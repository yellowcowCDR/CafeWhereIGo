package com.ubo.CafeWhereIGo.user.mileage.vo;

import java.sql.Date;

import org.springframework.stereotype.Component;

@Component
public class MileageHistoryVO {
	private int mileage_history_id;
	private int mileage_score;
	private Date accumalate_date;
	private String user_user_id;
	private int orderAndReservation_id;
	
	public MileageHistoryVO() {
		super();
	}

	public MileageHistoryVO(int mileage_score, String user_user_id, int orderAndReservation_id) {
		super();
		this.mileage_score = mileage_score;
		this.user_user_id = user_user_id;
		this.orderAndReservation_id = orderAndReservation_id;
	}

	public MileageHistoryVO(int mileage_history_id, int mileage_score, Date accumalate_date, String user_user_id, int orderAndReservation_id) {
		super();
		this.mileage_history_id = mileage_history_id;
		this.mileage_score = mileage_score;
		this.accumalate_date = accumalate_date;
		this.user_user_id = user_user_id;
		this.orderAndReservation_id = orderAndReservation_id;
	}

	public int getMileage_history_id() {
		return mileage_history_id;
	}

	public void setMileage_history_id(int mileage_history_id) {
		this.mileage_history_id = mileage_history_id;
	}

	public int getMileage_score() {
		return mileage_score;
	}

	public void setMileage_score(int mileage_score) {
		this.mileage_score = mileage_score;
	}

	public Date getAccumalate_date() {
		return accumalate_date;
	}

	public void setAccumalate_date(Date accumalate_date) {
		this.accumalate_date = accumalate_date;
	}

	public String getUser_user_id() {
		return user_user_id;
	}

	public void setUser_user_id(String user_user_id) {
		this.user_user_id = user_user_id;
	}

	public int getOrderAndReservation_id() {
		return orderAndReservation_id;
	}

	public void setOrderAndReservation_id(int orderAndReservation_id) {
		this.orderAndReservation_id = orderAndReservation_id;
	}
}
