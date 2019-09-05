package com.youguu.intelligent.second.excel;

public class Market {

    private String firstSort;

    private String secondSort;

    private String stockCode;

    private String stockName;

    public Market(String firstSort, String secondSort, String stockCode, String stockName) {
        this.firstSort = firstSort;
        this.secondSort = secondSort;
        this.stockCode = stockCode;
        this.stockName = stockName;
    }

    public String getFirstSort() {
        return firstSort;
    }

    public void setFirstSort(String firstSort) {
        this.firstSort = firstSort;
    }

    public String getSecondSort() {
        return secondSort;
    }

    public void setSecondSort(String secondSort) {
        this.secondSort = secondSort;
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


}
