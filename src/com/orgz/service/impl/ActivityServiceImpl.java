package com.orgz.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.orgz.base.SearchConditionOfActivity;
import com.orgz.dao.ActivityDao;
import com.orgz.domain.Activity;
import com.orgz.domain.PageBean;
import com.orgz.domain.Society;
import com.orgz.domain.User;
import com.orgz.service.ActivityService;

@Service
@Transactional
public class ActivityServiceImpl implements ActivityService {

	@Resource
	ActivityDao activityDao;
	
	@Override
	public int createActivity(int societyId, int userId, Activity activity) {
		//补全数据
		Society society = new Society();
		society.setSocietyId(societyId);
		User user = new User();
		user.setUserId(userId);
		activity.setSociety(society);
		activity.setFounder(user);
		//第一次创建点赞数和评论数都为0
		activity.setDiscussCount(0);
		activity.setActivityLikebutton(0);
		int result = activityDao.insertActivity(activity);
		return result;
	}

	@Override
	public int updateDiscussCount(int activityId) {
		return activityDao.updateDiscussCount(activityId);
	}

	@Override
	public int updateLikebutton(int activityId) {
		return activityDao.updateLikebutton(activityId);
	}

	@Override
	public PageBean getPageBean(SearchConditionOfActivity ac, int numPerPage, int pageNum) {
		//根据条件得到部分也时的总记录数
		int recordCount = getActivityCount(ac);
		//补全条件数据
		ac.setStart((pageNum-1)*numPerPage);
		ac.setSize(numPerPage);
		//得到记录
		List recordList = activityDao.selectByCondition(ac);
		PageBean pageBean = new PageBean(pageNum, numPerPage, recordCount, recordList);
		return pageBean;
	}

	@Override
	public int getActivityCount(SearchConditionOfActivity ac) {
		return activityDao.getActivityCount(ac);
	}

	@Override
	public Activity getActivityById(int activityId) {
		return activityDao.getActivityById(activityId);
	}

	@Override
	public int deleteActivity(SearchConditionOfActivity ac) {
		return activityDao.deleteActivity(ac);
	}

	@Override
	public int updateDiscussCountReduce(int activityId, int count) {
		return activityDao.updateDiscussCountReduce(activityId, count);
	}

	@Override
	public int updateLikebuttonReduce(int activityId) {
		return activityDao.updateLikebuttonReduce(activityId);
	}

	@Override
	public List<Activity> getUserStoreActivity(int userId) {
		return activityDao.getUserStoreActivity(userId);
	}

	@Override
	public Activity getActivityByIdWithCheck(int activityId, int userId) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("activityId", activityId);
		params.put("userId", userId);
		return activityDao.getActivityByIdWithCheck(params);
	}
}
