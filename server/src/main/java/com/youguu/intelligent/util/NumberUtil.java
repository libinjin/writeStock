package com.youguu.intelligent.util;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.List;

/**
 * 此工具类用来准确计算价格等浮点数据.
 * 工具类的使用前提是当且仅当调用上下文情况判断来决定是否使用此工具类，
 * 当涉及到循环及其他大规模计算时，需要在自行实现BigDecimal包装浮点数并计算结果，不建议使用此
 * 类，具体需要根据实际情况决定.
 * @author hucy 2008-3-25 10:20:49
 * @author iceline
 */
public class NumberUtil {

	private static final int DEF_DIV_SCALE = 10;


	private static final BigDecimal ONE = new BigDecimal("1");

	/**
	 * f * scale 后进行4舍5入 取得整数
	 * Warnning ! Possible lost part of number values;
	 * @param f
	 * @param scale
	 * @return
	 */
	public static int float2Int(float f , int  scale){
		return  Math.round(f*scale);
	}

	/**
	 * d * scale 后进行4舍5入 取得整数
	 * 
	 * @param f
	 * @param scale
	 * @return
	 */
	public final static long double2Long(double d , int  scale){
		//return  (long)(d*scale+0.5);
		return  d>=0?(long)(d*scale+0.5):(long)(d*scale-0.5);
	}

	/**
	 * d 进行4舍5入 取得整数
	 * 
	 * @param f
	 * @param scale
	 * @return
	 */
	public final static long double2Long(double d){
		//return  (long)(d+0.5);
		return  d>=0?(long)(d+0.5):(long)(d-0.5);
	}
	/**
	 * d * scale 后进行4舍5入 取得整数
	 * 
	 * @param f
	 * @param scale
	 * @return
	 */
	public final static int double2Int(double d , int  scale){
		return  d>=0?(int)(d*scale+0.5):(int)(d*scale-0.5);
	}

	/**
	 * 比较精确到 0.00001. 在行情服务中仅用于价格
	 * Warnning ! Possible lost part of number values;
	 * @param d1
	 * @param d2
	 * @return
	 */
	public static boolean doubleEqual(double d1, double d2) {
		return Math.abs(d1 - d2) < 0.00001;
	}
	
	public static boolean doubleGraterEqual(double d1, double d2) {
		return d1 - d2 > -0.00001;
	}
	
	public static boolean doubleGreater(double d1, double d2) {
		return d1 - d2 > 0.00001;
	}
	
	public static boolean doubleLess(double d1, double d2) {
		return d1 - d2 < -0.00001;
	}
	
	public static boolean doubleLessEqual(double d1, double d2) {
		return d1 - d2 < 0.00001;
	}	

	/**
	 * 比较精确到 0.00001.
	 * 
	 * @param f1
	 * @param f2
	 * @return
	 */
	public static boolean isZero(double d1) {
		return d1 >= -(1e-6) && d1 <= 1e-6;
	}
	
	/**
	 * 比较浮点数的值
	 * @param d1
	 * @param d2
	 * @return
	 */
	public static int compDouble(double d1 ,double d2){
		double dif = d1 -d2;
		if( dif < -(1e-5) ){
			return -1;
		}else if( dif > 1e-5){
			return 1;
		}else{
			return 0;
		}
	}
	
	/**
	 * 比较浮点数的值
	 * @param d1
	 * @param d2
	 * @return
	 */
	public final static int compLong(long d1 ,long d2){
		long dif = d1 -d2;
		if( dif < 0 ){
			return -1;
		}else if( dif > 0){
			return 1;
		}else{
			return 0;
		}
	}
	
	/**
	 * 比较浮点数的值
	 * @param d1
	 * @param d2
	 * @return
	 */
	public final static int compInt(int d1 ,int d2){
		int dif = d1 -d2;
		if( dif < 0 ){
			return -1;
		}else if( dif > 0){
			return 1;
		}else{
			return 0;
		}
	}
	
	
	/**
	 * 提供精确的小数位四舍五入处理.
	 * 
	 * @param v
	 *            需要四舍五入的数字
	 * @param scale
	 *            小数点后保留几位
	 * @return 四舍五入后的结果
	 */
	public static double round(double v, int scale) {
		if (scale < 0) {
			throw new IllegalArgumentException("The scale must be a positive integer or zero");
		}
		BigDecimal b = new BigDecimal(Double.toString(v));
		return b.divide(ONE, scale, BigDecimal.ROUND_HALF_UP).doubleValue();
	}

	/**
	 * 两个Double数相加
	 * 
	 * @param v1
	 * @param v2
	 * @return Double
	 */
	public static Double add(double v1, double v2) {
		BigDecimal b1 = new BigDecimal(Double.toString(v1));
		BigDecimal b2 = new BigDecimal(Double.toString(v2));
		return b1.add(b2).doubleValue();
	}

	/**
	 * 两个Double数相减
	 * 
	 * @param v1
	 * @param v2
	 * @return Double
	 */
	public static Double sub(double v1, double v2) {
		BigDecimal b1 = new BigDecimal(Double.toString(v1));
		BigDecimal b2 = new BigDecimal(Double.toString(v2));
		return b1.subtract(b2).doubleValue();
	}

	/**
	 * 两个Double数相乘
	 * 
	 * @param v1
	 * @param v2
	 * @return Double
	 */
	public static Double mul(double v1, double v2) {
		BigDecimal b1 = new BigDecimal(Double.toString(v1));
		BigDecimal b2 = new BigDecimal(Double.toString(v2));
		return b1.multiply(b2).doubleValue();
	}

	/**
	 * 两个Double数相除
	 * 
	 * @param v1
	 * @param v2
	 * @return Double
	 */
	public static Double div(double v1, double v2) {
		BigDecimal b1 = new BigDecimal(Double.toString(v1));
		BigDecimal b2 = new BigDecimal(Double.toString(v2));
		return b1.divide(b2, DEF_DIV_SCALE, BigDecimal.ROUND_HALF_UP).doubleValue();
	}

	public static Double longDiv(long v1, long v2){
		BigDecimal b1 = new BigDecimal(Long.toString(v1));
		BigDecimal b2 = new BigDecimal(Long.toString(v2));
		return b1.divide(b2, DEF_DIV_SCALE, BigDecimal.ROUND_HALF_UP).doubleValue();
	}

	/**
	 * 两个Double数相除，并保留scale位小数
	 * 
	 * @param v1
	 * @param v2
	 * @param scale
	 * @return Double
	 */
	public static Double div(double v1, double v2, int scale) {
		if (scale < 0) {
			throw new IllegalArgumentException("The scale must be a positive integer or zero");
		}
		BigDecimal b1 = new BigDecimal(Double.toString(v1));
		BigDecimal b2 = new BigDecimal(Double.toString(v2));
		return b1.divide(b2, scale, BigDecimal.ROUND_HALF_UP).doubleValue();
	}

	/**
	 * 计算EMA
	 * @param preEMA
	 * @param x
	 * @param cycle
	 * @return
	 */
	public static double calcEMA(double preEMA,double x,int cycle){
		if(preEMA==0)return x;
		double y=(2*x+(cycle-1)*preEMA)/(cycle+1);
		return y;
	}
	
	public static double calcMA(List<Double> beforeXList, double x, int cycle){
		double sum=0;
		int n=0;
		for(int i=beforeXList.size()-1;i>=0;i--){
			sum += beforeXList.get(i);
			n++;
			if(n>=cycle-1)break;
		}
		sum +=x;
		n++;
		double y=sum/n;
		return y;
	}
	
	
	
	/**
	 * 保存小数点后 scale位
	 * @param data
	 * @param scale
	 * @return
	 */
	public static String getFormatDouble(Double data, int scale) {
		StringBuffer format = new StringBuffer("0.");
		if(scale < 0){
			throw new IllegalArgumentException("The scale must be a positive integer or zero");
		}else{
			for(int i=0;i<scale;i++){
				format.append("0");
			}
		} 
		if (data == null) {
			return "";
		} else {
			DecimalFormat df = new DecimalFormat(format.toString());
			return df.format(data);
		}
	}

	/**
	 * double 转换为 float
	 * 
	 * @param v1
	 * @return float
	 */
	public static float double2Float(double v1) {
		String s1 = String.valueOf(v1);
		Float f1 = Float.valueOf(s1);
		return f1.floatValue();
	}

	/**
	 * long 转换为 int
	 * 
	 * @param v1
	 * @return int
	 */
	public static int long2Int(long v1) {
		String s1 = String.valueOf(v1);
		Integer f1 = Integer.parseInt(s1);
		return f1.intValue();
	}



}
