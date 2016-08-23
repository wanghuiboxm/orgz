package com.orgz.domain;

import java.util.Date;

import org.apache.struts2.json.annotations.JSON;

public class Discuss {
	private int discussId;
	private String discussContent; // 最多可输入100个汉字
	private Date discussTime; // 评论时间
	private String discussTitle;
	private User user; // 评论人
	private Discuss parent; // 所回复的上一条评论
	private int activityId;


	public int getActivityId() {
		return activityId;
	}

	public void setActivityId(int activityId) {
		this.activityId = activityId;
	}

	public int getDiscussId() {
		return discussId;
	}

	public void setDiscussId(int discussId) {
		this.discussId = discussId;
	}

	public String getDiscussContent() {
		return discussContent;
	}

	public void setDiscussContent(String discussContent) {
		this.discussContent = discussContent;
	}

	@JSON(format = "yyyy-MM-dd HH:mm:ss")
	public Date getDiscussTime() {
		return discussTime;
	}

	public void setDiscussTime(Date discussTime) {
		this.discussTime = discussTime;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Discuss getParent() {
		return parent;
	}

	public void setParent(Discuss parent) {
		this.parent = parent;
	}

	public String getDiscussTitle() {
		return discussTitle;
	}

	public void setDiscussTitle(String discussTitle) {
		this.discussTitle = discussTitle;
	}
}
