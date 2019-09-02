package com.youguu.intelligent.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * Created by CosWind on 2015/4/14.
 */
public class DateUtil {

    private final static SimpleDateFormat currentTime = new SimpleDateFormat("yyyyMMddHHmmss");
    private final static SimpleDateFormat currentTimeMills = new SimpleDateFormat("yyyyMMddHHmmssSSS");
    private final static SimpleDateFormat currentDate = new SimpleDateFormat("yyyy-MM-dd");

    public static String getCurrentTime() {
        return currentTime.format(new Date());
    }

    public static String getCurrentTimeMills() {
        return currentTimeMills.format(new Date());
    }

    public static String getTime(Date date) {
        return currentTime.format(date);
    }

    public static String getCurrentDate() {
        return currentDate.format(new Date());
    }

    public static Date getDate(String time) {
        try {
            return currentTime.parse(time);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static String formatMillisecond(long milliSeconds) {
        return String.format("%02d:%02d:%02d",
                TimeUnit.MILLISECONDS.toHours(milliSeconds),
                TimeUnit.MILLISECONDS.toMinutes(milliSeconds) -
                        TimeUnit.HOURS.toMinutes(TimeUnit.MILLISECONDS.toHours(milliSeconds)),
                TimeUnit.MILLISECONDS.toSeconds(milliSeconds) -
                        TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(milliSeconds)));
    }

    public static String simpleFormatMS(long ms) {
        if (ms < 1000 * 10) {
            return String.format("%8d", ms);
        } else {
            return formatMillisecond(ms);
        }
    }
}
