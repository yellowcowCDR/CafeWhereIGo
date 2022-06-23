package com.ubo.CafeWhereIGo.cafe.cafePhoto.vo;

import org.springframework.stereotype.Component;

@Component
public class CafePhotoVO {
	private int photo_id;
	private String filename;
	private String photo_type;
	private int cafe_cafe_id;
	public CafePhotoVO() {
		super();
	}
	
	public CafePhotoVO(String filename, int cafe_cafe_id) {
		super();
		this.filename = filename;
		this.cafe_cafe_id = cafe_cafe_id;
	}
	
	public CafePhotoVO(String filename, String photo_type, int cafe_cafe_id) {
		super();
		this.filename = filename;
		this.photo_type = photo_type;
		this.cafe_cafe_id = cafe_cafe_id;
	}

	public CafePhotoVO(int photo_id, String filename, String photo_type, int cafe_cafe_id) {
		super();
		this.photo_id = photo_id;
		this.filename = filename;
		this.photo_type = photo_type;
		this.cafe_cafe_id = cafe_cafe_id;
	}

	public int getPhoto_id() {
		return photo_id;
	}

	public void setPhoto_id(int photo_id) {
		this.photo_id = photo_id;
	}

	public String getFilename() {
		return filename;
	}

	public void setFilename(String filename) {
		this.filename = filename;
	}

	public String getPhoto_type() {
		return photo_type;
	}

	public void setPhoto_type(String photo_type) {
		this.photo_type = photo_type;
	}

	public int getCafe_cafe_id() {
		return cafe_cafe_id;
	}

	public void setCafe_cafe_id(int cafe_cafe_id) {
		this.cafe_cafe_id = cafe_cafe_id;
	}
	
	
}
