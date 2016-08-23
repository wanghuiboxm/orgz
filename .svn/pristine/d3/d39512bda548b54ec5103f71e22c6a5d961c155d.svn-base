package com.orgz.service;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.orgz.domain.Friend;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={ "classpath:applicationContext.xml"})
public class FriendServiceTest {
	@Resource
	FriendService friendService;
	
	@Test
	public void test() {
		Friend  friend = new Friend(null, 1, 7);
		Friend f = friendService.findByFriendUserIdAndUserId(friend);
		System.out.println(f != null);
	}
}
