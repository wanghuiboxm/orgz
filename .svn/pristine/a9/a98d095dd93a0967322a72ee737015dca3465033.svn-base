package com.orgz.condition;

public class SearchConditionOfUser {
	private int userId;
	private int sex;
	private String keyword;
	private int start;
	private int size; //当size=0表示不分页

	public int getStart() {
		return start;
	}


	@Override
	public String toString() {
		return "SearchConditionOfUser [userId=" + userId + ", sex=" + sex
				+ ", keyword=" + keyword + ", start=" + start + ", size="
				+ size + "]";
	}

	public SearchConditionOfUser(int sex, String keyword) {
		super();
		this.sex = sex;
		this.keyword = keyword;
	}
	
	public SearchConditionOfUser(){}
	
	public void setStart(int start) {
		this.start = start;
	}

	public int getSize() {
		return size;
	}
	

	public void setSize(int size) {
		this.size = size;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getSex() {
		return sex;
	}

	public void setSex(int sex) {
		this.sex = sex;
	}

	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}
}
