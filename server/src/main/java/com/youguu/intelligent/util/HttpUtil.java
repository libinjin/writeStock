package com.youguu.intelligent.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Map;

@SuppressWarnings("unchecked")
public class HttpUtil {

	final static Logger logger = LoggerFactory.getLogger(HttpUtil.class);
	private final static String DEFAULT_ENCODING = "UTF-8";
	public static byte[] doPost(String strUrl, byte[] reqData) {
		try {
			URL url = new URL(strUrl);
			HttpURLConnection httpcon = (HttpURLConnection) url
					.openConnection();

			httpcon.setDoOutput(true);
			httpcon.setDoInput(true);
			httpcon.setUseCaches(false);
			httpcon.setInstanceFollowRedirects(true);

			httpcon.setRequestMethod("POST");
			
			//设置30分钟超时
			httpcon.setConnectTimeout(30 * 1000);
			httpcon.setReadTimeout(30 * 1000);
			
			httpcon.connect();
			OutputStream os = httpcon.getOutputStream();
			os.write(reqData);
			os.flush();
			InputStream is = httpcon.getInputStream();
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			byte[] buf = new byte[4096];
			for (int len = 0; (len = is.read(buf)) != -1;) {
				baos.write(buf, 0, len);
			}
			is.close();

			byte[] resData = baos.toByteArray();
			baos.close();
			httpcon.disconnect();
			return resData;
		} catch (Exception ex) {
			logger.error(ex.toString(), ex);
			return null;
		}
	}

	public static byte[] doGet(String strUrl) {
		try {
			URL url = new URL(strUrl);
			HttpURLConnection httpcon = (HttpURLConnection) url
					.openConnection();

			httpcon.setDoOutput(false);
			httpcon.setDoInput(true);
			httpcon.setUseCaches(false);
			httpcon.setInstanceFollowRedirects(true);

			httpcon.setRequestMethod("GET");

			//设置10分钟超时
			httpcon.setConnectTimeout(10*10 *1000);
			httpcon.setReadTimeout(10*10 *1000);
			httpcon.connect();
			InputStream is = httpcon.getInputStream();

			ByteArrayOutputStream baos = new ByteArrayOutputStream();
//			DataInputStream dis = new DataInputStream(is);
//			short len1 = dis.readShort();
//			System.out.println(len1);
			byte[] buf = new byte[4096];
			for (int len = 0; (len = is.read(buf)) != -1;) {
				baos.write(buf, 0, len);
			}
			is.close();

			byte[] resData = baos.toByteArray();
			baos.close();
			httpcon.disconnect();
			return resData;
		} catch (Exception ex) {
			logger.error("HttpUtil request " + strUrl + " error", ex);
			return null;
		}
	}
	
	
	
	public static DataInputStream doGet1(String strUrl) {
		try {
			URL url = new URL(strUrl);
			HttpURLConnection httpcon = (HttpURLConnection) url
					.openConnection();

			httpcon.setDoOutput(false);
			httpcon.setDoInput(true);
			httpcon.setUseCaches(false);
			httpcon.setInstanceFollowRedirects(true);

			httpcon.setRequestMethod("GET");
			
			//设置10分钟超时
			httpcon.setConnectTimeout(10 *1000);
			httpcon.setReadTimeout(10*1000);
			httpcon.connect();
			InputStream is = httpcon.getInputStream();

			return new DataInputStream(is);
		} catch (Exception ex) {
			logger.error("HttpUtil request " + strUrl + " error", ex);
			return null;
		}
	}

	public static byte[] doGet(String strUrl, int timepout) {
		try {
			URL url = new URL(strUrl);
			HttpURLConnection httpcon = (HttpURLConnection) url
					.openConnection();

			httpcon.setDoOutput(false);
			httpcon.setDoInput(true);
			httpcon.setUseCaches(false);
			httpcon.setInstanceFollowRedirects(true);

			httpcon.setRequestMethod("GET");
			
			//设置超时
			httpcon.setConnectTimeout(timepout *1000);
			httpcon.setReadTimeout(timepout *1000);
			httpcon.connect();
			InputStream is = httpcon.getInputStream();
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			byte[] buf = new byte[4096];
			for (int len = 0; (len = is.read(buf)) != -1;) {
				baos.write(buf, 0, len);
			}
			is.close();

			byte[] resData = baos.toByteArray();
			baos.close();
			httpcon.disconnect();
			return resData;
		} catch (Throwable ex) {
			logger.error(ex.toString());
			return null;
		}
	}
	
	
	public static byte[] doPost(String url, Map params) {
		return send(url, "POST", params, null);
	}

	private static byte[] send(String urlString, String method,
                               Map<String, String> parameters, Map<String, String> propertys) {
		HttpURLConnection urlConnection = null;
		try {
			if (method.equalsIgnoreCase("GET") && parameters != null) {
				StringBuffer param = new StringBuffer();
				int i = 0;
				for (String key : parameters.keySet()) {
					if (i == 0)
						param.append("?");
					else
						param.append("&amp;");
					param.append(URLEncoder.encode(key,DEFAULT_ENCODING)).append("=").append(URLEncoder.encode(parameters.get(key),DEFAULT_ENCODING));
					i++;
				}
				urlString += param;
			}
			URL url = new URL(urlString);
			urlConnection = (HttpURLConnection) url.openConnection();

			urlConnection.setRequestMethod(method);
			urlConnection.setDoOutput(true);
			urlConnection.setDoInput(true);
			urlConnection.setUseCaches(false);
			
			//设置10分钟超时
			urlConnection.setConnectTimeout(10 *1000);
			urlConnection.setReadTimeout(10*1000);

			if (propertys != null)
				for (String key : propertys.keySet()) {
					urlConnection.addRequestProperty(key, propertys.get(key));
				}

			if (method.equalsIgnoreCase("POST") && parameters != null) {
				StringBuilder param = new StringBuilder();
				for (String key : parameters.keySet()) {
					param.append("&");
					param.append(URLEncoder.encode(key,DEFAULT_ENCODING)).append("=").append(URLEncoder.encode(parameters.get(key),DEFAULT_ENCODING));
				}
				urlConnection.getOutputStream().write(
						param.toString().getBytes());
				urlConnection.getOutputStream().flush();
				urlConnection.getOutputStream().close();
			}
		} catch (Exception ex) {
			logger.error(ex.toString(), ex);
		}
		return makeContent(urlString, urlConnection);
	}

	/**
	 * 得到响应对象
	 * 
	 * @param urlConnection
	 * @return 响应对象
	 * @throws IOException
	 */
	private static byte[] makeContent(String urlString,
                                      HttpURLConnection urlConnection) {
		try {	
		InputStream is = urlConnection.getInputStream();
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		byte[] buf = new byte[4096];
		for (int len = 0; (len = is.read(buf)) != -1;) {
			baos.write(buf, 0, len);
		}
		is.close();

		byte[] resData = baos.toByteArray();
		baos.close();
		urlConnection.disconnect();
		return resData;
		} catch (Exception e) {
			logger.error(e.toString(),e);
			return null;
		} finally {
			if (urlConnection != null)
				urlConnection.disconnect();
		}
	}
}
