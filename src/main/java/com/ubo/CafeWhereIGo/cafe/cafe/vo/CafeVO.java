package com.ubo.CafeWhereIGo.cafe.cafe.vo;

import java.util.Date;

import org.springframework.stereotype.Component;

@Component
public class CafeVO {
	private int cafe_id;
	private String cafe_name;
	private String cafe_location1;
	private String cafe_location2;
	private String phonenum1;
	private String phonenum2;
	private String phonenum3;
	private String open_time;
	private String close_time;
	private int number_of_seat;
	private String business_state;
	private Date created_date;
	private Date shutdown_date;
	private String user_user_id;
	
	public CafeVO() {
		super();
	}
	

	public CafeVO(String cafe_name, String cafe_location1, String cafe_location2, String phonenum1, String phonenum2,
			String phonenum3, String open_time, String close_time, int number_of_seat, String business_state,
			String user_user_id) {
		super();
		this.cafe_name = cafe_name;
		this.cafe_location1 = cafe_location1;
		this.cafe_location2 = cafe_location2;
		this.phonenum1 = phonenum1;
		this.phonenum2 = phonenum2;
		this.phonenum3 = phonenum3;
		this.open_time = open_time;
		this.close_time = close_time;
		this.number_of_seat = number_of_seat;
		this.business_state = business_state;
		this.user_user_id = user_user_id;
	}



	public CafeVO(int cafe_id, String cafe_name, String cafe_location1, String cafe_location2, String phonenum1,
			String phonenum2, String phonenum3, String open_time, String close_time, int number_of_seat,
			String business_state, Date created_date, Date shutdown_date, String user_user_id) {
		super();
		this.cafe_id = cafe_id;
		this.cafe_name = cafe_name;
		this.cafe_location1 = cafe_location1;
		this.cafe_location2 = cafe_location2;
		this.phonenum1 = phonenum1;
		this.phonenum2 = phonenum2;
		this.phonenum3 = phonenum3;
		this.open_time = open_time;
		this.close_time = close_time;
		this.number_of_seat = number_of_seat;
		this.business_state = business_state;
		this.created_date = created_date;
		this.shutdown_date = shutdown_date;
		this.user_user_id = user_user_id;
	}


	public int getCafe_id() {
		return cafe_id;
	}


	public void setCafe_id(int cafe_id) {
		this.cafe_id = cafe_id;
	}


	public String getCafe_name() {
		return cafe_name;
	}


	public void setCafe_name(String cafe_name) {
		this.cafe_name = cafe_name;
	}


	public String getCafe_location1() {
		return cafe_location1;
	}


	public void setCafe_location1(String cafe_location1) {
		this.cafe_location1 = cafe_location1;
	}


	public String getCafe_location2() {
		return cafe_location2;
	}


	public void setCafe_location2(String cafe_location2) {
		this.cafe_location2 = cafe_location2;
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


	public String getOpen_time() {
		return open_time;
	}


	public void setOpen_time(String open_time) {
		this.open_time = open_time;
	}


	public String getClose_time() {
		return close_time;
	}


	public void setClose_time(String close_time) {
		this.close_time = close_time;
	}


	public int getNumber_of_seat() {
		return number_of_seat;
	}


	public void setNumber_of_seat(int number_of_seat) {
		this.number_of_seat = number_of_seat;
	}


	public String getBusiness_state() {
		return business_state;
	}


	public void setBusiness_state(String business_state) {
		this.business_state = business_state;
	}


	public Date getCreated_date() {
		return created_date;
	}


	public void setCreated_date(Date created_date) {
		this.created_date = created_date;
	}


	public Date getShutdown_date() {
		return shutdown_date;
	}


	public void setShutdown_date(Date shutdown_date) {
		this.shutdown_date = shutdown_date;
	}


	public String getUser_user_id() {
		return user_user_id;
	}


	public void setUser_user_id(String user_user_id) {
		this.user_user_id = user_user_id;
	}
	
	
}
