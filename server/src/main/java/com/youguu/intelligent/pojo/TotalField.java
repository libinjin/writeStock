package com.youguu.intelligent.pojo;


import java.util.Date;

public class TotalField {

    private String stockCode;

    private String stockName;

    private Long comcode;

    /**
     * 净利润
     */
    private double netprofit;

    /**
     * 营业收入
     */
    private double operrevenue;

    /**
     * 总资产收益率
     */
    private double netcashflowoper;

    /**
     * 净资产收益率
     */
    private double roe;

    /**
     * 总资产收益率
     */
    private double roa;

    /**
     * 资产负债率
     */
    private double tltota;

    /**
     * 流动比率
     */
    private double currentratio;

    /**
     * 毛利率
     */
    private double grossprofitmargin;

    /**
     * 总资产周转率
     */
    private double totalassetturnover;

    /**
     * 总股本
     */
    private double totalshare;


    /**
     * 资产总计
     */
    private double totalasset;

    /**
     * 负债合计
     */
    private double totalliab;

    /**
     * 非流动负债合计
     */
    private double totalnoncurliab;

    /**
     * 股东总数
     */
    private long totalSh;

    /**
     * 截止日期
     */
    private Date enddate;

    //30日收入金额


    //30日流出金额

    public Date getEnddate() {
        return enddate;
    }

    public void setEnddate(Date enddate) {
        this.enddate = enddate;
    }

    public long getTotalSh() {
        return totalSh;
    }

    public void setTotalSh(long totalSh) {
        this.totalSh = totalSh;
    }

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

    public Long getComcode() {
        return comcode;
    }

    public void setComcode(Long comcode) {
        this.comcode = comcode;
    }

    public double getNetprofit() {
        return netprofit;
    }

    public void setNetprofit(double netprofit) {
        this.netprofit = netprofit;
    }

    public double getOperrevenue() {
        return operrevenue;
    }

    public void setOperrevenue(double operrevenue) {
        this.operrevenue = operrevenue;
    }

    public double getNetcashflowoper() {
        return netcashflowoper;
    }

    public void setNetcashflowoper(double netcashflowoper) {
        this.netcashflowoper = netcashflowoper;
    }

    public double getRoe() {
        return roe;
    }

    public void setRoe(double roe) {
        this.roe = roe;
    }

    public double getRoa() {
        return roa;
    }

    public void setRoa(double roa) {
        this.roa = roa;
    }

    public double getTltota() {
        return tltota;
    }

    public void setTltota(double tltota) {
        this.tltota = tltota;
    }

    public double getCurrentratio() {
        return currentratio;
    }

    public void setCurrentratio(double currentratio) {
        this.currentratio = currentratio;
    }

    public double getGrossprofitmargin() {
        return grossprofitmargin;
    }

    public void setGrossprofitmargin(double grossprofitmargin) {
        this.grossprofitmargin = grossprofitmargin;
    }

    public double getTotalassetturnover() {
        return totalassetturnover;
    }

    public void setTotalassetturnover(double totalassetturnover) {
        this.totalassetturnover = totalassetturnover;
    }

    public double getTotalshare() {
        return totalshare;
    }

    public void setTotalshare(double totalshare) {
        this.totalshare = totalshare;
    }

    public double getTotalasset() {
        return totalasset;
    }

    public void setTotalasset(double totalasset) {
        this.totalasset = totalasset;
    }

    public double getTotalliab() {
        return totalliab;
    }

    public void setTotalliab(double totalliab) {
        this.totalliab = totalliab;
    }

    public double getTotalnoncurliab() {
        return totalnoncurliab;
    }

    public void setTotalnoncurliab(double totalnoncurliab) {
        this.totalnoncurliab = totalnoncurliab;
    }

    @Override
    public String toString() {
        return "TotalField{" +
                "stockCode='" + stockCode + '\'' +
                ", stockName='" + stockName + '\'' +
                ", comcode=" + comcode +
                ", netprofit=" + netprofit +
                ", operrevenue=" + operrevenue +
                ", netcashflowoper=" + netcashflowoper +
                ", roe=" + roe +
                ", roa=" + roa +
                ", tltota=" + tltota +
                ", currentratio=" + currentratio +
                ", grossprofitmargin=" + grossprofitmargin +
                ", totalassetturnover=" + totalassetturnover +
                ", totalshare=" + totalshare +
                ", totalasset=" + totalasset +
                ", totalliab=" + totalliab +
                ", totalnoncurliab=" + totalnoncurliab +
                ", totalSh=" + totalSh +
                '}';
    }
}
