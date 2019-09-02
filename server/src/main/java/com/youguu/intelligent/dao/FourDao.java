package com.youguu.intelligent.dao;

import com.youguu.intelligent.pojo.First;
import com.youguu.intelligent.pojo.Fiveth;
import com.youguu.intelligent.pojo.Fourth;
import com.youguu.intelligent.pojo.Third;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class FourDao extends GangAoDAOBase<Fourth>{

    //根据
    public List<Fourth> queryFour(String endDate, int reportType){
        Map<String, Object> map = new HashMap<>();
        map.put("endDate", endDate);
        map.put("reportType", reportType);
        return findBy("getFourList", map);
    }

    public Fourth queryFourByCode(Long ComCode, String endDate, int reportType){
        Map<String, Object> map = new HashMap<>();
        map.put("ComCode", ComCode);
        map.put("endDate", endDate);
        map.put("reportType", reportType);
        return findUniqueBy("selectFourByCode", map);
    }
}
