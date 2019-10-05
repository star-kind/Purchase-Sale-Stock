package com.allstargh.ssm.mechanism;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

/**
 * 不登录则拦截该请求,令其重定向
 * 
 * @author gzh
 *
 */
public class LoginMechanism implements HandlerInterceptor {

	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		// 检查session中是否有usrname，有则放行，无则拦截并重定向
		HttpSession session = request.getSession();
		if (session.getAttribute("username") == null) {
			response.sendRedirect("../account/login.do");
			return false;
		}
		return true;
	}

	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {

	}

	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {

	}

}