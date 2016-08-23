package com.orgz.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.orgz.base.BaseDaoImpl;
import com.orgz.dao.FriendDao;
import com.orgz.domain.Friend;

@Repository
public class FriendDaoImpl extends BaseDaoImpl implements FriendDao {

	@Override
	public List<Friend> findByUserId(int userId) {
		return getSession().selectList("com.orgz.dao.FriendMapper.selectByUserId", userId);
	}

	@Override
	public Friend findByFriendUserIdAndUserId(Friend friend) {
		return getSession().selectOne("com.orgz.dao.FriendMapper.selectByFriendUserIdAndUserId", friend);
	}

	@Override
	public Friend findById(int friendId) {
		return getSession().selectOne("com.orgz.dao.FriendMapper.selectById", friendId);
	}

	@Override
	public int insertFriend(Friend friend) {
		getSession().insert("com.orgz.dao.FriendMapper.insert", friend);
		return friend.getFriendId();
	}

	@Override
	public int editNickname(Friend friend) {
		return getSession().update("com.orgz.dao.FriendMapper.updateFriend", friend);
	}

	@Override
	public int delete(Friend friend) {
		return getSession().delete("com.orgz.dao.FriendMapper.deleteFriend", friend);
	}

}
