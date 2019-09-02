package com.youguu.intelligent.pojo;

import java.util.Date;

/**
 * 股东总数
 */
public class TotalNum {

    private Long comcode;

    private Date enddate;

    private long totalSh;

    public Long getComcode() {
        return comcode;
    }

    public void setComcode(Long comcode) {
        this.comcode = comcode;
    }

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

    @Override
    public String toString() {
        return "TotalNum{" +
                "comcode=" + comcode +
                ", enddate=" + enddate +
                ", totalSh=" + totalSh +
                '}';
    }
}
