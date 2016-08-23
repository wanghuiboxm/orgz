package com.orgz.dao.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.orgz.base.BaseDaoImpl;
import com.orgz.dao.ActpraiseDao;
import com.orgz.domain.ActPraise;

@Repository
public class ActpraiseDaoImpl extends BaseDaoImpl implements ActpraiseDao {

	@Override
	public int insert(ActPraise actPraise) {
		 getSession().insert("com.orgz.dao.ActPraiseMapper.insertActpraise", actPraise);
		 return actPraise.getActpraiseId();
	}

	@Override
	public int deleteByActivityId(int activityId) {
		return getSession().delete("com.orgz.dao.ActPraiseMapper.deleteByActivityId", activityId);
	}

	@Override
	public ActPraise selectByUserIdAndActivityId(int userId, int activityId) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("userId", userId);
		params.put("activityId", activityId);
		return getSession().selectOne("com.orgz.dao.ActPraiseMapper.selectByUserIdAndActivityId", params);
	}

	@Override
	public int deleteByUserIdAndActivityId(int userId, int activityId) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("userId", userId);
		params.put("activityId", activityId);
		return getSession().delete("com.orgz.dao.ActPraiseMapper.deleteByUserIdAndActivityId", params);
	}

}
