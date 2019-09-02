package com.youguu.intelligent.pojo;

import java.io.Serializable;

public class MoneyFlow implements Serializable {

	/**
	* @Fields serialVersionUID : TODO(用一句话描述这个变量表示什么)
	*/
	
	private static final long serialVersionUID = 5488951882369458116L;

	String stockCode;
	
	long beginTime;
	
	long endTime;
	
	long littleBidTurnoverVol;
	
	double littleBidTurnoverVal;
	
	int littleBidTurnoverDeals;
	
	long midBidTurnoverVol;
	
	double midBidTurnoverVal;
	
	int midBidTurnoverDeals;
	
	long bigBidTurnoverVol;
	
	double bigBidTurnoverVal;
	
	int bigBidTurnoverDeals;
	
	long biggerBidTurnoverVol;
	
	double biggerBidTurnoverVal;
	
	int biggerBidTurnoverDeals;
	
	long littleAskTurnoverVol;
	
	double littleAskTurnoverVal;
	
	int littleAskTurnoverDeals;
	
	long midAskTurnoverVol;
	
	double midAskTurnoverVal;
	
	int midAskTurnoverDeals;
	
	long bigAskTurnoverVol;
	
	double bigAskTurnoverVal;
	
	int bigAskTurnoverDeals;
	
	long biggerAskTurnoverVol;
	
	double biggerAskTurnoverVal;
	
	int biggerAskTurnoverDeals;
	
	double totalBidVal;
	
	long totalBidVol;
	
	double totalAskVal;
	
	long totalAskVol;
	
	double netVal;
	
	long netVol;
	
	public String getStockCode() {
		return stockCode;
	}
	public void setStockCode(String stockCode) {
		this.stockCode = stockCode;
	}
	public long getBeginTime() {
		return beginTime;
	}
	public void setBeginTime(long beginTime) {
		this.beginTime = beginTime;
	}
	public long getEndTime() {
		return endTime;
	}
	public void setEndTime(long endTime) {
		this.endTime = endTime;
	}
	public long getLittleBidTurnoverVol() {
		return littleBidTurnoverVol;
	}
	public void setLittleBidTurnoverVol(long littleBidTurnoverVol) {
		this.littleBidTurnoverVol = littleBidTurnoverVol;
	}
	public double getLittleBidTurnoverVal() {
		return littleBidTurnoverVal;
	}
	public void setLittleBidTurnoverVal(double littleBidTurnoverVal) {
		this.littleBidTurnoverVal = littleBidTurnoverVal;
	}
	public int getLittleBidTurnoverDeals() {
		return littleBidTurnoverDeals;
	}
	public void setLittleBidTurnoverDeals(int littleBidTurnoverDeals) {
		this.littleBidTurnoverDeals = littleBidTurnoverDeals;
	}
	public long getMidBidTurnoverVol() {
		return midBidTurnoverVol;
	}
	public void setMidBidTurnoverVol(long midBidTurnoverVol) {
		this.midBidTurnoverVol = midBidTurnoverVol;
	}
	public double getMidBidTurnoverVal() {
		return midBidTurnoverVal;
	}
	public void setMidBidTurnoverVal(double midBidTurnoverVal) {
		this.midBidTurnoverVal = midBidTurnoverVal;
	}
	public int getMidBidTurnoverDeals() {
		return midBidTurnoverDeals;
	}
	public void setMidBidTurnoverDeals(int midBidTurnoverDeals) {
		this.midBidTurnoverDeals = midBidTurnoverDeals;
	}
	public long getBigBidTurnoverVol() {
		return bigBidTurnoverVol;
	}
	public void setBigBidTurnoverVol(long bigBidTurnoverVol) {
		this.bigBidTurnoverVol = bigBidTurnoverVol;
	}
	public double getBigBidTurnoverVal() {
		return bigBidTurnoverVal;
	}
	public void setBigBidTurnoverVal(double bigBidTurnoverVal) {
		this.bigBidTurnoverVal = bigBidTurnoverVal;
	}
	public int getBigBidTurnoverDeals() {
		return bigBidTurnoverDeals;
	}
	public void setBigBidTurnoverDeals(int bigBidTurnoverDeals) {
		this.bigBidTurnoverDeals = bigBidTurnoverDeals;
	}
	public long getBiggerBidTurnoverVol() {
		return biggerBidTurnoverVol;
	}
	public void setBiggerBidTurnoverVol(long biggerBidTurnoverVol) {
		this.biggerBidTurnoverVol = biggerBidTurnoverVol;
	}
	public double getBiggerBidTurnoverVal() {
		return biggerBidTurnoverVal;
	}
	public void setBiggerBidTurnoverVal(double biggerBidTurnoverVal) {
		this.biggerBidTurnoverVal = biggerBidTurnoverVal;
	}
	public int getBiggerBidTurnoverDeals() {
		return biggerBidTurnoverDeals;
	}
	public void setBiggerBidTurnoverDeals(int biggerBidTurnoverDeals) {
		this.biggerBidTurnoverDeals = biggerBidTurnoverDeals;
	}
	public long getLittleAskTurnoverVol() {
		return littleAskTurnoverVol;
	}
	public void setLittleAskTurnoverVol(long littleAskTurnoverVol) {
		this.littleAskTurnoverVol = littleAskTurnoverVol;
	}
	public double getLittleAskTurnoverVal() {
		return littleAskTurnoverVal;
	}
	public void setLittleAskTurnoverVal(double littleAskTurnoverVal) {
		this.littleAskTurnoverVal = littleAskTurnoverVal;
	}
	public int getLittleAskTurnoverDeals() {
		return littleAskTurnoverDeals;
	}
	public void setLittleAskTurnoverDeals(int littleAskTurnoverDeals) {
		this.littleAskTurnoverDeals = littleAskTurnoverDeals;
	}
	public long getMidAskTurnoverVol() {
		return midAskTurnoverVol;
	}
	public void setMidAskTurnoverVol(long midAskTurnoverVol) {
		this.midAskTurnoverVol = midAskTurnoverVol;
	}
	public double getMidAskTurnoverVal() {
		return midAskTurnoverVal;
	}
	public void setMidAskTurnoverVal(double midAskTurnoverVal) {
		this.midAskTurnoverVal = midAskTurnoverVal;
	}
	public int getMidAskTurnoverDeals() {
		return midAskTurnoverDeals;
	}
	public void setMidAskTurnoverDeals(int midAskTurnoverDeals) {
		this.midAskTurnoverDeals = midAskTurnoverDeals;
	}
	public long getBigAskTurnoverVol() {
		return bigAskTurnoverVol;
	}
	public void setBigAskTurnoverVol(long bigAskTurnoverVol) {
		this.bigAskTurnoverVol = bigAskTurnoverVol;
	}
	public double getBigAskTurnoverVal() {
		return bigAskTurnoverVal;
	}
	public void setBigAskTurnoverVal(double bigAskTurnoverVal) {
		this.bigAskTurnoverVal = bigAskTurnoverVal;
	}
	public int getBigAskTurnoverDeals() {
		return bigAskTurnoverDeals;
	}
	public void setBigAskTurnoverDeals(int bigAskTurnoverDeals) {
		this.bigAskTurnoverDeals = bigAskTurnoverDeals;
	}
	public long getBiggerAskTurnoverVol() {
		return biggerAskTurnoverVol;
	}
	public void setBiggerAskTurnoverVol(long biggerAskTurnoverVol) {
		this.biggerAskTurnoverVol = biggerAskTurnoverVol;
	}
	public double getBiggerAskTurnoverVal() {
		return biggerAskTurnoverVal;
	}
	public void setBiggerAskTurnoverVal(double biggerAskTurnoverVal) {
		this.biggerAskTurnoverVal = biggerAskTurnoverVal;
	}
	public int getBiggerAskTurnoverDeals() {
		return biggerAskTurnoverDeals;
	}
	public void setBiggerAskTurnoverDeals(int biggerAskTurnoverDeals) {
		this.biggerAskTurnoverDeals = biggerAskTurnoverDeals;
	}
	public double getTotalBidVal() {
		return totalBidVal;
	}
	public void setTotalBidVal(double totalBidVal) {
		this.totalBidVal = totalBidVal;
	}
	public long getTotalBidVol() {
		return totalBidVol;
	}
	public void setTotalBidVol(long totalBidVol) {
		this.totalBidVol = totalBidVol;
	}
	public double getTotalAskVal() {
		return totalAskVal;
	}
	public void setTotalAskVal(double totalAskVal) {
		this.totalAskVal = totalAskVal;
	}
	public long getTotalAskVol() {
		return totalAskVol;
	}
	public void setTotalAskVol(long totalAskVol) {
		this.totalAskVol = totalAskVol;
	}
	public double getNetVal() {
		return netVal;
	}
	public void setNetVal(double netVal) {
		this.netVal = netVal;
	}
	public long getNetVol() {
		return netVol;
	}
	public void setNetVol(long netVol) {
		this.netVol = netVol;
	}

	@Override
	public String toString() {
		return "MoneyFlow{" +
				"stockCode='" + stockCode + '\'' +
				", beginTime=" + beginTime +
				", endTime=" + endTime +
				", littleBidTurnoverVol=" + littleBidTurnoverVol +
				", littleBidTurnoverVal=" + littleBidTurnoverVal +
				", littleBidTurnoverDeals=" + littleBidTurnoverDeals +
				", midBidTurnoverVol=" + midBidTurnoverVol +
				", midBidTurnoverVal=" + midBidTurnoverVal +
				", midBidTurnoverDeals=" + midBidTurnoverDeals +
				", bigBidTurnoverVol=" + bigBidTurnoverVol +
				", bigBidTurnoverVal=" + bigBidTurnoverVal +
				", bigBidTurnoverDeals=" + bigBidTurnoverDeals +
				", biggerBidTurnoverVol=" + biggerBidTurnoverVol +
				", biggerBidTurnoverVal=" + biggerBidTurnoverVal +
				", biggerBidTurnoverDeals=" + biggerBidTurnoverDeals +
				", littleAskTurnoverVol=" + littleAskTurnoverVol +
				", littleAskTurnoverVal=" + littleAskTurnoverVal +
				", littleAskTurnoverDeals=" + littleAskTurnoverDeals +
				", midAskTurnoverVol=" + midAskTurnoverVol +
				", midAskTurnoverVal=" + midAskTurnoverVal +
				", midAskTurnoverDeals=" + midAskTurnoverDeals +
				", bigAskTurnoverVol=" + bigAskTurnoverVol +
				", bigAskTurnoverVal=" + bigAskTurnoverVal +
				", bigAskTurnoverDeals=" + bigAskTurnoverDeals +
				", biggerAskTurnoverVol=" + biggerAskTurnoverVol +
				", biggerAskTurnoverVal=" + biggerAskTurnoverVal +
				", biggerAskTurnoverDeals=" + biggerAskTurnoverDeals +
				", totalBidVal=" + totalBidVal +
				", totalBidVol=" + totalBidVol +
				", totalAskVal=" + totalAskVal +
				", totalAskVol=" + totalAskVol +
				", netVal=" + netVal +
				", netVol=" + netVol +
				'}';
	}
}
