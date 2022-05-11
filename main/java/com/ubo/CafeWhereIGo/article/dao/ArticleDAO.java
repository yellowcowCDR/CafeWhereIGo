package com.ubo.CafeWhereIGo.article.dao;

import java.util.List;

import com.ubo.CafeWhereIGo.article.vo.ArticleVO;
import com.ubo.CafeWhereIGo.article.vo.SearchConditionVO;
import com.ubo.CafeWhereIGo.articleReply.vo.ArticleReplyVO;
import com.ubo.CafeWhereIGo.likedArticle.vo.LikedArticleVO;

public interface ArticleDAO {
	public void insertArticle(ArticleVO articleVO);
	public List<ArticleVO> selectAllArticle(String articleType);
	public ArticleVO selectArticle(int article_id);
	public List<ArticleVO> selectArticles(SearchConditionVO searchConditionVO);
	public void updateArticle(ArticleVO articleVO);
	public void deleteArticle(int articleId);
	public int getNextArticleNo();
	public int getLastArticleNo();
	public void articleLike(LikedArticleVO likedArticleVO);
	public void articleLikeCancel(LikedArticleVO likedArticleVO);
	public void addViewCount(int article_no);
	public int getArticleLikeCount(int article_id);
	public int getViewCount(int article_no);
	public boolean isLiked(LikedArticleVO likedArticleVO);
	public void addReply(ArticleReplyVO articleReplyVO);
	public List<ArticleReplyVO> getReplies(int article_id);
	public void deleteReply(int reply_id);
}
