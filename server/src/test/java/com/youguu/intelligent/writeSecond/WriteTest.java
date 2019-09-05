package com.youguu.intelligent.writeSecond;

import com.youguu.intelligent.base.BaseTestClass;
import com.youguu.intelligent.second.IndexCalStaticTask;
import org.junit.Test;

public class WriteTest extends BaseTestClass {

    IndexCalStaticTask indexCalStaticTask = (IndexCalStaticTask) getInstance("indexCalStaticTask");

    @Test
    public void TotalTest() {

        indexCalStaticTask.generateIndexFile();

        System.out.println("写入完成");
    }

}
