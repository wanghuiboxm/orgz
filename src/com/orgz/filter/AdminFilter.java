package com.orgz.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AdminFilter implements Filter {

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		Object admin = req.getSession().getAttribute("admin");
		String reqPath = req.getRequestURI();
		System.out.println("管理员过滤器");
		System.out.println(reqPath);
		if(admin == null && !reqPath.startsWith("/orgz/admin/admin_login")){
			String path = req.getContextPath();
			String basePath = req.getScheme()+"://"+req.getServerName()+":"+req.getServerPort()+path+"/";
			HttpServletResponse resp = (HttpServletResponse) response;
			resp.sendRedirect(basePath+"login.jsp");
//			chain.doFilter(req, resp);
		}else{
			chain.doFilter(req, response);
		}
	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub
		
	}


}
