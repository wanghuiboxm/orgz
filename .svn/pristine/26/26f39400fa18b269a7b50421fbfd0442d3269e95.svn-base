package com.orgz.service;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.orgz.admin.service.VersionService;
import com.orgz.domain.Friend;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={ "classpath:applicationContext.xml"})
public class VersionServiceTest {
	@Resource
	VersionService versionService;
	
	@Test
	public void test() {
		System.out.println(versionService.findAll().size());
	}
}
