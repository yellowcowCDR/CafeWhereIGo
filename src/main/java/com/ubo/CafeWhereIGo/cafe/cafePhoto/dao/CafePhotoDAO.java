package com.ubo.CafeWhereIGo.cafe.cafePhoto.dao;

import java.util.List;

import com.ubo.CafeWhereIGo.cafe.cafePhoto.vo.CafePhotoVO;

public interface CafePhotoDAO {
	public void insertCafePhoto(CafePhotoVO cafePhoto);
	public CafePhotoVO selectCafeMainPhoto(int cafe_id);
	public List<CafePhotoVO> selectCafePhoto(int cafe_id);
	public CafePhotoVO selectOneCafePhoto(int photo_id);
	public void updateCafePhoto(CafePhotoVO cafePhoto);
	public void deleteCafePhoto(int photo_id);
	
}
