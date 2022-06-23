package com.ubo.CafeWhereIGo.cafe.goods.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.ubo.CafeWhereIGo.cafe.goods.dao.GoodsDAO;
import com.ubo.CafeWhereIGo.cafe.goods.vo.GoodsVO;
import com.ubo.CafeWhereIGo.cafe.goodsphoto.dao.GoodsPhotoDAO;
import com.ubo.CafeWhereIGo.cafe.goodsphoto.vo.GoodsPhotoInfoVO;
import com.ubo.CafeWhereIGo.cafe.goodsphoto.vo.GoodsPhotoVO;

@Transactional
@Service
public class GoodsServiceImpl implements GoodsService{
	@Autowired
	GoodsDAO goodsDAO;
	
	@Autowired
	GoodsPhotoDAO goodsPhotoDAO;
	
	@Override
	public List<GoodsPhotoInfoVO> registerGoods(MultipartHttpServletRequest multipartRequest, int cafe_id, int goodsSize) {
		// TODO Auto-generated method stub
	
		List<GoodsPhotoInfoVO> goodsPhotoInfoList = new ArrayList<GoodsPhotoInfoVO>();
		for(int i=1; i<=goodsSize;i++) {
			//register goods
			
			String goods_name=multipartRequest.getParameter("goods"+i+"_name");
			int price = Integer.parseInt(multipartRequest.getParameter("goods"+i+"_price"));
			String description=multipartRequest.getParameter("goods"+i+"description");
			GoodsVO goods = new GoodsVO(goods_name, price, description, cafe_id);
			goodsDAO.insertGoods(goods);
			
			int goods_id= goodsDAO.getRecentGoodsId();
			
			//register goods photo info
			String fileName = "goodsphoto" + i;
			MultipartFile mFile = multipartRequest.getFile(fileName);
			String OrgFilename = mFile.getOriginalFilename();
			
			if(!OrgFilename.equals("") || OrgFilename!=null) {
				if(mFile.getSize()>0) {
					GoodsPhotoVO goodsPhoto = new GoodsPhotoVO(goods_id, OrgFilename);
					goodsDAO.insertGoodsPhoto(goodsPhoto);
					GoodsPhotoInfoVO goodsPhotoInfo = new GoodsPhotoInfoVO(goods_id, fileName, OrgFilename);
					goodsPhotoInfoList.add(goodsPhotoInfo);
				}
			}
		}
		return goodsPhotoInfoList;
	}
	@Override
	public int registerGoods(GoodsVO goods) {
		// TODO Auto-generated method stub
		goodsDAO.insertGoods(goods);
		int goods_id = goodsDAO.getRecentGoodsId(); 
		
		return goods_id;
	}
	
	@Override
	public void deleteGoods(int goods_id) {
		// TODO Auto-generated method stub
		goodsDAO.deleteGoodsByGoodsId(goods_id);
	}

	@Override
	public void modifyGoods(MultipartHttpServletRequest multipartRequest, int cafe_id, int goodSize) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void modifyGoods(GoodsVO goods) {
		// TODO Auto-generated method stub
		goodsDAO.updateGoods(goods);
	}
	
	@Override
	public List<GoodsVO> getGoods(int cafe_id) {
		// TODO Auto-generated method stub
		List<GoodsVO> goodsList = goodsDAO.selectGoods(cafe_id);
		return goodsList;
	}
	
	@Override
	public GoodsVO getOneGoods(int goods_id) {
		// TODO Auto-generated method stub
		GoodsVO goods = goodsDAO.selectOneGoods(goods_id);
		return goods;
	}

	@Override
	public GoodsPhotoVO getGoodsPhoto(int goods_id) {
		GoodsPhotoVO goodsPhoto = (GoodsPhotoVO)goodsPhotoDAO.selectGoodsPhoto(goods_id);
		return goodsPhoto;
	}

	@Override
	public void registerGoodsPhoto(GoodsPhotoVO goodsPhoto) {
		// TODO Auto-generated method stub
		goodsPhotoDAO.insertGoodsPhoto(goodsPhoto);
	}

	@Override
	public void modifyGoodsPhoto(GoodsPhotoVO goodsPhoto) {
		// TODO Auto-generated method stub
		goodsPhotoDAO.modifyGoodsPhoto(goodsPhoto);
	}

	@Override
	public void deleteGoodsPhoto(int goods_id) {
		// TODO Auto-generated method stub
		
	}
	
	
}
