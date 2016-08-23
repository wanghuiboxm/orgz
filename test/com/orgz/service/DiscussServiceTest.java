package com.orgz.service;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.orgz.base.SearchConditionOfDiscuss;
import com.orgz.domain.Discuss;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={ "classpath:applicationContext.xml"})
public class DiscussServiceTest {
	@Resource
	DiscussService discussService;
	
	@Test
	public void test(){
		SearchConditionOfDiscuss dc = new SearchConditionOfDiscuss();
		dc.setActivityId(2);
		Discuss dis = (Discuss) discussService.getPageBean(dc, 1, 0).getRecordList().get(5);
		System.out.println(dis.getParent().getDiscussContent());
	}
}
