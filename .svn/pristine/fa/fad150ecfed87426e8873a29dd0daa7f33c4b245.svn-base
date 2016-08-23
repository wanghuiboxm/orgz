package com.orgz.service;

import javax.annotation.Resource;

import org.apache.commons.codec.digest.DigestUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.orgz.admin.domain.Admin;
import com.orgz.admin.service.AdminService;
import com.orgz.domain.PageBean;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={ "classpath:applicationContext.xml"})
public class AdminServiceTest {

	@Resource
	AdminService adminService;
	
	@Test
	public void test() {
		Admin admin = new Admin();
		admin.setAdminId(1);
		admin.setPassword(DigestUtils.md5Hex("123456"));
		admin.setAdminName("admin");
		System.out.println(DigestUtils.md5Hex("123456"));
		System.out.println(adminService.getByIdAndPassword(admin).getAdminName());
//		Admin test = adminService.getById(admin);
//		System.out.println(test != null);
//		PageBean pages = adminService.getPageBean();
//		System.out.println(pages.getRecordList().size());
//		admin.setAdminName("admin");
//		System.out.println(admin.getAdminName() == "admin");
	}
}
