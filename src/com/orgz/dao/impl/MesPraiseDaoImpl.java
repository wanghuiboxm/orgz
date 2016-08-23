package com.orgz.dao.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.orgz.base.BaseDaoImpl;
import com.orgz.dao.MesPraiseDao;
import com.orgz.domain.MesPraise;

@Repository
public class MesPraiseDaoImpl extends BaseDaoImpl implements MesPraiseDao {

	@Override
	public int insert(MesPraise mesPraise) {
		getSession().insert("com.orgz.dao.MesPraiseMapper.insertMesPraise", mesPraise);
		return mesPraise.getMesPraiseId();
	}

	@Override
	public int deleteByMessageId(int messageId) {
		return getSession().delete("com.orgz.dao.MesPraiseMapper.deleteByMessageId", messageId);
	}

	@Override
	public int deleteByUserIdAndMessageId(int userId, int messageId) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("userId", userId);
		params.put("messageId", messageId);
		return getSession().delete("com.orgz.dao.MesPraiseMapper.deleteByUserIdAndMessageId", params);
	}

	@Override
	public MesPraise selectByUserIdAndMessageId(int userId, int messageId) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("userId", userId);
		params.put("messageId", messageId);
		return getSession().selectOne("com.orgz.dao.MesPraiseMapper.selectByUserIdAndMessageId", params);
	}

}
