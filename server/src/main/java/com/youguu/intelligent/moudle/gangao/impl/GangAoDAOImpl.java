package com.youguu.intelligent.moudle.gangao.impl;

import com.youguu.intelligent.moudle.gangao.GangAoDAO;
import com.youguu.intelligent.moudle.gangao.GangAoDAOBase;
import com.youguu.intelligent.pojo.StkBasicinfo;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository("gangAoDAO")
public class GangAoDAOImpl extends GangAoDAOBase<StkBasicinfo> implements GangAoDAO {


    @Override
    public List<StkBasicinfo> selectAll() {

        return findBy("selectfindAllStock", null);
    }

    @Override
    public StkBasicinfo selectStockByCode(String stockCode) {
        Map<String, Object> map = new HashMap<>();
        map.put("stockCode", stockCode);
        return findUniqueBy("selectStockByCode", map);

    }

    @Override
    public List<StkBasicinfo> selectStocInner() {
        return findBy("selectStocInner", null);
    }


}
