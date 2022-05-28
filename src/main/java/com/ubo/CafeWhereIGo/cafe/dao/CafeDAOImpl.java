package com.ubo.CafeWhereIGo.cafe.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ubo.CafeWhereIGo.cafe.facilityInfo.vo.FacilityInfoVO;
import com.ubo.CafeWhereIGo.cafe.parkinglot.vo.ParkingLotVO;
import com.ubo.CafeWhereIGo.cafe.vo.CafeVO;
import com.ubo.CafeWhereIGo.cafeHomeArticle.vo.CafeHomeArticleVO;

@Repository
public class CafeDAOImpl implements CafeDAO {
	@Autowired
	private SqlSession sqlSession;

	@Override
	public void insertCafe(CafeVO cafeInfo) {
		// TODO Auto-generated method stub
		sqlSession.insert("mapper.cafe.insertCafe", cafeInfo);
	}

	@Override
	public CafeVO selectCafe(CafeVO cafeInfo) {
		// TODO Auto-generated method stub
		return (CafeVO)sqlSession.selectOne("mapper.cafe.selectCafe", cafeInfo);
		
	}

	@Override
	public List<CafeVO> selectCafeList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateCafe(CafeVO cafeInfo) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteCafe(int cafe_id) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void insertCafeFacility(FacilityInfoVO facilityInfoVO) {
		// TODO Auto-generated method stub
		sqlSession.insert("mapper.cafeFacility.insertFacility", facilityInfoVO);
	}

	@Override
	public FacilityInfoVO selectCafeFacility(int cafe_id) {
		// TODO Auto-generated method stub
		return (FacilityInfoVO)sqlSession.selectOne("mapper.cafeFacility.selectFacility", cafe_id);
	}

	@Override
	public void updateCafeFacility(FacilityInfoVO facilityInfoVO) {
		// TODO Auto-generated method stub
		sqlSession.update("mapper.cafeFacility.updateFacility");
	}

	@Override
	public void deleteCafeFacility(int cafe_id) {
		// TODO Auto-generated method stub
		sqlSession.delete("mapper.cafeFacility.deleteFacility");
	}

	
	
	@Override
	public void insertCafeHomeArticle(CafeHomeArticleVO homeArticle) {
		// TODO Auto-generated method stub
		sqlSession.insert("mapper.cafeHomeArticle.insertHomeArticle", homeArticle);
	}

	@Override
	public CafeHomeArticleVO selectCafeHomeArticle(int cafe_id) {
		// TODO Auto-generated method stub
		return (CafeHomeArticleVO) sqlSession.selectOne("mapper.cafeHomeArticle.selectHomeArticle",cafe_id);
	}

	@Override
	public void updateCafeHomeArticle(CafeHomeArticleVO homeArticle) {
		// TODO Auto-generated method stub
		sqlSession.update("mapper.cafeHomeArticle.updateHomeArticle", homeArticle);
	}

	@Override
	public void deleteCafeHomeArticle(int cafe_id) {
		// TODO Auto-generated method stub
		sqlSession.delete("mapper.cafeHomeArticle.updateHomeArticle", cafe_id);
	}
	
	@Override
	public void insertParkingLotInfo(List<ParkingLotVO> parkingLotInfoList) {
		// TODO Auto-generated method stub
		for(int i=0; i<parkingLotInfoList.size(); i++) {
			ParkingLotVO paringLotInfo=parkingLotInfoList.get(i);
			sqlSession.insert("mapper.cafeParkingLot.insertParkingLotInfo",paringLotInfo);
		}
	}

	@Override
	public List<ParkingLotVO> selectParkingLotInfo(int cafe_id) {
		// TODO Auto-generated method stub
		return sqlSession.selectList("mapper.cafeParkingLot.selectParkingLotInfo", cafe_id);
	}

	@Override
	public void updateParkingLotInfo(ParkingLotVO parkingLotInfo) {
		// TODO Auto-generated method stub
		sqlSession.update("mapper.cafeParkingLot.updateParkingLotInfo",parkingLotInfo);
	}

	@Override
	public void deleteParkingLotInfo(int parking_lot_id) {
		// TODO Auto-generated method stub
		sqlSession.delete("mapper.cafeParkingLot.deleteParkingLotInfo",parking_lot_id);
	}

	@Override
	public void deleteParkingLotInfoByCafeId(int cafe_id) {
		// TODO Auto-generated method stub
		sqlSession.delete("mapper.cafeParkingLot.deleteParkingLotInfoByCafeId",cafe_id);
	}

	@Override
	public int getRecentCafeId() {
		// TODO Auto-generated method stub
		int id= (Integer)sqlSession.selectOne("mapper.cafe.selectRecentCafeId");
		return id;
	}
	
}
