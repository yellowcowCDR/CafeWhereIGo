package com.ubo.CafeWhereIGo.user.user.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ubo.CafeWhereIGo.user.user.dao.UserDAO;
import com.ubo.CafeWhereIGo.user.user.vo.UserSearchParameterVO;
import com.ubo.CafeWhereIGo.user.user.vo.UserVO;
import com.ubo.CafeWhereIGo.user.userProfilePhoto.dao.UserProfilePhotoDAO;
import com.ubo.CafeWhereIGo.user.userProfilePhoto.vo.UserProfilePhotoVO;

@Transactional
@Service("userService")
public class UserServiceImpl implements UserService {
	Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);
	
	@Autowired
	UserDAO userDAO;
	
	@Autowired
	UserProfilePhotoDAO userProfilePhotoDAO;
	
	@Override
	public UserVO login(UserVO loginInfo) {
		// TODO Auto-generated method stub
		UserVO userInfo;
		userInfo= (UserVO)userDAO.login(loginInfo);
		return userInfo;
	}
	
	
	
	@Override
	public String getJoinState(String user_id) {
		// TODO Auto-generated method stub
		String join_state = userDAO.selectJoinState(user_id);
		return join_state;
	}



	@Override
	public List<Map> getUserList(UserSearchParameterVO userSearchParameter) {
		// TODO Auto-generated method stub
		List<Map> userList = userDAO.selectUserList(userSearchParameter);
		return userList;
	}
	
	@Override
	public List<Map> getCafeManagerList(UserSearchParameterVO userSearchParameter) {
		// TODO Auto-generated method stub
		List<Map> cafeManagerList = userDAO.selectCafeManagerList(userSearchParameter);
		return cafeManagerList;
	}

	@Override
	public String overlapped(String user_id) {
		// TODO Auto-generated method stub
		String isUserOverlapped = (String) userDAO.overlapped(user_id);
		return isUserOverlapped;
	}

	@Override
	public void register(Map<String, String> userInfoForm) {
		// TODO Auto-generated method stub
		String user_id= userInfoForm.get("user_id");
		String filename = userInfoForm.get("filename");
		
		Map<String, String> userInfo = new HashMap<String,String>(userInfoForm);
		logger.debug("[@UserService] company_registration_number: " + userInfo.get("bussiness_number"));
		userInfo.remove("filename");
		userDAO.register(userInfo);
		
		if(filename!=null && !filename.equals("")){
			Map<String, String> userProfilePhotoInfo = new HashMap<String, String>();
			userProfilePhotoInfo.put("user_id", user_id);
			userProfilePhotoInfo.put("filename", filename);
			userProfilePhotoDAO.upload(userProfilePhotoInfo);
		}
	}
	@Override
	public void update(Map<String, String> userInfoForm) {
		// TODO Auto-generated method stub
		String user_id= userInfoForm.get("user_id");
		String filename = userInfoForm.get("filename");
		
		Map<String, String> userInfo = new HashMap<String,String>(userInfoForm);
		logger.debug("[@UserService] company_registration_number: " + userInfo.get("bussiness_number"));
		userInfo.remove("filename");
		userDAO.update(userInfo);
		
		if(filename!=null && !filename.equals("")){
			Map<String, String> userProfilePhotoInfo = new HashMap<String, String>();
			userProfilePhotoInfo.put("user_id", user_id);
			userProfilePhotoInfo.put("filename", filename);
			userProfilePhotoDAO.update(userProfilePhotoInfo);
		}
	}
	@Override
	public String getUserPassword(String user_id) {
		// TODO Auto-generated method stub
		String user_pw = userDAO.getUserPassword(user_id);
		return user_pw;
	}

	@Override
	public String getUserProfilePhoto(String user_id) {
		// TODO Auto-generated method stub
		UserProfilePhotoVO userProfilePhotoVO = userProfilePhotoDAO.download(user_id);
		String filename="";
		if(userProfilePhotoVO != null) {
			filename = userProfilePhotoVO.getFilename();
		}
		return filename;
	}

	
	
	@Override
	public void banUser(String user_id) {
		// TODO Auto-generated method stub
		String join_status="banned";
		Map<String,String> userMap = new HashMap<String,String>();
		userMap.put("user_id", user_id);
		userMap.put("join_state", join_status);
		
		userDAO.updateUserStatus(userMap);
	}

	@Override
	public void reRegisterUser(String user_id) {
		// TODO Auto-generated method stub
		String join_status="joined";
		Map<String,String> userMap = new HashMap<String,String>();
		userMap.put("user_id", user_id);
		userMap.put("join_state", join_status);
		
		userDAO.updateUserStatus(userMap);
	}

	@Override
	public int getMileage(String user_id) {
		// TODO Auto-generated method stub
		int mileage = userDAO.selectMileage(user_id);
		return mileage;
	}

	@Override
	public void modifyMileage(UserVO userInfo) {
		// TODO Auto-generated method stub
		userDAO.updateMileage(userInfo);
	}
	
	
}
