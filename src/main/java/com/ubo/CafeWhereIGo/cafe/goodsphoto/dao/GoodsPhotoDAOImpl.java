package com.ubo.CafeWhereIGo.cafe.goodsphoto.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ubo.CafeWhereIGo.cafe.goodsphoto.vo.GoodsPhotoVO;

@Repository
public class GoodsPhotoDAOImpl implements GoodsPhotoDAO {
	@Autowired
	SqlSession sqlSession;

	@Override
	public GoodsPhotoVO insertGoodsPhoto(GoodsPhotoVO goodsPhoto) {
		// TODO Auto-generated method stub
		sqlSession.insert("mapper.cafeGoodsPhoto.insertGoodsPhoto", goodsPhoto);
		return null;
	}

	@Override
	public GoodsPhotoVO selectGoodsPhoto(int goods_id) {
		// TODO Auto-generated method stub
		GoodsPhotoVO goodPhoto = (GoodsPhotoVO)sqlSession.selectOne("mapper.cafeGoodsPhoto.selectGoodsPhoto", goods_id);
		return goodPhoto;
	}

	@Override
	public void modifyGoodsPhoto(GoodsPhotoVO goodsPhoto) {
		// TODO Auto-generated method stub
		sqlSession.update("mapper.cafeGoodsPhoto.updateGoodsPhoto", goodsPhoto);
	}

	@Override
	public void deleteGoodsPhoto(int goods_id) {
		// TODO Auto-generated method stub
		
	}
}
