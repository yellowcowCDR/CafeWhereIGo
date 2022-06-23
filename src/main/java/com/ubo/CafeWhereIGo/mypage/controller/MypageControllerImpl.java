package com.ubo.CafeWhereIGo.mypage.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

import com.ubo.CafeWhereIGo.cafe.cafe.service.CafeService;
import com.ubo.CafeWhereIGo.cafe.cafe.vo.CafeSearchResultVO;
import com.ubo.CafeWhereIGo.cafe.goods.service.GoodsService;
import com.ubo.CafeWhereIGo.cafe.goods.vo.GoodsVO;
import com.ubo.CafeWhereIGo.cafe.groupseat.service.GroupSeatService;
import com.ubo.CafeWhereIGo.cafe.groupseat.vo.GroupSeatVO;
import com.ubo.CafeWhereIGo.cart.cart.service.CartService;
import com.ubo.CafeWhereIGo.cart.goodsCart.vo.GoodsCartSearchResultVO;
import com.ubo.CafeWhereIGo.cart.groupSeatCart.vo.GroupSeatCartSearchResultVO;
import com.ubo.CafeWhereIGo.orderAndReservation.goodsOrder.vo.GoodsOrderVO;
import com.ubo.CafeWhereIGo.orderAndReservation.reservation.vo.ReservationVO;
import com.ubo.CafeWhereIGo.orderAndReservation.service.OrderAndReservationService;
import com.ubo.CafeWhereIGo.orderAndReservation.vo.OrderAndReservationVO;
import com.ubo.CafeWhereIGo.user.user.vo.UserVO;

@Controller("mypageController")
public class MypageControllerImpl {
	Logger logger  =  LoggerFactory.getLogger(MypageControllerImpl.class);
	@Autowired
	CartService cartService;
	
	@Autowired
	OrderAndReservationService orderAndReservationService;
	
	@Autowired
	CafeService cafeService;
	
	@Autowired
	GoodsService goodsService;
	
	@Autowired
	GroupSeatService groupSeatService; 
	
	@RequestMapping(value= "/mypage/userinfo.do" ,method={RequestMethod.POST,RequestMethod.GET})
	public ModelAndView loginform(HttpServletRequest request, HttpServletResponse response) throws Exception{
		ModelAndView mav=new ModelAndView();
		String viewName = "/mypage/userinfo";
		mav.setViewName(viewName);
		
		return mav;
	}
	@RequestMapping(value= "/mypage/wishlist.do" ,method={RequestMethod.POST,RequestMethod.GET})
	public ModelAndView wishlist(HttpServletRequest request, HttpServletResponse response) throws Exception{
		ModelAndView mav=new ModelAndView();
		
		HttpSession loginSession = request.getSession();
		UserVO userInfo = (UserVO)loginSession.getAttribute("loginSession");
		
		if(userInfo !=null) {
			String user_id = userInfo.getUser_id();
			List<CafeSearchResultVO> likedCafeList = cafeService.selectLikeCafeList(user_id);
			mav.addObject("likedCafeList", likedCafeList);
		}
		String viewName = "/mypage/wishlist";
		mav.setViewName(viewName);
		
		return mav;
	}
	
	@RequestMapping(value= "/mypage/cartList.do" ,method={RequestMethod.POST,RequestMethod.GET})
	public ModelAndView reservationlist(HttpServletRequest request, HttpServletResponse response) throws Exception{
		HttpSession loginSession = request.getSession();
		UserVO userInfo = (UserVO)loginSession.getAttribute("loginSession");
		String user_id = userInfo.getUser_id();
		
		int orderAndReservationPrice=0;
		
		List<GoodsCartSearchResultVO> goodsCartList = cartService.getGoodsCartListbyUserId(user_id);
		for(int i=0; i<goodsCartList.size();i++) {
			GoodsCartSearchResultVO goodsSearchResult = goodsCartList.get(i);
			int goodsTotalPrice = goodsSearchResult.getPrice()*goodsSearchResult.getQuantity();
			orderAndReservationPrice+= goodsTotalPrice;
		}
		List<GroupSeatCartSearchResultVO> groupSeatCartList = cartService.getGroupSeatCartListbyUserId(user_id);
		for(int j=0; j<groupSeatCartList.size();j++) {
			GroupSeatCartSearchResultVO groupSeatSearchResult = groupSeatCartList.get(j);
			orderAndReservationPrice+= groupSeatSearchResult.getTotalPrice();
		}
		
		ModelAndView mav=new ModelAndView();
		String viewName = "/mypage/cartList";
		mav.setViewName(viewName);
		mav.addObject("goodsCartList",goodsCartList);
		mav.addObject("groupSeatCartList",groupSeatCartList);
		mav.addObject("allTotalPrice", orderAndReservationPrice);
		return mav;
	}
	@RequestMapping(value= "/mypage/orderReservationList.do" ,method={RequestMethod.POST,RequestMethod.GET})
	public ModelAndView orderlist(HttpServletRequest request, HttpServletResponse response) throws Exception{
	
		HttpSession loginSession = request.getSession();
		UserVO userInfo = (UserVO)loginSession.getAttribute("loginSession");		
		String user_id = userInfo.getUser_id();
		
		List<Map> orderMapList= new ArrayList<Map>();
		
		//get Goods And Reservation List
		List<OrderAndReservationVO> orderAndReservationList = orderAndReservationService.getOrderAndReservationByUserId(user_id);  
		for(int i=0; i<orderAndReservationList.size(); i++) {
			OrderAndReservationVO orderAndReservation = orderAndReservationList.get(i);
			int orderAndReservation_id = orderAndReservation.getOrderAndReservation_id();
			Date orderDate = orderAndReservation.getCreated_date();
			String dateStrTest = orderDate.toString();
			logger.debug("[@MypageControllerImpl, orderlist] order date: "+ dateStrTest);
			
			List<GoodsOrderVO> goodsOrderList = orderAndReservationService.getGoodsOrderListByUserIdAndOrderId(user_id, orderAndReservation_id);
			List<ReservationVO> reservationList = orderAndReservationService.getReservationListByUserIdAndOrderId(user_id, orderAndReservation_id);
			
			Map orderMap = new HashMap();
			int numberOfOrder =0;
			int orderPrice=0;
			orderMap.put("order_id", orderAndReservation_id);
			if(goodsOrderList != null && goodsOrderList.size()>0) {
				orderMap.put("goodsOrderList", goodsOrderList);
				for(int j=0;j<goodsOrderList.size();j++) {
					GoodsOrderVO order =goodsOrderList.get(j);
					int goods_id = order.getGoods_goods_id();
					GoodsVO goods = goodsService.getOneGoods(goods_id);
					int unitPrice = goods.getPrice();
					int quantity = order.getOrder_quantity();
					orderPrice+=unitPrice*quantity;
				}
				numberOfOrder += goodsOrderList.size();
			}
			if(reservationList != null && reservationList.size()>0) {
				orderMap.put("reservationList", reservationList);
				for(int j=0;j<reservationList.size();j++) {
					ReservationVO reservation = reservationList.get(j);
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
					orderPrice += totalPrice;
					//orderPrice+=reservationList.get(j).getTotalPrice();
				}
				numberOfOrder += reservationList.size();
//				logger.debug("[@MypageControllerImpl, orderlist]"+"orderAndReservation_id: "+orderAndReservation_id+"reservation representedOrderName: "+ representedOrderName);
			}
			
			String representedOrderName="상품없음";
			
			if(goodsOrderList != null && goodsOrderList.size()>0) {
				GoodsOrderVO goodsOrder= goodsOrderList.get(0);
				int goods_id = goodsOrder.getGoods_goods_id();
				GoodsVO goods = goodsService.getOneGoods(goods_id);
				representedOrderName = goods.getGoods_name();
				logger.debug("[@MypageControllerImpl, orderlist] goodsOrder representedOrderName: "+ representedOrderName);
				if (numberOfOrder!=1){
					representedOrderName += " 외 "+(numberOfOrder-1)+"건";
				}
				
			}else if(reservationList != null && reservationList.size()>0) {
				ReservationVO reservation = reservationList.get(0);
				int groupSeat_id = reservation.getGroupseat_groupseat_id();
				GroupSeatVO groupSeat = groupSeatService.getOneGroupSeat(groupSeat_id);
				representedOrderName = groupSeat.getSeat_name();
				
				logger.debug("[@MypageControllerImpl, orderlist] reservation representedOrderName: "+ representedOrderName);
				if (numberOfOrder!=1){
					representedOrderName += " 외 "+(numberOfOrder-1)+"건";
				}
			}
			orderMap.put("order_id", orderAndReservation.getOrderAndReservation_id());
			orderMap.put("orderStatus",orderAndReservation.getOrder_status());
			orderMap.put("orderDate",orderAndReservation.getCreated_date());
			orderMap.put("representedOrderName",representedOrderName);
			orderMap.put("totalPrice", orderPrice);
			orderMapList.add(orderMap);
		}
		//get Goods Name
		//if Goods not exist, get Group Seat Name
		//get Number of Goods and Group Seat 
		//카페명 칼럼 삭제 
		//get total price(discount included)
		//get order date and time
		//order state
		ModelAndView mav=new ModelAndView();
		String viewName = "/mypage/orderReservationList";
		mav.setViewName(viewName);
		mav.addObject("orderMapList", orderMapList);
		return mav;
	}
	
	
	
}
