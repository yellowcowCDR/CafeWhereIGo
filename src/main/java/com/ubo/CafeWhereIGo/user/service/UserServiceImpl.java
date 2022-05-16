package com.ubo.CafeWhereIGo.user.service;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ubo.CafeWhereIGo.user.dao.UserDAO;
import com.ubo.CafeWhereIGo.user.dao.UserDAOImpl;
import com.ubo.CafeWhereIGo.user.vo.UserVO;
import com.ubo.CafeWhereIGo.userProfilePhoto.dao.UserProfilePhotoDAO;
import com.ubo.CafeWhereIGo.userProfilePhoto.vo.UserProfilePhotoVO;

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

		Map<String, String> userProfilePhotoInfo = new HashMap<String, String>();
		userProfilePhotoInfo.put("user_id", user_id);
		userProfilePhotoInfo.put("filename", filename);
		userProfilePhotoDAO.upload(userProfilePhotoInfo);
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
		String filename = userProfilePhotoVO.getFilename();
		return filename;
	}
	
	
}
