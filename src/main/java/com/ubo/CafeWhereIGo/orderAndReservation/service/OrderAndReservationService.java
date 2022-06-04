package com.ubo.CafeWhereIGo.orderAndReservation.service;

import java.util.List;

import com.ubo.CafeWhereIGo.orderAndReservation.goodsOrder.vo.GoodsOrderVO;
import com.ubo.CafeWhereIGo.orderAndReservation.reservation.vo.ReservationVO;
import com.ubo.CafeWhereIGo.orderAndReservation.vo.OrderAndReservationVO;

public interface OrderAndReservationService {
	List<OrderAndReservationVO> getOrderAndReservationByCafeId(int cafe_id);
	
	List<OrderAndReservationVO> getOrderAndReservationByUserId(int user_id);
	
	void addOrderAndReservationOrderOnly(OrderAndReservationVO orderAndReservation, List<GoodsOrderVO> goodsOrderList);
	
	void addOrderAndReservationReservationOnly(OrderAndReservationVO orderAndReservation, List<ReservationVO> reservationList);
	
	void addOrderAndReservation(OrderAndReservationVO orderAndReservation, List<GoodsOrderVO> goodsOrderList, List<ReservationVO> reservationList);
	
	void modifyOrderAndReservationOrderOnly(OrderAndReservationVO orderAndReservation, List<GoodsOrderVO> goodsOrderList);
	
	void modifyOrderAndReservationReservationOnly(OrderAndReservationVO orderAndReservation, List<ReservationVO> reservationList);
	
	void modifyOrderAndReservation(OrderAndReservationVO orderAndReservation);

	void deleteOrderAndReservation(int cafe_id);
}
