package com.youguu.intelligent.dao;


import com.youguu.intelligent.pojo.IntelligentStock;

import java.util.List;

/**
 * Created by lenovo on 2019/8/14.
 */
public interface IIntelligentStockDAO {

    /**
     * 查询所有股票的静态数据
     * @return
     */
    List<IntelligentStock> queryAllStockList();


    /**
     * 查询所有股票代码
     * @return
     */
    List<String> queryAllStock();
}


