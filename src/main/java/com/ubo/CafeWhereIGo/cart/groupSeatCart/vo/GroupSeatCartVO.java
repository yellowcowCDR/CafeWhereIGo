package com.ubo.CafeWhereIGo.cart.groupSeatCart.vo;

import java.sql.Date;

import org.springframework.stereotype.Component;

@Component
public class GroupSeatCartVO {
	private int cart_id;
	private int groupSeat_id;
	private Date reservation_date;
	private String start_time;
	private String end_time;
	private Date cart_date;
	private String cart_state;
	private String user_user_id;
	private int cafe_cafe_id;
	
	
	
	public GroupSeatCartVO() {
		super();
	}



	public GroupSeatCartVO(int groupSeat_id, Date reservation_date, String start_time, String end_time, String cart_state,
			String user_user_id, int cafe_cafe_id) {
		super();
		this.groupSeat_id = groupSeat_id;
		this.reservation_date = reservation_date;
		this.start_time = start_time;
		this.end_time = end_time;
		this.cart_state = cart_state;
		this.user_user_id = user_user_id;
		this.cafe_cafe_id = cafe_cafe_id;
	}



	public GroupSeatCartVO(int cart_id, int groupSeat_id, Date reservation_date, String start_time, String end_time,
			Date cart_date, String cart_state, String user_user_id, int cafe_cafe_id) {
		super();
		this.cart_id = cart_id;
		this.groupSeat_id = groupSeat_id;
		this.reservation_date = reservation_date;
		this.start_time = start_time;
		this.end_time = end_time;
		this.cart_date = cart_date;
		this.cart_state = cart_state;
		this.user_user_id = user_user_id;
		this.cafe_cafe_id = cafe_cafe_id;
	}



	public int getCart_id() {
		return cart_id;
	}



	public void setCart_id(int cart_id) {
		this.cart_id = cart_id;
	}



	public int getGroupSeat_id() {
		return groupSeat_id;
	}



	public void setGroupSeat_id(int groupSeat_id) {
		this.groupSeat_id = groupSeat_id;
	}



	public Date getReservation_date() {
		return reservation_date;
	}



	public void setReservation_date(Date reservation_date) {
		this.reservation_date = reservation_date;
	}



	public String getStart_time() {
		return start_time;
	}



	public void setStart_time(String start_time) {
		this.start_time = start_time;
	}



	public String getEnd_time() {
		return end_time;
	}



	public void setEnd_time(String end_time) {
		this.end_time = end_time;
	}



	public Date getCart_date() {
		return cart_date;
	}



	public void setCart_date(Date cart_date) {
		this.cart_date = cart_date;
	}



	public String getCart_state() {
		return cart_state;
	}



	public void setCart_state(String cart_state) {
		this.cart_state = cart_state;
	}



	public String getUser_user_id() {
		return user_user_id;
	}



	public void setUser_user_id(String user_user_id) {
		this.user_user_id = user_user_id;
	}



	public int getCafe_cafe_id() {
		return cafe_cafe_id;
	}



	public void setCafe_cafe_id(int cafe_cafe_id) {
		this.cafe_cafe_id = cafe_cafe_id;
	}
	
	
}
