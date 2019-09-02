package com.youguu.intelligent.sevice;

import com.youguu.intelligent.dao.FirstDao;
import com.youguu.intelligent.dao.FiveDao;
import com.youguu.intelligent.dao.FourDao;
import com.youguu.intelligent.dao.SecondDao;
import com.youguu.intelligent.dao.ShNumDao;
import com.youguu.intelligent.dao.SixDao;
import com.youguu.intelligent.dao.ThirdDao;
import com.youguu.intelligent.moudle.gangao.GangAoDAO;
import com.youguu.intelligent.pojo.First;
import com.youguu.intelligent.pojo.Fiveth;
import com.youguu.intelligent.pojo.Fourth;
import com.youguu.intelligent.pojo.Second;
import com.youguu.intelligent.pojo.Sixth;
import com.youguu.intelligent.pojo.StkBasicinfo;
import com.youguu.intelligent.pojo.Third;
import com.youguu.intelligent.pojo.TotalField;
import com.youguu.intelligent.pojo.TotalNum;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class TotalService {

    @Resource
    private GangAoDAO gangAoDAO;

    @Resource
    private FirstDao firstDao;

    @Resource
    private SecondDao secondDao;

    @Resource
    private ThirdDao thirdDao;

    @Resource
    private FourDao fourDao;

    @Resource
    private FiveDao fiveDao;

    @Resource
    private SixDao sixDao;

    @Resource
    private ShNumDao shNumDao;

    private String endDate;

    private int reportType;

    /**
     * （2019中报、2019一季报、2018年报、2018三季报、2018中报）
     */

    //endDate 2018-12-31  reportType 12 年报
    public Map<Long, TotalField> putTogether(String endDate, int reportType){

        //查询所有公司的comCode
        List<StkBasicinfo> list = gangAoDAO.selectStocInner();

        List<First> firstList = firstDao.querFirstList(endDate, reportType);

        List<Second> secondList = secondDao.querSecondList(endDate, reportType);

        List<Third> thirdList = thirdDao.queryThird(endDate, reportType);

        List<Fourth> fourthList = fourDao.queryFour(endDate, reportType);

        List<Fiveth> fivethList = fiveDao.queryFive(endDate, reportType);

        List<Sixth> sixthList = sixDao.querySix(endDate, reportType);

        List<TotalNum> totalNumList = shNumDao.queruTotalNum(endDate);

        System.out.println("查询完成");

        Map<Long, TotalField> map = new HashMap<>();

        for (StkBasicinfo stkBasicinfo : list) {
            TotalField totalField = new TotalField();
            Long comcode = stkBasicinfo.getComcode();
            totalField.setComcode(comcode);
            totalField.setStockName(stkBasicinfo.getSecuabbr());
            totalField.setStockCode(stkBasicinfo.getTradingcode());
            map.put(comcode, totalField);
        }

        for (First first : firstList) {
            Long comCode = first.getComcode();
            if(map.containsKey(comCode)){
                TotalField totalField = map.get(comCode);
                totalField.setNetprofit(first.getNetprofit());
                totalField.setOperrevenue(first.getOperrevenue());
            }
        }

        for (Second second : secondList) {
            Long comCode = second.getComcode();
            if(map.containsKey(comCode)){
                TotalField totalField = map.get(comCode);
                totalField.setNetcashflowoper(second.getNetcashflowoper());
            }
        }

        for (Third third : thirdList) {
            Long comCode = third.getComcode();
            if(map.containsKey(comCode)){
                TotalField totalField = map.get(comCode);
                totalField.setRoe(third.getRoe());
            }
        }


        for (Fourth fourth : fourthList) {
            Long comCode = fourth.getComcode();
            if(map.containsKey(comCode)){
                TotalField totalField = map.get(comCode);
                totalField.setRoa(fourth.getRoa());
                totalField.setTltota(fourth.getTltota());
                totalField.setCurrentratio(fourth.getCurrentratio());
                totalField.setGrossprofitmargin(fourth.getGrossprofitmargin());
                totalField.setTotalassetturnover(fourth.getTotalassetturnover());
            }
        }

        for (Fiveth fiveth : fivethList) {
            Long comCode = fiveth.getComcode();
            if(map.containsKey(comCode)){
                TotalField totalField = map.get(comCode);
                totalField.setTotalshare(fiveth.getTotalshare());
                totalField.setTotalasset(fiveth.getTotalasset());
            }
        }

        for (Sixth sixth : sixthList) {
            Long comCode = sixth.getComcode();
            if(map.containsKey(comCode)){
                TotalField totalField = map.get(comCode);
                totalField.setTotalliab(sixth.getTotalliab());
                totalField.setTotalnoncurliab(sixth.getTotalnoncurliab());
            }
        }

        for (TotalNum totalNum : totalNumList) {
            Long comCode = totalNum.getComcode();
            if(map.containsKey(comCode)){
                TotalField totalField = map.get(comCode);
                totalField.setTotalSh(totalNum.getTotalSh());
                totalField.setEnddate(totalNum.getEnddate());
            }
        }
        return map;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public int getReportType() {
        return reportType;
    }

    public void setReportType(int reportType) {
        this.reportType = reportType;
    }
}
