package com.ubo.CafeWhereIGo.cafe.cafePhoto.service;

import java.util.List;
import java.util.Map;

import com.ubo.CafeWhereIGo.cafe.cafePhoto.vo.CafePhotoVO;

public interface CafePhotoService {
	public void addCafePhoto(CafePhotoVO cafePhoto);
	public CafePhotoVO getCafeMainPhoto(int cafe_id);
	public List<CafePhotoVO> getCafePhoto(int cafe_id);
	public CafePhotoVO getOneCafePhoto(int photo_id);
	public List<Map<String,Object>> getAllPhoto(int cafe_id);
	public void modifyCafePhoto(CafePhotoVO cafePhoto);
	public void deleteCafePhoto(int photo_id);
	
}
