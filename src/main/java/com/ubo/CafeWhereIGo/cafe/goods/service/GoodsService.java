package com.ubo.CafeWhereIGo.cafe.goods.service;

import java.util.List;

import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.ubo.CafeWhereIGo.cafe.goods.vo.GoodsVO;
import com.ubo.CafeWhereIGo.cafe.goodsphoto.vo.GoodsPhotoInfoVO;
import com.ubo.CafeWhereIGo.cafe.goodsphoto.vo.GoodsPhotoVO;

public interface GoodsService {
	public List<GoodsPhotoInfoVO> registerGoods(MultipartHttpServletRequest multipartRequest, int cafe_id, int goodsSize);
	public int registerGoods(GoodsVO goods);
	public void deleteGoods(int goods_id);
	public void modifyGoods(MultipartHttpServletRequest multipartRequest, int cafe_id, int goodsSize);
	public void modifyGoods(GoodsVO goods);
	public List<GoodsVO> getGoods(int cafe_id);
	public GoodsVO getOneGoods(int goods_id);
	
	public void registerGoodsPhoto(GoodsPhotoVO goodsPhoto);
	public GoodsPhotoVO getGoodsPhoto(int goods_id);
	public void modifyGoodsPhoto(GoodsPhotoVO goodsPhoto);
	public void deleteGoodsPhoto(int goods_id);
	
	
}
