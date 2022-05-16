package com.ubo.CafeWhereIGo.user.dao;

import java.util.Map;

import com.ubo.CafeWhereIGo.user.vo.UserVO;

public interface UserDAO {
	public UserVO login(UserVO userInfo);
	public void register(Map<String,String> userInfo) ;
	public String overlapped(String user_id);
	public String getUserPassword(String user_id);
}
