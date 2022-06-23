package com.ubo.CafeWhereIGo.cafe.cafe.service;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ubo.CafeWhereIGo.cafe.cafe.dao.CafeDAO;
import com.ubo.CafeWhereIGo.cafe.cafe.vo.CafeSearchParameterForManagementVO;
import com.ubo.CafeWhereIGo.cafe.cafe.vo.CafeSearchParameterVO;
import com.ubo.CafeWhereIGo.cafe.cafe.vo.CafeSearchResultVO;
import com.ubo.CafeWhereIGo.cafe.cafe.vo.CafeVO;
import com.ubo.CafeWhereIGo.cafe.facilityInfo.dao.FacilityInfoDAO;
import com.ubo.CafeWhereIGo.cafe.facilityInfo.vo.FacilityInfoVO;
import com.ubo.CafeWhereIGo.cafe.parkinglot.dao.ParkingLotDAO;
import com.ubo.CafeWhereIGo.cafe.parkinglot.vo.ParkingLotVO;
import com.ubo.CafeWhereIGo.cafe.review.vo.CafeReviewVO;
import com.ubo.CafeWhereIGo.cafe.themescore.dao.ThemeScoreDAO;
import com.ubo.CafeWhereIGo.cafe.themescore.vo.ThemeScoreVO;
import com.ubo.CafeWhereIGo.cafeHomeArticle.dao.CafeHomeArticleDAO;
import com.ubo.CafeWhereIGo.cafeHomeArticle.vo.CafeHomeArticleVO;
import com.ubo.CafeWhereIGo.likedcafe.vo.LikedCafeVO;


@Service
@Transactional
public class CafeServiceImpl implements CafeService{
	Logger logger = LoggerFactory.getLogger(CafeServiceImpl.class);
	
	@Autowired
	CafeDAO cafeDAO;
	
	@Autowired
	FacilityInfoDAO facilityInfoDAO;
	
	@Autowired
	CafeHomeArticleDAO homeArticleDAO;
	
	@Autowired
	ParkingLotDAO parkingLotDAO;

	@Autowired
	ThemeScoreDAO themeScoreDAO;
	
	@Override
	public int addCafe(CafeVO cafeInfo) {
		// TODO Auto-generated method stub
		cafeDAO.insertCafe(cafeInfo);
		
		int cafe_id = cafeDAO.getRecentCafeId();
		return cafe_id;
	}

	@Override
	public List<CafeSearchResultVO> getCafeList(CafeSearchParameterVO cafeSearchParameter) {
		// TODO Auto-generated method stub
		List<CafeSearchResultVO> cafeSearchResultList = cafeDAO.selectCafeList(cafeSearchParameter);
		return cafeSearchResultList;
	}
	
	
	
	@Override
	public List<Map> getCafeListForManagement(CafeSearchParameterForManagementVO cafeSearchParameterForManagement) {
		// TODO Auto-generated method stub
		List<Map> cafeList= cafeDAO.selectCafeListForManagement(cafeSearchParameterForManagement);
		return cafeList;
	}

	@Override
	public CafeVO getCafeDetail(int cafe_id) {
		// TODO Auto-generated method stub
		CafeVO cafe=(CafeVO) cafeDAO.selectCafeDetail(cafe_id);
		return cafe;
	}

	@Override
	public void modifyCafe(CafeVO cafe) {
		// TODO Auto-generated method stub
		cafeDAO.updateCafe(cafe);
	}

	@Override
	public void deleteCafe(int cafe_id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void registerFacilityInfo(FacilityInfoVO facilityInfo) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public FacilityInfoVO getFacilityInfo(int cafe_id) {
		// TODO Auto-generated method stub
		FacilityInfoVO facilityInfo =  facilityInfoDAO.selectFacilityInfo(cafe_id);
		return facilityInfo;
	}

	@Override
	public void modifyFacilityInfo(FacilityInfoVO facilityInfo) {
		// TODO Auto-generated method stub
		int cafe_id = facilityInfo.getCafe_cafe_id();
		FacilityInfoVO facilityInfoFromDB = facilityInfoDAO.selectFacilityInfo(cafe_id);
		if(facilityInfoFromDB == null) {
			facilityInfoDAO.insertFacilityInfo(facilityInfo);
		}else {
			facilityInfoDAO.updateFacilityInfo(facilityInfo);
		}
	}

	@Override
	public void deleteFacilityInfo(int cafe_id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void registerHomeArticle(CafeHomeArticleVO homeArticle) {
		// TODO Auto-generated method stub
		homeArticleDAO.insertHomeArticle(homeArticle);
	}

	@Override
	public CafeHomeArticleVO selectHomeArticle(int cafe_id) {
		// TODO Auto-generated method stub
		CafeHomeArticleVO homeArticle = homeArticleDAO.selectHomeArticle(cafe_id);
		return homeArticle;
	}

	@Override
	public void modifyHomeArticle(CafeHomeArticleVO homeArticle) {
		// TODO Auto-generated method stub
		homeArticleDAO.updateHomeArticle(homeArticle);
	}

	@Override
	public void deleteHomeArticle(int cafe_id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void registerParkingLot(List<ParkingLotVO> parkingLotList) {
		// TODO Auto-generated method stub
		Iterator parkingLotListIt = parkingLotList.iterator();
		while(parkingLotListIt.hasNext()) {
			ParkingLotVO parkingLot = (ParkingLotVO) parkingLotListIt.next();
			parkingLotDAO.insertParkingLot(parkingLot);
		}
	}
	
	@Override
	public void registerParkingLot(ParkingLotVO parkingLot) {
		// TODO Auto-generated method stub
		parkingLotDAO.insertParkingLot(parkingLot);
	}
	

	@Override
	public List<ParkingLotVO> selectParkingLot(int cafe_id) {
		// TODO Auto-generated method stub
		List<ParkingLotVO> parkingLotList = parkingLotDAO.selectParkingLot(cafe_id);
		logger.debug("[@CafeServiceImpl, selectParkingLot] parkingLot size: "+ parkingLotList.size());
		return parkingLotList;
	}

	@Override
	public void modifyParkingLot(ParkingLotVO parkingLot) {
		// TODO Auto-generated method stub
		parkingLotDAO.updateParkingLot(parkingLot);
	}

	@Override
	public void deleteParkingLot(int parkingLot_id) {
		// TODO Auto-generated method stub
		parkingLotDAO.deleteParkingLot(parkingLot_id);
	}

	
	
	@Override
	public void insertThemeScore(ThemeScoreVO themeScore) {
		// TODO Auto-generated method stub
		themeScoreDAO.insertThemeScore(themeScore);
	}

	@Override
	public Map<String, Object> getThemeScoreAverage(int cafe_id) {
		// TODO Auto-generated method stub
		double coffeeScore = 0;
		double drinkScore = 0;
		double dessertScore = 0;
		double viewScore = 0;
		double moodScore = 0;
		double quietScore = 0;
		
		double coffeeScoreAvg = 0;
		double drinkScoreAvg = 0;
		double dessertScoreAvg = 0;
		double viewScoreAvg = 0;
		double moodScoreAvg = 0;
		double quietScoreAvg = 0;
		
		List<ThemeScoreVO> themeScoreList = themeScoreDAO.selectThemeScores(cafe_id);
		int numOfthemeScoreList = themeScoreList.size();
		if(themeScoreList.size()>0) {
			Iterator themeScoreListIt = themeScoreList.iterator();
			while(themeScoreListIt.hasNext()) {
				ThemeScoreVO themeScore = (ThemeScoreVO) themeScoreListIt.next();
				coffeeScore+=themeScore.getCoffee_score();
				drinkScore+=themeScore.getDrink_score();
				dessertScore+=themeScore.getDessert_score();
				viewScore+=themeScore.getView_score();
				moodScore+=themeScore.getMood_score();
				quietScore+=themeScore.getQuiet_score();
			}

			coffeeScoreAvg = coffeeScore/(double)numOfthemeScoreList;
			drinkScoreAvg = drinkScore/(double)numOfthemeScoreList;
			dessertScoreAvg = dessertScore/(double)numOfthemeScoreList;
			viewScoreAvg = viewScore/(double)numOfthemeScoreList;
			moodScoreAvg = moodScore/(double)numOfthemeScoreList;
			quietScoreAvg = quietScore/(double)numOfthemeScoreList;
		}
		
		Map<String, Object> themeScoreMap = new HashMap<String, Object>();
		themeScoreMap.put("cafe_id", cafe_id);
		themeScoreMap.put("coffeeScore", coffeeScoreAvg);
		themeScoreMap.put("drinkScore", drinkScoreAvg);
		themeScoreMap.put("dessertScore", dessertScoreAvg);
		themeScoreMap.put("viewScore", viewScoreAvg);
		themeScoreMap.put("moodScore", moodScoreAvg);
		themeScoreMap.put("quietScore", quietScoreAvg);
		return themeScoreMap;
	}
	
	@Override
	public void addCafeReview(Map<String, Object> reviewMap) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Map<String, Object>> getCafeReviewList(int cafe_id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateCafeReview(CafeReviewVO cafeReview) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteCafeReview(int review_id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<CafeSearchResultVO> selectLikeCafeList(String user_id) {
		// TODO Auto-generated method stub
		List<CafeSearchResultVO> likeCafeList= cafeDAO.selectLikeCafeList(user_id);
		return likeCafeList;
	}

	@Override
	public void toggleLikeCafe(String user_id, int cafe_id) {
		// TODO Auto-generated method stub
		LikedCafeVO likeCafeInfo = new LikedCafeVO(user_id, cafe_id);
		boolean isLikeCafe = cafeDAO.selectIsLikeCafe(likeCafeInfo);
		if(isLikeCafe) {
			cafeDAO.deleteLikeCafe(likeCafeInfo);
		}else {
			cafeDAO.insertLikeCafe(likeCafeInfo);
		}
	}

	@Override
	public boolean isLikeCafe(String user_id, int cafe_id) {
		// TODO Auto-generated method stub
		LikedCafeVO likeCafeInfo = new LikedCafeVO(user_id, cafe_id);
		boolean isLikeCafe = cafeDAO.selectIsLikeCafe(likeCafeInfo);
		return isLikeCafe;
	}
	
	
}
