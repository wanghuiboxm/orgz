package com.spring;

import java.sql.SQLException;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.orgz.domain.User;

public class TestSpring {
	@Test
	public void testSpringContext() throws SQLException{
		/*
		 * Spring初始化容器.三种经常用到的实现：
		 * 一、ClassPathXmlApplicationContext:从类路径中加载。
		 * 二、FileSystemXmlApplicationContext:从文件系统加载。
		 * 三、XmlWebApplicationContext:从web系统中加载。
		 */

		ApplicationContext application = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
		SqlSessionFactory sqlSessionFactory = (SqlSessionFactory) application.getBean("sqlSessionFactory");
		SqlSession session = sqlSessionFactory.openSession();
//		System.out.println(application.getBean("userServiceImpl"));
		User user1 = new User();
		user1.setUserName("zhangsan");
		user1.setEmail("11@163.com");
		user1.setPassword("123");
//		session.insert("registUserByEmail", user1);
//		session.commit();
//		User user = session.selectOne("findUserById", 1);
//		System.out.println(user.getUserId() + user.getUserName() + user.getEmail() + user.getPassword());
//		System.out.println(user.toString());
	}
}
