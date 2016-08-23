package com.orgz.lbs.bean;

import org.apache.ibatis.annotations.Param;

import com.orgz.lbs.constant.LbsConstant;

public class UserGeoBean {
	private String title; //可选
	private String address; //可选
	private String tags; //可选
	private String latitude; //纬度
	private String longitude; //经度
	private String coord_type = LbsConstant.COORD_TYPE; //必选，坐标类型
	private String geotable_id = LbsConstant.USER_GEOTABLE_ID; //地理表
	private String ak = LbsConstant.AK;

	//下面是自定义列
	private String user_id; //唯一索引列
	private String user_name;
	private String user_icon;
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getTags() {
		return tags;
	}
	public void setTags(String tags) {
		this.tags = tags;
	}
	public String getLatitude() {
		return latitude;
	}
	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}
	public String getLongitude() {
		return longitude;
	}
	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}
	public String getCoord_type() {
		return coord_type;
	}
	public void setCoord_type(String coord_type) {
		this.coord_type = coord_type;
	}
	public String getGeotable_id() {
		return geotable_id;
	}
	public void setGeotable_id(String geotable_id) {
		this.geotable_id = geotable_id;
	}
	public String getAk() {
		return ak;
	}
	public void setAk(String ak) {
		this.ak = ak;
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String string) {
		this.user_id = string;
	}
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	public String getUser_icon() {
		return user_icon;
	}
	public void setUser_icon(String user_icon) {
		this.user_icon = user_icon;
	}
	
}
