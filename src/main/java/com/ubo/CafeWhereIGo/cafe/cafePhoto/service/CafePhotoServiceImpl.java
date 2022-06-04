package com.ubo.CafeWhereIGo.cafe.cafePhoto.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ubo.CafeWhereIGo.cafe.cafePhoto.dao.CafePhotoDAO;
import com.ubo.CafeWhereIGo.cafe.cafePhoto.vo.CafePhotoVO;

@Service
@Transactional
public class CafePhotoServiceImpl implements CafePhotoService{
	@Autowired
	CafePhotoDAO cafePhotoDAO;

	@Override
	public void addCafePhoto(CafePhotoVO cafePhoto) {
		// TODO Auto-generated method stub
		cafePhotoDAO.insertCafePhoto(cafePhoto);
	}

	@Override
	public CafePhotoVO getCafeMainPhoto(int cafe_id) {
		// TODO Auto-generated method stub
		CafePhotoVO cafePhoto = (CafePhotoVO)cafePhotoDAO.selectCafeMainPhoto(cafe_id);
		return cafePhoto;
	}

	@Override
	public List<CafePhotoVO> getCafePhoto(int cafe_id) {
		// TODO Auto-generated method stub
		List<CafePhotoVO> cafePhotoList = cafePhotoDAO.selectCafePhoto(cafe_id);
		return cafePhotoList;
	}

	@Override
	public void modifyCafePhoto(CafePhotoVO cafePhoto) {
		// TODO Auto-generated method stub
		cafePhotoDAO.updateCafePhoto(cafePhoto);
	}
	@Override
	public void deleteCafePhoto(int photo_id) {
		// TODO AutÍΩo-generated method stub
		cafePhotoDAO.deleteCafePhoto(photo_id);
	}
	
	
}
