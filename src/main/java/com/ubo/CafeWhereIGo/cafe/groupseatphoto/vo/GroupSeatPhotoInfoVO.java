package com.ubo.CafeWhereIGo.cafe.groupseatphoto.vo;

import org.springframework.stereotype.Component;

@Component
public class GroupSeatPhotoInfoVO {
	int groupSeat_id;
	String filename;
	String orgFilename;
	
	
	
	public GroupSeatPhotoInfoVO() {
		super();
	}



	public GroupSeatPhotoInfoVO(int groupSeat_id, String filename, String orgFilename) {
		super();
		this.groupSeat_id = groupSeat_id;
		this.filename = filename;
		this.orgFilename = orgFilename;
	}



	public int getGroupSeat_id() {
		return groupSeat_id;
	}



	public void setGroupSeat_id(int groupSeat_id) {
		this.groupSeat_id = groupSeat_id;
	}



	public String getFilename() {
		return filename;
	}



	public void setFilename(String filename) {
		this.filename = filename;
	}



	public String getOrgFilename() {
		return orgFilename;
	}



	public void setOrgFilename(String orgFilename) {
		this.orgFilename = orgFilename;
	}
	
	
}
