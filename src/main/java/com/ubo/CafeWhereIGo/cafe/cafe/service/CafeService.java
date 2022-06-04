package com.ubo.CafeWhereIGo.cafe.cafe.service;

import java.util.List;

import com.ubo.CafeWhereIGo.cafe.cafe.vo.CafeSearchResultVO;
import com.ubo.CafeWhereIGo.cafe.cafe.vo.CafeVO;
import com.ubo.CafeWhereIGo.cafe.facilityInfo.vo.FacilityInfoVO;
import com.ubo.CafeWhereIGo.cafe.parkinglot.vo.ParkingLotVO;
import com.ubo.CafeWhereIGo.cafeHomeArticle.vo.CafeHomeArticleVO;

public interface CafeService {
	//cafe info
	public int addCafe(CafeVO cafe);
	public List<CafeSearchResultVO> getCafeList();
	public CafeVO getCafeDetail(int cafe_id);
	public void modifyCafe(CafeVO cafe);
	public void deleteCafe(int cafe_id);
	
	//facility info
	public void registerFacilityInfo(FacilityInfoVO facilityInfo);
	public FacilityInfoVO selectFacilityInfo();
	public void modifyFacilityInfo(FacilityInfoVO facilityInfo);
	public void deleteFacilityInfo(int cafe_id);
	
	//home article
	public void registerHomeArticle(CafeHomeArticleVO homeArticle);
	public CafeHomeArticleVO selectHomeArticle(int cafe_id);
	public void modifyHomeArticle(CafeHomeArticleVO homeArticle);
	public void deleteHomeArticle(int cafe_id);
	
	//parking lot
	public void registerParkingLot(List<ParkingLotVO> parkingLotList);
	public List<ParkingLotVO> selectParkingLot(int cafe_id);
	public void modifyParkingLotVO(ParkingLotVO parkingLot);
	public void deleteParkingLotVO(int parkingLot_id);
}
