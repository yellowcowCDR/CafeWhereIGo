package com.ubo.CafeWhereIGo.orderAndReservation.goodsOrder.dao;

import java.util.List;

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
	public List<GoodsOrderVO> selectGoodsOrderByCafeId(int cafe_id) {
		// TODO Auto-generated method stub
		List<GoodsOrderVO> goodsOrderlist = sqlSession.selectList("mapper.goodsOrder.selectGoodsOrderByCafeId",cafe_id);
		return goodsOrderlist;
	}

	@Override
	public void updateGoodsOrder(GoodsOrderVO goodsOrder) {
		// TODO Auto-generated method stub
		sqlSession.selectList("mapper.goodsOrder.updateGoodsOrder",goodsOrder);
	}

	@Override
	public void deleteGoodsOrder(int order_id) {
		// TODO Auto-generated method stub
		sqlSession.delete("mapper.goodsOrder.deleteGoodsOrder",order_id);
	}
}
