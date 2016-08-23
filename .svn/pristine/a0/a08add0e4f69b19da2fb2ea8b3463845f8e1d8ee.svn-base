<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<form id="pagerForm" method="post" action="admin/society_list">
	<input type="hidden" name="status" value="active"> 
	<input type="hidden" name="keywords" value="${param.keywords}" /> 
	<input type="hidden" name="pageNum" value="${pages.currentPage }" />
	<input type="hidden" name="numPerPage" value="${pages.pageSize}" />
	<input type="hidden" name="orderField" value="${param.orderField}" />
	
	<input type="hidden" name="sc.property" value="${sc.property }"> 
	<input type="hidden" name="sc.societyName" value="${sc.societyName }"> 
	<input type="hidden" name="sc.school" value="${sc.school }"> 
	<input type="hidden" name="sc.tags" value="${sc.tags }"> 
	<input type="hidden" name="sc.status" value="${sc.status }"> 
</form>


<div class="pageHeader" height="250">
	<!-- 查询条件 -->
	<form onsubmit="return navTabSearch(this);" action="admin/society_list" method="post">
		<div class="searchBar">
			<table class="searchContent">
				<tr>
					<td>
					社团属性： 
						<input type="radio" name="sc.property" value="2" checked="checked" /> 全部
					 	<input type="radio" name="sc.property" value="1" />官方
					 	<input type="radio" name="sc.property" value="0" /> 个人
					 </td>
					<td>
						社团名称：<input type="text" name="sc.societyName" />
						<input type="hidden" name="sc.status" value="0"/>
					</td>
					<td>
						<div class="buttonActive">
							<div class="buttonContent">
								<button type="submit">检索</button>
							</div>
						</div>
					</td>
					<td>
						<a class="button" href="admin/society_searchUI" target="dialog" mask="true" title="社团高级查询" height="300" fresh="true"><span>高级检索</span></a>
					</td>
				</tr>
			</table>
		</div>
	</form>
</div>
<div class="pageContent">
	<div class="panelBar">
		<ul class="toolBar">
			<li><a class="edit" href="admin/society_editUI?society.societyId={sid_user}" height="500" target="dialog"><span>修改</span></a>
			</li>
		</ul>
	</div>
	<table class="list" width="100%" layoutH="90">
		<thead>
			<tr>
				<th width="150" align="center">社团名称</th>
				<th width="50" align="center">属性</th>
				<th width="50">状态</th>
				<th width="150" align="center">创建时间</th>
				<th width="130" align="center">学校</th>
				<th width="130" align="center">标签</th>
				<th width="50" align="center">活动数</th>
				<th width="60" align="center">社团人数</th>
				<th align="center">介绍</th>
				<th width="80">创始人信息</th>
				<th width="80">操作</th>
			</tr>
		</thead>
		<tbody>
			<s:iterator value="pages.recordList" var="soc">
				<tr target="sid_user" rel="${soc.societyId }">
					<td>${soc.societyName }</td>
					<td>
						<s:if test="#soc.property == 1">官方</s:if>
						<s:if test="#soc.property == 0">个人</s:if>
					</td>
						<s:if test="#soc.status == 0"><td style="color:green;">通过</td></s:if>
						<s:if test="#soc.status == 1"><td style="color:blue;">待审核</td></s:if>
						<s:if test="#soc.status == 2"><td style="color:red;">未通过</td></s:if>
					<td><s:date name="#soc.createTime" format="yyyy-MM-dd HH:mm:ss" /></td>
					<td>${soc.school }</td>
					<td>${soc.tags }</td>
					<td>${soc.activityCount }</td>
					<td>${soc.peopleCount }</td>
					<td>${soc.introduce }</td>
					<td><a title="用户详细信息" style="color:#009966;" target="dialog"
						href="admin/user_detail?user.userId=${soc.founder.userId }">${soc.founder.userName }</a></td>
					<td><a title="社团活动" style="color:blue;" target="navTab"
						href="admin/activity_list?ac.societyId=${soc.societyId }" rel="activityList" id="activityList">查看社团活动</a></td>
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

