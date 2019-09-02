package com.youguu.intelligent.dao;

import com.youguu.intelligent.pojo.First;
import com.youguu.intelligent.pojo.Second;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository("secondDao")
public class SecondDao extends GangAoDAOBase<Second>{

    //根据
    public List<Second> querSecondList(String endDate, int reportType){
        Map<String, Object> map = new HashMap<>();
        map.put("endDate", endDate);
        map.put("reportType", reportType);
        return findBy("getSecondList", map);
    }
}
