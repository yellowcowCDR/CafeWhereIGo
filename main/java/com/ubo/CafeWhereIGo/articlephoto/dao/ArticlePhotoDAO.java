package com.ubo.CafeWhereIGo.articlephoto.dao;

import java.util.List;

import com.ubo.CafeWhereIGo.articlephoto.vo.ArticlePhotoVO;

public interface ArticlePhotoDAO {
	public void upload(ArticlePhotoVO articlePhotoVO);
	public void upload(List<ArticlePhotoVO> articlePhotoVOList);
	public void deletePhotos(int article_id);
	public void modify(ArticlePhotoVO articlePhotoVO);
	public List<ArticlePhotoVO> getArticlePhotoList(int article_id);
}
