package com.ubo.CafeWhereIGo.orderAndReservation.dao;

import java.util.List;
import java.util.Map;

import com.ubo.CafeWhereIGo.orderAndReservation.vo.OrderAndReservationVO;

public interface OrderAndReservationDAO {
	public void insertOrderAndReservation(OrderAndReservationVO orderAndReservation);

	public List<OrderAndReservationVO> selectOrderAndReservationByCafeId(int cafe_id);
	
	public List<OrderAndReservationVO> selectOrderAndReservationByUserId(String user_id);
	
	public OrderAndReservationVO selectOrderAndReservationByOrderId(int orderAndReservation_id);
	
	public void updateOrderAndReservation(OrderAndReservationVO orderAndReservation);

	public void deleteOrderAndReservation(int orderAndReservation_id);
	
	public void updateOrderAndReservationStatus(int orderAndReservation_id, String order_status);
	
	public int getRecentOrderAndReservationId();
}
