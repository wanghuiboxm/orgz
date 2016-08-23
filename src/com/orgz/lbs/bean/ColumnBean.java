package com.orgz.lbs.bean;

import com.orgz.lbs.constant.LbsConstant;

public class ColumnBean {
	private String id;  //列的id
	private String name; //column中文名称，必选
	private String key; //column存储的属性key，必选
	private String type; //1 int 2 double 3 string 4 在线图片url 必选
	private String max_length; //必选 最大值2048，对string有效
	private String default_value; //设置默认值
	private String is_sortfilter_field; //必选 1是 0否 只对int或double有效
	private String is_search_field;  //必选 只对string可以设置
	private String is_index_field; //必选 
	private String is_unique_field; //可选
	private String geotable_id; //必选
	private String ak = LbsConstant.AK;

	public ColumnBean(){
		
	}
	
	public ColumnBean(String id, String name,
			String max_length,
			String is_sortfilter_field, String is_search_field,
			String is_index_field, String is_unique_field, String geotable_id) {
		this.id = id;
		this.name = name;
		this.max_length = max_length;
		this.is_sortfilter_field = is_sortfilter_field;
		this.is_search_field = is_search_field;
		this.is_index_field = is_index_field;
		this.is_unique_field = is_unique_field;
		this.geotable_id = geotable_id;
	}
	

	public ColumnBean(String name, String key, String type, String max_length,
			String is_sortfilter_field, String is_search_field,
			String is_index_field, String is_unique_field, String geotable_id) {
		this.name = name;
		this.key = key;
		this.type = type;
		this.max_length = max_length;
		this.is_sortfilter_field = is_sortfilter_field;
		this.is_search_field = is_search_field;
		this.is_index_field = is_index_field;
		this.is_unique_field = is_unique_field;
		this.geotable_id = geotable_id;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getMax_length() {
		return max_length;
	}

	public void setMax_length(String max_length) {
		this.max_length = max_length;
	}

	public String getDefault_value() {
		return default_value;
	}

	public void setDefault_value(String default_value) {
		this.default_value = default_value;
	}

	public String getIs_sortfilter_field() {
		return is_sortfilter_field;
	}

	public void setIs_sortfilter_field(String is_sortfilter_field) {
		this.is_sortfilter_field = is_sortfilter_field;
	}

	public String getIs_search_field() {
		return is_search_field;
	}

	public void setIs_search_field(String is_search_field) {
		this.is_search_field = is_search_field;
	}

	public String getIs_index_field() {
		return is_index_field;
	}

	public void setIs_index_field(String is_index_field) {
		this.is_index_field = is_index_field;
	}

	public String getIs_unique_field() {
		return is_unique_field;
	}

	public void setIs_unique_field(String is_unique_field) {
		this.is_unique_field = is_unique_field;
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
	
}
