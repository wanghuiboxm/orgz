<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<<style>
.main{
padding: 0px; margin: 0px;width: 100%;height: 100%;
}
.header{
width:100%;height:80px;margin-top:5px;padding: 0px;border: #CCCCCC solid 1px;
}
.photo{
	width: 50px;height: 50px;background-color:red;margin: 3px;
}
.contab{
font-size:11px;color: #333333;height:100%;width:100%;
}
.conHeaderRight{
border-bottom: #666666 solid 1px;padding-left: 5px;
}
.conHeaderLeft{
border-bottom: #666666 solid 1px;
}
.conHeaderLeft a{
color:#0033CC; text-decoration:none;
}
.conMain{
width: 100%;height: 100%;margin: 0px;padding: 10px;font-size: 12px;
}
.conMain p{
line-height: 20px;
}
.content{
width:100%;height:100px;margin-top:5px;padding: 0px;border: #CCCCCC solid 1px;
}

</style>
<div class="pageContent">
		<div class="header">
		<table style="width:100%;height:100%;padding:0px;">
			<tr>
				<td style="width: 5%;border-right:#CCCCCC solid 1px; "><div class="photo">
						<img src="#" />
					</div></td>
				<td style="width: 95%;">
					<table border="0" cellpadding="0" cellspacing="0" class="contab">
						<tr style="height: 15px;margin: 0px;">
							<td width="95%" class="conHeaderLeft">
								由<span style="color:#0066FF;">${activity.founder.userName }</span>发布</span>
							</td>
							<td width="5%" class="conHeaderRight"><a href="#">删除活动</a></td>
						</tr>
						<tr>
							<td colspan="2">
								<div class="conMain">
									<p >
										活动主题：${activity.title }
									</p>
									<p >
										活动内容：${activity.activityContent }
									</p>
									<p >
										活动时间：<s:date name="activity.startTime" format="yyyy-MM-dd HH:mm:ss" />到<s:date name="activity.endTime" format="yyyy-MM-dd HH:mm:ss" />
									</p>
								</div>
							</td>
						</tr>
					</table>
				</td>
			</tr>
		</table>
	</div>
	
	<s:iterator value="pages.recordList" var="dis">
	<div class="content">
		<table style="width:100%;height:100%;padding:0px;">
			<tr>
				<td style="width: 5%;border-right:#CCCCCC solid 1px; ">
					<div class="photo">
						<img src="#" />
					</div></td>
				<td style="width: 95%;"><table border="0" cellpadding="0"
						cellspacing="0" class="contab">
						<tr style="height: 15px;margin: 0px;">
							<td width="95%" class="conHeaderLeft"><span
								style="color:#0066FF;">${dis.user.userName }</span> 发表于 <span
								style="color:#6633FF;"><s:date name="#dis.discussTime" format="yyyy-MM-dd HH:mm:ss" /></span>
							</td>
							<td width="5%" class="conHeaderRight"><a href="#" >删除评论</a></td>
						</tr>
						<tr>
							<td colspan="2">
								<div class="conMain">
									<s:if test="dis.parent != null">
										<p style="color:gray;text-decoration: underline;line-height: 20px;">
										”<span style="color: green;">${dis.parent.user.userName }</span>回复：${dis.parent.discussContent }
									</p>
									</s:if>
									<p >${dis.discussContent }</p>
								</div>
							</td>
						</tr>
					</table></td>
			</tr>
		</table>
	</div>
	</s:iterator>
</div>
