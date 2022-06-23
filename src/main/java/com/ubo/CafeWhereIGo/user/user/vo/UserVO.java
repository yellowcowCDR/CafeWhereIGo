package com.ubo.CafeWhereIGo.user.user.vo;

import java.util.Date;

import org.springframework.stereotype.Component;

@Component("UserVO")
public class UserVO {
	private String user_id;
	private String user_pw;
	private String user_name;
	private String phonenum1;
	private String phonenum2;
	private String phonenum3;
	private String user_email; 
	private int mileage;
	private String user_role;
	private Date join_date;
	private String join_state;
	private Date quit_date;
	private String company_registration_number;
	private boolean sns_account;
	
	public UserVO() {
		
	}
	
	public UserVO(String user_id, String user_pw) {
		super();
		this.user_id = user_id;
		this.user_pw = user_pw;
	}
	
	public UserVO(String user_id, int mileage) {
		super();
		this.user_id = user_id;
		this.mileage = mileage;
	}

	public UserVO(String user_id, String user_pw, String user_name, String phonenum1, String phonenum2,
			String phonenum3, int mileage, String user_role, Date join_date, String join_state, Date quit_date,
			String company_registration_number) {
		super();
		this.user_id = user_id;
		this.user_pw = user_pw;
		this.user_name = user_name;
		this.phonenum1 = phonenum1;
		this.phonenum2 = phonenum2;
		this.phonenum3 = phonenum3;
		this.mileage = mileage;
		this.user_role = user_role;
		this.join_date = join_date;
		this.join_state = join_state;
		this.quit_date = quit_date;
		this.company_registration_number = company_registration_number;
	}
	
	

	public UserVO(String user_id, String user_pw, String user_name, String phonenum1, String phonenum2,
			String phonenum3, String user_email, String user_role, String join_state,
			String company_registration_number, boolean sns_account) {
		super();
		this.user_id = user_id;
		this.user_pw = user_pw;
		this.user_name = user_name;
		this.phonenum1 = phonenum1;
		this.phonenum2 = phonenum2;
		this.phonenum3 = phonenum3;
		this.user_email = user_email;
		this.user_role = user_role;
		this.join_state = join_state;
		this.company_registration_number = company_registration_number;
		this.sns_account = sns_account;
	}

	public UserVO(String user_id, String user_pw, String user_name, String phonenum1, String phonenum2,
			String phonenum3, String user_email, int mileage, String user_role, Date join_date, String join_state,
			Date quit_date, String company_registration_number, boolean sns_account) {
		super();
		this.user_id = user_id;
		this.user_pw = user_pw;
		this.user_name = user_name;
		this.phonenum1 = phonenum1;
		this.phonenum2 = phonenum2;
		this.phonenum3 = phonenum3;
		this.user_email = user_email;
		this.mileage = mileage;
		this.user_role = user_role;
		this.join_date = join_date;
		this.join_state = join_state;
		this.quit_date = quit_date;
		this.company_registration_number = company_registration_number;
		this.sns_account = sns_account;
	}

	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public String getUser_pw() {
		return user_pw;
	}
	public void setUser_pw(String user_pw) {
		this.user_pw = user_pw;
	}
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	public String getPhonenum1() {
		return phonenum1;
	}
	public void setPhonenum1(String phonenum1) {
		this.phonenum1 = phonenum1;
	}
	public String getPhonenum2() {
		return phonenum2;
	}
	public void setPhonenum2(String phonenum2) {
		this.phonenum2 = phonenum2;
	}
	public String getPhonenum3() {
		return phonenum3;
	}
	public void setPhonenum3(String phonenum3) {
		this.phonenum3 = phonenum3;
	}
	
	public String getUser_email() {
		return user_email;
	}

	public void setUser_email(String user_email) {
		this.user_email = user_email;
	}

	public int getMileage() {
		return mileage;
	}
	public void setMileage(int mileage) {
		this.mileage = mileage;
	}
	public String getUser_role() {
		return user_role;
	}
	public void setUser_role(String user_role) {
		this.user_role = user_role;
	}
	public Date getJoin_date() {
		return join_date;
	}
	public void setJoin_date(Date join_date) {
		this.join_date = join_date;
	}
	public String getJoin_state() {
		return join_state;
	}
	public void setJoin_state(String join_state) {
		this.join_state = join_state;
	}
	public Date getQuit_date() {
		return quit_date;
	}
	public void setQuit_date(Date quit_date) {
		this.quit_date = quit_date;
	}
	public String getCompany_registration_number() {
		return company_registration_number;
	}
	public void setCompany_registration_number(String company_registration_number) {
		this.company_registration_number = company_registration_number;
	}

	public boolean isSns_account() {
		return sns_account;
	}

	public void setSns_account(boolean sns_account) {
		this.sns_account = sns_account;
	}
	
}
