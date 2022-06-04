package com.ubo.CafeWhereIGo.cafe.cafePhoto.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ubo.CafeWhereIGo.cafe.cafePhoto.vo.CafePhotoVO;

@Repository
public class CafePhotoDAOImpl implements CafePhotoDAO{
	@Autowired
	SqlSession sqlSession;

	@Override
	public void insertCafePhoto(CafePhotoVO cafePhoto) {
		// TODO Auto-generated method stub
		sqlSession.insert("mapper.cafePhoto.insertCafePhoto", cafePhoto);
	}

	@Override
	public CafePhotoVO selectCafeMainPhoto(int cafe_id) {
		// TODO Auto-generated method stub
		CafePhotoVO cafePhoto = (CafePhotoVO) sqlSession.selectOne("mapper.cafePhoto.selectCafeMainPhoto", cafe_id);
		return cafePhoto;
	}

	@Override
	public List<CafePhotoVO> selectCafePhoto(int cafe_id) {
		// TODO Auto-generated method stub
		List<CafePhotoVO> cafePhotoList = sqlSession.selectList("mapper.cafePhoto.selectCafePhoto", cafe_id);
		return cafePhotoList;
	}

	@Override
	public void updateCafePhoto(CafePhotoVO cafePhoto) {
		// TODO Auto-generated method stub
		sqlSession.update("mapper.cafePhoto.updateCafePhoto", cafePhoto);
	}

	@Override
	public void deleteCafePhoto(int photo_id) {
		// TODO Auto-generated method stub
		sqlSession.delete("mapper.cafePhoto.deleteCafePhoto", photo_id);
	}
	
	
}
