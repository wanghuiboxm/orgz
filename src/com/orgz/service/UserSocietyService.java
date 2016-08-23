package com.orgz.service;

import com.orgz.domain.UserSociety;

public interface UserSocietyService {
	public int insert(int userId, int societyId, String reason, int property);
	public UserSociety findByUserIdAndSocietyId(int societyId, int userId);
	public int deleteByUserIdAndSocietyId(int userId, int societyId);
}
