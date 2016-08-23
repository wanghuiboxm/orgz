package com.orgz.domain;

import java.util.Date;

import org.apache.struts2.json.annotations.JSON;

public class ActPraise {
	private int actpraiseId;
	private Date actpraiseTime;
	private Activity activity;
	private User user;

	public int getActpraiseId() {
		return actpraiseId;
	}
	public ActPraise(){}
	
	public ActPraise(Activity activity, User user) {
		super();
		this.activity = activity;
		this.user = user;
	}

	public void setActpraiseId(int actpraiseId) {
		this.actpraiseId = actpraiseId;
	}

	@JSON(format = "yyyy-MM-dd HH:mm:ss")
	public Date getActpraiseTime() {
		return actpraiseTime;
	}

	public void setActpraiseTime(Date actpraiseTime) {
		this.actpraiseTime = actpraiseTime;
	}

	public Activity getActivity() {
		return activity;
	}

	public void setActivity(Activity activity) {
		this.activity = activity;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
}
