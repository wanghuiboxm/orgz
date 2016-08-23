package com.orgz.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.struts2.json.annotations.JSON;

public class Activity {
	private int activityId;
	private String title; // 活动主题
	private String activityContent; // 活动内容
	private Date startTime; // 开始时间
	private Date endTime; // 结束时间
	private int discussCount; // 评论数
	private int activityLikebutton; // 点赞数
	private String province;
	private String city;
	private String district;
	private String address;
	private String activityPhoto;
	private Date publishTime;
	private int storeFlag; //是否收藏，非0代表用户已收藏
	private int likeFlag;  //是否点赞，非0代表已点赞过
	private Society society; // 活动所属社团
	private User founder; // 活动发起人
	// private List<User> storedPeople = new ArrayList<User>(); //收藏了该活动的人
	// private List<User> praisedPeople = new ArrayList<User>(); //点赞了的人
	// private List<Discuss> discuss = new ArrayList<Discuss>(); //活动的评论

	@Override
	public String toString() {
		return "Activity [activityId=" + activityId + ", title=" + title
				+ ", activityContent=" + activityContent + ", startTime="
				+ startTime + ", endTime=" + endTime + ", discussCount="
				+ discussCount + ", activityLikebutton=" + activityLikebutton
				+ ", province=" + province + ", city=" + city + ", district="
				+ district + ", address=" + address + ", activityPhoto="
				+ activityPhoto + ", society=" + society + ", founder="
				+ founder + ", storedPeople=" + ", praisedPeople="
				+ ", discuss=" + "]";
	}


	@JSON(serialize=false)
	public boolean isMatchCodition() {
		if (activityContent != null && title != null && endTime != null && startTime != null
				&& province != null && city != null
				&& district != null && address != null) {
			return true;
		}
		return false;
	}
	
	public Society getSociety() {
		return society;
	}

	public void setSociety(Society society) {
		this.society = society;
	}

	public User getFounder() {
		return founder;
	}

	public void setFounder(User founder) {
		this.founder = founder;
	}

//	public List<User> getStoredPeople() {
//		return storedPeople;
//	}
//
//	public void setStoredPeople(List<User> storedPeople) {
//		this.storedPeople = storedPeople;
//	}
//
//	public List<User> getPraisedPeople() {
//		return praisedPeople;
//	}
//
//	public void setPraisedPeople(List<User> praisedPeople) {
//		this.praisedPeople = praisedPeople;
//	}
//
//	public List<Discuss> getDiscuss() {
//		return discuss;
//	}
//
//	public void setDiscuss(List<Discuss> discuss) {
//		this.discuss = discuss;
//	}

	public int getActivityId() {
		return activityId;
	}

	public void setActivityId(int activityId) {
		this.activityId = activityId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getActivityContent() {
		return activityContent;
	}

	public void setActivityContent(String activityContent) {
		this.activityContent = activityContent;
	}

	@JSON(format = "yyyy-MM-dd HH:mm:ss")
	public Date getStartTime() {
		return startTime;
	}

	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

	@JSON(format = "yyyy-MM-dd HH:mm:ss")
	public Date getEndTime() {
		return endTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}

	@JSON(format = "yyyy-MM-dd HH:mm:ss")
	public Date getPublishTime() {
		return publishTime;
	}

	public void setPublishTime(Date publishTime) {
		this.publishTime = publishTime;
	}

	public int getDiscussCount() {
		return discussCount;
	}

	public void setDiscussCount(int discussCount) {
		this.discussCount = discussCount;
	}

	public int getActivityLikebutton() {
		return activityLikebutton;
	}

	public void setActivityLikebutton(int activityLikebutton) {
		this.activityLikebutton = activityLikebutton;
	}

	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getActivityPhoto() {
		return activityPhoto;
	}

	public void setActivityPhoto(String activityPhoto) {
		this.activityPhoto = activityPhoto;
	}

	public int getStoreFlag() {
		return storeFlag;
	}

	public void setStoreFlag(int storeFlag) {
		this.storeFlag = storeFlag;
	}

	public int getLikeFlag() {
		return likeFlag;
	}

	public void setLikeFlag(int likeFlag) {
		this.likeFlag = likeFlag;
	}

	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

}
