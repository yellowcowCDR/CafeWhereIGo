package com.ubo.CafeWhereIGo.user.userProfilePhoto.dao;

import java.util.Map;

import com.ubo.CafeWhereIGo.user.userProfilePhoto.vo.UserProfilePhotoVO;

public interface UserProfilePhotoDAO {
	public void upload(Map<String, String> userProfilePhotoInfo);
	public UserProfilePhotoVO download(String user_id);
	public void update(Map<String, String> userProfilePhotoVO);
	public void delete(String user_id);
}
