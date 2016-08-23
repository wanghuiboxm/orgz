<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<form id="pagerForm" method="post" action="admin/discuss_list?dc.activityId=${activity.activityId }">
	<input type="hidden" name="status" value="">
	<input type="hidden" name="keywords" value="" />
	<input type="hidden" name="pageNum" value="${pages.currentPage }" />
	<input type="hidden" name="numPerPage" value="${pages.pageSize }" />
	<input type="hidden" name="orderField" value="" />
</form>

<div class="pageContent" >
<div layoutH="50">
	<table class="list" width="100%" >
		<tbody minH="100px">
			<tr target="sid_user" >
				<td width="60px"><img height="50px" width="50px" src="${activity.activityPhoto }"></img></td>
				<td>
					<table class="list" width="100%" style="background-color: blue;">
						<tr>
							<td>由<span style="color:#0066FF;"><a title="用户详细信息" target="dialog"
						href="admin/user_detail?user.userId=${activity.founder.userId }">${activity.founder.userName }</a></span>发布</td>
							<td width="50px">
								<a title="删除活动" target="ajaxTodo" href="admin/activity_delete?ac.activityId=${activity.activityId }&flag=1">删除活动</a>
							</td>
						</tr>
						<tr>	
							<td colspan="2">
							<div style="margin: 0px;padding: 5px;">
							<p style="line-height: 18px;">
										活动主题：${activity.title }
									</p>
									<p style="line-height: 18px;">
										活动内容：${activity.activityContent }
									</p>
									<p style="line-height: 18px;">
										活动时间：<s:date name="activity.startTime" format="yyyy-MM-dd HH:mm:ss" /> 到 <s:date name="activity.endTime" format="yyyy-MM-dd HH:mm:ss" />
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
		
		<s:iterator value="pages.recordList" var="dis">
		<tbody minH="60px">
			<tr height="15px"></tr>
			<tr target="sid_user" >
				<td width="60px"><img height="50px" width="50px" src="${dis.user.userIcon }"></td>
				<td>
					<table class="list" width="100%">
						<tr>
							<td><span
								style="color:#0066FF;"><a title="用户详细信息"  target="dialog"
						href="admin/user_detail?user.userId=${dis.user.userId }">${dis.user.userName }</a></span> 发表于 <span
								style="color:#6633FF;"><s:date name="#dis.discussTime" format="yyyy-MM-dd HH:mm:ss" /></span></td>
							<td width="50px">
								<a title="删除评论" target="ajaxTodo" href="admin/discuss_deleteByAdmin?dc.discussId=${dis.discussId }&dc.activityId=${dis.activityId }">删除</a>
							</td>
						</tr>
						<tr height="60px">				
							<td colspan="2">
							<div style="margin: 0px;padding: 5px;">
								<s:if test="#dis.parent != null">
										<p style="color:gray;text-decoration: underline;line-height: 20px;">
										”回复：<span style="color: green;"><a title="用户详细信息"  target="dialog"
						href="admin/user_detail?user.userId=${dis.parent.user.userId }">${dis.parent.user.userName }</a></span>&nbsp;&nbsp; ${dis.parent.discussContent }
									</p>
									</s:if>
									<p style="line-height: 18px;">${dis.discussContent }</p>
									</div>
							</td>
						</tr>
						<tr>
							<td></td>
							<td></td>
						</tr>
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
