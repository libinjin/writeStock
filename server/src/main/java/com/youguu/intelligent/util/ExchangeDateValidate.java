package com.youguu.intelligent.util;

import com.youguu.core.logging.Log;
import com.youguu.core.logging.LogFactory;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 交易所时间验证
 * Created by lqipr on 2016/10/11.
 */
public class ExchangeDateValidate {

    private static Date maxTime;

    private static final Log log = LogFactory.getLog(ExchangeDateValidate.class);

    public static Date getMaxTime() {
        return maxTime;
    }

    public static synchronized void setMaxTime(Date currTime) {
        if(currTime == null) return;

        if(maxTime == null || currTime.getTime() > maxTime.getTime()){
            maxTime = currTime;
        }
    }

    public static boolean validate(Date now){
        SimpleDateFormat sdf = new SimpleDateFormat("HHmm");
        int curr = Integer.parseInt(sdf.format(now));


        //是否在12点50以后  减少判断次数
        if(curr > 1255 && curr < 1305){
            int maxDate = Integer.parseInt(sdf.format(ExchangeDateValidate.getMaxTime()));
            log.info("curr date:" + curr + "---maxDate:" + maxDate +" return:" + !(maxDate < 1300));
            //判断交易所的最大快照时间是否在一点以前
            if(maxDate < 1300){
                return false;
            }
        }
        return true;
    }

}
