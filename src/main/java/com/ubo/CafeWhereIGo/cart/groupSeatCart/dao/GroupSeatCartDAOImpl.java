package com.ubo.CafeWhereIGo.cart.groupSeatCart.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ubo.CafeWhereIGo.cart.groupSeatCart.vo.GroupSeatCartSearchResultVO;
import com.ubo.CafeWhereIGo.cart.groupSeatCart.vo.GroupSeatCartVO;

@Repository
public class GroupSeatCartDAOImpl implements GroupSeatCartDAO{
	@Autowired
	SqlSession sqlSession;

	@Override
	public void insertGroupSeatCart(GroupSeatCartVO groupSeatCart) {
		// TODO Auto-generated method stub
		sqlSession.insert("mapper.groupSeatCart.insertGroupSeatCart", groupSeatCart);
	}

	@Override
	public List<GroupSeatCartSearchResultVO> selectGroupSeatListByCafeId(int cafe_id) {
		// TODO Auto-generated method stub
		List<GroupSeatCartSearchResultVO> groupSeatCartList =
				sqlSession.selectList("mapper.groupSeatCart.selectGroupSeatCartByCafeId",cafe_id);
		return groupSeatCartList;
	}

	@Override
	public List<GroupSeatCartSearchResultVO> selectGroupSeatListByUserId(String user_id) {
		// TODO Auto-generated method stub
		List<GroupSeatCartSearchResultVO> groupSeatCartList =
		sqlSession.selectList("mapper.groupSeatCart.selectGroupSeatCartByUserId",user_id);
		return groupSeatCartList;
	}

	@Override
	public void updateGroupSeatCart(GroupSeatCartVO groupSeatCart) {
		// TODO Auto-generated method stub
		sqlSession.update("mapper.groupSeatCart.updateGroupSeatCart",groupSeatCart);
	}

	@Override
	public void deleteGroupSeatCart(int cart_id) {
		// TODO Auto-generated method stub
		sqlSession.delete("mapper.groupSeatCart.deleteGroupSeatCart",cart_id);
	}
	
	
}
