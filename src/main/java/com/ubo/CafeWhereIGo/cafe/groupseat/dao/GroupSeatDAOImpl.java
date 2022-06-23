package com.ubo.CafeWhereIGo.cafe.groupseat.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ubo.CafeWhereIGo.cafe.goodsphoto.vo.GoodsPhotoVO;
import com.ubo.CafeWhereIGo.cafe.groupseat.vo.GroupSeatVO;
import com.ubo.CafeWhereIGo.cafe.groupseatphoto.vo.GroupSeatPhotoVO;

@Repository
public class GroupSeatDAOImpl implements GroupSeatDAO{
	@Autowired
	SqlSession sqlSession;

	@Override
	public void insertGroupSeat(GroupSeatVO groupseat) {
		// TODO Auto-generated method stub
		sqlSession.insert("mapper.cafeGroupSeat.insertGroupSeat",groupseat);
	}

	@Override
	public void updateGroupSeat(GroupSeatVO groupseat) {
		// TODO Auto-generated method stub
		sqlSession.update("mapper.cafeGroupSeat.updateGroupSeat",groupseat);
	}

	@Override
	public List<GroupSeatVO> selectGroupSeat(int cafe_id) {
		// TODO Auto-generated method stub
		List<GroupSeatVO> groupseatList = sqlSession.selectList("mapper.cafeGroupSeat.selectGroupSeat",cafe_id);
		return groupseatList;
	}

	@Override
	public GroupSeatVO selectOneGroupSeat(int groupseat_id) {
		// TODO Auto-generated method stub
		GroupSeatVO groupseat = (GroupSeatVO) sqlSession.selectOne("mapper.cafeGroupSeat.selectOneGroupSeat", groupseat_id);
		return groupseat;
	}

	@Override
	public void deleteGroupSeatByCafeId(int cafe_id) {
		// TODO Auto-generated method stub
		sqlSession.delete("mapper.cafeGroupSeat.deleteGroupSeatByCafeId", cafe_id);
	}

	@Override
	public void deleteGroupSeatByGoodsId(int seat_id) {
		// TODO Auto-generated method stub
		sqlSession.delete("mapper.cafeGroupSeat.deleteGroupSeat", seat_id);
	}

	@Override
	public void insertGroupSeatPhoto(GroupSeatPhotoVO groupseatPhoto) {
		// TODO Auto-generated method stub
		sqlSession.insert("mapper.cafeGroupSeatPhoto.insertGroupSeatPhoto",groupseatPhoto);
	}

	@Override
	public void updateGroupSeatPhoto(GroupSeatPhotoVO groupseatPhoto) {
		// TODO Auto-generated method stub
		sqlSession.update("mapper.cafeGroupSeatPhoto.updateGroupSeatPhoto",groupseatPhoto);
	}

	@Override
	public GroupSeatPhotoVO selectGroupSeatPhoto(int seat_id) {
		// TODO Auto-generated method stub
		GroupSeatPhotoVO groupSeatPhoto = (GroupSeatPhotoVO)sqlSession.selectOne("mapper.cafeGroupSeatPhoto.selectGroupSeatPhoto",seat_id);
		return groupSeatPhoto;
	}

	@Override
	public void deleteGroupSeatPhoto(int seat_id) {
		// TODO Auto-generated method stub
		sqlSession.delete("mapper.cafeGroupSeatPhoto.deleteGroupSeatPhoto",seat_id);
	}

	@Override
	public int getRecentGroupSeatId() {
		// TODO Auto-generated method stub
		int groupseat_id = (Integer)sqlSession.selectOne("mapper.cafeGroupSeat.selectRecentGroupSeatId");
		return groupseat_id;
	}
	
	
}
