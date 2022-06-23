package com.ubo.CafeWhereIGo.user.user.vo;

public class UserSearchParameterVO {
	String sortingOption ="recent";
	String join_state;
	String searchCondition="all";
	String searchWords;
	
	int chapter=1, pageNum=1;
	
	

	public UserSearchParameterVO() {
		super();
	}

	

	public UserSearchParameterVO(String sortingOption, String join_state, String searchCondition, String searchWords) {
		super();
		this.sortingOption = sortingOption;
		this.join_state = join_state;
		this.searchCondition = searchCondition;
		this.searchWords = searchWords;
	}



	public UserSearchParameterVO(String sortingOption, String join_state, String searchCondition, String searchWords,
			int chapter, int pageNum) {
		super();
		this.sortingOption = sortingOption;
		this.join_state = join_state;
		this.searchCondition = searchCondition;
		this.searchWords = searchWords;
		this.chapter = chapter;
		this.pageNum = pageNum;
	}



	public String getSortingOption() {
		return sortingOption;
	}



	public void setSortingOption(String sortingOption) {
		this.sortingOption = sortingOption;
	}



	public String getJoin_state() {
		return join_state;
	}



	public void setJoin_state(String join_state) {
		this.join_state = join_state;
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



	public int getChapter() {
		return chapter;
	}



	public void setChapter(int chapter) {
		this.chapter = chapter;
	}



	public int getPageNum() {
		return pageNum;
	}



	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}
	
	
}
