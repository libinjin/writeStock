package com.youguu.intelligent.util;


import com.youguu.intelligent.pojo.CommonKlinePoint;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;


public class XRDRKlineUtil {


	public static List<CommonKlinePoint> calForWardKLine(List<CommonKlinePoint> klList,
                                                         Map<Long, String> forwardXRDR, byte klineType, String stockcode, int marketid, int priceScale) {

		//将除复权因子从最早到最晚排序（从20120301  到 20120323）
		List<CommonKlinePoint> kLinePoints = new ArrayList<CommonKlinePoint>();
		forwardXRDR = sortMapByKey(forwardXRDR);
		CommonKlinePoint comStart = (CommonKlinePoint) klList.get(0);
		CommonKlinePoint comEnd = (CommonKlinePoint) klList.get(klList.size()-1);
		List<Long> dateList = new ArrayList<Long>(forwardXRDR.keySet());
		if(dateList.size() == 0){
			return klList;
		}

		if(comStart.getDate()>dateList.get(dateList.size()-1)) //如果查询的K线在最晚除复权日期之后 则直接返回
			return klList;
		else if(comEnd.getDate()<dateList.get(0)){//如果查询的K线日期均在除权除息最早日期之前，则除复权因子一致
			String xrdr = forwardXRDR.get(dateList.get(0));
			for(int i=0;i<klList.size();i++){
				CommonKlinePoint com = calKlinePoints((CommonKlinePoint) klList.get(i),xrdr,priceScale);
				kLinePoints.add(com);
			}
			return kLinePoints;
		}else {
			Iterator<Long> dateSetIt = forwardXRDR.keySet().iterator();
			int i=0;
			while(dateSetIt.hasNext()){
				Long date = dateSetIt.next();
				String xrdr = forwardXRDR.get(date);
				for(;i<klList.size();i++){
					if(i==0&&((CommonKlinePoint)klList.get(i)).getDate()>=date){
						if(klineType == 0x21 ){
							break;
						}else if(klineType == 0x27 || klineType == 0x28){
//							kLinePoints.add(calForwardMoreDayKlinePoint((CommonKlinePoint)klList.get(i),stockcode,date, forwardXRDR,marketQuery,priceScale,klineType));
//							i++;
							break;
						}else{
							break;
						}
					}else if(i==0&&((CommonKlinePoint)klList.get(i)).getDate()<date){
						if(klineType == 0x21){
							kLinePoints.add(calKlinePoints((CommonKlinePoint)klList.get(i), xrdr, priceScale));
						}else if(klineType != 0x21){
							kLinePoints.add(calKlinePoints((CommonKlinePoint)klList.get(i), xrdr, priceScale));
						}
					}else if(i!=0&&((CommonKlinePoint)klList.get(i)).getDate()>=date&&((CommonKlinePoint)klList.get(i-1)).getDate()<date){
						if(klineType == 0x21){
							break;
						}else if(klineType == 0x27 || klineType == 0x28){
							kLinePoints.add(calForwardMoreDayKlinePoint((CommonKlinePoint)klList.get(i),stockcode,marketid,date, forwardXRDR, priceScale,klineType));
							i++;
							break;
						}else{ //分钟K线
							break;
						}
					}else{
//						if(klineType == 0x21)
						kLinePoints.add(calKlinePoints((CommonKlinePoint)klList.get(i), xrdr,priceScale));
//						else if(klineType == 0x27)
//							kLinePoints.add(calForwardMoreDayKlinePoint((CommonKlinePoint)klList.get(i),stockcode,date, xrdr,marketQuery,priceScale,klineType));


					}
				}
				if(i==klList.size())
					break;
			}
			if(i<klList.size()){
				for(;i<klList.size();i++){
					kLinePoints.add(klList.get(i));
				}
			}
			/*for(BaseKlinePoint kli :klList){
				System.out.println("new com==="+kli);
			}*/
			return kLinePoints;
		}

	}


	private static CommonKlinePoint calForwardMoreDayKlinePoint(CommonKlinePoint comKline, String stockcode, int marketid, long xrdrDate, Map<Long, String> forwardXRDR, int priceScale, byte klineType) {
		String klinetypestr = null;
		if(klineType == 0x27){
			klinetypestr = "week";
		}else if(klineType == 0x28){
			klinetypestr = "month";
		}

		CommonKlinePoint comWeek = new CommonKlinePoint();

		List<CommonKlinePoint> klList=new ArrayList<CommonKlinePoint>();

		List<CommonKlinePoint> tmpklList=new ArrayList<CommonKlinePoint>();
		boolean getNotEnough=true;
		short length=2;
		//1.得到上周周K线点  2.根据上周K线点的日期 查询出 此周 每天的 K线点 3.对每天的K线点进行运算 得到新的周K线点

		while(getNotEnough){
			tmpklList = HisKlineReader.getKlineByCount(stockcode, marketid, klinetypestr, length);
			if(tmpklList.size()==0)break;
			if(((CommonKlinePoint)tmpklList.get(0)).getKeyDate()<comKline.getKeyDate())
				getNotEnough=false;
			length+=2;
		}
		//上周K线点 
		comWeek = (CommonKlinePoint) (((CommonKlinePoint)tmpklList.get(1)).getKeyDate()<comKline.getKeyDate()?tmpklList.get(1):tmpklList.get(0));

		if(comWeek.getDate()>=xrdrDate){//如果上周的时间在除权除息日 之后(包含)
			return comKline;
		}
		List<CommonKlinePoint> tmpklDAYList=new ArrayList<CommonKlinePoint>();
		getNotEnough = true;
		short len = 5;
		while(getNotEnough){
			tmpklDAYList = HisKlineReader.getKlineByCount(stockcode, marketid, "day", len);
			if(tmpklDAYList.size()==0)break;
			//如果 取得的K线点的 第一天的时间<上周K线点的时间 则停止循环 
			if(((CommonKlinePoint)tmpklDAYList.get(0)).getDate()<comWeek.getDate())
				getNotEnough=false;
			len+=5;
		}

		List<CommonKlinePoint> tempdayKlList=new ArrayList<CommonKlinePoint>();//周K线的每天K线
		for(CommonKlinePoint bkpoint:tmpklDAYList){
			final CommonKlinePoint kpoint = (CommonKlinePoint) bkpoint;
			if(kpoint.getDate()>comWeek.getDate()&&kpoint.getDate()<=comKline.getDate())
				tempdayKlList.add(kpoint);
			if(kpoint.getDate()>comKline.getDate())
				break;
		}

		List<CommonKlinePoint> dayKlList=new ArrayList<CommonKlinePoint>();
		Iterator<Long> dateSetIt = forwardXRDR.keySet().iterator();
		int i=0;
		while(dateSetIt.hasNext()){
			Long date = dateSetIt.next();
			String xrdr = forwardXRDR.get(date);
			for(;i<tempdayKlList.size();i++){
				CommonKlinePoint kpoint = (CommonKlinePoint) tempdayKlList.get(i);
				if(kpoint.getDate()>=date){
					break;
				}else{
					dayKlList.add(calKlinePoints((CommonKlinePoint)tempdayKlList.get(i), xrdr,priceScale));
				}

			}
			if(i==tempdayKlList.size())
				break;
		}
		if(i<tempdayKlList.size()){
			for(;i<tempdayKlList.size();i++){
				CommonKlinePoint kpoint = (CommonKlinePoint) tempdayKlList.get(i);
				dayKlList.add(kpoint);
			}
		}

		CommonKlinePoint comNEWKpoint = new CommonKlinePoint();
		double high = 0.0;
		double low = 300.0;
		for(int j=0;j<dayKlList.size();j++){
			CommonKlinePoint comnew = (CommonKlinePoint) dayKlList.get(j);
			high = comnew.getHigh()>high?comnew.getHigh():high;
			low = comnew.getLow()<low?comnew.getLow():low;
		}
		comNEWKpoint.setOpen(((CommonKlinePoint)dayKlList.get(0)).getOpen());
		comNEWKpoint.setHigh(high);
		comNEWKpoint.setLow(low);
		comNEWKpoint.setCur(((CommonKlinePoint)dayKlList.get(dayKlList.size()-1)).getCur());
		comNEWKpoint.setDate(comKline.getDate());
		comNEWKpoint.setKeyDate(comKline.getKeyDate());
		comNEWKpoint.setSum(comKline.getSum());
		comNEWKpoint.setSwap(comKline.getSwap());
		comNEWKpoint.setVolume(comKline.getVolume());
		comNEWKpoint.setVolume5PointAvg(comKline.getVolume5PointAvg());
		comNEWKpoint.setVolume10PointAvg(comKline.getVolume10PointAvg());
		return comNEWKpoint;

	}

	public static CommonKlinePoint calKlinePoints(CommonKlinePoint com, String xrdr, int priceScale) {
		// TODO Auto-generated method stub
		CommonKlinePoint com1 = new CommonKlinePoint();
		String[] xr = xrdr.split(",");
		Double x = Double.parseDouble(xr[0]);
		Double y = Double.parseDouble(xr[1]);
		double cur = NumberUtil.round(com.getCur()*x+y, 2);
		double low = NumberUtil.round(com.getLow()*x+y, 2);
		double high = NumberUtil.round(com.getHigh()*x+y, 2);
		double open = NumberUtil.round(com.getOpen()*x+y, 2);
		com1.setDate(com.getDate());
		com1.setKeyDate(com.getKeyDate());
		com1.setCur(cur);
		com1.setHigh(high);
		com1.setLow(low);
		com1.setOpen(open);
		com1.setSum(com.getSum());
		com1.setVolume(com.getVolume());
		com1.setSwap(com.getSwap());
		com1.setVolume10PointAvg(com.getVolume10PointAvg());
		com1.setVolume5PointAvg(com.getVolume5PointAvg());


		com1.setPrice10PointAvg(com.getPrice10PointAvg()*x+y);
		com1.setPrice120PointAvg(com.getPrice120PointAvg()*x+y);
		com1.setPrice20PointAvg(com.getPrice20PointAvg()*x+y);
		com1.setPrice240PointAvg(com.getPrice240PointAvg()*x+y);
		com1.setPrice5PointAvg(com.getPrice5PointAvg()*x+y);
		com1.setPrice60PointAvg(com.getPrice60PointAvg()*x+y);
		return com1;
		/*com.setCur(NumberUtil.double2Int(com.getCur()*x+y,priceScale));
		com.setHigh(NumberUtil.double2Int(com.getHigh()*x+y,priceScale));
		com.setLow(NumberUtil.double2Int(com.getLow()*x+y,priceScale));
		com.setOpen(NumberUtil.double2Int(com.getOpen()*x+y,priceScale));
		com.setPrice10PointAvg(NumberUtil.double2Int(com.getPrice10PointAvg()*x+y,priceScale));
		com.setPrice120PointAvg(NumberUtil.double2Int(com.getPrice120PointAvg()*x+y,priceScale));
		com.setPrice20PointAvg(NumberUtil.double2Int(com.getPrice20PointAvg()*x+y,priceScale));
		com.setPrice240PointAvg(NumberUtil.double2Int(com.getPrice240PointAvg()*x+y,priceScale));
		com.setPrice5PointAvg(NumberUtil.double2Int(com.getPrice5PointAvg()*x+y,priceScale));
		com.setPrice60PointAvg(NumberUtil.double2Int(com.getPrice60PointAvg()*x+y,priceScale));*/
	}

	public static Map sortMapByKey(Map map) {
		Map<Object, Object> mapVK = new TreeMap<Object, Object>(new Comparator<Object>() {
			public int compare(Object obj1, Object obj2) {
				Long v1 = (Long) obj1;
				Long v2 = (Long) obj2;
				int s = v1.compareTo(v2);
				return s;
			}
		});
		Set col = map.keySet();
		Iterator iter = col.iterator();
		while (iter.hasNext()) {
			Long key =  (Long) iter.next();
			String value = (String) map.get(key);
			mapVK.put(key, value);
		}
		return mapVK;
	}
	static class SortByDateComparator implements Comparator<CommonKlinePoint> {

		@Override
		public int compare(CommonKlinePoint o1, CommonKlinePoint o2) {
			return 0;
		}

	}

	public static List<CommonKlinePoint> getKlist(String stockCode,
												  int marketid, long startTime, long endTime, String klinetype) {
		String code = QuoteUtil.convertTo8(stockCode, marketid);
		List<CommonKlinePoint> klist = HisKlineReader.getKLineByTime(stockCode, marketid, klinetype, startTime, endTime);
		List<CommonKlinePoint> forwardKline = new ArrayList<>();
		if(klist.size()>0){
			if(StrategyCache.stocksXRDR.get(code)!=null){
				forwardKline = XRDRKlineUtil.calForWardKLine(klist, StrategyCache.stocksXRDR.get(code), (byte)0x21, stockCode, marketid, 0);
			}

		}
		return forwardKline;
	}
	public static List<CommonKlinePoint> getPreList(String stockCode,
													int marketid, long startTime, int i, String klinetype) {
		String code = QuoteUtil.convertTo8(stockCode, marketid);
		List<CommonKlinePoint> klist = HisKlineReader.getKLineBeforeTimeNoToday(stockCode, marketid, klinetype, startTime, i);

		List<CommonKlinePoint> forwardKline = new ArrayList<>();
		if(StrategyCache.stocksXRDR.get(code) !=null && klist.size()>0){
			forwardKline = XRDRKlineUtil.calForWardKLine(klist, StrategyCache.stocksXRDR.get(code), (byte)0x21, stockCode, marketid, 0);
		}else{
			forwardKline.addAll(klist);
		}

		return forwardKline;
	}

	/**
	 * malist传入 +1根    1     10  2  11
	 *
	 *
	 * @param stockCode 6位股票
	 * @param tradeday 交易日
	 * @param ma
	 * @param malist
	 * @return
	 */
	public static Double getMA(String stockCode, long tradeday,
							   int ma, List<CommonKlinePoint> malist) {
		/**
		 * 当天下午4:00后收盘，可以计算MA
		 */
		Double maNum = 0.0d;
		double sum = 0;
		String keystr = stockCode+"_"+tradeday+"_"+ma;
		if(malist.size()<ma){
			return null;
		}
		if(malist.size()>0){
			for(CommonKlinePoint point:malist){
				sum += point.getCur();
			}
			maNum = NumberUtil.round(sum/malist.size(), 4);
			if(ma == 5 || ma == 10){
				StrategyCache.stocksMA.put(keystr, maNum);
			}
		}
		return maNum;
	}



	public static List<CommonKlinePoint> getValueList(List<CommonKlinePoint> prelist,
													  List<CommonKlinePoint> klist, int i, int days) {

		List<CommonKlinePoint> malist = new ArrayList<>();
		try{
			if(i>days){
				return klist.subList(i-days, i);
			}
			if(prelist.size()+i>days){
				if(i<0){
					malist.addAll(prelist.subList(prelist.size()+i-days, prelist.size()+i));
				}else{
					malist.addAll(prelist.subList(prelist.size()+i-days, prelist.size()));
				}
			}
			else
				malist.addAll(prelist);
			if(i>0)
				malist.addAll(klist.subList(0, i));

		}catch(Exception e){
			e.printStackTrace();
		}
		return malist;
	}

	public static List<CommonKlinePoint> getKlineByCount(String stockCode, int count){

		int marketid = 1;
		boolean isIndex = false;
		if(stockCode.length() == 8){
			marketid = QuoteUtil.getMarketID(stockCode);
			stockCode = stockCode.substring(2);
			isIndex = true;//是指数
		}else{
			 marketid = QuoteUtil.getMarketIdByStock(stockCode);
		}

		List<CommonKlinePoint> his251List = HisKlineReader.getKlineByCount(stockCode, marketid,"day", count);

		if(isIndex){
			return his251List;
		}

		/*if(StrategyCache.stocksXRDR.get(stockCode) == null){
			QuoteZookeeperConfig quotezkconfig = new QuoteZookeeperConfig();
			String quoteURL = quotezkconfig.getQuoteURL();
			XRDRCollector.getXrdrInfo(quoteURL, stockCode, marketid);
		}*/

		if(StrategyCache.stocksXRDR.get(stockCode) == null){
			return his251List;
		}
		List<CommonKlinePoint> forWardKLine = XRDRKlineUtil.calForWardKLine(his251List, StrategyCache.stocksXRDR.get(stockCode), (byte)0x21, stockCode, marketid, 0);

		return forWardKLine;
	}

}
