package com.ubo.CafeWhereIGo.articlephoto.vo;

import org.springframework.stereotype.Component;

@Component("articlePhotoVO")
public class ArticlePhotoVO {
	private int article_photo_id;
	private int article_article_id;
	private String filename;
	
	public ArticlePhotoVO() {
		super();
	}

	public ArticlePhotoVO(int article_article_id, String photo_location) {
		super();
		this.article_article_id = article_article_id;
		this.filename = photo_location;
	}

	
	
	public ArticlePhotoVO(int article_photo_id, int article_article_id, String filename) {
		super();
		this.article_photo_id = article_photo_id;
		this.article_article_id = article_article_id;
		this.filename = filename;
	}

	public int getArticle_article_id() {
		return article_article_id;
	}

	public void setArticle_article_id(int article_article_id) {
		this.article_article_id = article_article_id;
	}

	public String getFilename() {
		return filename;
	}

	public void setFilename(String filename) {
		this.filename = filename;
	}

	public int getArticle_photo_id() {
		return article_photo_id;
	}

	public void setArticle_photo_id(int article_photo_id) {
		this.article_photo_id = article_photo_id;
	}
	
}
