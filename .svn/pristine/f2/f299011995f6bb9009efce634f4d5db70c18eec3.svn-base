<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<div class="pageContent">
	<form method="post" action="admin/user_edit"
		class="pageForm required-validate"
		onsubmit="return validateCallback(this, dialogAjaxDone);">
		<div class="pageFormContent" layoutH="50">
			<p>
				<label>用户标识：</label> <input name="user.userId" type="text" size="30"
					value="${user.userId }" readonly="readonly" />
			</p>
			<p>
				<label>用户名：</label> <input name="user.userName" type="text"
					size="30" value="${user.userName }" />
			</p>
			<p>
				<label>Email：</label> <input type="text" size="30" name="user.email"
					value="${user.email }" readonly="readonly" />
			</p>
			<p>
				<label>电话：</label> 
				<input type="text" size="30" name="user.phoneNumber" value="${user.phoneNumber }" readonly="readonly" />
			</p>
			<p>
				<label>性别：</label>
					<input type="radio" name="user.sex" value="0" <s:if test="user.sex == 0">checked="checked"</s:if>/>女
					<input type="radio" name="user.sex" value="1" <s:if test="user.sex == 1">checked="checked"</s:if>/>男
			</p>
			<p>
				<label>注册时间：</label>
				<s:date name="user.regtime" format="yyyy-MM-dd HH:mm:ss" var="regtime" />
				 <input name="user.regtime" type="text" size="30" value="${requestScope.regtime }" readonly="readonly" />
			</p>
			<p>
				<label>最近登录时间：</label> 
				<s:date name="user.latelyTime" format="yyyy-MM-dd HH:mm:ss" var="latelyTime" />
				<input name="user.latelyTime" type="text" size="30" value="${requestScope.latelyTime }" readonly="readonly" />
			</p>
			<p>
				<label>签名：</label>
				<input name="user.userSign" type="text" value="${user.userSign }" size="30" />
			</p>
			<p>
				<label>用户所在区域：</label> 
				<input type="text" size="30" value="${user.province }${user.city}${user.district}" readonly="readonly" />
			</p>
			<p>
				<label>用户详细地址：</label> <input type="text" name="user.address" value="${user.address }" size="30" readonly="readonly" />
			</p>
		</div>
		<div class="formBar">
			<ul>
				<!--<li><a class="buttonActive" href="javascript:;"><span>保存</span></a></li>-->
				<li><div class="buttonActive">
						<div class="buttonContent">
							<button type="submit">保存</button>
						</div>
					</div>
				</li>
				<li>
					<div class="button">
						<div class="buttonContent">
							<button type="button" class="close">取消</button>
						</div>
					</div></li>
			</ul>
		</div>
	</form>
</div>
