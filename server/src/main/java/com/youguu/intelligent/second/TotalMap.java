package com.youguu.intelligent.second;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class TotalMap {

    Map<String , List<ChangePer>> changePercentMap = new HashMap<>();

    Map<String ,List<VolumnPer>> volumeMap = new HashMap<>();

    Map<String , MarkertPer> marketMap = new LinkedHashMap<>();

    Map<String, BOLLPoint> bollPointMap = new HashMap<>();

    public Map<String, List<ChangePer>> getChangePercentMap() {
        return changePercentMap;
    }

    public void setChangePercentMap(Map<String, List<ChangePer>> changePercentMap) {
        this.changePercentMap = changePercentMap;
    }

    public Map<String, List<VolumnPer>> getVolumeMap() {
        return volumeMap;
    }

    public void setVolumeMap(Map<String, List<VolumnPer>> volumeMap) {
        this.volumeMap = volumeMap;
    }

    public Map<String, MarkertPer> getMarketMap() {
        return marketMap;
    }

    public void setMarketMap(Map<String, MarkertPer> marketMap) {
        this.marketMap = marketMap;
    }

    public Map<String, BOLLPoint> getBollPointMap() {
        return bollPointMap;
    }

    public void setBollPointMap(Map<String, BOLLPoint> bollPointMap) {
        this.bollPointMap = bollPointMap;
    }
}
