package com.ubo.CafeWhereIGo.user.user.service;

import java.util.List;
import java.util.Map;

import com.ubo.CafeWhereIGo.user.user.vo.UserSearchParameterVO;
import com.ubo.CafeWhereIGo.user.user.vo.UserVO;

public interface UserService {
	public UserVO login(UserVO userInfo);
	public String getJoinState(String user_id);
	public List<Map> getUserList(UserSearchParameterVO userSearchParameter);
	public List<Map> getCafeManagerList(UserSearchParameterVO userSearchParameter);
	public String overlapped(String user_id);
	public void register(Map<String, String> UserInfo);
	public void update(Map<String,String> userInfoForm);
	public String getUserPassword(String user_id);
	public String getUserProfilePhoto(String user_id);

	public void banUser(String user_id);
	public void reRegisterUser(String user_id);
	
	
	//mileage 
	public int getMileage(String user_id);
	public void modifyMileage(UserVO userInfo);
}
