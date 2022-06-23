package com.ubo.CafeWhereIGo.cafe.groupseat.vo;

import java.sql.Date;

import org.springframework.stereotype.Component;

@Component
public class GroupSeatVO {
	private int groupseat_id;
	private String seat_name;
	private String description;
	private int price;
	private int cafe_cafe_id;
	private Date created_date;
	
	public GroupSeatVO() {
		super();
	}
	public GroupSeatVO(String seat_name, String description, int price) {
		super();
		this.seat_name = seat_name;
		this.description = description;
		this.price = price;
	}
	
	public GroupSeatVO(String seat_name, int price, String description, int cafe_cafe_id) {
		super();
		this.seat_name = seat_name;
		this.description = description;
		this.price = price;
		this.cafe_cafe_id = cafe_cafe_id;
	}
	
	
	
	public GroupSeatVO(int groupseat_id, String seat_name, int price, String description) {
		super();
		this.groupseat_id = groupseat_id;
		this.seat_name = seat_name;
		this.price = price;
		this.description = description;
	}
	public GroupSeatVO(int groupseat_id, String seat_name, String description, int price, int cafe_cafe_id,
			Date created_date) {
		super();
		this.groupseat_id = groupseat_id;
		this.seat_name = seat_name;
		this.description = description;
		this.price = price;
		this.cafe_cafe_id = cafe_cafe_id;
		this.created_date = created_date;
	}
	public int getGroupseat_id() {
		return groupseat_id;
	}
	public void setGroupseat_id(int groupseat_id) {
		this.groupseat_id = groupseat_id;
	}
	public String getSeat_name() {
		return seat_name;
	}
	public void setSeat_name(String seat_name) {
		this.seat_name = seat_name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
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
