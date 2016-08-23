<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib uri="/struts-tags" prefix="s" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<form id="pagerForm" method="post" action="admin/admin_list">
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
			<li><a class="add" href="admin/admin_addUI" target="dialog" width="600"><span>添加</span></a></li>
			<li><a class="delete" href="admin/admin_delete?adminId={sid_user}" target="ajaxTodo" title="确定要删除吗?"><span>删除</span></a></li>
		</ul>
	
	</div>
	
	<table class="list" width="100%" layoutH="53">
		<thead>
			<tr>
				<th width="80" align="center">管理员名字</th>
				<th width="80" align="center">创建时间</th>
				<th width="80" align="center">电话</th>
				<th width="80" align="center">Email</th>
			</tr>
		</thead>
		<tbody>
			<s:iterator value="pages.recordList" var="adm">
				<tr target="sid_user" rel="${adm.adminId }">
					<td>${adm.adminName }</td>
					<td><s:date name="#adm.addTime" format="yyyy-MM-dd HH:mm:ss" /></td>
					<td>${adm.phoneNumber }</td>
					<td>${adm.email }</td>
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