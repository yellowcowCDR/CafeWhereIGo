package com.ubo.CafeWhereIGo.article.service;

import java.util.List;
import java.util.Map;

import com.ubo.CafeWhereIGo.article.vo.ArticleVO;
import com.ubo.CafeWhereIGo.article.vo.ArticleSearchConditionVO;
import com.ubo.CafeWhereIGo.articleReply.vo.ArticleReplyVO;
import com.ubo.CafeWhereIGo.articlephoto.vo.ArticlePhotoVO;
import com.ubo.CafeWhereIGo.likedArticle.vo.LikedArticleVO;

public interface ArticleService {
	public int registerArticle(ArticleVO articleVO, List<ArticlePhotoVO> articlePhotoVOList);
	public void deleteArticle(int articleNO);
	public void modifyArticle(ArticleVO articleVO, List<ArticlePhotoVO> articlePhotoVOList);
	public List<ArticleVO> getArticleList(ArticleSearchConditionVO condition);
	public List<ArticleVO> getArticleList(int startArticleNO, int endArticleNO);
	public List<ArticleVO> searchArticle(ArticleSearchConditionVO searchConditionVO);
	public Map<String,Object> getArticle(int article_id);
	public int getNextArticleNo();
	public int getLastArticleNo();
	public void add_view_count(int article_id);
	public void add_liked_article(LikedArticleVO likedArticleVO);
	public int get_liked_count(int article_id);
	public boolean isLiked(LikedArticleVO likedArticleVO);
	public void delete_liked_article(LikedArticleVO likedArticleVO);
	public void addReply(ArticleReplyVO articleReplyVO);
	public List<ArticleReplyVO> getReplies(int article_id);
	public void deleteReply(int reply_id);
	public void updateReply(ArticleReplyVO articleReplyVO);
	public List<ArticlePhotoVO> getFiles(int article_id);
	public void deleteWithPhotoId(int article_photo_id);
	public void updateOne(ArticlePhotoVO articlePhotoVO);
	boolean isFileExists(int article_photo_id);
}
