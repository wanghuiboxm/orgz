package com.orgz.dao.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.orgz.base.BaseDaoImpl;
import com.orgz.dao.UserActivityStoreDao;
import com.orgz.domain.UserActivityStore;

@Repository
public class UserActivityStoreDaoImpl extends BaseDaoImpl implements
		UserActivityStoreDao {

	@Override
	public int insert(UserActivityStore userActivityStore) {
		return getSession().insert("com.orgz.dao.UserActivityStoreMapper.insertUserActivityStore", userActivityStore);
	}

	@Override
	public int deleteByActivityId(int activityId) {
		return getSession().delete("com.orgz.dao.UserActivityStoreMapper.deleteByActivityId", activityId);
	}

	@Override
	public UserActivityStore selectByUserIdAndActivityId(int activityId,
			int userId) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("userId", userId);
		params.put("activityId", activityId);
		return getSession().selectOne("com.orgz.dao.UserActivityStoreMapper.selectByUserIdAndActivityId", params);
	}

	@Override
	public int deleteByActivityIdAndUserId(int activityId, int userId) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("userId", userId);
		params.put("activityId", activityId);
		return getSession().delete("com.orgz.dao.UserActivityStoreMapper.deleteByActivityIdAndUserId", params);
	}

}
