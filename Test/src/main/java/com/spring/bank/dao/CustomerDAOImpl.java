package com.spring.bank.dao;

import java.util.Map;
import java.util.Properties;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.spring.bank.dto.CustomerDTO;
import com.spring.bank.util.SettingValues;


@Repository
public class CustomerDAOImpl implements CustomerDAO{
	
	@Autowired
	SqlSession SqlSession;
	
	@Override
	public int idCheck(String strId) {
		return SqlSession.getMapper(CustomerDAO.class).idCheck(strId);
	}

	@Override
	public int insertCustomer(CustomerDTO dto) {
		return SqlSession.getMapper(CustomerDAO.class).insertCustomer(dto);
	}

	@Override
	public int deleteCustomerDetail(String strId) {
		return SqlSession.getMapper(CustomerDAO.class).deleteCustomerDetail(strId);
	}

	@Override
	public CustomerDTO getCustomerDetail(String strId) {
		return SqlSession.getMapper(CustomerDAO.class).getCustomerDetail(strId);
	}

	@Override
	public int updateCustomerDetail(CustomerDTO dto) {
		return SqlSession.getMapper(CustomerDAO.class).updateCustomerDetail(dto);
	}

	@Override
	public String emailCheck(String code) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public int idPasswordChk(Map<String,String> map) {
		return SqlSession.getMapper(CustomerDAO.class).idPasswordChk(map);
	}
	// 시큐리티 아이디 확인

	@Override
	public CustomerDTO selectCustomerId(String id) {
		return SqlSession.getMapper(CustomerDAO.class).selectCustomerId(id);
	}

	public void sendEmail(String email, String key) {
		final String username = SettingValues.admin;      // 본인 이메일
	      final String password = SettingValues.pw;      // 본인 비밀번호
	      final String host = "smtp.gmail.com";
	      
	      // SMTP(메일 서버) 설정
	      
	      // 아래 import는 pom.xml에 mail API를 설정해야 가능
	      // import java.util.Properties;
	      Properties props = new Properties();         
	      props.put("mail.smtp.user", username);         // SMTP에서 사용할 메일 주소
	      props.put("mail.smtp.password", password);      // 비밀번호
	      props.put("mail.smtp.host", host);            // host 서버 : gmail로 설정
	      props.put("mail.smtp.port", "25");            // 25번 포트 사용
	      props.put("mail.debug", "true");            // 디버그 설정
	      props.put("mail.smtp.auth", "true");         // 인증 : true
	      props.put("mail.smtp.starttls.enable", "true");   // tls 사용 허용
	      props.put("mail.smtp.ssl.enable", "true");      // ssl 허용
	      props.put("mail.smtp.ssl.trust", host);         // ssl 신뢰 가능으로 설정(보안레벨)
	      
	      // propert값 설정
	      props.setProperty("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");   
	      props.setProperty("mail.smtp.socketFactory.fallback", "false");
	      props.setProperty("mail.smtp.port", "465");
	      props.setProperty("mail.smtp.socketFactory.port", "465");
	      
	      // import javax.mail.Session;
	      // import javax.mail.Authenticator
	      // import javax.mail.PasswordAuthentication
	      Session session = Session.getInstance(props, new Authenticator() {
	         protected PasswordAuthentication getPasswordAuthentication() {
	            return new PasswordAuthentication(username, password);
	         }
	      });
	      
	      // import javax.mail.Message
	      // import javax.mail.internet.MimeMessage;
	      // import javax.mail.internet.InternetAddress;
	      // import javax.mail.Transport
	      
	      // emailCheck.do를 컨트롤러에 작성해야함
	      
	      try {
	         Message message = new MimeMessage(session);
	         message.setFrom(new InternetAddress("choeung2@gmail.com"));
	         message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(email));
	        // 링크를 클릭해서 이메일 인증 성공 -> endabled 를 1로 업데이트 
	         String content ="회원가입을 축하드립니다. 링크를 눌러 회원가입을 완료하세요."
	                     + "<a href='http://localhost/spring/emailChk.do?key=" + key + "'>링크</a>";
	         message.setSubject("회원가입 인증 메일");
	         message.setContent(content, "text/html; charset=utf-8");
	         
	         System.out.println("send");
	         Transport.send(message);
	         System.out.println("SEND");
	      } catch(Exception e) {
	         e.printStackTrace();
	      }      
	}
	@Override
	public int selectKey(String key) {
		return SqlSession.getMapper(CustomerDAO.class).selectKey(key);
	}
	@Override
	public int updateGrade(String key) {
		return SqlSession.getMapper(CustomerDAO.class).updateGrade(key);
	}

	@Override
	public int zipcodechk(String zipcode) {
		// TODO Auto-generated method stub
		return 0;
	}
}
