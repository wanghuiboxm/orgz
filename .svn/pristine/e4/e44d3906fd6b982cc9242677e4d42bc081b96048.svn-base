package com.orgz.service;

import com.orgz.base.SearchConditionOfDiscuss;
import com.orgz.domain.Discuss;
import com.orgz.domain.PageBean;

public interface DiscussService {
	
	public Discuss findById(int discussId);
	
	/**
	 * 根据条件得到记录,当numPerPage=1,pageNum=1时，表示不分页，显示符合条件的所有记录
	 * @param dc 条件
	 * @param numPerPage 每页显示多少条记录
	 * @param pageNum  显示第几页 
	 * @return
	 */
	public PageBean getPageBean(SearchConditionOfDiscuss dc, int numPerPage, int pageNum);
	/**
	 * 
	 * @param discuss
	 * @return 插入的那条记录的id
	 */
	public int insertDiscuss(Discuss discuss, int activityId, int userId);
	/**
	 * 根据评论id或者活动id删除记录
	 * @param discussId
	 * @return 返回删除记录的条数
	 */
	public int deleteByCondition(SearchConditionOfDiscuss dc);
	public int deleteByDiscussId(int discussId);
	public int deleteByActivityId(int activityId);
	public boolean isHasReply(int discussId);
}
