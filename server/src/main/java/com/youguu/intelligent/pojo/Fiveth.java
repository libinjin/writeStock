package com.youguu.intelligent.pojo;


import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import java.util.Date;

public class Fiveth {
    /**
     * TotalShare、TotalAsset
     */
    private Long id;

    /**
     * 
     */
    private Long comcode;

    /**
     * 
     */
    private String infosource;

    /**
     * 
     */
    private Date pubdate;

    /**
     * 
     */
    private Date startdate;

    /**
     * 
     */
    private Date enddate;

    /**
     * 
     */
    private Long reporttype;

    /**
     * 
     */
    private Long standardcode;

    /**
     * 
     */
    private Long dataflag;

    /**
     * 
     */
    private Long comnature;

    /**
     * 
     */
    private Long currencycode;

    /**
     * 
     */
    private double operrevenue;

    /**
     * 
     */
    private double operprofit;

    /**
     * 
     */
    private double totalprofit;

    /**
     * 
     */
    private double netprofitparentcom;

    /**
     * 
     */
    private double netprofitcutparentcom;

    /**
     * 
     */
    private double basiceps;

    /**
     * 
     */
    private double dilutedeps;

    /**
     * 
     */
    private double cutbasiceps;

    /**
     * 
     */
    private double roe;

    /**
     * 
     */
    private double weightedroe;

    /**
     * 
     */
    private double cutweightedroe;

    /**
     * 
     */
    private double cutroe;

    /**
     * 
     */
    private double netcashflowoper;

    /**
     * 
     */
    private double netcashflowoperps;

    /**
     * 
     */
    private double totalshequity;

    /**
     * 
     */
    private double shequityparentcom;

    /**
     * 
     */
    private double bvps;

    /**
     * 
     */
    private double totalshare;

    /**
     * 
     */
    private double totalcurasset;

    /**
     * 
     */
    private double totalnoncurasset;

    /**
     * 
     */
    private double totalcurliab;

    /**
     * 
     */
    private double totalnoncurliab;

    /**
     * 
     */
    private double totalliab;

    /**
     * 
     */
    private double minorityinterest;

    /**
     * 
     */
    private double totalliabshequity;

    /**
     * 
     */
    private double totalasset;

    /**
     * 
     */
    private double netcashflowinv;

    /**
     * 
     */
    private double netcashflowfina;

    /**
     * 
     */
    private double cashequinetincr;

    /**
     * 
     */
    private double cashequiending;

    /**
     * 
     */
    private double minorityprofit;

    /**
     * 
     */
    private double netprofit;

    /**
     * 
     */
    private double ebit;

    /**
     * 
     */
    private double netprofitias;

    /**
     * 
     */
    private double nonrecurringprofitloss;

    /**
     * 
     */
    private double assetimpairmentprov;

    /**
     * 
     */
    private double roa;

    /**
     * 
     */
    private double monetaryfund;

    /**
     * 
     */
    private double settlementprovision;

    /**
     * 
     */
    private double tradfinaasset;

    /**
     * 
     */
    private double derifinaasset;

    /**
     * 
     */
    private double avaisalefinaasset;

    /**
     * 
     */
    private double heldmaturityinv;

    /**
     * 
     */
    private double ltequityinv;

    /**
     * 
     */
    private double derifinaliab;

    /**
     * 
     */
    private double secuproxymoney;

    /**
     * 
     */
    private double retainedearning;

    /**
     * 
     */
    private double commissionincome;

    /**
     * 
     */
    private double interestnetincome;

    /**
     * 
     */
    private double invincome;

    /**
     * 
     */
    private double fairvalgain;

    /**
     * 
     */
    private double operexpense;

    /**
     * 
     */
    private double businesstaxsurtax;

    /**
     * 
     */
    private double premiumearned;

    /**
     * 
     */
    private double premiumearnedgrowthratio;

    /**
     * 
     */
    private double sellexpense;

    /**
     * 
     */
    private double adminexpense;

    /**
     * 
     */
    private double eps;

    /**
     * 
     */
    private double finacost;

    /**
     * 
     */
    private double opercost;

    /**
     * 
     */
    private double fixedasset;

    /**
     * 
     */
    private double sharecapital;

    /**
     * 
     */
    private double entfcf;

    /**
     * 
     */
    private double shfcf;

    /**
     * 
     */
    private double totaloperrevenue;

    /**
     * 
     */
    private double totalopercost;

    /**
     * 
     */
    private double workcapital;

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

    /**
     * 
     */
    private String divischeme;

    /**
     * 
     */
    private Long sharestandard;


    public Fiveth() {
        super();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getComcode() {
        return comcode;
    }

    public void setComcode(Long comcode) {
        this.comcode = comcode;
    }

    public String getInfosource() {
        return infosource;
    }

    public void setInfosource(String infosource) {
        this.infosource = infosource == null ? null : infosource.trim();
    }

    public Date getPubdate() {
        return pubdate;
    }

    public void setPubdate(Date pubdate) {
        this.pubdate = pubdate;
    }

    public Date getStartdate() {
        return startdate;
    }

    public void setStartdate(Date startdate) {
        this.startdate = startdate;
    }

    public Date getEnddate() {
        return enddate;
    }

    public void setEnddate(Date enddate) {
        this.enddate = enddate;
    }

    public Long getReporttype() {
        return reporttype;
    }

    public void setReporttype(Long reporttype) {
        this.reporttype = reporttype;
    }

    public Long getStandardcode() {
        return standardcode;
    }

    public void setStandardcode(Long standardcode) {
        this.standardcode = standardcode;
    }

    public Long getDataflag() {
        return dataflag;
    }

    public void setDataflag(Long dataflag) {
        this.dataflag = dataflag;
    }

    public Long getComnature() {
        return comnature;
    }

    public void setComnature(Long comnature) {
        this.comnature = comnature;
    }

    public Long getCurrencycode() {
        return currencycode;
    }

    public void setCurrencycode(Long currencycode) {
        this.currencycode = currencycode;
    }

    public double getOperrevenue() {
        return operrevenue;
    }

    public void setOperrevenue(double operrevenue) {
        this.operrevenue = operrevenue;
    }

    public double getOperprofit() {
        return operprofit;
    }

    public void setOperprofit(double operprofit) {
        this.operprofit = operprofit;
    }

    public double getTotalprofit() {
        return totalprofit;
    }

    public void setTotalprofit(double totalprofit) {
        this.totalprofit = totalprofit;
    }

    public double getNetprofitparentcom() {
        return netprofitparentcom;
    }

    public void setNetprofitparentcom(double netprofitparentcom) {
        this.netprofitparentcom = netprofitparentcom;
    }

    public double getNetprofitcutparentcom() {
        return netprofitcutparentcom;
    }

    public void setNetprofitcutparentcom(double netprofitcutparentcom) {
        this.netprofitcutparentcom = netprofitcutparentcom;
    }

    public double getBasiceps() {
        return basiceps;
    }

    public void setBasiceps(double basiceps) {
        this.basiceps = basiceps;
    }

    public double getDilutedeps() {
        return dilutedeps;
    }

    public void setDilutedeps(double dilutedeps) {
        this.dilutedeps = dilutedeps;
    }

    public double getCutbasiceps() {
        return cutbasiceps;
    }

    public void setCutbasiceps(double cutbasiceps) {
        this.cutbasiceps = cutbasiceps;
    }

    public double getRoe() {
        return roe;
    }

    public void setRoe(double roe) {
        this.roe = roe;
    }

    public double getWeightedroe() {
        return weightedroe;
    }

    public void setWeightedroe(double weightedroe) {
        this.weightedroe = weightedroe;
    }

    public double getCutweightedroe() {
        return cutweightedroe;
    }

    public void setCutweightedroe(double cutweightedroe) {
        this.cutweightedroe = cutweightedroe;
    }

    public double getCutroe() {
        return cutroe;
    }

    public void setCutroe(double cutroe) {
        this.cutroe = cutroe;
    }

    public double getNetcashflowoper() {
        return netcashflowoper;
    }

    public void setNetcashflowoper(double netcashflowoper) {
        this.netcashflowoper = netcashflowoper;
    }

    public double getNetcashflowoperps() {
        return netcashflowoperps;
    }

    public void setNetcashflowoperps(double netcashflowoperps) {
        this.netcashflowoperps = netcashflowoperps;
    }

    public double getTotalshequity() {
        return totalshequity;
    }

    public void setTotalshequity(double totalshequity) {
        this.totalshequity = totalshequity;
    }

    public double getShequityparentcom() {
        return shequityparentcom;
    }

    public void setShequityparentcom(double shequityparentcom) {
        this.shequityparentcom = shequityparentcom;
    }

    public double getBvps() {
        return bvps;
    }

    public void setBvps(double bvps) {
        this.bvps = bvps;
    }

    public double getTotalshare() {
        return totalshare;
    }

    public void setTotalshare(double totalshare) {
        this.totalshare = totalshare;
    }

    public double getTotalcurasset() {
        return totalcurasset;
    }

    public void setTotalcurasset(double totalcurasset) {
        this.totalcurasset = totalcurasset;
    }

    public double getTotalnoncurasset() {
        return totalnoncurasset;
    }

    public void setTotalnoncurasset(double totalnoncurasset) {
        this.totalnoncurasset = totalnoncurasset;
    }

    public double getTotalcurliab() {
        return totalcurliab;
    }

    public void setTotalcurliab(double totalcurliab) {
        this.totalcurliab = totalcurliab;
    }

    public double getTotalnoncurliab() {
        return totalnoncurliab;
    }

    public void setTotalnoncurliab(double totalnoncurliab) {
        this.totalnoncurliab = totalnoncurliab;
    }

    public double getTotalliab() {
        return totalliab;
    }

    public void setTotalliab(double totalliab) {
        this.totalliab = totalliab;
    }

    public double getMinorityinterest() {
        return minorityinterest;
    }

    public void setMinorityinterest(double minorityinterest) {
        this.minorityinterest = minorityinterest;
    }

    public double getTotalliabshequity() {
        return totalliabshequity;
    }

    public void setTotalliabshequity(double totalliabshequity) {
        this.totalliabshequity = totalliabshequity;
    }

    public double getTotalasset() {
        return totalasset;
    }

    public void setTotalasset(double totalasset) {
        this.totalasset = totalasset;
    }

    public double getNetcashflowinv() {
        return netcashflowinv;
    }

    public void setNetcashflowinv(double netcashflowinv) {
        this.netcashflowinv = netcashflowinv;
    }

    public double getNetcashflowfina() {
        return netcashflowfina;
    }

    public void setNetcashflowfina(double netcashflowfina) {
        this.netcashflowfina = netcashflowfina;
    }

    public double getCashequinetincr() {
        return cashequinetincr;
    }

    public void setCashequinetincr(double cashequinetincr) {
        this.cashequinetincr = cashequinetincr;
    }

    public double getCashequiending() {
        return cashequiending;
    }

    public void setCashequiending(double cashequiending) {
        this.cashequiending = cashequiending;
    }

    public double getMinorityprofit() {
        return minorityprofit;
    }

    public void setMinorityprofit(double minorityprofit) {
        this.minorityprofit = minorityprofit;
    }

    public double getNetprofit() {
        return netprofit;
    }

    public void setNetprofit(double netprofit) {
        this.netprofit = netprofit;
    }

    public double getEbit() {
        return ebit;
    }

    public void setEbit(double ebit) {
        this.ebit = ebit;
    }

    public double getNetprofitias() {
        return netprofitias;
    }

    public void setNetprofitias(double netprofitias) {
        this.netprofitias = netprofitias;
    }

    public double getNonrecurringprofitloss() {
        return nonrecurringprofitloss;
    }

    public void setNonrecurringprofitloss(double nonrecurringprofitloss) {
        this.nonrecurringprofitloss = nonrecurringprofitloss;
    }

    public double getAssetimpairmentprov() {
        return assetimpairmentprov;
    }

    public void setAssetimpairmentprov(double assetimpairmentprov) {
        this.assetimpairmentprov = assetimpairmentprov;
    }

    public double getRoa() {
        return roa;
    }

    public void setRoa(double roa) {
        this.roa = roa;
    }

    public double getMonetaryfund() {
        return monetaryfund;
    }

    public void setMonetaryfund(double monetaryfund) {
        this.monetaryfund = monetaryfund;
    }

    public double getSettlementprovision() {
        return settlementprovision;
    }

    public void setSettlementprovision(double settlementprovision) {
        this.settlementprovision = settlementprovision;
    }

    public double getTradfinaasset() {
        return tradfinaasset;
    }

    public void setTradfinaasset(double tradfinaasset) {
        this.tradfinaasset = tradfinaasset;
    }

    public double getDerifinaasset() {
        return derifinaasset;
    }

    public void setDerifinaasset(double derifinaasset) {
        this.derifinaasset = derifinaasset;
    }

    public double getAvaisalefinaasset() {
        return avaisalefinaasset;
    }

    public void setAvaisalefinaasset(double avaisalefinaasset) {
        this.avaisalefinaasset = avaisalefinaasset;
    }

    public double getHeldmaturityinv() {
        return heldmaturityinv;
    }

    public void setHeldmaturityinv(double heldmaturityinv) {
        this.heldmaturityinv = heldmaturityinv;
    }

    public double getLtequityinv() {
        return ltequityinv;
    }

    public void setLtequityinv(double ltequityinv) {
        this.ltequityinv = ltequityinv;
    }

    public double getDerifinaliab() {
        return derifinaliab;
    }

    public void setDerifinaliab(double derifinaliab) {
        this.derifinaliab = derifinaliab;
    }

    public double getSecuproxymoney() {
        return secuproxymoney;
    }

    public void setSecuproxymoney(double secuproxymoney) {
        this.secuproxymoney = secuproxymoney;
    }

    public double getRetainedearning() {
        return retainedearning;
    }

    public void setRetainedearning(double retainedearning) {
        this.retainedearning = retainedearning;
    }

    public double getCommissionincome() {
        return commissionincome;
    }

    public void setCommissionincome(double commissionincome) {
        this.commissionincome = commissionincome;
    }

    public double getInterestnetincome() {
        return interestnetincome;
    }

    public void setInterestnetincome(double interestnetincome) {
        this.interestnetincome = interestnetincome;
    }

    public double getInvincome() {
        return invincome;
    }

    public void setInvincome(double invincome) {
        this.invincome = invincome;
    }

    public double getFairvalgain() {
        return fairvalgain;
    }

    public void setFairvalgain(double fairvalgain) {
        this.fairvalgain = fairvalgain;
    }

    public double getOperexpense() {
        return operexpense;
    }

    public void setOperexpense(double operexpense) {
        this.operexpense = operexpense;
    }

    public double getBusinesstaxsurtax() {
        return businesstaxsurtax;
    }

    public void setBusinesstaxsurtax(double businesstaxsurtax) {
        this.businesstaxsurtax = businesstaxsurtax;
    }

    public double getPremiumearned() {
        return premiumearned;
    }

    public void setPremiumearned(double premiumearned) {
        this.premiumearned = premiumearned;
    }

    public double getPremiumearnedgrowthratio() {
        return premiumearnedgrowthratio;
    }

    public void setPremiumearnedgrowthratio(double premiumearnedgrowthratio) {
        this.premiumearnedgrowthratio = premiumearnedgrowthratio;
    }

    public double getSellexpense() {
        return sellexpense;
    }

    public void setSellexpense(double sellexpense) {
        this.sellexpense = sellexpense;
    }

    public double getAdminexpense() {
        return adminexpense;
    }

    public void setAdminexpense(double adminexpense) {
        this.adminexpense = adminexpense;
    }

    public double getEps() {
        return eps;
    }

    public void setEps(double eps) {
        this.eps = eps;
    }

    public double getFinacost() {
        return finacost;
    }

    public void setFinacost(double finacost) {
        this.finacost = finacost;
    }

    public double getOpercost() {
        return opercost;
    }

    public void setOpercost(double opercost) {
        this.opercost = opercost;
    }

    public double getFixedasset() {
        return fixedasset;
    }

    public void setFixedasset(double fixedasset) {
        this.fixedasset = fixedasset;
    }

    public double getSharecapital() {
        return sharecapital;
    }

    public void setSharecapital(double sharecapital) {
        this.sharecapital = sharecapital;
    }

    public double getEntfcf() {
        return entfcf;
    }

    public void setEntfcf(double entfcf) {
        this.entfcf = entfcf;
    }

    public double getShfcf() {
        return shfcf;
    }

    public void setShfcf(double shfcf) {
        this.shfcf = shfcf;
    }

    public double getTotaloperrevenue() {
        return totaloperrevenue;
    }

    public void setTotaloperrevenue(double totaloperrevenue) {
        this.totaloperrevenue = totaloperrevenue;
    }

    public double getTotalopercost() {
        return totalopercost;
    }

    public void setTotalopercost(double totalopercost) {
        this.totalopercost = totalopercost;
    }

    public double getWorkcapital() {
        return workcapital;
    }

    public void setWorkcapital(double workcapital) {
        this.workcapital = workcapital;
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

    public String getDivischeme() {
        return divischeme;
    }

    public void setDivischeme(String divischeme) {
        this.divischeme = divischeme == null ? null : divischeme.trim();
    }

    public Long getSharestandard() {
        return sharestandard;
    }

    public void setSharestandard(Long sharestandard) {
        this.sharestandard = sharestandard;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
    }
}