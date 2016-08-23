package com.orgz.lbs.bean;

import com.orgz.lbs.constant.LbsConstant;

public class ActivityGeoBean {
	private String title; // 必选
	private String address; // 可选
	private String tags; // 可选
	private String latitude; // 纬度
	private String longitude; // 经度
	private String coord_type = LbsConstant.COORD_TYPE; // 必选，坐标类型
	private String geotable_id = LbsConstant.ACTIVITY_GEOTABLE_ID; // 地理表
	private String ak = LbsConstant.AK;

	// 下面是自定义列
	private String activity_id; // 唯一索引列
	private String activity_icon;
	private String start_time;
	private String end_time;
	private String activity_title;
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
	public String getActivity_id() {
		return activity_id;
	}
	public void setActivity_id(String activity_id) {
		this.activity_id = activity_id;
	}
	public String getActivity_icon() {
		return activity_icon;
	}
	public void setActivity_icon(String activity_icon) {
		this.activity_icon = activity_icon;
	}
	public String getStart_time() {
		return start_time;
	}
	public void setStart_time(String start_time) {
		this.start_time = start_time;
	}
	public String getEnd_time() {
		return end_time;
	}
	public void setEnd_time(String end_time) {
		this.end_time = end_time;
	}
	public String getActivity_title() {
		return activity_title;
	}
	public void setActivity_title(String activity_title) {
		this.activity_title = activity_title;
	}

}
