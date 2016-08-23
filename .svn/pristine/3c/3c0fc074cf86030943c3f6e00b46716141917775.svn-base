package com.orgz.domain;

import java.io.Serializable;
import java.util.Date;

import org.apache.struts2.json.annotations.JSON;

import com.orgz.lbs.bean.Location;

public class User implements Serializable{
	private static final long serialVersionUID = 1L;
	private int userId;
	private String userName;
	private String email;
	private String phoneNumber; // 用户电话
	private String password; // 用户密码
	private String userIcon; // 用户图像路径
	private String userSign; // 用户签名
	private int sex; // 0代表女 1代表男 -1代表无性别
	private Date regtime; // 注册时间
	private Date latelyTime; // 最近登录时间
	private String verifycode; // 用于找回密码的验证码
	private Date postTime; // 找回密码验证码发送时间
	private String province;
	private String city;
	private String district;
	private String address; // 用户地址
	private int friendFlag;
	private Location location;

	@Override
	public String toString() {
		String result = userId + userName + phoneNumber + password + userIcon
				+ userSign + sex + regtime + latelyTime + address + verifycode
				+ postTime;
		return result;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	
	@JSON(serialize=false)
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUserSign() {
		return userSign;
	}

	public void setUserSign(String userSign) {
		this.userSign = userSign;
	}

	public int getSex() {
		return sex;
	}

	public void setSex(int sex) {
		this.sex = sex;
	}

	//返回json的格式
	@JSON(format="yyyy-MM-dd HH:mm:ss")
	public Date getRegtime() {
		return regtime;
	}

	public void setRegtime(Date regtime) {
		this.regtime = regtime;
	}
	
	@JSON(serialize=false)
	public Date getPostTime() {
		return postTime;
	}

	public void setPostTime(Date postTime) {
		this.postTime = postTime;
	}
	
	@JSON(format="yyyy-MM-dd HH:mm:ss")
	public Date getLatelyTime() {
		return latelyTime;
	}

	public void setLatelyTime(Date latelyTime) {
		this.latelyTime = latelyTime;
	}

	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public Location getLocation() {
		return location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}

	public void setUserIcon(String userIcon) {
		this.userIcon = userIcon;
	}

	public String getUserIcon() {
		return userIcon;
	}
	
	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	
	@JSON(serialize=false)
	public String getVerifycode() {
		return verifycode;
	}

	public void setVerifycode(String verifycode) {
		this.verifycode = verifycode;
	}

	public String getAddress() {
		return address;
	}

	public int getFriendFlag() {
		return friendFlag;
	}

	public void setFriendFlag(int friendFlag) {
		this.friendFlag = friendFlag;
	}


}
