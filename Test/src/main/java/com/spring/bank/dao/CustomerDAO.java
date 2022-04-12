package com.spring.bank.dao;

import java.util.Map;

import com.spring.bank.dto.CustomerDTO;

public interface CustomerDAO {

		//以묐났�솗�씤 泥섎━
		public int idCheck(String strId);
		// �쉶�썝媛��엯泥섎━
		public int insertCustomer(CustomerDTO dto);
		// 濡쒓렇�씤 泥섎━
		public int idPasswordChk(Map<String,String> map);
		// �쉶�썝 �젙蹂� �씤利� 諛� �깉�눜
		public int deleteCustomerDetail(String strId);
		// �쉶�썝 �씤利� 諛� �긽�꽭 �럹�씠吏�
		public CustomerDTO getCustomerDetail(String strId);
		// �쉶�썝 �젙蹂� �닔�젙
		public int updateCustomerDetail(CustomerDTO dto);
		// �씠硫붿씪�씤利�
		public String emailCheck(String code);
		// �슦�렪踰덊샇 �엯�젰
		public int zipcodechk(String zipcode);
		
		// �떆�걧由ы떚 �븘�씠�뵒 寃��깋
		public CustomerDTO selectCustomerId(String id);
		
		// �씤利� 硫붿씪 諛쒖넚
		public void sendEmail(String email, String key);
		// �씤利� 硫붿씪 - �씤利앺궎 寃�利�
		public int selectKey(String key);
		// �씠硫붿씪 �씤利�- �벑湲� �뾽洹몃젅�씠�뱶
		public int updateGrade(String key);
		

}
