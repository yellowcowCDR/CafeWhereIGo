package com.ubo.CafeWhereIGo.articlephoto.dao;

import java.util.List;

import com.ubo.CafeWhereIGo.articlephoto.vo.ArticlePhotoVO;

public interface ArticlePhotoDAO {
	public void upload(ArticlePhotoVO articlePhotoVO);
	public void upload(List<ArticlePhotoVO> articlePhotoVOList);
	public void deletePhotos(int article_id);
	public void deleteWithPhotoId(int article_photo_id);
	public void modify(ArticlePhotoVO articlePhotoVO);
	public void modifyOne(ArticlePhotoVO articlePotoVO);
	public List<ArticlePhotoVO> getArticlePhotoList(int article_id);
	public List<ArticlePhotoVO> getFiles(int article_id);
	public boolean isFileExists(int article_photo_id);
}
