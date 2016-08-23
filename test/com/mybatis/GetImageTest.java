package com.mybatis;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.HttpMethod;
import org.junit.Test;

import com.orgz.utils.HttpClientUtil;

public class GetImageTest {

	@Test
	public void test(){
		HttpMethod method = HttpClientUtil.getGetMethod("http://localhost:8080/orgz/image/activity/20150403154837_12.jpg");
		HttpClient client = HttpClientUtil.getHttpClient();
		try {
			//执行get请求方法
			client.executeMethod(method);
			//得到请求返回的流
			InputStream is = method.getResponseBodyAsStream();
			//将流里的内容读到一副缓冲图里
			BufferedImage bm = ImageIO.read(is);
			System.out.println(bm.getHeight());
			//将缓冲图写到本地
			File file = new File("E:/image.jpg");
			ImageIO.write(bm, "jpg", file);
		} catch (HttpException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
