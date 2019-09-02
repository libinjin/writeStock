package com.youguu.intelligent.dao;

import com.youguu.intelligent.pojo.TotalNum;
import org.springframework.stereotype.Repository;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository("shNumDao")
public class ShNumDao extends GangAoDAOBase<TotalNum>{

    //查询股东数量
    public List<TotalNum> queruTotalNum(String endDate){
        Map<String, Object> map = new HashMap<>();
        map.put("endDate", endDate);
        return findBy("getTotalNumList", map);
    }
}
