package com.ubo.CafeWhereIGo.cafe.cafe.vo;

public class CafeSearchParameterForManagementVO {	
	String sortingOption="recent";
	String searchKeyword;
	String business_state;
	int chapter=1, pageNum=1;
	
	public CafeSearchParameterForManagementVO() {
		super();
	}

	public CafeSearchParameterForManagementVO(String sortingOption, String searchKeyword, String business_state,
			int chapter) {
		super();
		this.sortingOption = sortingOption;
		this.searchKeyword = searchKeyword;
		this.business_state = business_state;
		this.chapter = chapter;
	}

	public CafeSearchParameterForManagementVO(String sortingOption, String searchKeyword, String business_state,
			int chapter, int pageNum) {
		super();
		this.sortingOption = sortingOption;
		this.searchKeyword = searchKeyword;
		this.business_state = business_state;
		this.chapter = chapter;
		this.pageNum = pageNum;
	}

	public String getSortingOption() {
		return sortingOption;
	}

	public void setSortingOption(String sortingOption) {
		this.sortingOption = sortingOption;
	}

	public String getSearchKeyword() {
		return searchKeyword;
	}

	public void setSearchKeyword(String searchKeyword) {
		this.searchKeyword = searchKeyword;
	}

	public String getBusiness_state() {
		return business_state;
	}

	public void setBusiness_state(String business_state) {
		this.business_state = business_state;
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
