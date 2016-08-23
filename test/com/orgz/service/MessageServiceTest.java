package com.orgz.service;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.orgz.condition.SearchConditionOfMessage;
import com.orgz.domain.Message;
import com.orgz.domain.PageBean;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={ "classpath:applicationContext.xml"})
public class MessageServiceTest {

	@Resource
	MessageService messageService;
	
	@Test
	public void test(){
		Message message = new Message();
		message.setMessageContent("今天天气真是好");
//		System.out.println(messageService.createMessage(3, message));
//		System.out.println(messageService.updateReplyCount(1));
//		System.out.println(messageService.updateReplyCountReduce(1));
//		System.out.println(messageService.updateLikebutton(1));
//		System.out.println(messageService.updateLikebuttonReduce(1));
		SearchConditionOfMessage mc = new SearchConditionOfMessage();
		mc.setUserId(3);
//		PageBean pages = messageService.getPageBean(mc, 20, 1);
//		System.out.println(pages.getRecordList().size());
//		System.out.println(messageService.deleteMessage(message));
		System.out.println(messageService.getMessageById(2).getUser().getUserName());
	}
}
