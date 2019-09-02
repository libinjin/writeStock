package com.youguu.intelligent.dao;

import com.youguu.intelligent.pojo.First;
import com.youguu.intelligent.pojo.Fiveth;
import com.youguu.intelligent.pojo.Sixth;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class SixDao extends GangAoDAOBase<Sixth>{

    //根据
    public List<Sixth> querySix(String endDate, int reportType){
        Map<String, Object> map = new HashMap<>();
        map.put("endDate", endDate);
        map.put("reportType", reportType);
        return findBy("getSixList", map);
    }

    public Sixth querySixByCode(Long ComCode, String endDate, int reportType){
        Map<String, Object> map = new HashMap<>();
        map.put("ComCode", ComCode);
        map.put("endDate", endDate);
        map.put("reportType", reportType);
        return findUniqueBy("selectSixByCode", map);
    }
}
