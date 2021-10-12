package com.mgr.netflix.client.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class ClientInterceptor extends HandlerInterceptorAdapter{
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		System.out.println("preHandle");
		HttpSession session = request.getSession(false);//세션이 없으면 만들지 않겠다는 뜻
		if(session!=null) {
			Object  authInfo = session.getAttribute("authInfo");
			if(authInfo!=null) {
				return true;
			}
		}
		response.sendRedirect(request.getContextPath()+"/clientLogin.do");
		return false;
	}
}