package com.ubo.CafeWhereIGo.orderAndReservation.reservation.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ubo.CafeWhereIGo.orderAndReservation.reservation.vo.ReservationVO;

@Repository
public class ReservationDAOImpl implements ReservationDAO{
	@Autowired
	SqlSession sqlSession;

	@Override
	public void insertReservation(ReservationVO reservation) {
		// TODO Auto-generated method stub
		sqlSession.insert("mapper.reservation.insertReservation",reservation);
	}

	@Override
	public List<ReservationVO> selectReservationByUserId(String user_id) {
		// TODO Auto-generated method stub
		List<ReservationVO> reservationList = sqlSession.selectList("mapper.reservation.selectReservationByUserId",user_id);
		return reservationList;
	}
	
	@Override
	public List<ReservationVO> selectReservationByOrderId(int order_id) {
		// TODO Auto-generated method stub
		List<ReservationVO> reservationList = sqlSession.selectList("mapper.reservation.selectReservationByOrderId",order_id);
		return reservationList;
	}

	@Override
	public List<ReservationVO> selectReservationByUserIdAndOrderId(Map searchMap) {
		// TODO Auto-generated method stub
		List<ReservationVO> reservationList= sqlSession.selectList("mapper.reservation.selectReservationByUserIdAndOrderId", searchMap);
		return reservationList;
	}
	
	@Override
	public List<ReservationVO> selectReservationByCafeId(int cafe_id) {
		// TODO Auto-generated method stub
		
		List<ReservationVO> reservationList = sqlSession.selectList("mapper.reservation.selectReservationByCafeId",cafe_id);
		return reservationList;
	}
	
	@Override
	public List<ReservationVO> selectReservationForReview(String user_id, int cafe_id, int orderAndReservation_id) {
		// TODO Auto-generated method stub
		Map searchMap = new HashMap();
		searchMap.put("user_id",user_id);
		searchMap.put("cafe_id",cafe_id);
		searchMap.put("order_id",orderAndReservation_id);

		List<ReservationVO> reservationList = sqlSession.selectList("mapper.reservation.selectReservationForReview",searchMap);
		return reservationList;
	}

	@Override
	public ReservationVO selectOneReservation(int reservation_id) {
		// TODO Auto-generated method stub
		ReservationVO reservation = (ReservationVO) sqlSession.selectOne("mapper.reservation.selectReservationByCafeId", reservation_id);
		return reservation;
	}

	@Override
	public void updateReservation(ReservationVO reservation) {
		// TODO Auto-generated method stub
		sqlSession.update("mapper.reservation.updateReservation",reservation);
	}

	@Override
	public void deleteReservation(int reservation_id) {
		// TODO Auto-generated method stub
		sqlSession.delete("mapper.reservation.deleteReservation",reservation_id);
	}

	@Override
	public void updateReservationState(int reservation_id, String reservation_state) {
		// TODO Auto-generated method stub
		ReservationVO reservation = new ReservationVO(reservation_id,reservation_state);
		sqlSession.update("mapper.reservation.updateReservationState",reservation);
	}

	
	
}
