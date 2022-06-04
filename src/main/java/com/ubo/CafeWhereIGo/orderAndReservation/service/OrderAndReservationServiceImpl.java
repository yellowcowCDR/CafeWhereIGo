package com.ubo.CafeWhereIGo.orderAndReservation.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ubo.CafeWhereIGo.orderAndReservation.dao.OrderAndReservationDAO;
import com.ubo.CafeWhereIGo.orderAndReservation.goodsOrder.dao.GoodsOrderDAO;
import com.ubo.CafeWhereIGo.orderAndReservation.goodsOrder.vo.GoodsOrderVO;
import com.ubo.CafeWhereIGo.orderAndReservation.reservation.dao.ReservationDAO;
import com.ubo.CafeWhereIGo.orderAndReservation.reservation.vo.ReservationVO;
import com.ubo.CafeWhereIGo.orderAndReservation.vo.OrderAndReservationVO;

@Transactional
@Service
public class OrderAndReservationServiceImpl implements OrderAndReservationService{
	@Autowired
	OrderAndReservationDAO orderAndReservationDAO;
	
	@Autowired
	GoodsOrderDAO goodsOrderDAO;
	
	@Autowired
	ReservationDAO reservationDAO;
	
	@Override
	public List<OrderAndReservationVO> getOrderAndReservationByCafeId(int cafe_id) {
		// TODO Auto-generated method stub
		List<OrderAndReservationVO> orderAndReservation = orderAndReservationDAO.selectOrderAndReservationByCafeId(cafe_id);
		return orderAndReservation;
	}

	@Override
	public List<OrderAndReservationVO> getOrderAndReservationByUserId(int user_id) {
		// TODO Auto-generated method stub
		List<OrderAndReservationVO> orderAndReservation = orderAndReservationDAO.selectOrderAndReservationByCafeId(user_id);
		return orderAndReservation;
	}
	
	@Override
	public void addOrderAndReservationOrderOnly(OrderAndReservationVO orderAndReservation,
			List<GoodsOrderVO> goodsOrderList) {
		// TODO Auto-generated method stub
		orderAndReservationDAO.insertOrderAndReservation(orderAndReservation);
		int orderAndReservation_id = orderAndReservationDAO.getRecentOrderAndReservationId();
		
		
	}

	@Override
	public void addOrderAndReservationReservationOnly(OrderAndReservationVO orderAndReservation,
			List<ReservationVO> reservationList) {
		// TODO Auto-generated method stub
		orderAndReservationDAO.insertOrderAndReservation(orderAndReservation);
		int orderAndReservation_id = orderAndReservationDAO.getRecentOrderAndReservationId();
	}

	@Override
	public void addOrderAndReservation(OrderAndReservationVO orderAndReservation, List<GoodsOrderVO> goodsOrderList,
			List<ReservationVO> reservationList) {
		// TODO Auto-generated method stub
		orderAndReservationDAO.insertOrderAndReservation(orderAndReservation);
		int orderAndReservation_id = orderAndReservationDAO.getRecentOrderAndReservationId();
	}

	@Override
	public void modifyOrderAndReservation(OrderAndReservationVO orderAndReservation) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void modifyOrderAndReservationOrderOnly(OrderAndReservationVO orderAndReservation,
			List<GoodsOrderVO> goodsOrderList) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void modifyOrderAndReservationReservationOnly(OrderAndReservationVO orderAndReservation,
			List<ReservationVO> reservationList) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteOrderAndReservation(int cafe_id) {
		// TODO Auto-generated method stub
		
	}
}
