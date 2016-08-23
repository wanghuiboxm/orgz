package com.orgz.dao.impl;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.orgz.base.BaseDaoImpl;
import com.orgz.condition.SearchConditionOfUser;
import com.orgz.dao.UserDao;
import com.orgz.domain.User;

@Repository
public class UserDaoImpl extends BaseDaoImpl implements UserDao {

	@Override
	public User findUserById(int id) {
		return getSession().selectOne("com.orgz.dao.UserMapper.findUserById", id);
	}

	@Override
	public User findUserByPhoneNumber(String phoneNumber) {
		return getSession().selectOne("com.orgz.dao.UserMapper.findUserByPhoneNumber", phoneNumber);
	}

	@Override
	public User findUserByEmail(String email) {
		return getSession().selectOne("com.orgz.dao.UserMapper.findUserByEmail", email);
	}

	@Override
	public User validateUserByEmail(User user) {
		return getSession().selectOne("com.orgz.dao.UserMapper.validateUserByEmail", user);
	}

	@Override
	public User validateUserByPhoneNumber(User user) {
		return getSession().selectOne("com.orgz.dao.UserMapper.validateUserByPhoneNumber", user);
	}

	@Override
	public int updateLatelyTimeByEmail(String email) {
		return getSession().update("com.orgz.dao.UserMapper.updateTimeWithEmail", email);
		
	}

	@Override
	public int updateLatelyTime(User user) {
		return getSession().update("com.orgz.dao.UserMapper.updateLatelyTime", user.getUserId());
	}

	@Override
	public List<User> listUserByCondition(SearchConditionOfUser uc) {
		return getSession().selectList("com.orgz.dao.UserMapper.listUser", uc);
	}

	@Override
	public int getUserCount() {
		return getSession().selectList("com.orgz.dao.UserMapper.userCount").size();
	}

	@Override
	public int updateUser(User user) {
		return getSession().update("com.orgz.dao.UserMapper.updateUser", user);
	}

	@Override
	public int insertUser(User user) {
		getSession().insert("com.orgz.dao.UserMapper.insertUser", user);
		return user.getUserId();
	}

	@Override
	public User validateUserById(User user) {
		return getSession().selectOne("com.orgz.dao.UserMapper.validateUserById", user);
	}

	@Override
	public User findUserByIdWithCheck(Map<String, Object> params) {
		return getSession().selectOne("com.orgz.dao.UserMapper.findUserByIdWithCheck", params);
	}


}
