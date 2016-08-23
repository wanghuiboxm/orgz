package com.orgz.utils;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

import net.sf.json.JSONObject;

import org.apache.commons.httpclient.HttpException;

import com.orgz.lbs.bean.ColumnBean;
import com.orgz.lbs.constant.ColumnConstant;
import com.orgz.lbs.constant.LbsConstant;

public class CreateGeotableUtils {

	/**
	 * 
	 * @param name
	 *            表名 必选
	 * @param geotype
	 *            持有数据的类型 必选 1代表点 现在只支持点
	 * @param is_published
	 *            是否发布到检索
	 * @return
	 * @throws HttpException
	 * @throws IOException
	 */
	public static JSONObject createGeotable(String name, int geotype,
			int is_published) throws HttpException, IOException {
		HashMap<String, Object> params = new HashMap<String, Object>();
		String uri = "http://api.map.baidu.com/geodata/v3/geotable/create"; // post请求
		params.put("name", name);
		params.put("geotype", geotype);
		params.put("is_published", is_published);
		params.put("ak", LbsConstant.AK);
		return HttpClientUtil.executePostMethod(uri, params);
	}

	/**
	 * @param name 表的名字，null代表查询所有表
	 * @return
	 */
	public static JSONObject searchGeotable(String name) {
		String uri = "http://api.map.baidu.com/geodata/v3/geotable/list"; // get请求
		HashMap<String, Object> params = new HashMap<String, Object>();
		params.put("ak", LbsConstant.AK);
		if(name != null){
			params.put("name", name);
		}
		return HttpClientUtil.executeGetMethod(uri, params);
	}
	
	public static JSONObject addColumnToGeotable(Map<String, Object> params) throws HttpException, IOException{
		String uri = "http://api.map.baidu.com/geodata/v3/column/create";
//		params.put("geotable_id", geotableId);
		return HttpClientUtil.executePostMethod(uri, params);
	}


	public static int updateColumn(Map<String, Object> params) throws Exception {
		String uri = "http://api.map.baidu.com/geodata/v3/column/update";
		JSONObject jsonObj = HttpClientUtil.executePostMethod(uri, params);
		int result = jsonObj.getInt("status");
		System.out.println(jsonObj.toString());
		return result;
	}

	/**
	 * @param key
	 * @param name
	 * @param length
	 *            列最大长度
	 * @param type
	 *            列的值类型 1代表 int64 2代表double 3代表string 4代表在图片url
	 * @param is_sortfilter
	 *            1代表是 0代表否 只有int与double类型可以设置
	 * @param is_search 只对string 检索文本信息
	 * @param is_index
	 * @param is_unique
	 * @return
	 */
	public static HashMap<String, Object> getBaseColumnParams( String key, String name, String length,String type, String is_sortfilter, String is_search, String is_index, String is_unique) {
		HashMap<String, Object> params = new HashMap<String, Object>();
		params.put("name", name); // column的属性中文名称
		params.put("key", key); // column存储的属性
		params.put("type", type); // 存储的值类型,1代表int
		params.put("max_length", length);
		params.put("is_sortfilter_field", is_sortfilter);
		params.put("is_search_field", is_search);
		params.put("is_index_field", is_index);
		params.put("is_unique_field", is_unique);
//		params.put("geotable_id", geotableId);
		params.put("ak", LbsConstant.AK);
		return params;
	}

	public static JSONObject searchColumn(String geotableId, String key, String ak) {
		String uri = "http://api.map.baidu.com/geodata/v3/column/list";
		Map<String, Object> params = new HashMap<String, Object>();
		if(key != null){
			params.put("key", key); // 可选
		}
		params.put("ak", ak);
		params.put("geotable_id", geotableId);
		return HttpClientUtil.executeGetMethod(uri, params);
	}

//	public static void main(String[] args) throws Exception, IOException {
		/*
		 * 修改列的属性 Map<String, Object> params = new HashMap<String, Object>();
		 * params.put("id", "118030"); params.put("max_length", "100");
		 * params.put("is_sortfilter_field", "1"); params.put("is_search_field",
		 * "0"); params.put("is_index_field", "1");
		 * params.put("is_unique_field", "1"); params.put("geotable_id",
		 * "99418"); params.put("ak", "PFGqsYpOFFCV3CIQ5eywVFGw");
		 * updateColumn(params);
		 */
//		ColumnBean column = new ColumnBean(ColumnConstant.SOCIETY_ID, "society_id", "64", "1", "0", "1", "1", LbsConstant.SOCIETYT_GEOTABLE_ID);
//		System.out.println(BeanUtils.toMap(column).toString());
//		System.out.println(updateColumn(BeanUtils.toMap(column)));
//		System.out.println(searchColumn(LbsConstant.SOCIETYT_GEOTABLE_ID, "society_id","PFGqsYpOFFCV3CIQ5eywVFGw"));
		//1.创建geotable
		
//	}
}
