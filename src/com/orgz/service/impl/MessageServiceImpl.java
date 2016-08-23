package com.orgz.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.orgz.condition.SearchConditionOfMessage;
import com.orgz.dao.MessageDao;
import com.orgz.domain.Message;
import com.orgz.domain.PageBean;
import com.orgz.domain.User;
import com.orgz.service.MessageService;

@Service
@Transactional
public class MessageServiceImpl implements MessageService {
	@Resource
	MessageDao messageDao;

	@Override
	public int createMessage(int userId, Message message) {
		User user = new User();
		user.setUserId(userId);
		// 补齐数据
		message.setUser(user);
		int id = messageDao.insertMessage(message);
		return id;
	}

	@Override
	public int updateReplyCount(int messageId) {
		return messageDao.updateReplyCount(messageId);
	}

	@Override
	public int updateReplyCountReduce(int messageId, int count) {
		return messageDao.updateReplyCountReduce(messageId, count);
	}

	@Override
	public int updateLikebutton(int messageId) {
		return messageDao.updateLikebutton(messageId);
	}

	@Override
	public int updateLikebuttonReduce(int messageId) {
		return messageDao.updateLikebuttonReduce(messageId);
	}

	@Override
	public PageBean getPageBean(SearchConditionOfMessage mc, int numPerPage,
			int pageNum) {
		// 根据条件得到分页时的总记录数
		int recordCount = getMessageCount(mc);
		// 补全条件数据
		mc.setStart((pageNum - 1) * numPerPage);
		mc.setSize(numPerPage);
		// 得到记录
		List recordList = messageDao.selectByCondition(mc);
		PageBean pageBean = new PageBean(pageNum, numPerPage, recordCount,
				recordList);
		return pageBean;
	}

	@Override
	public int getMessageCount(SearchConditionOfMessage mc) {
		return messageDao.getMessageCount(mc);
	}

	@Override
	public Message getMessageById(int messageId) {
		return messageDao.getMessageById(messageId);
	}

	@Override
	public int deleteMessage(Message message) {
		return messageDao.deleteMessage(message);
	}

	@Override
	public Message getMessageByIdWithCheck(int userId, int messageId) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("userId", userId);
		params.put("messageId", messageId);
		return messageDao.getMessageByIdWithCheck(params);
	}

}
