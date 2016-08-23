package com.orgz.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpConnectionManager;
import org.apache.commons.httpclient.HttpMethod;
import org.apache.commons.httpclient.MultiThreadedHttpConnectionManager;
import org.apache.commons.httpclient.NameValuePair;
import org.apache.commons.httpclient.cookie.CookiePolicy;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.params.HttpConnectionManagerParams;
import org.apache.commons.httpclient.params.HttpMethodParams;

public class HttpClientForSMS {
	private static HttpClient httpClient;
	private static HttpConnectionManager connectionManager;
	
	public static HttpClient getHttpClient(){
		//新建多线程的连接管理池
		connectionManager = new MultiThreadedHttpConnectionManager();
		//设置管理池的各种参数
		HttpConnectionManagerParams managerParams = connectionManager.getParams();
		managerParams.setStaleCheckingEnabled(true);
		managerParams.setMaxTotalConnections(20);
		managerParams.setDefaultMaxConnectionsPerHost(10);
		//设置连接的超时时间
		managerParams.setConnectionTimeout(10000);
		//这里表示一个连接的read()阻塞的时间,即读取数据的超时时间
		managerParams.setSoTimeout(5000);
		//用多线程的连接池来创建
		httpClient = new HttpClient(connectionManager);
		//设置字符编码
		httpClient.getParams().setContentCharset("UTF-8");
//		HttpState httpState = httpClient.getState();
		//设置cookie策略
		httpClient.getParams().setCookiePolicy(CookiePolicy.BROWSER_COMPATIBILITY);
		new MultiThreadedHttpConnectionManager();
		
		return httpClient;
	}
	
	//获得get请求方法
	public static HttpMethod getGetMethod(String uri){
		HttpMethod getMethod = new GetMethod(uri);
		getMethod.setRequestHeader("Content-Type", "text/html;charset=UTF-8");
		return getMethod;
		
	}
	
	//获得post请求方法
	public static PostMethod getPostMethod(String uri){
		PostMethod postMethod = new PostMethod(uri);
		postMethod.setParameter(HttpMethodParams.HTTP_CONTENT_CHARSET, "UTF-8");
		postMethod.setRequestHeader("Content-Type", "application/x-www-form-urlencoded;charset=UTF-8");
		return postMethod;
	}
	
	public static String executeGetMethod(String uri, Map<String, Object> params){
		HttpMethod method = getGetMethod(uri);
		String result = null;
		if(params != null){
			method.setQueryString(getNameValuePairs(params));
		}
		System.out.println(method.getQueryString());
		try {
			getHttpClient().executeMethod(method);
			result = getStringFromInputStream(method.getResponseBodyAsStream());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			method.releaseConnection();
		}
		return result;
	}
	
	public static String executePostMethod(String uri, Map<String, Object> params){
		PostMethod method = getPostMethod(uri);
		String result = null;
		if(params != null){
			method.setRequestBody(getNameValuePairs(params));
		}
		try {
			getHttpClient().executeMethod(method);
			result = getStringFromInputStream(method.getResponseBodyAsStream());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			result = null;
		}finally{
			method.releaseConnection();
		}
		return result;
	}
	public static NameValuePair[] getNameValuePairs(Map<String, Object> params){
		Iterator<Entry<String, Object>> iter = params.entrySet().iterator();
		NameValuePair[] nv = new NameValuePair[params.size()];
		int index = 0;
		while(iter.hasNext()){
			Map.Entry<String,Object> entry = iter.next();
			nv[index++] = new NameValuePair(entry.getKey(),(String)(entry.getValue()+""));
		}
		return nv;
	}
	public static String getStringFromInputStream(InputStream input) throws IOException{
		byte[] bytes = new byte[1024];
		StringBuilder sb = new StringBuilder();
		int length = 0;
		while((length = input.read(bytes)) != -1){
			sb.append(new String(bytes, 0, length, "UTF-8"));
		}
		return sb.toString();
	}
}
