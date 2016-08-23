package com.orgz.action;
import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.Action;
import com.orgz.base.BaseAction;
import com.orgz.condition.SearchConditionOfUser;
import com.orgz.domain.User;
import com.orgz.lbs.bean.Location;
import com.orgz.lbs.service.UserGeoService;
import com.orgz.utils.BeanUtils;
import com.orgz.utils.FileUploadUtils;
import com.orgz.utils.SMSUtils;
import com.orgz.utils.ValidateUtils;

@Controller
@Scope("prototype")
public class UserAction extends BaseAction {
	private static final long serialVersionUID = 1L;
	private User user;
	private int userId;
	private String longitude;
	private String latitude;
	private SearchConditionOfUser uc;
	private String oldPassword;
	private String newPassword;
	private String rnewPassword;
	private String phoneNumber;
	private String verifyCode;
	private String password;
	private String savePath = ServletActionContext.getServletContext().getRealPath("image/user");
	private String keyword;
	private int checkUserId;
	private String counter;
	
	public String login() throws Exception {
		  
//		if(user != null && user.getPassword() != null && (user.getEmail() != null || user.getPhoneNumber() != null)){
		if(counter != null && password != null) {
			User u = new User();
			u.setPassword(password);
			if(ValidateUtils.isEmail(counter)) {//验证邮箱登录
				u.setEmail(counter);
				user = userService.validateUserByEmail(u);
			}
			if(ValidateUtils.isPhoneNumber(counter)){//验证手机号登录
				u.setPhoneNumber(counter);
				user = userService.validateUserByPhoneNumber(u); 
			}
			if(user == null){
				dataMap.put("status", 1);
				dataMap.put("message", "账户或密码错误");
			}else{
				dataMap.put("status", 0);
				dataMap.put("message", "成功");
				dataMap.put("user", user);
				session.put("user", user);
				//更新最近登录时间 
				userService.updateLatelyTime(user);
				//向lbs云存储发送或更新用户位置 
				if(longitude!=null && latitude!=null){
					Location location = new Location();
					location.setLat(latitude);
					location.setLng(longitude);
					user.setLocation(location);
					threadPool.invokeMethod(UserGeoService.class, "updateUserLocation", user, BeanUtils.copy(userGeoService));
				}
			}
	
		}else {
			dataMap.put("status", 4);
			dataMap.put("message", "参数不正确");
		}
		
		return Action.SUCCESS;
	}
	
	public String registerByEmail() throws Exception{
		//验证email与密码是否为空
		if(user != null && user.getEmail() != null && user.getPassword() != null){
			//查看email是否已被注册
			User u = userService.findUserByEmail(user.getEmail());
			if(u != null){ 
				dataMap.put("status", 2);
				dataMap.put("message", "该邮箱已被注册");
				return Action.SUCCESS;
			}
			//注册用户
			user.setSex(-1);
			userService.registerUserWithEmail(user);
			dataMap.put("status", 0);
			dataMap.put("message", "成功");
		}else{
			dataMap.put("status", 4);
			dataMap.put("message", "参数错误");
		}

		return Action.SUCCESS;
	}
	
	public String registerByPhoneNumber() throws Exception{
//		String code = (String) session.get("verifyCode");
			//查看电话是否被注册
//		if(verifyCode != null &&verifyCode.equals(code) && phoneNumber != null && ValidateUtils.isPhoneNumber(phoneNumber) && password != null) {
		if(phoneNumber != null && ValidateUtils.isPhoneNumber(phoneNumber) && password != null) {
			User u = userService.findUserByPhoneNumber(phoneNumber);
			if(u != null) {
				dataMap.put("status", 2);
				dataMap.put("message", "该电话已被注册");
			}else {
				//电话注册
				user = new User();
				user.setPhoneNumber(phoneNumber);
				user.setPassword(password);
				//默认性别无
				user.setSex(-1);
				userService.registerUserWithPhoneNumber(user);
				dataMap.put("status", 0);
				dataMap.put("message", "成功");
			}
		}else {
			dataMap.put("status", 4);
			dataMap.put("message", "参数错误");
		}
		return Action.SUCCESS;
	}
	
	public String editPersonalInfo() throws Exception{
		//思路是根据用户传递过来的信息，查处用户的信息，根据修改后的信息，得到一个新的user，然后更新到User表中
		if(user != null && user.getUserId() > 0){
			//如果上传了图片
			if(upload != null && uploadFileName != null){
				String fileName = FileUploadUtils.getFileName(user.getUserId(), uploadFileName);
				FileUploadUtils.saveFile(upload, savePath+"/"+user.getUserId(), fileName);
				//将图片保存路径赋值给活动
				user.setUserIcon("image/user/"+user.getUserId()+"/"+fileName);
				
			}
			userService.updateUser(user);
			User u = userService.findUserById(user.getUserId());
			dataMap.put("status", 0);
			dataMap.put("message", "成功");
			dataMap.put("user", u);
			//如果修改了名字或者头像，则要更新到lbs
			if(user.getUserName() != null || user.getUserIcon() != null){	
				threadPool.invokeMethod(UserGeoService.class, "updateUserGeo", u, BeanUtils.copy(userGeoService));
			}
		}else {
			dataMap.put("status", 4);
			dataMap.put("message", "参数错误");
		}
		return Action.SUCCESS;
	}
	
	//上传用户位置
	public String sendLocation() throws Exception {
		
		if(userId >0 && longitude!=null && latitude!=null){
			user = userService.findUserById(userId);
			Location location = new Location();
			location.setLat(latitude);
			location.setLng(longitude);
			if(user != null){
				user.setLocation(location);
			}
			threadPool.invokeMethod(UserGeoService.class, "updateUserLocation", user, BeanUtils.copy(userGeoService));
			dataMap.put("status", 0);
			dataMap.put("message", "成功");
		}else {
			dataMap.put("status", 4);
			dataMap.put("message", "失败");
		}
		
		return Action.SUCCESS;
	}
	
	//修改密码
	public String editpwd() throws Exception {
		if(userId > 0 && oldPassword != null && newPassword != null && rnewPassword != null && newPassword.compareTo(rnewPassword)== 0 ){
			User user = new User();
			user.setUserId(userId);
			user.setPassword(oldPassword);
			//验证密码与用户一致性
			user = userService.validateUserById(user);
			if(user == null){
				dataMap.put("status", "1");
				dataMap.put("message", "操作失败");
			}else{
				user.setPassword(newPassword);
				userService.updateUser(user);
				dataMap.put("status", "0");
				dataMap.put("message", "成功");
			}
		}else{
			dataMap.put("status", "4");
			dataMap.put("message", "参数不正确");
		}
		return Action.SUCCESS;
	}
	
	//发送短信验证
	public String sendSMS() throws Exception {
		//接受参数phonenumber
		if(phoneNumber != null && ValidateUtils.isPhoneNumber(phoneNumber)){
			String code = SMSUtils.getVerifyCode();
//			System.out.println("verifyCode:" + code);
			String lastPhoneNumber = (String) session.get("phoneNumber");
			//同一个号码在发送验证码的间隔时间为60s
			long nowTime = System.currentTimeMillis();
			long lastSendTime = 0;
			if(session.containsKey("sendTime"))
				lastSendTime = (Long) session.get("sendTime");
			if(lastPhoneNumber != null && phoneNumber.equals(lastPhoneNumber) && (nowTime-lastSendTime) < 60000){
				dataMap.put("status", 1);
				dataMap.put("message", "发送间隔过短，请稍候再试");
			} else {
				
				user = userService.findUserByPhoneNumber(phoneNumber);
					
				//该手机号没被注册
				if(user == null) {
					boolean result = SMSUtils.send(code, phoneNumber); 
//					System.out.println("发送验证码");
					session.put("verifyCode", code);
					session.put("phoneNumber", phoneNumber);
					session.put("sendTime", System.currentTimeMillis());
					dataMap.put("status", 0);
					dataMap.put("message", "成功");
				} else {
					dataMap.put("status", "1");
					dataMap.put("message", "该帐号已被注册");
				}
			}
		}else {
			dataMap.put("status", 4);
			dataMap.put("message", "参数不正确");
		}
		return Action.SUCCESS;
	}
	
	//验证手机号与验证码
	public String validateVerifyCode() throws Exception {
		String sphoneNumber = (String) session.get("phoneNumber");
		String sverifyCode = (String) session.get("verifyCode");
		System.out.println(sphoneNumber +"***" + sverifyCode);
		System.out.println(phoneNumber + "***params" + verifyCode);
		if(sphoneNumber.equals(phoneNumber) && sverifyCode.equals(verifyCode)) {
			dataMap.put("status", 0);
			dataMap.put("message", "成功");
		}else {
			dataMap.put("status", 1);
			dataMap.put("message", "失败");
		}
		return Action.SUCCESS;
	} 
	
	//重置密码
	public String resetPwd() throws Exception {
		String lastPhoneNumber = (String) session.get("phoneNumber");
		String lastVerifyCode = (String) session.get("verifyCode");
		if(verifyCode != null && verifyCode.equals(lastVerifyCode) && phoneNumber != null && phoneNumber.equals(lastPhoneNumber) && newPassword != null  ) {
			user = userService.findUserByPhoneNumber(phoneNumber);
			if(user == null){
				dataMap.put("status", "1");
				dataMap.put("message", "该帐号不存在");
			}else{
				user.setPassword(newPassword);
				userService.updateUser(user);
				dataMap.put("status", "0");
				dataMap.put("message", "成功");
			}
		} else {
			dataMap.put("status", 4);
			dataMap.put("message", "参数不正确");
		}
		return Action.SUCCESS;
	}
	
	//接收一个手机号，判断是够注册，然后发送验证码
	public String findPwd() throws Exception {
		if(phoneNumber != null && ValidateUtils.isPhoneNumber(phoneNumber)) {
			String code = SMSUtils.getVerifyCode();
			String lastPhoneNumber = (String) session.get("phoneNumber");
			user = userService.findUserByPhoneNumber(phoneNumber);
			//判断该手机号是否注册过
			if(user == null){
				dataMap.put("status", "1");
				dataMap.put("message", "该帐号不存在");
			} else {
				//发送手机验证码
				long nowTime = System.currentTimeMillis();
				long lastSendTime = 0;
				if(session.containsKey("sendTime"))
					lastSendTime = (Long) session.get("sendTime");
				
				if(lastPhoneNumber != null && phoneNumber.equals(lastPhoneNumber) && (nowTime-lastSendTime) < 60000){
					dataMap.put("status", 1);
					dataMap.put("message", "发送间隔过短，请稍候再试");
				} else {
					boolean result = SMSUtils.send(code, phoneNumber); 
					session.put("verifyCode", code);
					session.put("phoneNumber", phoneNumber);
					session.put("sendTime", System.currentTimeMillis());
					dataMap.put("status", 0);
					dataMap.put("message", "成功");
				}
			}
		}else {
			dataMap.put("status", 4);
			dataMap.put("message", "参数不正确");
		}
		
		return Action.SUCCESS;
	}
	
	//检验验证码
	public String checkVerifyCode() throws Exception {
		String code = (String) session.get("verifyCode");
		if(verifyCode != null && code != null && code.compareTo(verifyCode) == 0) {
			dataMap.put("status", 0);
			dataMap.put("message", "成功");
		} else {
			dataMap.put("status", 1);
			dataMap.put("message", "失败");
		}
		return Action.SUCCESS;
	}
	
	//根据条件搜索用户
	public String search() throws Exception {
		//判断参数是否合法
		if(keyword != null && keyword.trim() != "" && userId > 0){
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
			//构造条件,不分性别查找
			uc = new SearchConditionOfUser(2, keyword);
			uc.setUserId(userId);
			System.out.println(pageNum + "***"+ numPerPage);
			System.out.println(uc.toString());
			//填充pageBean的参数
			pages = userService.getPageBean(uc, pageNum, numPerPage);
			dataMap.put("status", 0);
			dataMap.put("message", "成功");
			dataMap.put("result", pages);
		}else {
			dataMap.put("status", 4);
			dataMap.put("message", "参数不正确");
		}
		return Action.SUCCESS;
	}
	
	//展示用户详细信息
	public String showDetail() throws Exception {
		if(userId > 0 && checkUserId > 0){
			user = userService.findUserByIdWithCheck(userId, checkUserId);
			dataMap.put("status", 0);
			dataMap.put("message", "成功");
			dataMap.put("result", user);
		}else {
			dataMap.put("status", 4);
			dataMap.put("message", "参数错误");
		}
		return Action.SUCCESS;
	}
	
	public String uploadImage() throws Exception {
		if(upload != null) {
			String fileName = FileUploadUtils.getFileName(1, uploadFileName);
			System.out.println(phoneNumber);
			System.out.println(fileName);
			FileUploadUtils.saveFile(upload, savePath, fileName);
			dataMap.put("status", 0);
			dataMap.put("message", "成功");
		}else {
			System.out.println(phoneNumber);
		}
		return Action.SUCCESS;
	}
	
	//后台方法
	
	public String edit() throws Exception {
		if(user.getUserId() >= 0 && user.getUserName() != null){
			userService.updateUser(user);
			dataMap.put("statusCode", "200");
			dataMap.put("message", "操作成功");
		}else{
			dataMap.put("statusCode", "300");
			dataMap.put("message", "操作失败");
		}
		dataMap.put("navTabId", "userList");
		dataMap.put("rel", "userList");
		dataMap.put("callbackType", "closeCurrent");
		dataMap.put("forwardUrl", "");
		return "jsonResult";
	}
	
	public String editUI() throws Exception {
		//根据用户id查找用户
		if(request.getRequestURI().startsWith("/orgz/admin")){
			if(user != null && user.getUserId() > 0) {
				user = userService.findUserById(user.getUserId());
				System.out.println(user.toString());
			}
			return "editUI";
		}else{
			return "jsonResult";
		}
	}
	
	public String list() throws Exception {
		//判断参数是否合法
		if(pageNum < 1){
			//默认显示第一页
			pageNum = 1;
		}
		if(numPerPage < 1){
			//默认每页显示20条
			numPerPage = 20;
		}
		//构造条件，默认显示所有用户
		if(uc == null){
			uc = new SearchConditionOfUser(2, null);
		}
		System.out.println(pageNum + "***"+ numPerPage);
		System.out.println(uc.toString());
		//填充pageBean的参数
		pages = userService.getPageBean(uc, pageNum, numPerPage);
		return "list";
	}
	
	//展示用户详细信息
	public String detail() throws Exception {
		if(user != null && user.getUserId() >= 0){
			//查询用户信息
			int id = user.getUserId();
			user = userService.findUserById(id);
		}
		return "detail";
	}

	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public String getLongitude() {
		return longitude;
	}
	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}
	public String getLatitude() {
		return latitude;
	}
	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}

	public SearchConditionOfUser getUc() {
		return uc;
	}

	public void setUc(SearchConditionOfUser uc) {
		this.uc = uc;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getOldPassword() {
		return oldPassword;
	}

	public void setOldPassword(String oldPassword) {
		this.oldPassword = oldPassword;
	}

	public String getNewPassword() {
		return newPassword;
	}

	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
	}

	public String getRnewPassword() {
		return rnewPassword;
	}

	public void setRnewPassword(String rnewPassword) {
		this.rnewPassword = rnewPassword;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getVerifyCode() {
		return verifyCode;
	}

	public void setVerifyCode(String verifyCode) {
		this.verifyCode = verifyCode;
	}

	public int getCheckUserId() {
		return checkUserId;
	}

	public void setCheckUserId(int checkUserId) {
		this.checkUserId = checkUserId;
	}

	public String getCounter() {
		return counter;
	}

	public void setCounter(String counter) {
		this.counter = counter;
	}

}
