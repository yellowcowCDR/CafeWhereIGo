package com.ubo.CafeWhereIGo.cart.goodsCart.vo;

import java.sql.Date;

public class GoodsCartVO {
	private int cart_id;
	private int goods_id;
	private int quantity;
	private boolean is_Takeout;
	private Date cart_date;
	private String cart_state;
	private String user_user_id;
	private int cafe_cafe_id;
	
	public GoodsCartVO() {
		super();
	}	
	
	public GoodsCartVO(int goods_id, int quantity, boolean is_Takeout, String cart_state, String user_user_id,
			int cafe_cafe_id) {
		super();
		this.goods_id = goods_id;
		this.quantity = quantity;
		this.is_Takeout = is_Takeout;
		this.cart_state = cart_state;
		this.user_user_id = user_user_id;
		this.cafe_cafe_id = cafe_cafe_id;
	}

	

	public GoodsCartVO(int cart_id, int goods_id, int quantity, boolean is_Takeout, Date cart_date, String cart_state,
			String user_user_id, int cafe_cafe_id) {
		super();
		this.cart_id = cart_id;
		this.goods_id = goods_id;
		this.quantity = quantity;
		this.is_Takeout = is_Takeout;
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



	public int getQuantity() {
		return quantity;
	}



	public void setQuantity(int quantity) {
		this.quantity = quantity;
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

	public boolean is_Takeout() {
		return is_Takeout;
	}

	public void setIs_Takeout(boolean is_Takeout) {
		this.is_Takeout = is_Takeout;
	}
	
	
	
}
