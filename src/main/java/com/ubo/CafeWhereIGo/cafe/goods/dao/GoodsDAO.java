package com.ubo.CafeWhereIGo.cafe.goods.dao;

import java.util.List;

import com.ubo.CafeWhereIGo.cafe.goods.vo.GoodsVO;
import com.ubo.CafeWhereIGo.cafe.goodsphoto.vo.GoodsPhotoVO;

public interface GoodsDAO {
	
	//Goods
	public void insertGoods(GoodsVO goods);
	public void updateGoods(GoodsVO goods);
	public List<GoodsVO> selectGoods(int cafe_id);
	public GoodsVO selectOneGoods(int goods_id);
	public void deleteGoodsByCafeId(int cafe_id);
	public void deleteGoodsByGoodsId(int goods_id);
	
	//Goods Photo
	public void insertGoodsPhoto (GoodsPhotoVO goodsPhoto);
	public void updateGoodsPhoto(GoodsPhotoVO goodsPhoto);
	public GoodsPhotoVO selectGoodsPhoto(int goods_id);
	public void deleteGoodsPhoto(int goods_id);
	
	//helper function
	public int getRecentGoodsId();
}
