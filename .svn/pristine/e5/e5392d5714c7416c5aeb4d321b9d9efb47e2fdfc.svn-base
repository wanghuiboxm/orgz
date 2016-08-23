<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<div class="pageContent">
	<form method="post" action="admin/society_list" class="pageForm" onsubmit="return navTabSearch(this);">
		<div class="pageFormContent" layoutH="58">
			<div class="unit">
				<label>社团名称：</label>
				<input type="text" name="sc.societyName" size="50"/>
				<span class="inputInfo">关键字或全称</span>
			</div>
			<div class="divider">divider</div>
						<div class="unit">
				<label>社团属性：</label>
				<label class="radioButton"><input name="sc.property" type="radio" value="2" checked="checked" />全部</label>
				<label class="radioButton"><input name="sc.property" type="radio" value="1"/>官方</label>
				<label class="radioButton"><input name="sc.property" type="radio" value="0"/>个人</label>
			</div>
			<div class="unit">
				<label>社团状态：</label>
				<label class="radioButton"><input name="sc.status" type="radio" value="3" checked="checked"/>全部</label>
				<label class="radioButton"><input name="sc.status" type="radio" value="0"/>通过</label>
				<label class="radioButton"><input name="sc.status" type="radio" value="1"/>待审核</label>
				<label class="radioButton"><input name="sc.status" type="radio" value="2"/>未通过</label>
			</div>
			<div class="unit">
				<label>标签：</label>
				<input type="text" size="25" name="sc.tags"/>
				<span class="inputInfo">关键字</span>
			</div>		
			<div class="unit">
				<label>社团所在城市：</label>
				<input type="text" size="25" name="sc.city"/>
				<span class="inputInfo">关键字或全称</span>
			</div>		
			<div class="divider">divider</div>
		</div>
		<div class="formBar">
			<button id="guanbi" class="close" value="关闭"></button>
			<ul>
				<li><div class="buttonActive"><div class="buttonContent"><button type="submit" onclick="search()">开始检索</button>
					<script type="text/javascript">
						function search(){
							$("#guanbi").click();
						}
					</script>
				</div></div></li>
				<li><div class="button"><div class="buttonContent"><button type="reset">清空重输</button></div></div></li>
			</ul>
		</div>
	</form>
</div>
