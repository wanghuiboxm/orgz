package com.orgz.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.orgz.dao.ActpraiseDao;
import com.orgz.domain.ActPraise;
import com.orgz.domain.Activity;
import com.orgz.domain.User;
import com.orgz.service.ActpraiseService;

@Service
@Transactional
public class ActpraiseServiceImpl implements ActpraiseService {

	@Resource
	ActpraiseDao actpraiseDao;
	@Override
	public int insert(int userId, int activityId) {
		//构造Actpraise
		User user = new User();
		user.setUserId(userId);
		Activity activity = new Activity();
		activity.setActivityId(activityId);
		ActPraise actPraise = new ActPraise(activity, user);
		return actpraiseDao.insert(actPraise);
	}

	@Override
	public int deleteByActivityId(int activityId) {
		return actpraiseDao.deleteByActivityId(activityId);
	}

	@Override
	public ActPraise findByUserIdAndActivityId(int activityId, int userId) {
		return actpraiseDao.selectByUserIdAndActivityId(userId, activityId);
	}

	@Override
	public int deleteByUserIdAndActivityId(int activityId, int userId) {
		return actpraiseDao.deleteByUserIdAndActivityId(userId, activityId);
	}

}
