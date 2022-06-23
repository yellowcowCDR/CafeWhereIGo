package com.ubo.CafeWhereIGo.cart.groupSeatCart.dao;

import java.util.List;

import com.ubo.CafeWhereIGo.cart.groupSeatCart.vo.GroupSeatCartSearchResultVO;
import com.ubo.CafeWhereIGo.cart.groupSeatCart.vo.GroupSeatCartVO;

public interface GroupSeatCartDAO {
	public void insertGroupSeatCart(GroupSeatCartVO groupSeatCart);
	public List<GroupSeatCartSearchResultVO> selectGroupSeatListByCafeId(int cafe_id);
	public List<GroupSeatCartSearchResultVO> selectGroupSeatListByUserId(String user_id);
	public void updateGroupSeatCart(GroupSeatCartVO groupSeatCart);
	public void deleteGroupSeatCart(int cart_id);
}
