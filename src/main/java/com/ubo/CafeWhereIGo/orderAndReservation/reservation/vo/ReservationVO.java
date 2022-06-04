package com.ubo.CafeWhereIGo.orderAndReservation.reservation.vo;

import java.sql.Date;

import org.springframework.stereotype.Component;

@Component
public class ReservationVO  {
	private int reservation_id;
	private Date reservation_date;
	private String start_time;
	private String end_time;
	private Date reservation_add_date;
	private String reservation_state;
	private String user_user_id;
	private int cafe_cafe_id;
	private int OrderAndReservation_OrderAndReservation_id;
	private int Groupseat_groupseat_id;
	
	public ReservationVO() {
		super();
	}
	
	public ReservationVO(int groupseat_groupseat_id, Date reservation_date, String start_time, String end_time,
			String reservation_state, int cafe_cafe_id, String user_user_id) {
		super();
		Groupseat_groupseat_id = groupseat_groupseat_id;
		this.reservation_date = reservation_date;
		this.start_time = start_time;
		this.end_time = end_time;
		this.reservation_state = reservation_state;
		this.cafe_cafe_id = cafe_cafe_id;
		this.user_user_id = user_user_id;
	}

	public ReservationVO(Date reservation_date, String start_time, String end_time, Date reservation_add_date,
			String reservation_state, String user_user_id, int cafe_cafe_id,
			int orderAndReservation_OrderAndReservation_id, int groupseat_groupseat_id) {
		super();
		this.reservation_date = reservation_date;
		this.start_time = start_time;
		this.end_time = end_time;
		this.reservation_add_date = reservation_add_date;
		this.reservation_state = reservation_state;
		this.user_user_id = user_user_id;
		this.cafe_cafe_id = cafe_cafe_id;
		OrderAndReservation_OrderAndReservation_id = orderAndReservation_OrderAndReservation_id;
		Groupseat_groupseat_id = groupseat_groupseat_id;
	}



	public ReservationVO(int reservation_id, Date reservation_date, String start_time, String end_time,
			Date reservation_add_date, String reservation_state, String user_user_id, int cafe_cafe_id,
			int orderAndReservation_OrderAndReservation_id, int groupseat_groupseat_id) {
		super();
		this.reservation_id = reservation_id;
		this.reservation_date = reservation_date;
		this.start_time = start_time;
		this.end_time = end_time;
		this.reservation_add_date = reservation_add_date;
		this.reservation_state = reservation_state;
		this.user_user_id = user_user_id;
		this.cafe_cafe_id = cafe_cafe_id;
		OrderAndReservation_OrderAndReservation_id = orderAndReservation_OrderAndReservation_id;
		Groupseat_groupseat_id = groupseat_groupseat_id;
	}



	public int getReservation_id() {
		return reservation_id;
	}

	public void setReservation_id(int reservation_id) {
		this.reservation_id = reservation_id;
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

	public Date getReservation_add_date() {
		return reservation_add_date;
	}

	public void setReservation_add_date(Date reservation_add_date) {
		this.reservation_add_date = reservation_add_date;
	}

	public String getReservation_state() {
		return reservation_state;
	}

	public void setReservation_state(String reservation_state) {
		this.reservation_state = reservation_state;
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

	public int getOrderAndReservation_OrderAndReservation_id() {
		return OrderAndReservation_OrderAndReservation_id;
	}

	public void setOrderAndReservation_OrderAndReservation_id(int orderAndReservation_OrderAndReservation_id) {
		OrderAndReservation_OrderAndReservation_id = orderAndReservation_OrderAndReservation_id;
	}

	public int getGroupseat_groupseat_id() {
		return Groupseat_groupseat_id;
	}

	public void setGroupseat_groupseat_id(int groupseat_groupseat_id) {
		Groupseat_groupseat_id = groupseat_groupseat_id;
	}
}
