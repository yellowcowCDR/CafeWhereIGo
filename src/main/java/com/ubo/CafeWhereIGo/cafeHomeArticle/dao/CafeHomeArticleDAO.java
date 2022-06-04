package com.ubo.CafeWhereIGo.cafeHomeArticle.dao;

import com.ubo.CafeWhereIGo.cafeHomeArticle.vo.CafeHomeArticleVO;

public interface CafeHomeArticleDAO {
	public void insertHomeArticle(CafeHomeArticleVO homeArticle);
	public void updateHomeArticle(CafeHomeArticleVO homeArticle);
	public CafeHomeArticleVO selectHomeArticle(int cafe_id);
	public void deleteHomeArticle(int cafe_id);
}
