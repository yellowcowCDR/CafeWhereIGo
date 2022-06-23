package com.ubo.CafeWhereIGo.orderAndReservation.controller;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.ubo.CafeWhereIGo.cafe.goods.service.GoodsService;
import com.ubo.CafeWhereIGo.cafe.goods.vo.GoodsVO;
import com.ubo.CafeWhereIGo.cafe.groupseat.service.GroupSeatService;
import com.ubo.CafeWhereIGo.cafe.groupseat.vo.GroupSeatVO;
import com.ubo.CafeWhereIGo.orderAndReservation.goodsOrder.vo.GoodsOrderVO;
import com.ubo.CafeWhereIGo.orderAndReservation.reservation.vo.ReservationVO;
import com.ubo.CafeWhereIGo.orderAndReservation.service.OrderAndReservationService;
import com.ubo.CafeWhereIGo.orderAndReservation.vo.OrderAndReservationVO;
import com.ubo.CafeWhereIGo.user.user.service.UserService;
import com.ubo.CafeWhereIGo.user.user.vo.UserVO;

//@Controller("orderAndReservationController")
@Controller
public class OrderAndReservationControllerImpl implements OrderAndReservationController{
	Logger logger = LoggerFactory.getLogger(OrderAndReservationControllerImpl.class);
	@Autowired
	GoodsService goodsService;
	
	@Autowired
	GroupSeatService groupSeatService;
	
	@Autowired
	OrderAndReservationService orderAndReservationService;
	
	@Autowired
	UserService userService;
	
	@Override
	@RequestMapping(value= "/orderAndReservation/orderAndReservationForm.do" ,method={RequestMethod.POST,RequestMethod.GET})
	public ModelAndView orderAndReservationForm(HttpServletRequest request, HttpServletResponse response) throws Exception{
		request.setCharacterEncoding("utf-8");
		
		ModelAndView mav=new ModelAndView();
		int orderAndReservationPrice=0;
		
		//get User Session
		HttpSession loginSession = request.getSession();
		UserVO userInfo = (UserVO) loginSession.getAttribute("loginSession");
		String user_id = userInfo.getUser_id();
		
		//init Goods Order
		int numOfGoodsOrder=0;
		String numOfGoodsOrderStr= request.getParameter("numberOfGoods");
		logger.debug("[@OrderAndReservationControllerImpl, orderAndReservationForm] numberOfGoodsStr is null?: "+(numOfGoodsOrderStr==null));
		logger.debug("[@OrderAndReservationControllerImpl, orderAndReservationForm] numberOfGoodsStr?: "+numOfGoodsOrderStr);
		if(numOfGoodsOrderStr != null && !numOfGoodsOrderStr.equals("")) {
			numOfGoodsOrder = Integer.parseInt(numOfGoodsOrderStr);
			logger.debug("[@OrderAndReservationControllerImpl, orderAndReservationForm] numberOfGoods: "+numOfGoodsOrder);
			List<GoodsOrderVO> orderList = new ArrayList<GoodsOrderVO>();
			for(int i=1; i<=numOfGoodsOrder; i++) {
				//get cafe id
				int cafe_id = Integer.parseInt(request.getParameter("goods_cafe_id"+1));
				int goods_id = Integer.parseInt(request.getParameter("goods_id"+i));
				logger.debug("[@OrderAndReservationControllerImpl, orderAndReservationForm] goods_id: "+goods_id);
				GoodsVO goods = goodsService.getOneGoods(goods_id);
				logger.debug("[@OrderAndReservationControllerImpl, orderAndReservationForm] goods is null?: "+(goods==null));		
				String goods_name = goods.getGoods_name();
				int price = goods.getPrice();
				String goods_description_temp= goods.getDescription();
				String[] goods_description = goods_description_temp.split("\r\n");
				int quantity = Integer.parseInt(request.getParameter("quantity"+i));
				boolean isTakeout = Boolean.parseBoolean(request.getParameter("isTakeout"+i));
				int unitTotalPrice = price*quantity;
				String orderState = "completed";
				GoodsOrderVO order = new GoodsOrderVO(goods_id, goods_name, price, goods_description, quantity, isTakeout, orderState, user_id, cafe_id);
				orderList.add(order);
				orderAndReservationPrice+=unitTotalPrice;
			}
			mav.addObject("orderList", orderList);
		}
		
		int numOfReservation;
		String numOfReservationStr= request.getParameter("numberOfReservation");
		logger.debug("numOfReservationStr: "+numOfReservationStr);
		if(numOfReservationStr != null && !numOfReservationStr.equals("")) {
			numOfReservation = Integer.parseInt(numOfReservationStr);
			List<ReservationVO> reservationList = new ArrayList<ReservationVO>();
			for(int i=1; i<=numOfReservation; i++) {
				int cafe_id = Integer.parseInt(request.getParameter("groupSeat_cafe_id"+1));
				int seat_id = Integer.parseInt(request.getParameter("seat_id"+i));
				logger.debug("[@OrderAndReservationControllerImpl, orderAndReservationForm] cafe_id: "+cafe_id);
				logger.debug("[@OrderAndReservationControllerImpl, orderAndReservationForm] seat_id: "+seat_id);
				GroupSeatVO groupseat = groupSeatService.getOneGroupSeat(seat_id);
				String seat_name = groupseat.getSeat_name();
				String dateStr = request.getParameter("reservation_date"+i);
				LocalDate dateTemp = LocalDate.parse(dateStr);
				Date reservation_date = java.sql.Date.valueOf(dateTemp);
				String start_time = request.getParameter("start_time"+i);
				String end_time = request.getParameter("end_time"+i);
				
				String start_dateStr = dateStr + " " + start_time;
				String end_dateStr = dateStr + " " + end_time;
				
				SimpleDateFormat dateTimeFmt = new SimpleDateFormat("yyyy-MM-dd HH:mm");
				java.util.Date start_date = dateTimeFmt.parse(start_dateStr);
				java.util.Date end_date = dateTimeFmt.parse(end_dateStr);
				
				long timeDiff = end_date.getTime() - start_date.getTime();
				long timeDiffToMinute = Math.round((double)timeDiff/(60*1000));

				int unitPrice = Integer.parseInt(request.getParameter("unitPrice"+i));
				double unitPricePerMinute = (double)unitPrice/60;
				
				int totalPrice = (int)(unitPricePerMinute*timeDiffToMinute);
				orderAndReservationPrice += totalPrice;
				String reservationState = "completed";
				ReservationVO reservation = new ReservationVO(seat_id, seat_name, reservation_date, start_time, end_time, unitPrice, totalPrice, reservationState, user_id, cafe_id);
				reservationList.add(reservation);
			}
			mav.addObject("reservationList", reservationList);
		}
		
		mav.addObject("allTotalPrice", orderAndReservationPrice);
		
		int user_mileage= userService.getMileage(user_id);
		mav.addObject("user_mileage", user_mileage);
		
		String viewName = "/orderAndReservation/orderAndReservationForm";
		mav.setViewName(viewName);
		return mav;
	}
	
	@Override
	@RequestMapping(value= "/orderAndReservation/registerOrderAndReservation.do" ,method={RequestMethod.POST})
	public ModelAndView registerOrderAndReservation(@RequestParam("numberOfGoods") int numberOfGoods, @RequestParam("numberOfReservation") int numberOfGroupSeat, HttpServletRequest request, HttpServletResponse response) throws Exception{
		//get User Session
		HttpSession loginSession = request.getSession();
		UserVO userInfo = (UserVO) loginSession.getAttribute("loginSession");
		String user_id = userInfo.getUser_id();
		
		
		
		//get order list
		List<GoodsOrderVO> goodsOrderList = new ArrayList<GoodsOrderVO>(); 
		for(int i=1; i<=numberOfGoods;i++) {
			int cafe_id = Integer.parseInt(request.getParameter("goods_cafe_id"+i));
			int goods_id = Integer.parseInt(request.getParameter("goods_id"+i));
			int quantity = Integer.parseInt(request.getParameter("quantity"+i));
			boolean isTakeout = Boolean.parseBoolean(request.getParameter("isTakeout"+i));
			String order_state = "complete";
			GoodsOrderVO goodsOrder = new GoodsOrderVO(goods_id, quantity, isTakeout, order_state, user_id, cafe_id);
			goodsOrderList.add(goodsOrder);
		}
		
		//get reservation list
		List<ReservationVO> reservationList = new ArrayList<ReservationVO>(); 
		for(int i=1; i<=numberOfGroupSeat;i++) {
			int cafe_id = Integer.parseInt(request.getParameter("groupSeat_cafe_id"+i));
			int seat_id=Integer.parseInt(request.getParameter("seat_id"+i));;
			String dateStr = request.getParameter("reservation_date"+i);
			LocalDate dateTemp = LocalDate.parse(dateStr);
			Date reservation_date = java.sql.Date.valueOf(dateTemp);
			String start_time=request.getParameter("start_time"+i);
			String end_time=request.getParameter("end_time"+i);
			
			logger.debug("[@OrderAndReservationControllerImpl, orderAndReservationForm] @Register reservation user_id: "+user_id);
			
			String reservation_state = "complete";
			ReservationVO reservation = new ReservationVO(seat_id, reservation_date, start_time, end_time, reservation_state, user_id, cafe_id);
			reservationList.add(reservation);
		}
		
		int mileageScore=0;
		
		//get Mileage Info
		boolean isMileageAdd = Boolean.parseBoolean(request.getParameter("isMileageAdd"));
		if(isMileageAdd) {
			double mileageToAddTemp = Double.parseDouble(request.getParameter("mileageToAdd"));
			int mileageToAdd = (int)Math.round(mileageToAddTemp);
			mileageScore=mileageToAdd;
		}else {
			double mileageToUseTemp = Double.parseDouble(request.getParameter("mileageToUse"));
			int mileageToUse = (int)Math.round(mileageToUseTemp);
			mileageScore= -(mileageToUse);
		}
		
		//process Order And Reservation
		OrderAndReservationVO orderAndReservation = new OrderAndReservationVO(user_id,"completed");
		
		if(numberOfGoods>0 && numberOfGroupSeat>0) {
			orderAndReservationService.addOrderAndReservation(orderAndReservation, goodsOrderList, reservationList, mileageScore);
		}else if(numberOfGoods>0) {
			orderAndReservationService.addOrderAndReservationOrderOnly(orderAndReservation, goodsOrderList, mileageScore);
		}else if(numberOfGroupSeat>0) {
			orderAndReservationService.addOrderAndReservationReservationOnly(orderAndReservation, reservationList, mileageScore);
		}
		
		
		
		ModelAndView mav= new ModelAndView();
		mav.setViewName("/main/main");
		List<String> msgList = new ArrayList<String>();
		msgList.add("numberOfGoods: "+numberOfGoods);
		msgList.add("numberOfGroupSeat: "+numberOfGroupSeat);
		msgList.add("주문이 완료되었습니다");
		mav.addObject("msgList", msgList);
		return mav;
	}

	@Override
	@RequestMapping(value= "/orderAndReservation/OrderAndReservationDetail.do" ,method={RequestMethod.GET})
	public ModelAndView orderDetail(@RequestParam("orderAndReservation_id") int orderAndReservation_id, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		ModelAndView mav = new ModelAndView();
		
		OrderAndReservationVO orderAndReservation = orderAndReservationService.getOrderAndReservationByOrderId(orderAndReservation_id);
		
		int orderAndReservationPrice=0;
		
		List<GoodsOrderVO> goodsOrderList = orderAndReservationService.getGoodsOrderListByOrderId(orderAndReservation_id);
		if(goodsOrderList !=null) {
			Iterator<GoodsOrderVO> goodsOrderListIt= goodsOrderList.iterator();
			while(goodsOrderListIt.hasNext()) {
				GoodsOrderVO goodsOrder = goodsOrderListIt.next();
				int goods_id = goodsOrder.getGoods_goods_id();
				GoodsVO goods= goodsService.getOneGoods(goods_id);
				String goods_name = goods.getGoods_name();
				int price = goods.getPrice();
				String goods_description_temp= goods.getDescription();
				String[] goods_description = goods_description_temp.split("\r\n");
				int quantity = goodsOrder.getOrder_quantity();
				boolean isTakeout = goodsOrder.is_takeout();
				int unitTotalPrice = price*quantity;
				if(goodsOrder.getOrder_state().equals("complete")) {
					orderAndReservationPrice+=unitTotalPrice;
				}
				goodsOrder.setGoods_name(goods_name);
				goodsOrder.setGoods_price(price);
				goodsOrder.setGoods_description(goods_description);
			}
			mav.addObject("orderList", goodsOrderList);
		}
		
		
		List<ReservationVO> reservationList = orderAndReservationService.getReservationListByOrderId(orderAndReservation_id);
		if(reservationList!=null) {
			Iterator<ReservationVO> reservationListIt= reservationList.iterator();
			while(reservationListIt.hasNext()) {
				ReservationVO reservation = reservationListIt.next();
				int groupseat_id = reservation.getGroupseat_groupseat_id();
				GroupSeatVO groupSeat= groupSeatService.getOneGroupSeat(groupseat_id);
				String seat_name = groupSeat.getSeat_name();

				Date reservation_date = reservation.getReservation_date();
				String start_time =reservation.getStart_time();
				String end_time = reservation.getEnd_time();
				
				String start_dateStr = reservation_date + " " + start_time;
				String end_dateStr = reservation_date + " " + end_time;
				
				SimpleDateFormat dateTimeFmt = new SimpleDateFormat("yyyy-MM-dd HH:mm");
				java.util.Date start_date = dateTimeFmt.parse(start_dateStr);
				java.util.Date end_date = dateTimeFmt.parse(end_dateStr);
				
				long timeDiff = end_date.getTime() - start_date.getTime();
				long timeDiffToMinute = Math.round((double)timeDiff/(60*1000));

				int unitPrice = groupSeat.getPrice();
				double unitPricePerMinute = (double)unitPrice/60;
				
				int totalPrice = (int)(unitPricePerMinute*timeDiffToMinute);
				if(reservation.getReservation_state().equals("complete")) {
					orderAndReservationPrice += totalPrice;
				}
				reservation.setSeat_name(seat_name);
				reservation.setUnitPrice(unitPrice);
				reservation.setTotalPrice(totalPrice);
			}
			mav.addObject("reservationList", reservationList);
		}
		
		mav.addObject("allTotalPrice", orderAndReservationPrice);
		
		HttpSession loginSession = request.getSession();
		UserVO userInfo = (UserVO)loginSession.getAttribute("loginSession");
		String user_id =userInfo.getUser_id();
		int user_mileage= userService.getMileage(user_id);
		mav.addObject("user_mileage", user_mileage);
		
		String viewName = "/orderAndReservation/orderAndReservationDetail";
		mav.setViewName(viewName);

		return mav;
	}

	@Override
	@RequestMapping(value= "/orderAndReservation/orderAndReservationDelete.do" ,method={RequestMethod.POST})
	public ResponseEntity orderAndReservationDelete(@RequestParam("order_id")int orderAndReservation_id, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		orderAndReservationService.deleteOrderAndReservation(orderAndReservation_id);
		return ResponseEntity.noContent().build();
	}
	@Override
	@RequestMapping(value= "/orderAndReservation/orderAndReservationCancel.do" ,method={RequestMethod.POST})
	public ResponseEntity orderAndReservationCancel(@RequestParam("orderAndReservation_id") int orderAndReservation_id, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		orderAndReservationService.cancelOrderAndReservation(orderAndReservation_id);
		return ResponseEntity.noContent().build();
	}
	@Override
	@RequestMapping(value= "/orderAndReservation/goodsOrderModify.do" ,method={RequestMethod.POST})
	public ResponseEntity goodsOrderModify(@ModelAttribute GoodsOrderVO goodsOrder, HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		// TODO Auto-generated method stub
		orderAndReservationService.modifyGoodsOrder(goodsOrder);
		return ResponseEntity.noContent().build();
	}

	@Override
	@RequestMapping(value= "/orderAndReservation/goodsOrderDelete.do" ,method={RequestMethod.POST})
	public ResponseEntity goodsOrderDelete(@RequestParam("order_id")int order_id, HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		// TODO Auto-generated method stub
		orderAndReservationService.deleteGoodsOrder(order_id);
		return ResponseEntity.noContent().build();
	}

	@Override
	@RequestMapping(value= "/orderAndReservation/reservationModify.do" ,method={RequestMethod.POST})
	public ResponseEntity reservationModify(@ModelAttribute ReservationVO reservation, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		orderAndReservationService.modifyReservation(reservation);
		return ResponseEntity.noContent().build();
	}

	@Override
	@RequestMapping(value= "/orderAndReservation/reservationDelete.do" ,method={RequestMethod.POST})
	public ResponseEntity reservationDelete(@RequestParam("reservation_id")int reservation_id, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		orderAndReservationService.deleteReservation(reservation_id);
		return ResponseEntity.noContent().build();
	}

	@Override
	@RequestMapping(value= "/orderAndReservation/goodsOrderCancel.do" ,method={RequestMethod.POST})
	public ResponseEntity goodsOrderCancel(@RequestParam("order_id") int order_id, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		orderAndReservationService.cancelGoodsOrder(order_id);
		return ResponseEntity.noContent().build();
	}

	@Override
	@RequestMapping(value= "/orderAndReservation/reservationCancel.do" ,method={RequestMethod.POST})
	public ResponseEntity reservationCancel(@RequestParam("reservation_id") int reservation_id, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		orderAndReservationService.cancelReservation(reservation_id);
		return ResponseEntity.noContent().build();
	}
	
	
	
}
