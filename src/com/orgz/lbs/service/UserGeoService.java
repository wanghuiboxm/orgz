package com.orgz.lbs.service;

import java.io.Serializable;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.orgz.domain.User;
import com.orgz.lbs.bean.Location;
import com.orgz.lbs.bean.SocietyGeoBean;
import com.orgz.lbs.bean.UserGeoBean;
import com.orgz.lbs.dao.UserGeoDao;
@Component
public class UserGeoService implements Serializable {

	private static final long serialVersionUID = 1L;
	@Resource
	UserGeoDao userGeoDao;
	
	/**
	 * 插入或更新用户位置
	 * @param userGeo
	 * @return
	 * @throws Exception
	 */
	public int insertUserToGeo(Object obj) throws Exception{
		User user = (User) obj;
		UserGeoBean userGeo = new UserGeoBean();
		//设置经纬度与名称
		userGeo.setLatitude(user.getLocation().getLat());
		userGeo.setLongitude(user.getLocation().getLng());
		userGeo.setTitle(user.getUserName());
		//设置一些可选参数
		
		//设置自定义参数
		userGeo.setUser_id(Integer.toString(user.getUserId()));
		userGeo.setUser_name(user.getUserName());
		userGeo.setUser_icon(user.getUserIcon());
		//插入用户地理信息
		int result = userGeoDao.insert(userGeo);
		int i = 3;
		//如果是百度服务器内部错误，循环发送三次
		while(result == 1 && i > 0){
			result = userGeoDao.insert(userGeo);
			--i;
		}
		return result;
		
	}
	
	/**
	 * 更新用户的基本信息，不包含经纬度
	 * @param user
	 * @throws Exception 
	 */
	public int updateUserGeo(Object obj ) throws Exception{
		User user = (User) obj;
		int result = -1;
		UserGeoBean userGeo = new UserGeoBean();
		//使用用户名作为POI名称
		userGeo.setTitle(user.getUserName());
		//设置可选参数
		userGeo.setUser_id(Integer.toString(user.getUserId()));
		userGeo.setUser_name(user.getUserName());
		userGeo.setUser_icon(user.getUserIcon());
		
		result = userGeoDao.update(userGeo);
		//如果result=1表示服务器内部错误,重复操作3次
		int index = 3;
		while(result == 1 && index >0){
			result = userGeoDao.update(userGeo);
		}
		return result;
	}
	
	//更新用户经纬度
	public int updateUserLocation(Object obj) throws Exception {
		User user = (User) obj;
		int result = -1;
		UserGeoBean userGeo = new UserGeoBean();
		userGeo.setUser_id(Integer.toString(user.getUserId()));
		userGeo.setLatitude(user.getLocation().getLat());
		userGeo.setLongitude(user.getLocation().getLng());
		
		result = userGeoDao.update(userGeo);
		//如果result=1表示服务器内部错误，如果指定POI不存在，即报3003错误，则插入POI,重复操作3次
		int index = 3;
		while((result == 1 || result == 3003) && index >0){
			if(result == 3003){
				result = insertUserToGeo(user);
			}else{
				result = userGeoDao.update(userGeo);
			}
		}
		return result;
	}
	
	
}
