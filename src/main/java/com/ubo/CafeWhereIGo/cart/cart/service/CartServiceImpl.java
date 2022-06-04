package com.ubo.CafeWhereIGo.cart.cart.service;

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
		return goodsCartList;
	}

	@Override
	public List<GoodsCartSearchResultVO> getGoodsCartListbyCafeId(int cafe_id) {
		// TODO Auto-generated method stub
		List<GoodsCartSearchResultVO> goodsCartList=goodsCartDAO.selectGoodsCartListByCafeId(cafe_id);
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
	public List<GroupSeatCartSearchResultVO> getGroupSeatCartListbyUserId(String user_id) {
		// TODO Auto-generated method stub
		List<GroupSeatCartSearchResultVO> groupSeatCartList = groupSeatCartDAO.selectGroupSeatListByUserId(user_id);
		return groupSeatCartList;
	}

	@Override
	public List<GroupSeatCartSearchResultVO> getGroupSeatCartListbyCafeId(int cafe_id) {
		// TODO Auto-generated method stub
		List<GroupSeatCartSearchResultVO> groupSeatCartList = groupSeatCartDAO.selectGroupSeatListByCafeId(cafe_id);
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
