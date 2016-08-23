<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<form id="pagerForm" method="post" action="admin/reply_list?rc.messageId=${messageId }">
	<input type="hidden" name="status" value="">
	<input type="hidden" name="keywords" value="" />
	<input type="hidden" name="pageNum" value="${pages.currentPage }" />
	<input type="hidden" name="numPerPage" value="${pages.pageSize }" />
	<input type="hidden" name="orderField" value="" />
</form>

<div class="pageContent" >
<div layoutH="50">
	<table  width="100%" style="width: 100%;min-height: 50px;">
		<tbody minH="100px">
			<tr target="sid_user" >
				<td width="60px"><img height="50px" width="50px" src="${message.user.userIcon}"></img></td>
				<td height="50px">
					<table class="list" width="100%" style="">
						<tr>
							<td>由
								<span style="color:#0066FF;">
									<a title="用户详细信息" target="dialog" href="admin/user_detail?user.userId=${message.user.userId }">${message.user.userName }</a>
								</span>
								<s:date name="message.publishTime" format="yyyy-MM-dd HH:mm:ss" />发布
							</td>
							<td width="50px">
								<a title="删除留言" target="ajaxTodo" href="admin/message_deleteByAdmin?mc.messageId=${message.messageId }&flag=1">删除留言</a>
							</td>
						</tr>
						<tr>	
							<td colspan="2">
								<div style="margin: 0px;padding: 5px;">
									<p style="line-height: 18px;">
										留言内容：${message.messageContent }
									</p>
								</div>
							</td>
						</tr>
						<tr>
							<td height="5px">     </td>
							<td>     </td>
						</tr>
					</table>
			
				</td>
			</tr>
		</tbody>
		
		<s:iterator value="pages.recordList" var="reply">
				<tbody minH="60px">
				<tr height="20px"></tr>
			<tr target="sid_user" >
				<td width="60px"><img height="40px" width="40px" src="${reply.user.userIcon }"></td>
				<td>
					<table class="list" width="100%">
						<tr>
							<td>
								<span style="color:#0066FF;"><a title="用户详细信息"  target="dialog" href="admin/user_detail?user.userId=${reply.user.userId }">${reply.user.userName }</a></span> 发表于 
								<span style="color:#6633FF;"><s:date name="#reply.replyTime" format="yyyy-MM-dd HH:mm:ss" /></span>
							</td>
							<td width="50px">
								<a title="删除回复" target="ajaxTodo" href="admin/reply_deleteByAdmin?rc.replyId=${reply.replyId }&rc.messageId=${reply.message.messageId }">删除</a>
							</td>
						</tr>
						<tr>
							<td colspan="2" style="height: 30px;"><p style="line-height: 18px; padding-left: 5px;">${reply.replyContent }</p>
							<s:if test="#reply.parent != null">
								<!-- <div style="margin: 0px;padding-top: 0px;"> -->
									<p style="color:gray;text-decoration: underline;line-height: 15px;">
											”回复：<span style="color: green;"><a title="用户详细信息"
												target="dialog"
												href="admin/user_detail?user.userId=${reply.parent.user.userId }">${reply.parent.user.userName}</a>
											</span>&nbsp;&nbsp; ${reply.parent.replyContent }
									</p>
								
							</s:if>
							</td>
						</tr>
								<!--<s:iterator value="#reply.replies" var="child">
							<tr>
								<td>
								<s:if test="#child.user.userId != #reply.user.userId">
									<p style="line-height: 18px; padding-left: 5px;">
										<span><a href="admin/user_detail?user.userId=${child.user.userId }" target="dialog">${child.user.userName }</a></span>&nbsp;回复
										<span><a href="admin/user_detail?user.userId=${child.user.userId }" target="dialog">${reply.user.userName }</a></span>&nbsp;：${child.replyContent }
									</p>
								</s:if>
								<s:else>
									<p style="line-height: 18px; padding-left: 5px;">
										<span><a href="admin/user_detail?user.userId=${child.user.userId }" target="dialog">${reply.user.userName }</a></span>&nbsp;回复
										<span><a href="admin/user_detail?user.userId=${child.user.userId }" target="dialog">${child.user.userName }</a></span>&nbsp;：${child.replyContent }
									</p>
								</s:else>
								</td>
								<td>
									<a title="删除回复" target="ajaxTodo" href="admin/reply_deleteByAdmin?rc.replyId=${child.replyId }&rc.messageId=${reply.message.messageId }">删除</a>
								</td>
							</tr>
						</s:iterator>-->
					</table>
				</td>
			</tr>
		</tbody>
		</s:iterator>
	</table>
	</div>
	
	<div class="panelBar">
		<div class="pages">

			<span>共${pages.recordCount }条${pages.pageCount }页</span>
		</div>

		<div class="pagination" targetType="navTab"
			totalCount="${pages.recordCount }" numPerPage="${pages.pageSize }"
			pageNumShown="${pages.endPageIndex - pages.beginPageIndex +1}"
			currentPage="${pages.currentPage }"></div>

	</div>

</div>
