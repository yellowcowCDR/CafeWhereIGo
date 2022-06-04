package com.ubo.CafeWhereIGo.orderAndReservation.reservation.dao;

import java.util.List;

import com.ubo.CafeWhereIGo.orderAndReservation.reservation.vo.ReservationVO;

public interface ReservationDAO {
	public void insertReservation(ReservationVO reservation);
	public List<ReservationVO> selectReservationByUserId(String user_id);
	public List<ReservationVO> selectReservationByCafeId(int cafe_id);
	public ReservationVO selectOneReservation(int reservation_id);
	public void updateReservation(ReservationVO reservation);
	public void deleteReservation(int reservation_id);
}
