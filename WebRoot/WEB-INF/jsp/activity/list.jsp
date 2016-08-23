<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib uri="/struts-tags" prefix="s" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<form id="pagerForm" method="post" action="admin/activity_list?ac.societyId=${ac.societyId }">
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
			<s:if test="#session.admin.adminName != 'admin'">
				<li><a class="add" href="admin/activity_addUI" target="dialog" height="500" width="800"><span>添加</span></a></li>
			</s:if>
			<li><a class="delete" href="admin/activity_delete?ac.activityId={sid_user}&ac.societyId=${ac.societyId }&flag=0" target="ajaxTodo" title="确定要删除吗?"><span>删除</span></a></li>
		</ul>
	
	</div>
	
	<table class="list" width="100%" layoutH="53">
		<thead>
			<tr>
				<th width="100" align="center">活动主题</th>
				<th width="100" align="center">活动内容</th>
				<th width="130" align="center">开始时间</th>
				<th width="130" align="center"> 结束时间</th>
				<th width="60" align="center">回复数量</th>
				<th width="60" align="center">点赞数量</th>
				<th width="200" align="center">地址</th>
				<th width="80" align="center">发布人</th>
				<th width="80" align="center">所属社团</th>
				<th width="80" align="center">查看评论</th>
			</tr>
		</thead>
		<tbody>
			<s:iterator value="pages.recordList" var="act">
				<tr target="sid_user" rel="${act.activityId }">
					<td>${act.title }</td>
					<td>${act.activityContent }</td>
					<td><s:date name="#act.startTime" format="yyyy-MM-dd HH:mm:ss" /></td>
					<td><s:date name="#act.endTime" format="yyyy-MM-dd HH:mm:ss" /></td>
					<td>${act.discussCount }</td>
					<td>${act.activityLikebutton }</td>
					<td>${act.city }${act.district }${act.address }</td>
					<td><a title="用户详细信息" style="color:#009966;" target="dialog"
						href="admin/user_detail?user.userId=${act.founder.userId }">${act.founder.userName }</a></td>
					<td><a title="社团详细信息" style="color:#009966;" target="dialog"
						href="admin/society_showDetail?society.societyId=${act.society.societyId }" rel="societyDetail">${act.society.societyName }</a></td>
					<td>
						<a title="活动评论" style="color:blue;" target="navTab" href="admin/discuss_list?dc.activityId=${act.activityId }" rel="discussList">查看活动评论</a>
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