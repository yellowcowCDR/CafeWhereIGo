package com.ubo.CafeWhereIGo.orderAndReservation.dao;

import java.util.List;

import com.ubo.CafeWhereIGo.orderAndReservation.vo.OrderAndReservationVO;

public interface OrderAndReservationDAO {
	public void insertOrderAndReservation(OrderAndReservationVO orderAndReservation);

	public List<OrderAndReservationVO> selectOrderAndReservationByCafeId(int cafe_id);
	
	public List<OrderAndReservationVO> selectOrderAndReservationByUserId(String user_id);

	public void updateOrderAndReservation(OrderAndReservationVO orderAndReservation);

	public void deleteOrderAndReservation(int orderAndReservation_id);

	public int getRecentOrderAndReservationId();
}
