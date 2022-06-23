package com.ubo.CafeWhereIGo.cart.goodsCart.dao;

import java.util.List;

import com.ubo.CafeWhereIGo.cart.goodsCart.vo.GoodsCartSearchResultVO;
import com.ubo.CafeWhereIGo.cart.goodsCart.vo.GoodsCartVO;

public interface GoodsCartDAO {
	public void insertGoodsCart(GoodsCartVO goodsCart);
	public List<GoodsCartSearchResultVO> selectGoodsCartListByCafeId(int cafe_id);
	public List<GoodsCartSearchResultVO> selectGoodsCartListByUserId(String user_id);
	public void updateGoodsCart(GoodsCartVO goodsCart);
	public void deleteGoodsCart(int cart_id);
}
