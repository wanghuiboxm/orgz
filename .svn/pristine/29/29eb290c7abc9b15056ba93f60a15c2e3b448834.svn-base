package com.orgz.dao;

import java.util.List;
import java.util.Map;

import com.orgz.condition.SearchConditionOfMessage;
import com.orgz.domain.Message;

public interface MessageDao {
	public Message getMessageById(int messageId);
	
	public Message getMessageByIdWithCheck(Map<String, Object> params);
	/**
	 * 通过条件查找留言
	 * @param mc
	 * @return
	 */
	public List<Message> selectByCondition(SearchConditionOfMessage mc);
	/**
	 * 根据条件得到记录数
	 * @param mc
	 * @return
	 */
	public int getMessageCount(SearchConditionOfMessage mc);
	/**
	 * 
	 * @param activity
	 * @return 返回插入留言的id
	 */
	public int insertMessage(Message message);
	public int updateReplyCount(int messageId);
	public int updateReplyCountReduce(int messageId, int count);
	public int updateLikebutton(int messageId);
	public int updateLikebuttonReduce(int messageId);
	public int deleteMessage(Message message);
}
