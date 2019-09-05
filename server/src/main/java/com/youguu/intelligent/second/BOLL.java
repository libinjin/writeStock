/**  
* @Title: BOLL.java
* @Package com.youguu.quote.market
* @Description: TODO(用一句话描述该文件做什么)
* @author TangYanhong
* @date 2014年5月20日 上午10:16:02
* @version V1.0  
*/
 
package com.youguu.intelligent.second;


import com.youguu.intelligent.pojo.CommonKlinePoint;
import com.youguu.intelligent.util.Util;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName: BOLL
 * @Description: TODO(这里用一句话描述这个方法的作用)
 * @author TangYanhong
 * @date 2014年5月20日 上午10:16:02
 * 
 */
public class BOLL {
	/**
	 * K线数据
	 */
	private List<CommonKlinePoint> klineList;

	/**
	 * 计算开始位置
	 */
	private int startPoint = 0;

	/**
	 * 默认周期
	 */
	private static final int DEFAULT_PERIOD = 20;

	/**
	 * 默认倍数
	 */
	private static final int DEFAULT_TIMES = 2;

	private int period;

	private int times;

	private List<BOLLPoint> pointList = new ArrayList<BOLLPoint>();

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public BOLL(List klineList) {
		super();
		this.klineList = klineList;
		this.period = DEFAULT_PERIOD;
		this.times = DEFAULT_TIMES;
		this.startPoint = 0;
		this.calculate();
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public BOLL(List klineList, int startPoint){
		this.period = DEFAULT_PERIOD;
		this.times = DEFAULT_TIMES;
		this.klineList = klineList;
		this.startPoint = startPoint;
		this.calculate();
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public BOLL(List klineList, int startPoint, int period, int times){
		this.period = period;
		this.times = times;
		this.klineList = klineList;
		this.startPoint = startPoint;
		this.calculate();
	}

	public List<BOLLPoint> getPointList() {
		return pointList;
	}

	private void calculate(){
		/*MID :  MA(CLOSE,N);
		UPPER: MID + P*STD(CLOSE,N);
		LOWER: MID - P*STD(CLOSE,N);*/
		if(klineList == null || klineList.size() == 0) return;
		List<Double> maList = calcMA(this.klineList,this.startPoint,this.period);
		List<Double> stdList = calcSTD(this.klineList,this.startPoint,this.period,maList);
		for(int i=this.startPoint;i<klineList.size();i++){
			long date = klineList.get(i).getDate();
			if(i<this.period-1){
				BOLLPoint boll = new BOLLPoint(null,null,null,date);
				pointList.add(boll);
				continue;
			}
			double mid = Util.roundUp(maList.get(i-this.startPoint));
			double upper = Util.roundUp((double)(mid + this.times * stdList.get(i-this.startPoint)));
			double lower = Util.roundUp((double)(mid - this.times * stdList.get(i-this.startPoint)));

			BOLLPoint boll = new BOLLPoint(mid,upper,lower,date);
			pointList.add(boll);
		}

	}

	private List<Double> calcMA(List<CommonKlinePoint> klineList, int start, int period){
		List<Double> maList = new ArrayList<Double>();
		for(int i=start;i<klineList.size();i++){
			int from = i-period+1;
			if(from<0)from=0;
			int count=0;
			double sum=0;
			for(int k=from;k<=i;k++){
				sum = sum + klineList.get(k).getCur();
				count++;
			}
			double ma = sum/(count);
			maList.add(ma);
		}

		return maList;
	}

	private List<Double> calcSTD(List<CommonKlinePoint> klineList, int start, int period, List<Double> maList){
		List<Double> stdList = new ArrayList<Double>();
		
		for(int i=start;i<klineList.size();i++){
			double ma = maList.get(i-start);
			int from = i-period+1;
			if(from<0)from=0;
			int count=0;
			double sum = 0;
			for(int k=from;k<=i;k++){
				double close = klineList.get(k).getCur();
				sum = sum + (close - ma) * (close - ma);
				count++;
			}
			double std =count==1?0:Math.sqrt(sum/(count-1));
			stdList.add(std);
		}
		
		return stdList;
	}
	
}
