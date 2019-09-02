package com.youguu.intelligent.dao;

import com.youguu.intelligent.pojo.First;
import com.youguu.intelligent.pojo.Third;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class ThirdDao extends GangAoDAOBase<Third>{

    //根据
    public List<Third> queryThird(String endDate, int reportType){
        Map<String, Object> map = new HashMap<>();
        map.put("endDate", endDate);
        map.put("reportType", reportType);
        return findBy("getThirdList", map);
    }
}
