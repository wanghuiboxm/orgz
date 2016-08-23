package com.mybatis;

import java.io.IOException;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import com.user.User;

public class TestMybatis {

	@Test
	public void testSelect(){
		try {
			Reader reader = Resources.getResourceAsReader("Sqlconfig.xml");
			SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader, "development1");
			SqlSession session = sqlSessionFactory.openSession();
			System.out.println("开始执行");
			com.user.User user = session.selectOne("selectUserById", 6);
//			User user = new User();
//			user.setId(3);
//			user.setName("张三");
//			session.insert("insertUser", user);
//			session.commit();
			System.out.println(user.getId()+"*****" + user.getName());
			session.close();
			reader.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
