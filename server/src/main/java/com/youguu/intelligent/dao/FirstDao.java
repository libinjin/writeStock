package com.youguu.intelligent.dao;

import com.youguu.intelligent.pojo.First;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository("firstDao")
public class FirstDao extends GangAoDAOBase<First>{

    //根据
    public List<First> queryFirst(String ComCode, String endDate, int reportType){
        Map<String, Object> map = new HashMap<>();
        map.put("ComCode", ComCode);
        map.put("endDate", endDate);
        map.put("reportType", reportType);
        return findBy("selectByFirst", map);
    }


    public List<First> querFirstList(String endDate, int reportType){
        Map<String, Object> map = new HashMap<>();
        map.put("endDate", endDate);
        map.put("reportType", reportType);
        return findBy("getFirstListByCode", map);
    }
}
