package com.ubo.CafeWhereIGo.article.vo;

import org.springframework.stereotype.Component;

@Component
public class ArticleSearchConditionVO {
	private String searchCondition;
	private String searchWords;
	private String articleType;
	private String sortingOption = "recent";
	
	private int pageNum=1;
	private int chapter=1;
	
	public ArticleSearchConditionVO() {
		super();
	}

	public ArticleSearchConditionVO(String searchCondition, String searchWords, String articleType, String sortingOption,
			int pageNum, int chapter) {
		super();
		this.searchCondition = searchCondition;
		this.searchWords = searchWords;
		this.articleType = articleType;
		this.sortingOption = sortingOption;
		this.pageNum = pageNum;
		this.chapter = chapter;
	}



	public String getSearchCondition() {
		return searchCondition;
	}



	public void setSearchCondition(String searchCondition) {
		this.searchCondition = searchCondition;
	}



	public String getSearchWords() {
		return searchWords;
	}



	public void setSearchWords(String searchWords) {
		this.searchWords = searchWords;
	}



	public String getArticleType() {
		return articleType;
	}



	public void setArticleType(String articleType) {
		this.articleType = articleType;
	}



	public String getsortingOption() {
		return sortingOption;
	}



	public void setsortingOption(String sortingOption) {
		this.sortingOption = sortingOption;
	}



	public int getPageNum() {
		return pageNum;
	}



	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}



	public int getChapter() {
		return chapter;
	}



	public void setChapter(int chapter) {
		this.chapter = chapter;
	}
}
