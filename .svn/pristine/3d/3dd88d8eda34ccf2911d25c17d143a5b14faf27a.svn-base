package com.orgz.action;

import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.Action;
import com.orgz.base.BaseAction;
import com.orgz.domain.Friend;

@Controller
@Scope("prototype")
public class FriendAction extends BaseAction {
	private static final long serialVersionUID = -210600019332532153L;
	
	private int userId;
	private int friendUserId;
	private int friendId;
	private String nickname;
	private Friend friend;

	//展示我的好友
	public String list() throws Exception {
		if(userId > 0) {
			List<Friend> friends = friendService.findByUserId(userId);
			dataMap.put("status", 0);
			dataMap.put("message", "成功");
			dataMap.put("result", friends);
		}else {
			dataMap.put("status", 4);
			dataMap.put("message", "参数不正确");
		}
		return Action.SUCCESS;
	}
	
	//添加好友
	public String add() throws Exception {
		if(userId > 0 && friendUserId > 0) {
			friend = new Friend();
			friend.setUserId(userId);
			friend.setFriendUserId(friendUserId);
			if(nickname != null && nickname.trim().compareTo("") != 0){
				friend.setNickname(nickname);
			}
			Friend f = friendService.findByFriendUserIdAndUserId(friend);
			if(f != null){
				dataMap.put("status", 2);
				dataMap.put("message", "该记录已存在");
			}else {
				friend.setFriendUserId(friendUserId);
				friendService.insert(friend);
				dataMap.put("status", 0);
				dataMap.put("message", "成功");
			}
		}else {
			dataMap.put("status", 4);
			dataMap.put("message", "参数不正确");
		}
		return Action.SUCCESS;
	}
	
	//更改好用昵称
	public String edit() throws Exception {
		if(userId > 0 && friendUserId > 0 && nickname != null && nickname.trim().compareTo("") != 0) {
			friend = new Friend(nickname, userId, friendUserId);
			friendService.updateNickname(friend);
			dataMap.put("status", 0);
			dataMap.put("message", "成功");
		}else {
			dataMap.put("status", 4);
			dataMap.put("message", "参数不正确");
		}
		return Action.SUCCESS;
	}
	
	//删除好友
	public String delete() throws Exception {
		if(userId > 0 && friendUserId > 0) {
			friend = new Friend(null, userId, friendUserId);
			friendService.delete(friend);
			dataMap.put("status", 0);
			dataMap.put("message", "成功");
		}else {
			dataMap.put("status", 4);
			dataMap.put("message", "参数不正确");
		}
		return Action.SUCCESS;
	}
	
	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getFriendUserId() {
		return friendUserId;
	}

	public void setFriendUserId(int friendUserId) {
		this.friendUserId = friendUserId;
	}

	public int getFriendId() {
		return friendId;
	}

	public void setFriendId(int friendId) {
		this.friendId = friendId;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public Friend getFriend() {
		return friend;
	}

	public void setFriend(Friend friend) {
		this.friend = friend;
	}
}
