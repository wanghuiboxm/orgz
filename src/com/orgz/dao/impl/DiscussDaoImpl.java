package com.orgz.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.orgz.base.BaseDaoImpl;
import com.orgz.base.SearchConditionOfDiscuss;
import com.orgz.dao.DiscussDao;
import com.orgz.domain.Discuss;

@Repository
public class DiscussDaoImpl extends BaseDaoImpl implements DiscussDao {

	@Override
	public List<Discuss> selectByCondition(SearchConditionOfDiscuss dc) {
		return getSession().selectList("com.orgz.dao.DiscussMapper.listDiscuss", dc);
	}

	@Override
	public int insertDiscuss(Discuss discuss) {
		getSession().insert("com.orgz.dao.DiscussMapper.insertDiscuss", discuss);
		return discuss.getDiscussId();
	}

	@Override
	public int deleteByCondition(SearchConditionOfDiscuss dc) {
		return getSession().delete("com.orgz.dao.DiscussMapper.deleteDiscuss", dc);
	}

	@Override
	public int getDiscussCount(SearchConditionOfDiscuss dc) {
		return getSession().selectList("com.orgz.dao.DiscussMapper.discussCount", dc).size();
	}

	@Override
	public int isHasReply(int discussId) {
		return getSession().selectOne("com.orgz.dao.DiscussMapper.isHasReply", discussId);
	}

	@Override
	public Discuss findById(int discussId) {
		return getSession().selectOne("com.orgz.dao.DiscussMapper.selectById", discussId);
	}


}
