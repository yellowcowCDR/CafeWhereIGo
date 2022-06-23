package com.ubo.CafeWhereIGo.cafe.review.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ubo.CafeWhereIGo.cafe.review.vo.CafeReviewVO;
import com.ubo.CafeWhereIGo.cafe.reviewPhoto.vo.CafeReviewPhotoVO;

@Repository
public class CafeReviewDAOImpl implements CafeReviewDAO{
	@Autowired
	SqlSession sqlSession;

	// Cafe Review
	@Override
	public void insertCafeReview(CafeReviewVO cafeReview) {
		// TODO Auto-generated method stub
		sqlSession.insert("mapper.cafeReview.insertCafeReview", cafeReview);
	}

	@Override
	public List<CafeReviewVO> selectCafeReviewList(int cafe_id) {
		// TODO Auto-generated method stub
		List<CafeReviewVO> cafeReviewList = sqlSession.selectList("mapper.cafeReview.selectCafeReviewList", cafe_id);
		return cafeReviewList;
	}

	@Override
	public CafeReviewVO selectCafeReview(int review_id) {
		// TODO Auto-generated method stub
		CafeReviewVO cafeReview = (CafeReviewVO) sqlSession.selectOne("mapper.cafeReview.selectCafeReview", review_id);
		return cafeReview;
	}

	@Override
	public void updateCafeReview(CafeReviewVO cafeReview) {
		// TODO Auto-generated method stub
		sqlSession.update("mapper.cafeReview.updateCafeReview", cafeReview);
	}

	@Override
	public void deleteCafeReview(int review_id) {
		// TODO Auto-generated method stub
		sqlSession.delete("mapper.cafeReview.deleteCafeReview", review_id);
	}

	
	// Cafe Review Photo
	@Override
	public void insertCafeReviewPhoto(CafeReviewPhotoVO cafeReviewPhoto) {
		// TODO Auto-generated method stub
		sqlSession.insert("mapper.cafeReviewPhoto.insertCafeReviewPhoto", cafeReviewPhoto);
	}

	@Override
	public CafeReviewPhotoVO selectCafeReviewPhoto(int review_id) {
		// TODO Auto-generated method stub
		CafeReviewPhotoVO cafeReviewPhoto = (CafeReviewPhotoVO)sqlSession.selectOne("mapper.cafeReviewPhoto.selectCafeReviewPhoto", review_id);
		return cafeReviewPhoto;
	}

	
	
	@Override
	public List<CafeReviewPhotoVO> selectCafeReviewsPhotos(int cafe_id) {
		// TODO Auto-generated method stub
		List<CafeReviewPhotoVO> cafeReviewPhotoList = sqlSession.selectList("mapper.cafeReviewPhoto.selectCafeReviewPhotos", cafe_id);
		return cafeReviewPhotoList;
	}

	@Override
	public void updateCafeReviewPhoto(CafeReviewPhotoVO cafeReviewPhoto) {
		// TODO Auto-generated method stub
		sqlSession.update("mapper.cafeReviewPhoto.updateCafeReviewPhoto", cafeReviewPhoto);
	}

	@Override
	public void deleteCafeReviewPhoto(int review_id) {
		// TODO Auto-generated method stub
		sqlSession.delete("mapper.cafeReviewPhoto.deleteCafeReviewPhoto", review_id);
	}

	//helper function
	@Override
	public int selectRecentReviewId() {
		// TODO Auto-generated method stub
		int review_id= (Integer)sqlSession.selectOne("mapper.cafeReview.selectRecentCafeReviewId");
		return review_id;
	}
	
	
	
}
