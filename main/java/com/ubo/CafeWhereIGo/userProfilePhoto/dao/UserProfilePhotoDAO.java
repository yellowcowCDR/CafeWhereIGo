package com.ubo.CafeWhereIGo.userProfilePhoto.dao;

import java.util.Map;

import com.ubo.CafeWhereIGo.userProfilePhoto.vo.UserProfilePhotoVO;

public interface UserProfilePhotoDAO {
	public void upload(Map<String, String> userProfilePhotoInfo);
	public UserProfilePhotoVO download(String user_id);
	public void update(UserProfilePhotoVO userProfilePhotoVO);
	public void delete(String user_id);
}
