package com.youguu.intelligent.second;


import com.youguu.intelligent.pojo.CommonKlinePoint;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BOLLStock {

    private String stockCode;
    private List<CommonKlinePoint> day251List = new ArrayList<>();
    private TotalMap totalMap ;

    public BOLLStock(String stockCode, List<CommonKlinePoint> klist, TotalMap totalMap) {
        this.stockCode = stockCode;
        day251List.addAll(klist);
        this.totalMap = totalMap;
        this.calculate();
    }


    public void calculate(){

        BOLL boll = new BOLL(day251List);

        List<BOLLPoint> pointList = boll.getPointList();

        Collections.reverse(pointList);

        BOLLPoint bollPoint = pointList.get(0);

        totalMap.getBollPointMap().put(stockCode, bollPoint);
    }




}
