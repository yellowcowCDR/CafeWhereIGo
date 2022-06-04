package com.ubo.CafeWhereIGo.cafe.facilityInfo.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ubo.CafeWhereIGo.cafe.facilityInfo.vo.FacilityInfoVO;

@Repository
public class FacilityInfoDAOImpl implements FacilityInfoDAO{
	@Autowired
	SqlSession sqlSession;

	@Override
	public void insertFacilityInfo(FacilityInfoVO facilityInfo) {
		// TODO Auto-generated method stub
		sqlSession.insert("mapper.cafeFacility.insertFacility", facilityInfo);
	}

	@Override
	public void updateFacilityInfo(FacilityInfoVO facilityInfo) {
		// TODO Auto-generated method stub
		sqlSession.update("mapper.cafeFacility.updateFacility", facilityInfo);
	}

	@Override
	public FacilityInfoVO selectFacilityInfo(int cafe_id) {
		// TODO Auto-generated method stub
		FacilityInfoVO facilityInfo = (FacilityInfoVO)sqlSession.selectOne("mapper.cafeFacility.selectFacility", cafe_id);
		return facilityInfo;
	}

	@Override
	public void deleteFacilityInfo(int cafe_id) {
		// TODO Auto-generated method stub
		sqlSession.delete("mapper.cafeFacility.deleteFacility", cafe_id);
	}
}
