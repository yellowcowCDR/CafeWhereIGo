package com.ubo.CafeWhereIGo.cafe.cafe.vo;

public class CafeSearchParameterVO {
	String cafe_location1, cafe_location2, cafe_location3, cafe_location4;
	boolean power_plug=false, parking_lot=false, wifi=false, dontCare=true;
	int number_of_seat;
	String theme;
	String sortingOption="recent";
	String searchKeyword;
	String user_user_id;
	String business_state;
	int chapter=1, pageNum=1;
	
	public CafeSearchParameterVO() {
		super();
	}
	
	public CafeSearchParameterVO(String cafe_location1, String cafe_location2, String cafe_location3,
			String cafe_location4, boolean dontCare, boolean power_plug, boolean parking_lot, boolean wifi, int number_of_seat,
			String theme, String sortingOption, String searchKeyword, String user_user_id) {
		super();
		this.cafe_location1 = cafe_location1;
		this.cafe_location2 = cafe_location2;
		this.cafe_location3 = cafe_location3;
		this.cafe_location4 = cafe_location4;
		this.dontCare = dontCare;
		this.power_plug = power_plug;
		this.parking_lot = parking_lot;
		this.wifi = wifi;
		this.number_of_seat = number_of_seat;
		this.theme = theme;
		this.sortingOption = sortingOption;
		this.searchKeyword = searchKeyword;
		this.user_user_id  = user_user_id;
	}

	public CafeSearchParameterVO(String cafe_location1, String cafe_location2, String cafe_location3,
			String cafe_location4, boolean dontCare, boolean power_plug, boolean parking_lot, boolean wifi, int number_of_seat,
			String theme, String sortingOption, String searchKeyword, String user_user_id, int chapter, int pageNum) {
		super();
		this.cafe_location1 = cafe_location1;
		this.cafe_location2 = cafe_location2;
		this.cafe_location3 = cafe_location3;
		this.cafe_location4 = cafe_location4;
		this.dontCare = dontCare;
		this.power_plug = power_plug;
		this.parking_lot = parking_lot;
		this.wifi = wifi;
		this.number_of_seat = number_of_seat;
		this.theme = theme;
		this.sortingOption = sortingOption;
		this.searchKeyword = searchKeyword;
		this.user_user_id = user_user_id;
		this.chapter = chapter;
		this.pageNum = pageNum;
	}

	public String getCafe_location1() {
		return cafe_location1;
	}

	public void setCafe_location1(String cafe_location1) {
		this.cafe_location1 = cafe_location1;
	}

	public String getCafe_location2() {
		return cafe_location2;
	}

	public void setCafe_location2(String cafe_location2) {
		this.cafe_location2 = cafe_location2;
	}

	public String getCafe_location3() {
		return cafe_location3;
	}

	public void setCafe_location3(String cafe_location3) {
		this.cafe_location3 = cafe_location3;
	}

	public String getCafe_location4() {
		return cafe_location4;
	}

	public void setCafe_location4(String cafe_location4) {
		this.cafe_location4 = cafe_location4;
	}
	
	public boolean getDontCare() {
		return dontCare;
	}
	
	public void setDontCare(boolean dontCare) {
		this.dontCare = dontCare;
	}

	public boolean isPower_plug() {
		return power_plug;
	}

	public void setPower_plug(boolean power_plug) {
		this.power_plug = power_plug;
	}

	public boolean isParking_lot() {
		return parking_lot;
	}

	public void setParking_lot(boolean parking_lot) {
		this.parking_lot = parking_lot;
	}

	public boolean isWifi() {
		return wifi;
	}

	public void setWifi(boolean wifi) {
		this.wifi = wifi;
	}

	public int getNumber_of_seat() {
		return number_of_seat;
	}

	public void setNumber_of_seat(int number_of_seat) {
		this.number_of_seat = number_of_seat;
	}

	public String getTheme() {
		return theme;
	}

	public void setTheme(String theme) {
		this.theme = theme;
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
	
	public String getUser_user_id() {
		return user_user_id;
	}

	public void setUser_user_id(String user_user_id) {
		this.user_user_id = user_user_id;
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
