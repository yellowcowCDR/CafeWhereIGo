package com.ubo.CafeWhereIGo.cafe.parkinglot.dao;

import java.util.List;

import com.ubo.CafeWhereIGo.cafe.parkinglot.vo.ParkingLotVO;

public interface ParkingLotDAO {
	public void insertParkingLot(ParkingLotVO facilityInfo);
	public void updateParkingLot(ParkingLotVO facilityInfo);
	public List<ParkingLotVO> selectParkingLot(int cafe_id);
	public void deleteParkingLot(int cafe_id);
}
