package com.orgz.utils;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import javax.xml.xpath.XPathExpressionException;

public class SMSUtils {
	public static String getVerifyCode(){
		String code = "";
		for(int i=0; i < 6; ++i){
			code += randInt();
		}
		return code;
	}
	
	private static int randInt() {
		Random rand = new Random();
		return rand.nextInt(10);
	}
	
	public static boolean send(String content, String phoneNumber ){
		boolean flag = false;
		String result = null;
		String sendContent = "您的验证码是"+content+",如非本人操作请忽略。【联码科技】";
		String uri = "http://sms.chanzor.com:8001/sms.aspx";
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("content", sendContent);
		params.put("mobile", phoneNumber);
		params.put("action", "send");
		params.put("account", "lianmakeji");
		params.put("password", "978986");
		result = HttpClientForSMS.executePostMethod(uri, params);
		System.out.println(result);
		if (result != null) {
			try {
				result = ParserXmlUtils.getString("returnstatus", result);
			} catch (XPathExpressionException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if(result != null){
			flag = result.compareToIgnoreCase("Success")==0;
		}
		return flag;
		
	}
	
	public static void main(String[] args) {
		System.out.println(getVerifyCode());
		System.out.println(send(getVerifyCode(), "15071147408"));
	}
}
