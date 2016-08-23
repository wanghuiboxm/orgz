package com.orgz.lbs.dao;

import java.io.Serializable;
import java.util.Map;

import net.sf.json.JSONObject;

import com.orgz.utils.BeanUtils;
import com.orgz.utils.HttpClientUtil;

public class BaseGeoDao implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 插入单个poi到geotable
	 * @param geoBean 要插入的poi数据
	 * @return 0代表成功  1代表服务器内部错误
	 * @throws Exception 
	 */
	public int insert(Object geoBean) throws Exception{
		int result = -1;
		String uri = "http://api.map.baidu.com/geodata/v3/poi/create";  //post请求
		Map<String, Object> params = BeanUtils.toMap(geoBean);
		JSONObject jsonObj = HttpClientUtil.executePostMethod(uri, params);
		result = jsonObj.getInt("status");
		System.out.println(jsonObj.toString());
		return result;
	}
	
	/**
	 * 更新单个poi数据到geotable
	 * @param geoBean
	 * @return 0代表成功 1代表服务器内部错误
	 * @throws Exception
	 */
	public int update(Object geoBean) throws Exception{
		int result = -1;
		String uri = "http://api.map.baidu.com/geodata/v3/poi/update"; //post请求
		Map<String, Object> params = BeanUtils.toMap(geoBean);
		JSONObject jsonObj = HttpClientUtil.executePostMethod(uri, params);
		if(jsonObj != null){
			System.out.println(jsonObj.toString());
			result = jsonObj.getInt("status");
		}
		return result;
	}
	
	/**
	 * 删除单个poi数据
	 * @param geoBean
	 * @return
	 * @throws Exception
	 */
	public int delete(Object geoBean) throws Exception{
		int result = -1;
		String uri = "http://api.map.baidu.com/geodata/v3/poi/delete";
		Map<String, Object> params = BeanUtils.toMap(geoBean);
		System.out.println(params.toString());
		JSONObject jsonObj = HttpClientUtil.executePostMethod(uri, params);
		if(jsonObj != null){
			System.out.println(jsonObj.toString());
			result = jsonObj.getInt("status");
		}
		return result;	
	}
}
