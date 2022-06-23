package com.ubo.CafeWhereIGo.cafe.parkinglot.vo;

import org.springframework.stereotype.Component;

@Component
public class ParkingLotVO {
	private int parking_lot_id;
	private String parking_lot_name;
	private String parking_lot_location1;
	private String parking_lot_location2;
	private int cafe_cafe_id;
	public ParkingLotVO() {
		super();
	}
		
	public ParkingLotVO(int parking_lot_id, String parking_lot_name, String parking_lot_location1,
			String parking_lot_location2) {
		super();
		this.parking_lot_id = parking_lot_id;
		this.parking_lot_name = parking_lot_name;
		this.parking_lot_location1 = parking_lot_location1;
		this.parking_lot_location2 = parking_lot_location2;
	}

	public ParkingLotVO(String parking_lot_name, String parking_lot_location1, String parking_lot_location2,
			int cafe_cafe_id) {
		super();
		this.parking_lot_name = parking_lot_name;
		this.parking_lot_location1 = parking_lot_location1;
		this.parking_lot_location2 = parking_lot_location2;
		this.cafe_cafe_id = cafe_cafe_id;
	}
	public ParkingLotVO(int parking_lot_id, String parking_lot_name, String parking_lot_location1,
			String parking_lot_location2, int cafe_cafe_id) {
		super();
		this.parking_lot_id = parking_lot_id;
		this.parking_lot_name = parking_lot_name;
		this.parking_lot_location1 = parking_lot_location1;
		this.parking_lot_location2 = parking_lot_location2;
		this.cafe_cafe_id = cafe_cafe_id;
	}
	public int getParking_lot_id() {
		return parking_lot_id;
	}
	public void setParking_lot_id(int parking_lot_id) {
		this.parking_lot_id = parking_lot_id;
	}
	public String getParking_lot_name() {
		return parking_lot_name;
	}
	public void setParking_lot_name(String parking_lot_name) {
		this.parking_lot_name = parking_lot_name;
	}
	public String getParking_lot_location1() {
		return parking_lot_location1;
	}
	public void setParking_lot_location1(String parking_lot_location1) {
		this.parking_lot_location1 = parking_lot_location1;
	}
	public String getParking_lot_location2() {
		return parking_lot_location2;
	}
	public void setParking_lot_location2(String parking_lot_location2) {
		this.parking_lot_location2 = parking_lot_location2;
	}
	public int getCafe_cafe_id() {
		return cafe_cafe_id;
	}
	public void setCafe_cafe_id(int cafe_cafe_id) {
		this.cafe_cafe_id = cafe_cafe_id;
	}
	
	
}
