package com.orgz.action;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;
@Controller
public class ErrorJsonAction extends ActionSupport {

	/**
	 * 
	 */ 
	private static final long serialVersionUID = 1L;
	private Map<String, Object> dataMap = new HashMap<String, Object>();
	
	public String systemError() throws Exception {
		dataMap.put("status", 3);
		dataMap.put("message", "服务器内部异常");
		return Action.SUCCESS; 
	} 
	 
	public String pathError() throws Exception {
		dataMap.put("status", 5); 
		dataMap.put("message", "请求URL路径错误");
		return Action.SUCCESS; 
	} 
	
	public String fileError() throws Exception {
		dataMap.put("status", 6); 
		dataMap.put("message", "参数异常错误");
		return Action.SUCCESS;
	} 
	
	public String paramsError() throws Exception {
		dataMap.put("status", 7);
		dataMap.put("message", "参数异常");
		return Action.SUCCESS;
	}
	
	public Map<String, Object> getDataMap() {
		return dataMap;
	}

	public void setDataMap(Map<String, Object> dataMap) {
		this.dataMap = dataMap;
	}

}
