package com.orgz.lbs.service;

import java.io.Serializable;
import java.text.SimpleDateFormat;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.orgz.domain.Activity;
import com.orgz.domain.Society;
import com.orgz.lbs.bean.ActivityGeoBean;
import com.orgz.lbs.bean.Location;
import com.orgz.lbs.bean.SocietyGeoBean;
import com.orgz.lbs.dao.ActivityGeoDao;
import com.orgz.lbs.dao.GeoCoderDao;

@Service
public class ActivityGeoService implements Serializable {

	private static final long serialVersionUID = 1L;
	@Resource
	ActivityGeoDao activityGeoDao;
	@Resource
	GeoCoderDao geoCoderDao;
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

	public int insertActivityToGeo(Object obj) throws Exception {
		Activity activity = (Activity) obj;
		// 地址编码，将社团地址转为经纬度
		Location location = geoCoderDao.addressToLocation(activity.getAddress(),activity.getDistrict(), activity.getCity());
		// 构造ActivityGeoBean对象
		if(location == null) {
			System.out.println("该地址错误");
			return 1;
		}
		ActivityGeoBean activityGeo = new ActivityGeoBean();
		// 设置经纬度
		activityGeo.setLatitude(location.getLat());
		activityGeo.setLongitude(location.getLng());
		// 设置poi名称
		activityGeo.setTitle(activity.getTitle());
		// 设置可选参数
		activityGeo.setAddress(activity.getCity() + activity.getDistrict()
				+ activity.getAddress());

		// 设置自定义参数
		activityGeo.setActivity_id(Integer.toString(activity.getActivityId()));
		activityGeo.setActivity_icon(activity.getActivityPhoto());
		activityGeo.setStart_time(sdf.format(activity.getStartTime()));
		activityGeo.setEnd_time((sdf.format(activity.getEndTime())));
		activityGeo.setActivity_title(activity.getTitle());

		// 执行操作
		int result = activityGeoDao.insert(activityGeo);
		int i = 3;
		// 如果是百度服务器内部错误，循环发送三次
		while (result == 1 && i > 0) {
			result = activityGeoDao.insert(activityGeo);
			--i;
		}

		return result;
	}
	
	/**
	 * 更新
	 * @param obj
	 * @return
	 * @throws Exception
	 */
	public int updateActivityGeo(Object obj) throws Exception {
		int result = -1;
		Activity activity = (Activity) obj;
		// 构造ActivityGeoBean对象
		ActivityGeoBean activityGeo = new ActivityGeoBean();
		// 设置自定列参数
		activityGeo.setActivity_id(Integer.toString(activity.getActivityId()));
		activityGeo.setActivity_icon(activity.getActivityPhoto());
		activityGeo.setStart_time(sdf.format(activity.getStartTime()));
		activityGeo.setEnd_time((sdf.format(activity.getEndTime())));
		activityGeo.setActivity_title(activity.getTitle());
		//执行操作
		result = activityGeoDao.update(activityGeo);
		//如果指定POI不存在，即报3003错误，则插入POI
		if(result == 3003){
			result = insertActivityToGeo(obj);
		}
		return result;
	}
	
	/**
	 * 根据活动id来删除
	 * @throws Exception 
	 * 
	 */
	public int deleteActivity(Object obj) throws Exception{
		int result = -1;
		Activity activity = (Activity) obj;
		// 构造ActivityGeoBean对象
		ActivityGeoBean activityGeo = new ActivityGeoBean();
		//根据activity_id来删除
		activityGeo.setActivity_id(Integer.toString(activity.getActivityId()));
		
		result = activityGeoDao.delete(activityGeo);
		int i = 3;
		// 如果是百度服务器内部错误，循环发送三次
		while (result == 1 && i > 0) {
			result = activityGeoDao.insert(activityGeo);
			--i;
		}
		return result;
	}
}
