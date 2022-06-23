package com.ubo.CafeWhereIGo.orderAndReservation.reservation.vo;

import org.springframework.stereotype.Component;

@Component
public class OrderAndReservationSearchConditionVo {
	private String searchCondition="order";
	private String searchWords;
	private String orderState;
	private String sortingOption = "recent";
	
	private int pageNum=1;
	private int chapter=1;
	
	
	
	public OrderAndReservationSearchConditionVo() {
		super();
	}



	public OrderAndReservationSearchConditionVo(String searchCondition, String searchWords, String orderState,
			String sortingOption, int pageNum, int chapter) {
		super();
		this.searchCondition = searchCondition;
		this.searchWords = searchWords;
		this.orderState = orderState;
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



	public String getOrderState() {
		return orderState;
	}



	public void setOrderState(String orderState) {
		this.orderState = orderState;
	}



	public String getSortingOption() {
		return sortingOption;
	}



	public void setSortingOption(String sortingOption) {
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
