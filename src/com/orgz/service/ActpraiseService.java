package com.orgz.service;

import com.orgz.domain.ActPraise;

public interface ActpraiseService {
	public int insert(int userId, int activityId);
	public int deleteByActivityId(int activityId);
	public int deleteByUserIdAndActivityId(int activityId, int userId);
	public ActPraise findByUserIdAndActivityId(int activityId, int userId);
}
