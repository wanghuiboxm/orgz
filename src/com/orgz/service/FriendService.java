package com.orgz.service;

import java.util.List;

import com.orgz.domain.Friend;

public interface FriendService {
	public Friend findById(int friendId);
	public List<Friend> findByUserId(int userId);
	public Friend findByFriendUserIdAndUserId(Friend friend);
	public int updateNickname(Friend friend);
	public int delete(Friend friend);
	public int insert(Friend friend);
}
