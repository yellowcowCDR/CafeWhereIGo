package com.ubo.CafeWhereIGo.cafe.facilityInfo.vo;

import org.springframework.stereotype.Component;

@Component
public class FacilityInfoVO {
	private int cafe_cafe_id;
	private boolean parking_lot;
	private boolean power_plug;
	private boolean wifi;
	
	public FacilityInfoVO() {
		super();
	}

	public FacilityInfoVO(int cafe_cafe_id, boolean parking_lot, boolean power_plug, boolean wifi) {
		super();
		this.cafe_cafe_id = cafe_cafe_id;
		this.parking_lot = parking_lot;
		this.power_plug = power_plug;
		this.wifi = wifi;
	}

	public int getCafe_cafe_id() {
		return cafe_cafe_id;
	}

	public void setCafe_cafe_id(int cafe_cafe_id) {
		this.cafe_cafe_id = cafe_cafe_id;
	}

	public boolean isParking_lot() {
		return parking_lot;
	}

	public void setParking_lot(boolean parking_lot) {
		this.parking_lot = parking_lot;
	}

	public boolean isPower_plug() {
		return power_plug;
	}

	public void setPower_plug(boolean power_plug) {
		this.power_plug = power_plug;
	}

	public boolean isWifi() {
		return wifi;
	}

	public void setWifi(boolean wifi) {
		this.wifi = wifi;
	}
	
	
}
