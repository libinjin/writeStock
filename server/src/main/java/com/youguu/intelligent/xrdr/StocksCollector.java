package com.youguu.intelligent.xrdr;

import com.youguu.core.logging.Log;
import com.youguu.core.logging.LogFactory;
import com.youguu.intelligent.util.QuoteUtil;

import java.util.List;


public class StocksCollector {
	private static Log logger  = LogFactory.getLog(StocksCollector.class);
	
//	private static String quoteURL = ZkPropertiesHelper.getCacheAndWatchProperties("quote", true).getProperty("quoteURL");
//	
//	private static long boardid = Long.parseLong(ZkPropertiesHelper.getCacheAndWatchProperties("quote", true).getProperty("boardid"));
	

	

	
	public static void getXRDRInfos(List<String> stocks) {

		logger.info("begin to getXRDRInfo......");

		QuoteZookeeperConfig quotezkconfig = new QuoteZookeeperConfig();

		String quoteURL = quotezkconfig.getQuoteURL();

		for(String stockCode : stocks){

			int marketid = QuoteUtil.getMarketIdByStock(stockCode);

			if(stockCode.equals("300429")){
				logger.info("------------------");
			}
			XRDRCollector.getXrdrInfo(quoteURL, stockCode, marketid);
		}
		logger.info("getXRDRInfo end......");
		
	}

	

}
