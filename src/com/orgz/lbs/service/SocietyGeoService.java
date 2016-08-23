package com.orgz.lbs.service;

import java.io.Serializable;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.orgz.domain.Society;
import com.orgz.lbs.bean.Location;
import com.orgz.lbs.bean.SocietyGeoBean;
import com.orgz.lbs.dao.GeoCoderDao;
import com.orgz.lbs.dao.SocietyGeoDao;

@Service
public class SocietyGeoService implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Resource
	SocietyGeoDao societyGeoDao;
	@Resource
	GeoCoderDao geoCoderDao;
	
	public int insertSocietyToGeo(Object obj) throws Exception{
		Society society = (Society)obj;
		System.out.println(society.getAddress()+"***"+society.getCity());
		//地址编码，将社团地址转为经纬度
		Location location = geoCoderDao.addressToLocation(society.getAddress(),society.getDistrict(), society.getCity());
		//如果地址转换失败
		if(location == null) {
			System.out.println("该地址错误");
			return 1;
		}
		//构造societyGeoBean对象 
		SocietyGeoBean societyGeo = new SocietyGeoBean();
		//设置经纬度
		societyGeo.setLatitude(location.getLat());
		societyGeo.setLongitude(location.getLng());
		societyGeo.setTitle(society.getSocietyName());
		//设置一些可选参数
		societyGeo.setAddress(society.getCity()+society.getDistrict()+society.getAddress());
		societyGeo.setTags(society.getTags());
		
		//设置自定列参数
		societyGeo.setSociety_id(Integer.toString(society.getSocietyId()));
		societyGeo.setSociety_name(society.getSocietyName());
		societyGeo.setSociety_icon(society.getSocietyIcon());
		societyGeo.setProperty(Integer.toString(society.getProperty()));
		//创建是社团默认人数是1
		societyGeo.setPeople_count(Integer.toString(society.getPeopleCount()));
		societyGeo.setIntroduce(society.getIntroduce());
		societyGeo.setActivity_count(Integer.toString(society.getActivityCount()));
		
		//执行操作
		int result = societyGeoDao.insert(societyGeo);
		int i = 3;
		//如果是百度服务器内部错误，循环发送三次
		while(result == 1 && i > 0){
			result = societyGeoDao.insert(societyGeo);
			--i;
		}
		
		return result;
	}
	
	public int updateSocietyGeo(Object obj) throws Exception{
		Society society = (Society) obj;
		//构造societyGeoBean对象
		SocietyGeoBean societyGeo = new SocietyGeoBean();
		//设置自定列参数
		societyGeo.setSociety_id(Integer.toString(society.getSocietyId()));
		societyGeo.setSociety_name(society.getSocietyName());
		societyGeo.setSociety_icon(society.getSocietyIcon());
		societyGeo.setPeople_count(Integer.toString(society.getPeopleCount()));
		societyGeo.setIntroduce(society.getIntroduce());
		societyGeo.setActivity_count(Integer.toString(society.getActivityCount()));
		societyGeo.setProperty(Integer.toString(society.getProperty()));
		//执行操作
		int result = societyGeoDao.update(societyGeo);
		//如果指定POI不存在，即报3003错误，则插入POI
		if(result == 3003){
			result = insertSocietyToGeo(society);
		}
		return result;
	}
}
