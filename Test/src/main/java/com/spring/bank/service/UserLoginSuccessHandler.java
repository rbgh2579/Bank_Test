package com.spring.bank.service;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import com.spring.bank.dto.UserVO;



public class UserLoginSuccessHandler implements AuthenticationSuccessHandler {
	
	SqlSessionTemplate sqlSession;
	
	//security-context.xml에서 매개변수 생성자 sqlSession 생성후 그 주소 값을 매개변수로 전달
	public UserLoginSuccessHandler(SqlSessionTemplate sqlSession) {
		this.sqlSession = sqlSession;
	}
	
	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
			Authentication authentication) throws IOException, ServletException {
		System.out.println("<<< UserLoginSuccessHandler - onAuthenticationSuccess >>>");
		
		UserVO vo = (UserVO) authentication.getPrincipal();
		System.out.println("UserVO : " + vo.getUsername());
		
		String msg = authentication.getName() + "로그인을 축하합니다.";
		System.out.println("UserLoginSuccessHandler, msg 확인 : "+msg);
		String authority = sqlSession.selectOne("com.ch.spring.dao.CustomerDAO.authorityChk", authentication.getName());
		
		request.setAttribute("msg", msg);
		// session에 아이디 저장
		if(authentication.getName().equals("admin")) {
			System.out.println("loginSucess(admin) : "+authentication.getName());
			request.getSession().setAttribute("amdin_id", authentication.getName());
			request.getSession().setAttribute("customerId", authentication.getName());  // 
			request.getSession().setAttribute("authority", authority);
		}else {
			System.out.println("loginSucess(user) : "+authentication.getName());
			request.getSession().setAttribute("customerId", authentication.getName());  // 
			request.getSession().setAttribute("authority", authority);
		}
		int grade = 0;
		// 로그인한 사람이 유저인 경우
		if(authority.equals("ROLE_USER")) {
			grade = 1;
			RequestDispatcher dispatcher = request.getRequestDispatcher("/main.do");
			dispatcher.forward(request, response);
		// 로그인한 사람이 관리자인 경우
		} else {
			grade = 0;
			RequestDispatcher dispatcher = request.getRequestDispatcher("/productList.st");
			dispatcher.forward(request, response);
		}
		
	}

}
