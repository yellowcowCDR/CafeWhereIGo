package com.ubo.CafeWhereIGo.cafe.cafe.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ubo.CafeWhereIGo.cafe.cafe.dao.CafeDAO;
import com.ubo.CafeWhereIGo.cafe.cafe.vo.CafeSearchResultVO;
import com.ubo.CafeWhereIGo.cafe.cafe.vo.CafeVO;
import com.ubo.CafeWhereIGo.cafe.facilityInfo.dao.FacilityInfoDAO;
import com.ubo.CafeWhereIGo.cafe.facilityInfo.vo.FacilityInfoVO;
import com.ubo.CafeWhereIGo.cafe.parkinglot.dao.ParkingLotDAO;
import com.ubo.CafeWhereIGo.cafe.parkinglot.vo.ParkingLotVO;
import com.ubo.CafeWhereIGo.cafeHomeArticle.dao.CafeHomeArticleDAO;
import com.ubo.CafeWhereIGo.cafeHomeArticle.vo.CafeHomeArticleVO;


@Service
@Transactional
public class CafeServiceImpl implements CafeService{
	@Autowired
	CafeDAO cafeDAO;
	
	@Autowired
	FacilityInfoDAO facilityInfoDAO;
	
	@Autowired
	CafeHomeArticleDAO homeArticleDAO;
	
	@Autowired
	ParkingLotDAO parkingLotDAO;

	@Override
	public int addCafe(CafeVO cafeInfo) {
		// TODO Auto-generated method stub
		cafeDAO.insertCafe(cafeInfo);
		
		int cafe_id = cafeDAO.getRecentCafeId();
		return cafe_id;
	}

	@Override
	public List<CafeSearchResultVO> getCafeList() {
		// TODO Auto-generated method stub
		List<CafeSearchResultVO> cafeSearchResultList = cafeDAO.selectCafeList();
		return cafeSearchResultList;
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
	public FacilityInfoVO selectFacilityInfo() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void modifyFacilityInfo(FacilityInfoVO facilityInfo) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteFacilityInfo(int cafe_id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void registerHomeArticle(CafeHomeArticleVO homeArticle) {
		// TODO Auto-generated method stub
		
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
		
	}

	@Override
	public void deleteHomeArticle(int cafe_id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void registerParkingLot(List<ParkingLotVO> parkingLotList) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<ParkingLotVO> selectParkingLot(int cafe_id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void modifyParkingLotVO(ParkingLotVO parkingLot) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteParkingLotVO(int parkingLot_id) {
		// TODO Auto-generated method stub
		
	}
}
