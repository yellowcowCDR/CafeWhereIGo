package com.ubo.CafeWhereIGo.orderAndReservation.goodsOrder.vo;

import java.sql.Date;

import org.springframework.stereotype.Component;

@Component
public class GoodsOrderVO {
	private int order_id;
	private int goods_goods_id;
	private String goods_name;
	private int goods_price;
	private String[] goods_description;
	private int order_quantity;
	private boolean is_takeout;
	private Date order_date;
	private String order_state;
	private String user_user_id;
	private int cafe_cafe_id;
	private int OrderAndReservation_OrderAndReservation_id;
	
	
	public GoodsOrderVO() {
		super();
	}
	
	public GoodsOrderVO(int goods_goods_id, String goods_name, int goods_price, String[] goods_description,
			int order_quantity, boolean is_takeout, String order_state, String user_user_id, int cafe_cafe_id) {
		super();
		this.goods_goods_id = goods_goods_id;
		this.goods_name = goods_name;
		this.goods_price = goods_price;
		this.goods_description = goods_description;
		this.order_quantity = order_quantity;
		this.is_takeout = is_takeout;
		this.order_state = order_state;
		this.user_user_id = user_user_id;
		this.cafe_cafe_id = cafe_cafe_id;
	}
	
	public GoodsOrderVO(int order_id, int goods_goods_id, String goods_name, int goods_price,
			String[] goods_description, int order_quantity, boolean is_takeout, Date order_date, String order_state,
			String user_user_id, int cafe_cafe_id, int orderAndReservation_OrderAndReservation_id) {
		super();
		this.order_id = order_id;
		this.goods_goods_id = goods_goods_id;
		this.goods_name = goods_name;
		this.goods_price = goods_price;
		this.goods_description = goods_description;
		this.order_quantity = order_quantity;
		this.is_takeout = is_takeout;
		this.order_date = order_date;
		this.order_state = order_state;
		this.user_user_id = user_user_id;
		this.cafe_cafe_id = cafe_cafe_id;
		OrderAndReservation_OrderAndReservation_id = orderAndReservation_OrderAndReservation_id;
	}

	public int getOrder_id() {
		return order_id;
	}

	public void setOrder_id(int order_id) {
		this.order_id = order_id;
	}

	public int getOrder_quantity() {
		return order_quantity;
	}

	public void setOrder_quantity(int order_quantity) {
		this.order_quantity = order_quantity;
	}

	public Date getOrder_date() {
		return order_date;
	}

	public void setOrder_date(Date order_date) {
		this.order_date = order_date;
	}

	public String getOrder_state() {
		return order_state;
	}

	public void setOrder_state(String order_state) {
		this.order_state = order_state;
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

	public int getGoods_goods_id() {
		return goods_goods_id;
	}

	public void setGoods_goods_id(int goods_goods_id) {
		this.goods_goods_id = goods_goods_id;
	}

	public int getOrderAndReservation_OrderAndReservation_id() {
		return OrderAndReservation_OrderAndReservation_id;
	}

	public void setOrderAndReservation_OrderAndReservation_id(int orderAndReservation_OrderAndReservation_id) {
		OrderAndReservation_OrderAndReservation_id = orderAndReservation_OrderAndReservation_id;
	}

	public boolean is_takeout() {
		return is_takeout;
	}

	public void setIs_takeout(boolean is_takeout) {
		this.is_takeout = is_takeout;
	}





	public String getGoods_name() {
		return goods_name;
	}





	public void setGoods_name(String goods_name) {
		this.goods_name = goods_name;
	}





	public int getGoods_price() {
		return goods_price;
	}





	public void setGoods_price(int goods_price) {
		this.goods_price = goods_price;
	}





	public String[] getGoods_description() {
		return goods_description;
	}





	public void setGoods_description(String[] goods_description) {
		this.goods_description = goods_description;
	}





	public boolean isIs_takeout() {
		return is_takeout;
	}
	
	
}
