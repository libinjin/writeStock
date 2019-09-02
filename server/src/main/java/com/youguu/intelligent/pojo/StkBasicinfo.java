package com.youguu.intelligent.pojo;

import java.util.Date;

public class StkBasicinfo {
    /**
     * 
     */
    private Long id;

    /**
     * 
     */
    private Long secucode;

    /**
     * 
     */
    private Long comcode;

    /**
     * 
     */
    private String tradingcode;

    /**
     * 
     */
    private String secuabbr;

    /**
     * 
     */
    private String chiname;

    /**
     * 
     */
    private String chinameabbr;

    /**
     * 
     */
    private String chispelling;

    /**
     * 
     */
    private String engname;

    /**
     * 
     */
    private String engnameabbr;

    /**
     * 
     */
    private Long secucategorycodei;

    /**
     * 
     */
    private Long secucategorycodeii;

    /**
     * 
     */
    private String secucategory;

    /**
     * 
     */
    private Long exchangecode;

    /**
     * 
     */
    private String exchangename;

    /**
     * 
     */
    private Date listingdate;

    /**
     * 
     */
    private Date delistingdate;

    /**
     * 
     */
    private Long boardcode;

    /**
     * 
     */
    private String boardname;

    /**
     * 
     */
    private Long listingstatecode;

    /**
     * 
     */
    private Long currencycode;

    /**
     * 
     */
    private String isin;

    /**
     * 
     */
    private Date entrytime;

    /**
     * 
     */
    private Date updatetime;

    /**
     * 
     */
    private Date groundtime;

    /**
     * 
     */
    private Long updateid;

    /**
     * 
     */
    private String resourceid;

    /**
     * 
     */
    private String recordid;

    public StkBasicinfo(Long id, Long secucode, Long comcode, String tradingcode, String secuabbr, String chiname, String chinameabbr, String chispelling, String engname, String engnameabbr, Long secucategorycodei, Long secucategorycodeii, String secucategory, Long exchangecode, String exchangename, Date listingdate, Date delistingdate, Long boardcode, String boardname, Long listingstatecode, Long currencycode, String isin, Date entrytime, Date updatetime, Date groundtime, Long updateid, String resourceid, String recordid) {
        this.id = id;
        this.secucode = secucode;
        this.comcode = comcode;
        this.tradingcode = tradingcode;
        this.secuabbr = secuabbr;
        this.chiname = chiname;
        this.chinameabbr = chinameabbr;
        this.chispelling = chispelling;
        this.engname = engname;
        this.engnameabbr = engnameabbr;
        this.secucategorycodei = secucategorycodei;
        this.secucategorycodeii = secucategorycodeii;
        this.secucategory = secucategory;
        this.exchangecode = exchangecode;
        this.exchangename = exchangename;
        this.listingdate = listingdate;
        this.delistingdate = delistingdate;
        this.boardcode = boardcode;
        this.boardname = boardname;
        this.listingstatecode = listingstatecode;
        this.currencycode = currencycode;
        this.isin = isin;
        this.entrytime = entrytime;
        this.updatetime = updatetime;
        this.groundtime = groundtime;
        this.updateid = updateid;
        this.resourceid = resourceid;
        this.recordid = recordid;
    }

    public StkBasicinfo() {
        super();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getSecucode() {
        return secucode;
    }

    public void setSecucode(Long secucode) {
        this.secucode = secucode;
    }

    public Long getComcode() {
        return comcode;
    }

    public void setComcode(Long comcode) {
        this.comcode = comcode;
    }

    public String getTradingcode() {
        return tradingcode;
    }

    public void setTradingcode(String tradingcode) {
        this.tradingcode = tradingcode == null ? null : tradingcode.trim();
    }

    public String getSecuabbr() {
        return secuabbr;
    }

    public void setSecuabbr(String secuabbr) {
        this.secuabbr = secuabbr == null ? null : secuabbr.trim();
    }

    public String getChiname() {
        return chiname;
    }

    public void setChiname(String chiname) {
        this.chiname = chiname == null ? null : chiname.trim();
    }

    public String getChinameabbr() {
        return chinameabbr;
    }

    public void setChinameabbr(String chinameabbr) {
        this.chinameabbr = chinameabbr == null ? null : chinameabbr.trim();
    }

    public String getChispelling() {
        return chispelling;
    }

    public void setChispelling(String chispelling) {
        this.chispelling = chispelling == null ? null : chispelling.trim();
    }

    public String getEngname() {
        return engname;
    }

    public void setEngname(String engname) {
        this.engname = engname == null ? null : engname.trim();
    }

    public String getEngnameabbr() {
        return engnameabbr;
    }

    public void setEngnameabbr(String engnameabbr) {
        this.engnameabbr = engnameabbr == null ? null : engnameabbr.trim();
    }

    public Long getSecucategorycodei() {
        return secucategorycodei;
    }

    public void setSecucategorycodei(Long secucategorycodei) {
        this.secucategorycodei = secucategorycodei;
    }

    public Long getSecucategorycodeii() {
        return secucategorycodeii;
    }

    public void setSecucategorycodeii(Long secucategorycodeii) {
        this.secucategorycodeii = secucategorycodeii;
    }

    public String getSecucategory() {
        return secucategory;
    }

    public void setSecucategory(String secucategory) {
        this.secucategory = secucategory == null ? null : secucategory.trim();
    }

    public Long getExchangecode() {
        return exchangecode;
    }

    public void setExchangecode(Long exchangecode) {
        this.exchangecode = exchangecode;
    }

    public String getExchangename() {
        return exchangename;
    }

    public void setExchangename(String exchangename) {
        this.exchangename = exchangename == null ? null : exchangename.trim();
    }

    public Date getListingdate() {
        return listingdate;
    }

    public void setListingdate(Date listingdate) {
        this.listingdate = listingdate;
    }

    public Date getDelistingdate() {
        return delistingdate;
    }

    public void setDelistingdate(Date delistingdate) {
        this.delistingdate = delistingdate;
    }

    public Long getBoardcode() {
        return boardcode;
    }

    public void setBoardcode(Long boardcode) {
        this.boardcode = boardcode;
    }

    public String getBoardname() {
        return boardname;
    }

    public void setBoardname(String boardname) {
        this.boardname = boardname == null ? null : boardname.trim();
    }

    public Long getListingstatecode() {
        return listingstatecode;
    }

    public void setListingstatecode(Long listingstatecode) {
        this.listingstatecode = listingstatecode;
    }

    public Long getCurrencycode() {
        return currencycode;
    }

    public void setCurrencycode(Long currencycode) {
        this.currencycode = currencycode;
    }

    public String getIsin() {
        return isin;
    }

    public void setIsin(String isin) {
        this.isin = isin == null ? null : isin.trim();
    }

    public Date getEntrytime() {
        return entrytime;
    }

    public void setEntrytime(Date entrytime) {
        this.entrytime = entrytime;
    }

    public Date getUpdatetime() {
        return updatetime;
    }

    public void setUpdatetime(Date updatetime) {
        this.updatetime = updatetime;
    }

    public Date getGroundtime() {
        return groundtime;
    }

    public void setGroundtime(Date groundtime) {
        this.groundtime = groundtime;
    }

    public Long getUpdateid() {
        return updateid;
    }

    public void setUpdateid(Long updateid) {
        this.updateid = updateid;
    }

    public String getResourceid() {
        return resourceid;
    }

    public void setResourceid(String resourceid) {
        this.resourceid = resourceid == null ? null : resourceid.trim();
    }

    public String getRecordid() {
        return recordid;
    }

    public void setRecordid(String recordid) {
        this.recordid = recordid == null ? null : recordid.trim();
    }

    @Override
    public String toString() {
        return "StkBasicinfo{" +
                "id=" + id +
                ", secucode=" + secucode +
                ", comcode=" + comcode +
                ", tradingcode='" + tradingcode + '\'' +
                ", secuabbr='" + secuabbr + '\'' +
                ", chiname='" + chiname + '\'' +
                ", chinameabbr='" + chinameabbr + '\'' +
                ", chispelling='" + chispelling + '\'' +
                ", engname='" + engname + '\'' +
                ", engnameabbr='" + engnameabbr + '\'' +
                ", secucategorycodei=" + secucategorycodei +
                ", secucategorycodeii=" + secucategorycodeii +
                ", secucategory='" + secucategory + '\'' +
                ", exchangecode=" + exchangecode +
                ", exchangename='" + exchangename + '\'' +
                ", listingdate=" + listingdate +
                ", delistingdate=" + delistingdate +
                ", boardcode=" + boardcode +
                ", boardname='" + boardname + '\'' +
                ", listingstatecode=" + listingstatecode +
                ", currencycode=" + currencycode +
                ", isin='" + isin + '\'' +
                ", entrytime=" + entrytime +
                ", updatetime=" + updatetime +
                ", groundtime=" + groundtime +
                ", updateid=" + updateid +
                ", resourceid='" + resourceid + '\'' +
                ", recordid='" + recordid + '\'' +
                '}';
    }
}