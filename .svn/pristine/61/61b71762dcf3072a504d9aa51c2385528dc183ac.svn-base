<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib uri="/struts-tags" prefix="s" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<form id="pagerForm" method="post" action="admin/message_list">
	<input type="hidden" name="pageNum" value="${pages.currentPage }" />
	<input type="hidden" name="numPerPage" value="${pages.pageSize}" />
	<!-- 
	<input type="hidden" name="ac.societyId" value="${ac.societyId }">
	<input type="hidden" name="status" value="active"> 
	<input type="hidden" name="keywords" value="${param.keywords}" /> 
	<input type="hidden" name="orderField" value="${param.orderField}" />
	  -->
	
</form>

<div class="pageContent">
	<div class="panelBar">
	
		<ul class="toolBar">
			<li><a class="delete" href="admin/message_deleteByAdmin?mc.messageId={sid_user}&flag=0" target="ajaxTodo" title="确定要删除吗?"><span>删除</span></a></li>
		</ul>
	
	</div>
	
	<table class="list" width="100%" layoutH="53">
		<thead>
			<tr>
				<th width="80" align="center">留言发布者</th>
				<th width="100" align="center">发布时间</th>
				<th align="center">留言内容</th>
				<th width="80" align="center">回复数量</th>
				<th width="80" align="center">点赞数量</th>
				<th width="100" align="center">查看回复</th>
			</tr>
		</thead>
		<tbody>
			<s:iterator value="pages.recordList" var="msg">
				<tr target="sid_user" rel="${msg.messageId }"}>
					<td><a title="用户详细信息" style="color:#009966;" target="dialog"
						href="admin/user_detail?user.userId=${msg.user.userId }">${msg.user.userName }</a></td>
					<td><s:date name="#msg.publishTime" format="yyyy-MM-dd HH:mm:ss" /></td>
					<td>${msg.messageContent }</td>
					<td>${msg.replyCount }</td>
					<td>${msg.messageLikebutton }</td>
					<td>
						<a title="留言回复" style="color:blue;" target="navTab" href="admin/reply_list?rc.messageId=${msg.messageId}" rel="replyList">查看留言回复</a>
					</td>
				</tr>
			</s:iterator>
		</tbody>
	</table>
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