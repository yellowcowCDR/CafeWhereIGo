package com.ubo.CafeWhereIGo.cafe.cafe.service;

import java.util.List;
import java.util.Map;

import com.ubo.CafeWhereIGo.cafe.cafe.vo.CafeSearchParameterForManagementVO;
import com.ubo.CafeWhereIGo.cafe.cafe.vo.CafeSearchParameterVO;
import com.ubo.CafeWhereIGo.cafe.cafe.vo.CafeSearchResultVO;
import com.ubo.CafeWhereIGo.cafe.cafe.vo.CafeVO;
import com.ubo.CafeWhereIGo.cafe.facilityInfo.vo.FacilityInfoVO;
import com.ubo.CafeWhereIGo.cafe.parkinglot.vo.ParkingLotVO;
import com.ubo.CafeWhereIGo.cafe.review.vo.CafeReviewVO;
import com.ubo.CafeWhereIGo.cafe.themescore.vo.ThemeScoreVO;
import com.ubo.CafeWhereIGo.cafeHomeArticle.vo.CafeHomeArticleVO;

public interface CafeService {
	//cafe info
	public int addCafe(CafeVO cafe);
	public List<CafeSearchResultVO> getCafeList(CafeSearchParameterVO cafeSearchParameter);
	public List<Map> getCafeListForManagement(CafeSearchParameterForManagementVO cafeSearchParameterForManagement);
	public CafeVO getCafeDetail(int cafe_id);
	public void modifyCafe(CafeVO cafe);
	public void deleteCafe(int cafe_id);
	
	//facility info
	public void registerFacilityInfo(FacilityInfoVO facilityInfo);
	public FacilityInfoVO getFacilityInfo(int cafe_id);
	public void modifyFacilityInfo(FacilityInfoVO facilityInfo);
	public void deleteFacilityInfo(int cafe_id);
	
	//home article
	public void registerHomeArticle(CafeHomeArticleVO homeArticle);
	public CafeHomeArticleVO selectHomeArticle(int cafe_id);
	public void modifyHomeArticle(CafeHomeArticleVO homeArticle);
	public void deleteHomeArticle(int cafe_id);
	
	//parking lot
	public void registerParkingLot(List<ParkingLotVO> parkingLotList);
	public void registerParkingLot(ParkingLotVO parkingLot);
	public List<ParkingLotVO> selectParkingLot(int cafe_id);
	public void modifyParkingLot(ParkingLotVO parkingLot);
	public void deleteParkingLot(int parkingLot_id);
	
	//theme score
	public void insertThemeScore(ThemeScoreVO themeScore);
	public Map<String, Object> getThemeScoreAverage(int cafe_id);
	
	//cafe review
	public void addCafeReview(Map<String,Object> reviewMap);
	public List<Map<String, Object>> getCafeReviewList(int cafe_id);
	public void updateCafeReview(CafeReviewVO cafeReview);
	public void deleteCafeReview(int review_id);
	
	//like cafe
	public List<CafeSearchResultVO> selectLikeCafeList(String user_id);
	public void toggleLikeCafe(String user_id, int cafe_id);
	public boolean isLikeCafe(String user_id, int cafe_id);
}
