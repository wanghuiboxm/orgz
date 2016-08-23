package com.orgz.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.orgz.base.SearchConditionOfDiscuss;
import com.orgz.dao.DiscussDao;
import com.orgz.domain.Discuss;
import com.orgz.domain.PageBean;
import com.orgz.domain.User;
import com.orgz.service.DiscussService;

@Service
@Transactional
public class DiscussServiceImpl implements DiscussService {
	
	@Resource
	DiscussDao discussDao;
	
	@Override
	public PageBean getPageBean(SearchConditionOfDiscuss dc, int numPerPage, int pageNum) {
		//补全条件
		dc.setStart((pageNum-1)*numPerPage);
		dc.setSize(numPerPage);
		//根据条件得到记录
		int recordCount = discussDao.getDiscussCount(dc);
		List recordList = discussDao.selectByCondition(dc);
		//构造pagebean
		PageBean pages = new PageBean(pageNum, numPerPage, recordCount, recordList);
		return pages;
	}

	@Override
	public int insertDiscuss(Discuss discuss, int activityId, int userId) {
		//补齐数据
		User user = new User();
		user.setUserId(userId);
		discuss.setUser(user);
		discuss.setActivityId(activityId);
		return discussDao.insertDiscuss(discuss);
	}

	@Override
	public int deleteByCondition(SearchConditionOfDiscuss dc) {
		return discussDao.deleteByCondition(dc);
	}

	@Override
	public int deleteByDiscussId(int discussId) {
		SearchConditionOfDiscuss dc = new SearchConditionOfDiscuss();
		dc.setDiscussId(discussId);
		return discussDao.deleteByCondition(dc);
	}

	@Override
	public int deleteByActivityId(int activityId) {
		SearchConditionOfDiscuss dc = new SearchConditionOfDiscuss();
		dc.setActivityId(activityId);
		return discussDao.deleteByCondition(dc);
	}

	@Override
	public boolean isHasReply(int discussId) {
		boolean result = false;
		if(discussDao.isHasReply(discussId) > 0){
			result = true;
		}
		return result;
	}

	@Override
	public Discuss findById(int discussId) {
		return discussDao.findById(discussId);
	}


}
