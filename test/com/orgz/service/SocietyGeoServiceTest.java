package com.orgz.service;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.orgz.domain.Society;
import com.orgz.lbs.service.SocietyGeoService;
import com.orgz.utils.BeanUtils;
import com.orgz.utils.ThreadPoolUtils;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={ "classpath:applicationContext.xml"})
public class SocietyGeoServiceTest {
	
	@Resource
	SocietyGeoService societyGeoService;
	@Resource
	ThreadPoolUtils threadUtils;
	
	@Test
	public void functionTest() throws Exception{
		Society society = new Society();
		society.setSocietyId(1);
		society.setSocietyName("生活部");
		society.setIntroduce("华中师范大学生活部");
		society.setProperty(1);
		society.setSchool("华中师范大学");
		society.setStatus(1);
		society.setProvince("湖北省");
		society.setCity("武汉市");
		society.setDistrict("洪山区");
		society.setAddress("湖北省武汉市洪山区华中师范大学");
		society.setSocietyIcon("image/society/1.jpg");
		SocietyGeoService ss = (SocietyGeoService) BeanUtils.copy(societyGeoService);
		ss.updateSocietyGeo(society);
//		System.out.println(societyGeoService.updateSocietyGeo(society));
//		System.out.println(societyGeoService.insertSocietyToGeo(society));
		threadUtils.invokeMethod(SocietyGeoService.class, "updateSocietyGeo",society, ss);
	}

}
