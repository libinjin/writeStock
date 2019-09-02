package com.youguu.intelligent.moudle.gangao;

import com.youguu.intelligent.pojo.StkBasicinfo;

import java.util.List;

public interface GangAoDAO {


    List<StkBasicinfo> selectAll();

    StkBasicinfo selectStockByCode(String stockCode);

    List<StkBasicinfo> selectStocInner();
}
