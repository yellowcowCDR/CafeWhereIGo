package com.ubo.CafeWhereIGo.cafe.cafe.dao;

import java.util.List;

import com.ubo.CafeWhereIGo.cafe.cafe.vo.CafeSearchResultVO;
import com.ubo.CafeWhereIGo.cafe.cafe.vo.CafeVO;

public interface CafeDAO {
	//cafe info
	public void insertCafe(CafeVO cafeInfo);
	public List<CafeSearchResultVO> selectCafeList();
	public CafeVO selectCafeDetail(int cafe_id);
	public void updateCafe(CafeVO cafeInfo);
	public void deleteCafe(int cafe_id);
	
	//helper function
	public int getRecentCafeId();
}
