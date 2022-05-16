package com.ubo.CafeWhereIGo.likedArticle.vo;

import java.util.Date;

public class LikedArticleVO {
	private int liked_article_id;
	private String user_user_id;
	private int Article_article_id;
	private Date created_date;
	
	public LikedArticleVO(int liked_article_id, String user_user_id, int article_article_id, Date created_date) {
		super();
		this.liked_article_id = liked_article_id;
		this.user_user_id = user_user_id;
		Article_article_id = article_article_id;
		this.created_date = created_date;
	}

	public LikedArticleVO(String user_user_id, int article_article_id) {
		super();
		this.user_user_id = user_user_id;
		Article_article_id = article_article_id;
	}

	public int getLiked_article_id() {
		return liked_article_id;
	}

	public void setLiked_article_id(int liked_article_id) {
		this.liked_article_id = liked_article_id;
	}

	public String getUser_user_id() {
		return user_user_id;
	}

	public void setUser_user_id(String user_user_id) {
		this.user_user_id = user_user_id;
	}

	public int getArticle_article_id() {
		return Article_article_id;
	}

	public void setArticle_article_id(int article_article_id) {
		Article_article_id = article_article_id;
	}

	public Date getCreated_date() {
		return created_date;
	}

	public void setCreated_date(Date created_date) {
		this.created_date = created_date;
	}
	
}
