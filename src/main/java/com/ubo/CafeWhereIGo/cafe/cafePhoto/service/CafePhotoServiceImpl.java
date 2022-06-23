package com.ubo.CafeWhereIGo.cafe.cafePhoto.service;

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

import com.ubo.CafeWhereIGo.cafe.cafePhoto.dao.CafePhotoDAO;
import com.ubo.CafeWhereIGo.cafe.cafePhoto.vo.CafePhotoVO;
import com.ubo.CafeWhereIGo.cafe.review.dao.CafeReviewDAO;
import com.ubo.CafeWhereIGo.cafe.review.vo.CafeReviewVO;
import com.ubo.CafeWhereIGo.cafe.reviewPhoto.vo.CafeReviewPhotoVO;

@Service
@Transactional
public class CafePhotoServiceImpl implements CafePhotoService{
	Logger logger = LoggerFactory.getLogger(CafePhotoServiceImpl.class);
	@Autowired
	CafePhotoDAO cafePhotoDAO;

	@Autowired
	CafeReviewDAO cafeReviewDAO;
	
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
	public CafePhotoVO getOneCafePhoto(int photo_id) {
		// TODO Auto-generated method stub
		CafePhotoVO cafePhoto = cafePhotoDAO.selectOneCafePhoto(photo_id);
		return cafePhoto;
	}
	
	@Override
	public List<Map<String, Object>> getAllPhoto(int cafe_id) {
		// TODO Auto-generated method stub
		List<Map<String, Object>> photoMapList = new ArrayList<Map<String, Object>>();
		List<CafePhotoVO> cafePhotoList = cafePhotoDAO.selectCafePhoto(cafe_id);
		Iterator cafePhotoListIt = cafePhotoList.iterator();
		while(cafePhotoListIt.hasNext()) {
			CafePhotoVO cafePhoto = (CafePhotoVO)cafePhotoListIt.next();
			int photo_id = cafePhoto.getPhoto_id();
			String photo_name = cafePhoto.getFilename();
			Map<String, Object> photoMap = new HashMap<String, Object>();
			photoMap.put("photo_type","cafePhoto");
			photoMap.put("cafe_id", cafe_id);
			photoMap.put("photo_id", photo_id);
			photoMap.put("photo_name", photo_name);
			photoMapList.add(photoMap);
		}
		
		List<CafeReviewVO> cafeReviewList = cafeReviewDAO.selectCafeReviewList(cafe_id);
		Iterator cafeReviewListIt = cafeReviewList.iterator();
		while(cafeReviewListIt.hasNext()) {
			CafeReviewVO cafeReview = (CafeReviewVO) cafeReviewListIt.next();
			int review_id = cafeReview.getReview_id();
			
			CafeReviewPhotoVO cafeReviewPhoto = cafeReviewDAO.selectCafeReviewPhoto(review_id);
			if(cafeReviewPhoto != null) {
				Map<String, Object> photoMap = new HashMap<String, Object>();
				
				logger.debug("[@CafePhotoServiceImpl, getAllPhoto] @cafeReviewPhotoListIt, cafe_id: "+cafe_id);
				logger.debug("[@CafePhotoServiceImpl, getAllPhoto] @cafeReviewPhotoListIt, review_id: "+review_id);
				photoMap.put("photo_type","cafeReviewPhoto");
				photoMap.put("cafe_id", cafe_id);
				photoMap.put("review_id", review_id);
				
				photoMapList.add(photoMap);
			}
			
		}

		return photoMapList;
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
