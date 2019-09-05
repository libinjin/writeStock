package com.youguu.intelligent.sevice;

import java.util.Map;
import java.util.Set;

public interface QuoteService {


    /**
     * 查询行业及概念
     * @param type
     * @return
     */
    Map<String, String> getIndustryMap(int type);

}
