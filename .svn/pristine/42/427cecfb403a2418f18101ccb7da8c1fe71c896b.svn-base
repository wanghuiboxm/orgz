package com.orgz.domain;

import java.util.Date;
import java.util.List;

import org.apache.struts2.json.annotations.JSON;

public class Reply {
	private int replyId;
	private String replyContent; //回复内容
	private Date replyTime; //回复时间
//	private int parentId;
	private Message message; //回复对应的留言
	private User user; //留言回复者
//	private List<Reply> replies; // 该回复的子回复
	private Reply parent; //该回复的父评论

	public int getReplyId() {
		return replyId;
	}

	public void setReplyId(int replyId) {
		this.replyId = replyId;
	}

	public String getReplyContent() {
		return replyContent;
	}

	public void setReplyContent(String replyContent) {
		this.replyContent = replyContent;
	}

	@JSON(format = "yyyy-MM-dd HH:mm:ss")
	public Date getReplyTime() {
		return replyTime;
	}

	public void setReplyTime(Date replyTime) {
		this.replyTime = replyTime;
	}

	public Message getMessage() {
		return message;
	}

	public void setMessage(Message message) {
		this.message = message;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

//	public List<Reply> getReplies() {
//		return replies;
//	}
//
//	public void setReplies(List<Reply> replies) {
//		this.replies = replies;
//	}

//	public int getParentId() {
//		return parentId;
//	}
//
//	public void setParentId(int parentId) {
//		this.parentId = parentId;
//	}

	public Reply getParent() {
		return parent;
	}

	public void setParent(Reply parent) {
		this.parent = parent;
	}

}
