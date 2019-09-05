package com.youguu.intelligent.second;

public class MarkertPer {

    private int rank;

    private String market;

    private double changePercent;

    public MarkertPer(int rank, String market, double changePercent) {
        this.rank = rank;
        this.market = market;
        this.changePercent = changePercent;
    }

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    public String getMarket() {
        return market;
    }

    public void setMarket(String market) {
        this.market = market;
    }

    public double getChangePercent() {
        return changePercent;
    }

    public void setChangePercent(double changePercent) {
        this.changePercent = changePercent;
    }
}
