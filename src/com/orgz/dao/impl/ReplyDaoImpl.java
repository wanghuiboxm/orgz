package com.orgz.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.orgz.base.BaseDaoImpl;
import com.orgz.condition.SearchConditionOfReply;
import com.orgz.dao.ReplyDao;
import com.orgz.domain.Reply;

@Repository
public class ReplyDaoImpl extends BaseDaoImpl implements ReplyDao {

	@Override
	public List<Reply> selectByCondition(SearchConditionOfReply rc) {
		return getSession().selectList("com.orgz.dao.ReplyMapper.listReply", rc);
	}

	@Override
	public int insertReply(Reply reply) {
		return getSession().insert("com.orgz.dao.ReplyMapper.insertReply", reply);
	}

	@Override
	public int deleteByCondition(SearchConditionOfReply rc) {
		return getSession().delete("com.orgz.dao.ReplyMapper.deleteReply", rc);
	}

	@Override
	public int getReplyCount(SearchConditionOfReply rc) {
		return getSession().selectOne("com.orgz.dao.ReplyMapper.replyCount", rc);
	}

	@Override
	public int isHasReply(int replyId) {
		return getSession().selectOne("com.orgz.dao.ReplyMapper.isHasReply", replyId);
	}

	@Override
	public Reply getReplyById(int replyId) {
		return getSession().selectOne("com.orgz.dao.ReplyMapper.selectById", replyId);
	}

}
