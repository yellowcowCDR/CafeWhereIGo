package com.ubo.CafeWhereIGo.orderAndReservation.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.ubo.CafeWhereIGo.orderAndReservation.goodsOrder.vo.GoodsOrderVO;
import com.ubo.CafeWhereIGo.orderAndReservation.reservation.vo.ReservationVO;

public interface OrderAndReservationController {

	public ModelAndView orderAndReservationForm(HttpServletRequest request, HttpServletResponse response) throws Exception;
	public ModelAndView registerOrderAndReservation(int numberOfGoods, int numberOfGroupSeat, HttpServletRequest request,
			HttpServletResponse response) throws Exception;
	public ModelAndView orderDetail(@RequestParam("orderAndReservation_id") int orderAndReservation_id, HttpServletRequest request, HttpServletResponse response) throws Exception;
	public ResponseEntity orderAndReservationDelete(@RequestParam("orderAndReservation_id") int orderAndReservation_id, HttpServletRequest request, HttpServletResponse response) throws Exception;
	public ResponseEntity goodsOrderModify(@ModelAttribute GoodsOrderVO goodsOrder, HttpServletRequest request, HttpServletResponse response) throws Exception;
	public ResponseEntity goodsOrderDelete(@RequestParam("order_id") int order_id, HttpServletRequest request, HttpServletResponse response) throws Exception;
	public ResponseEntity reservationModify(@ModelAttribute ReservationVO reservation, HttpServletRequest request, HttpServletResponse response) throws Exception;
	public ResponseEntity reservationDelete(@RequestParam("reservation_id") int reservation_id, HttpServletRequest request, HttpServletResponse response) throws Exception;
	ResponseEntity orderAndReservationCancel(@RequestParam("orderAndReservation_id") int orderAndReservation_id, HttpServletRequest request,
			HttpServletResponse response) throws Exception; 
	ResponseEntity goodsOrderCancel(@RequestParam("order_id") int order_id, HttpServletRequest request,
			HttpServletResponse response) throws Exception; 
	ResponseEntity reservationCancel(@RequestParam("reservation_id") int reservation_id, HttpServletRequest request,
			HttpServletResponse response) throws Exception; 
}
