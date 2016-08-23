package com.orgz.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.orgz.base.BaseDaoImpl;
import com.orgz.condition.SearchConditionOfMessage;
import com.orgz.dao.MessageDao;
import com.orgz.domain.Message;
@Repository
public class MessageDaoImpl extends BaseDaoImpl implements MessageDao {

	@Override
	public Message getMessageById(int messageId) {
		return getSession().selectOne("com.orgz.dao.MessageMapper.selectMessageById",messageId);
	}

	@Override
	public List<Message> selectByCondition(SearchConditionOfMessage mc) {
		return getSession().selectList("com.orgz.dao.MessageMapper.listMessage", mc);
	}

	@Override
	public int getMessageCount(SearchConditionOfMessage mc) {
		return getSession().selectOne("com.orgz.dao.MessageMapper.messageCount", mc);
	}

	@Override
	public int insertMessage(Message message) {
		getSession().insert("com.orgz.dao.MessageMapper.insertMessage", message);
		return message.getMessageId();
	}

	@Override
	public int updateReplyCount(int messageId) {
		return getSession().update("com.orgz.dao.MessageMapper.updateReplyCount", messageId);
	}

	@Override
	public int updateReplyCountReduce(int messageId, int count) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("messageId", messageId);
		params.put("count", count);
		return getSession().update("com.orgz.dao.MessageMapper.updateReplyCountReduce", params);
	}

	@Override
	public int updateLikebutton(int messageId) {
		return getSession().update("com.orgz.dao.MessageMapper.updateLikebutton", messageId);
	}

	@Override
	public int updateLikebuttonReduce(int messageId) {
		return getSession().update("com.orgz.dao.MessageMapper.updateLikebuttonReduce", messageId);
	}

	@Override
	public int deleteMessage(Message message) {
		return getSession().delete("com.orgz.dao.MessageMapper.deleteMessage", message);
	}

	@Override
	public Message getMessageByIdWithCheck(Map<String, Object> params) {
		return getSession().selectOne("com.orgz.dao.MessageMapper.selectMessageByIdWithCheck",params);
	}

}
