package com.orgz.utils;

import java.io.IOException;
import java.util.Map;

import org.apache.commons.httpclient.HttpException;

import com.orgz.lbs.bean.ColumnBean;
import com.orgz.lbs.constant.LbsConstant;
/*
 * 说明：
 * 以下main方法中的1、2两段代码，每次只能打开其中一步的注释，先执行1，注释掉1然后执行2
 */
public class CreateGeoTable {
		
	public static void main(String[] args) throws Exception {
		
		//1.打开下面一行代码的注释，将执行后控制台打印出的字串对应的geotable_id保存到com.orgz.lbs.constant包下的LbsConstant.java文件中
//		createTable();  //在打开下面代码注释之前，请执行该行代码，在执行下面代码之前请注释掉改行代码
		
		
		
		
//		//2.在打开以下代码注释执行之前，请注释掉上一段代码，并将执行完后在控制台输出的内容中找出对应的字段id保存到com.orgz.lbs.constant包下的ColumnConstant.java文件中
//		createSocietyColumn();
//		createActivityColumn();
//		createUserColumn();
//		//查看lbs中表和字段
//		System.out.println(CreateGeotableUtils.searchColumn(LbsConstant.USER_GEOTABLE_ID, null, LbsConstant.AK));
//		System.out.println(CreateGeotableUtils.searchColumn(LbsConstant.SOCIETYT_GEOTABLE_ID, null, LbsConstant.AK));
//		System.out.println(CreateGeotableUtils.searchColumn(LbsConstant.ACTIVITY_GEOTABLE_ID, null, LbsConstant.AK));
		
	}
	
	
	private static void createTable() throws HttpException, IOException {
		//创建社团表
		CreateGeotableUtils.createGeotable("society_geotable", LbsConstant.GEO_TYPE, 1);
		CreateGeotableUtils.createGeotable("user_geotable", LbsConstant.GEO_TYPE, 1);
		CreateGeotableUtils.createGeotable("activity_geotable", LbsConstant.GEO_TYPE, 1);
		//得到创建表的id,将表的id保存到LbsConstant.java
		System.out.println(CreateGeotableUtils.searchGeotable(null).toString());
	}
	
	//创建社团下的字段
	private static void createSocietyColumn() throws HttpException, IOException, Exception {
		//定义社团下的字段
		ColumnBean societyId = new ColumnBean("society_id", "society_id", "1", "20", "1", "0", "1", "1", LbsConstant.SOCIETYT_GEOTABLE_ID);
		ColumnBean societyName = new ColumnBean("society_name", "society_name", "3", "100", "0", "1", "0", "0", LbsConstant.SOCIETYT_GEOTABLE_ID);
		ColumnBean societyProperty = new ColumnBean("property", "property", "1", "20", "1", "0", "0", "0", LbsConstant.SOCIETYT_GEOTABLE_ID);
		ColumnBean societyIntroduce = new ColumnBean("introduce", "introduce", "3", "200", "0", "1", "0", "0", LbsConstant.SOCIETYT_GEOTABLE_ID);
		ColumnBean societyActivityCount = new ColumnBean("activity_count", "activity_count", "1", "10", "1", "0", "0", "0", LbsConstant.SOCIETYT_GEOTABLE_ID);
		ColumnBean societyPeopleCount = new ColumnBean("people_count", "people_count", "1", "10", "1", "0", "0", "0", LbsConstant.SOCIETYT_GEOTABLE_ID);
		ColumnBean societyIcon = new ColumnBean("society_icon", "society_icon", "3", "200", "0", "0", "0", "0", LbsConstant.SOCIETYT_GEOTABLE_ID);
		//添加社团字段
		System.out.println(CreateGeotableUtils.addColumnToGeotable(BeanUtils.toMap(societyId)));
		System.out.println(CreateGeotableUtils.addColumnToGeotable(BeanUtils.toMap(societyName)));
		System.out.println(CreateGeotableUtils.addColumnToGeotable(BeanUtils.toMap(societyProperty)));
		System.out.println(CreateGeotableUtils.addColumnToGeotable(BeanUtils.toMap(societyIntroduce)));
		System.out.println(CreateGeotableUtils.addColumnToGeotable(BeanUtils.toMap(societyActivityCount)));
		System.out.println(CreateGeotableUtils.addColumnToGeotable(BeanUtils.toMap(societyPeopleCount)));
		System.out.println(CreateGeotableUtils.addColumnToGeotable(BeanUtils.toMap(societyIcon)));
	}
	
	private static void createActivityColumn() throws HttpException, IOException, Exception {
		//定义活动下的字段
		ColumnBean activityId = new ColumnBean("activity_id", "activity_id", "1", "20", "1", "0", "1", "1", LbsConstant.ACTIVITY_GEOTABLE_ID);
		ColumnBean activityTitle = new ColumnBean("activity_title", "activity_title", "3", "100", "0", "1", "0", "0", LbsConstant.ACTIVITY_GEOTABLE_ID);
		ColumnBean activityIcon = new ColumnBean("activity_icon", "activity_icon", "3", "200", "0", "0", "0", "0", LbsConstant.ACTIVITY_GEOTABLE_ID);
		ColumnBean activityStartTime = new ColumnBean("start_time", "start_time", "3", "40", "0", "1", "1", "0", LbsConstant.ACTIVITY_GEOTABLE_ID);
		ColumnBean activityEndTime = new ColumnBean("end_time", "end_time", "3", "40", "0", "1", "1", "0", LbsConstant.ACTIVITY_GEOTABLE_ID);
		//添加活动下的字段
		System.out.println(CreateGeotableUtils.addColumnToGeotable(BeanUtils.toMap(activityId)));
		System.out.println(CreateGeotableUtils.addColumnToGeotable(BeanUtils.toMap(activityTitle)));
		System.out.println(CreateGeotableUtils.addColumnToGeotable(BeanUtils.toMap(activityIcon)));
		System.out.println(CreateGeotableUtils.addColumnToGeotable(BeanUtils.toMap(activityStartTime)));
		System.out.println(CreateGeotableUtils.addColumnToGeotable(BeanUtils.toMap(activityEndTime)));
	}
	
	private static void createUserColumn() throws HttpException, IOException, Exception {
		//定义用户下的字段
		ColumnBean userId = new ColumnBean("user_id", "user_id", "1", "20", "1", "0", "1", "1", LbsConstant.USER_GEOTABLE_ID);
		ColumnBean userName = new ColumnBean("user_name", "user_name", "3", "20", "0", "1", "1", "0", LbsConstant.USER_GEOTABLE_ID);
		ColumnBean userIcon = new ColumnBean("user_icon", "user_icon", "3", "200", "0", "0", "0", "0", LbsConstant.USER_GEOTABLE_ID);
		//添加用户下的字段
		System.out.println(CreateGeotableUtils.addColumnToGeotable(BeanUtils.toMap(userId)));
		System.out.println(CreateGeotableUtils.addColumnToGeotable(BeanUtils.toMap(userName)));
		System.out.println(CreateGeotableUtils.addColumnToGeotable(BeanUtils.toMap(userIcon)));
	}
}
