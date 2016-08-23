package com.orgz.base;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.stereotype.Repository;

public class BaseDaoImpl implements BaseDao {

	@Resource
	private SqlSessionFactory sqlSessionFactory;
	
	@Override
	public SqlSession getSession() {
		return sqlSessionFactory.openSession();
	}

}
