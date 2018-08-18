package com.aartek.pp.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.aartek.pp.model.User;

@Component
public class SessionInterceptor extends HandlerInterceptorAdapter {

	public boolean preHandle(HttpServletRequest req, HttpServletResponse res, Object obj) throws Exception {

		System.out.println("Session Interceptor : prehandler");
		User user = (User) req.getSession().getAttribute("User");
		if (user == null || user.equals("")) {
			res.sendRedirect("login.do");
			return false;
		}
		return true;
	}

	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, ModelAndView arg3)
			throws Exception {

		System.out.println("Session Interceptor : postHandler");
	}

	public void afterCompletion(HttpServletRequest req, HttpServletResponse res, Object arg2, Exception arg3)
			throws Exception {
		System.out.println("Session Interceptor : afterCompletion");
	}
}