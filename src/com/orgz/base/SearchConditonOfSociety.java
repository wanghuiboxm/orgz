package com.orgz.base;

public class SearchConditonOfSociety {
	private int property; //属性
	private int status; //审核状态
	private int userId;
	private String societyName; //社团名字
	private String city;
	private String school;
	private String tags;
	private int start; //从几条记录开始
	private int size; //显示多少条

	public SearchConditonOfSociety(){}
	
	public SearchConditonOfSociety(int property, int status,
			String societyName, String city, String school, String tags) {
		super();
		this.property = property;
		this.status = status;
		this.societyName = societyName;
		this.city = city;
		this.school = school;
		this.tags = tags;
	}

	@Override
	public String toString() {
		return "SearchConditonOfSociety [property=" + property + ", status="
				+ status + ", societyName=" + societyName + ", city=" + city
				+ ", school=" + school + ", tags=" + tags + ", start=" + start
				+ ", size=" + size + "]";
	}

	public int getStart() {
		return start;
	}

	public void setStart(int start) {
		this.start = start;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public int getProperty() {
		return property;
	}

	public void setProperty(int property) {
		this.property = property;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getSocietyName() {
		return societyName;
	}

	public void setSocietyName(String societyName) {
		this.societyName = societyName;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getSchool() {
		return school;
	}

	public void setSchool(String school) {
		this.school = school;
	}

	public String getTags() {
		return tags;
	}

	public void setTags(String tags) {
		this.tags = tags;
	}
}
