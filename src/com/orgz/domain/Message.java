package com.orgz.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.struts2.json.annotations.JSON;

public class Message {
	private int messageId;
	private String messageContent; // 留言内容
	private Date publishTime; // 发布时间
	private int replyCount; // 回复数
	private int messageLikebutton; // 点赞数
	private int likeFlag; 
	private User user; // 发布留言的人
	private List<User> likes = new ArrayList<User>(); // 点赞的人
	private List<Reply> replys = new ArrayList<Reply>(); // 回复
	
	public int getMessageId() {
		return messageId;
	}

	public void setMessageId(int messageId) {
		this.messageId = messageId;
	}

	public String getMessageContent() {
		return messageContent;
	}

	public void setMessageContent(String messageContent) {
		this.messageContent = messageContent;
	}

	@JSON(format = "yyyy-MM-dd HH:mm:ss")
	public Date getPublishTime() {
		return publishTime;
	}

	public void setPublishTime(Date publishTime) {
		this.publishTime = publishTime;
	}

	public int getReplyCount() {
		return replyCount;
	}

	public void setReplyCount(int replyCount) {
		this.replyCount = replyCount;
	}

	public int getMessageLikebutton() {
		return messageLikebutton;
	}

	public void setMessageLikebutton(int messageLikebutton) {
		this.messageLikebutton = messageLikebutton;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<Reply> getReplys() {
		return replys;
	}

	public void setReplys(List<Reply> replys) {
		this.replys = replys;
	}

	public List<User> getLikes() {
		return likes;
	}

	public void setLikes(List<User> likes) {
		this.likes = likes;
	}

	public int getLikeFlag() {
		return likeFlag;
	}

	public void setLikeFlag(int likeFlag) {
		this.likeFlag = likeFlag;
	}
}
