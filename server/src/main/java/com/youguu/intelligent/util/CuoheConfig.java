package com.youguu.intelligent.util;

import com.youguu.core.util.PropertiesUtil;

import java.util.Properties;

/**
 * 
 * 
 * @author junwei.song
 * @version 2012-3-28
 */
public class CuoheConfig {
	public static Properties prop = null;
/*	static{
		prop = PropertiesUtil.getProperties("properties/cuohe_config.properties", "UTF-8");
	}*/
	
	public static String getProperty(String key) {
		return prop.getProperty(key);
	}
}
