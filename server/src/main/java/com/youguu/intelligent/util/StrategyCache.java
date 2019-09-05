package com.youguu.intelligent.util;

import com.youguu.core.logging.Log;
import com.youguu.core.logging.LogFactory;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

@Service("strategyCache")
public class StrategyCache {
	
	private static Log logger = LogFactory.getLog(StrategyCache.class);
	
	
	/**
	 * 所有策略设计到的股票代码
	 */
	public static Set<String> stockCodeSet = new HashSet<String>();
	
	/**
	 * 存储每个股票 一段时间的最高最低价
	 */
	public static Map<String, Double> stockNMMap = new ConcurrentHashMap<String,Double>();
	

	/**
	 * 存储股票的向前除复权因子信息
	 */
	public static Map<String,Map<Long,String>> stocksXRDR = new ConcurrentHashMap<>();
	
	/**
	 * 存储股票的MA(CLOSE,90)
	 * 
	 */
	public static Map<String,Double> stocksMA90 = new ConcurrentHashMap<>();

	/**
	 * 存储股票的MA(CLOSE,250)
	 *
	 */
	public static Map<String,Double> stocksMA = new ConcurrentHashMap<>();


	

}
