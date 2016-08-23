package com.orgz.condition;

public class SearchConditionOfMessage {
	private int messageId;
	private int userId;
	private int checkUserId; //需要检验的userid
	private int start;
	private int size; //当size=0表示不分页
	
	@Override
	public String toString() {
		return "SearchConditionOfMessage [messageId=" + messageId + ", userId="
				+ userId + ", start=" + start + ", size=" + size + "]";
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

	public int getMessageId() {
		return messageId;
	}

	public void setMessageId(int messageId) {
		this.messageId = messageId;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getCheckUserId() {
		return checkUserId;
	}

	public void setCheckUserId(int checkUserId) {
		this.checkUserId = checkUserId;
	}

}
