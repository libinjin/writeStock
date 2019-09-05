package com.youguu.intelligent.pojo;

import java.util.Date;

/**
 * 静态数据
 */
public class IntelligentStock {

    /**
     * 股票代码6位
     */
    private String stockCode;

    /**
     * 股票名称
     */
    private String stockName;

    /**
     * 每股收益
     */
    private double eps;

    /**
     * 每股净资产
     */
    private double bvps;

    /**
     * 每股现金流量
     */
    private double netCashFlowps;

    /**
     * 总负债
     */
    private double totalLiab;

    /**
     * 总资产
     */
    private double totalAsset;

    /**
     * A股总股本数
     */
    private long AtotalShare;

    /**
     * A股流通总股数
     */
    private long AlistedShare;

    /**
     * 3日资金净流入流出情况 1：资金净流入大于资金净流出 -1：资金净流入小于资金净流出
     */
    private int fundFlow3;

    /**
     * 5日资金净流入流出情况 1：资金净流入大于资金净流出 -1：资金净流入小于资金净流出
     */
    private int fundFlow5;

    /**
     * 10日资金净流入流出情况 1：资金净流入大于资金净流出 -1：资金净流入小于资金净流出
     */
    private int fundFlow10;

    /**
     * 21日资金净流入流出情况 1：资金净流入大于资金净流出 -1：资金净流入小于资金净流出
     */
    private int fundFlow21;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 修改时间
     */
    private Date updateTime;

    /**
     * 年每股收益
     */
    private double epsYear;

    public String getStockCode() {
        return stockCode;
    }

    public void setStockCode(String stockCode) {
        this.stockCode = stockCode;
    }

    public String getStockName() {
        return stockName;
    }

    public void setStockName(String stockName) {
        this.stockName = stockName;
    }

    public double getEps() {
        return eps;
    }

    public void setEps(double eps) {
        this.eps = eps;
    }

    public double getBvps() {
        return bvps;
    }

    public void setBvps(double bvps) {
        this.bvps = bvps;
    }

    public double getNetCashFlowps() {
        return netCashFlowps;
    }

    public void setNetCashFlowps(double netCashFlowps) {
        this.netCashFlowps = netCashFlowps;
    }

    public double getTotalLiab() {
        return totalLiab;
    }

    public void setTotalLiab(double totalLiab) {
        this.totalLiab = totalLiab;
    }

    public double getTotalAsset() {
        return totalAsset;
    }

    public void setTotalAsset(double totalAsset) {
        this.totalAsset = totalAsset;
    }


    public long getAtotalShare() {
        return AtotalShare;
    }

    public void setAtotalShare(long atotalShare) {
        AtotalShare = atotalShare;
    }

    public long getAlistedShare() {
        return AlistedShare;
    }

    public void setAlistedShare(long alistedShare) {
        AlistedShare = alistedShare;
    }

    public int getFundFlow3() {
        return fundFlow3;
    }

    public void setFundFlow3(int fundFlow3) {
        this.fundFlow3 = fundFlow3;
    }

    public int getFundFlow5() {
        return fundFlow5;
    }

    public void setFundFlow5(int fundFlow5) {
        this.fundFlow5 = fundFlow5;
    }

    public int getFundFlow10() {
        return fundFlow10;
    }

    public void setFundFlow10(int fundFlow10) {
        this.fundFlow10 = fundFlow10;
    }

    public int getFundFlow21() {
        return fundFlow21;
    }

    public void setFundFlow21(int fundFlow21) {
        this.fundFlow21 = fundFlow21;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public double getEpsYear() {
        return epsYear;
    }

    public void setEpsYear(double epsYear) {
        this.epsYear = epsYear;
    }

    @Override
    public String toString() {
        return "IntelligentStock{" +
                "stockCode='" + stockCode + '\'' +
                ", stockName='" + stockName + '\'' +
                ", eps=" + eps +
                ", bvps=" + bvps +
                ", netCashFlowps=" + netCashFlowps +
                ", totalLiab=" + totalLiab +
                ", totalAsset=" + totalAsset +
                ", AtotalShare=" + AtotalShare +
                ", AlistedShare=" + AlistedShare +
                ", fundFlow3=" + fundFlow3 +
                ", fundFlow5=" + fundFlow5 +
                ", fundFlow10=" + fundFlow10 +
                ", fundFlow21=" + fundFlow21 +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                ", epsYear=" + epsYear +
                '}';
    }



}
