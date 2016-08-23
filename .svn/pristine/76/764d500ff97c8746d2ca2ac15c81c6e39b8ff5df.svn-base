<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib uri="/struts-tags" prefix="s" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>有伴管理平台</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>源码科技管理平台</title>
<link href="style/themes/css/login.css" rel="stylesheet" type="text/css" />
<script type="text/javascript">
		$(function(){
			// 在被嵌套时就刷新上级窗口
			window.location.href="login.jsp";
		})
	</script>
</head>

<body>

	<div id="login">
		<div id="login_header">
			<h1 class="login_logo">
				<img src="style/themes/default/images/login_logo.gif"></img>
			</h1>
			<div class="login_headerContent">
				<div class="navList">
					<ul>
						
					</ul>
				</div>
				<h2 class="login_title"><img src="style/themes/default/images/login_title.png" /></h2>
			</div>
		</div>
		<div id="login_content">
			<div class="loginForm">
				<form action="admin/admin_login" method="post">
					<p style="margin-left: 80px;color: red;"><s:property value="#request.msg"></s:property></p>
					<p>
						<label>用户名：</label>
						<input type="text" name="admin.adminName" size="20" class="login_input" />
					</p>
					<p>
						<label>密码：</label>
						<input type="password" name="admin.password" size="20" class="login_input" />
					</p>
					<div class="login_bar">
						<input class="sub" type="submit" value=" " />
					</div>
				</form>
			</div>
			<div class="login_banner"><img src="style/themes/default/images/login_banner.jpg" /></div>
			<div class="login_main">
				<ul class="helpList">
					
				</ul>
				<div class="login_inner">
					<p>您可以使用 网易网盘 ，随时存，随地取</p>
					<p>您还可以使用 闪电邮 在桌面随时提醒邮件到达，快速收发邮件。</p>
					<p>在 百宝箱 里您可以查星座，订机票，看小说，学做菜…</p>
				</div>
			</div>
		</div>
		<div id="login_footer">
			Copyright &copy; 2009 www.orgz.com Inc. All Rights Reserved.
		</div>
	</div>
</body>
</html>
