package com.ubo.CafeWhereIGo.cafe.reviewPhoto.vo;

import org.springframework.stereotype.Component;

@Component
public class CafeReviewPhotoVO {
	private int CafeReview_review_id;
	private String filename;
	
	public CafeReviewPhotoVO() {
		super();
	}
	public CafeReviewPhotoVO(int cafeReview_review_id, String filename) {
		super();
		CafeReview_review_id = cafeReview_review_id;
		this.filename = filename;
	}
	public int getCafeReview_review_id() {
		return CafeReview_review_id;
	}
	public void setCafeReview_review_id(int cafeReview_review_id) {
		CafeReview_review_id = cafeReview_review_id;
	}
	public String getFilename() {
		return filename;
	}
	public void setFilename(String filename) {
		this.filename = filename;
	}
	
	
}
