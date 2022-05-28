package com.ubo.CafeWhereIGo.cafe.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.ubo.CafeWhereIGo.cafe.facilityInfo.vo.FacilityInfoVO;
import com.ubo.CafeWhereIGo.cafe.parkinglot.vo.ParkingLotVO;
import com.ubo.CafeWhereIGo.cafe.vo.CafeVO;
import com.ubo.CafeWhereIGo.cafeHomeArticle.vo.CafeHomeArticleVO;

@Repository
public interface CafeDAO {
	//Cafe Info
	public void insertCafe(CafeVO cafeInfo);
	public CafeVO selectCafe(CafeVO cafeInfo);
	public List<CafeVO> selectCafeList();
	public void updateCafe(CafeVO cafeInfo);
	public void deleteCafe(int cafe_id);
	
	//Facility Info 
	public void insertCafeFacility(FacilityInfoVO facilityInfoVO);
	public FacilityInfoVO selectCafeFacility(int cafe_id);
	public void updateCafeFacility(FacilityInfoVO facilityInfoVO);
	public void deleteCafeFacility(int cafe_id);
	
	//Home Article
	public void insertCafeHomeArticle(CafeHomeArticleVO homeArticle);
	public CafeHomeArticleVO selectCafeHomeArticle(int cafe_id);
	public void updateCafeHomeArticle(CafeHomeArticleVO homeArticle);
	public void deleteCafeHomeArticle(int cafe_id);
	
	//Parking Lot Info
	public void insertParkingLotInfo(List<ParkingLotVO> parkingLotInfoList);
	public List<ParkingLotVO> selectParkingLotInfo(int cafe_cafe_id);
	public void updateParkingLotInfo(ParkingLotVO parkingLotInfo);
	public void deleteParkingLotInfo(int parking_lot_id);
	public void deleteParkingLotInfoByCafeId(int cafe_id);
	public int getRecentCafeId();
}
