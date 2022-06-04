package com.ubo.CafeWhereIGo.orderAndReservation.controller;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.ubo.CafeWhereIGo.cafe.goods.service.GoodsService;
import com.ubo.CafeWhereIGo.cafe.goods.vo.GoodsVO;
import com.ubo.CafeWhereIGo.orderAndReservation.goodsOrder.vo.GoodsOrderVO;
import com.ubo.CafeWhereIGo.orderAndReservation.reservation.vo.ReservationVO;
import com.ubo.CafeWhereIGo.user.vo.UserVO;

//@Controller("orderAndReservationController")
@Controller
public class OrderAndReservationControllerImpl implements OrderAndReservationController{
	Logger logger = LoggerFactory.getLogger(OrderAndReservationControllerImpl.class);
	@Autowired
	GoodsService goodsService;
	
	@RequestMapping(value= "/orderAndReservation/orderAndReservationForm.do" ,method={RequestMethod.POST,RequestMethod.GET})
	public ModelAndView orderAndReservationForm(HttpServletRequest request, HttpServletResponse response) throws Exception{
		request.setCharacterEncoding("utf-8");
		
		ModelAndView mav=new ModelAndView();
		//get User Session
		HttpSession loginSession = request.getSession();
		UserVO userInfo = (UserVO) loginSession.getAttribute("loginSession");
		String user_id = userInfo.getUser_id();
		
		//get cafe id
		int cafe_id = Integer.parseInt(request.getParameter("cafe_id"));
		
		//init Goods Order
		int numOfGoodsOrder=0;
		String numOfGoodsOrderStr= request.getParameter("numberOfGoods");
		if(numOfGoodsOrderStr != null && !numOfGoodsOrderStr.equals("")) {
			numOfGoodsOrder = Integer.parseInt(numOfGoodsOrderStr);
		
			List<GoodsOrderVO> orderList = new ArrayList<GoodsOrderVO>();
			for(int i=1; i<=numOfGoodsOrder; i++) {
				int goods_id = Integer.parseInt(request.getParameter("goods_id"+i));
				logger.debug("[@OrderAndReservationControllerImpl, orderAndReservationForm] goods_id: "+goods_id);
				GoodsVO goods = goodsService.getOneGoods(goods_id);
				logger.debug("[@OrderAndReservationControllerImpl, orderAndReservationForm] goods is null?: "+(goods==null));		
				String goods_name = goods.getGoods_name();
				int price = goods.getPrice();
				String goods_description_temp= goods.getDescription();
				String[] goods_description = goods_description_temp.split("\r\n");
				int quantity = Integer.parseInt(request.getParameter("quantity"+i));
				boolean isTakeout = Boolean.parseBoolean(request.getParameter("is_takeout"+i));
				int totalPrice = Integer.parseInt(request.getParameter("totalPrice"+i));
				String orderState = "completed";
				GoodsOrderVO order = new GoodsOrderVO(goods_id, goods_name, price, goods_description, quantity, isTakeout, orderState, user_id, cafe_id);
				orderList.add(order);
			}
			mav.addObject("orderList", orderList);
		}
		
		int numOfReservation;
		String numOfReservationStr= request.getParameter("numberOfReservation");
		if(numOfReservationStr != null && !numOfReservationStr.equals("")) {
			numOfReservation = Integer.parseInt(numOfReservationStr);
			List<ReservationVO> reservationList = new ArrayList<ReservationVO>();
			for(int i=1; i<=numOfGoodsOrder; i++) {
				int seat_id = Integer.parseInt(request.getParameter("seat_id"+i));
				String dateStr = request.getParameter("reservation_date"+i);
				LocalDate dateTemp = LocalDate.parse(dateStr);
				Date reservation_date = java.sql.Date.valueOf(dateTemp);
				String start_time = request.getParameter("start_time"+i);
				String end_time = request.getParameter("end_time"+i);
				String reservationState = "completed";
				ReservationVO reservation = new ReservationVO(seat_id, reservation_date, start_time, end_time, reservationState, cafe_id, user_id);
				reservationList.add(reservation);
			}
			mav.addObject("reservationList", reservationList);
		}
		
		String viewName = "/orderAndReservation/orderAndReservationForm";
		mav.setViewName(viewName);
		return mav;
	}

	
	
}
