package com.orgz.utils;

import java.lang.reflect.Method;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.springframework.stereotype.Component;


import com.orgz.domain.Society;
import com.orgz.lbs.service.SocietyGeoService;

@Component
public class ThreadPoolUtils {
	final static ExecutorService eService = Executors.newFixedThreadPool(10);
	
	
	public void invokeMethod(Class<?> clazz, String methodName, Object params, Object instance) throws Exception{
		//通过反射获得method
		final Method method = clazz.getMethod(methodName, Object.class);
		final Object target = instance; 
		
		//在线程中调用方法
		MyThread task = new MyThread(method, target, params);
		eService.submit(task);
	}
//	public static void main(String[] args) throws Exception {
//		Society society = new Society();
//		society.setSocietyId(1);
//		society.setSocietyName("生活部");
//		society.setIntroduce("华中师范大学生活部");
//		society.setProperty(1);
//		society.setSchool("华中师范大学");
//		society.setStatus(1);
//		society.setProvince("湖北省");
//		society.setCity("武汉市");
//		society.setDistrict("洪山区");
//		society.setAddress("湖北省武汉市洪山区华中师范大学");
//		society.setSocietyIcon("image/society/1.jpg");
//		invokeMethod(SocietyGeoService.class, "insertSocietyToGeo",society);
//	}
}

class MyThread implements Runnable {
	private Method method;
	private Object target;
	private Object params;
	
	
	public MyThread(Method method, Object target, Object params) {
		super();
		this.method = method;
		this.target = target;
		this.params = params;
	}


	@Override
	public void run() {
		//调用真实需要调用的方法
		try {
			method.invoke(target, params);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
