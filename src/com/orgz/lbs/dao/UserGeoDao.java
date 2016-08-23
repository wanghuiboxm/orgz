package com.orgz.lbs.dao;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Component;

import net.sf.json.JSONObject;

import com.orgz.lbs.bean.UserGeoBean;
import com.orgz.utils.BeanUtils;
import com.orgz.utils.HttpClientUtil;
@Component
public class UserGeoDao extends BaseGeoDao {
//	public int insertUserToGeo(UserGeoBean userGeo) throws Exception{
//		int result = -1;
//		String uri = "http://api.map.baidu.com/geodata/v3/poi/create";  //post请求
//		Map<String, Object> params = BeanUtils.toMap(userGeo);
//		JSONObject jsonObj = HttpClientUtil.executePostMethod(uri, params);
//		result = jsonObj.getInt("status");
//		System.out.println(jsonObj.toString());
//		return result;
//	}
//	public JSONObject searchGeotable(HashMap<String, String> ak){
//		return null;
//	}
//	public int updateUserGeo(UserGeoBean userGeo) throws Exception{
//		String uri = "http://api.map.baidu.com/geodata/v3/poi/update"; //post请求
//		Map<String, Object> params = BeanUtils.toMap(userGeo);
//		JSONObject jsonObj = HttpClientUtil.executePostMethod(uri, params);
//		System.out.println(jsonObj.toString());
//		int result = jsonObj.getInt("status");
//		return result;
//	}
}
