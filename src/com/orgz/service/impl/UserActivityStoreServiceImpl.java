package com.orgz.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.orgz.dao.UserActivityStoreDao;
import com.orgz.domain.Activity;
import com.orgz.domain.User;
import com.orgz.domain.UserActivityStore;
import com.orgz.service.UserActivityStoreService;

@Service
@Transactional
public class UserActivityStoreServiceImpl implements UserActivityStoreService {

	@Resource
	UserActivityStoreDao userActivityStoreDao;
	
	@Override
	public int insert(int userId, int activityId) {
		UserActivityStore uas = new UserActivityStore(userId, activityId);
		return userActivityStoreDao.insert(uas);
	}

	@Override
	public int deleteByActivityId(int activityId) {
		return userActivityStoreDao.deleteByActivityId(activityId);
	}

	@Override
	public UserActivityStore findByUserIdAndActivityId(int activityId, int userId) {
		return userActivityStoreDao.selectByUserIdAndActivityId(activityId, userId);
	}

	@Override
	public int deleteByActivityIdAndUserId(int activityId, int userId) {
		return userActivityStoreDao.deleteByActivityIdAndUserId(activityId, userId);
	}

}
