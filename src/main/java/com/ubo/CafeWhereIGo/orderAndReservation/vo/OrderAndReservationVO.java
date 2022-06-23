package com.ubo.CafeWhereIGo.orderAndReservation.vo;

import java.util.Date;

import org.springframework.stereotype.Repository;

@Repository
public class OrderAndReservationVO {
	private int OrderAndReservation_id;
	private String user_user_id;
	private Date created_date;
	private String order_status;
	
	public OrderAndReservationVO() {
		super();
	}

	public OrderAndReservationVO(String user_user_id, String order_status) {
		super();
		this.user_user_id = user_user_id;
		this.order_status = order_status;
	}
	
	public OrderAndReservationVO(int OrderAndReservation_id, String order_status) {
		super();
		this.OrderAndReservation_id = OrderAndReservation_id;
		this.order_status = order_status;
	}

	public OrderAndReservationVO(int orderAndReservation_id, String user_user_id, Date created_date, String order_status) {
		super();
		OrderAndReservation_id = orderAndReservation_id;
		this.user_user_id = user_user_id;
		this.created_date = created_date;
		this.order_status = order_status;
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

	public String getOrder_status() {
		return order_status;
	}

	public void setOrder_status(String order_status) {
		this.order_status = order_status;
	}
	
}
