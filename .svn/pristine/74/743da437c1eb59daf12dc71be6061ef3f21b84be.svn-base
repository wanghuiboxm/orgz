package com.orgz.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.orgz.dao.FriendDao;
import com.orgz.domain.Friend;
import com.orgz.service.FriendService;

@Service
@Transactional
public class FriendServiceImpl implements FriendService {

	@Resource
	FriendDao friendDao;
	
	@Override
	public Friend findById(int friendId) {
		return friendDao.findById(friendId);
	}

	@Override
	public List<Friend> findByUserId(int userId) {
		return friendDao.findByUserId(userId);
	}

	@Override
	public Friend findByFriendUserIdAndUserId(Friend friend) {
		return friendDao.findByFriendUserIdAndUserId(friend);
	}

	@Override
	public int updateNickname(Friend friend) {
		return friendDao.editNickname(friend);
	}

	@Override
	public int delete(Friend friend) {
		return friendDao.delete(friend);
	}

	@Override
	public int insert(Friend friend) {
		return friendDao.insertFriend(friend);
	}

}
