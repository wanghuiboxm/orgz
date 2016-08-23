package com.orgz.lbs.dao;

import java.io.Serializable;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

import net.sf.json.JSONObject;

import org.springframework.stereotype.Repository;

import com.orgz.lbs.bean.AddressComponent;
import com.orgz.lbs.bean.GeoCoderResultBean;
import com.orgz.lbs.bean.Location;
import com.orgz.lbs.constant.LbsConstant;
import com.orgz.utils.HttpClientUtil;

@Repository
public class GeoCoderDao implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Location addressToLocation(String address, String district,  String city) throws Exception {
		String uri = "http://api.map.baidu.com/geocoder/v2/";
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("output", "json");
		params.put("ak", LbsConstant.AK);
		// params.put("address", URLEncoder.encode(address,"UTF-8"));
		// params.put("city", URLEncoder.encode(city,"UTF-8"));
		params.put("address", city+district+address);
		params.put("city", city);
		JSONObject jsonObj = HttpClientUtil.executeGetMethod(uri, params);
		Location result = null;
		// 编码成功
		if (jsonObj.getInt("status") == 0) {
			result = (Location) JSONObject.toBean(jsonObj.getJSONObject("result").getJSONObject("location"),Location.class);
		}

		System.out.println(jsonObj.toString());
		return result;
	}

	/**
	 * @param longitude
	 *            经度
	 * @param latitude
	 *            纬度
	 */
	public GeoCoderResultBean locationToAddress(String longitude, String latitude) {
		String uri = "http://api.map.baidu.com/geocoder/v2/";
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("output", "json");
		params.put("ak", LbsConstant.AK);
		params.put("location", latitude + "," + longitude);
		JSONObject jsonObj = HttpClientUtil.executeGetMethod(uri, params);
		GeoCoderResultBean result = null;
		System.out.println(jsonObj.toString());
//		Map<String, Class> classMap = new HashMap<String, Class>();
//		classMap.put("location", Location.class);
//		classMap.put("addressComponent", AddressComponent.class);
		// 编码成功
		if (jsonObj.getInt("status") == 0) {
			//注意在使用tobean时，json对象中要转换的所有参数在bean都需要
			result = (GeoCoderResultBean) JSONObject.toBean(jsonObj.getJSONObject("result"), GeoCoderResultBean.class);
			
		}
		return result;
	}
}
