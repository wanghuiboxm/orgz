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
				<th>社团标识</th>
				<th>${society.societyId}</th>
			</tr>
			<tr>
				<th>社团名</th>
				<th>${society.societyName }</th>
			</tr>
			<tr>
				<th>社团属性</th>
				<th>
					<s:if test="society.property == 1">官方</s:if>
					<s:if test="society.property == 0">个人</s:if>
				</th>
			</tr>
			<tr>
				<th>状态</th>
				<s:if test="society.status == 0"><th style="color:green;">通过</th></s:if>
				<s:if test="society.status == 1"><th style="color:blue;">待审核</th></s:if>
				<s:if test="society.status == 2"><th style="color:red;">未通过</th></s:if>
			</tr>			
			<tr>
				<th>创建时间</th>
				<th><s:date name="society.createTime" format="yyyy-MM-dd HH:mm:ss" /></th>
			</tr>
			<tr>
				<th>学校</th>
				<th>${society.school }</th>
			</tr>
			<tr>
				<th>标签</th>
				<th>${society.tags }</th>
			</tr>
			<tr>
				<th>发布活动数</th>
				<th>${society.activityCount }</th>
			</tr>
			<tr>
				<th>社团人数</th>
				<th>${society.peopleCount }</th>
			</tr>
			<tr>
				<th>社团介绍</th>
				<th>${society.introduce }</th>
			</tr>
			<tr>
				<th>创建人</th>
				<th>${society.founder.userName }</th>
			</tr>
			<tr>
				<th>所在地区</th>
				<th>${society.province }${society.city }${society.district }</th>
			</tr>
		</table>
	</div>
</div>