package com.orgz.service;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.orgz.domain.User;
import com.orgz.lbs.bean.Location;
import com.orgz.lbs.bean.UserGeoBean;
import com.orgz.lbs.constant.LbsConstant;
import com.orgz.lbs.service.UserGeoService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={ "classpath:applicationContext.xml"})
public class UserGeoServiceTest {
	@Resource
	public UserGeoService userGeoService;
	
	UserGeoBean userGeo = new UserGeoBean();
	
	@Test
	public void testInsertOrUpdate() throws Exception{
//		userGeo.setTags("大学2");
//		userGeo.setTitle("华中师范大学2");
//		userGeo.setLatitude("30.524533");
//		userGeo.setLongitude("114.36761");
//		userGeo.setCoord_type("3");
//		userGeo.setGeotable_id("99418");
//		userGeo.setAddress("hubeishengwuhanshi");
//		userGeo.setAk(LbsConstant.AK);
//		userGeo.setUser_id("2");
//		userGeo.setUser_name("回到过去2");
		User user = new User();
		user.setUserId(2);
		user.setUserName("回到过去");
		user.setUserIcon("image/user/20150105101010.jpg");
		Location location = new Location();
		location.setLat("30.524533");
		location.setLng("114.36761");
		user.setLocation(location);
		int result = userGeoService.updateUserLocation(user);
		System.out.println(result);
	}
}
