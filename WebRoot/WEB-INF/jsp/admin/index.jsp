<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>后台管理系统</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />

<link href="style/themes/default/style.css" rel="stylesheet" type="text/css" media="screen"/>
<link href="style/themes/css/core.css" rel="stylesheet" type="text/css" media="screen"/>
<link href="style/themes/css/print.css" rel="stylesheet" type="text/css" media="print"/>
<link href="style/uploadify/css/uploadify.css" rel="stylesheet" type="text/css" media="screen"/>
<!--[if IE]>
<link href="themes/css/ieHack.css" rel="stylesheet" type="text/css" media="screen"/>
<![endif]-->

<!--[if lte IE 9]>
<script src="dwz/style/speedup.js" type="text/javascript"></script>
<![endif]-->

<script src="style/js/jquery-1.7.2.js" type="text/javascript"></script>
<script src="style/js/jquery.cookie.js" type="text/javascript"></script>
<script src="style/js/jquery.validate.js" type="text/javascript"></script>
<script src="style/js/jquery.bgiframe.js" type="text/javascript"></script>

<script src="style/js/jquery.cityselect.js" type="text/javascript"></script>
<script src="style/xheditor/xheditor-1.2.1.min.js" type="text/javascript"></script>
<script src="style/xheditor/xheditor_lang/zh-cn.js" type="text/javascript"></script>
<script src="style/uploadify/scripts/jquery.uploadify.js" type="text/javascript"></script>

<!-- svg图表  supports Firefox 3.0+, Safari 3.0+, Chrome 5.0+, Opera 9.5+ and Internet Explorer 6.0+ -->
<!-- 
<script type="text/javascript" src="style/js/chart/raphael.js"></script>
<script type="text/javascript" src="style/js/chart/g.raphael.js"></script>
<script type="text/javascript" src="style/js/chart/g.bar.js"></script>
<script type="text/javascript" src="style/js/chart/g.line.js"></script>
<script type="text/javascript" src="style/js/chart/g.pie.js"></script>
<script type="text/javascript" src="style/js/chart/g.dot.js"></script>
 -->
<!--
<script src="style/js/dwz.core.js" type="text/javascript"></script>
<script src="style/js/dwz.util.date.js" type="text/javascript"></script>
<script src="style/js/dwz.validate.method.js" type="text/javascript"></script>
<script src="style/js/dwz.barDrag.js" type="text/javascript"></script>
<script src="style/js/dwz.drag.js" type="text/javascript"></script>
<script src="style/js/dwz.tree.js" type="text/javascript"></script>
<script src="style/js/dwz.accordion.js" type="text/javascript"></script>
<script src="style/js/dwz.ui.js" type="text/javascript"></script>
<script src="style/js/dwz.theme.js" type="text/javascript"></script>
<script src="style/js/dwz.switchEnv.js" type="text/javascript"></script>
<script src="style/js/dwz.alertMsg.js" type="text/javascript"></script>
<script src="style/js/dwz.contextmenu.js" type="text/javascript"></script>
<script src="style/js/dwz.navTab.js" type="text/javascript"></script>
<script src="style/js/dwz.tab.js" type="text/javascript"></script>
<script src="style/js/dwz.resize.js" type="text/javascript"></script>
<script src="style/js/dwz.dialog.js" type="text/javascript"></script>
<script src="style/js/dwz.dialogDrag.js" type="text/javascript"></script>
<script src="style/js/dwz.sortDrag.js" type="text/javascript"></script>
<script src="style/js/dwz.cssTable.js" type="text/javascript"></script>
<script src="style/js/dwz.stable.js" type="text/javascript"></script>
<script src="style/js/dwz.taskBar.js" type="text/javascript"></script>
<script src="style/js/dwz.ajax.js" type="text/javascript"></script>
<script src="style/js/dwz.pagination.js" type="text/javascript"></script>
<script src="style/js/dwz.database.js" type="text/javascript"></script>
<script src="style/js/dwz.datepicker.js" type="text/javascript"></script>
<script src="style/js/dwz.effects.js" type="text/javascript"></script>
<script src="style/js/dwz.panel.js" type="text/javascript"></script>
<script src="style/js/dwz.checkbox.js" type="text/javascript"></script>
<script src="style/js/dwz.history.js" type="text/javascript"></script>
<script src="style/js/dwz.combox.js" type="text/javascript"></script>
<script src="style/js/dwz.print.js" type="text/javascript"></script>-->
 
<!-- 可以用dwz.min.js替换前面全部dwz.*.js (注意：替换是下面dwz.regional.zh.js还需要引入)-->
<script src="style/bin/dwz.min.js" type="text/javascript"></script>

<script src="style/js/dwz.regional.zh.js" type="text/javascript"></script>

<script type="text/javascript">
$(function(){
	DWZ.init("style/dwz.frag.xml", {
		// loginUrl:"login.html", loginTitle:"登录",	// 弹出登录对话框
		loginUrl:"login.html",	// 跳到登录页面
		statusCode:{ok:200, error:300, timeout:301}, //【可选】
		pageInfo:{pageNum:"pageNum", numPerPage:"numPerPage", orderField:"orderField", orderDirection:"orderDirection"}, //【可选】
		keys: {statusCode:"statusCode", message:"message"}, //【可选】
		ui:{hideMode:'offsets'}, //【可选】hideMode:navTab组件切换的隐藏方式，支持的值有’display’，’offsets’负数偏移位置的值，默认值为’display’
		debug:false,	// 调试模式 【true|false】
		callback:function(){
			initEnv();
			$("#themeList").theme({themeBase:"style/themes"}); // themeBase 相对于index页面的主题base路径
		}
	});
	//$("#test").load("admin/society_checkList?sc.property=2&sc.status=1");
	$("#societyCheckList").click();
});

</script>
</head>

<body scroll="no">
	<div id="layout">
		<div id="header">
			<div class="headerNav">
				<ul class="nav">
					<li><span style="color:white;">管理员${admin.adminName }您好！</span></li>
					<li><a href="admin/admin_editpwdUI" target="dialog" width="600">修改密码</a></li>
					<s:if test="admin.adminName == 'admin'">
						<li><a href="admin/admin_addUI" target="dialog" width="600">添加管理员</a></li>
						<li><a href="admin/admin_list" target="navTab" rel="adminList"  id="adminList">查看管理员</a></li>
					</s:if>
					<li><a href="admin/admin_quit">退出</a></li>
				</ul>
				<ul class="themeList" id="themeList">
					<li theme="default"><div class="selected">蓝色</div></li>
					<li theme="green"><div>绿色</div></li>
					<!--<li theme="red"><div>红色</div></li>-->
					<li theme="purple"><div>紫色</div></li>
					<li theme="silver"><div>银色</div></li>
					<li theme="azure"><div>天蓝</div></li>
				</ul>
			</div>

			<!-- navMenu -->
			
		</div>

		<div id="leftside">
			<div id="sidebar_s">
				<div class="collapse">
					<div class="toggleCollapse"><div></div></div>
				</div>
			</div>
			<div id="sidebar">
				<div class="toggleCollapse"><h2>主菜单</h2><div>收缩</div></div>

				<div class="accordion" fillSpace="sidebar">
					<div class="accordionHeader">
						<h2><span>Folder</span>用户管理</h2>
					</div>
					<div class="accordionContent">
						<ul class="tree">
							<li><a href="admin/user_list" target="navTab" title="浏览用户" rel="userList" id="userList">浏览用户</a></li>
						</ul>
					</div>
					<div class="accordionHeader">
						<h2><span>Folder</span>社团管理</h2>
					</div>
					<div class="accordionContent">
						<ul class="tree">
							<li><a href="admin/society_list" target="navTab" rel="societyList">浏览社团</a></li>
							<li><a href="admin/society_checkList?sc.property=2&sc.status=1" target="navTab" rel="societyCheckList" id="societyCheckList">待审核社团</a></li>
							<li><a href="admin/society_unCheckList?sc.property=2&sc.status=2" target="navTab" rel="societyUnCheckList" id="societyUnCheckList">审核不通过社团</a></li>
						</ul>
					</div>
					<div class="accordionHeader">
						<h2><span>Folder</span>活动管理</h2>
					</div>
					<div class="accordionContent">
						<ul class="tree">
							<li><a href="admin/activity_list" target="navTab" rel="activityList" id="activityList">查看活动</a></li>
						</ul>
					</div>
					<div class="accordionHeader">
						<h2><span>Folder</span>留言板管理</h2>
					</div>
					<div class="accordionContent">
						<ul class="tree">
							<li><a href="admin/message_list" target="navTab" rel="messageList">查看留言</a></li>
						</ul>
					</div>
					<div class="accordionHeader">
						<h2><span>Folder</span>版本管理</h2>
					</div>
					<div class="accordionContent">
						<ul class="tree">
							<li><a href="admin/version_list" target="navTab" rel="versionList">查看版本记录</a></li>
						</ul>
					</div>
				</div>
			</div>
		</div>
		<div id="container">
			<div id="navTab" class="tabsPage">
				<div class="tabsPageHeader">
					<div class="tabsPageHeaderContent"><!-- 显示左右控制时添加 class="tabsPageHeaderMargin" -->
						<ul class="navTab-tab">
							<li tabid="main" class="main"><a href="javascript:;"><span><span class="home_icon">我的主页</span></span></a></li>
						</ul>
					</div>
					<div class="tabsLeft tabsLeftDisabled">left</div><!-- 禁用只需要添加一个样式 class="tabsLeft tabsLeftDisabled" -->
					<div class="tabsRight tabsRightDisabled">right</div><!-- 禁用只需要添加一个样式 class="tabsRight tabsRightDisabled" -->
					<div class="tabsMore">more</div>
				</div>
				<ul class="tabsMoreList">
					 <li><a href="#">我的主页</a></li>
				</ul>
				<div class="navTab-panel tabsPageContent layoutBox">
				<div class="page unitBox" id="test"> 
					 <div class="accountInfo">
					<p><h2>有伴后台管理</h2></p>
					
					</div>
					 <div class="accountInfo">
					<p><li><a href="admin/society_list" target="navTab" rel="societyList">浏览社团</a></li></p>
					<p><li><a href="admin/society_checkList?sc.property=2&sc.status=1" target="navTab" rel="societyCheckList" id="societyCheckList">待审核社团</a></li></p>
					</div>
				 </div>
				
			</div>
			</div>
		</div>

	</div>

	<div id="footer">Copyright &copy; 联码科技</div>

</body>
</html>
