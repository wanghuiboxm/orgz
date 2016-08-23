package com.orgz.dao;

import java.util.List;
import java.util.Map;

import com.orgz.base.SearchConditionOfActivity;
import com.orgz.domain.Activity;

public interface ActivityDao {
	/**
	 * 根据activityId得到活动，并且根据userId判断该用户是否收藏与点赞该活动
	 * @param params
	 * @return
	 */
	public Activity getActivityByIdWithCheck(Map<String, Object> params);
	public Activity getActivityById(int activityId);
	/**
	 * 通过条件查找活动
	 * @param ac
	 * @return
	 */
	public List<Activity> selectByCondition(SearchConditionOfActivity ac);
	/**
	 * 根据条件得到记录数
	 * @param ac
	 * @return
	 */
	public int getActivityCount(SearchConditionOfActivity ac);
	public List<Activity> getUserStoreActivity(int userId);
	/**
	 * 
	 * @param activity
	 * @return 返回插入活动的id
	 */
	public int insertActivity(Activity activity);
	public int updateDiscussCount(int activityId);
	public int updateDiscussCountReduce(int activityId, int count);
	public int updateLikebutton(int activityId);
	public int updateLikebuttonReduce(int activityId);
	public int deleteActivity(SearchConditionOfActivity ac);
}
