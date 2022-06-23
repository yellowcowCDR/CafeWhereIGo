package com.ubo.CafeWhereIGo.user.user.dao;

import java.util.List;
import java.util.Map;

import com.ubo.CafeWhereIGo.user.user.vo.UserSearchParameterVO;
import com.ubo.CafeWhereIGo.user.user.vo.UserVO;

public interface UserDAO {
	//user info
	public UserVO login(UserVO userInfo);
	public String selectJoinState(String user_id);
	public List<Map> selectUserList(UserSearchParameterVO userSearchParameter);
	public List<Map> selectCafeManagerList(UserSearchParameterVO userSearchParameter);
	public void register(Map<String,String> userInfo) ;
	public void update(Map<String,String> userInfo) ;
	public String overlapped(String user_id);
	public String getUserPassword(String user_id);
	public List<UserVO> getUserList(String user_role);
	public List<UserVO> getUserList();
	
	public void updateUserStatus(Map<String,String> userMap);
	
	
	//mileage
	public int selectMileage(String user_id);
	public void updateMileage(UserVO userInfo);
}
