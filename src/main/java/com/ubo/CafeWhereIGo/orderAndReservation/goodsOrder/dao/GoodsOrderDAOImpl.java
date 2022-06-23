package com.ubo.CafeWhereIGo.orderAndReservation.goodsOrder.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ubo.CafeWhereIGo.orderAndReservation.goodsOrder.vo.GoodsOrderVO;

@Repository
public class GoodsOrderDAOImpl implements GoodsOrderDAO {
	@Autowired
	SqlSession sqlSession;

	@Override
	public void insertGoodsOrder(GoodsOrderVO goodsOrder) {
		// TODO Auto-generated method stub
		sqlSession.insert("mapper.goodsOrder.insertGoodsOrder", goodsOrder);
	}

	@Override
	public List<GoodsOrderVO> selectGoodsOrderByUserId(String user_id) {
		// TODO Auto-generated method stub
		List<GoodsOrderVO> goodsOrderlist = sqlSession.selectList("mapper.goodsOrder.selectGoodsOrderByUserId",user_id);
		return goodsOrderlist;
	}
	
	@Override
	public List<GoodsOrderVO> selectGoodsOrderByOrderId(int order_id) {
		// TODO Auto-generated method stub
		List<GoodsOrderVO> goodsOrderlist = sqlSession.selectList("mapper.goodsOrder.selectGoodsOrderByOrderId",order_id);
		return goodsOrderlist;
	}

	@Override
	public List<GoodsOrderVO> selectGoodsOrderByUserIdAndOrderId(Map searchMap) {
		// TODO Auto-generated method stub
		List<GoodsOrderVO> goodsOrderlist  = sqlSession.selectList("mapper.goodsOrder.selectGoodsOrderByUserIdAndOrderId",searchMap);
		return goodsOrderlist;
	}
	
	@Override
	public List<GoodsOrderVO> selectGoodsOrderForReview(String user_id, int cafe_id, int orderAndReservation_id) {
		// TODO Auto-generated method stub
		Map searchMap = new HashMap();
		searchMap.put("user_id",user_id);
		searchMap.put("cafe_id",cafe_id);
		searchMap.put("order_id",orderAndReservation_id);
		
		List<GoodsOrderVO> goodsOrderlist  = sqlSession.selectList("mapper.goodsOrder.selectGoodsOrderForReview",searchMap);
		return goodsOrderlist;
	}

	@Override
	public List<GoodsOrderVO> selectGoodsOrderByCafeId(int cafe_id) {
		// TODO Auto-generated method stub
		List<GoodsOrderVO> goodsOrderlist = sqlSession.selectList("mapper.goodsOrder.selectGoodsOrderByCafeId",cafe_id);
		return goodsOrderlist;
	}

	@Override
	public void updateGoodsOrder(GoodsOrderVO goodsOrder) {
		// TODO Auto-generated method stub
		sqlSession.update("mapper.goodsOrder.updateGoodsOrder",goodsOrder);
	}

	@Override
	public void deleteGoodsOrder(int order_id) {
		// TODO Auto-generated method stub
		sqlSession.delete("mapper.goodsOrder.deleteGoodsOrder",order_id);
	}

	@Override
	public void updateGoodsOrderState(int order_id, String order_state) {
		// TODO Auto-generated method stub
		GoodsOrderVO goodsOrder = new GoodsOrderVO(order_id, order_state);
		sqlSession.update("mapper.goodsOrder.updateGoodsOrderState", goodsOrder);
	}
	
	
}
