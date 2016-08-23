package com.orgz.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.orgz.condition.SearchConditionOfUser;
import com.orgz.dao.UserDao;
import com.orgz.domain.PageBean;
import com.orgz.domain.User;
import com.orgz.service.UserService;
import com.orgz.utils.BeanUtils;

@Service
@Transactional
public class UserServiceImpl implements UserService {

	@Resource
	UserDao userDao;
	
	@Override
	public User findUserById(int userId) {
		return userDao.findUserById(userId);
	}

	@Override
	public User findUserByEmail(String email) {
		return userDao.findUserByEmail(email);
	}

	@Override
	public User findUserByPhoneNumber(String phoneNumber) {
		return userDao.findUserByPhoneNumber(phoneNumber);
	}

	@Override
	public User validateUserByEmail(User user) {
		return userDao.validateUserByEmail(user);
	}

	@Override
	public User validateUserByPhoneNumber(User user) {
		return userDao.validateUserByPhoneNumber(user);
	}

	@Override
	public int registerUserWithEmail(User user) {
		//用户名字注册时默认是email
		user.setUserName(user.getEmail());
		return userDao.insertUser(user);
	}

	@Override
	public int updateLatelyTime(User user) {
		return userDao.updateLatelyTime(user);
	}

	@Override
	public PageBean getPageBean(SearchConditionOfUser uc, int pageNum, int numPerPage) {
		//得到符合条件的总记录数
		int recordCount = userDao.listUserByCondition(uc).size();
		//补全条件
		uc.setStart((pageNum-1)*numPerPage);
		uc.setSize(numPerPage);
		List recordList = userDao.listUserByCondition(uc);
		return new PageBean(pageNum, numPerPage, recordCount, recordList);
	}

	@Override
	public int updateUser(User user) {
		return userDao.updateUser(user);
	}

	@Override
	public int registerUserWithPhoneNumber(User user) {
//		user.setUserName(user.getPhoneNumber());
		//设置用户默认用户名
		user.setUserName(BeanUtils.phoneNumber2Name(user.getPhoneNumber()));
		return userDao.insertUser(user);
	}

	@Override
	public int insertUser(User user) {
		return userDao.insertUser(user);
	}

	@Override
	public User validateUserById(User user) {
		return userDao.validateUserById(user);
	}

	@Override
	public User findUserByIdWithCheck(int userId, int checkUserId) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("userId", userId);
		params.put("checkUserId", checkUserId);
		return userDao.findUserByIdWithCheck(params);
	}

}
