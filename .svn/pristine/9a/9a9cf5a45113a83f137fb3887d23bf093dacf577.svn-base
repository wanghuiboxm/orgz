package com.spring;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.junit.Test;

import com.orgz.utils.ThreadPoolUtils;
import com.sun.jmx.snmp.tasks.ThreadService;

public class TestThread {

	public void test(Object s) {
		System.out.println("打印：" + s);
	}

	@Test
	public void t() {
		TestThread tt = new TestThread();
		try {
			ThreadPoolUtils threadPool = new ThreadPoolUtils(); 
			threadPool.invokeMethod(TestThread.class, "test", "就是我1", tt);
//			ThreadUtils.invokeMethod(TestThread.class, "test", "就是我2", tt);
//			ThreadUtils.invokeMethod(TestThread.class, "test", "就是我3", tt);
//			ThreadUtils.invokeMethod(TestThread.class, "test", "就是我4", tt);
//			ThreadUtils.invokeMethod(TestThread.class, "test", "就是我5", tt);
//			ThreadUtils.invokeMethod(TestThread.class, "test", "就是我6", tt);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// ExecutorService eService = Executors.newFixedThreadPool(10);
		// eService.submit(t1);
		// eService.submit(t2);
		// eService.submit(t3);
		// eService.submit(t4);
		// eService.submit(t5);
		// eService.submit(t6);
	}
}
