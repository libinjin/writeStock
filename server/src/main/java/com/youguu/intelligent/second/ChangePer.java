package com.youguu.intelligent.second;


public class ChangePer {

    private String stockCode;

    private double changePercent;

    private long date;


    public ChangePer(String stockCode, double changePercent, long date) {
        this.stockCode = stockCode;
        this.changePercent = changePercent;
        this.date = date;
    }

    public double getChangePercent() {
        return changePercent;
    }

    public void setChangePercent(double changePercent) {
        this.changePercent = changePercent;
    }

    public long getDate() {
        return date;
    }

    public void setDate(long date) {
        this.date = date;
    }

    public String getStockCode() {
        return stockCode;
    }

    public void setStockCode(String stockCode) {
        this.stockCode = stockCode;
    }

    @Override
    public String toString() {
        return "ChangePer{" +
                "stockCode='" + stockCode + '\'' +
                ", changePercent=" + changePercent +
                ", date=" + date +
                '}';
    }
}
