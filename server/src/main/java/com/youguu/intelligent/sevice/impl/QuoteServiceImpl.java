package com.youguu.intelligent.sevice.impl;

import com.youguu.intelligent.sevice.QuoteService;
import com.youguu.quote.pojo.IndustryCode;
import com.youguu.quote.rpc.client.QuoteClient;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Service("quoteService")
public class QuoteServiceImpl implements QuoteService {


    @Override
    public Map<String, String> getIndustryMap(int type) {

        Map<String, String> map = new HashMap();

        List<IndustryCode> industryCodeList = QuoteClient.getIndustryByCode(type);

        if(industryCodeList==null||industryCodeList.size()<=0){
            return map;
        }

        for(IndustryCode industryCode : industryCodeList){
            String stockCode = industryCode.getStockCode().substring(2);

            String induCode = industryCode.getInduCode();
            if(!map.containsKey(stockCode)){
                map.put(stockCode, induCode);
            }
        }
        return map;
    }

}
