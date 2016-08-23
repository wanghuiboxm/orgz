package com.orgz.domain;

import java.util.Date;

import org.apache.struts2.json.annotations.JSON;

public class Friend {
	private int friendId;
	private Date addTime;
	private String nickname;
	private int userId;
	private int friendUserId;
	private String friendIcon;
	private String friendName;
	
	
	public Friend(){}

	public Friend(String nickname, int userId, int friendUserId) {
		super();
		this.nickname = nickname;
		this.userId = userId;
		this.friendUserId = friendUserId;
	}

	public int getFriendId() {
		return friendId;
	}
	
	public void setFriendId(int friendId) {
		this.friendId = friendId;
	}
	
	@JSON(format="yyyy-MM-dd HH:mm:ss")
	public Date getAddTime() {
		return addTime;
	}

	public void setAddTime(Date addTime) {
		this.addTime = addTime;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getFriendUserId() {
		return friendUserId;
	}

	public void setFriendUserId(int friendUserId) {
		this.friendUserId = friendUserId;
	}

	public String getFriendIcon() {
		return friendIcon;
	}

	public void setFriendIcon(String friendIcon) {
		this.friendIcon = friendIcon;
	}

	public String getFriendName() {
		return friendName;
	}

	public void setFriendName(String friendName) {
		this.friendName = friendName;
	}

}
