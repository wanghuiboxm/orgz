package com.orgz.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
/**
 * 编码过滤器，使用自己实现的request对象，来替换掉原来的request对象，这样就可以自定自己所需的编码
 * @author
 *
 */

public class EncodingFilter implements Filter {
	private String charset = "UTF-8";
	@Override
	public void destroy() {}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		System.out.println("过滤器");
		HttpServletRequest req = (HttpServletRequest) request;
//		if(req.getMethod().equalsIgnoreCase("GET")) {
//			if(!(req instanceof GetRequest)) {
//				req = new GetRequest(req, charset);//将原有的request对象变成自己的request对象，处理get请求编码
//			}
//		} else {
			req.setCharacterEncoding(charset);//处理post请求编码
//		}
		chain.doFilter(req, response);
	}

	@Override
	public void init(FilterConfig fConfig) throws ServletException {
		String charset = fConfig.getInitParameter("charset");
		if(charset != null && !charset.isEmpty()) {
			this.charset = charset;
		}
	}
}
