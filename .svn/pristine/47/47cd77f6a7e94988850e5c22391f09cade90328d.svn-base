<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib uri="/struts-tags" prefix="s" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<form id="pagerForm" method="post" action="admin/user_list">

	<input type="hidden" name="pageNum" value="${pages.currentPage }" />
	<input type="hidden" name="numPerPage" value="${pages.pageSize}" />
	<input type="hidden" name="uc.sex" value="${uc.sex}" /> 
	<input type="hidden" name="uc.keyword" value="${uc.keyword }"> 
</form>


<div class="pageHeader" height="250">
	<!-- 查询条件 -->
	<form onsubmit="return navTabSearch(this);" action="admin/user_list" method="post">
		<div class="searchBar">
			<table class="searchContent">
				<tr>
					<td>
					用户性别： 
						<input type="radio" name="uc.sex" value="2" <s:if test="uc.sex !=0 && uc.sex != 1">checked="checked"</s:if> /> 全部
					 	<input type="radio" name="uc.sex" value="0" <s:if test="uc.sex == 0">checked="checked"</s:if> />女
					 	<input type="radio" name="uc.sex" value="1" <s:if test="uc.sex == 1">checked="checked"</s:if> /> 男
					 </td>
					<td>
						用户名称：
						<input type="text" name="uc.keyword" alt="请输入用户名/邮箱/电话" <s:if test="uc.keyword != null">value="${uc.keyword }"</s:if> />
					</td>
					<td>
						<div class="buttonActive">
							<div class="buttonContent">
								<button type="submit">检索</button>
							</div>
						</div>
					</td>
				</tr>
			</table>
		</div>
	</form>
</div>
<div class="pageContent">
	<div class="panelBar">
		<ul class="toolBar">
			<li><a class="edit" href="admin/user_detail?user.userId={sid_user}" target="dialog" height="400"><span>查看用户详情</span></a></li>
			<li><a class="edit" href="admin/user_editUI?user.userId={sid_user}" target="dialog" height="400"><span>修改</span></a></li>
		</ul>
	</div>
	<table class="table" width="100%" layoutH="112">
		<thead>
			<tr>
				<th width="100" align="center">用户名</th>
				<th width="100" align="center">电话号码</th>
				<th width="150" align="center">Email</th>
				<th width="30" align="center">性别</th>
				<th width="130" align="center">注册时间</th>
				<th width="130" align="center">最近登录时间</th>
				<th width="200" align="center">地址</th>
				<th align="center">签名</th>
			</tr>
		</thead>
		<tbody>
			<s:iterator value="pages.recordList" var="user">
				<tr target="sid_user" rel="${user.userId }">
				<td>${user.userName }</td>
				<td>${user.phoneNumber }</td>
				<td>${user.email }</td>
				<td><s:if test="#user.sex == 0">女</s:if><s:if test="#user.sex == 1">男</s:if><s:if test="#user.sex == -1">无</s:if></td>
				<td><s:date name="#user.regtime" format="yyyy-MM-dd HH:mm:ss" /></td>
				<td><s:date name="#user.latelyTime" format="yyyy-MM-dd HH:mm:ss" /></td>
				<td>${user.address }</td>
				<td>${user.userSign }</td>
			</tr>
			</s:iterator>
		</tbody>
	</table>
	<div class="panelBar">
		<div class="pages">

			<span>共${pages.recordCount }条${pages.pageCount }页</span>
		</div>
		
		<div class="pagination" targetType="navTab" totalCount="${pages.recordCount }" numPerPage="${pages.pageSize }" pageNumShown="${pages.endPageIndex - pages.beginPageIndex +1}" currentPage="${pages.currentPage }"></div>

	</div>
</div>

