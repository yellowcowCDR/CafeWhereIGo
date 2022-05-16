package com.ubo.CafeWhereIGo.article.vo;

import java.util.Date;

import org.springframework.stereotype.Component;

@Component("articleVO")
public class ArticleVO {
	private int search_result_no;
	private int article_id;
	private String cafe_name;
	private String article_title;
	private String article_content;
	private Date created_date;
	private int view_count;
	private String user_user_id;
	private String ArticleType;
	private int likeCount;
	


	public ArticleVO() {
		super();
	}
	
	
	
	public ArticleVO(int search_result_no, int article_id, String cafe_name, String article_title,
			String article_content, Date created_date, int view_count, String user_user_id, String articleType,
			int likeCount) {
		super();
		this.search_result_no = search_result_no;
		this.article_id = article_id;
		this.cafe_name = cafe_name;
		this.article_title = article_title;
		this.article_content = article_content;
		this.created_date = created_date;
		this.view_count = view_count;
		this.user_user_id = user_user_id;
		ArticleType = articleType;
		this.likeCount = likeCount;
	}



	public ArticleVO(int article_id, String cafe_name, String article_title, String article_content, Date created_date,
			int view_count, String user_user_id, String articleType, int likeCount) {
		super();
		this.article_id = article_id;
		this.cafe_name = cafe_name;
		this.article_title = article_title;
		this.article_content = article_content;
		this.created_date = created_date;
		this.view_count = view_count;
		this.user_user_id = user_user_id;
		ArticleType = articleType;
		this.likeCount = likeCount;
	}
	public ArticleVO(int article_id, String cafe_name, String article_title, String article_content, Date created_date,
			int view_count, String user_user_id, String articleType) {
		super();
		this.article_id = article_id;
		this.cafe_name = cafe_name;
		this.article_title = article_title;
		this.article_content = article_content;
		this.created_date = created_date;
		this.view_count = view_count;
		this.user_user_id = user_user_id;
		ArticleType = articleType;
	}

	
	public int getSearch_result_no() {
		return search_result_no;
	}

	public void setSearch_result_no(int search_result_no) {
		this.search_result_no = search_result_no;
	}

	public int getArticle_id() {
		return article_id;
	}

	public void setArticle_id(int article_id) {
		this.article_id = article_id;
	}

	public String getCafe_name() {
		return cafe_name;
	}

	public void setCafe_name(String cafe_name) {
		this.cafe_name = cafe_name;
	}

	public String getArticle_title() {
		return article_title;
	}

	public void setArticle_title(String article_title) {
		this.article_title = article_title;
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

	public int getView_count() {
		return view_count;
	}

	public void setView_count(int view_count) {
		this.view_count = view_count;
	}

	public String getUser_user_id() {
		return user_user_id;
	}

	public void setUser_user_id(String user_user_id) {
		this.user_user_id = user_user_id;
	}

	public String getArticleType() {
		return ArticleType;
	}

	public void setArticleType(String articleType) {
		ArticleType = articleType;
	}

	public int getLikeCount() {
		return likeCount;
	}

	public void setLikeCount(int likeCount) {
		this.likeCount = likeCount;
	}
	
	
}
