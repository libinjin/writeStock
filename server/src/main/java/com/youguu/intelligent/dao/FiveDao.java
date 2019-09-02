package com.youguu.intelligent.dao;

import com.youguu.intelligent.pojo.First;
import com.youguu.intelligent.pojo.Fiveth;
import com.youguu.intelligent.pojo.Fourth;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class FiveDao extends GangAoDAOBase<Fiveth>{

    //根据
    public List<Fiveth> queryFive(String endDate, int reportType){
        Map<String, Object> map = new HashMap<>();
        map.put("endDate", endDate);
        map.put("reportType", reportType);
        return findBy("getFiveList", map);
    }

    public Fiveth queryFirst(String ComCode, String endDate, int reportType){
        Map<String, Object> map = new HashMap<>();
        map.put("ComCode", ComCode);
        map.put("endDate", endDate);
        map.put("reportType", reportType);
        return findUniqueBy("selectFourByCode", map);
    }
}
