package com.ubo.CafeWhereIGo.cafe.goods.vo;

import java.sql.Date;

import org.springframework.stereotype.Component;

@Component
public class GoodsVO {
	private int goods_id;
	private String goods_name;
	private String description;
	private int price;
	private Date created_date;
	private int cafe_cafe_id;

	public GoodsVO() {
		super();
	}
	
	
	
	public GoodsVO(int goods_id, String goods_name, int price, String description) {
		super();
		this.goods_id = goods_id;
		this.goods_name = goods_name;
		this.price = price;
		this.description = description;
	}

	public GoodsVO(String goods_name, int price, String description, int cafe_cafe_id) {
		super();
		this.goods_name = goods_name;
		this.description = description;
		this.price = price;
		this.cafe_cafe_id = cafe_cafe_id;
	}



	public GoodsVO(int goods_id, String goods_name, String description, int price, Date created_date,
			int cafe_cafe_id) {
		super();
		this.goods_id = goods_id;
		this.goods_name = goods_name;
		this.description = description;
		this.price = price;
		this.created_date = created_date;
		this.cafe_cafe_id = cafe_cafe_id;
	}



	public int getGoods_id() {
		return goods_id;
	}



	public void setGoods_id(int goods_id) {
		this.goods_id = goods_id;
	}



	public String getGoods_name() {
		return goods_name;
	}



	public void setGoods_name(String goods_name) {
		this.goods_name = goods_name;
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
	
	
}
