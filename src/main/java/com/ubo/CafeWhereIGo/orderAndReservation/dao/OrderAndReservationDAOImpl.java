package com.ubo.CafeWhereIGo.orderAndReservation.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ubo.CafeWhereIGo.orderAndReservation.vo.OrderAndReservationVO;

@Repository
public class OrderAndReservationDAOImpl implements OrderAndReservationDAO{
	@Autowired
	SqlSession sqlSession;

	@Override
	public void insertOrderAndReservation(OrderAndReservationVO orderAndReservation) {
		// TODO Auto-generated method stub
		sqlSession.insert("mapper.orderAndReservation.insertOrderAndReservation", orderAndReservation);
	}

	@Override
	public List<OrderAndReservationVO> selectOrderAndReservationByCafeId(int cafe_id) {
		// TODO Auto-generated method stub
		List<OrderAndReservationVO> orderAndReservationList = sqlSession.selectList("mapper.orderAndReservation.selectOrderAndReservationByCafeId",cafe_id);
		return orderAndReservationList;
	}

	@Override
	public List<OrderAndReservationVO> selectOrderAndReservationByUserId(String user_id){
		List<OrderAndReservationVO> orderAndReservationList = sqlSession.selectList("mapper.orderAndReservation.selectOrderAndReservationByUserId",user_id);
		return orderAndReservationList;
	}
	
	@Override
	public void updateOrderAndReservation(OrderAndReservationVO orderAndReservation) {
		// TODO Auto-generated method stub
		sqlSession.update("mapper.orderAndReservation.updateOrderAndReservation", orderAndReservation);
	}

	@Override
	public void deleteOrderAndReservation(int orderAndReservation_id) {
		// TODO Auto-generated method stub
		sqlSession.delete("mapper.orderAndReservation.updateOrderAndReservation", orderAndReservation_id);
	}


	@Override
	public int getRecentOrderAndReservationId() {
		// TODO Auto-generated method stub
		int orderAndReservationId = (Integer)sqlSession.selectOne("mapper.orderAndReservation.selectRecentOrderAndReservationId");
		return orderAndReservationId;
	}
	
}