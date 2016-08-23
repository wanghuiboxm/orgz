package com.orgz.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.orgz.dao.MesPraiseDao;
import com.orgz.domain.MesPraise;
import com.orgz.domain.Message;
import com.orgz.domain.User;
import com.orgz.service.MesPraiseService;

@Service
@Transactional
public class MesPraiseServiceImpl implements MesPraiseService {

	@Resource
	MesPraiseDao mesPraiseDao;
	
	@Override
	public int insert(int userId, int messageId) {
		User user = new User();
		user.setUserId(userId);
		Message message = new Message();
		message.setMessageId(messageId);
		
		MesPraise mesPraise = new MesPraise();
		mesPraise.setUser(user);
		mesPraise.setMessage(message);
		
		return mesPraiseDao.insert(mesPraise);
	}

	@Override
	public int deleteByMessageId(int messageId) {
		return mesPraiseDao.deleteByMessageId(messageId);
	}

	@Override
	public int deleteByUserIdAndMessageId(int userId, int messageId) {
		return mesPraiseDao.deleteByUserIdAndMessageId(userId, messageId);
	}

	@Override
	public MesPraise findByUserIdAndMessageId(int userId, int messageId) {
		return mesPraiseDao.selectByUserIdAndMessageId(userId, messageId);
	}

}
