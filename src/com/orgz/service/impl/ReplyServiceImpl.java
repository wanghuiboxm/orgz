package com.orgz.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.orgz.condition.SearchConditionOfReply;
import com.orgz.dao.ReplyDao;
import com.orgz.domain.Message;
import com.orgz.domain.PageBean;
import com.orgz.domain.Reply;
import com.orgz.domain.User;
import com.orgz.service.ReplyService;

@Service
@Transactional
public class ReplyServiceImpl implements ReplyService {
	
	@Resource
	ReplyDao replyDao;
	
	@Override
	public PageBean getPageBean(SearchConditionOfReply rc, int numPerPage,
			int pageNum) {
		rc.setStart((pageNum-1)*numPerPage);
		rc.setSize(numPerPage);
		
		int recordCount = replyDao.getReplyCount(rc);
		List recordList = replyDao.selectByCondition(rc);
		PageBean pages  = new PageBean(pageNum, numPerPage, recordCount, recordList);
		return pages;
	}

	@Override
	public int insertReply(Reply reply, int messageId, int userId) {
		Message message = new Message();
		message.setMessageId(messageId);
		User user = new User();
		user.setUserId(userId);
		
		reply.setMessage(message);
		reply.setUser(user);
		
		return replyDao.insertReply(reply);
	}

	@Override
	public int deleteByReplyId(int replyId) {
		SearchConditionOfReply rc = new SearchConditionOfReply();
		rc.setReplyId(replyId);
		return replyDao.deleteByCondition(rc);
	}

	@Override
	public int deleteByMessage(int messageId) {
		SearchConditionOfReply rc = new SearchConditionOfReply();
		rc.setMessageId(messageId);
		return replyDao.deleteByCondition(rc);
	}

	@Override
	public boolean isHasReply(int replyId) {
		boolean result = false;
		if(replyDao.isHasReply(replyId) > 0){
			result = true;
		}
		return result;
	}

	@Override
	public int deleteByCondition(SearchConditionOfReply rc) {
		return replyDao.deleteByCondition(rc);
	}

	@Override
	public Reply getReplyById(int replyId) {
		return replyDao.getReplyById(replyId);
	}

}
