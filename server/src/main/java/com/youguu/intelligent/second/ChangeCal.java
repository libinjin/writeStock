package com.youguu.intelligent.second;

import com.youguu.intelligent.pojo.CommonKlinePoint;
import com.youguu.intelligent.util.NumberUtil;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ChangeCal {

    private String stockCode;
    private List<CommonKlinePoint> day251List = new ArrayList<>();
    private TotalMap totalMap ;

    public ChangeCal(String stockCode, List<CommonKlinePoint> klist, TotalMap totalMap) {

        this.stockCode = stockCode;
        day251List.addAll(klist);
        Collections.reverse(day251List);
        this.totalMap = totalMap;
        this.calculate();
    }


    //1.近30个交易日的涨跌幅
    public void calculate(){

        List<CommonKlinePoint> day31List = day251List.subList(0, 31);

        List<ChangePer> changePerList = new ArrayList<>();

        for (int i = 1; i < day31List.size(); i++) {

            long date = day31List.get(i-1).getDate();

            double cur = day31List.get(0).getCur();//cur

            double yesCur = day31List.get(i).getCur();//cur

            double changePercent =calChangePercent(cur, yesCur);

            ChangePer changePer = new ChangePer(stockCode, changePercent, date);

            changePerList.add(changePer);
        }
        totalMap.getChangePercentMap().put(stockCode, changePerList);
    }

    /**
     * 涨跌幅 = (今日收盘价-昨日收盘价)/昨日收盘价
     * @param curPrice
     * @param closePrice
     * @return
     */
    public  double calChangePercent(double curPrice, double closePrice){

        if(curPrice == 0 || closePrice == 0){
            return 0;
        }
        double changePercent = (curPrice-closePrice)/closePrice;
        return NumberUtil.round(changePercent, 4);
    }

}
