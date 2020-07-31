package com.hipporing.board.core.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

@Component
public class AuthInterceptor implements HandlerInterceptor {
	
	@Override //상속된걸 재구현 , overload:같은 함수명으로 다른 자료형 처리 
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		
		HttpSession session = request.getSession();
		String id = (String) session.getAttribute("id"); //형변환(null이 들어오면 안될때는 .tostring())
		
		if(id == null || id.isEmpty()) {
			response.sendRedirect("/login"); //서버의 응답을 담음
			return false;
		}
			
		return true; //False면 되돌려 보냄
	}
	
}
