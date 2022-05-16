package com.ubo.CafeWhereIGo.userProfilePhoto.vo;

import org.springframework.stereotype.Component;

@Component("userProfilePhotoVO")
public class UserProfilePhotoVO {
	private String user_user_id;
	private String filename;
	
	public UserProfilePhotoVO() {
		super();
	}
	public UserProfilePhotoVO(String user_user_id, String filename) {
		super();
		this.user_user_id = user_user_id;
		this.filename = filename;
	}
	public String getUser_user_id() {
		return user_user_id;
	}
	public void setUser_user_id(String user_user_id) {
		this.user_user_id = user_user_id;
	}
	public String getFilename() {
		return filename;
	}
	public void setFilename(String filename) {
		this.filename = filename;
	}
	
	
}
