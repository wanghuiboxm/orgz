<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<div class="pageContent">
	
	<form method="post" action="admin/admin_add" class="pageForm required-validate" onsubmit="return validateCallback(this, dialogAjaxDone)">
		<div class="pageFormContent" layoutH="50">
			<p>
				<label>用户名：</label> 
				<input name="admin.adminName" type="text" size="30" class="required "/>
			</p>
			<p>
				<label>Email：
				</label> <input type="text" size="30" name="admin.email" class="email" />
			</p>
			<p>
				<label>电话：</label> 
				<input type="text" size="30" name="admin.phoneNumber" />
			</p>
			<p>
				<label>密码：</label>
				<input type="password" id="cp_newPassword" name="newPassword" size="30" minlength="6" maxlength="20" class="required alphanumeric"/>
			</p>
			<p>
				<label>重复输入新密码：</label>
				<input type="password" name="rnewPassword" size="30" equalTo="#cp_newPassword" class="required alphanumeric"/>
			</p>
		</div>
		<div class="formBar">
			<ul>
				<li><div class="buttonActive"><div class="buttonContent"><button type="submit">提交</button></div></div></li>
				<li><div class="button"><div class="buttonContent"><button type="button" class="close">取消</button></div></div></li>
			</ul>
		</div>
	</form>
	
</div>
