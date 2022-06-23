package com.ubo.CafeWhereIGo.articleReply.dao;

import java.util.List;

import com.ubo.CafeWhereIGo.articleReply.vo.ArticleReplyVO;

public interface ArticleReplyDAO {
	public void insertReply(ArticleReplyVO articleReplyVO);
	public void updateReply(ArticleReplyVO articleReplyVO);
	public List<ArticleReplyVO> selectReplies(int article_no);
	public void deleteReplies(int article_no);
	public void deleteReply(int reply_id);
}
