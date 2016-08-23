package com.orgz.service;

import com.orgz.condition.SearchConditionOfReply;
import com.orgz.domain.PageBean;
import com.orgz.domain.Reply;

public interface ReplyService {
	public Reply getReplyById(int replyId);
	public PageBean getPageBean(SearchConditionOfReply rc, int numPerPage, int pageNum);
	public int insertReply(Reply reply, int messageId, int userId);
	public int deleteByReplyId(int replyId);
	public int deleteByMessage(int messageId);
	public boolean isHasReply(int replyId);
	public int deleteByCondition(SearchConditionOfReply rc);
}
