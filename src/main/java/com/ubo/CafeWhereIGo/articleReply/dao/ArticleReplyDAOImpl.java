package com.ubo.CafeWhereIGo.articleReply.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;

import com.ubo.CafeWhereIGo.articleReply.vo.ArticleReplyVO;

public class ArticleReplyDAOImpl implements ArticleReplyDAO{
	@Autowired
	private SqlSession sqlSession;

	@Override
	public void insertReply(ArticleReplyVO articleReplyVO) {
		// TODO Auto-generated method stub
		sqlSession.insert("mapper.article.insertArticleReply", articleReplyVO);
	}

	@Override
	public void updateReply(ArticleReplyVO articleReplyVO) {
		// TODO Auto-generated method stub
		sqlSession.update("mapper.article.updateArticleReply", articleReplyVO);
	}

	@Override
	public List<ArticleReplyVO> selectReplies(int article_no) {
		// TODO Auto-generated method stub
		List<ArticleReplyVO> replies = sqlSession.selectList("mapper.article.selectReplies", article_no);
		return replies;
	}

	@Override
	public void deleteReplies(int article_no) {
		// TODO Auto-generated method stub
		sqlSession.delete("mapper.article.deleteReplies", article_no);
	}

	@Override
	public void deleteReply(int reply_id) {
		// TODO Auto-generated method stub
		sqlSession.delete("mapper.article.deleteReply", reply_id);
	}	
}
