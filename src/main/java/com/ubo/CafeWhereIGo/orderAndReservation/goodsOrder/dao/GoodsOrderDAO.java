package com.ubo.CafeWhereIGo.orderAndReservation.goodsOrder.dao;

import java.util.List;

import com.ubo.CafeWhereIGo.cafe.goods.vo.GoodsVO;
import com.ubo.CafeWhereIGo.orderAndReservation.goodsOrder.vo.GoodsOrderVO;

public interface GoodsOrderDAO {
	public void insertGoodsOrder(GoodsOrderVO goodsOrder);
	public List<GoodsOrderVO> selectGoodsOrderByUserId(String user_id);
	public List<GoodsOrderVO> selectGoodsOrderByCafeId(int cafe_id);
	public void updateGoodsOrder(GoodsOrderVO goodsOrder);
	public void deleteGoodsOrder(int goods_id);
}
