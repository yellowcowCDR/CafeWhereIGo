package com.ubo.CafeWhereIGo.cafe.goods.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ubo.CafeWhereIGo.cafe.goods.vo.GoodsVO;
import com.ubo.CafeWhereIGo.cafe.goodsphoto.vo.GoodsPhotoVO;

@Repository
public class GoodsDAOImpl implements GoodsDAO{
	@Autowired
	SqlSession sqlSession;

	@Override
	public void insertGoods(GoodsVO goods) {
		// TODO Auto-generated method stub
		sqlSession.insert("mapper.cafeGoods.insertGoods",goods);
	}

	@Override
	public void updateGoods(GoodsVO goods) {
		// TODO Auto-generated method stub
		sqlSession.update("mapper.cafeGoods.updateGoods",goods);
	}

	@Override
	public List<GoodsVO> selectGoods(int cafe_id) {
		// TODO Auto-generated method stub
		List<GoodsVO> goodsList = sqlSession.selectList("mapper.cafeGoods.selectGoods",cafe_id);
		return goodsList;
	}
	
	@Override
	public GoodsVO selectOneGoods(int goods_id) {
		// TODO Auto-generated method stub
		GoodsVO goods = (GoodsVO) sqlSession.selectOne("mapper.cafeGoods.selectOneGoods", goods_id);
		return goods;
	}

	@Override
	public void deleteGoodsByCafeId(int cafe_id) {
		// TODO Auto-generated method stub
		sqlSession.delete("mapper.cafeGoods.deleteGoodsByCafeId", cafe_id);
	}

	@Override
	public void deleteGoodsByGoodsId(int goods_id) {
		// TODO Auto-generated method stub
		sqlSession.delete("mapper.cafeGoods.deleteGoods",goods_id);
	}

	

	@Override
	public void insertGoodsPhoto(GoodsPhotoVO goodsPhoto) {
		// TODO Auto-generated method stub
		sqlSession.insert("mapper.cafeGoodsPhoto.insertGoodsPhoto", goodsPhoto);
	}

	@Override
	public void updateGoodsPhoto(GoodsPhotoVO goodsPhoto) {
		// TODO Auto-generated method stub
		sqlSession.update("mapper.cafeGoodsPhoto.updateGoodsPhoto", goodsPhoto);
	}

	@Override
	public GoodsPhotoVO selectGoodsPhoto(int goods_id) {
		// TODO Auto-generated method stub
		GoodsPhotoVO goodsPhoto =(GoodsPhotoVO) sqlSession.selectOne("mapper.cafeGoodsPhoto.selectGoodsPhoto", goods_id);
		return goodsPhoto;
	}

	@Override
	public void deleteGoodsPhoto(int goods_id) {
		// TODO Auto-generated method stub
		sqlSession.delete("mapper.cafeGoodsPhoto.deleteGoodsPhoto", goods_id);
	}

	@Override
	public int getRecentGoodsId() {
		// TODO Auto-generated method stub
		return (Integer) sqlSession.selectOne("mapper.cafeGoods.selectRecentGoodsId");
	}
	
	
}
