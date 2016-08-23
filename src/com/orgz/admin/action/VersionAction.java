package com.orgz.admin.action;

import java.io.InputStream;
import java.util.List;

import javax.annotation.Resource;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.Action;
import com.orgz.admin.service.VersionService;
import com.orgz.base.BaseAction;
import com.orgz.domain.Version;
import com.orgz.utils.FileUploadUtils;

@Controller
@Scope("prototype")
public class VersionAction extends BaseAction {
	
	private static final long serialVersionUID = 1L;
	
	@Resource
	private VersionService versionService;
	private int versionId;
	private String inputName;
	private Version version;
	private String savePath = ServletActionContext.getServletContext().getRealPath("roms");
	private List<Version> versions;
	private String filename;
	 
	public String checkUpdate() throws Exception {
		if(versionId > 0) {
			//如果true,表示最新版本与当前版本一致
			version = versionService.getLatestVersion();
			if(version !=null && version.getVersionId() == versionId){
				dataMap.put("status", 0);
				dataMap.put("message", "没有更新");
			} else {
				dataMap.put("status", 7);
				dataMap.put("message", "有版本更新");
				dataMap.put("result", version);
			}
		}
		return Action.SUCCESS; 
	} 
 
	public String getUpdate() throws Exception {
		version = versionService.getLatestVersion();

		inputName = version.getRomUrl();
		String name = "有伴_"+version.getVersionNumber()+".apk";
		//解决下载文件中文名乱码问题
		filename = new String(name.getBytes(), "ISO-8859-1");
		return "version";
	}
	
	public String add() throws Exception {
		if(version != null) {
//			String fileName = FileUploadUtils.getFileName(uploadFileName);
			String fileName = "有伴_"+version.getVersionNumber()+".apk";
			FileUploadUtils.saveFile(upload, savePath, fileName);
			version.setRomUrl("roms/"+fileName);
			versionService.addVersion(version);

			dataMap.put("status", 200);
			dataMap.put("message", "添加成功"); 
			dataMap.put("navTabId", "versionList");
			dataMap.put("rel", "");
			dataMap.put("callbackType", "closeCurrent");
			dataMap.put("forwardUrl", "");
		} else {
			dataMap.put("statusCode", 300);
			dataMap.put("message", "添加失败");
		}
		return "jsonResult";
	}
	
	public String list() throws Exception {
		versions = versionService.findAll();
		return "list";
	}
	
	public String addUI() throws Exception {
		return "addUI";
	}
	
	public int getVersionId() {
		return versionId;
	}

	public void setVersionId(int versionId) {
		this.versionId = versionId;
	}

	public InputStream getTargetFile() {
		return ServletActionContext.getServletContext().getResourceAsStream(inputName);
	}

	public List<Version> getVersions() {
		return versions;
	}

	public void setVersions(List<Version> versions) {
		this.versions = versions;
	}

	public Version getVersion() {
		return version;
	}

	public void setVersion(Version version) {
		this.version = version;
	}

	public String getFilename() {
		return filename;
	}

	public void setFilename(String filename) {
		this.filename = filename;
	}

}
