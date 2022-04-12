package com.spring.bank.service;

import java.util.ArrayList;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.spring.bank.dao.*;
import com.spring.bank.dto.*;

public class UserAuthenticationService implements UserDetailsService {
	
	@Autowired
	SqlSessionTemplate sqlSession;
	
	public UserAuthenticationService(SqlSessionTemplate sqlSession) {
		this.sqlSession = sqlSession;
	}
	
	@Override
	public UserDetails loadUserByUsername(String id) throws UsernameNotFoundException {
		System.out.println("<<<UserAuthenticationService - loadUserByUsername 진입 >>>");
		System.out.println("확인 loadUserByUsername1");
		CustomerDTO dto = sqlSession.selectOne("com.ch.spring.dao.CustomerDAO.selectCustomerId", id);
		System.out.println("확인 loadUserByUsername2");
		System.out.println("로그인 체크 ==>" + dto.getAuthority());
		if(dto == null) {
			throw new UsernameNotFoundException(id);
		}
		System.out.println("UserAuthenticationService  : "+dto.toString());
		
		List<GrantedAuthority> authority = new ArrayList<GrantedAuthority>();
		
		authority.add(new SimpleGrantedAuthority(dto.getAuthority()));  // default 'ROLE_USER'

		return new UserVO(dto.getGUEST_ID(), dto.getPwd(), dto.getEnabled().equals("1"),
				true, true, true, authority);
	}

}
