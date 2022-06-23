package com.ubo.CafeWhereIGo.orderAndReservation.reservation.dao;

import java.util.List;
import java.util.Map;

import com.ubo.CafeWhereIGo.orderAndReservation.reservation.vo.ReservationVO;

public interface ReservationDAO {
	public void insertReservation(ReservationVO reservation);
	public List<ReservationVO> selectReservationByUserId(String user_id);
	public List<ReservationVO> selectReservationByOrderId(int order_id);
	public List<ReservationVO> selectReservationByUserIdAndOrderId(Map searchMap);
	public List<ReservationVO> selectReservationByCafeId(int cafe_id);
	public List<ReservationVO> selectReservationForReview(String user_id, int cafe_id, int orderAndReservation_id);
	public ReservationVO selectOneReservation(int reservation_id);
	public void updateReservation(ReservationVO reservation);
	public void deleteReservation(int reservation_id);
	public void updateReservationState(int reservation_id, String reservation_state);
}
