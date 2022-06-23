package com.ubo.CafeWhereIGo.cafeHomeArticle.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ubo.CafeWhereIGo.cafe.goods.dao.GoodsDAO;
import com.ubo.CafeWhereIGo.cafeHomeArticle.vo.CafeHomeArticleVO;

@Repository
public class CafeHomeArticleDAOImpl implements CafeHomeArticleDAO{
	@Autowired
	SqlSession sqlSession;
	
	@Override
	public void insertHomeArticle(CafeHomeArticleVO homeArticle) {
		// TODO Auto-generated method stub
		sqlSession.insert("mapper.cafeHomeArticle.insertHomeArticle", homeArticle);
	}

	@Override
	public void updateHomeArticle(CafeHomeArticleVO homeArticle) {
		// TODO Auto-generated method stub
		sqlSession.update("mapper.cafeHomeArticle.updateHomeArticle", homeArticle);
	}

	@Override
	public CafeHomeArticleVO selectHomeArticle(int cafe_id) {
		// TODO Auto-generated method stub
		CafeHomeArticleVO homeArticle=(CafeHomeArticleVO)sqlSession.selectOne("selectHomeArticle",cafe_id);
		return homeArticle;
	}

	@Override
	public void deleteHomeArticle(int cafe_id) {
		// TODO Auto-generated method stub
		sqlSession.update("mapper.cafeHomeArticle.deleteHomeArticle", cafe_id);
	}
	
}
