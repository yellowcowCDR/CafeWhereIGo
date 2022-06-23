package com.ubo.CafeWhereIGo.user.mileage.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ubo.CafeWhereIGo.user.mileage.vo.MileageHistoryVO;

@Repository
public class MileageHistoryDAOImpl implements MileageHistoryDAO {
	@Autowired
	SqlSession sqlSession;
	

	@Override
	public void insertMileageHistory(MileageHistoryVO mileageHistory) {
		// TODO Auto-generated method stub
		sqlSession.insert("mapper.mileage.insertMileageHistory", mileageHistory);
	}

	@Override
	public List<MileageHistoryVO> selectMileageHistoryByUserId(String user_id) {
		// TODO Auto-generated method stub
		List<MileageHistoryVO> mileageHistory = sqlSession.selectList("mapper.mileage.selectMileageHistoryByUserId", user_id);
		return mileageHistory;
	}

	@Override
	public List<MileageHistoryVO> selectOneMileageHistory(String mileageHistory_id) {
		// TODO Auto-generated method stub
		List<MileageHistoryVO> mileageHistory = sqlSession.selectList("mapper.mileage.selectOneMileageHistory", mileageHistory_id);
		return mileageHistory;
	}

	@Override
	public void updateMileageHistory(MileageHistoryVO mileageHistory) {
		// TODO Auto-generated method stub
		sqlSession.update("mapper.mileage.updateMileageHistory", mileageHistory);
	}

	@Override
	public void deleteMileageHistory(int mileageHistory_id) {
		// TODO Auto-generated method stub
		sqlSession.delete("mapper.mileage.deleteMileageHistory", mileageHistory_id);
	}
	
}
