package com.ubo.CafeWhereIGo.articleReply.vo;

public class ArticleReplyVO {
	private int reply_id;
	private String reply_content;
	private int Article_article_id;
	private String user_user_id;
	
	public ArticleReplyVO() {
		super();
	}

	public ArticleReplyVO(String user_user_id, int article_article_id, String reply_content) {
		super();
		this.reply_content = reply_content;
		Article_article_id = article_article_id;
		this.user_user_id = user_user_id;
	}

	public ArticleReplyVO(int reply_id, String reply_content, int article_article_id, String user_user_id) {
		super();
		this.reply_id = reply_id;
		this.reply_content = reply_content;
		Article_article_id = article_article_id;
		this.user_user_id = user_user_id;
	}

	public int getReply_id() {
		return reply_id;
	}

	public void setReply_id(int reply_id) {
		this.reply_id = reply_id;
	}

	public String getReply_content() {
		return reply_content;
	}

	public void setReply_content(String reply_content) {
		this.reply_content = reply_content;
	}

	public int getArticle_article_id() {
		return Article_article_id;
	}

	public void setArticle_article_id(int article_article_id) {
		Article_article_id = article_article_id;
	}

	public String getUser_user_id() {
		return user_user_id;
	}

	public void setUser_user_id(String user_user_id) {
		this.user_user_id = user_user_id;
	}
	
	
}
