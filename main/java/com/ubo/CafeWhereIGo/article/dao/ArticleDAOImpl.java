package com.ubo.CafeWhereIGo.article.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ubo.CafeWhereIGo.article.vo.ArticleVO;
import com.ubo.CafeWhereIGo.article.vo.SearchConditionVO;
import com.ubo.CafeWhereIGo.articleReply.vo.ArticleReplyVO;
import com.ubo.CafeWhereIGo.likedArticle.vo.LikedArticleVO;

@Repository("articleDAO")
public class ArticleDAOImpl implements ArticleDAO{

	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public int getNextArticleNo() {
		int nextArticleId = (Integer)sqlSession.selectOne("mapper.article.getNextArticleId");
		
		return nextArticleId;
	}
	
	@Override
	public int getLastArticleNo() {
		int articleNo = (Integer)sqlSession.selectOne("mapper.article.getLastArticleId");
		return articleNo;
	}
	
	@Override
	public void insertArticle(ArticleVO articleVO) {
		// TODO Auto-generated method stub
		sqlSession.insert("mapper.article.insertArticle", articleVO);
	}

	@Override
	public List<ArticleVO> selectAllArticle(String articleType) {
		// TODO Auto-generated method stub
		List<ArticleVO> articleList = (List<ArticleVO>) sqlSession.selectList("mapper.article.selectAllArticle", articleType);

		return articleList;
	}
	
	@Override
	public ArticleVO selectArticle(int article_id) {
		// TODO Auto-generated method stub
		ArticleVO articleVO = (ArticleVO) sqlSession.selectOne("mapper.article.selectArticle", article_id);
		return articleVO;
	}

	@Override
	public List<ArticleVO> selectArticles(SearchConditionVO searchConditionVO) {
		// TODO Auto-generated method stub
		List<ArticleVO> articleList = (List<ArticleVO>) sqlSession.selectList("mapper.article.selectArticles", searchConditionVO);
		return articleList;
	}

	@Override
	public void updateArticle(ArticleVO articleVO) {
		// TODO Auto-generated method stub
		sqlSession.update("mapper.article.updateArticle", articleVO);
	}

	@Override
	public void deleteArticle(int articleId) {
		// TODO Auto-generated method stub
		sqlSession.delete("mapper.article.deleteArticle",articleId);
	}

	@Override
	public void articleLike(LikedArticleVO likedArticleVO) {
		// TODO Auto-generated method stub
		sqlSession.insert("mapper.article.addLike", likedArticleVO);
	}
	
	@Override
	public void articleLikeCancel(LikedArticleVO likedArticleVO) {
		sqlSession.delete("mapper.article.deleteLike", likedArticleVO);
	}
	

	@Override
	public int getArticleLikeCount(int article_id) {
		// TODO Auto-generated method stub\
		int likeCount = (Integer) sqlSession.selectOne("mapper.article.getArticleLikeCount", article_id);
		return likeCount;
	}
	
	@Override
	public boolean isLiked(LikedArticleVO likedArticleVO) {
		boolean isLiked= (Boolean) sqlSession.selectOne("mapper.article.isLiked", likedArticleVO);
		
		return isLiked;
	}
	
	@Override
	public void addViewCount(int article_no) {
		// TODO Auto-generated method stub
		sqlSession.update("mapper.article.updateViewCount",article_no);
		
	}
	@Override
	public int getViewCount(int article_no) {
		// TODO Auto-generated method stub	
		int view_count=(Integer) sqlSession.selectOne("mapper.article.getViewCount", article_no);
		return view_count;
	}
	
	@Override
	public void addReply(ArticleReplyVO articleReplyVO) {
		sqlSession.insert("mapper.article.insertArticleReply",articleReplyVO);
	}

	@Override
	public List<ArticleReplyVO> getReplies(int article_id) {
		// TODO Auto-generated method stub
		List<ArticleReplyVO> articleReplies = sqlSession.selectList("mapper.article.selectReplies",article_id);
		return articleReplies;
	}

	@Override
	public void deleteReply(int reply_id) {
		// TODO Auto-generated method stub
		sqlSession.delete("mapper.article.deleteReply", reply_id);
	}
	
	
	
}
