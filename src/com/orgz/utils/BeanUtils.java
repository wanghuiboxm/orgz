package com.orgz.utils;

import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

import com.orgz.lbs.bean.UserGeoBean;

public class BeanUtils {
	public static Object toBean(Class<?> type, Map<String,? extends Object> map) throws Exception{
		//得到bean的信息
		BeanInfo beanInfo = Introspector.getBeanInfo(type);
		//实例化bean对象
		Object obj = type.newInstance();
		PropertyDescriptor[] propertyDescriptor = beanInfo.getPropertyDescriptors();
		for(int i = 0; i < propertyDescriptor.length; ++i){
			PropertyDescriptor desciptor = propertyDescriptor[i];
			String propertyName = desciptor.getName();
			if(map.containsKey(propertyName)){
				Object value = map.get(propertyName);
				Object[] args = new Object[1];
				args[0] = value;
				desciptor.getWriteMethod().invoke(obj, args);
			}
		}
		return obj;
	}
	
	public static Map<String, Object> toMap(Object bean) throws Exception{
		Map<String, Object> map = new HashMap<String, Object>();
		BeanInfo beanInfo = Introspector.getBeanInfo(bean.getClass());  
        PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();  
        for (int i = 0; i< propertyDescriptors.length; i++) {  
            PropertyDescriptor descriptor = propertyDescriptors[i];  
            String propertyName = descriptor.getName();  
            if (!propertyName.equals("class")) {  
                Method readMethod = descriptor.getReadMethod();  
                Object result = readMethod.invoke(bean, new Object[0]);  
                //只有非空的值才转换
                if (result != null) {  
                    map.put(propertyName, result);  
                } //else {  
                  //  map.put(propertyName, "");  
                //}  
            }  
        }  
        return map;
	}
	
	//深度clone一个对象
	@SuppressWarnings("unchecked")
	public static  <T extends Serializable> T copy(T target){
		ByteArrayOutputStream baos = null;
		ObjectOutputStream oos = null;
		ByteArrayInputStream bais = null;
		ObjectInputStream ois = null;
		
		try {
			baos = new ByteArrayOutputStream();
			oos = new ObjectOutputStream(baos);
			oos.writeObject(target);
			oos.flush();
			byte[] bytes = baos.toByteArray();
			bais = new ByteArrayInputStream(bytes);
			ois = new ObjectInputStream(bais);
			Object result = ois.readObject();
			return (T) result;
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}finally {
			try {
				if(baos != null) {
					baos.close();
				}
				if(oos != null) {
					oos.close();
				}
				if(bais != null) {
					bais.close();
				}
				if(ois != null) {
					ois.close();
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return null;
	}
	
	//将一个电话号码转为一个用户名，隐藏电话中间四位数
	public static String phoneNumber2Name(String phoneNumber) {
		String start = phoneNumber.substring(0, 3);
		String end = phoneNumber.substring(7, 11);
		return start+"****"+end;
	}
	public static void main(String[] args) throws Exception {
//		Map<String,String> map = new HashMap<String, String>();
//		map.put("title", "nihao");
//		map.put("address", "hubei");
//		UserGeoBean userGeo = (UserGeoBean) toBean(UserGeoBean.class, map);
//		System.out.println(userGeo.getAddress()+"******"+userGeo.getTitle());
//		
//		Map map2 = toMap(userGeo);
//		System.out.println(map2.toString());
		System.out.println(phoneNumber2Name("15011112222"));
		
	}
}
