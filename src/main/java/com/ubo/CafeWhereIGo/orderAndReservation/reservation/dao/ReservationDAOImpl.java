package com.ubo.CafeWhereIGo.orderAndReservation.reservation.dao;

import java.util.List;

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
	public List<ReservationVO> selectReservationByCafeId(int cafe_id) {
		// TODO Auto-generated method stub
		List<ReservationVO> reservationList = sqlSession.selectList("mapper.reservation.selectReservationByCafeId",cafe_id);
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
}
