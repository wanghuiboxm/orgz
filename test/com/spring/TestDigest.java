package com.spring;

import org.apache.commons.codec.digest.DigestUtils;
import org.junit.Test;

public class TestDigest {
	
	@Test
	public void test() {
		String md5 = DigestUtils.md5Hex("123456");
		System.out.println(md5);
	}
}
