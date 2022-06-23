package com.ubo.CafeWhereIGo.orderAndReservation.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ubo.CafeWhereIGo.cafe.goods.dao.GoodsDAO;
import com.ubo.CafeWhereIGo.cafe.goods.vo.GoodsVO;
import com.ubo.CafeWhereIGo.cafe.groupseat.dao.GroupSeatDAO;
import com.ubo.CafeWhereIGo.cafe.groupseat.vo.GroupSeatVO;
import com.ubo.CafeWhereIGo.orderAndReservation.dao.OrderAndReservationDAO;
import com.ubo.CafeWhereIGo.orderAndReservation.goodsOrder.dao.GoodsOrderDAO;
import com.ubo.CafeWhereIGo.orderAndReservation.goodsOrder.vo.GoodsOrderVO;
import com.ubo.CafeWhereIGo.orderAndReservation.reservation.dao.ReservationDAO;
import com.ubo.CafeWhereIGo.orderAndReservation.reservation.vo.ReservationVO;
import com.ubo.CafeWhereIGo.orderAndReservation.vo.OrderAndReservationVO;
import com.ubo.CafeWhereIGo.user.mileage.dao.MileageHistoryDAO;
import com.ubo.CafeWhereIGo.user.mileage.vo.MileageHistoryVO;
import com.ubo.CafeWhereIGo.user.user.dao.UserDAO;
import com.ubo.CafeWhereIGo.user.user.vo.UserVO;

@Transactional
@Service
public class OrderAndReservationServiceImpl implements OrderAndReservationService{
	Logger logger = LoggerFactory.getLogger(OrderAndReservationServiceImpl.class);
	@Autowired
	OrderAndReservationDAO orderAndReservationDAO;
	
	@Autowired
	GoodsOrderDAO goodsOrderDAO;
	
	@Autowired
	ReservationDAO reservationDAO;
	
	@Autowired
	GoodsDAO  goodsDAO;
	
	@Autowired
	GroupSeatDAO groupSeatDAO;
	
	@Autowired
	UserDAO userDAO;
	
	@Autowired
	MileageHistoryDAO mileageHistoryDAO;
	
	@Override
	public List<OrderAndReservationVO> getOrderAndReservationByCafeId(int cafe_id) {
		// TODO Auto-generated method stub
		List<OrderAndReservationVO> orderAndReservation = orderAndReservationDAO.selectOrderAndReservationByCafeId(cafe_id);
		return orderAndReservation;
	}

	@Override
	public List<OrderAndReservationVO> getOrderAndReservationByUserId(String user_id) {
		// TODO Auto-generated method stub
		List<OrderAndReservationVO> orderAndReservation = orderAndReservationDAO.selectOrderAndReservationByUserId(user_id);
		return orderAndReservation;
	}
	
	@Override
	public OrderAndReservationVO getOrderAndReservationByOrderId(int orderAndReservation_id) {
		// TODO Auto-generated method stub
		OrderAndReservationVO orderAndReservation = orderAndReservationDAO.selectOrderAndReservationByOrderId(orderAndReservation_id);
		return orderAndReservation;
	}

	@Override
	public void addOrderAndReservationOrderOnly(OrderAndReservationVO orderAndReservation,
			List<GoodsOrderVO> goodsOrderList, int mileageScore) {
		// TODO Auto-generated method stub
		orderAndReservationDAO.insertOrderAndReservation(orderAndReservation);
		int orderAndReservation_id = orderAndReservationDAO.getRecentOrderAndReservationId();
		
		for(int i=0; i<goodsOrderList.size(); i++) {
			GoodsOrderVO goodsOrder = goodsOrderList.get(i);
			goodsOrder.setOrderAndReservation_OrderAndReservation_id(orderAndReservation_id);
			goodsOrderDAO.insertGoodsOrder(goodsOrder);
		 }
		
		String user_id = orderAndReservation.getUser_user_id();
		
		int user_mileage = userDAO.selectMileage(user_id);
		int mileage = user_mileage-mileageScore;
		UserVO userInfo = new UserVO(user_id,mileage);
		userDAO.updateMileage(userInfo);
		
		MileageHistoryVO mileageHistory= new MileageHistoryVO(mileageScore, user_id, orderAndReservation_id);
		mileageHistoryDAO.insertMileageHistory(mileageHistory);
	}

	@Override
	public void addOrderAndReservationReservationOnly(OrderAndReservationVO orderAndReservation,
			List<ReservationVO> reservationList, int mileageScore) {
		// TODO Auto-generated method stub
		orderAndReservationDAO.insertOrderAndReservation(orderAndReservation);
		int orderAndReservation_id = orderAndReservationDAO.getRecentOrderAndReservationId();
		
		for(int i=0; i<reservationList.size(); i++) {
			ReservationVO reservation = reservationList.get(i);
			reservation.setOrderAndReservation_OrderAndReservation_id(orderAndReservation_id);
			reservationDAO.insertReservation(reservation);
		}
		 
		String user_id = orderAndReservation.getUser_user_id();

		int user_mileage = userDAO.selectMileage(user_id);
		int mileage = user_mileage-mileageScore;
		UserVO userInfo = new UserVO(user_id,mileage);
		userDAO.updateMileage(userInfo);
			
		MileageHistoryVO mileageHistory= new MileageHistoryVO(mileageScore, user_id, orderAndReservation_id);
		mileageHistoryDAO.insertMileageHistory(mileageHistory);
	}

	@Override
	public void addOrderAndReservation(OrderAndReservationVO orderAndReservation, List<GoodsOrderVO> goodsOrderList,
			List<ReservationVO> reservationList, int mileageScore) {
		// TODO Auto-generated method stub
		orderAndReservationDAO.insertOrderAndReservation(orderAndReservation);
		int orderAndReservation_id = orderAndReservationDAO.getRecentOrderAndReservationId();
		
		for(int i=0; i<goodsOrderList.size(); i++) {
			GoodsOrderVO goodsOrder = goodsOrderList.get(i);
			goodsOrder.setOrderAndReservation_OrderAndReservation_id(orderAndReservation_id);
			goodsOrderDAO.insertGoodsOrder(goodsOrder);
		}
		for(int i=0; i<reservationList.size(); i++) {
			ReservationVO reservation = reservationList.get(i);
			String r_user_id=reservation.getUser_user_id();
			logger.debug("[@OrderAndReservationServiceImpl, addOrderAndReservation] @Register reservation user_id: "+r_user_id);
			reservation.setOrderAndReservation_OrderAndReservation_id(orderAndReservation_id);
			reservationDAO.insertReservation(reservation);
		}

		String user_id = orderAndReservation.getUser_user_id();

		int user_mileage = userDAO.selectMileage(user_id);
		int mileage = user_mileage+mileageScore;
		UserVO userInfo = new UserVO(user_id,mileage);
		userDAO.updateMileage(userInfo);
		
		MileageHistoryVO mileageHistory= new MileageHistoryVO(mileageScore, user_id, orderAndReservation_id);
		mileageHistoryDAO.insertMileageHistory(mileageHistory);
	}

	@Override
	public void modifyOrderAndReservation(int orderAndReservation_id) {
		// TODO Auto-generated method stub
		
		
	}
	
	@Override
	public void modifyOrderAndReservationOrderOnly(int orderAndReservation_id,
			List<GoodsOrderVO> goodsOrderList) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void modifyOrderAndReservationReservationOnly(int orderAndReservation_id,
			List<ReservationVO> reservationList) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void deleteOrderAndReservation(int order_id) {
		// TODO Auto-generated method stub
		orderAndReservationDAO.deleteOrderAndReservation(order_id);
	}

	@Override
	public void deleteOrderAndReservationByCafeId(int cafe_id) {
		// TODO Auto-generated method stub
		// GoodsOrder and Reservation will be removed by Trigger

	}

	@Override
	public void cancelOrderAndReservation(int orderAndReservation_id) {
		// TODO Auto-generated method stub
		
		// cancel goods order
		List<GoodsOrderVO> goodsOrderList = goodsOrderDAO.selectGoodsOrderByOrderId(orderAndReservation_id);
		Iterator<GoodsOrderVO> GoodsOrderIt =  goodsOrderList.iterator();
		while(GoodsOrderIt.hasNext()) {
			GoodsOrderVO goodsOrder = GoodsOrderIt.next();
			int order_id = goodsOrder.getOrder_id();
			goodsOrderDAO.updateGoodsOrderState(order_id, "canceled");
		}
		
		// cancel reservation
		List<ReservationVO> reservationList = reservationDAO.selectReservationByOrderId(orderAndReservation_id);
		Iterator<ReservationVO> orderAndReservationIt = reservationList.iterator();
		while(orderAndReservationIt.hasNext()) {
			ReservationVO reservation = orderAndReservationIt.next();
			int reservation_id = reservation.getReservation_id();
			reservationDAO.updateReservationState(reservation_id, "canceled");
		}
		
		// cancel order and reservation
		orderAndReservationDAO.updateOrderAndReservationStatus(orderAndReservation_id, "canceled");
	}

	@Override
	public List<GoodsOrderVO> getGoodsOrderListByUserId(String user_id) {
		// TODO Auto-generated method stub
		List<GoodsOrderVO> goodsOrderList =goodsOrderDAO.selectGoodsOrderByUserId(user_id);
		return goodsOrderList;
	}
	
	@Override
	public List<GoodsOrderVO> getGoodsOrderListByUserIdAndOrderId(String user_id, int orderAndReservation_id) {
		// TODO Auto-generated method stub
		Map searchMap = new HashMap();
		
		searchMap.put("user_id", user_id);
		searchMap.put("order_id", orderAndReservation_id);
		List<GoodsOrderVO> goodsOrderList =goodsOrderDAO.selectGoodsOrderByUserIdAndOrderId(searchMap);
		return goodsOrderList;
	}
	
	@Override
	public List<GoodsOrderVO> getGoodsOrderListByOrderId(int order_id) {
		// TODO Auto-generated method stub
		List<GoodsOrderVO> goodsOrderList =goodsOrderDAO.selectGoodsOrderByOrderId(order_id);
		return goodsOrderList;
	}

	
	
	@Override
	public void modifyGoodsOrder(GoodsOrderVO goodsOrder) {
		// TODO Auto-generated method stub
		goodsOrderDAO.updateGoodsOrder(goodsOrder);
	}

	@Override
	public void deleteGoodsOrder(int order_id) {
		// TODO Auto-generated method stub
		goodsOrderDAO.deleteGoodsOrder(order_id);
	}
	
	

	@Override
	public void cancelGoodsOrder(int order_id) {
		// TODO Auto-generated method stub
		goodsOrderDAO.updateGoodsOrderState(order_id, "canceled");
	}

	@Override
	public List<ReservationVO> getReservationListByUserId(String user_id) {
		// TODO Auto-generated method stub
		List<ReservationVO> reservationList = reservationDAO.selectReservationByUserId(user_id);
		return reservationList;
	}

	@Override
	public List<ReservationVO> getReservationListByUserIdAndOrderId(String user_id, int orderAndReservation_id) {
		// TODO Auto-generated method stub
		Map searchMap = new HashMap();
		
		searchMap.put("user_id", user_id);
		searchMap.put("order_id", orderAndReservation_id);
		
		List<ReservationVO> reservationList = reservationDAO.selectReservationByUserIdAndOrderId(searchMap);
		
		return reservationList;
	}

	@Override
	public List<ReservationVO> getReservationListByOrderId(int order_id) {
		// TODO Auto-generated method stub
		List<ReservationVO> reservationList = reservationDAO.selectReservationByOrderId(order_id);
		return reservationList;
	}
	
	@Override
	public void modifyReservation(ReservationVO reservation) {
		// TODO Auto-generated method stub
		reservationDAO.updateReservation(reservation);
	}

	@Override
	public void deleteReservation(int reservation_id) {
		// TODO Auto-generated method stub
		reservationDAO.deleteReservation(reservation_id);
	}

	@Override
	public void cancelReservation(int reservation_id) {
		// TODO Auto-generated method stub
		reservationDAO.updateReservationState(reservation_id, "canceled");
	}

	@Override
	public List<Map> getOrderAndReservationForCafeDetail(String user_id, int cafe_id) throws ParseException {
		// TODO Auto-generated method stub
		List<Map> orderMapList= new ArrayList<Map>();
		
		//get Goods And Reservation List
		List<OrderAndReservationVO> orderAndReservationList = orderAndReservationDAO.selectOrderAndReservationByUserId(user_id);  
		for(int i=0; i<orderAndReservationList.size(); i++) {
			OrderAndReservationVO orderAndReservation = orderAndReservationList.get(i);
			int orderAndReservation_id = orderAndReservation.getOrderAndReservation_id();
			Date orderDate = orderAndReservation.getCreated_date();
			String dateStrTest = orderDate.toString();
			logger.debug("[@MypageControllerImpl, orderlist] order date: "+ dateStrTest);
			
			List<GoodsOrderVO> goodsOrderList = goodsOrderDAO.selectGoodsOrderForReview(user_id, cafe_id, orderAndReservation_id);
			
			List<ReservationVO> reservationList = reservationDAO.selectReservationForReview(user_id, cafe_id, orderAndReservation_id);
			if(goodsOrderList.size()>0 || reservationList.size()>0) {
				Map orderMap = new HashMap();
				int numberOfOrder =0;
				int orderPrice=0;
				orderMap.put("order_id", orderAndReservation_id);
				if(goodsOrderList != null && goodsOrderList.size()>0) {
					orderMap.put("goodsOrderList", goodsOrderList);
					for(int j=0;j<goodsOrderList.size();j++) {
						GoodsOrderVO order =goodsOrderList.get(j);
						int goods_id = order.getGoods_goods_id();
						GoodsVO goods = goodsDAO.selectOneGoods(goods_id);
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
						GroupSeatVO groupSeat= groupSeatDAO.selectOneGroupSeat(groupseat_id);
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
				
				String representedOrderName="주문기록없음";
				
				if(goodsOrderList != null && goodsOrderList.size()>0) {
					GoodsOrderVO goodsOrder= goodsOrderList.get(0);
					int goods_id = goodsOrder.getGoods_goods_id();
					GoodsVO goods = goodsDAO.selectOneGoods(goods_id);
					representedOrderName = goods.getGoods_name();
					logger.debug("[@MypageControllerImpl, orderlist] goodsOrder representedOrderName: "+ representedOrderName);
					if (numberOfOrder!=1){
						representedOrderName += " 외 "+(numberOfOrder-1)+"건";
					}
					
				}else if(reservationList != null && reservationList.size()>0) {
					ReservationVO reservation = reservationList.get(0);
					int groupSeat_id = reservation.getGroupseat_groupseat_id();
					GroupSeatVO groupSeat = groupSeatDAO.selectOneGroupSeat(groupSeat_id);
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
		}
		return orderMapList;
	}
	
	
}
