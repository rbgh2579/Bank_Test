package com.spring.bank.service;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;

// 로그인실패시 작동
public class UserLoginFailureHandler implements AuthenticationFailureHandler {

	@Autowired
	SqlSessionTemplate sqlSession;
	
	@Autowired
	BCryptPasswordEncoder passwordEncoder;   // 비밀번호 암호화( 복호화 )
	
	public UserLoginFailureHandler(SqlSessionTemplate sqlSession, BCryptPasswordEncoder passwordEncoder) {
		this.sqlSession = sqlSession;
		this.passwordEncoder = passwordEncoder;
	}
	
	@Override
	public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response,
			AuthenticationException exception) throws IOException, ServletException {

		System.out.println("<<< UserLoginFailureHandler - onAuthenticationFailure 진입 >>>");
		
		String strId = request.getParameter("id");
		System.out.println(strId);
		String strPwd = request.getParameter("password");
		System.out.println("확인1");
		// int cnt = sqlSession.getMapper(CustomerDAO.class).idCheck(strId);
//		if(cnt != 0) {
//			System.out.println("확인2");
//			String encryptPassword = null ;
//			try {
//				encryptPassword =	sqlSession.selectOne("com.ch.spring.dao.CustomerDAO.pwdCheck",strId);
//			}catch(Exception ex) {
//				encryptPassword = null;
//			}
//			System.out.println(" 암호화된 비밀번호 : " + encryptPassword);
//			System.out.println(" 입력받은 비밀번호 : " + strPwd);
//			// 일치확인- 비밀번호 일치할 경우
//			if(passwordEncoder.matches(strPwd, encryptPassword)) {
//				System.out.println("이메일 인증");
//				request.setAttribute("errorMsg", "인증메일이 발송되었습니다. 회원가입시 등록한 메일 확인 후 부탁드립니다.");
//			} else {
//				System.out.println("<<< 비밀번호 불일치 >>>");
//				request.setAttribute("errorMsg", "비밀번호가 일치하지 않습니다.!!");
//			}
//			
//		} else {
//			System.out.println("<< 아이디 불일치>>");
//			request.setAttribute("errorMsg", "아이디가 일치하지 않습니다");
//		}
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/customer/login/loginAction.jsp");
		dispatcher.forward(request, response);
		
	}

}