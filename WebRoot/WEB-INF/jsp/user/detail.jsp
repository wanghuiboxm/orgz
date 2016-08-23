<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<div  title="用户详细信息">
	<div>
		<table class="list" width="100%">
			<tr>
				<th>用户标识</th>
				<th>${user.userId}</th>
			</tr>
			<tr>
				<th>用户名</th>
				<th>${user.userName }</th>
			</tr>
			<tr>
				<th>电话号码</th>
				<th>${user.phoneNumber }</th>
			</tr>
			<tr>
				<th>Email</th>
				<th>${user.email }</th>
			</tr>
			<tr>
				<th>性别</th>
				<th>
					<s:if test="user.sex == 0">女</s:if>
					<s:if test="user.sex == 1">男</s:if>
				</th>
			</tr>
			<tr>
				<th>注册时间</th>
				<s:date name="user.regtime" format="yyyy-MM-dd HH:mm:ss" var="regtime"/>
				<th>${requestScope.regtime }</th>
			</tr>
			<tr>
				<th>最近登录时间</th>
				<s:date name="user.latelyTime" format="yyyy-MM-dd HH:mm:ss" var="latelyTime"/>
				<th>${requestScope.latelyTime }</th>
			</tr>
			<tr>
				<th>所在地区</th>
				<th>${user.province }${user.city }${user.district }</th>
			</tr>
			<tr>
				<th>地址</th>
				<th>${user.address }</th>
			</tr>
			<tr>
				<th>签名</th>
				<th>${user.userSign }</th>
			</tr>
		</table>
	</div>
</div>