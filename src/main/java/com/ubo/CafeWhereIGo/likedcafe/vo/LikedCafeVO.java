package com.ubo.CafeWhereIGo.likedcafe.vo;

import java.sql.Date;

import org.springframework.stereotype.Component;

@Component
public class LikedCafeVO {
	int liked_cafe_id;
	String user_user_id;
	int cafe_cafe_id;
	Date created_date;
	
	public LikedCafeVO() {
		super();
	}


	public LikedCafeVO(String user_user_id, int cafe_cafe_id) {
		super();
		this.user_user_id = user_user_id;
		this.cafe_cafe_id = cafe_cafe_id;
	}


	public LikedCafeVO(int liked_cafe_id, String user_user_id, int cafe_cafe_id, Date created_date) {
		super();
		this.liked_cafe_id = liked_cafe_id;
		this.user_user_id = user_user_id;
		this.cafe_cafe_id = cafe_cafe_id;
		this.created_date = created_date;
	}


	public int getLiked_cafe_id() {
		return liked_cafe_id;
	}


	public void setLiked_cafe_id(int liked_cafe_id) {
		this.liked_cafe_id = liked_cafe_id;
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


	public Date getCreated_date() {
		return created_date;
	}


	public void setCreated_date(Date created_date) {
		this.created_date = created_date;
	}
	
	
}
