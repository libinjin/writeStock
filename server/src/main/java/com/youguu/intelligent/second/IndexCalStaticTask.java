package com.youguu.intelligent.second;

import com.youguu.intelligent.dao.IIntelligentStockDAO;
import com.youguu.intelligent.pojo.CommonKlinePoint;
import com.youguu.intelligent.second.excel.ExcelImpl;
import com.youguu.intelligent.second.excel.Market;
import com.youguu.intelligent.sevice.QuoteService;
import com.youguu.intelligent.sevice.WriteService;
import com.youguu.intelligent.util.XRDRKlineUtil;
import com.youguu.intelligent.xrdr.StocksCollector;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by lenovo on 2019/8/14.
 * 通过读取K线文件 生成技术指标所有数据 写入文件
 */
@Service("indexCalStaticTask")
public class IndexCalStaticTask {

    private static final String file = "E:/data/writeStock/market2019.xlsx";
    @Resource
    private IIntelligentStockDAO intelligentStockDAO;

    @Resource
    private QuoteService quoteService;

    @Resource
    private ExcelImpl excel;

    public void generateIndexFile() {

        try {
            //1.从数据库加载3000多只股票
            List<String> stockCodeList = intelligentStockDAO.queryAllStock();

            //加载除权除息数据
            StocksCollector.getXRDRInfos(stockCodeList);

            TotalMap totalMap = new TotalMap();

            int i = 0;
            List<CommonKlinePoint> day251List = new ArrayList<>();
            for (String stockCode : stockCodeList) {

                day251List = XRDRKlineUtil.getKlineByCount(stockCode , 251);

                System.out.println("当前list："+(i++));
                //1.近30个交易日的涨跌幅
                new ChangeCal(stockCode, day251List, totalMap);
                //近十日成交量

                new VolumnCal(stockCode, day251List, totalMap);

                //布林线的下轨
                new BOLLStock(stockCode, day251List, totalMap);
            }
            String date = day251List.get(0).getDate()+"";
            //根据加载涨跌幅，加载行业排名
            loadMarketRank(totalMap);

            WriteService writeService = new WriteService("");

            writeService.genSeond("E:/gen/changPercnet.xls", totalMap);
            writeService.genSeond("E:/gen/volumn.xls", totalMap);
            writeService.genSeond("E:/gen/Boll.xls", totalMap);
            writeService.genSeond("E:/gen/marketRank.xls", totalMap);


        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void loadMarketRank(TotalMap totalMap) {

        Map<String, List<ChangePer>> map = totalMap.getChangePercentMap();

        //当天所有的股票涨跌幅
        List<ChangePer> changePerList = new ArrayList<>();
        for (Map.Entry<String ,List<ChangePer>> entry : map.entrySet()) {
            List<ChangePer> change = entry.getValue();
            changePerList.add(change.get(0));
        }

        // <股票名称, 行业名称>
        Map<String, String> induMap = new HashMap<>();
        List<Market> marketList = excel.transXss(file);
        for (Market market : marketList) {

            String stockCode = market.getStockCode();
            String indu = market.getFirstSort();
            induMap.put(stockCode, indu);
        }

        //<行业名称, List>
        Map<String, List<ChangePer>> listMap = new HashMap<>();
        //根据股票code，分多个List
        for (ChangePer changePer : changePerList) {
            String code = changePer.getStockCode();
            String indu = induMap.get(code);
            if(listMap.containsKey(indu)){
                listMap.get(indu).add(changePer);
            }else{

                List<ChangePer> changeList = new ArrayList<>();

                listMap.put(indu, changeList);
            }
        }

        for (Map.Entry<String ,List<ChangePer>> entry : listMap.entrySet()) {

            List<ChangePer> everyList = entry.getValue();

            Collections.sort(everyList, new Comparator<ChangePer>() {
                @Override
                public int compare(ChangePer o1, ChangePer o2) {
                    return o1.getChangePercent() >= o2.getChangePercent() ? -1 : 1;
                }
            });
        }

        for (Map.Entry<String ,List<ChangePer>> entry : listMap.entrySet()) {

            String market = entry.getKey();
            List<ChangePer> list = entry.getValue();
            for (int i = 0; i < list.size(); i++) {

                ChangePer changePer = list.get(i);

                String stockCode = changePer.getStockCode();

                double changePercent = changePer.getChangePercent();

                MarkertPer markertPer = new MarkertPer(i+1, market, changePercent);

                totalMap.getMarketMap().put(stockCode, markertPer);
            }
        }

    }



}
