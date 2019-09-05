package com.youguu.intelligent.second;

import com.youguu.intelligent.pojo.CommonKlinePoint;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class VolumnCal {

    private String stockCode;
    private List<CommonKlinePoint> day251List = new ArrayList<>();
    private TotalMap totalMap ;

    public VolumnCal(String stockCode, List<CommonKlinePoint> klist, TotalMap totalMap) {

        this.stockCode = stockCode;
        day251List.addAll(klist);
        Collections.reverse(day251List);
        this.totalMap = totalMap;
        this.calculate();
    }

    //近十日成交量
    public void calculate(){

        day251List = day251List.subList(0, 10);

        List<VolumnPer> volumnPerList = new ArrayList<>();

        for (int i = 0; i < day251List.size(); i++) {

            long date = day251List.get(i).getDate();

            long volume = day251List.get(i).getVolume();//cur

            VolumnPer volumnPer = new VolumnPer(volume, date);

            volumnPerList.add(volumnPer);
        }
        totalMap.getVolumeMap().put(stockCode, volumnPerList);
    }

}
