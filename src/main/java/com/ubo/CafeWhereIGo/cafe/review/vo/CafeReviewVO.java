package com.ubo.CafeWhereIGo.cafe.review.vo;

import java.sql.Date;

import org.springframework.stereotype.Component;

@Component
public class CafeReviewVO {
	private int review_id;
	private String review_content;
	private String[] review_content_list;
	private Date created_date;
	private int cafe_cafe_id;
	private String user_user_id;
	private int OrderAndReservation_OrderAndReservation_id;
	
	public CafeReviewVO() {
		super();
	}
	
	public CafeReviewVO(String user_user_id, String review_content, int cafe_cafe_id,
			int orderAndReservation_OrderAndReservation_id) {
		super();
		this.user_user_id = user_user_id;
		this.review_content = review_content;
		this.cafe_cafe_id = cafe_cafe_id;
		OrderAndReservation_OrderAndReservation_id = orderAndReservation_OrderAndReservation_id;
	}

	public int getReview_id() {
		return review_id;
	}
	public void setReview_id(int review_id) {
		this.review_id = review_id;
	}
	public String getReview_content() {
		return review_content;
	}
	public void setReview_content(String review_content) {
		this.review_content = review_content;
	}
	public Date getCreated_date() {
		return created_date;
	}
	public void setCreated_date(Date created_date) {
		this.created_date = created_date;
	}
	public int getCafe_cafe_id() {
		return cafe_cafe_id;
	}
	public void setCafe_cafe_id(int cafe_cafe_id) {
		this.cafe_cafe_id = cafe_cafe_id;
	}
	public String getUser_user_id() {
		return user_user_id;
	}
	public void setUser_user_id(String user_user_id) {
		this.user_user_id = user_user_id;
	}
	public int getOrderAndReservation_OrderAndReservation_id() {
		return OrderAndReservation_OrderAndReservation_id;
	}
	public void setOrderAndReservation_OrderAndReservation_id(int orderAndReservation_OrderAndReservation_id) {
		OrderAndReservation_OrderAndReservation_id = orderAndReservation_OrderAndReservation_id;
	}

	public String[] getReview_content_list() {
		return review_content_list;
	}

	public void setReview_content_list(String[] review_content_list) {
		this.review_content_list = review_content_list;
	}
	
	
}
