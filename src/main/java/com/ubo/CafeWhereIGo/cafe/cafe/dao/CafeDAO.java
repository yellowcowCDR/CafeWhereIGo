package com.ubo.CafeWhereIGo.cafe.cafe.dao;

import java.util.List;
import java.util.Map;

import com.ubo.CafeWhereIGo.cafe.cafe.vo.CafeSearchParameterForManagementVO;
import com.ubo.CafeWhereIGo.cafe.cafe.vo.CafeSearchParameterVO;
import com.ubo.CafeWhereIGo.cafe.cafe.vo.CafeSearchResultVO;
import com.ubo.CafeWhereIGo.cafe.cafe.vo.CafeVO;
import com.ubo.CafeWhereIGo.likedcafe.vo.LikedCafeVO;

public interface CafeDAO {
	//cafe info
	public void insertCafe(CafeVO cafeInfo);
	public List<CafeSearchResultVO> selectCafeList(CafeSearchParameterVO cafeSearchParameter);
	public List<Map> selectCafeListForManagement(CafeSearchParameterForManagementVO cafeSearchCondition);
	public CafeVO selectCafeDetail(int cafe_id);
	public void updateCafe(CafeVO cafeInfo);
	public void deleteCafe(int cafe_id);
	
	
	//cafe like
	public List<CafeSearchResultVO> selectLikeCafeList(String user_id);
	public void insertLikeCafe(LikedCafeVO likeInfo);
	public void deleteLikeCafe(LikedCafeVO likeInfo);
	public boolean selectIsLikeCafe(LikedCafeVO likeInfo);
	
	//helper function
	public int getRecentCafeId();
}
