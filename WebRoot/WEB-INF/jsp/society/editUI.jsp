<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<div class="pageContent">
	<form method="post" action="admin/society_edit"
		class="pageForm required-validate"
		onsubmit="return validateCallback(this, dialogAjaxDone);">
		<div class="pageFormContent" layoutH="56">
			<p>
				<label>社团标识：</label> <input name="society.societyId" type="text" size="30"
					value="${society.societyId }" readonly="readonly" />
			</p>
			<p>
				<label>社团名称：</label>
				 <input name="society.societyName" type="text" size="30" value="${society.societyName }" />
				 <span class="inputInfo" style="color:blue;">可修改</span>
			</p>
			<p>
				<label>社团属性：</label>
				<select name="society.property" >
					<option value="0" <s:if test="society.property == 0"> selected="selected" </s:if> >个人</option>
					<option value="1" <s:if test="society.property == 1"> selected="selected" </s:if> >官方</option>
				</select>
				<span class="inputInfo" style="color:blue;">可修改</span>
			</p>
			<p>
				<label>创建时间：</label> 
				<s:date name="society.createTime" format="yyyy-MM-dd HH:mm:ss" var="createTime" />
				<input type="text" size="30" name="society.createTime" value="${requestScope.createTime }" readonly="readonly" />
			</p>
			<p>
				<label>学校：</label>
					<input type="text" name="society.school" value="${society.school }" size="30" />
			</p>
			<p>
				<label>标签：</label>
				 <input name="society.tags" type="text" size="30" value="${society.tags }" />
				 <span class="inputInfo" style="color:blue;">可修改</span>
			</p>
			<p>
				<label>活动数：</label> 
				<input name="society.activityCount" type="text" size="30" value="${society.activityCount }" readonly="readonly" />
			</p>
			<p>
				<label>社团人数：</label>
				<input name="society.peopleCount" type="text" size="30" value="${society.peopleCount }" readonly="readonly" />
			</p>
			<p>
				<label>社团所在区域：</label> 
				<input type="text" size="30" value="${society.province }${society.city}${society.district}" readonly="readonly" />
			</p>
			<p>
				<label>社团介绍：</label> 
				<input type="text" size="30" value="${society.introduce }" />
				<span class="inputInfo" style="color:blue;">可修改</span>
			</p>
			<p>
				<label>创建人：</label> 
				<input type="hidden" size="30" name="society.founder.userId" value="${society.founder.userId }" />
				<input type="text" size="30" value="${society.founder.userName }" readonly="readonly" />
			</p>	
		</div>
		<div class="formBar">
			<ul>
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
