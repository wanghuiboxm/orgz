package com.orgz.base;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.orgz.admin.service.AdminService;
import com.orgz.domain.PageBean;
import com.orgz.lbs.service.ActivityGeoService;
import com.orgz.lbs.service.SocietyGeoService;
import com.orgz.lbs.service.UserGeoService;
import com.orgz.service.ActivityService;
import com.orgz.service.ActpraiseService;
import com.orgz.service.DiscussService;
import com.orgz.service.FriendService;
import com.orgz.service.MesPraiseService;
import com.orgz.service.MessageService;
import com.orgz.service.ReplyService;
import com.orgz.service.SocietyService;
import com.orgz.service.UserActivityStoreService;
import com.orgz.service.UserService;
import com.orgz.service.UserSocietyService;
import com.orgz.utils.ThreadPoolUtils;

public class BaseAction extends ActionSupport {
	private static final long serialVersionUID = 1L;

	protected PageBean pages;
	protected int pageNum; // 第几页
	protected int numPerPage; // 每页显示多少条
	protected int flag; //标识从哪个页面过来的请求
	
	protected File upload; 
	protected String uploadContentType;
	protected String uploadFileName;
	
	protected Map<String, Object> dataMap = new HashMap<String, Object>();
	@Resource
	protected UserService userService;
	@Resource
	protected UserGeoService userGeoService;
	@Resource
	protected SocietyService societyService;
	@Resource
	protected SocietyGeoService societyGeoService;
	@Resource
	protected ActivityService activityService;
	@Resource
	protected ActivityGeoService activityGeoService;
	@Resource
	protected AdminService adminService;
	@Resource
	protected DiscussService discussService;
	@Resource
	protected ActpraiseService actpraiseService;
	@Resource
	protected UserSocietyService userSocietyService;
	@Resource
	protected UserActivityStoreService userActivityStoreService;
	@Resource
	protected MessageService messageService;
	@Resource
	protected ReplyService replyService;
	@Resource
	protected MesPraiseService mesPraiseService;
	@Resource
	protected FriendService friendService;
	@Resource
	protected ThreadPoolUtils threadPool;
	
	protected HttpServletRequest request = ServletActionContext.getRequest();
	protected Map<String, Object> session = ServletActionContext.getContext().getSession();
	
	public Map<String, Object> getDataMap() {
		return dataMap;
	}

	public void setDataMap(Map<String, Object> dataMap) {
		this.dataMap = dataMap;
	}

	public PageBean getPages() {
		return pages;
	}

	public void setPages(PageBean pages) {
		this.pages = pages;
	}

	public int getPageNum() {
		return pageNum;
	}

	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}

	public int getNumPerPage() {
		return numPerPage;
	}

	public void setNumPerPage(int numPerPage) {
		this.numPerPage = numPerPage;
	}

	public int getFlag() {
		return flag;
	}

	public void setFlag(int flag) {
		this.flag = flag;
	}

	public File getUpload() {
		return upload;
	}

	public void setUpload(File upload) {
		this.upload = upload;
	}

	public String getUploadContentType() {
		return uploadContentType;
	}

	public void setUploadContentType(String uploadContentType) {
		this.uploadContentType = uploadContentType;
	}

	public String getUploadFileName() {
		return uploadFileName;
	}

	public void setUploadFileName(String uploadFileName) {
		this.uploadFileName = uploadFileName;
	}
}
