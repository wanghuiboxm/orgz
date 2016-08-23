package com.orgz.utils;

import java.io.IOException;
import java.text.MessageFormat;
import java.util.Properties;

import javax.mail.MessagingException;
import javax.mail.Session;

import org.junit.Test;

public class MailUtilsDemo {
	@Test
	public void fun1() throws MessagingException, IOException {
		Properties prop = new Properties();
		prop.load(this.getClass().getClassLoader().getResourceAsStream("email_template.properties"));
		String host = prop.getProperty("host");//主机名
		String username = prop.getProperty("username");//邮箱名
		String password = prop.getProperty("password");//邮箱密码	
		System.out.println(username);
		/*
		 * 创建Mail对象
		 */
		String from = prop.getProperty("from");
		String to = "414726324@qq.com";
		String subject = prop.getProperty("subject");
		//String content = pro.getProperty("content");
		//补全占位符数据
		String content = MessageFormat.format(prop.getProperty("content"), "王会波");
		Mail mail = new Mail(from, to, subject, content);
		// 创建一个Mail类的对象，参数指定发件人和收件人
//		Mail mail = new Mail("itcast_cxf@163.com", "itcast_cxf@126.com");
//		mail.setSubject("还是测试邮件");//设置主题
//		mail.setContent("这是正文，不是垃圾邮件！");//设置正文
		
		// 创建Session对象，需要三个参数：主机名、用户名、密码
		// Session session = MailUtils.createSession("smtp.163.com",
		// "itcast_cxf", "itcast");
		// 发邮件，需要session和Mail对象
		Session session = MailUtils.createSession(host, username, password);
		MailUtils.send(session, mail);
	}
}
