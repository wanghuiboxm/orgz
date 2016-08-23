package com.orgz.dao.impl;

import org.springframework.stereotype.Repository;

import com.orgz.base.BaseDaoImpl;
import com.orgz.dao.UserSocietyDao;
import com.orgz.domain.UserSociety;

@Repository
public class UserSocietyDaoImpl extends BaseDaoImpl implements UserSocietyDao {

	@Override
	public int insert(UserSociety userSociety) {
		return getSession().insert("com.orgz.dao.UserSocietyMapper.insertUserSociety", userSociety);
	}

	@Override
	public int update(UserSociety userScoiety) {
		return 0;
	}

	@Override
	public UserSociety selectByUserIdAndSocietyId(UserSociety userSociety) {
		return getSession().selectOne("com.orgz.dao.UserSocietyMapper.selectByUserIdAndSocietyId", userSociety );
	}

	@Override
	public int deleteByUserIdAndSocietyId(int userId, int societyId) {
		//构造参数
		UserSociety us = new UserSociety(userId, societyId, null, 0);
		return getSession().delete("com.orgz.dao.UserSocietyMapper.deleteByUserIdAndSocietyId", us);
	}

}
