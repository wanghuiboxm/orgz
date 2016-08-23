package com.orgz.dao;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import org.junit.Test;

import com.orgz.lbs.bean.UserGeoBean;
import com.orgz.lbs.dao.UserGeoDao;
import com.orgz.utils.BeanUtils;

public class TestUserGeoDao {

	UserGeoDao userGeoDao = new UserGeoDao();
	
	@Test
	public void testInsertUserToGeo() throws Exception{
		UserGeoBean userGeo = new UserGeoBean();
		userGeo.setTags("大学2");
//		userGeo.setTitle("华中师范大学2");
		userGeo.setLatitude("30.524533");
		userGeo.setLongitude("114.36761");
		userGeo.setCoord_type("3");
		userGeo.setGeotable_id("99418");
		userGeo.setAddress("hubeishengwuhanshi");
		userGeo.setAk("PFGqsYpOFFCV3CIQ5eywVFGw");
		userGeo.setUser_id("2");
		userGeo.setUser_name("回到过去");
		System.out.println(BeanUtils.toMap(userGeo).toString());
		System.out.println(userGeoDao.insert(userGeo));
//		System.out.println(userGeoDao.updateUserGeo(userGeo));
	}
}
