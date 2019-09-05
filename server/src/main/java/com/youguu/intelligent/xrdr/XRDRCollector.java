package com.youguu.intelligent.xrdr;

import com.youguu.core.logging.Log;
import com.youguu.core.logging.LogFactory;
import com.youguu.intelligent.pojo.CommonStockInfo;
import com.youguu.intelligent.util.HttpUtil;
import com.youguu.intelligent.util.NumberUtil;
import com.youguu.intelligent.util.QuoteUtil;
import com.youguu.intelligent.util.StrategyCache;

import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.util.HashMap;
import java.util.Map;

public class XRDRCollector {
	private static Log logger = LogFactory.getLog(XRDRCollector.class);

	/**
	 * @param quoteURL
	 * @param stockcode
	 * @param marketid
	 */
	public static void getXrdrInfo(String quoteURL, String stockcode, int marketid){

		String code = QuoteUtil.convertTo8(stockcode, marketid);

		try {
			String url = quoteURL+"xrdrfactor"+"?code="+code+"&type=0";
			byte[] resbyte = HttpUtil.doGet(url);

			if(resbyte.length != 0){

				DataInputStream dis =  new DataInputStream(new ByteArrayInputStream(resbyte));
				for(int i=0;i<8;i++){
					dis.readByte();
				}
				//数据体
				CommonStockInfo com = null;
				com = unpackSimpleStockInfo(dis);
				int xrdrcount = dis.readShort();
				Map<Long, String> xrdrmap = new HashMap<>();
				for(int i=0;i<xrdrcount;i++){
					long date = dis.readInt();
					double mutifactor = NumberUtil.round((dis.readInt()/10000.0d), 4);
					double addfactor = NumberUtil.round(dis.readInt()/10000.0d, 4);
					xrdrmap.put(date, mutifactor+","+addfactor);
				}
				StrategyCache.stocksXRDR.put(stockcode, xrdrmap);
			}
		} catch (Exception e) {
			logger.error("XRDRCollector getXrdrInfo error....",e);
		}
	}

	public static CommonStockInfo unpackSimpleStockInfo(DataInputStream dis) throws Exception {
		byte[] bcode = new byte[6];
		byte[] bname = new byte[24];
		dis.read(bcode);
		dis.read(bname);
		int precision = dis.readByte();
		int marketid = dis.readByte(); // 市场
		CommonStockInfo cpyinfo = null;
		byte type = dis.readByte();
		cpyinfo = new CommonStockInfo();


		String code = new String(bcode,"UTF-8").trim();
		int blen = 0;
		for(int k=0;k<bname.length;k++){
			if((byte)0==bname[k]){
				blen = k;
				break;
			}
		}
		byte[] tname = new byte[blen];
		System.arraycopy(bname, 0, tname, 0, blen);
		String name = new String(tname,"UTF-8");
		cpyinfo.setCnName(name);
		cpyinfo.setStockCode(code);
		cpyinfo.setMarketId(marketid);
		cpyinfo.setType(type);
		boolean suspend = dis.readBoolean();
		cpyinfo.setSuspend(suspend);
		return cpyinfo;
	}

	public static void main(String args[]){

		XRDRCollector.getXrdrInfo("http://192.168.1.82:7073/quote/xrdrfactor", "600705", 1);
	}

}
