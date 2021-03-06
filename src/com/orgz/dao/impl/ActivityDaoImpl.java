package com.orgz.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.orgz.base.BaseDaoImpl;
import com.orgz.base.SearchConditionOfActivity;
import com.orgz.dao.ActivityDao;
import com.orgz.domain.Activity;

@Repository
public class ActivityDaoImpl extends BaseDaoImpl implements ActivityDao {

	@Override
	public int insertActivity(Activity activity) {
		getSession().insert("com.orgz.dao.ActivityMapper.insertActivity", activity);
		return activity.getActivityId();
	}

	@Override
	public int updateDiscussCount(int activityId) {
		return getSession().update("com.orgz.dao.ActivityMapper.updateDiscussCount", activityId);
	}

	@Override
	public int updateLikebutton(int activityId) {
		return getSession().update("com.orgz.dao.ActivityMapper.updateLikebutton", activityId);
	}

	@Override
	public List<Activity> selectByCondition(SearchConditionOfActivity ac) {
		return getSession().selectList("com.orgz.dao.ActivityMapper.listActivity", ac);
	}

	@Override
	public int getActivityCount(SearchConditionOfActivity ac) {
		return getSession().selectOne("com.orgz.dao.ActivityMapper.activityCount", ac);
	}

	@Override
	public Activity getActivityById(int activityId) {
		return getSession().selectOne("com.orgz.dao.ActivityMapper.selectById", activityId);
	}

	@Override
	public int deleteActivity(SearchConditionOfActivity ac) {
		return getSession().delete("com.orgz.dao.ActivityMapper.deleteActivity", ac);
	}

	@Override
	public int updateDiscussCountReduce(int activityId, int count) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("activityId", activityId);
		params.put("count", count);
		return getSession().update("com.orgz.dao.ActivityMapper.updateDiscussCountReduce", params);
	}

	@Override
	public int updateLikebuttonReduce(int activityId) {
		return getSession().update("com.orgz.dao.ActivityMapper.updateLikebuttonReduce", activityId);
	}

	@Override
	public List<Activity> getUserStoreActivity(int userId) {
		return getSession().selectList("com.orgz.dao.ActivityMapper.listStoreByUserId", userId);
	}

	@Override
	public Activity getActivityByIdWithCheck(Map<String, Object> params) {
		return getSession().selectOne("com.orgz.dao.ActivityMapper.selectById", params);
	}



}
