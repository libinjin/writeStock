package com.youguu.intelligent.pojo;

import java.util.Date;

public class QuoteInfo {

    public final static int MARKET_TYPE_SH = 0;
    public final static int MARKET_TYPE_SZ = 2;

    public final static int TYPE_STOCK = 0;
    public final static int TYPE_FUND = 1;

    /**
     * 数据时间
     */
    public Date time;

    /**
     * 名称
     */
    public String name = "";

    /**
     * 代码
     */
    public String code;

    /**
     * 前收盘价
     */
    public double closePrice;

    /**
     * 今开盘价
     */
    public double openPrice;

    /**
     * 最高价
     */
    public double highPrice;

    /**
     * 最低价
     */
    public double lowPrice;

    /**
     * 最新价
     */
    public double curPrice;

    /**
     * 总成交额
     */
    public double totalMoney;

    /**
     * 总成交量
     */
    public long totalAmount;


    /**
     * 股票：买入价1；指数：涨数
     */
    public double buyPrice1;

    /**
     * 股票：卖出价1；指数： 跌数
     */
    public double sellPrice1;

    /**
     * 买入量1；指数：总申买量
     */
    public int buyAmount1;

    /**
     * 卖出量1；指数：总申卖量
     */
    public int sellAmount1;

    /**
     * 买入价2
     */
    public double buyPrice2;

    /**
     * 卖出价2
     */
    public double sellPrice2;

    /**
     * 买入量2
     */
    public int buyAmount2;

    /**
     * 卖出量2
     */
    public int sellAmount2;

    /**
     * 买入价3
     */
    public double buyPrice3;

    /**
     * 卖出价3
     */
    public double sellPrice3;

    /**
     * 买入量3
     */
    public int buyAmount3;

    /**
     * 卖出量3
     */
    public int sellAmount3;

    /**
     * 买入价4
     */
    public double buyPrice4;

    /**
     * 卖出价4
     */
    public double sellPrice4;

    /**
     * 买入量4
     */
    public int buyAmount4;

    /**
     * 卖出量4
     */
    public int sellAmount4;

    /**
     * 买入价5
     */
    public double buyPrice5;

    /**
     * 卖出价5
     */
    public double sellPrice5;

    /**
     * 买入量5
     */
    public int buyAmount5;

    /**
     * 卖出量5
     */
    public int sellAmount5;

    /**
     * 量比
     */
    public double amountScale;

    /**
     * 是否停牌
     */
    public boolean isStop;

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public double getClosePrice() {
        return closePrice;
    }

    public void setClosePrice(double closePrice) {
        this.closePrice = closePrice;
    }

    public double getOpenPrice() {
        return openPrice;
    }

    public void setOpenPrice(double openPrice) {
        this.openPrice = openPrice;
    }

    public double getHighPrice() {
        return highPrice;
    }

    public void setHighPrice(double highPrice) {
        this.highPrice = highPrice;
    }

    public double getLowPrice() {
        return lowPrice;
    }

    public void setLowPrice(double lowPrice) {
        this.lowPrice = lowPrice;
    }

    public double getCurPrice() {
        return curPrice;
    }

    public void setCurPrice(double curPrice) {
        this.curPrice = curPrice;
    }

    public double getTotalMoney() {
        return totalMoney;
    }

    public void setTotalMoney(double totalMoney) {
        this.totalMoney = totalMoney;
    }

    public long getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(long totalAmount) {
        this.totalAmount = totalAmount;
    }

    public double getBuyPrice1() {
        return buyPrice1;
    }

    public void setBuyPrice1(double buyPrice1) {
        this.buyPrice1 = buyPrice1;
    }

    public double getSellPrice1() {
        return sellPrice1;
    }

    public void setSellPrice1(double sellPrice1) {
        this.sellPrice1 = sellPrice1;
    }

    public int getBuyAmount1() {
        return buyAmount1;
    }

    public void setBuyAmount1(int buyAmount1) {
        this.buyAmount1 = buyAmount1;
    }

    public int getSellAmount1() {
        return sellAmount1;
    }

    public void setSellAmount1(int sellAmount1) {
        this.sellAmount1 = sellAmount1;
    }

    public double getBuyPrice2() {
        return buyPrice2;
    }

    public void setBuyPrice2(double buyPrice2) {
        this.buyPrice2 = buyPrice2;
    }

    public double getSellPrice2() {
        return sellPrice2;
    }

    public void setSellPrice2(double sellPrice2) {
        this.sellPrice2 = sellPrice2;
    }


    public int getBuyAmount2() {
        return buyAmount2;
    }

    public void setBuyAmount2(int buyAmount2) {
        this.buyAmount2 = buyAmount2;
    }

    public int getSellAmount2() {
        return sellAmount2;
    }

    public void setSellAmount2(int sellAmount2) {
        this.sellAmount2 = sellAmount2;
    }

    public double getBuyPrice3() {
        return buyPrice3;
    }

    public void setBuyPrice3(double buyPrice3) {
        this.buyPrice3 = buyPrice3;
    }

    public double getSellPrice3() {
        return sellPrice3;
    }

    public void setSellPrice3(double sellPrice3) {
        this.sellPrice3 = sellPrice3;
    }

    public int getBuyAmount3() {
        return buyAmount3;
    }

    public void setBuyAmount3(int buyAmount3) {
        this.buyAmount3 = buyAmount3;
    }

    public int getSellAmount3() {
        return sellAmount3;
    }

    public void setSellAmount3(int sellAmount3) {
        this.sellAmount3 = sellAmount3;
    }

    public double getBuyPrice4() {
        return buyPrice4;
    }

    public void setBuyPrice4(double buyPrice4) {
        this.buyPrice4 = buyPrice4;
    }

    public double getSellPrice4() {
        return sellPrice4;
    }

    public void setSellPrice4(double sellPrice4) {
        this.sellPrice4 = sellPrice4;
    }

    public int getBuyAmount4() {
        return buyAmount4;
    }

    public void setBuyAmount4(int buyAmount4) {
        this.buyAmount4 = buyAmount4;
    }

    public int getSellAmount4() {
        return sellAmount4;
    }

    public void setSellAmount4(int sellAmount4) {
        this.sellAmount4 = sellAmount4;
    }

    public double getBuyPrice5() {
        return buyPrice5;
    }

    public void setBuyPrice5(double buyPrice5) {
        this.buyPrice5 = buyPrice5;
    }

    public double getSellPrice5() {
        return sellPrice5;
    }

    public void setSellPrice5(double sellPrice5) {
        this.sellPrice5 = sellPrice5;
    }

    public int getBuyAmount5() {
        return buyAmount5;
    }

    public void setBuyAmount5(int buyAmount5) {
        this.buyAmount5 = buyAmount5;
    }

    public int getSellAmount5() {
        return sellAmount5;
    }

    public void setSellAmount5(int sellAmount5) {
        this.sellAmount5 = sellAmount5;
    }

    public double getAmountScale() {
        return amountScale;
    }

    public void setAmountScale(double amountScale) {
        this.amountScale = amountScale;
    }

    public boolean isStop() {
        return isStop;
    }

    public void setStop(boolean stop) {
        isStop = stop;
    }


    @Override
    public String toString() {
        return "QuoteInfo{" +
                "time=" + time +
                ", name='" + name + '\'' +
                ", code='" + code + '\'' +
                ", closePrice=" + closePrice +
                ", openPrice=" + openPrice +
                ", highPrice=" + highPrice +
                ", lowPrice=" + lowPrice +
                ", curPrice=" + curPrice +
                ", totalMoney=" + totalMoney +
                ", totalAmount=" + totalAmount +
                ", buyPrice1=" + buyPrice1 +
                ", sellPrice1=" + sellPrice1 +
                ", buyAmount1=" + buyAmount1 +
                ", sellAmount1=" + sellAmount1 +
                ", buyPrice2=" + buyPrice2 +
                ", sellPrice2=" + sellPrice2 +
                ", buyAmount2=" + buyAmount2 +
                ", sellAmount2=" + sellAmount2 +
                ", buyPrice3=" + buyPrice3 +
                ", sellPrice3=" + sellPrice3 +
                ", buyAmount3=" + buyAmount3 +
                ", sellAmount3=" + sellAmount3 +
                ", buyPrice4=" + buyPrice4 +
                ", sellPrice4=" + sellPrice4 +
                ", buyAmount4=" + buyAmount4 +
                ", sellAmount4=" + sellAmount4 +
                ", buyPrice5=" + buyPrice5 +
                ", sellPrice5=" + sellPrice5 +
                ", buyAmount5=" + buyAmount5 +
                ", sellAmount5=" + sellAmount5 +
                ", amountScale=" + amountScale +
                ", isStop=" + isStop +
                '}';
    }
}
