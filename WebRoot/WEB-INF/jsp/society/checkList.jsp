<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib uri="/struts-tags" prefix="s" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<form id="pagerForm" method="post" action="admin/society_checkList">
	<input type="hidden" name="status" value="active"> 
	<input type="hidden" name="keywords" value="${param.keywords}" /> 
	<input type="hidden" name="pageNum" value="${pages.currentPage }" />
	<input type="hidden" name="numPerPage" value="${pages.pageSize}" />
	<input type="hidden" name="orderField" value="${param.orderField}" /> 
</form>

<div class="pageContent" >
	<div class="panelBar">
		<ul class="toolBar">
			<li><a title="确实要审核通过这些社团吗?" target="selectedTodo" rel="ids"  href="admin/society_batchCheckPass?society.status=0&flag=0" class="edit"><span>批量审核通过</span></a></li>
			<li><a title="确实要审核不通过这些社团吗?" target="selectedTodo" rel="ids"  href="admin/society_batchCheckPass?society.status=2&flag=0" class="delete"><span>批量审核不通过</span></a></li>
		</ul>
	</div>
	<table class="list" width="100%" layoutH="53">
		<thead>
			<tr>
				<th width="22"><input type="checkbox" group="ids" class="checkboxCtrl"></th>
				<th width="120">社团名称</th>
				<th width="50">属性</th>
				<th width="50">状态</th>
				<th width="130" orderField="accountCert">创建时间</th>
				<th width="130">学校</th>
				<th width="200">地址</th>
				<th width="80">创建人</th>
				<th width="120">标签</th>
				<th>介绍</th>
				<th width="120">操作</th>
			</tr>
		</thead>
		<tbody>
			<s:iterator value="pages.recordList" var="soc">
				<tr target="sid_user" rel="1" >
				<td><input name="ids" value="${soc.societyId }" type="checkbox"></td>
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
				<td>${soc.province }${soc.city }${soc.district }</td>
				<td><a title="用户详细信息" style="color:#009966;" target="dialog"
						href="admin/user_detail?user.userId=${soc.founder.userId }">${soc.founder.userName }</a></td>
				<td>${soc.tags }</td>
				<td>${soc.introduce }</td>
				<td>
					<a title="不通过" target="ajaxTodo" href="admin/society_checkPass?society.societyId=${soc.societyId }&society.status=2&flag=0" ><button style="background-color:#CCCCCC;">不通过</button></a>
					<a title="通过" target="ajaxTodo" href="admin/society_checkPass?society.societyId=${soc.societyId }&society.status=0&flag=0" ><button style="background-color:#999999;">通过</button></a>
				</td>
			</tr>
			</s:iterator>
		</tbody>
	</table>
	
	<script type="text/javascript">
		
			$("tbody > tr").bind("click",(function(){
				var ele = $(this).find("input");
				var val = $(ele).attr("checked");
				if($(ele).is(":checked")){
					$(ele).attr("checked", false);
				}else{
					$(ele).attr("checked", "checked");
				}
				//$(this).find("input").attr("checked","checked");	
				})
			);
		
	</script>
	
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

