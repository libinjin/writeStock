package com.youguu.intelligent.dao;

import com.youguu.core.dao.SqlDAO;
import org.apache.ibatis.session.SqlSessionFactory;

import javax.annotation.Resource;

public class GangAoDAOBase<T> extends SqlDAO<T> {


	@Resource(name = "gangaoSessionFactory")
	@Override
	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory){
		super.setSqlSessionFactory(sqlSessionFactory);
	}


}
