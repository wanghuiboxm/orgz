package com.orgz.domain;

import java.util.Date;

import org.apache.struts2.json.annotations.JSON;

public class UserSociety {
	private int userId;
	private int societyId;
	private String jionReason;
	private Date jionTime;
	private int property; //0代表社员

	public UserSociety(){}
	
	public UserSociety(int userId, int societyId, String jionReason, int property){
		this.userId = userId;
		this.societyId = societyId;
		this.jionReason = jionReason;
		this.property = property;
	}
	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getSocietyId() {
		return societyId;
	}

	public void setSocietyId(int societyId) {
		this.societyId = societyId;
	}

	public String getJionReason() {
		return jionReason;
	}

	public void setJionReason(String jionReason) {
		this.jionReason = jionReason;
	}

	@JSON(format = "yyyy-MM-dd HH:mm:ss")
	public Date getJionTime() {
		return jionTime;
	}

	public void setJionTime(Date jionTime) {
		this.jionTime = jionTime;
	}

	public int getProperty() {
		return property;
	}

	public void setProperty(int property) {
		this.property = property;
	}
}
