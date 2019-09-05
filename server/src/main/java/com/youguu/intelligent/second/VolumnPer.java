package com.youguu.intelligent.second;

public class VolumnPer {

    private long volume;

    private long date;

    public VolumnPer(long volume, long date) {
        this.volume = volume;
        this.date = date;
    }

    public long getVolume() {
        return volume;
    }

    public void setVolume(long volume) {
        this.volume = volume;
    }

    public long getDate() {
        return date;
    }

    public void setDate(long date) {
        this.date = date;
    }
}
