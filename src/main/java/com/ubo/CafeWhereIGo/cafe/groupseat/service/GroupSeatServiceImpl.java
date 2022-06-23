package com.ubo.CafeWhereIGo.cafe.groupseat.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.ubo.CafeWhereIGo.cafe.groupseat.dao.GroupSeatDAO;
import com.ubo.CafeWhereIGo.cafe.groupseat.vo.GroupSeatVO;
import com.ubo.CafeWhereIGo.cafe.groupseatphoto.vo.GroupSeatPhotoInfoVO;
import com.ubo.CafeWhereIGo.cafe.groupseatphoto.vo.GroupSeatPhotoVO;

@Transactional
@Service
public class GroupSeatServiceImpl implements GroupSeatService {
	@Autowired
	GroupSeatDAO groupSeatDAO;

	
	
	@Override
	public List<GroupSeatPhotoInfoVO> registerGroupSeat(MultipartHttpServletRequest multipartRequest, int cafe_id,
			int groupSeatSize) {
		// TODO Auto-generated method stub
		List<GroupSeatPhotoInfoVO> groupSeatPhotoInfoList = new ArrayList<GroupSeatPhotoInfoVO>();
		for(int i=1; i<=groupSeatSize;i++) {
			//register goods
			
			String seat_name=multipartRequest.getParameter("groupSeat"+i+"_name");
			int price = Integer.parseInt(multipartRequest.getParameter("groupSeat"+i+"_price"));
			String description=multipartRequest.getParameter("groupSeat"+i+"description"); 
			GroupSeatVO goods = new GroupSeatVO(seat_name, price, description, cafe_id);
			groupSeatDAO.insertGroupSeat(goods);
			
			int seat_id= groupSeatDAO.getRecentGroupSeatId();
			
			//register goods photo info
			String fileName = "goodsphoto" + i;
			MultipartFile mFile = multipartRequest.getFile(fileName);
			String OrgFilename = mFile.getOriginalFilename();
			
			if(!OrgFilename.equals("") || OrgFilename!=null) {
				if(mFile.getSize()>0) {
					GroupSeatPhotoVO groupSeatPhoto = new GroupSeatPhotoVO(seat_id, OrgFilename);
					groupSeatDAO.insertGroupSeatPhoto(groupSeatPhoto);
					GroupSeatPhotoInfoVO goodsPhotoInfo = new GroupSeatPhotoInfoVO(seat_id, fileName, OrgFilename);
					groupSeatPhotoInfoList.add(goodsPhotoInfo);
				}
			}
		}
		return groupSeatPhotoInfoList;
	}

	
	
	@Override
	public int registerGroupSeat(GroupSeatVO groupSeat) {
		// TODO Auto-generated method stub
		groupSeatDAO.insertGroupSeat(groupSeat);
		int groupSeat_id = groupSeatDAO.getRecentGroupSeatId();
		
		return groupSeat_id;
	}



	@Override
	public void deleteGroupSeat(int groupseat_id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void modifyGroupSeat(MultipartHttpServletRequest multipartRequest, int cafe_id, int groupSeatSize) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void modifyGroupSeat(GroupSeatVO groupSeat) {
		// TODO Auto-generated method stub
		groupSeatDAO.updateGroupSeat(groupSeat);
	}
	
	@Override
	public List<GroupSeatVO> getGroupSeatList(int cafe_id) {
		// TODO Auto-generated method stub
		 List<GroupSeatVO> groupSeatList = groupSeatDAO.selectGroupSeat(cafe_id);
		return groupSeatList;
	}
	
	@Override
	public GroupSeatVO getOneGroupSeat(int groupseat_id) {
		GroupSeatVO groupseat = groupSeatDAO.selectOneGroupSeat(groupseat_id);
		return groupseat;
	}
	

	@Override
	public void registerGroupSeatPhoto(GroupSeatPhotoVO groupseatPhoto) {
		// TODO Auto-generated method stub
		groupSeatDAO.insertGroupSeatPhoto(groupseatPhoto);
	}

	@Override
	public void modifyGroupSeatPhoto(GroupSeatPhotoVO goodsPhoto) {
		// TODO Auto-generated method stub
		groupSeatDAO.updateGroupSeatPhoto(goodsPhoto);
	}

	@Override
	public GroupSeatPhotoVO getGroupSeatPhoto(int groupSeat_id) {
		// TODO Auto-generated method stub
		GroupSeatPhotoVO groupSeatPhoto = groupSeatDAO.selectGroupSeatPhoto(groupSeat_id);
		return groupSeatPhoto;
	}

	@Override
	public void deleteGroupSeatPhoto(int goods_id) {
		// TODO Auto-generated method stub
		groupSeatDAO.deleteGroupSeatByGoodsId(goods_id);
	}

		
	
}
