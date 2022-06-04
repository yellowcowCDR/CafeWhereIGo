package com.ubo.CafeWhereIGo.cafe.goodsphoto.vo;

import org.springframework.stereotype.Component;

@Component
public class GoodsPhotoVO {
	private int goods_goods_id;
	private String filename;
	
	public GoodsPhotoVO() {
		super();
	}

	public GoodsPhotoVO(int goods_goods_id, String filename) {
		super();
		this.goods_goods_id = goods_goods_id;
		this.filename = filename;
	}

	public int getGoods_goods_id() {
		return goods_goods_id;
	}

	public void setGoods_goods_id(int goods_goods_id) {
		this.goods_goods_id = goods_goods_id;
	}

	public String getFilename() {
		return filename;
	}

	public void setFilename(String filename) {
		this.filename = filename;
	}
}
