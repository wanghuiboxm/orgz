<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib uri="/struts-tags" prefix="s" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>


<div class="pageContent">
	<div class="panelBar">
	
		<ul class="toolBar">
			<li><a class="add" href="admin/version_addUI" target="dialog" height="500" width="800"><span>添加</span></a></li>
			<!-- <li><a class="delete" href="admin/activity_delete?ac.activityId={sid_user}&ac.societyId=${ac.societyId }&flag=0" target="ajaxTodo" title="确定要删除吗?"><span>删除</span></a></li> -->
			
		</ul>
	
	</div>
	
	<table class="list" width="100%" layoutH="53">
		<thead>
			<tr>
				<th width="100" align="center">ID</th>
				<th width="100" align="center">上传时间</th>
				<th align="center">版本描述</th>
				<th width="100" align="center"> 版本号</th>
				<th width="130" align="center"> 备注</th>
			</tr>
		</thead>
		<tbody>
			<s:iterator value="versions" var="v">
				<tr target="sid_user" rel="${v.versionId }">
					<td>${v.versionId }</td>
					<td><s:date name="#v.publishTime" format="yyyy-MM-dd HH:mm:ss" /></td>
					<td>${v.versionSign }</td>
					<td>${v.versionNumber }</td>
					<td>备注</td>
				</tr>
			</s:iterator>
		</tbody>
	</table>
	<div class="panelBar">
		<div class="pages">

			<span>共1页</span>
		</div>

		<div class="pagination" targetType="navTab"
			totalCount="1" numPerPage="1"
			pageNumShown="1"
			currentPage="1"></div>

	</div>

</div>