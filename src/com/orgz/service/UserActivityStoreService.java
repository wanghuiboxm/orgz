package com.orgz.service;

import com.orgz.domain.UserActivityStore;

public interface UserActivityStoreService {
	public int insert(int userId, int activityId);
	public int deleteByActivityId(int activityId);
	public int deleteByActivityIdAndUserId(int activityId, int userId);
	public UserActivityStore findByUserIdAndActivityId(int activityId, int userId);
}
