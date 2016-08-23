package com.orgz.domain;

import java.util.Date;

import org.apache.struts2.json.annotations.JSON;

public class Society {
	private int societyId;
	private String societyName; // 社团的名字
	private String societyIcon;
	private int property; // 社团属性 0代表个人 1代表官方
	private String introduce; // 社团介绍
	private Date createTime; // 社团创建时间
	private int activityCount; // 社团发布的活动数
	private int status; // 审核状态，0代表通过， 1代表正在审核中，2代表审核不通过
	private String school; // 社团所在学校
	private int peopleCount; // 参加社团的人数
	private String province;
	private String city;
	private String district;
	private String address; // 社团地址
	private User founder; //创始人
	private String tags;
	private int joinFlag; //0代表没有加入该社团，非0代表加入了


	@JSON(serialize=false)
	public boolean isMatchCodition() {
		if (societyName != null && introduce != null
				&& province != null && city != null
				&& district != null && address != null) {
			return true;
		}
		return false;
	}

	public User getFounder() {
		return founder;
	}
	
	public void setFounder(User founder) {
		this.founder = founder;
	}
	public int getSocietyId() {
		return societyId;
	}

	public void setSocietyId(int societyId) {
		this.societyId = societyId;
	}

	public String getSocietyName() {
		return societyName;
	}

	public void setSocietyName(String societyName) {
		this.societyName = societyName;
	}

	public int getProperty() {
		return property;
	}

	public void setProperty(int property) {
		this.property = property;
	}

	public String getIntroduce() {
		return introduce;
	}

	public void setIntroduce(String introduce) {
		this.introduce = introduce;
	}

	@JSON(format="yyyy-MM-dd HH:mm:ss")
	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public int getActivityCount() {
		return activityCount;
	}

	public void setActivityCount(int activityCount) {
		this.activityCount = activityCount;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getSchool() {
		return school;
	}

	public void setSchool(String school) {
		this.school = school;
	}

	public int getPeopleCount() {
		return peopleCount;
	}

	public void setPeopleCount(int peopleCount) {
		this.peopleCount = peopleCount;
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

	public String getSocietyIcon() {
		return societyIcon;
	}

	public void setSocietyIcon(String societyIcon) {
		this.societyIcon = societyIcon;
	}
	public String getTags() {
		return tags;
	}

	public void setTags(String tags) {
		this.tags = tags;
	}

	public int getJoinFlag() {
		return joinFlag;
	}

	public void setJoinFlag(int joinFlag) {
		this.joinFlag = joinFlag;
	}

	@Override
	public String toString() {
		return "Society [societyName=" + societyName + ", societyIcon="
				+ societyIcon + ", property=" + property + ", introduce="
				+ introduce + ", school=" + school + ", province=" + province
				+ ", city=" + city + ", district=" + district + ", address="
				+ address + "]";
	}
}
