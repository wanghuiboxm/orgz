package com.orgz.dao;

import com.orgz.domain.UserSociety;

public interface UserSocietyDao {
	public int insert(UserSociety userSociety);
	public int update(UserSociety userScoiety);
	public UserSociety selectByUserIdAndSocietyId(UserSociety userSociety);
	public int deleteByUserIdAndSocietyId(int userId, int societyId);
}
