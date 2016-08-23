package com.orgz.service;

import com.orgz.condition.SearchConditionOfMessage;
import com.orgz.domain.Message;
import com.orgz.domain.PageBean;

public interface MessageService {
	public int createMessage(int userId, Message message);
	public int updateReplyCount(int messageId);
	public int updateReplyCountReduce(int messageId, int count);
	public int updateLikebutton(int messageId);
	public int updateLikebuttonReduce(int messageId);
	/**
	 * 根据条件得到留言
	 * @return
	 */
	public PageBean getPageBean(SearchConditionOfMessage mc, int numPerPage, int pageNum);
	/**
	 * 根据条件得到留言数量
	 * @param mc
	 * @return
	 */
	public int getMessageCount(SearchConditionOfMessage mc);
	/**
	 * 根据留言id精确查找留言
	 * @param messageId
	 * @return
	 */
	public Message getMessageById(int messageId);
	/**
	 * 根据留言id，当前用户id来得到message并检查当前用户是否对该留言点赞
	 * @param userId
	 * @param messageId
	 * @return
	 */
	public Message getMessageByIdWithCheck(int userId, int messageId);
	public int deleteMessage(Message message);
}
