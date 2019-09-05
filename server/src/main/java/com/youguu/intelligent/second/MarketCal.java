package com.youguu.intelligent.second;

import com.youguu.intelligent.pojo.CommonKlinePoint;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MarketCal {

    private String stockCode;
    private List<CommonKlinePoint> day251List = new ArrayList<>();
    private TotalMap totalMap ;

    public MarketCal(String stockCode, List<CommonKlinePoint> day251List, TotalMap totalMap) {

        this.stockCode = stockCode;
        day251List.addAll(day251List);
        Collections.reverse(day251List);
        this.totalMap = totalMap;
        this.calculate();
    }


    public void calculate(){


    }
}
