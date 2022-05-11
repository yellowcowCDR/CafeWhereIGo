package com.ubo.CafeWhereIGo.article.vo;

public class SearchConditionVO {
	private String searchCondition;
	private String searchWords;
	
	public SearchConditionVO(String searchCondition, String searchWords) {
		super();
		this.searchCondition = searchCondition;
		this.searchWords = searchWords;
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
	
	
}
