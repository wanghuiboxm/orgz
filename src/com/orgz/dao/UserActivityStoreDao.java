package com.orgz.dao;

import com.orgz.domain.UserActivityStore;

/**
 * 用户收藏活动
 * @author qiukuiman
 *
 */
public interface UserActivityStoreDao {
	public int insert(UserActivityStore userActivityStore);
	/**
	 * 根据活动id删除记录
	 * @param activityId
	 * @return
	 */
	public int deleteByActivityId(int activityId);
	
	public UserActivityStore selectByUserIdAndActivityId(int activityId, int userId);
	public int deleteByActivityIdAndUserId(int activityId, int userId);
}
