package com.youguu.intelligent.base;

import com.youguu.core.dao.DataSourceLoader;
import com.youguu.core.dao.multi.MultiDataSourceTransactionManager;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

@Configuration
@ComponentScan({"com.youguu.*"})
@EnableTransactionManagement
@EnableAspectJAutoProxy(proxyTargetClass=true)
@EnableScheduling
public class ContextLoader extends DataSourceLoader{


	public DataSource getDataSource(String selector, String beanName){
		return load(selector, beanName);
	}


	@Bean
	public SqlSessionFactory gangaoSessionFactory() throws Exception {

		SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
		//1.datasource
		bean.setDataSource(getDataSource("datacenter","datacenterDS"));

		//2.configure
		DefaultResourceLoader dc = new DefaultResourceLoader();

		bean.setConfigLocation(dc.getResource("classpath:mybatis/datacenter-mapper-config.xml"));

		return bean.getObject();
	}
	
}
