package com.youguu.intelligent.sevice;

import com.youguu.core.logging.Log;
import com.youguu.core.logging.LogFactory;
import com.youguu.intelligent.pojo.TotalField;
import java.io.IOException;
import java.util.Map;

public class GenFileThread implements Runnable{

    private static Log log = LogFactory.getLog(GenFileThread.class);

    private TotalService totalService;

    private WriteService writeService;

    private int num;

    public GenFileThread(TotalService totalService, WriteService writeService, int num) {
        this.totalService = totalService;
        this.writeService = writeService;
        this.num = num;
    }

    public TotalService getTotalService() {
        return totalService;
    }

    public void setTotalService(TotalService totalService) {
        this.totalService = totalService;
    }

    public WriteService getWriteService() {
        return writeService;
    }

    public void setWriteService(WriteService writeService) {
        this.writeService = writeService;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    @Override
    public void run() {

        try {

            Map<Long, TotalField> map = totalService.putTogether(totalService.getEndDate(), totalService.getReportType());

            writeService.gen(writeService.getDir(), map);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
