package com.orgz.service;

import com.orgz.condition.SearchConditionOfUser;
import com.orgz.domain.PageBean;
import com.orgz.domain.User;

public interface UserService {
	
	public User findUserById(int userId);
	/**
	 * 根据用户id和要查看用户的id来查找用户
	 * @param userId
	 * @param friendUserId
	 * @return
	 */
	public User findUserByIdWithCheck(int userId, int checkUserId);
	public User findUserByEmail(String email);
	public User findUserByPhoneNumber(String phoneNumber);
	public User validateUserById(User user);
	public User validateUserByEmail(User user);
	public User validateUserByPhoneNumber(User user);
	public int registerUserWithEmail(User user);
	public int registerUserWithPhoneNumber(User user);
	public int updateLatelyTime(User user);
	public PageBean getPageBean(SearchConditionOfUser uc, int pageNum, int numPerPage);
	public int updateUser(User user);
	public int insertUser(User user);
}
