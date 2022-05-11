package com.ubo.CafeWhereIGo.article.service;

import java.util.List;
import java.util.Map;

import com.ubo.CafeWhereIGo.article.vo.ArticleVO;
import com.ubo.CafeWhereIGo.article.vo.SearchConditionVO;
import com.ubo.CafeWhereIGo.articleReply.vo.ArticleReplyVO;
import com.ubo.CafeWhereIGo.articlephoto.vo.ArticlePhotoVO;
import com.ubo.CafeWhereIGo.likedArticle.vo.LikedArticleVO;

public interface ArticleService {
	public int registerArticle(ArticleVO articleVO, List<ArticlePhotoVO> articlePhotoVOList);
	public void deleteArticle(int articleNO);
	public void modifyArticle(ArticleVO articleVO);
	public List<ArticleVO> getArticleList(String articleType);
	public List<ArticleVO> getArticleList(int startArticleNO, int endArticleNO);
	public List<ArticleVO> searchArticle(SearchConditionVO searchConditionVO);
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
}
