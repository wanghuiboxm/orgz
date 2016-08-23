package com.orgz.dao;

import org.junit.Test;

import com.orgz.lbs.bean.GeoCoderResultBean;
import com.orgz.lbs.bean.Location;
import com.orgz.lbs.dao.GeoCoderDao;

public class GeoCoderDaoTest {
	@Test
	public void testFuncton() throws Exception{
		GeoCoderDao geoCoderDao = new GeoCoderDao();
		Location location = geoCoderDao.addressToLocation("湖北省武汉市洪山区华中师范大学", null, "武汉市");
		System.out.println(location.getLat());
//		GeoCoderResultBean result = geoCoderDao.locationToAddress("114.36699631486", "30.523707614658");
//		System.out.println(result.getPoiRegions().size());
	}
}
