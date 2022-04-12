package com.spring.bank.service;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;

public class UserDeniedHandler implements AccessDeniedHandler {

	@Override
	public void handle(HttpServletRequest request, HttpServletResponse response,
			AccessDeniedException accessDeniedException) throws IOException, ServletException {

		System.out.println("<<< UserDeniedHandler - handle 진입 >>>");
		System.out.println("sessionId : " + request.getSession().getAttribute("customerID"));
		
		request.setAttribute("errMsg", "�?리자�? ?��근할 ?�� ?��?�� ?��?���??��?��?��.");
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/common/accessDenied.jsp");
		dispatcher.forward(request, response);
	}
	
}