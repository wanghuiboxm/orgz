package com.orgz.action.interceptor;

import ognl.MethodFailedException;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

public class MyExceptionInterceptor extends AbstractInterceptor {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4628779958231191809L;

	@Override
	public String intercept(ActionInvocation ai) throws Exception {
		String result = null;
		try {
			result = ai.invoke();
		}catch (NoSuchMethodException e) {
			//如果路径错误
			e.printStackTrace();
			result = "pathError";
			return result;
		}catch (Exception e) {
			//如果action中发生异常
			e.printStackTrace();
			result = "systemError";
		}
		return result;
	}

}
