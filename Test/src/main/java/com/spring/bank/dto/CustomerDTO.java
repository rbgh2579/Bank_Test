package com.spring.bank.dto;

import java.sql.Date;
import java.sql.Timestamp;

public class CustomerDTO {
	
	public CustomerDTO() {
	}
	/*
	 * GUEST_CODE ZIPCODE GUEST_ID BIRTH GUEST_NAME PWD MOBLIE_PHONE_NUMBER
	 * PHONE_NUMBER EMAIL START_DATE address
	 * 
	 * 
	 */

	private String GUEST_CODE;
	private String GUEST_ID;
	private Date birth;
	private String GUEST_NAME;
	private String pwd;
	private String zipcode;
	private String hp;
	private String email;
	private Timestamp regDate;
	private String address;
	
	// 시큐리티 
	// 추가 - 시큐리티
    private String key;	// 이메일인증
    private String authority;  // 권한등급 : ROLE_USER:customer, ROLE_ADMIN:관리자
    private String enabled;  // 계정사용 가능여부(1:사용가능, 0:사용불가) : 이메일인증시 1로 update
	
	/*
	 GUEST_CODE	CHAR(4 BYTE)
	ZIPCODE	VARCHAR2(20 BYTE)
	GUEST_ID	VARCHAR2(20 BYTE)
	BIRTH	DATE
	GUEST_NAME	VARCHAR2(20 BYTE)
	PWD	VARCHAR2(20 BYTE)
	MOBLIE_PHONE_NUMBER	VARCHAR2(20 BYTE)
	PHONE_NUMBER	VARCHAR2(20 BYTE)
	EMAIL	VARCHAR2(40 BYTE)
	START_DATE	DATE
	ADDRESS	VARCHAR2(50 BYTE) 
	 */

	public String getGUEST_CODE() {
		return GUEST_CODE;
	}

	public void setGUEST_CODE(String gUEST_CODE) {
		GUEST_CODE = gUEST_CODE;
	}

	public String getGUEST_ID() {
		return GUEST_ID;
	}

	public void setGUEST_ID(String gUEST_ID) {
		GUEST_ID = gUEST_ID;
	}

	public Date getBirth() {
		return birth;
	}

	public void setBirth(Date birth) {
		this.birth = birth;
	}

	public String getGUEST_NAME() {
		return GUEST_NAME;
	}

	public void setGUEST_NAME(String gUEST_NAME) {
		GUEST_NAME = gUEST_NAME;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getZipcode() {
		return zipcode;
	}

	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}

	public String getHp() {
		return hp;
	}

	public void setHp(String hp) {
		this.hp = hp;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Timestamp getRegDate() {
		return regDate;
	}

	public void setRegDate(Timestamp regDate) {
		this.regDate = regDate;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public String getAuthority() {
		return authority;
	}

	public void setAuthority(String authority) {
		this.authority = authority;
	}

	public String getEnabled() {
		return enabled;
	}

	public void setEnabled(String enabled) {
		this.enabled = enabled;
	}

	@Override
	public String toString() {
		return "CustomerDTO [GUEST_CODE=" + GUEST_CODE + ", GUEST_ID=" + GUEST_ID + ", birth=" + birth + ", GUEST_NAME="
				+ GUEST_NAME + ", pwd=" + pwd + ", zipcode=" + zipcode + ", hp=" + hp + ", email=" + email
				+ ", regDate=" + regDate + ", address=" + address + ", key=" + key + ", authority=" + authority
				+ ", enabled=" + enabled + "]";
	}
}
