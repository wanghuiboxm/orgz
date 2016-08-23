package com.orgz.action;

import java.util.List;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import com.opensymphony.xwork2.Action;
import com.orgz.base.BaseAction;
import com.orgz.base.SearchConditonOfSociety;
import com.orgz.domain.Society;
import com.orgz.domain.User;
import com.orgz.lbs.service.SocietyGeoService;
import com.orgz.utils.BeanUtils;
import com.orgz.utils.FileUploadUtils;

@Controller
@Scope("prototype")
public class SocietyAction extends BaseAction {
	private static final long serialVersionUID = 1L;

	private Society society;
	private int societyId;
	private int userId = -1;
	private SearchConditonOfSociety sc;
	private int[] ids;
	private String reason; //申请加入社团理由
	private String keyword;
	private String tags;

	private String savePath = ServletActionContext.getServletContext().getRealPath("image/society");
	/**
	 * 创建社团
	 * @return
	 * @throws Exception
	 */
	public String create() throws Exception {
		User user = null;
		if (userId > 0 && society != null && society.isMatchCodition()) {
			// 根据userId得到用户信息
			user = userService.findUserById(userId);
			int societyId = -1;
			System.out.println(society.toString());
			System.out.println(society.isMatchCodition());
			// 如果注册信息完整,而且用户存在
			if (user != null) {
				// 如果上传了图片
				if (upload != null && uploadFileName != null) {
					String fileName = FileUploadUtils.getFileName(userId,
							uploadFileName);
					FileUploadUtils.saveFile(upload, savePath, fileName);
					// 将图片保存路径赋值给活动
					society.setSocietyIcon("image/society/" + fileName);

				}
				// 如果注册官方社团
				if (society.getProperty() == 1) {
					societyId = societyService.createOfficialSociety(society,
							user);
					society.setSocietyId(societyId);
				} else {
					// 如果是个人社团
					societyId = societyService.createPersonalSociety(society,
							user);
					society.setSocietyId(societyId);
					// 向lbs发送信息
					societyGeoService.insertSocietyToGeo(society);
					threadPool.invokeMethod(SocietyGeoService.class,
							"insertSocietyToGeo", society,
							BeanUtils.copy(societyGeoService));
				}
				dataMap.put("status", 0);
				dataMap.put("message", "成功");
			}else {
				dataMap.put("status", 4);
				dataMap.put("message", "参数错误");
			}
		}else {
			dataMap.put("status", 4);
			dataMap.put("message", "参数错误");
		}
		return Action.SUCCESS;
	}
	
	//申请加入社团
	public String toJoin() throws Exception {
		if(societyId >0 && userId > 0 && reason != null){
			//查看用户是否已经加入过该社团
			if(userSocietyService.findByUserIdAndSocietyId(societyId, userId) != null){
				dataMap.put("status", 2);
				dataMap.put("message", "您已加入过该社团");
			}else{
				userSocietyService.insert(userId, societyId, reason, 0);
				//更新社团人数
				societyService.updatePeopleCount(societyId);
				//得到社团信息
				Society s = societyService.findSocietyById(societyId, userId);
				//向lbs更新社团信息
				if(s != null){
					threadPool.invokeMethod(SocietyGeoService.class, "updateSocietyGeo", s, BeanUtils.copy(societyGeoService));
				}
				dataMap.put("status", 0);
				dataMap.put("message", "成功");
			}
		}else{
			dataMap.put("status", 4);
			dataMap.put("message", "参数不正确");
		}
		return Action.SUCCESS;
	}
	
	//退出社团
	public String toQuit() throws Exception {
		if(societyId >0 && userId > 0){
			//退出社团
			int count = userSocietyService.deleteByUserIdAndSocietyId(userId, societyId);
			if(count > 0) {
				//减少社团人数
				societyService.updatePeopleCountReduce(societyId);
				//得到社团信息
				Society s = societyService.findSocietyById(societyId, userId);
				//向lbs更新社团信息
				if(s != null){
					threadPool.invokeMethod(SocietyGeoService.class, "updateSocietyGeo", s, BeanUtils.copy(societyGeoService));
				}
			}
			dataMap.put("status", 0);
			dataMap.put("message", "成功");
		}else{
			dataMap.put("status", 4);
			dataMap.put("message", "参数错误");
	}
		return Action.SUCCESS;
	}
	
	/**
	 * 展示加入或者创建的社团
	 * @return
	 * @throws Exception
	 */
	public String myList() throws Exception{
		List<Society> result = null;
//		User user = (User) ServletActionContext.getContext().getSession().get("user");
		if(userId > 0){
			result = societyService.findAllByUserId(userId);
			if(result == null || result.size() < 1){
				result = societyService.findHot();
				//推荐热门社团
				dataMap.put("status", 11); 
				dataMap.put("message", "推荐的热门社团");
				dataMap.put("result", result);
			}else{
				dataMap.put("status", 0);
				dataMap.put("result", result);
				dataMap.put("message", "成功");
			}
		}else{
			dataMap.put("status", 1);
			dataMap.put("message", "请登录");
		}
		return Action.SUCCESS;
	}
	
	/**
	 * 展示某个社团的详细信息
	 * @return
	 * @throws Exception
	 */
	public String detail() throws Exception{
		if(societyId > 0 && userId > 0) {
			Society soc =  societyService.findSocietyById(societyId, userId);
			if(soc != null){
				dataMap.put("result", soc);
				dataMap.put("status", 0);
				dataMap.put("message", "成功");
			}else{
				dataMap.put("status", 1);
				dataMap.put("message", "失败");
			}
		}else {
			dataMap.put("status", 4);
			dataMap.put("message", "参数不合法");
		}
		return Action.SUCCESS;
	}
	
	//用户搜索社团
	public String search() throws Exception {
		if(userId > 0 && keyword != null) {
			//表示不分页
			if(numPerPage == -1 && pageNum == -1) {
				pageNum = 1;
				numPerPage = 0;
			} else {
				if(numPerPage < 1){
					//默认每页显示20条
					numPerPage = 20;
				}
				if(pageNum < 1){
					//默认显示第一页
					pageNum = 1;
				}
			}
			//构造查询条件
			//默认显示全部审核通过社团
			sc = new SearchConditonOfSociety();
			sc.setSocietyName(keyword);
			sc.setUserId(userId);
			//显示审核通过社团
			sc.setStatus(0);
			sc.setProperty(2);
			if(tags != null){
				sc.setTags(tags);
			}
			//准备数据
			pages = societyService.getPageBean(sc, numPerPage, pageNum);
			dataMap.put("status", 1);
			dataMap.put("message", "成功");
			dataMap.put("result", pages);
			System.out.println(sc.toString());
		}else {
			dataMap.put("status", 4);
			dataMap.put("message", "参数错误");

		}
		return Action.SUCCESS;
	}
	
	//以下是后台方法
	
	public String showDetail() throws Exception {
		if(society != null){
			society = societyService.findSocietyById(society.getSocietyId(),0);
		}
		return "detail";
	}
	public String checkPass() throws Exception {
		//如果社团不空
		if(society != null){
			//如果是审核通过
			if(society.getStatus() == 0){
				societyService.checkPass(society.getSocietyId(),society.getStatus());
				//根据id得到社团
				Society s = societyService.findSocietyById(society.getSocietyId(), 0);
				if(s.getAddress()!=null && s.getCity() != null){
					//向lbs云存储发送社团信息,这里放在线程池中进行
					threadPool.invokeMethod(SocietyGeoService.class, "insertSocietyToGeo", s, BeanUtils.copy(societyGeoService));
				}
			}else{
				societyService.checkPass(society.getSocietyId(),society.getStatus());
			}
			dataMap.put("statusCode", "200");
			dataMap.put("message", "操作成功");
			//判断是从那个页面来的请求
			if(flag == 0){//待审页发来
				dataMap.put("navTabId", "societyCheckList");
				dataMap.put("rel", "societyCheckList");
			}
			if(flag == 1){//审核不过页发来请求
				dataMap.put("navTabId", "societyUnCheckList");
				dataMap.put("rel", "societyUnCheckList");
			}
			dataMap.put("callbackType", "");
			dataMap.put("forwardUrl", "");
			
		}else{		
			dataMap.put("statusCode", "300");
			dataMap.put("message", "操作失败");
		}
		return "jsonResult";
	}
	
	/**
	 * 展示所有社团
	 * @return
	 * @throws Exception
	 */
	public String list() throws Exception {
		if(numPerPage <= 0 ){
			//默认显示20条记录
			numPerPage = 20;
		}
		if(pageNum <= 0){
			//默认显示第一页
			pageNum = 1;
		}
		//构造查询条件
		//默认显示全部审核通过社团
		if(sc == null){
			sc = new SearchConditonOfSociety(2, 0, null, null, null, null);
		}
		//准备数据
		pages = societyService.getPageBean(sc, numPerPage, pageNum);
		System.out.println(sc.toString());
		return "list";
	}
	
	public String checkList() throws Exception {
		if(numPerPage <= 0 ){
			//默认显示20条记录
			numPerPage = 20;
		}
		if(pageNum <= 0){
			//默认显示第一页
			pageNum = 1;
		}
		//构造查询条件
		//默认显示全部待审核社团
		if(sc == null){
			sc = new SearchConditonOfSociety(2, 1, null, null, null, null);
		}
		pages = societyService.getPageBean(sc, numPerPage, pageNum);
		return "checkList";
	}
	
	public String unCheckList() throws Exception {
		if(numPerPage <= 0 ){
			//默认显示20条记录
			numPerPage = 20;
		}
		if(pageNum <= 0){
			//默认显示第一页
			pageNum = 1;
		}
		//构造查询条件
		//默认显示全部审核不通过社团
		if(sc == null){
			sc = new SearchConditonOfSociety(2, 2, null, null, null, null);
		}
		pages = societyService.getPageBean(sc, numPerPage, pageNum);
		return "unCheckList";
	}
	
	public String editUI() throws Exception {
		//根据id得到需要修改社团的信息
		if(society != null){
			int id = society.getSocietyId();
			society = societyService.findSocietyById(id, 0);
		}
		return "editUI";
	}

	public String edit() throws Exception {
		if (society != null && society.getSocietyId() >= 0) {
			// 更新修改后的数据
			societyService.updateSociety(society);
			//得到社团信息
			Society s = societyService.findSocietyById(society.getSocietyId(), 0);
			//向lbs更新社团信息
			if(s != null){
				threadPool.invokeMethod(SocietyGeoService.class, "updateSocietyGeo", s, BeanUtils.copy(societyGeoService));
			}
			
			dataMap.put("statusCode", "200");
			dataMap.put("message", "修改成功");
		} else {
			dataMap.put("statusCode", "300");
			dataMap.put("message", "修改失败");
		}
		dataMap.put("navTabId", "societyList");
		dataMap.put("rel", "societyList");
		dataMap.put("callbackType", "closeCurrent");
		dataMap.put("forwardUrl", "");

		return "jsonResult";
	}
	
	//批量审核
	public String batchCheckPass() throws Exception {
		for(int i=0; i<ids.length; ++i){
			System.out.println(ids[i]);
		}
		//有需要批量处理的社团
		if(ids != null && ids.length != 0 && society != null){
			societyService.batchUpdateStatus(ids, society.getStatus());
			dataMap.put("statusCode", "200");
			dataMap.put("message", "修改成功");
			//判断是从那个页面来的请求
			if(flag == 0){//待审页发来
				dataMap.put("navTabId", "societyCheckList");
				dataMap.put("rel", "societyCheckList");
			}
			if(flag == 1){//审核不过页发来请求
				dataMap.put("navTabId", "societyUnCheckList");
				dataMap.put("rel", "societyUnCheckList");
			}
			//如果是审核通过
			if(society.getStatus() == 0){
				//循环查找出社团信息，然后更新到lbs
				for(int id:ids){
					Society s = societyService.findSocietyById(id, 0);
					if(s != null){
						threadPool.invokeMethod(SocietyGeoService.class, "insertSocietyToGeo", s, BeanUtils.copy(societyGeoService));
					}
				}
			}
			dataMap.put("callbackType", "");
			dataMap.put("forwardUrl", "");
		}else{
			dataMap.put("statusCode", "300");
			dataMap.put("message", "修改失败");
		}
		return "jsonResult";
	}
	
	public String searchUI() throws Exception {		
		return "searchUI";
	}
	
	public Society getSociety() {
		return society;
	}

	public void setSociety(Society society) {
		this.society = society;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public SearchConditonOfSociety getSc() {
		return sc;
	}

	public void setSc(SearchConditonOfSociety sc) {
		this.sc = sc;
	}

	public int[] getIds() {
		return ids;
	}

	public void setIds(int[] ids) {
		this.ids = ids;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public int getSocietyId() {
		return societyId;
	}

	public void setSocietyId(int societyId) {
		this.societyId = societyId;
	}

	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}
	
	public String getTags() {
		return tags;
	}

	public void setTags(String tags) {
		this.tags = tags;
	}

}
