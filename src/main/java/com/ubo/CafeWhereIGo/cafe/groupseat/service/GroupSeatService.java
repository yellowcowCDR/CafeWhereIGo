package com.ubo.CafeWhereIGo.cafe.groupseat.service;

import java.util.List;

import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.ubo.CafeWhereIGo.cafe.goodsphoto.vo.GoodsPhotoVO;
import com.ubo.CafeWhereIGo.cafe.groupseat.vo.GroupSeatVO;
import com.ubo.CafeWhereIGo.cafe.groupseatphoto.vo.GroupSeatPhotoInfoVO;
import com.ubo.CafeWhereIGo.cafe.groupseatphoto.vo.GroupSeatPhotoVO;

public interface GroupSeatService {
	//group seat
	public List<GroupSeatPhotoInfoVO> registerGroupSeat(MultipartHttpServletRequest multipartRequest, int cafe_id, int groupSeatSize);
	public int registerGroupSeat(GroupSeatVO groupSeat);
	public void deleteGroupSeat(int groupseat_id);
	public void modifyGroupSeat(MultipartHttpServletRequest multipartRequest, int cafe_id, int groupSeatSize);
	public void modifyGroupSeat(GroupSeatVO groupSeat);
	public List<GroupSeatVO> getGroupSeatList(int cafe_id);
	
	//group seat photo
	public void registerGroupSeatPhoto (GroupSeatPhotoVO groupseatPhoto);
	public void modifyGroupSeatPhoto(GroupSeatPhotoVO goodsPhoto);
	public GroupSeatPhotoVO getGroupSeatPhoto(int groupSeat_id);
	public void deleteGroupSeatPhoto(int goods_id);
	GroupSeatVO getOneGroupSeat(int groupseat_id);
	
}
