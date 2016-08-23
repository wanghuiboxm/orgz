package com.orgz.service;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.orgz.domain.UserSociety;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={ "classpath:applicationContext.xml"})
public class UserActivityStoreServiceTest {
	@Resource
	UserSocietyService userSocietyService;
	
	@Test
	public void test(){
		UserSociety us = userSocietyService.findByUserIdAndSocietyId(7, 6);
//		int result = userSocietyService.insert(6, 7, "我喜欢", 0);
		System.out.println(us != null);
		
	}
}
