package com.orgz.service;

import java.util.Iterator;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.orgz.condition.SearchConditionOfReply;
import com.orgz.domain.PageBean;
import com.orgz.domain.Reply;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:applicationContext.xml" })
public class ReplyServcieTest {
	@Resource
	ReplyService replyService;

	@Test
	public void test() {
		SearchConditionOfReply rc = new SearchConditionOfReply();
		rc.setMessageId(2);
		PageBean pages = replyService.getPageBean(rc, 20, 1);
		Iterator it = pages.getRecordList().iterator();
		while (it.hasNext()) {
			Reply reply = (Reply) it.next();
			System.out.println(reply.getUser().getUserName() + "****1"+reply.getUser().getUserIcon());

		}
	}
}
