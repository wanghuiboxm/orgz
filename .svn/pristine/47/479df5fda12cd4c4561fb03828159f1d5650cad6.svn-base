package com.orgz.dao;

import java.util.List;
import java.util.Map;

import com.orgz.base.BaseDao;
import com.orgz.condition.SearchConditionOfUser;
import com.orgz.domain.User;

public interface UserDao extends BaseDao {
	
	public User findUserById(int id);
	public User findUserByIdWithCheck(Map<String, Object> params);
	public User findUserByPhoneNumber(String number);
	public User findUserByEmail(String email);
	public User validateUserById(User user);
	public User validateUserByEmail(User user);
	public User validateUserByPhoneNumber(User user);
	public int insertUser(User user);
	public int updateLatelyTimeByEmail(String email);
	public int updateLatelyTime(User user);
	public int getUserCount();
	public int updateUser(User user);
	public List<User> listUserByCondition(SearchConditionOfUser uc);
}
