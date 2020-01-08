package com.magister.slim.model;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.magister.slim.util.JWTUtil;

import io.swagger.models.HttpMethod;

@Component
public class MagisterInterceptor implements HandlerInterceptor {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		if (request.getRequestURI().equals("/login") || request.getMethod().equalsIgnoreCase(HttpMethod.OPTIONS.toString())) {
			return true;
		}
		else if (isUserLogged(request) && JWTUtil.verifyToken(request.getHeader("Authorization").substring(7)) ) {
			return true;
		} else {
			return true;
		}
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {

	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler,
			Exception exception) throws Exception {
	}

	public static boolean isUserLogged(HttpServletRequest request) {

		return request.getHeader("Authorization") != null;

	}

}