package com.youguu.intelligent.util;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;


/**
 * 行情工具类
 */
public class QuoteUtil {

	/**
	 * 判断格式化保留几位小数点; B股, 基金 3位, 其他两位
	 *
	 * @param code
	 * @return 2 保留2位，3保留三位
	 */
	public static int getFormart(String code) {
		int num = 2;
		if (code == null || code.length() != 8) {
			return num;
		}
		String stockCode = code.substring(2);
		if (code.startsWith("1")) {
			if (stockCode.startsWith("90") || stockCode.startsWith("50") || stockCode.startsWith("51")) {
				num = 3;
			}
		} else if (code.startsWith("2")) {
			if (stockCode.startsWith("20") || stockCode.startsWith("15") || stockCode.startsWith("16") || stockCode.startsWith("18")) {
				num = 3;
			}
		}
		return num;
	}

	/**
	 * 转换为6位证券代码
	 *
	 * @param code 8位优顾代码
	 * @return String
	 */
	public static String convertTo6(String code) {
		if (code.length() != 8) {
			return code;
		} else {
			return code.substring(2);
		}
	}

	/**
	 * 转换为8位证券代码, 支持指数, A股, 基金
	 *
	 * @param code
	 *            6位证券代码
	 * @param marketID
	 *            市场ID
	 * @return String
	 */
	public static String convertTo8(String code, int marketID) {
		if(marketID == 3 || marketID == 4 || marketID == 5){
			return marketID+"1"+code;
		}
		if (code.length() != 6) {
			return code;
		} else {
			StringBuilder sb = new StringBuilder();
			if (marketID == 1) {
				// 上证
				for (Entry<String, String> entry : LEVELFIRSTMAP_SH.entrySet()) {
					boolean isExponent = false;
					if (FIRST_TYPE_INDEX.equals(entry.getKey())) {
						isExponent = true;
					}
					String[] codeStart = entry.getValue().split(",");
					for (String cs : codeStart) {
						if (code.indexOf(cs) == 0 && isExponent) {
							return sb.append("10").append(code).toString();
						} else if (code.indexOf(cs) == 0 && !isExponent) {
							return sb.append("11").append(code).toString();
						}
					}
				}
			} else if (marketID == 2) {
				// 深证
				for (Entry<String, String> entry : LEVELFIRSTMAP_SZ.entrySet()) {
					boolean isExponent = false;
					if (FIRST_TYPE_INDEX.equals(entry.getKey())) {
						isExponent = true;
					}
					String[] codeStart = entry.getValue().split(",");
					for (String cs : codeStart) {
						if (code.indexOf(cs) == 0 && isExponent) {
							return sb.append("20").append(code).toString();
						} else if (code.indexOf(cs) == 0 && !isExponent) {
							return sb.append("21").append(code).toString();
						}
					}
				}
			}
			return code;
		}
	}


	/**
	 * 通过当前价返回 涨停--跌停价
	 *
	 * @param codeName
	 *            股票名称
	 * @param price
	 * @return dounle[0] 涨停价 double[1] 跌停价
	 */
	public static double[] getHlPrice(String codeName, double price) {
		double[] hlprice = new double[2];
		if (codeName != null) {
			if (codeName.toUpperCase().indexOf("N") == 0) {// 新股判断
				hlprice[0] = price + (price * 0.50);
				hlprice[1] = price - (price * 0.40);
			} else if (codeName.toUpperCase().startsWith("*ST") || codeName.toUpperCase().startsWith("ST")) {
				hlprice[0] = price + (price * 0.05);
				hlprice[1] = price - (price * 0.05);
			} else {
				hlprice[0] = price + (price * 0.1);
				hlprice[1] = price - (price * 0.1);
			}
		}
		return hlprice;
	}

	/**
	 * 返回格式化后的 涨停--跌停价
	 *
	 * @param code
	 *            8位股票代码
	 * @param codeName
	 *            股票名称
	 * @param price
	 *            价格
	 * @return
	 */
	public static String[] getHlPrice(String code, String codeName, double price) {
		String[] hlprice = new String[2];
		if (codeName != null && code != null) {
			double[] tempPrice = getHlPrice(codeName, price);
			int formartNum = getFormart(code);

			BigDecimal hight = new BigDecimal(Double.toString(tempPrice[0]));

			BigDecimal low = new BigDecimal(Double.toString(tempPrice[1]));
			hight = hight.setScale(formartNum, BigDecimal.ROUND_HALF_UP);
			low = low.setScale(formartNum, BigDecimal.ROUND_HALF_UP);

			hlprice[0] = hight.toPlainString();
			hlprice[1] = low.toPlainString();
		}
		return hlprice;
	}

	public static String getChangePercent(float curPrice, float lastprice) {
		float change = 0;
		if (curPrice != 0) {
			change = (curPrice - lastprice) * 100 / lastprice;
		}
		return String.format("%.2f%%", change);
	}





	/**
	 * 上证一级分类对应的代码规则
	 */
	public static HashMap<String, String> LEVELFIRSTMAP_SH = new HashMap<String, String>();

	/**
	 * 上证二级分类对应的代码规则
	 */
	public static HashMap<String, String> LEVELSECONDMAP_SH = new HashMap<String, String>();

	/**
	 * 深证一级分类对应的代码规则
	 */
	public static HashMap<String, String> LEVELFIRSTMAP_SZ = new HashMap<String, String>();

	/**
	 * 深证二级分类对应的代码规则
	 */
	public static HashMap<String, String> LEVELSECONDMAP_SZ = new HashMap<String, String>();

	static {
		// 上证
		LEVELFIRSTMAP_SH.put("1", "000"); // 指数
		LEVELFIRSTMAP_SH.put("2", "600,601,603,732,730,780");// A股
		LEVELFIRSTMAP_SH.put("3", "900");// B股
		LEVELFIRSTMAP_SH.put("4", "50,51,52");// 基金
		LEVELFIRSTMAP_SH.put("5", "009,010,019,020,100,104,105,106,107,113,120,121,122,126,129,13");// 国债
		LEVELFIRSTMAP_SH.put("6", "580,582");// 权证

		// 深圳
		LEVELFIRSTMAP_SZ.put("1", "39"); // 指数
		LEVELFIRSTMAP_SZ.put("2", "00,30");// A股
		LEVELFIRSTMAP_SZ.put("3", "20");// B股
		LEVELFIRSTMAP_SZ.put("4", "15,16,18");// 基金
		LEVELFIRSTMAP_SZ.put("5", "10,11,12");// 国债
		LEVELFIRSTMAP_SZ.put("6", "08,28,38");// 权证

		LEVELSECONDMAP_SZ.put("21", "30");// 创业板
		LEVELSECONDMAP_SZ.put("22", "002");// 中小板
		LEVELSECONDMAP_SZ.put("41", "15");// ETF
		LEVELSECONDMAP_SZ.put("42", "16");// LOF
	}

	/**
	 * 返回8位证券代码对应的二级分类
	 *
	 * @param code 8位证券代码
	 * @return String 二级分类代码
	 */
	public static String getLevelSecond(String code) {
		if (code == null || code.length() != 8) {
			return "0";
		}
		String stockCode = code.substring(2);
		HashMap<String, String> codeMap = null;
		if (code.startsWith("1")) {// 上证代码
			codeMap = LEVELSECONDMAP_SH;
		} else {// 深证代码
			codeMap = LEVELSECONDMAP_SZ;
		}
		Iterator<Entry<String, String>> iterator = codeMap.entrySet().iterator();
		while (iterator.hasNext()) {
			Entry<String, String> entry = iterator.next();
			String temp_code = entry.getKey();
			String[] codeSegments = entry.getValue().split(",");
			for (String codeSegment : codeSegments) {
				if (stockCode.startsWith(codeSegment)) {
					return temp_code;
				}
			}
		}
		return "0";
	}



	public static final String FIRST_TYPE_INDEX = "1"; // 指数

	public static final String FIRST_TYPE_STKA = "2"; // A股

	public static final String FIRST_TYPE_STKB = "3"; // B股

	public static final String FIRST_TYPE_FND = "4"; // 基金

	public static final String FIRST_TYPE_BND = "5"; // 债券

	public static final String FIRST_TYPE_OPT = "6"; // 权证

	public static final String FIRST_TYPE_INDUSTRY = "21"; // 行业

	public static final String FIRST_TYPE_CONCEPT = "22"; // 概念

	public static final String SECOND_TYPE_GEM = "21"; // 创业板

	public static final String SECOND_TYPE_SMB = "22"; // 中小板

	public static final String SECOND_TYPE_ETF = "41"; // ETF

	public static final String SECOND_TYPE_LOF = "42"; // LOF

	public static final int MARKET_SH = 1; // 上海市场ID

	public static final int MARKET_SZ = 2; // 深圳市场ID

	public static final int MARKET_BOARD = 9; // 行业与概念 市场ID

	/**
	 * 证券一级类别代码转换，新代码-〉老代码
	 *
	 * @param marketId 市场id
	 * @param newFirstType 新类别代码
	 * @return String 老一级代码
	 */
	public static String convertOldFirstType(int marketId, String newFirstType) {
		if (marketId == 1) {// 上海市场
			if (newFirstType.trim().equals("1")) {
				return "01";
			} else if (newFirstType.trim().equals("2")) {
				return "03";
			} else if (newFirstType.trim().equals("3")) {
				return "04";
			} else if (newFirstType.trim().equals("4")) {
				return "07";
			} else if (newFirstType.trim().equals("5")) {
				return "09";
			} else if (newFirstType.trim().equals("6")) {
				return "11";
			}
		} else if (marketId == 2) {// 深圳市场
			if (newFirstType.trim().equals("1")) {
				return "02";
			} else if (newFirstType.trim().equals("2")) {
				return "05";
			} else if (newFirstType.trim().equals("3")) {
				return "06";
			} else if (newFirstType.trim().equals("4")) {
				return "08";
			} else if (newFirstType.trim().equals("5")) {
				return "10";
			} else if (newFirstType.trim().equals("6")) {
				return "12";
			}
		}
		return "0";
	}

	/**
	 * 证券二级类别代码转换, 新代码-〉老代码
	 *
	 * @param marketId 市场id
	 * @param newSecondType 新类别代码
	 * @return String 老二级代码
	 */
	public static String convertToOldSecondType(int marketId, String newSecondType) {
		if (marketId == 2) {
			if (newSecondType.trim().equals("21")) {
				return "0501";
			} else if (newSecondType.trim().equals("22")) {
				return "0502";
			} else if (newSecondType.trim().equals("41")) {
				return "0801";
			} else if (newSecondType.trim().equals("42")) {
				return "0802";
			}
		}
		return "0";
	}

	/** 老代码 **/
	/*********** 一级分类 ************/
	/******* 变量名_start为：此分类代码段 ********/
	/**
	 * 上海指数
	 */
	public static final String O_SHZS = "01";

	/**
	 * 深圳指数
	 */
	public static final String O_SZZS = "02";
	/**
	 * 上海A股
	 */
	public static final String O_SHAG = "03";
	/**
	 * 上海B股
	 */
	public static final String O_SHBG = "04";
	/**
	 * 深圳A股
	 */
	public static final String O_SZAG = "05";
	/**
	 * 深圳B股
	 */
	public static final String O_SZBG = "06";
	/**
	 * 上海基金
	 */
	public static final String O_SHJJ = "07";
	/**
	 * 深圳基金
	 */
	public static final String O_SZJJ = "08";
	/**
	 * 上海国债
	 */
	public static final String O_SHGZ = "09";
	/**
	 * 深圳国债
	 */
	public static final String O_SZGZ = "10";
	/**
	 * 上海权证
	 */
	public static final String O_SHQZ = "11";
	/**
	 * 深圳权证
	 */
	public static final String O_SZQZ = "12";

	/*********** 二级分类 ************/
	/**
	 * 创业版
	 */
	public static final String S_CYB = "0501";
	/**
	 * 中小企业版
	 */
	public static final String S_ZXQYB = "0502";
	/**
	 * ETF
	 */
	public static final String S_ETF = "0801";
	/**
	 * LOF
	 */
	public static final String S_LOF = "0802";



	/**
	 * 返回8位代码对应的市场id
	 *
	 * @return int 市场id
	 */
	public static int getMarketID(String stockCode) {

		int marketID = 1;//上证

		if("21".equals(stockCode.substring(0, 2))){//深证
			marketID = 2;
		}

		return marketID;
	}

	/**
	 * 返回股票代码对应的市场id
	 *
	 * @return int 市场id
	 */
	public static int getMarketIdByStock(String stockCode) {

		/*6 开头开 11 上证
		其他全部加 21*/

		int marketID = 2;//深证

		if(stockCode.startsWith("6")){//上证
			marketID = 1;
		}

		return marketID;
	}

}
