package com.orgz.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.orgz.dao.UserSocietyDao;
import com.orgz.domain.UserSociety;
import com.orgz.service.UserSocietyService;

@Service
@Transactional
public class UserSocietyServiceImpl implements UserSocietyService {

	@Resource
	UserSocietyDao userSocietyDao;
	@Override
	public int insert(int userId, int societyId, String reason, int property) {
		UserSociety userSociety = new UserSociety(userId, societyId, reason, property);
		return userSocietyDao.insert(userSociety);
	}
	@Override
	public UserSociety findByUserIdAndSocietyId(int societyId, int userId) {
		UserSociety userSociety = new UserSociety(userId, societyId, null, 0);
		return userSocietyDao.selectByUserIdAndSocietyId(userSociety);
	}
	@Override
	public int deleteByUserIdAndSocietyId(int userId, int societyId) {
		return userSocietyDao.deleteByUserIdAndSocietyId(userId, societyId);
	}

}
