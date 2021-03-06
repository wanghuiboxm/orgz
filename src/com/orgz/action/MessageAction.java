package com.orgz.action;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.Action;
import com.orgz.base.BaseAction;
import com.orgz.condition.SearchConditionOfMessage;
import com.orgz.domain.Message;

@Controller
@Scope("prototype")
public class MessageAction extends BaseAction {
	private static final long serialVersionUID = 1L;
	
	private SearchConditionOfMessage mc;
	private Message message;
	private int userId;
	private int messageId;
	private String messageContent;
	
	public String create() throws Exception {
		if(userId > 0 && messageContent != null) {
			message = new Message();
			message.setMessageContent(messageContent);
			messageService.createMessage(userId, message);
			dataMap.put("status", 0);
			dataMap.put("message", "成功");
		}else {
			dataMap.put("status", 4);
			dataMap.put("message", "参数错误");
		}
		return Action.SUCCESS;
	}
	
	public String show() throws Exception {
		if(userId > 0) {
			//表示不分页
			if(numPerPage == -1 && pageNum == -1) {
				pageNum = 1;
				numPerPage = 0;
			} else {
				if(numPerPage < 1){
					//默认每页显示20条
					numPerPage = 20;
				}
				if(pageNum < 1){
					//默认显示第一页
					pageNum = 1;
				}
			}
			//默认显示
			mc = new SearchConditionOfMessage();
			mc.setCheckUserId(userId);
			pages = messageService.getPageBean(mc, numPerPage, pageNum);
			dataMap.put("status", 0);
			dataMap.put("message", "成功");
			dataMap.put("result", pages);
			
		}else {
			dataMap.put("status", 4);
			dataMap.put("message", "参数错误");
		}
		return Action.SUCCESS;
	}
	
//	public String detail() throws Exception {
//		
//		return Action.SUCCESS;
//	}
	
	public String delete() throws Exception {
		if(messageId > 0 && userId > 0){
			message = messageService.getMessageById(messageId);
			if(message != null && message.getUser().getUserId() == userId) {
				//删除留言下的评论
				replyService.deleteByMessage(messageId);
				//删除留言下的点赞
				mesPraiseService.deleteByMessageId(messageId);
				//删除留言
				messageService.deleteMessage(message);
				
				dataMap.put("status", 0);
				dataMap.put("message", "成功");
			}else {
				dataMap.put("status", 1);
				dataMap.put("message", "失败");
			}
		}else {
			dataMap.put("status", 4);
			dataMap.put("message", "参数错误");
		}
		return Action.SUCCESS;
	}

	//点赞
	public String like() throws Exception {
		if(userId > 0 && messageId > 0){
			if(mesPraiseService.findByUserIdAndMessageId(userId, messageId) != null){
				dataMap.put("status", 2);
				dataMap.put("message", "该活动您已点赞");
			}else{
				mesPraiseService.insert(userId, messageId);
				messageService.updateLikebutton(messageId);
				dataMap.put("status", 0);
				dataMap.put("message", "成功");
			}
		}else{
			dataMap.put("status", 4);
			dataMap.put("message", "参数错误");
		}
		return Action.SUCCESS;
	}
	
	//取消点赞
	public String cancelLike() throws Exception {
		if (userId > 0 && messageId > 0) {
			//删除点赞
			int count = mesPraiseService.deleteByUserIdAndMessageId(userId, messageId);
			if(count > 0){
				messageService.updateLikebuttonReduce(messageId);
				dataMap.put("status", 0);
				dataMap.put("message", "成功");
			}else{
				dataMap.put("status", 1);
				dataMap.put("message", "失败");
			}
		}else{
			dataMap.put("status", 4);
			dataMap.put("message", "参数错误");
		}
		return Action.SUCCESS;
	}

	//后台方法
	public String deleteByAdmin() throws Exception {
		if(mc != null){
			message = messageService.getMessageById(mc.getMessageId());
			if(message != null) {
				//删除留言下的评论
				replyService.deleteByMessage(message.getMessageId());
				//删除留言下的点赞
				mesPraiseService.deleteByMessageId(message.getMessageId());
				//删除留言
				messageService.deleteMessage(message);
				if(flag == 0){//留言页发来
					dataMap.put("navTabId", "messageList");
					dataMap.put("rel", "messageList");
					dataMap.put("callbackType", "");
				}
				if(flag == 1){//留言回复也发来
					dataMap.put("navTabId", "messageList");
					dataMap.put("rel", "messageList");
					dataMap.put("callbackType", "closeCurrent");
				}
				dataMap.put("statusCode", "200");
				dataMap.put("message", "操作成功");
			}
			dataMap.put("forwardUrl", "");
		}else{		
			dataMap.put("statusCode", "300");
			dataMap.put("message", "操作失败");
		}
		return "jsonResult";
	}
	
	public String list() throws Exception {
		if(numPerPage <= 0 ){
			//默认显示20条记录
			numPerPage = 20;
		}
		if(pageNum <= 0){
			//默认显示第一页
			pageNum = 1;
		}
		if(mc == null){
			//默认显示
			mc = new SearchConditionOfMessage();
		}
		pages = messageService.getPageBean(mc, numPerPage, pageNum);
		
		return "list";
	}
	
	public SearchConditionOfMessage getMc() {
		return mc;
	}

	public void setMc(SearchConditionOfMessage mc) {
		this.mc = mc;
	}

	public Message getMessage() {
		return message;
	}

	public void setMessage(Message message) {
		this.message = message;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

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
	
	
}
