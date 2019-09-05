package com.youguu.intelligent.util;
/**
 * 
* @Title: Util.java 
* @Package com.youguu.quote.market
* @Description: 辅助计算
* @author wangd
* @date 2014年2月12日 下午2:27:52 
* @version V1.0
 */
public class Util {
	/**
	 * 四舍五入保留两位小数点
	 * @param value
	 * @return
	 */
	public static double roundUp(double value){
		return (Math.floor((value*100 + 0.5)))/100;
	}
	
	
	public static double roundUp_3(double value){
		return (Math.floor((value*1000 + 0.5)))/1000;
	}
}
