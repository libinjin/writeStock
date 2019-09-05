package com.youguu.intelligent.util;


import com.youguu.core.logging.Log;
import com.youguu.core.logging.LogFactory;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class FileUtil {

	private static Log logger = LogFactory.getLog(FileUtil.class);


	public static void writeFinalContent(String filepath, String content) throws IOException {

		FileOutputStream out = null;
		File file = new File(filepath);

		if(file.exists()){
			file.delete();
		}

		if (!file.getParentFile().exists()) {
			file.getParentFile().mkdirs();
		}

		try {
			out = new FileOutputStream(filepath, false);
			out.write(content.getBytes("UTF-8"));
			logger.info("写入文件完毕，生成文件路径："+filepath);
		} catch (IOException e) {
			logger.info("写入文件失败");
		} finally {
			if (out != null) {
				out.close();
			}
		}
	}



	public static String readFinalURL(String filepath) {
		BufferedReader br = null;
		try {
			File file1 = new File(filepath);
			if (!file1.exists()) {
				return "noFile";
			}
			br = new BufferedReader(new InputStreamReader(new FileInputStream(filepath)));
			String str;
			while ((str = br.readLine()) != null) {
				return str;
			}
		} catch (Exception e) {
			logger.error("readFinalURL error ", e);
		} finally {
			if(br != null){
				try {
					br.close();
				} catch (IOException e) {
					logger.error("readFinalURL error ", e);
				}
			}
		}
		return null;
	}

}
