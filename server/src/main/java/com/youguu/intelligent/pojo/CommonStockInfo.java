package com.youguu.intelligent.pojo;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;


/**
 * 基本股票即时数据对象. 持有股票某个时间点上的即时数据内容，一般情况为最新股票即时数据.
 * 
 * @author hucy 2008 2008-3-19 下午04:12:32
 * @author iceline
 * @since 1.0
 */
public class CommonStockInfo implements Cloneable {
	

	/** serialVersionUID. */
	private static final long serialVersionUID = 109440135393239603L;
	
	/**
	 * 市场id,仅供client face使用
	 */
	private int marketId;

	/**
	 * 证券代码.
	 */
	protected String stockCode;

	/**
	 * 证券中文简称.
	 */
	private String cnName;

	/**
	 * 证券英文简称.
	 */
	private String enName;

	/**
	 * 最新价格
	 */
	private double lastPrice;

	/**
	 * 前收盘.
	 */
	private double preClose;

	/**
	 * 今开盘.
	 */
	private double todayOpen;

	/**
	 * 今收盘.
	 */
	private double todayClose;

	/**
	 * 当前买入价
	 */
	private double bid;

	/**
	 * 当前卖出价
	 */
	private double ask;

	/**
	 * 卖出差价
	 */
	private double bidSpread;
	/**
	 * 买入差价
	 */
	private double askSpread;

	/**
	 * 申卖1 申卖5
	 */
	private double askPrice1;

	private long askVolume1;

	private double askPrice2;

	private long askVolume2;

	private double askPrice3;

	private long askVolume3;

	private double askPrice4;

	private long askVolume4;

	private double askPrice5;

	private long askVolume5;

	/**
	 * 申买1 申买5
	 */
	private double bidPrice1;

	private long bidVolume1;

	private double bidPrice2;

	private long bidVolume2;

	private double bidPrice3;

	private long bidVolume3;

	private double bidPrice4;

	private long bidVolume4;

	private double bidPrice5;

	private long bidVolume5;

	/**
	 * 最高价.
	 */
	private double highPrice;

	/**
	 * 最低价.
	 */
	private double lowPrice;

	/**
	 * 升跌
	 */
	private double netChange;

	/**
	 * 升跌率
	 */
	private float netChangeRation;

	/**
	 * 成交量.
	 */
	private long volume;

	/**
	 * 成交金额 ,可以由交易所直接给出 ，也可以由明细成交量和当前价格相乘累计给出
	 */
	private double turnOver;

	/**
	 * 52周最高价
	 */
	private double yearHigh;

	/**
	 * 52周最低价
	 */
	private double yearLow;

	/**
	 * 市盈率
	 */
	private float peRatio;

	/**
	 * 息率
	 */
	private float yield;

	/**
	 * 每手股数
	 */
	private int lotSize;

	/**
	 * 货币单位
	 */
	private String currency;

	/**
	 * 市值
	 */
	private double marketCap;
	/**
	 * 是否停盘
	 */
	private boolean suspend;
	/**
	 * 到期日
	 */
	private long expiredate;

	/**
	 * 溢价
	 */
	private double premium;
	/**
	 * 杠杆比率
	 */
	private float gearingRatio;

	/**
	 * 换股价
	 */
	private double convPrice;
	/**
	 * 换股率
	 */
	private float convRation;

	/**
	 * 即时行情时间，把时间数据直接转换成长整形进行存储
	 */
	private long datetime;

	/////需要读取配置信息进行设置	
	/**
	 * 高字节为大类信息 低字节为小类信息
	 * 0x0100指数 0x0200股票 0x0300基金 0x0400债券 0x0500权证
	 */
	private short fullType;
	

	/////需要进行计算的值
	/**
	 * 换手率
	 */
	private float swap;

	/**
	 * 量比
	 */
	private float volumeRatio;
	/**
	 * 委比
	 */
	private float entrustRatio;
	/**
	 * 涨速
	 */
	private float velocityRatio;

	/**
	 * 内盘
	 */
	private long inSide;
	/**
	 * 外盘
	 */
	private long outSide;
	/**
	 * 现手
	 */
	private long curVolume;

	/**
	 * 振幅
	 */
	private float swing;

	/**
	 * 成交笔数
	 */
	private int tradeCount;
	
	/**
	 * 市净率
	 */
	private float PBration;
	
	private double last5MinPrice;
	
	private double last3MinPrice;
	
	private double last1MinPrice;
	
	/**
	 * 过去5个交易日每分钟平均交易量.tangyh added 2010-09-02
	 */
	private double fiveDaysMinuteVolumeAvg; 
	
	/**
	 * 总委买.tangyh added 2010-09-03
	 */
	private long totalBid; 

	/**
	 * 总委卖.tangyh added 2010-09-03
	 */
	private long totalAsk; 
	
	/**
	 * 流通总股本.tangyh added 2010-09-03
	 */
	private double floatTotalMarketCap; 
	
	/**
	 * 普通股票红绿柱.tangyh added 2010-09-09
	 */
	private byte commonRdp; 
	
	/**
	 * 普通股票上次行情红绿柱.tangyh added 2010-09-09
	 */
	private byte commonOldRdp; 
	
	/**
	 * 委差
	 * @param stock
	 * @return
	 */
	private long weicha;
	
	/**
	 * 涨停价
	 * @param stock
	 * @return
	 */
	private double riseLimitPrice; 
	
	/**
	 * 跌停价
	 * @param stock
	 * @return
	 */
	private double declientLimitPrice;
	
	private double tradeAmountIn;
	
	private double tradeAmountOut;
	
	private long tradeVolIn;
	
	private long tradeVolOut;
	
	private String securityPreName;
	//ashlee 证券级别  'Z' 退市股票 ； 'N' 正常；'S' ST 股票；'*' *ST 股票；4 股份转让；
	//5 上市开放基金LOF；6  交易型开放式指数基金（ETF）；7 非交易型开放式基金 
	//8 仅提供净值揭示服务的开放式基金；9 仅在协议交易平台挂牌交易的证券（
	private byte securityProperties;


	public CommonStockInfo copyData2(CommonStockInfo stock){
		
		stock.stockCode = this.stockCode;
		stock.cnName = this.cnName;
		stock.enName = this.enName;
		stock.lastPrice = this.lastPrice;
		stock.preClose = this.preClose;
		stock.todayOpen = this.todayOpen;
		stock.todayClose = this.todayClose;
		stock.bid = this.bid;
		stock.ask = this.ask;
		stock.bidSpread = this.bidSpread;
		stock.askSpread = this.askSpread;

		stock.askPrice1 = this.askPrice1;
		stock.askVolume1 = this.askVolume1;
		stock.askPrice2 = this.askPrice2;
		stock.askVolume2 = this.askVolume2;
		stock.askPrice3 = this.askPrice3;
		stock.askVolume3 = this.askVolume3;
		stock.askPrice4 = this.askPrice4;
		stock.askVolume4 = this.askVolume4;
		stock.askPrice5 = this.askPrice5;
		stock.askVolume5 = this.askVolume5;
		stock.bidPrice1 = this.bidPrice1;
		stock.bidVolume1 = this.bidVolume1;
		stock.bidPrice2 = this.bidPrice2;
		stock.bidVolume2 = this.bidVolume2;
		stock.bidPrice3 = this.bidPrice3;
		stock.bidVolume3 = this.bidVolume3;
		stock.bidPrice4 = this.bidPrice4;
		stock.bidVolume4 = this.bidVolume4;
		stock.bidPrice5 = this.bidPrice5;
		stock.bidVolume5 = this.bidVolume5;
		
		stock.highPrice = this.highPrice;
		stock.lowPrice = this.lowPrice;
		stock.volume = this.volume;
		stock.turnOver = this.turnOver;
		stock.yearHigh = this.yearHigh;
		stock.yearLow = this.yearLow;
		stock.peRatio = this.peRatio;
		stock.yield = this.yield;
		stock.lotSize = this.lotSize;
		stock.currency = this.currency;
		stock.marketCap = this.marketCap;
		stock.suspend = this.suspend;
		stock.expiredate = this.expiredate;
		stock.premium = this.premium;
		stock.gearingRatio =this.gearingRatio;
		stock.convPrice = this.convPrice;
		stock.convRation = this.convRation;
		stock.datetime = this.datetime;
		stock.PBration = this.PBration;

		stock.netChange = this.netChange;
		stock.netChangeRation = this.netChangeRation;
		
		stock.swap = this.swap;
		stock.volumeRatio = this.volumeRatio;
		stock.entrustRatio = this.entrustRatio;
		stock.velocityRatio = this.velocityRatio;
		stock.inSide = this.inSide;
		stock.outSide = this.outSide;
		stock.curVolume = this.curVolume;			
		stock.swing = this.swing;
		stock.tradeCount = this.tradeCount;	
		
		stock.fullType = this.fullType;
		stock.marketId = this.marketId;
		
		stock.last5MinPrice = this.last5MinPrice;
		stock.last3MinPrice = this.last3MinPrice;
		stock.last1MinPrice = this.last1MinPrice;
		
		stock.fiveDaysMinuteVolumeAvg = this.fiveDaysMinuteVolumeAvg;
		stock.totalAsk=this.totalAsk;
		stock.totalBid=this.totalBid;
		stock.floatTotalMarketCap=this.floatTotalMarketCap;
		stock.commonRdp=this.commonRdp;
		stock.commonOldRdp=this.commonOldRdp;
		stock.weicha=this.weicha;
		stock.riseLimitPrice=this.riseLimitPrice;
		stock.declientLimitPrice=this.declientLimitPrice;
		stock.tradeAmountIn = this.tradeAmountIn;
		stock.tradeAmountOut = this.tradeAmountOut;
		stock.tradeVolIn = this.tradeVolIn;
		stock.tradeVolOut = this.tradeVolOut;
		stock.securityPreName = this.securityPreName;
		
		stock.securityProperties = this.securityProperties;
		return stock;
	}

	public void zero() {
		// this.stockCodee;
		// this.cnName
		// this.enName
		if(this.lastPrice > 0.00001d )//判断只有在最新价不为0时清空
			this.preClose = this.lastPrice;
		this.lastPrice = 0;
		this.todayOpen = 0;
		this.todayClose = 0;
		this.bid = 0;
		this.ask = 0;
		this.bidSpread = 0;
		this.askSpread = 0;
		this.askPrice1 = 0;
		this.askVolume1 = 0;
		this.askPrice2 = 0;
		this.askVolume2 = 0;
		this.askPrice3 = 0;
		this.askVolume3 = 0;
		this.askPrice4 = 0;
		this.askVolume4 = 0;
		this.askPrice5 = 0;
		this.askVolume5 = 0;
		this.bidPrice1 = 0;
		this.bidVolume1 = 0;
		this.bidPrice2 = 0;
		this.bidVolume2 = 0;
		this.bidPrice3 = 0;
		this.bidVolume3 = 0;
		this.bidPrice4 = 0;
		this.bidVolume4 = 0;
		this.bidPrice5 = 0;
		this.bidVolume5 = 0;
		this.highPrice = 0;
		this.lowPrice = 0;
		this.netChange = 0;
		this.netChangeRation = 0;
		this.volume = 0;
		this.turnOver = 0;
		this.yearHigh = 0;
		this.yearLow = 0;
		this.peRatio = 0;
		this.yield = 0;
		this.lotSize = 0;
		// this.currency
		//this.marketCap = 0;
		// this.suspend = 0;
		this.expiredate = 0;
		this.premium = 0;
		this.gearingRatio = 0;
		this.convPrice = 0;
		this.convRation = 0;
		this.datetime = 0;
		// this.mainboard ;
		// this.gemboard ;
		// this.others;
		// this.redchips ;
		// this.hshares ;
		// this.convertPrecision;
		this.swap = 0;
		this.volumeRatio = 0;
		this.entrustRatio = 0;
		this.velocityRatio = 0;
		this.inSide = 0;
		this.outSide = 0;
		this.curVolume = 0;
		this.swing = 0;
		this.tradeCount = 0;
		this.PBration=0;
		this.last5MinPrice = 0.0f;
		this.last3MinPrice = 0.0f;
		this.last1MinPrice = 0.0f;
		
		this.fiveDaysMinuteVolumeAvg=0;
		this.totalAsk=0;
		this.totalBid=0;
		this.floatTotalMarketCap=0;
		this.commonRdp=0;
		this.commonOldRdp=0;
		this.weicha=0;
		this.riseLimitPrice=0;
		this.declientLimitPrice=0;
		this.tradeAmountIn= 0.0d;
		this.tradeAmountOut= 0.0d;
		this.tradeVolIn=0;
		this.tradeVolOut=0;
		this.securityPreName = "";
		this.securityProperties = (byte)'N';
	}

	@Override
	public String toString() {
		StringBuffer strbuf = new StringBuffer(this.getClass().getSimpleName() + "==");
		strbuf.append(" stockCode:" + stockCode);
		strbuf.append(" marketId:" + marketId);
		strbuf.append(" cnName:" + cnName);
		strbuf.append(" enName:" + enName);
		strbuf.append(" securityPreName:" + securityPreName);
		strbuf.append( "securityProperties:"+securityProperties);
		strbuf.append(" lastPrice:" + lastPrice);
		strbuf.append(" preClose:" + preClose);
		strbuf.append(" todayOpen:" + todayOpen);
		strbuf.append(" todayClose:" + todayClose);
		strbuf.append(" bid:" + bid);
		strbuf.append(" ask:" + ask);
		strbuf.append(" bidSpread:" + bidSpread);
		strbuf.append(" askSpread:" + askSpread);
		strbuf.append(" askPrice1:" + askPrice1);
		strbuf.append(" askVolume1:" + askVolume1);
		strbuf.append(" askPrice2:" + askPrice2);
		strbuf.append(" askVolume2:" + askVolume2);
		strbuf.append(" askPrice3:" + askPrice3);
		strbuf.append(" askVolume3:" + askVolume3);
		strbuf.append(" askPrice4:" + askPrice4);
		strbuf.append(" askVolume4:" + askVolume4);
		strbuf.append(" askPrice5:" + askPrice5);
		strbuf.append(" askVolume5:" + askVolume5);
		strbuf.append(" bidPrice1:" + bidPrice1);
		strbuf.append(" bidVolume1:" + bidVolume1);
		strbuf.append(" bidPrice2:" + bidPrice2);
		strbuf.append(" bidVolume2:" + bidVolume2);
		strbuf.append(" bidPrice3:" + bidPrice3);
		strbuf.append(" bidVolume3:" + bidVolume3);
		strbuf.append(" bidPrice4:" + bidPrice4);
		strbuf.append(" bidVolume4:" + bidVolume4);
		strbuf.append(" bidPrice5:" + bidPrice5);
		strbuf.append(" bidVolume5:" + bidVolume5);
		strbuf.append(" highPrice:" + highPrice);
		strbuf.append(" lowPrice:" + lowPrice);
		strbuf.append(" netChange:" + netChange);
		strbuf.append(" netChangeRation:" + netChangeRation);
		strbuf.append(" volume:" + volume);
		strbuf.append(" turnOver:" + turnOver);
		strbuf.append(" yearHigh:" + yearHigh);
		strbuf.append(" yearLow:" + yearLow);
		strbuf.append(" peRatio:" + peRatio);
		strbuf.append(" yield:" + yield);
		strbuf.append(" lotSize:" + lotSize);
		strbuf.append(" currency:" + currency);
		strbuf.append(" marketCap:" + marketCap);
		strbuf.append(" suspend:" + suspend);
		strbuf.append(" expiredate:" + expiredate);
		strbuf.append(" premium:" + premium);
		strbuf.append(" gearingRatio:" + gearingRatio);
		strbuf.append(" convPrice:" + convPrice);
		strbuf.append(" convRation:" + convRation);
		strbuf.append(" datetime:" + datetime);
		strbuf.append(" swap:" + swap);
		strbuf.append(" volumeRatio:" + volumeRatio);
		strbuf.append(" entrustRatio:" + entrustRatio);
		strbuf.append(" velocityRatio:" + velocityRatio);
		strbuf.append(" inSide:" + inSide);
		strbuf.append(" outSide:" + outSide);
		strbuf.append(" curVolume:" + curVolume);
		strbuf.append(" swing:" + swing);
		strbuf.append(" tradeCount:" + tradeCount);
		strbuf.append(" pbration:" + PBration);
		strbuf.append(" last5MinPrice:" + last5MinPrice);
		strbuf.append(" last3MinPrice:" + last3MinPrice);
		strbuf.append(" last1MinPrice:" + last1MinPrice);
		strbuf.append(" fiveDaysMinuteVolumeAvg:" + fiveDaysMinuteVolumeAvg);
		strbuf.append(" totalAsk:" + totalAsk);
		strbuf.append(" totalBid:" + totalBid);
		strbuf.append(" floatTotalMarketCap:" + floatTotalMarketCap);
		strbuf.append(" commonRdp:" + commonRdp);
		strbuf.append(" commonOldRdp:" + commonOldRdp);
		strbuf.append(" weicha:" + weicha);
		strbuf.append(" riseLimitPrice:" + riseLimitPrice);
		strbuf.append(" declientLimitPrice:" + declientLimitPrice);
		strbuf.append(" tradeAmountIn:" + tradeAmountIn);
		strbuf.append(" tradeAmountOut:" + tradeAmountOut);
		strbuf.append(" tradeVolIn:" + tradeVolIn);
		strbuf.append(" tradeVolOut:" + tradeVolOut);
		strbuf.append(" securityProperty:" + securityProperties);
		
		return strbuf.toString();
	}

	public byte getSecurityProperties() {
		return securityProperties;
	}

	public void setSecurityProperties(byte securityProperties) {
		this.securityProperties = securityProperties;
	}
	public double getAsk() {
		return ask;
	}

	public void setAsk(double ask) {
		this.ask = ask;
	}

	public double getAskPrice1() {
		return askPrice1;
	}

	public void setAskPrice1(double askPrice1) {
		this.askPrice1 = askPrice1;
	}

	public double getAskPrice2() {
		return askPrice2;
	}

	public void setAskPrice2(double askPrice2) {
		this.askPrice2 = askPrice2;
	}

	public double getAskPrice3() {
		return askPrice3;
	}

	public void setAskPrice3(double askPrice3) {
		this.askPrice3 = askPrice3;
	}

	public double getAskPrice4() {
		return askPrice4;
	}

	public void setAskPrice4(double askPrice4) {
		this.askPrice4 = askPrice4;
	}

	public double getAskPrice5() {
		return askPrice5;
	}

	public void setAskPrice5(double askPrice5) {
		this.askPrice5 = askPrice5;
	}

	public double getAskSpread() {
		return askSpread;
	}

	public void setAskSpread(double askSpread) {
		this.askSpread = askSpread;
	}

	public long getAskVolume1() {
		return askVolume1;
	}

	public void setAskVolume1(long askVolume1) {
		this.askVolume1 = askVolume1;
	}

	public long getAskVolume2() {
		return askVolume2;
	}

	public void setAskVolume2(long askVolume2) {
		this.askVolume2 = askVolume2;
	}

	public long getAskVolume3() {
		return askVolume3;
	}

	public void setAskVolume3(long askVolume3) {
		this.askVolume3 = askVolume3;
	}

	public long getAskVolume4() {
		return askVolume4;
	}

	public void setAskVolume4(long askVolume4) {
		this.askVolume4 = askVolume4;
	}

	public long getAskVolume5() {
		return askVolume5;
	}

	public void setAskVolume5(long askVolume5) {
		this.askVolume5 = askVolume5;
	}

	public double getBid() {
		return bid;
	}

	public void setBid(double bid) {
		this.bid = bid;
	}

	public double getBidPrice1() {
		return bidPrice1;
	}

	public void setBidPrice1(double bidPrice1) {
		this.bidPrice1 = bidPrice1;
	}

	public double getBidPrice2() {
		return bidPrice2;
	}

	public void setBidPrice2(double bidPrice2) {
		this.bidPrice2 = bidPrice2;
	}

	public double getBidPrice3() {
		return bidPrice3;
	}

	public void setBidPrice3(double bidPrice3) {
		this.bidPrice3 = bidPrice3;
	}

	public double getBidPrice4() {
		return bidPrice4;
	}

	public void setBidPrice4(double bidPrice4) {
		this.bidPrice4 = bidPrice4;
	}

	public double getBidPrice5() {
		return bidPrice5;
	}

	public void setBidPrice5(double bidPrice5) {
		this.bidPrice5 = bidPrice5;
	}

	public double getBidSpread() {
		return bidSpread;
	}

	public void setBidSpread(double bidSpread) {
		this.bidSpread = bidSpread;
	}

	public long getBidVolume1() {
		return bidVolume1;
	}

	public void setBidVolume1(long bidVolume1) {
		this.bidVolume1 = bidVolume1;
	}

	public long getBidVolume2() {
		return bidVolume2;
	}

	public void setBidVolume2(long bidVolume2) {
		this.bidVolume2 = bidVolume2;
	}

	public long getBidVolume3() {
		return bidVolume3;
	}

	public void setBidVolume3(long bidVolume3) {
		this.bidVolume3 = bidVolume3;
	}

	public long getBidVolume4() {
		return bidVolume4;
	}

	public void setBidVolume4(long bidVolume4) {
		this.bidVolume4 = bidVolume4;
	}

	public long getBidVolume5() {
		return bidVolume5;
	}

	public void setBidVolume5(long bidVolume5) {
		this.bidVolume5 = bidVolume5;
	}

	public String getCnName() {
		return cnName;
	}

	public void setCnName(String cnName) {
		this.cnName = cnName;
	}


	public double getConvPrice() {
		return convPrice;
	}

	public void setConvPrice(double convPrice) {
		this.convPrice = convPrice;
	}

	public float getConvRation() {
		return convRation;
	}

	public void setConvRation(float convRation) {
		this.convRation = convRation;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public long getCurVolume() {
		return curVolume;
	}

	public void setCurVolume(long curVolume) {
		this.curVolume = curVolume;
	}

	public long getDatetime() {
		return datetime;
	}

	public void setDatetime(long datetime) {
		this.datetime = datetime;
	}

	public String getEnName() {
		return enName;
	}

	public void setEnName(String enName) {
		this.enName = enName;
	}

	public float getEntrustRatio() {
		return entrustRatio;
	}

	public void setEntrustRatio(float entrustRatio) {
		this.entrustRatio = entrustRatio;
	}

	public long getExpiredate() {
		return expiredate;
	}

	public void setExpiredate(long expiredate) {
		this.expiredate = expiredate;
	}

	public float getGearingRatio() {
		return gearingRatio;
	}

	public void setGearingRatio(float gearingRatio) {
		this.gearingRatio = gearingRatio;
	}

	public double getHighPrice() {
		return highPrice;
	}

	public void setHighPrice(double highPrice) {
		this.highPrice = highPrice;
	}

	public long getInSide() {
		return inSide;
	}

	public void setInSide(long inSide) {
		this.inSide = inSide;
	}

	public double getLastPrice() {
		return lastPrice;
	}

	public void setLastPrice(double lastPrice) {
		this.lastPrice = lastPrice;
	}

	public int getLotSize() {
		return lotSize;
	}

	public void setLotSize(int lotSize) {
		this.lotSize = lotSize;
	}

	public double getLowPrice() {
		return lowPrice;
	}

	public void setLowPrice(double lowPrice) {
		this.lowPrice = lowPrice;
	}

	public double getMarketCap() {
		return marketCap;
	}

	public void setMarketCap(double marketCap) {
		this.marketCap = marketCap;
	}

	public double getNetChange() {
		return netChange;
	}

	public void setNetChange(double netChange) {
		this.netChange = netChange;
	}

	public float getNetChangeRation() {
		return netChangeRation;
	}

	public void setNetChangeRation(float netChangeRation) {
		this.netChangeRation = netChangeRation;
	}

	public long getOutSide() {
		return outSide;
	}

	public void setOutSide(long outSide) {
		this.outSide = outSide;
	}

	public float getPeRatio() {
		return peRatio;
	}

	public void setPeRatio(float peRatio) {
		this.peRatio = peRatio;
	}

	public double getPreClose() {
		return preClose;
	}

	public void setPreClose(double preClose) {
		this.preClose = preClose;
	}

	public double getPremium() {
		return premium;
	}

	public void setPremium(double premium) {
		this.premium = premium;
	}

	public String getStockCode() {
		return stockCode;
	}

	public void setStockCode(String stockCode) {
		this.stockCode = stockCode.trim();
	}

	public boolean isSuspend() {
		return suspend;
	}

	public void setSuspend(boolean suspend) {
		this.suspend = suspend;
	}

	public float getSwap() {
		return swap;
	}

	public void setSwap(float swap) {
		this.swap = swap;
	}

	public float getSwing() {
		return swing;
	}

	public void setSwing(float swing) {
		this.swing = swing;
	}

	public double getTodayClose() {
		return todayClose;
	}

	public void setTodayClose(double todayClose) {
		this.todayClose = todayClose;
	}

	public double getTodayOpen() {
		return todayOpen;
	}

	public void setTodayOpen(double todayOpen) {
		this.todayOpen = todayOpen;
	}

	public int getTradeCount() {
		return tradeCount;
	}

	public void setTradeCount(int tradeCount) {
		this.tradeCount = tradeCount;
	}

	public double getTurnOver() {
		return turnOver;
	}

	public void setTurnOver(double turnOver) {
		this.turnOver = turnOver;
	}

	public float getVelocityRatio() {
		return velocityRatio;
	}

	public void setVelocityRatio(float velocityRatio) {
		this.velocityRatio = velocityRatio;
	}

	public long getVolume() {
		return volume;
	}

	public void setVolume(long volume) {
		this.volume = volume;
	}

	public float getVolumeRatio() {
		return volumeRatio;
	}

	public void setVolumeRatio(float volumeRatio) {
		this.volumeRatio = volumeRatio;
	}

	public double getYearHigh() {
		return yearHigh;
	}

	public void setYearHigh(double yearHigh) {
		this.yearHigh = yearHigh;
	}

	public double getYearLow() {
		return yearLow;
	}

	public void setYearLow(double yearLow) {
		this.yearLow = yearLow;
	}

	public float getYield() {
		return yield;
	}

	public void setYield(float yield) {
		this.yield = yield;
	}

	public byte getType() {
		return (byte) (fullType >>> 8);
	}
	
	/**
	 * 兼容，请使用setFullType
	 * @param bigtype
	 */
	public void setType(byte bigtype) {
		short ft = (short)( (bigtype & 0xff) << 8);
		this.setFullType(ft);
	}
	
	public byte getSubType(){
		return (byte)fullType;
	}

	public void setFullType(short fulltype) {
		this.fullType = fulltype;
	}
	
	public short getFullType() {
		return fullType ;
	}	

	public int getMarketId() {
		return marketId;
	}

	public void setMarketId(int marketId) {
		this.marketId = marketId;
	}

	public float getPBration() {
		return PBration;
	}

	public void setPBration(float bration) {
		PBration = bration;
	}


	public double getLast5MinPrice() {
		return last5MinPrice;
	}

	public void setLast5MinPrice(double last5MinPrice) {
		this.last5MinPrice = last5MinPrice;
	}

	public double getLast3MinPrice() {
		return last3MinPrice;
	}

	public void setLast3MinPrice(double last3MinPrice) {
		this.last3MinPrice = last3MinPrice;
	}

	public double getLast1MinPrice() {
		return last1MinPrice;
	}

	public void setLast1MinPrice(double last1MinPrice) {
		this.last1MinPrice = last1MinPrice;
	}
	
	public double getFiveDaysMinuteVolumeAvg() {
		return fiveDaysMinuteVolumeAvg;
	}

	public void setFiveDaysMinuteVolumeAvg(double fiveDaysMinuteVolumeAvg) {
		this.fiveDaysMinuteVolumeAvg = fiveDaysMinuteVolumeAvg;
	}

	public long getTotalBid() {
		return totalBid;
	}

	public void setTotalBid(long totalBid) {
		this.totalBid = totalBid;
	}

	public long getTotalAsk() {
		return totalAsk;
	}

	public void setTotalAsk(long totalAsk) {
		this.totalAsk = totalAsk;
	}

	public double getFloatTotalMarketCap() {
		return floatTotalMarketCap;
	}

	public void setFloatTotalMarketCap(double floatTotalMarketCap) {
		this.floatTotalMarketCap = floatTotalMarketCap;
	}
	
	public byte getCommonRdp() {
		return commonRdp;
	}

	public void setCommonRdp(byte commonRdp) {
		this.commonRdp = commonRdp;
	}

	public byte getCommonOldRdp() {
		return commonOldRdp;
	}

	public void setCommonOldRdp(byte commonOldRdp) {
		this.commonOldRdp = commonOldRdp;
	}

	public long getWeicha() {
		return weicha;
	}

	public void setWeicha(long weicha) {
		this.weicha = weicha;
	}

	public double getRiseLimitPrice() {
		return riseLimitPrice;
	}

	public void setRiseLimitPrice(double riseLimitPrice) {
		this.riseLimitPrice = riseLimitPrice;
	}

	public double getDeclientLimitPrice() {
		return declientLimitPrice;
	}

	public void setDeclientLimitPrice(double declientLimitPrice) {
		this.declientLimitPrice = declientLimitPrice;
	}

	public double getTradeAmountIn() {
		return tradeAmountIn;
	}

	public void setTradeAmountIn(double tradeAmountIn) {
		this.tradeAmountIn = tradeAmountIn;
	}

	public double getTradeAmountOut() {
		return tradeAmountOut;
	}

	public void setTradeAmountOut(double tradeAmountOut) {
		this.tradeAmountOut = tradeAmountOut;
	}

	public long getTradeVolIn() {
		return tradeVolIn;
	}

	public void setTradeVolIn(long tradeVolIn) {
		this.tradeVolIn = tradeVolIn;
	}

	public long getTradeVolOut() {
		return tradeVolOut;
	}

	public void setTradeVolOut(long tradeVolOut) {
		this.tradeVolOut = tradeVolOut;
	}

	public String getSecurityPreName() {
		return securityPreName;
	}

	public void setSecurityPreName(String securityPreName) {
		this.securityPreName = securityPreName;
	}

    public void writeData(DataOutputStream dos, int version) throws IOException {
    	int beginSize=dos.size();
 		dos.writeDouble(this.getLastPrice());
		dos.writeDouble(this.getPreClose());
		dos.writeDouble(this.getTodayOpen());
		dos.writeDouble(this.getTodayClose());
		dos.writeDouble(this.getBid());
		dos.writeDouble(this.getAsk());
		dos.writeDouble(this.getBidSpread());
		dos.writeDouble(this.getAskSpread());
		dos.writeDouble(this.getAskPrice1());
		dos.writeLong(this.getAskVolume1());
		dos.writeDouble(this.getAskPrice2());
		dos.writeLong(this.getAskVolume2());
		dos.writeDouble(this.getAskPrice3());
		dos.writeLong(this.getAskVolume3());
		dos.writeDouble(this.getAskPrice4());
		dos.writeLong(this.getAskVolume4());
		dos.writeDouble(this.getAskPrice5());
		dos.writeLong(this.getAskVolume5());
		dos.writeDouble(this.getBidPrice1());
		dos.writeLong(this.getBidVolume1());
		dos.writeDouble(this.getBidPrice2());
		dos.writeLong(this.getBidVolume2());
		dos.writeDouble(this.getBidPrice3());
		dos.writeLong(this.getBidVolume3());
		dos.writeDouble(this.getBidPrice4());
		dos.writeLong(this.getBidVolume4());
		dos.writeDouble(this.getBidPrice5());
		dos.writeLong(this.getBidVolume5());
		dos.writeDouble(this.getHighPrice());
		dos.writeDouble(this.getLowPrice());
		dos.writeDouble(this.getNetChange());
		dos.writeFloat(this.getNetChangeRation());
		dos.writeLong(this.getVolume());
		dos.writeDouble(this.getTurnOver());
		dos.writeDouble(this.getYearHigh());
		dos.writeDouble(this.getYearLow());
		dos.writeFloat(this.getPeRatio());
		dos.writeFloat(this.getYield());
		dos.writeInt(this.getLotSize());
		dos.writeDouble(this.getMarketCap());
		dos.writeBoolean(this.isSuspend());
		dos.writeLong(this.getExpiredate());
		dos.writeDouble(this.getPremium());
		dos.writeFloat(this.getGearingRatio());
		dos.writeDouble(this.getConvPrice());
		dos.writeFloat(this.getConvRation());
		dos.writeLong(this.getDatetime());
		dos.writeFloat(this.getSwap());
		dos.writeFloat(this.getVolumeRatio());
		dos.writeFloat(this.getEntrustRatio());
		dos.writeFloat(this.getVelocityRatio());
		dos.writeFloat(this.getSwing());
		dos.writeLong(this.getInSide());
		dos.writeLong(this.getOutSide());
		dos.writeLong(this.getCurVolume());
		dos.writeUTF(this.getStockCode());
		
		dos.writeUTF(this.getCurrency()== null ? "":this.getCurrency());
		dos.writeUTF(this.getCnName()  == null ? "":this.getCnName());
		dos.writeUTF(this.getEnName() == null?"":this.getEnName());
		dos.writeFloat(this.PBration);
		dos.writeDouble(this.last5MinPrice);
		dos.writeDouble(this.last3MinPrice);
		dos.writeDouble(this.last1MinPrice);
		dos.writeDouble(this.fiveDaysMinuteVolumeAvg);
		dos.writeLong(this.totalAsk);
		dos.writeLong(this.totalBid);
		dos.writeDouble(this.floatTotalMarketCap);
		dos.writeByte(this.commonRdp);
		dos.writeByte(this.commonOldRdp);
		dos.writeInt(this.tradeCount);
		dos.writeLong(this.weicha);
		dos.writeDouble(this.riseLimitPrice);
		dos.writeDouble(this.declientLimitPrice);
		dos.writeDouble(this.tradeAmountIn);
		dos.writeDouble(this.tradeAmountOut);
		dos.writeLong(this.tradeVolIn);
		dos.writeLong(this.tradeVolOut);
		dos.writeUTF(this.getSecurityPreName() == null ? "":this.getSecurityPreName());
		dos.writeByte(this.getSecurityProperties());
		int skipSize=650-(dos.size()-beginSize);
		if(version == 2){
			skipSize=1024-(dos.size()-beginSize);
		}
		for(int i=0;i<skipSize;i++){
			dos.writeByte(0);
		}
    }
  
    public void readData(DataInputStream dis, int version) throws IOException {
    	int beginSize=dis.available();
		this.setLastPrice(dis.readDouble());
		this.setPreClose(dis.readDouble());
		this.setTodayOpen(dis.readDouble());
		this.setTodayClose(dis.readDouble());
		this.setBid(dis.readDouble());
		this.setAsk(dis.readDouble());
		this.setBidSpread(dis.readDouble());
		this.setAskSpread(dis.readDouble());
		this.setAskPrice1(dis.readDouble());
		this.setAskVolume1(dis.readLong());
		this.setAskPrice2(dis.readDouble());
		this.setAskVolume2(dis.readLong());
		this.setAskPrice3(dis.readDouble());
		this.setAskVolume3(dis.readLong());
		this.setAskPrice4(dis.readDouble());
		this.setAskVolume4(dis.readLong());
		this.setAskPrice5(dis.readDouble());
		this.setAskVolume5(dis.readLong());
		this.setBidPrice1(dis.readDouble());
		this.setBidVolume1(dis.readLong());
		this.setBidPrice2(dis.readDouble());
		this.setBidVolume2(dis.readLong());
		this.setBidPrice3(dis.readDouble());
		this.setBidVolume3(dis.readLong());
		this.setBidPrice4(dis.readDouble());
		this.setBidVolume4(dis.readLong());
		this.setBidPrice5(dis.readDouble());
		this.setBidVolume5(dis.readLong());
		this.setHighPrice(dis.readDouble());
		this.setLowPrice(dis.readDouble());
		this.setNetChange(dis.readDouble());
		this.setNetChangeRation(dis.readFloat());
		this.setVolume(dis.readLong());
		this.setTurnOver(dis.readDouble());
		this.setYearHigh(dis.readDouble());
		this.setYearLow(dis.readDouble());
		this.setPeRatio(dis.readFloat());
		this.setYield(dis.readFloat());
		this.setLotSize(dis.readInt());
		this.setMarketCap(dis.readDouble());
		this.setSuspend(dis.readBoolean());
		this.setExpiredate(dis.readLong());
		this.setPremium(dis.readDouble());
		this.setGearingRatio(dis.readFloat());
		this.setConvPrice(dis.readDouble());
		this.setConvRation(dis.readFloat());
		this.setDatetime(dis.readLong());
		this.setSwap(dis.readFloat());
		this.setVolumeRatio(dis.readFloat());
		this.setEntrustRatio(dis.readFloat());
		this.setVelocityRatio(dis.readFloat());
		this.setSwing(dis.readFloat());
		this.setInSide(dis.readLong());
		this.setOutSide(dis.readLong());
		this.setCurVolume(dis.readLong());
		this.setStockCode(dis.readUTF());
		this.setCurrency(dis.readUTF());
		this.setCnName(dis.readUTF());
		this.setEnName(dis.readUTF());
		this.setPBration(dis.readFloat());
		this.last5MinPrice = dis.readDouble();
		this.last3MinPrice = dis.readDouble();
		this.last1MinPrice = dis.readDouble();
		this.setFiveDaysMinuteVolumeAvg(dis.readDouble());
		this.setTotalAsk(dis.readLong());
		this.setTotalBid(dis.readLong());
		this.setFloatTotalMarketCap(dis.readDouble());
		this.setCommonRdp(dis.readByte());
		this.setCommonOldRdp(dis.readByte());
		this.setTradeCount(dis.readInt());
		this.setWeicha(dis.readLong());
		this.setRiseLimitPrice(dis.readDouble());
		this.setDeclientLimitPrice(dis.readDouble());
		this.setTradeAmountIn(dis.readDouble());
		this.setTradeAmountOut(dis.readDouble());
		this.setTradeVolIn(dis.readLong());
		this.setTradeVolOut(dis.readLong());
		this.setSecurityPreName(dis.readUTF());
		this.setSecurityProperties(dis.readByte());
		int skipSize=650-(beginSize-dis.available());
		if(version == 2){
			skipSize=1024-(beginSize-dis.available());
		}
		dis.skipBytes(skipSize);
    }
}
