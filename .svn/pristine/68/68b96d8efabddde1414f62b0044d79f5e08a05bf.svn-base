package com.orgz.domain;

import java.util.Date;

import org.apache.struts2.json.annotations.JSON;

public class MesPraise {
	private int mesPraiseId;
	private Date mesPraiseTime; // 点赞的时间
	private User user; // 点赞的人
	private Message message; // 点赞对应的留言

	public int getMesPraiseId() {
		return mesPraiseId;
	}

	public void setMesPraiseId(int mesPraiseId) {
		this.mesPraiseId = mesPraiseId;
	}

	@JSON(format = "yyyy-MM-dd HH:mm:ss")
	public Date getMesPraiseTime() {
		return mesPraiseTime;
	}

	public void setMesPraiseTime(Date mesPraiseTime) {
		this.mesPraiseTime = mesPraiseTime;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Message getMessage() {
		return message;
	}

	public void setMessage(Message message) {
		this.message = message;
	}
}
