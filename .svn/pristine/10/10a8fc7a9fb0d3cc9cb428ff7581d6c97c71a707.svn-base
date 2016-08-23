package com.orgz.service;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.orgz.domain.Activity;
import com.orgz.lbs.service.ActivityGeoService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={ "classpath:applicationContext.xml"})
public class ActivityGeoServiceTest {
	@Resource
	ActivityGeoService activityGeoService;
	
	@Test
	public void test() throws Exception{
//		ActivityGeoBean activityGeo = new ActivityGeoBean();
//		activityGeo.setActivity_id("4099");
		Activity activity = new Activity();
		activity.setActivityId(4099);
		System.out.println(activityGeoService.deleteActivity(activity));
	}
}
