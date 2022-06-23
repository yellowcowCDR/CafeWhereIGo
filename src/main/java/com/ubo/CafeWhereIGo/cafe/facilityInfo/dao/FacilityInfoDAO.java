package com.ubo.CafeWhereIGo.cafe.facilityInfo.dao;

import com.ubo.CafeWhereIGo.cafe.facilityInfo.vo.FacilityInfoVO;

public interface FacilityInfoDAO {
	public void insertFacilityInfo(FacilityInfoVO facilityInfo);
	public void updateFacilityInfo(FacilityInfoVO facilityInfo);
	public FacilityInfoVO selectFacilityInfo(int cafe_id);
	public void deleteFacilityInfo(int cafe_id);
}
