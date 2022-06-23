package com.ubo.CafeWhereIGo.cafe.goodsphoto.vo;

import org.springframework.stereotype.Component;

@Component
public class GoodsPhotoInfoVO {
	int goods_id;
	String filename;
	String orgFilename;
	public GoodsPhotoInfoVO() {
		super();
	}
	public GoodsPhotoInfoVO(int goods_id, String filename, String orgFilename) {
		super();
		this.goods_id = goods_id;
		this.filename = filename;
		this.orgFilename = orgFilename;
	}
	public int getGoods_id() {
		return goods_id;
	}
	public void setGoods_id(int goods_id) {
		this.goods_id = goods_id;
	}
	public String getFilename() {
		return filename;
	}
	public void setFilename(String filename) {
		this.filename = filename;
	}
	public String getOrgFilename() {
		return orgFilename;
	}
	public void setOrgFilename(String orgFilename) {
		this.orgFilename = orgFilename;
	}
	
	
}
