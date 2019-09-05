package com.youguu.intelligent.dao;

import com.youguu.intelligent.pojo.IntelligentStock;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by lenovo on 2019/8/14.
 */
@Repository("intelligentStockDAO")
public class IntelligentStockDAOImpl extends GangAoDAOBase<IntelligentStock> implements IIntelligentStockDAO {


    @Override
    public List<IntelligentStock> queryAllStockList() {
        return findBy("findAllStock", null);
    }

    @Override
    public List<String> queryAllStock() {
        return findBy("selectAllStockCode", null);
    }


}
