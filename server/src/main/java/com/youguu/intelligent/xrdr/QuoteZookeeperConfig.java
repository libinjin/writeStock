package com.youguu.intelligent.xrdr;

import com.youguu.core.zookeeper.listener.base.DataChangedListener;
import com.youguu.core.zookeeper.pro.ZkPropertiesHelper;

import java.io.IOException;
import java.io.StringReader;
import java.util.Properties;

public class QuoteZookeeperConfig implements DataChangedListener {
	private String quoteURL ;
	private String generatefile;
	private String historyfolder;
	
	
	 public QuoteZookeeperConfig(){
         Properties quotepro = ZkPropertiesHelper.getCacheAndWatchProperties("quote", true);
         this.assignment(quotepro);
     }


	private void assignment(Properties quotepro) {
		quoteURL = quotepro.getProperty("quoteURL");
		String os = System.getProperty("os.name");
		if(os.startsWith("Windows")){
			historyfolder = "E:/quote";
			generatefile = "E:/data/intelligent/indexCal.json";
		}else{
			historyfolder = quotepro.getProperty("historyfolder");
			generatefile = quotepro.getProperty("generatefile");
		}
	}
	
	

	public String getQuoteURL() {
		return quoteURL;
	}


	public void setQuoteURL(String quoteURL) {
		this.quoteURL = quoteURL;
	}



	public String getHistoryfolder() {
		return historyfolder;
	}


	public void setHistoryfolder(String historyfolder) {
		this.historyfolder = historyfolder;
	}

	public String getGeneratefile() {
		return generatefile;
	}

	public void setGeneratefile(String generatefile) {
		this.generatefile = generatefile;
	}

	@Override
	public void reload(String data) {
		 Properties pro = new Properties();
         try {
             pro.load(new StringReader(data));
             this.assignment(pro);
         } catch (IOException e) {
             e.printStackTrace();
         }

		
	}

}
