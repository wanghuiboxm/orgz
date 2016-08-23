package com.orgz.dao;

import java.util.List;

import com.orgz.domain.Friend;

public interface FriendDao {
	public List<Friend> findByUserId (int userId);
	public Friend findByFriendUserIdAndUserId(Friend friend);
	public Friend findById(int friendId);
	public int insertFriend(Friend friend);
	public int editNickname(Friend friend);
	public int delete(Friend friend);
	
}
