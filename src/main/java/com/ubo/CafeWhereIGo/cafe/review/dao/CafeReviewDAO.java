package com.ubo.CafeWhereIGo.cafe.review.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.ubo.CafeWhereIGo.cafe.review.vo.CafeReviewVO;
import com.ubo.CafeWhereIGo.cafe.reviewPhoto.vo.CafeReviewPhotoVO;

public interface CafeReviewDAO {
	// cafe review
	public void insertCafeReview(CafeReviewVO cafeReview);
	public List<CafeReviewVO> selectCafeReviewList(int cafe_id);
	public CafeReviewVO selectCafeReview(int review_id);
	public void updateCafeReview(CafeReviewVO cafeReview);
	public void deleteCafeReview(int review_id);
	
	//cafe review photo
	public void insertCafeReviewPhoto(CafeReviewPhotoVO cafeReviewPhoto);
	public CafeReviewPhotoVO selectCafeReviewPhoto(int review_id);
	public List<CafeReviewPhotoVO> selectCafeReviewsPhotos(int cafe_id);
	public void updateCafeReviewPhoto(CafeReviewPhotoVO cafeReviewPhoto);
	public void deleteCafeReviewPhoto(int review_id);
	
	//helper function
	public int selectRecentReviewId();
}
