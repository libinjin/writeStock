package com.youguu.intelligent.util;

import com.youguu.core.logging.Log;
import com.youguu.core.logging.LogFactory;
import com.youguu.intelligent.pojo.CommonKlinePoint;
import com.youguu.intelligent.xrdr.QuoteZookeeperConfig;

import java.io.DataInputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class HisKlineReader {

	private static Log logger = LogFactory.getLog(HisKlineReader.class);

	// K线存储基础目录
//	public static String historyfolder = ZkPropertiesHelper.getCacheAndWatchProperties("quote", true).getProperty("historyfolder");

	/**
	 * 每个klinepoint的大小
	 */
	private static final int blockSize = 132+8;

	private final static int BufCount = 250;


	public static List<CommonKlinePoint> getKlineByCount(String stockcode, int marketid, String klinetype, int count){
		List<CommonKlinePoint> klist = new ArrayList<CommonKlinePoint>();
		String filepath = getKlinePath(stockcode, marketid, klinetype);
		final File file = new File(filepath);
		if (!file.exists()) {
			return klist;
		}
		RandomAccessFile raf = null;


		try {
			raf = new RandomAccessFile(file, "r");
			long len = raf.length();
			long location = len > count* blockSize ? len - count* blockSize : 0;

			final MemInStream mis = new MemInStream(new byte[blockSize]);
			final DataInputStream dis = new DataInputStream(mis);
			// 先定位到的指定时间的K线点,然后计算出实际应该读取的点
			while (location < len ) {

				raf.seek(location);
				dis.reset();
				raf.read(mis.getBuf());
				final CommonKlinePoint point = readKlinePoint(dis);
				klist.add(point);
				location = location + blockSize;
			}
			return klist;
		} catch (final Exception e) {
			logger.error(e.toString(), e);
			return klist;
		} finally {
			close(raf);
		}

	}

	public static List<CommonKlinePoint> getKLineByTime(String stockCode, int marketid, String klinetype, final long startTime, final long endTime){
		// 先对参数进行必要的合法性判断(正负)
		if ((startTime < 0) || (endTime < 0)) {
			logger.error("please assign the time correctly!");
			return new ArrayList<CommonKlinePoint>();
		} else if (startTime > endTime) { // 两时间参数相等或是start>endTime的特殊情况
			logger.error("please assign the startTime and endTime correctly!");
			return new ArrayList<CommonKlinePoint>();
		}
		// 读取历史文件名称
		final String historyFileName = getKlinePath(stockCode, marketid, klinetype);
		// 用endTime和文件末每个klinePoint的时间循环比较
		long location = -1;
		long fileLength = 0;

		final LinkedList<CommonKlinePoint> k_points = new LinkedList<CommonKlinePoint>();
		final File file = new File(historyFileName);
		if (!file.exists()) {
			logger.error("the file for " + historyFileName + " does not exist!");
			return new ArrayList<CommonKlinePoint>();
		}
		RandomAccessFile raf = null;
		try {
			raf = new RandomAccessFile(file, "r");
			fileLength = raf.length();
			location = fileLength - fileLength % blockSize;
			final BufferedRandomAccess bufRa = new BufferedRandomAccess(raf, blockSize, BufCount, BufferedRandomAccess.CACHE_BEFORE);
			final DataInputStream dis = new DataInputStream(bufRa);

			long diff = -1;

			//先根据终止时间从文件中查找
			do {
				location -= blockSize;
				if (location < 0) {
					break;
				}
				bufRa.seek(location + 124);
				final long tmpTime = dis.readLong();
				diff = endTime - tmpTime;
			} while (diff < 0);//要找的时间小于当前点时间继续

			//没有找到endTime之前的点就返回空List
			if ( diff < 0) {
				return new ArrayList<CommonKlinePoint>();
			}

			//把小于等于结束时间的当前点加入列表
			if (diff >= 0) {
				location += blockSize;
			}

			// 找到以后就从后向前与起始时间相比较
			while (location > 0) {
				location -= blockSize;
				bufRa.seek(location);
				final CommonKlinePoint k_point = readKlinePoint(dis);
				if (startTime - k_point.getKeyDate() <= 0) {
					k_points.addFirst(k_point);
				} else {
					break;
				}
			}

			return k_points;
		} catch (final FileNotFoundException e) {
			logger.error(e.toString(), e);
			return null;
		} catch (final IOException e) {
			logger.error(e.toString(), e);
			return null;
		} finally {
			close(raf);
		}
	}

	/**
	 * 注意：包含timePoint当天的点
	 * @param stockCode
	 * @param marketid
	 * @param klineType
	 * @param timePoint
	 * @param num
	 * @return
	 */
	public static List<CommonKlinePoint> getKLineBeforeTime(String stockCode, int marketid, String klineType, final long timePoint, int num){
		// 判断参数的有效性
		if ((Long.valueOf(timePoint) < 0) || (num <= 0)) {
			logger.warn("please correctly assign the startTime and number you want to look for!");
			return new ArrayList<CommonKlinePoint>();
		}
		// 读取文件名称
		final String historyFileName = getKlinePath(stockCode, marketid, klineType);
		// 用startTime和文件最末每个klinePoint的时间循环比较，将满足条件的保存到list中返回
		long location = -1;
		long fileLength = 0;
		final List<CommonKlinePoint> k_points = new ArrayList<CommonKlinePoint>(num);
		final File file = new File(historyFileName);
		if (!file.exists()) {
			return k_points;
		}
		RandomAccessFile raf = null;
		try {
			raf = new RandomAccessFile(file, "r");
			fileLength = raf.length();

			final BufferedRandomAccess bufRa = new BufferedRandomAccess(raf, blockSize, num + 1, BufferedRandomAccess.CACHE_BEFORE);
			final DataInputStream dis = new DataInputStream(bufRa);

			long tmpTime;
			long diff = 0; // 两时间比较结果
			location = fileLength - fileLength % blockSize;
			// 查找合适的位置点
			do {
				location -= blockSize;
				// 查找到文件头位置
				if (location < 0) {
					location = 0;
					break;
				}
				bufRa.seek(location + 124);
				tmpTime = dis.readLong();
				diff = timePoint - tmpTime;

			} while (diff <= 0);

			// 当文件中只有一个点时直接定位到点末尾,根据location计算出实际读取的个数
			// 包括相等时间点
			if (diff > 0) {
				location += blockSize*2;
			}

			// 先定位到的指定时间的K线点,然后计算出实际应该读取的点
			if (location > 0) {
				// 判断开始位置
				if (location / blockSize <= 0) {
					return k_points;
				}
				// 实际读取点的个数
				final long counter = location / blockSize > (num ) ? (num) : location / blockSize;
				location = location - counter * blockSize;
				bufRa.seek(location);
				// 从前向后依次读取指定的个数K点或是满足条件且不够num的所有点
				for (int ind = 0; ind < counter; ind++) {
					k_points.add(readKlinePoint(dis));
				}
			}
			return k_points;
		} catch (final FileNotFoundException e) {
			logger.error(e.toString(), e);
			return null;
		} catch (final IOException e) {
			logger.error(e.toString(), e);
			return null;
		} finally {
			close(raf);
		}

	}

	/**
	 * 注意：不包含timePoint当天的点
	 * @param stockCode
	 * @param marketid
	 * @param klineType
	 * @param timePoint
	 * @param num
	 * @return
	 */
	public static List<CommonKlinePoint> getKLineBeforeTimeNoToday(String stockCode, int marketid, String klineType, final long timePoint, int num){
		// 判断参数的有效性
		if ((Long.valueOf(timePoint) < 0) || (num <= 0)) {
			logger.warn("please correctly assign the startTime and number you want to look for!");
			return new ArrayList<CommonKlinePoint>();
		}
		// 读取文件名称
		final String historyFileName = getKlinePath(stockCode, marketid, klineType);
		// 用startTime和文件最末每个klinePoint的时间循环比较，将满足条件的保存到list中返回
		long location = -1;
		long fileLength = 0;
		final List<CommonKlinePoint> k_points = new ArrayList<CommonKlinePoint>(num);
		final File file = new File(historyFileName);
		if (!file.exists()) {
			return k_points;
		}
		RandomAccessFile raf = null;
		try {
			raf = new RandomAccessFile(file, "r");
			fileLength = raf.length();

			final BufferedRandomAccess bufRa = new BufferedRandomAccess(raf, blockSize, num + 1, BufferedRandomAccess.CACHE_BEFORE);
			final DataInputStream dis = new DataInputStream(bufRa);

			long tmpTime;
			long diff = 0; // 两时间比较结果
			location = fileLength - fileLength % blockSize;
			// 查找合适的位置点
			do {
				location -= blockSize;
				// 查找到文件头位置
				if (location < 0) {
					location = 0;
					break;
				}
				bufRa.seek(location + 124);
				tmpTime = dis.readLong();
				diff = timePoint - tmpTime;

			} while (diff < 0);

			// 当文件中只有一个点时直接定位到点末尾,根据location计算出实际读取的个数
			// 不包括相等时间点
			if (diff > 0) {
				location += blockSize;
			}

			// 先定位到的指定时间的K线点,然后计算出实际应该读取的点
			if (location > 0) {
				// 判断开始位置
				if (location / blockSize <= 0) {
					return k_points;
				}
				// 实际读取点的个数
				final long counter = location / blockSize > (num ) ? (num) : location / blockSize;
				location = location - counter * blockSize;
				bufRa.seek(location);
				// 从前向后依次读取指定的个数K点或是满足条件且不够num的所有点
				for (int ind = 0; ind < counter; ind++) {
					k_points.add(readKlinePoint(dis));
				}
			}
			return k_points;
		} catch (final FileNotFoundException e) {
			logger.error(e.toString(), e);
			return null;
		} catch (final IOException e) {
			logger.error(e.toString(), e);
			return null;
		} finally {
			close(raf);
		}

	}


	private static String getKlinePath(String stockCode, int marketid, String klinetype) {
		StringBuffer filepath = new StringBuffer();
		QuoteZookeeperConfig quotezkconfig = new QuoteZookeeperConfig();
		String historyfolder = quotezkconfig.getHistoryfolder();
		filepath.append(historyfolder);
		filepath.append(File.separator);
		if(marketid == 1){
			filepath.append("shdata");
		}else if(marketid == 2){
			filepath.append("szdata");
		}
		filepath.append(File.separator);
		filepath.append("kline");
		filepath.append(File.separator);
		filepath.append(klinetype);
		filepath.append(File.separator);
		filepath.append(stockCode.substring(stockCode.length() - 1, stockCode.length()));
		filepath.append(File.separator);
		filepath.append(stockCode + ".data");

		return filepath.toString();
	}



	/**
	 * 从文件中读取一个KLinePoint点并返回 Method for readKlinePoint.
	 *
	 * @param dis
	 * @return KlinePoint
	 * @throws IOException
	 */
	private static CommonKlinePoint readKlinePoint(final DataInputStream dis) throws IOException {
		final CommonKlinePoint k_point = new CommonKlinePoint();
		k_point.setDate(dis.readLong());
		k_point.setOpen(dis.readDouble());
		k_point.setHigh(dis.readDouble());
		k_point.setLow(dis.readDouble());
		k_point.setCur(dis.readDouble());
		k_point.setSum(dis.readDouble());
		k_point.setVolume5PointAvg(dis.readLong());
		k_point.setPrice5PointAvg(dis.readDouble());
		k_point.setVolume10PointAvg(dis.readLong());
		k_point.setPrice10PointAvg(dis.readDouble());
		k_point.setPrice20PointAvg(dis.readDouble());
		k_point.setPrice60PointAvg(dis.readDouble());
		k_point.setPrice120PointAvg(dis.readDouble());
		k_point.setPrice240PointAvg(dis.readDouble());
		k_point.setVolume(dis.readLong());
		k_point.setSwap(dis.readFloat());
		k_point.setKeyDate(dis.readLong());
		k_point.setSettlePrice(dis.readDouble());
		return k_point;
	}


	/**
	 * 关闭文件 Method for close.
	 *
	 * @param raf
	 */
	private static void close(final RandomAccessFile raf) {
		if (raf != null) {
			try {
				raf.close();
			} catch (final IOException e) {
				logger.error(e.toString(), e);
			}
		}
	}


	public static void main(String args[]){

		String stockCode = "600000";
		int marketid = 1;
		long startTime =20160720;
		long endTime = 20190729;



		List<CommonKlinePoint> klist =  HisKlineReader.getKLineByTime(stockCode, marketid, "day", startTime, endTime);
		for(CommonKlinePoint point:klist){
			System.out.println(point.toString());
		}
	}
}
