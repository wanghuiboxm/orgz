package com.orgz.lbs.bean;

import java.util.List;

/**
 * 根据中文地址解析得到的结果
 * @author qiukuiman
 *
 */
public class GeoCoderResultBean {
	private Location location;
	private String formatted_address;
	private String business;
	private AddressComponent addressComponent;
	private List<PoiRegion> poiRegions;
	private String sematic_description;
	private String cityCode;

	public Location getLocation() {
		return location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}

	public String getFormatted_address() {
		return formatted_address;
	}

	public void setFormatted_address(String formatted_address) {
		this.formatted_address = formatted_address;
	}

	public String getBusiness() {
		return business;
	}

	public void setBusiness(String business) {
		this.business = business;
	}

	public AddressComponent getAddressComponent() {
		return addressComponent;
	}

	public void setAddressComponent(AddressComponent addressComponent) {
		this.addressComponent = addressComponent;
	}

	public List<PoiRegion> getPoiRegions() {
		return poiRegions;
	}

	public void setPoiRegions(List<PoiRegion> poiRegions) {
		this.poiRegions = poiRegions;
	}

	public String getSematic_description() {
		return sematic_description;
	}

	public void setSematic_description(String sematic_description) {
		this.sematic_description = sematic_description;
	}

	public String getCityCode() {
		return cityCode;
	}

	public void setCityCode(String cityCode) {
		this.cityCode = cityCode;
	}
}

/**
 * 地址编码后的周边区域信息
 * @author qiukuiman
 *
 */
class PoiRegion{
	private String direction_desc;
	private String name;
	public String getDirection_desc() {
		return direction_desc;
	}
	public void setDirection_desc(String direction_desc) {
		this.direction_desc = direction_desc;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}
