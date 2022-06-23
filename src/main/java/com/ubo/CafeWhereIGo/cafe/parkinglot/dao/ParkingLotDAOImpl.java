package com.ubo.CafeWhereIGo.cafe.parkinglot.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ubo.CafeWhereIGo.cafe.parkinglot.vo.ParkingLotVO;

@Repository
public class ParkingLotDAOImpl implements ParkingLotDAO{

	@Autowired
	SqlSession sqlSession;

	@Override
	public void insertParkingLot(ParkingLotVO parkingLotInfo) {
		// TODO Auto-generated method stub
		sqlSession.insert("mapper.cafeParkingLot.insertParkingLotInfo",parkingLotInfo);
	}

	@Override
	public void updateParkingLot(ParkingLotVO parkingLotInfo) {
		// TODO Auto-generated method stub
		sqlSession.update("mapper.cafeParkingLot.updateParkingLotInfo",parkingLotInfo);
	}

	@Override
	public List<ParkingLotVO> selectParkingLot(int cafe_id) {
		// TODO Auto-generated method stub
		List<ParkingLotVO> parkingLotList = sqlSession.selectList("mapper.cafeParkingLot.selectParkingLotInfo",cafe_id);
		return parkingLotList;
	}

	@Override
	public void deleteParkingLot(int parkingLot_id) {
		// TODO Auto-generated method stub
		sqlSession.delete("mapper.cafeParkingLot.deleteParkingLotInfo",parkingLot_id);
	}
	
	
	
}
