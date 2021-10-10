package com.majon.memo.common;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

@Component
public class PermissionInterceptor implements HandlerInterceptor{

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws IOException {
		
		HttpSession session = request.getSession();
		
		String uri = request.getRequestURI();
		
		// 비로그인
		if(session.getAttribute("userId")==null) {
			// 리스트화면, 디테일 화면, 글쓰기 화면
			// /post/** 접근 못하도록 -> 로그인 페이지로 이동
			if(uri.startsWith("/post")) {
				response.sendRedirect("/user/signin_view");
				return false;
			}
		} else {
			//로그인
			//로그인 화면, 회원가입
			// /user/** -> 리스트 페이지
			if(uri.startsWith("/user")) {
				response.sendRedirect("/post/list_view");
				return false;
			}
			
		}
		
		return true;
		
	}
	
	@Override
	public void postHandle(HttpServletRequest request
			,HttpServletResponse response
			,Object handler
			,ModelAndView modelAndView) {
		
	}
	
	@Override
	public void afterCompletion(HttpServletRequest request
			,HttpServletResponse response
			,Object handler
			,Exception ex) {
		
	}
	
}