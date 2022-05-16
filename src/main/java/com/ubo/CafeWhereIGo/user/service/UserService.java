package com.ubo.CafeWhereIGo.user.service;

import java.util.Map;

import com.ubo.CafeWhereIGo.user.vo.UserVO;

public interface UserService {
	public UserVO login(UserVO userInfo);
	public String overlapped(String user_id);
	public void register(Map<String, String> UserInfo);
	public String getUserPassword(String user_id);
	public String getUserProfilePhoto(String user_id);
}
