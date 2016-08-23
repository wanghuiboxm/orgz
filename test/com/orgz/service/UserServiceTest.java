package com.orgz.service;

import javax.annotation.Resource;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.orgz.condition.SearchConditionOfUser;
import com.orgz.dao.UserDao;
import com.orgz.dao.impl.UserDaoImpl;
import com.orgz.domain.User;

/*
 * 这里必须要加这个两个注解，不然会报空指针错误
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={ "classpath:applicationContext.xml"})
public class UserServiceTest {

//	ApplicationContext application = null;
	@Before
	public void init(){
//		this.application = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
	}
		
	@Resource
	UserService userService;
	@Test
	public void testFindUserById(){
		User user = new User();
		user.setUserId(7);
//		user.setEmail("11@163.com");
//		user.setPhoneNumber("123456789");
//		user.setPassword("123");
//		User user = userService.findUserById(3);
//		System.out.println(user.getLatelyTime());
//		user = userService.findUserByEmail("11@163.com");
//		user = userService.findUserByPhoneNumber("123456789");
//		user = userService.validateUserByEmail(user);
//		user = userService.validateUserByPhoneNumber(user);
//		userService.updateLatelyTime(user);
//		System.out.println(user.getUserId());
//		UserDao userDao = new UserDaoImpl();
		SearchConditionOfUser su = new SearchConditionOfUser();
		su.setStart(0);
		su.setSize(10);
		System.out.println(userService.getPageBean(su, 1, 10).getRecordCount());
//		userService.updateLatelyTime(user);

	}
}
