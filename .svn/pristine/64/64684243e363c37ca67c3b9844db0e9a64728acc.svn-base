package com.orgz.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidateUtils {
	public static boolean isEmail(String email){
		String regex = "^([a-zA-Z0-9]*[-_]?[a-zA-Z0-9]+)*@([a-zA-Z0-9]*[-_]?[a-zA-Z0-9]+)+[\\.][A-Za-z]{2,3}([\\.][A-Za-z]{2})?$";
		return validate(regex, email);
	}
	
	public static boolean isPhoneNumber(String mobile) {
		String regex = "^((13[0-9])|(15[^4,\\D])|(18[0-9])|(17[0-9])|(14[0-9]))\\d{8}$";
		return validate(regex, mobile);
	}
	public static boolean validate(String regex, String content) {
		boolean result = false;
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher= pattern.matcher(content);
		result = matcher.matches();
		return result;
	}
	
//	public static void main(String[] args) {
//		System.out.println(isEmail("11@qq.com"));
//		System.out.println(isPhoneNumber("17971141408"));
//	}
}
