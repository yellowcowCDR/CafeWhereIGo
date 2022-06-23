package com.ubo.CafeWhereIGo.cart.cart.service;

import java.text.ParseException;
import java.util.List;

import com.ubo.CafeWhereIGo.cart.goodsCart.vo.GoodsCartSearchResultVO;
import com.ubo.CafeWhereIGo.cart.goodsCart.vo.GoodsCartVO;
import com.ubo.CafeWhereIGo.cart.groupSeatCart.vo.GroupSeatCartSearchResultVO;
import com.ubo.CafeWhereIGo.cart.groupSeatCart.vo.GroupSeatCartVO;

public interface CartService {
	// Goods Cart
	public void addGoodsCart(GoodsCartVO goodsCart);
	public List<GoodsCartSearchResultVO> getGoodsCartListbyUserId(String user_id);
	public List<GoodsCartSearchResultVO> getGoodsCartListbyCafeId(int cafe_id);
	public void modifyGoodsCart(GoodsCartVO goodsCart);
	public void deleteGoodsCart(int cart_id);
	
	// Group Seat Cart
	public void addGroupSeatCart(GroupSeatCartVO groupSeatCart);
	public List<GroupSeatCartSearchResultVO> getGroupSeatCartListbyUserId(String user_id) throws ParseException;
	public List<GroupSeatCartSearchResultVO> getGroupSeatCartListbyCafeId(int cafe_id) throws ParseException;
	public void modifyGroupSeatCart(GroupSeatCartVO groupSeatCart);
	public void deleteGroupSeatCart(int cart_id);
	
}
