package com.ubo.CafeWhereIGo.userProfilePhoto.dao;

import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ubo.CafeWhereIGo.userProfilePhoto.vo.UserProfilePhotoVO;

@Repository
public class UserProfilePhotoDAOImpl implements UserProfilePhotoDAO{
	@Autowired
	SqlSession sqlSession;

	@Override
	public void upload(Map<String, String> userProfilePhotoInfo) {
		// TODO Auto-generated method stub
		UserProfilePhotoVO userProfilePhotoVO = convertMapToVO(userProfilePhotoInfo);
		sqlSession.insert("mapper.userProfilePhoto.upload", userProfilePhotoVO);
	}

	@Override
	public UserProfilePhotoVO download(String user_id) {
		// TODO Auto-generated method stub
		UserProfilePhotoVO userProfilePhotoVO =
				(UserProfilePhotoVO) sqlSession.selectOne("mapper.userProfilePhoto.download", user_id);
		return userProfilePhotoVO;
	}
	
	@Override
	public void update(UserProfilePhotoVO userProfilePhotoVO) {
		// TODO Auto-generated method stub
		sqlSession.update("mapper.userProfilePhoto.update", userProfilePhotoVO);
	}
	
	@Override
	public void delete(String user_id) {
		// TODO Auto-generated method stub
		sqlSession.delete("mapper.userProfilePhoto.delete", user_id);
	}

	private UserProfilePhotoVO convertMapToVO(Map<String, String> userInfo) {
		String user_user_id = userInfo.get("user_id");
		String filename = userInfo.get("filename");
		
		
		UserProfilePhotoVO userProfilePhotoVO = 
				new UserProfilePhotoVO(
						user_user_id, 
						filename
				);
		
		return userProfilePhotoVO;
	}
	
}
