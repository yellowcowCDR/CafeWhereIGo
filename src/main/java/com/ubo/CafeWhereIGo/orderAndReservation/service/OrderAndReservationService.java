package com.ubo.CafeWhereIGo.orderAndReservation.service;

import java.text.ParseException;
import java.util.List;
import java.util.Map;

import com.ubo.CafeWhereIGo.orderAndReservation.goodsOrder.vo.GoodsOrderVO;
import com.ubo.CafeWhereIGo.orderAndReservation.reservation.vo.ReservationVO;
import com.ubo.CafeWhereIGo.orderAndReservation.vo.OrderAndReservationVO;

public interface OrderAndReservationService {
	// OrderAndReservation
	public List<OrderAndReservationVO> getOrderAndReservationByCafeId(int cafe_id);
	public List<OrderAndReservationVO> getOrderAndReservationByUserId(String user_id);
	public List<Map> getOrderAndReservationForCafeDetail(String user_id, int cafe_id) throws ParseException;
	public OrderAndReservationVO getOrderAndReservationByOrderId(int orderAndReservation_id);
	public void addOrderAndReservationOrderOnly(OrderAndReservationVO orderAndReservation, List<GoodsOrderVO> goodsOrderList, int mileageScore);
	public void addOrderAndReservationReservationOnly(OrderAndReservationVO orderAndReservation, List<ReservationVO> reservationList, int mileageScore);
	public void addOrderAndReservation(OrderAndReservationVO orderAndReservation, List<GoodsOrderVO> goodsOrderList, List<ReservationVO> reservationList, int mileageScore);
	public void modifyOrderAndReservation(int orderAndReservation_id);
	public void modifyOrderAndReservationOrderOnly(int orderAndReservation_id, List<GoodsOrderVO> goodsOrderList);
	public void modifyOrderAndReservationReservationOnly(int orderAndReservation_id, List<ReservationVO> reservationList);
	public void deleteOrderAndReservation(int order_id);
	public void deleteOrderAndReservationByCafeId(int cafe_id);
	public void cancelOrderAndReservation(int orderAndReservation_id);
	
	//Order
	public List<GoodsOrderVO> getGoodsOrderListByUserId(String user_id);
	public List<GoodsOrderVO> getGoodsOrderListByUserIdAndOrderId(String user_id, int orderAndReservation_id);
	public List<GoodsOrderVO> getGoodsOrderListByOrderId(int orderAndReservation_id);
	public void modifyGoodsOrder(GoodsOrderVO goodsOrder);
	public void deleteGoodsOrder(int order_id);
	public void cancelGoodsOrder(int order_id);
	
	//Reservation
	public List<ReservationVO> getReservationListByUserId(String user_id);
	public List<ReservationVO> getReservationListByUserIdAndOrderId(String user_id, int orderAndReservation_id);
	public List<ReservationVO> getReservationListByOrderId(int orderAndReservation_id);
	public void modifyReservation(ReservationVO reservation);
	public void deleteReservation(int reservation_id);
	public void cancelReservation(int reservation_id);
}
