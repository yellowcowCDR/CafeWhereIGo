package com.ubo.CafeWhereIGo.cafe.groupseatphoto.vo;

import org.springframework.stereotype.Component;

@Component
public class GroupSeatPhotoVO {
	private int GroupSeat_groupseat_id;
	private String filename;
	
	public GroupSeatPhotoVO() {
		super();
	}

	public GroupSeatPhotoVO(int groupSeat_groupseat_id, String filename) {
		super();
		GroupSeat_groupseat_id = groupSeat_groupseat_id;
		this.filename = filename;
	}

	public int getGroupSeat_groupseat_id() {
		return GroupSeat_groupseat_id;
	}

	public void setGroupSeat_groupseat_id(int groupSeat_groupseat_id) {
		GroupSeat_groupseat_id = groupSeat_groupseat_id;
	}

	public String getFilename() {
		return filename;
	}

	public void setFilename(String filename) {
		this.filename = filename;
	}
	
}
