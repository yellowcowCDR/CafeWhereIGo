package com.ubo.CafeWhereIGo.cafe.review.service;

import java.util.List;
import java.util.Map;

import com.ubo.CafeWhereIGo.cafe.review.vo.CafeReviewVO;
import com.ubo.CafeWhereIGo.cafe.reviewPhoto.vo.CafeReviewPhotoVO;

public interface CafeReviewService {
	// cafe review
	public int addCafeReview(Map<String, Object> cafeReviewMap);
	public List<Map<String,Object>> getCafeReviewList(int cafe_id);
	public void modifyCafeReview(Map<String, Object> cafeReviewMap);
	public int deleteCafeReview(int review_id);
	
	//cafe reivew photo
	public void addCafeReviewPhoto(CafeReviewPhotoVO cafeReviewPhoto);
	public CafeReviewPhotoVO getCafeReviewPhoto(int review_id);
	public void modifyCafeReviewPhoto(CafeReviewPhotoVO cafeReviewPhoto);
	public void deleteCafeReviewPhoto(int review_id);
}
