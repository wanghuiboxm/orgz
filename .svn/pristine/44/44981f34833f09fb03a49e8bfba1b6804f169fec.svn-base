<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib uri="/struts-tags" prefix="s" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>


<script type="text/javascript">
	$(function(){
		$("#city").citySelect({
		url:"style/js/city.min.js",
		nodata:"none",
		required:true
		}); 
	});
	
$(function() {
    $("#city").citySelect({
        url: "style/js/city.min2.js",
        nodata: "none",
        required: true
    });
});
var isIE = /msie/i.test(navigator.userAgent) && !window.opera; 

function fileChange(target, id) {
    var fileSize = 0;
    var filetypes = [".jpg", ".png", ".gif"];
    var filepath = target.value;
    var filemaxsize = 2000; //200kb
    if (filepath) {
        var isnext = false;
        var fileend = filepath.substring(filepath.indexOf("."));
        if (filetypes && filetypes.length > 0) {
            for (var i = 0; i < filetypes.length; i++) {
                if (filetypes[i] == fileend) {
                    isnext = true;
                    break;
                }
            }
        }
        if (!isnext) {
            alert("不接受此文件类型！");
            target.value = "";
            return false;
        }
    } else {
        return false;
    }
    
    if (isIE && !target.files) {
    	
        var filePath = target.value;
        var fileSystem;
        try {  
                fileSystem = new ActiveXObject("Scripting.FileSystemObject");  
            } catch (e) {  
                alert("您用的是IE浏览器，请使用其他浏览器或将IE安全级别调低！");  
                var file = $("#upload");
                file.after(file.clone().val(""));
                file.remove();
            return false;
            }  
        if (!fileSystem.FileExists(filePath)) {
            alert("附件不存在，请重新输入！");
            return false;
        }
        var file = fileSystem.GetFile(filePath);
        fileSize = file.Size;
            
    } else {
        fileSize = target.files[0].size;
    }

    var size = fileSize/1024;
    if (size > filemaxsize) {
        alert("附件大小不能大于" + filemaxsize + "KB！");
        target.value = "";
        return false;
    }
    if (size <= 0) {
        alert("附件大小不能为0KB！");
        target.value = "";
        return false;
    }
}
	
</script>

<div class="pageContent" >
	
	<form method="post" action="admin/activity_add" class="pageForm required-validate" enctype="multipart/form-data" onsubmit="return iframeCallback(this, dialogAjaxDone);">
	<!--<form method="post" action="admin/activity_add" class="pageForm required-validate" onsubmit="return iframeCallback validateCallback(this, dialogAjaxDone)">-->
		<div class="pageFormContent nowrap" layoutH="50" style="margin: auto;">

			<dl>
				<dt>活动主题：</dt>
				<dd>
					<input type="text" name="activity.title" class="required" />
					<span class="info"></span>
				</dd>
			</dl>
			<dl>
				<dt>开始时间：</dt>
				<dd>
					<input type="text" name="activity.startTime" class="date required" dateFmt="yyyy-MM-dd HH:mm:ss" readonly="readonly"/>
					<a class="inputDateButton" href="javascript:;">选择</a>
				</dd>
			</dl>
			<dl>
				<dt>结束时间：</dt>
				<dd>
					<input type="text" name="activity.endTime" class="date required" dateFmt="yyyy-MM-dd HH:mm:ss" readonly="readonly"/>
					<a class="inputDateButton" href="javascript:;">选择</a>
				</dd>
			</dl>
			
					<input type="hidden" name="societyId" value="${admin.society.societyId }"/>
			
			
					<input type="hidden" name="userId" value="${admin.user.userId }"/>
			
			<dl>
				<dt>地址</dt>
				<dd>
					<div id="city"> 
						<select class="prov" name="activity.province"></select>  
						<select class="city" name="activity.city" disabled="disabled"></select> 
						<select class="dist" name="activity.district" disabled="disabled"></select> 

					</div> 
				</dd>
			</dl>
			<dl>
				<dt>详细地址</dt>
				<dd>
					<input type="text" name="activity.address"/>
					<span class="info"></span>
				</dd>
			</dl>
			<dl>
				<dt>活动图片：</dt>
				<dd >
					<input type="file" name="upload" onchange="fileChange(this)" id="upload" class="required" style="width: 150px;"/>		
				</dd><span class="info">图片支持jpg,png,gif 大小不超过200KB</span>		
			</dl>
			<dl>
				<dt>活动内容：</dt>
				<dd>
				<textarea rows="10" cols="50" name="activity.activityContent" class="required" alt="请输入活动内容"></textarea>
					<span class="info"></span>
				</dd>
			</dl>
			</div>
		<div class="formBar">
			<ul>
				<li><div class="buttonActive"><div class="buttonContent"><button onclick="tijiao()" >提交</button>
				<script type="text/javascript">
					function tijiao(){
						//$("form").submit(iframeCallback(this, dialogAjaxDone));
						//if(result == true){
						//	$("#guanbi").click();
						//}
						//$.pdialog.closeCurrent();
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

