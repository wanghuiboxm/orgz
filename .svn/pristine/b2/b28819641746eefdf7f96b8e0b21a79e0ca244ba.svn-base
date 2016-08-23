<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib uri="/struts-tags" prefix="s" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<div class="pageContent" >
	
	<form method="post" action="admin/version_add" class="pageForm required-validate" enctype="multipart/form-data" onsubmit="return iframeCallback(this, dialogAjaxDone);">
	<!--<form method="post" action="admin/activity_add" class="pageForm required-validate" onsubmit="return iframeCallback validateCallback(this, dialogAjaxDone)">-->
		<div class="pageFormContent nowrap" layoutH="50" style="margin: auto;">

			<dl>
				<dt>版本号：</dt>
				<dd>
					<input type="text" name="version.versionNumber" class="required" />
					<span class="info"></span>
				</dd>
			</dl>
			<dl>
				<dt>程序apk文件：</dt>
				<dd >
					<input type="file" name="upload"  id="upload" class="required" style="width: 150px;"/>		
				</dd>	
			</dl>
			<dl>
				<dt>版本描述：</dt>
				<dd>
				<textarea rows="10" cols="50" name="version.versionSign" class="required" alt="请输入活动内容"></textarea>
					<span class="info"></span>
				</dd>
			</dl>
			</div>
		<div class="formBar">
			<ul>
				<li><div class="buttonActive"><div class="buttonContent"><button onclick="tijiao()" >提交</button>
				<script type="text/javascript">
					function tijiao(){
						$("form").submit(iframeCallback(this, dialogAjaxDone));
						if(result == true){
							$("#guanbi").click();
						}
						$.pdialog.closeCurrent();
					}
				</script>
				</div></div></li>
				<li><div class="button"><div class="buttonContent"><button id="guanbi" type="button" class="close">取消</button></div></div></li>
			</ul>
		</div>
	</form>
	
</div>



<script type="text/javascript">
function customvalidXxx(element){
	if ($(element).val() == "xxx") return false;
	return true;
}
</script>

