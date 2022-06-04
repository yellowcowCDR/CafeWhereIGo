package com.ubo.CafeWhereIGo.cart.goodsCart.vo;

import java.sql.Date;

import org.springframework.stereotype.Component;

@Component
public class GoodsCartSearchResultVO {
	private int cart_id;
	private int goods_id;
	private String goods_name;
	private int price;
	private int quantity;
	private String description;
	private String[] descriptionList;
	private Date cart_date;
	private String cart_state;
	private String user_user_id;
	private int cafe_cafe_id;
	
	public GoodsCartSearchResultVO() {
		super();
	}
	public GoodsCartSearchResultVO(int cart_id, int goods_id, String goods_name, int price, int quantity,
			String description, String user_user_id, int cafe_cafe_id) {
		super();
		this.cart_id = cart_id;
		this.goods_id = goods_id;
		this.goods_name = goods_name;
		this.price = price;
		this.quantity = quantity;
		this.description = description;
		this.user_user_id = user_user_id;
		this.cafe_cafe_id = cafe_cafe_id;
	}



	public GoodsCartSearchResultVO(int cart_id, int goods_id, String goods_name, int price, int quantity,
			String description, String[] descriptionList, Date cart_date, String cart_state, String user_user_id,
			int cafe_cafe_id) {
		super();
		this.cart_id = cart_id;
		this.goods_id = goods_id;
		this.goods_name = goods_name;
		this.price = price;
		this.quantity = quantity;
		this.description = description;
		this.descriptionList = descriptionList;
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

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String[] getDecriptionList() {
		return descriptionList;
	}

	public void setDescriptionList(String[] descriptionList) {
		this.descriptionList = descriptionList;
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
