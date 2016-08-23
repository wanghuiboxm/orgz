package com.orgz.service;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.orgz.base.SearchConditionOfActivity;
import com.orgz.domain.PageBean;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={ "classpath:applicationContext.xml"})
public class ActivityServiceTest {
	@Resource
	ActivityService activityService;
	
	@Test
	public void test(){
		SearchConditionOfActivity ac = new SearchConditionOfActivity();
		ac.setSocietyId(1);
		ac.setActivityId(4131);
		PageBean pages = activityService.getPageBean(ac, 1, 0);
		System.out.println(activityService.getActivityById(4131).getActivityPhoto());
//		System.out.println(pages.getRecordList().size());
//		System.out.println(activityService.deleteActivity(ac));
	}
}
