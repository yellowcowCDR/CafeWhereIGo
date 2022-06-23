package com.ubo.CafeWhereIGo.orderAndReservation.goodsOrder.dao;

import java.util.List;
import java.util.Map;

import com.ubo.CafeWhereIGo.cafe.goods.vo.GoodsVO;
import com.ubo.CafeWhereIGo.orderAndReservation.goodsOrder.vo.GoodsOrderVO;

public interface GoodsOrderDAO {
	public void insertGoodsOrder(GoodsOrderVO goodsOrder);
	public List<GoodsOrderVO> selectGoodsOrderByUserId(String user_id);
	public List<GoodsOrderVO> selectGoodsOrderByOrderId(int order_id);
	public List<GoodsOrderVO> selectGoodsOrderByUserIdAndOrderId(Map searchMap);
	public List<GoodsOrderVO> selectGoodsOrderByCafeId(int cafe_id);
	public List<GoodsOrderVO> selectGoodsOrderForReview(String user_id, int cafe_id, int orderAndReservation_id);
	public void updateGoodsOrder(GoodsOrderVO goodsOrder);
	public void deleteGoodsOrder(int order_id);
	public void updateGoodsOrderState(int order_id, String order_state);
}
