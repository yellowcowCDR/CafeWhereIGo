package com.ubo.CafeWhereIGo.cart.cart.service;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ubo.CafeWhereIGo.cart.goodsCart.dao.GoodsCartDAO;
import com.ubo.CafeWhereIGo.cart.goodsCart.vo.GoodsCartSearchResultVO;
import com.ubo.CafeWhereIGo.cart.goodsCart.vo.GoodsCartVO;
import com.ubo.CafeWhereIGo.cart.groupSeatCart.dao.GroupSeatCartDAO;
import com.ubo.CafeWhereIGo.cart.groupSeatCart.vo.GroupSeatCartSearchResultVO;
import com.ubo.CafeWhereIGo.cart.groupSeatCart.vo.GroupSeatCartVO;

@Transactional
@Service
public class CartServiceImpl implements CartService {
	
	//Logger logger = LoggerFactory.getLogger(CartServiceImpl.class);
	
	@Autowired
	GoodsCartDAO goodsCartDAO;

	@Autowired
	GroupSeatCartDAO groupSeatCartDAO;
	
	@Override
	public void addGoodsCart(GoodsCartVO goodsCart) {
		// TODO Auto-generated method stub
		goodsCartDAO.insertGoodsCart(goodsCart);
	}

	@Override
	public List<GoodsCartSearchResultVO> getGoodsCartListbyUserId(String user_id) {
		// TODO Auto-generated method stub
		List<GoodsCartSearchResultVO> goodsCartList=goodsCartDAO.selectGoodsCartListByUserId(user_id);
		List<String> descriptionList = new ArrayList<String>();
		for(int i=0; i<goodsCartList.size(); i++) {
			GoodsCartSearchResultVO goodsCart = goodsCartList.get(i);
			String description = goodsCart.getDescription();
			String[] descriptionListTemp ={""};
			if(description!= null) {
				descriptionListTemp = description.split("\r\n");
			}
			for(String desc: descriptionListTemp) {
				descriptionList.add(desc);
			}
			goodsCartList.get(i).setDescriptionList(descriptionList);
			
			
		}
		
		return goodsCartList;
	}

	@Override
	public List<GoodsCartSearchResultVO> getGoodsCartListbyCafeId(int cafe_id) {
		// TODO Auto-generated method stub
		List<GoodsCartSearchResultVO> goodsCartList=goodsCartDAO.selectGoodsCartListByCafeId(cafe_id);
		List<String> descriptionList = new ArrayList<String>();
		for(int i=0; i<goodsCartList.size(); i++) {
			GoodsCartSearchResultVO goodsCart = goodsCartList.get(i);
			String description = goodsCart.getDescription();
			String[] descriptionListTemp ={""};
			if(description!= null) {
				descriptionListTemp = description.split("\r\n");
			}
			for(String desc: descriptionListTemp) {
				descriptionList.add(desc);
			}
			goodsCartList.get(i).setDescriptionList(descriptionList);
			goodsCartList.get(i).setDescriptionList(descriptionList);
			
		}
		return goodsCartList;
	}

	@Override
	public void modifyGoodsCart(GoodsCartVO goodsCart) {
		// TODO Auto-generated method stub
		goodsCartDAO.updateGoodsCart(goodsCart);
	}

	@Override
	public void deleteGoodsCart(int cart_id) {
		// TODO Auto-generated method stub
		goodsCartDAO.deleteGoodsCart(cart_id);
	}

	@Override
	public void addGroupSeatCart(GroupSeatCartVO groupSeatCart) {
		// TODO Auto-generated method stub
		groupSeatCartDAO.insertGroupSeatCart(groupSeatCart);
	}
	
	@Override
	public List<GroupSeatCartSearchResultVO> getGroupSeatCartListbyUserId(String user_id) throws ParseException {
		// TODO Auto-generated method stub
		List<GroupSeatCartSearchResultVO> groupSeatCartList = groupSeatCartDAO.selectGroupSeatListByUserId(user_id);
		for(int i=0; i<groupSeatCartList.size(); i++) {
			GroupSeatCartSearchResultVO groupSeatCart = groupSeatCartList.get(i);
			String description = groupSeatCart.getDescription();
			String[] descriptionList = description.split("\r\n");
			groupSeatCartList.get(i).setDescriptionList(descriptionList);
			
			SimpleDateFormat dateFmt = new SimpleDateFormat("yyyy-MM-dd");
			Date reservation_date = groupSeatCart.getReservation_date();
			String dateStr=dateFmt.format(reservation_date);
			String start_time = groupSeatCart.getStart_time();
			String end_time = groupSeatCart.getEnd_time();
			
			String start_dateStr = dateStr + " " + start_time;
			String end_dateStr = dateStr + " " + end_time;
			
			SimpleDateFormat dateTimeFmt = new SimpleDateFormat("yyyy-MM-dd HH:mm");
			java.util.Date start_date = dateTimeFmt.parse(start_dateStr);
			java.util.Date end_date = dateTimeFmt.parse(end_dateStr);
			
			long timeDiff = end_date.getTime() - start_date.getTime();
			long timeDiffToMinute = Math.round((double)timeDiff/(60*1000));

			int unitPricePerHour = groupSeatCart.getPrice();
			double unitPricePerMinute = (double)unitPricePerHour/60;
			
			int totalPrice = (int)(unitPricePerMinute*timeDiffToMinute);
			groupSeatCart.setTotalPrice(totalPrice);
		}
		
		return groupSeatCartList;
	}

	@Override
	public List<GroupSeatCartSearchResultVO> getGroupSeatCartListbyCafeId(int cafe_id) throws ParseException {
		// TODO Auto-generated method stub
		List<GroupSeatCartSearchResultVO> groupSeatCartList = groupSeatCartDAO.selectGroupSeatListByCafeId(cafe_id);
		for(int i=0; i<groupSeatCartList.size(); i++) {
			GroupSeatCartSearchResultVO groupSeatCart = groupSeatCartList.get(i);
			String description = groupSeatCart.getDescription();
			String[] descriptionList = description.split("\r\n");
			groupSeatCartList.get(i).setDescriptionList(descriptionList);
			
			SimpleDateFormat dateFmt = new SimpleDateFormat("yyyy-MM-dd");
			Date reservation_date = groupSeatCart.getReservation_date();
			String dateStr=dateFmt.format(reservation_date);
			String start_time = groupSeatCart.getStart_time();
			String end_time = groupSeatCart.getEnd_time();
			
			String start_dateStr = dateStr + " " + start_time;
			String end_dateStr = dateStr + " " + end_time;
			
			SimpleDateFormat dateTimeFmt = new SimpleDateFormat("yyyy-MM-dd HH:mm");
			java.util.Date start_date = dateTimeFmt.parse(start_dateStr);
			java.util.Date end_date = dateTimeFmt.parse(end_dateStr);
			
			long timeDiff = end_date.getTime() - start_date.getTime();
			long timeDiffToMinute = Math.round((double)timeDiff/(60*1000));

			int unitPricePerHour = groupSeatCart.getPrice();
			double unitPricePerMinute = (double)unitPricePerHour/60;
			
			int totalPrice = (int)(unitPricePerMinute*timeDiffToMinute);
			
			
			
			groupSeatCart.setTotalPrice(totalPrice);
		}
		return groupSeatCartList;
	}

	@Override
	public void modifyGroupSeatCart(GroupSeatCartVO groupSeatCart) {
		// TODO Auto-generated method stub
		groupSeatCartDAO.updateGroupSeatCart(groupSeatCart);
	}

	@Override
	public void deleteGroupSeatCart(int cart_id) {
		// TODO Auto-generated method stub
		groupSeatCartDAO.deleteGroupSeatCart(cart_id);
	}
}
