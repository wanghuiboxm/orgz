package com.orgz.dao;

import com.orgz.domain.ActPraise;

/**
 * 活动点赞
 * @author qiukuiman
 *
 */

public interface ActpraiseDao {
	/**
	 * 插入用户点赞信息
	 * @return 返回插入点赞记录的id
	 */
	public int insert(ActPraise actPraise);
	/**
	 * 通过活动id删除记录
	 * @return
	 */
	public int deleteByActivityId(int activityId);
	public int deleteByUserIdAndActivityId(int userId, int activityId);
	
	public ActPraise selectByUserIdAndActivityId(int userId, int activityId);
}
