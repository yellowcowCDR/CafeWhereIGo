package com.ubo.CafeWhereIGo.orderAndReservation.vo;

import java.sql.Date;

import org.springframework.stereotype.Repository;

@Repository
public class OrderAndReservationVO {
	private int OrderAndReservation_id;
	private String user_user_id;
	private Date created_date;
	
	public OrderAndReservationVO() {
		super();
	}

	public OrderAndReservationVO(String user_user_id) {
		super();
		this.user_user_id = user_user_id;
	}

	public OrderAndReservationVO(int orderAndReservation_id, String user_user_id, Date created_date) {
		super();
		OrderAndReservation_id = orderAndReservation_id;
		this.user_user_id = user_user_id;
		this.created_date = created_date;
	}

	public int getOrderAndReservation_id() {
		return OrderAndReservation_id;
	}

	public void setOrderAndReservation_id(int orderAndReservation_id) {
		OrderAndReservation_id = orderAndReservation_id;
	}

	public String getUser_user_id() {
		return user_user_id;
	}

	public void setUser_user_id(String user_user_id) {
		this.user_user_id = user_user_id;
	}

	public Date getCreated_date() {
		return created_date;
	}

	public void setCreated_date(Date created_date) {
		this.created_date = created_date;
	}
}
