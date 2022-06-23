package com.ubo.CafeWhereIGo.cafe.cafe.vo;

import java.sql.Date;

import org.springframework.stereotype.Component;

@Component
public class CafeSearchResultVO {
	private int cafe_id;
	private String cafe_name;
	private String cafe_location1;
	private String cafe_location2;
	private String user_user_id;
	private String phonenum1;
	private String phonenum2;
	private String phonenum3;
	private int number_of_seat;
	private Date created_date;
	private String business_state;
	private Date shutdown_date;
	private String open_time;
	private String close_time;
	private boolean parking_lot;
	private boolean power_plug;
	private boolean wifi;
	private double mood_score;
	private double coffee_score;
	private double drink_score;
	private double dessert_score;
	private double quiet_score;
	private double view_score;
	
	
	public CafeSearchResultVO() {
		super();
	}

	public CafeSearchResultVO(String cafe_name, String cafe_location1, String cafe_location2, String user_user_id,
			String phonenum1, String phonenum2, String phonenum3, int number_of_seat, String business_state,
			String open_time, String close_time, boolean parking_lot, boolean power_plug, boolean wifi, double mood_score,
			double coffee_score, double drink_score, double dessert_score, double quiet_score, double view_score) {
		super();
		this.cafe_name = cafe_name;
		this.cafe_location1 = cafe_location1;
		this.cafe_location2 = cafe_location2;
		this.user_user_id = user_user_id;
		this.phonenum1 = phonenum1;
		this.phonenum2 = phonenum2;
		this.phonenum3 = phonenum3;
		this.number_of_seat = number_of_seat;
		this.business_state = business_state;
		this.open_time = open_time;
		this.close_time = close_time;
		this.parking_lot = parking_lot;
		this.power_plug = power_plug;
		this.wifi = wifi;
		this.mood_score = mood_score;
		this.coffee_score = coffee_score;
		this.drink_score = drink_score;
		this.dessert_score = dessert_score;
		this.quiet_score = quiet_score;
		this.view_score = view_score;
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


	public String getUser_user_id() {
		return user_user_id;
	}


	public void setUser_user_id(String user_user_id) {
		this.user_user_id = user_user_id;
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


	public Date getCreated_date() {
		return created_date;
	}


	public void setCreated_date(Date created_date) {
		this.created_date = created_date;
	}


	public String getBusiness_state() {
		return business_state;
	}


	public void setBusiness_state(String business_state) {
		this.business_state = business_state;
	}


	public Date getShutdown_date() {
		return shutdown_date;
	}


	public void setShutdown_date(Date shutdown_date) {
		this.shutdown_date = shutdown_date;
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


	public boolean isParking_lot() {
		return parking_lot;
	}


	public void setParking_lot(boolean parking_lot) {
		this.parking_lot = parking_lot;
	}


	public boolean isPower_plug() {
		return power_plug;
	}


	public void setPower_plug(boolean power_plug) {
		this.power_plug = power_plug;
	}


	public boolean isWifi() {
		return wifi;
	}


	public void setWifi(boolean wifi) {
		this.wifi = wifi;
	}


	public double getMood_score() {
		return mood_score;
	}


	public void setMood_score(double mood_score) {
		this.mood_score = mood_score;
	}


	public double getCoffee_score() {
		return coffee_score;
	}


	public void setCoffee_score(double coffee_score) {
		this.coffee_score = coffee_score;
	}


	public double getDrink_score() {
		return drink_score;
	}


	public void setDrink_score(double drink_score) {
		this.drink_score = drink_score;
	}


	public double getDessert_score() {
		return dessert_score;
	}


	public void setDessert_score(double dessert_score) {
		this.dessert_score = dessert_score;
	}


	public double getQuiet_score() {
		return quiet_score;
	}


	public void setQuiet_score(double quiet_score) {
		this.quiet_score = quiet_score;
	}


	public double getView_score() {
		return view_score;
	}


	public void setView_score(double view_score) {
		this.view_score = view_score;
	}

	public int getNumber_of_seat() {
		return number_of_seat;
	}

	public void setNumber_of_seat(int number_of_seat) {
		this.number_of_seat = number_of_seat;
	}
	
}
