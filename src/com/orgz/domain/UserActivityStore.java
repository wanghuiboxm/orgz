package com.orgz.domain;

import java.util.Date;

import org.apache.struts2.json.annotations.JSON;

public class UserActivityStore {
	private int userId;
	private int activityId;
	private Date storeTime;

	public UserActivityStore(){}
	
	public UserActivityStore(int userId, int activityId) {
		super();
		this.userId = userId;
		this.activityId = activityId;
	}
	
	@JSON(format = "yyyy-MM-dd HH:mm:ss")
	public Date getStoreTime() {
		return storeTime;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getActivityId() {
		return activityId;
	}

	public void setActivityId(int activityId) {
		this.activityId = activityId;
	}

	public void setStoreTime(Date storeTime) {
		this.storeTime = storeTime;
	}

	
}
