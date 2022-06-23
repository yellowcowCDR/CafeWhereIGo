package com.ubo.CafeWhereIGo.cafe.review.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ubo.CafeWhereIGo.cafe.review.dao.CafeReviewDAO;
import com.ubo.CafeWhereIGo.cafe.review.vo.CafeReviewVO;
import com.ubo.CafeWhereIGo.cafe.reviewPhoto.vo.CafeReviewPhotoVO;
import com.ubo.CafeWhereIGo.cafe.themescore.dao.ThemeScoreDAO;
import com.ubo.CafeWhereIGo.cafe.themescore.vo.ThemeScoreVO;

@Service
@Transactional
public class CafeReviewServiceImpl implements CafeReviewService{
	Logger logger = LoggerFactory.getLogger(CafeReviewServiceImpl.class);
	@Autowired
	CafeReviewDAO cafeReviewDAO;
	
	@Autowired
	ThemeScoreDAO themeScoreDAO;
	
	// Cafe Review
	@Override
	public int addCafeReview(Map<String, Object> cafeReviewMap) {
		// TODO Auto-generated method stub
		CafeReviewVO cafeReview = (CafeReviewVO) cafeReviewMap.get("cafeReview");
		ThemeScoreVO themeScore = (ThemeScoreVO) cafeReviewMap.get("themeScore");
		cafeReviewDAO.insertCafeReview(cafeReview);
		int review_id = cafeReviewDAO.selectRecentReviewId();
		themeScore.setReview_review_id(review_id);
		themeScoreDAO.insertThemeScore(themeScore);
		
		return review_id;
	}

	@Override
	public List<Map<String,Object>> getCafeReviewList(int cafe_id) {
		// TODO Auto-generated method stub
		List<Map<String,Object>> cafeReviewMapList = new ArrayList<Map<String,Object>>();
		List<CafeReviewVO> cafeReviewList = cafeReviewDAO.selectCafeReviewList(cafe_id);
		Iterator cafeReviewListIt = cafeReviewList.iterator();
		while(cafeReviewListIt.hasNext()) {
			CafeReviewVO cafeReview = (CafeReviewVO) cafeReviewListIt.next();
			int review_id = cafeReview.getReview_id();
			
			String review_content = cafeReview.getReview_content();
			String[] review_content_list = review_content.split("\r\n");
			for(String review : review_content_list) {
				logger.debug("@[CafeReviewService, getCafeReviewList] review content: " + review);
			}
			cafeReview.setReview_content_list(review_content_list);
			
			Map<String,Object> cafeReviewMap = new HashMap<String,Object>();
			CafeReviewPhotoVO cafeReviewPhoto = cafeReviewDAO.selectCafeReviewPhoto(review_id);
			ThemeScoreVO themeScore = themeScoreDAO.selectThemeScore(review_id);
			
			cafeReviewMap.put("cafeReview",cafeReview);
			cafeReviewMap.put("cafeReviewPhoto",cafeReviewPhoto);
			cafeReviewMap.put("themeScore",themeScore);
			
			cafeReviewMapList.add(cafeReviewMap);
		}
		
		return cafeReviewMapList;
	}

	@Override
	public void modifyCafeReview(Map<String, Object> cafeReviewMap) {
		// TODO Auto-generated method stub
		CafeReviewVO cafeReview = (CafeReviewVO) cafeReviewMap.get("cafeReview");
		ThemeScoreVO themeScore = (ThemeScoreVO) cafeReviewMap.get("themeScore");
		cafeReviewDAO.updateCafeReview(cafeReview);
		themeScoreDAO.updateThemeScore(themeScore);
	}

	@Override
	public int deleteCafeReview(int review_id) {
		// TODO Auto-generated method stub
		
		// delete theme score
		themeScoreDAO.deleteThemeScore(review_id);
		// delete cafe review photo & photo file
		cafeReviewDAO.deleteCafeReviewPhoto(review_id);
		// delete cafe review
		CafeReviewVO cafeReview = cafeReviewDAO.selectCafeReview(review_id);
		int cafe_id = cafeReview.getCafe_cafe_id();
		cafeReviewDAO.deleteCafeReview(review_id);
		
		return cafe_id;
	}

	//Cafe Review Photo
	@Override
	public void addCafeReviewPhoto(CafeReviewPhotoVO cafeReviewPhoto) {
		// TODO Auto-generated method stub
		cafeReviewDAO.insertCafeReviewPhoto(cafeReviewPhoto);
	}

	@Override
	public CafeReviewPhotoVO getCafeReviewPhoto(int review_id) {
		// TODO Auto-generated method stub
		CafeReviewPhotoVO reviewPhoto = cafeReviewDAO.selectCafeReviewPhoto(review_id);
		return reviewPhoto;
	}

	@Override
	public void modifyCafeReviewPhoto(CafeReviewPhotoVO cafeReviewPhoto) {
		// TODO Auto-generated method stub
		cafeReviewDAO.updateCafeReviewPhoto(cafeReviewPhoto);
	}

	@Override
	public void deleteCafeReviewPhoto(int review_id) {
		// TODO Auto-generated method stub
		cafeReviewDAO.deleteCafeReviewPhoto(review_id);
	}
}
