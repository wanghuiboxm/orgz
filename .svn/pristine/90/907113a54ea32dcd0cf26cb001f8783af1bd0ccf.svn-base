package com.orgz.dao;

import java.util.List;

import com.orgz.condition.SearchConditionOfReply;
import com.orgz.domain.Reply;

public interface ReplyDao {
	public Reply getReplyById(int replyId);
	public List<Reply> selectByCondition(SearchConditionOfReply rc);
	public int insertReply(Reply reply);
	public int deleteByCondition(SearchConditionOfReply rc);
	public int getReplyCount(SearchConditionOfReply rc);
	public int isHasReply(int replyId);
}
