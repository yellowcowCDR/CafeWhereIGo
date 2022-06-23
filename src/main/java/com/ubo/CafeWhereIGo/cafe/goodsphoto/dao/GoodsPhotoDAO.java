package com.ubo.CafeWhereIGo.cafe.goodsphoto.dao;

import java.util.List;

import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.ubo.CafeWhereIGo.cafe.goods.vo.GoodsVO;
import com.ubo.CafeWhereIGo.cafe.goodsphoto.vo.GoodsPhotoVO;

public interface GoodsPhotoDAO {
	public GoodsPhotoVO insertGoodsPhoto(GoodsPhotoVO goodsPhoto);
	public GoodsPhotoVO selectGoodsPhoto(int goods_id);
	public void modifyGoodsPhoto(GoodsPhotoVO goodsPhoto);
	public void deleteGoodsPhoto(int goods_id);
}
