package com.youguu.intelligent.base;

import com.youguu.core.logging.Log;
import com.youguu.core.logging.LogFactory;
import com.youguu.intelligent.pojo.TotalField;
import com.youguu.intelligent.sevice.GenFileThread;
import com.youguu.intelligent.sevice.TotalService;
import com.youguu.intelligent.sevice.WriteService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.io.IOException;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;


/**
 *
 * @ClassName: BootStrap
 * @Description: rpc server 启动入口
 * @author libin
 * @date 2019年08月07日 上午11:17:37
 *
 */
public class BootStrap {

	private static final Log logger = LogFactory.getLog(BootStrap.class);

	public static void main(String[] args) {

		ApplicationContext app = new AnnotationConfigApplicationContext(ContextLoader.class);

		long start = System.currentTimeMillis();

	/*	ExecutorService executor = new ThreadPoolExecutor(4,4, 0L,TimeUnit.SECONDS, new LinkedBlockingQueue<Runnable>()){
			@Override
			protected void beforeExecute(Thread t, Runnable r) {
				System.out.println("准备执行任务："+((GenFileThread)r).getNum());
			}

			@Override
			protected void afterExecute(Runnable r, Throwable t) {
				System.out.println("执行任务："+((GenFileThread)r).getNum()+"完毕");
			}

			@Override
			protected void terminated() {
				System.out.println("线程池退出");
			}
		};*/

		//2019中报、2019一季报、2018年报、2018三季报、2018中报

		String endDate = "2019-06-30 00:00:00";
		int reportType = 6;
		String dir = "/home/jhss/wangdong/data/writeStock/2019-06-30.xls";

		TotalService totalService1 = (TotalService) app.getBean("totalService");
		totalService1.setEndDate(endDate);
		totalService1.setReportType(reportType);

		Map<Long, TotalField> map = totalService1.putTogether(endDate, reportType);
		try {
			WriteService writeService = new WriteService(dir);
			writeService.gen(dir, map);
			logger.info(dir+"写入完毕");
		} catch (IOException e) {
			e.printStackTrace();
		}

		String endDate2 = "2019-03-31 00:00:00";
		int reportType2 = 1;
		String dir2 = "/home/jhss/wangdong/data/writeStock/2019-03-31.xls";
		TotalService totalService2 = (TotalService) app.getBean("totalService");
		totalService2.setEndDate(endDate2);
		totalService2.setReportType(reportType2);
		Map<Long, TotalField> secMap = totalService2.putTogether(endDate2, reportType2);
		try {
			WriteService writeService = new WriteService(dir2);
			writeService.gen(dir2, secMap);
			logger.info(dir2+"写入完毕");
		} catch (IOException e) {
			e.printStackTrace();
		}


		String endDate3 = "2018-12-31 00:00:00";
		int reportType3 = 12;
		String dir3 = "/home/jhss/wangdong/data/writeStock/2018-12-31.xls";
		TotalService totalService3 = (TotalService) app.getBean("totalService");
		totalService3.setEndDate(endDate3);
		totalService3.setReportType(reportType3);
		Map<Long, TotalField> thirdMap = totalService3.putTogether(endDate3, reportType3);
		try {
			WriteService writeService = new WriteService(dir3);
			writeService.gen(dir3, thirdMap);
			logger.info(dir3+"写入完毕");
		} catch (IOException e) {
			e.printStackTrace();
		}


		String endDate4 = "2018-06-30 00:00:00";
		int reportType4 = 6;
		String dir4 = "/home/jhss/wangdong/data/writeStock/2018-06-30.xls";
		TotalService totalService4 = (TotalService) app.getBean("totalService");
		totalService4.setEndDate(endDate4);
		totalService4.setReportType(reportType4);
		Map<Long, TotalField> fourMap = totalService4.putTogether(endDate4, reportType4);
		try {
			WriteService writeService = new WriteService(dir4);
			writeService.gen(dir4, fourMap);
			logger.info(dir4+"写入完毕");
		} catch (IOException e) {
			e.printStackTrace();
		}


		long end = System.currentTimeMillis();
		logger.info("耗时："+(end-start));

	}

}
