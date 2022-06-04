package com.ubo.CafeWhereIGo.cafe.groupseat.dao;

import java.util.List;

import com.ubo.CafeWhereIGo.cafe.groupseat.vo.GroupSeatVO;
import com.ubo.CafeWhereIGo.cafe.groupseatphoto.vo.GroupSeatPhotoVO;

public interface GroupSeatDAO {
	//Group Seat
	public void insertGroupSeat(GroupSeatVO groupseat);
	public void updateGroupSeat(GroupSeatVO groupseat);
	public List<GroupSeatVO> selectGroupSeat(int cafe_id);
	public GroupSeatVO selectOneGroupSeat(int groupseat_id);
	public void deleteGroupSeatByCafeId(int cafe_id);
	public void deleteGroupSeatByGoodsId(int goods_id);
	
	//Group Seat Photo
	public void insertGroupSeatPhoto (GroupSeatPhotoVO groupseatPhoto);
	public void updateGroupSeatPhoto(GroupSeatPhotoVO goodsPhoto);
	public GroupSeatPhotoVO selectGroupSeatPhoto(int goods_id);
	public void deleteGroupSeatPhoto(int goods_id);
	
	//helper function
	public int getRecentGroupSeatId();
}
