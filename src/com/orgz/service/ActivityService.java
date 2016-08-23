package com.orgz.service;

import java.util.List;
import java.util.Map;

import com.orgz.base.SearchConditionOfActivity;
import com.orgz.domain.Activity;
import com.orgz.domain.PageBean;

public interface ActivityService {
	public int createActivity(int societyId, int userId, Activity activity);
	public int updateDiscussCount(int activityId);
	public int updateDiscussCountReduce(int activityId, int count);
	public int updateLikebutton(int activityId);
	public int updateLikebuttonReduce(int activityId);
	/**
	 * 根据条件得到社团下的所有活动
	 * @param activity
	 * @return
	 */
	public PageBean getPageBean(SearchConditionOfActivity ac, int numPerPage, int pageNum);
	/**
	 * 根据activityId得到活动，并且根据userId判断该用户是否收藏与点赞该活动
	 * @param activityId
	 * @param userId
	 * @return
	 */
	public Activity getActivityByIdWithCheck(int activityId, int userId);
	/**
	 * 根据条件得到社团下的活动数
	 * @param ac
	 * @return
	 */
	public int getActivityCount(SearchConditionOfActivity ac);
	/**
	 * 根据活动id精确查找活动
	 * @param activityId
	 * @return
	 */
	public Activity getActivityById(int activityId);
	public List<Activity> getUserStoreActivity(int userId);
	
	public int deleteActivity(SearchConditionOfActivity ac);
}
