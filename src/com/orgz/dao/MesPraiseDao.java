package com.orgz.dao;

import com.orgz.domain.MesPraise;

public interface MesPraiseDao {
	public int insert(MesPraise mesPraise);
	public int deleteByMessageId(int messageId);
	public int deleteByUserIdAndMessageId(int userId, int messageId);
	public MesPraise selectByUserIdAndMessageId(int userId, int messageId);
}
