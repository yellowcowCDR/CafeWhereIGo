package com.ubo.CafeWhereIGo.cafeHomeArticle.vo;

import java.util.Date;

import org.springframework.stereotype.Component;

@Component
public class CafeHomeArticleVO {
	private int article_id;
	private String article_content;
	private Date created_date;
	private int cafe_cafe_id;
	private String user_user_id;
	
	public CafeHomeArticleVO() {
		super();
	}

	public CafeHomeArticleVO(String article_content, Date created_date, int cafe_cafe_id, String user_user_id) {
		super();
		this.article_content = article_content;
		this.created_date = created_date;
		this.cafe_cafe_id = cafe_cafe_id;
		this.user_user_id = user_user_id;
	}

	public CafeHomeArticleVO(int article_id, String article_content, Date created_date, int cafe_cafe_id,
			String user_user_id) {
		super();
		this.article_id = article_id;
		this.article_content = article_content;
		this.created_date = created_date;
		this.cafe_cafe_id = cafe_cafe_id;
		this.user_user_id = user_user_id;
	}

	public int getArticle_id() {
		return article_id;
	}

	public void setArticle_id(int article_id) {
		this.article_id = article_id;
	}

	public String getArticle_content() {
		return article_content;
	}

	public void setArticle_content(String article_content) {
		this.article_content = article_content;
	}

	public Date getCreated_date() {
		return created_date;
	}

	public void setCreated_date(Date created_date) {
		this.created_date = created_date;
	}

	public int getCafe_cafe_id() {
		return cafe_cafe_id;
	}

	public void setCafe_cafe_id(int cafe_cafe_id) {
		this.cafe_cafe_id = cafe_cafe_id;
	}

	public String getUser_user_id() {
		return user_user_id;
	}

	public void setUser_user_id(String user_user_id) {
		this.user_user_id = user_user_id;
	}
	
	
}
