package com.ubo.CafeWhereIGo.user.mileage.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ubo.CafeWhereIGo.user.mileage.dao.MileageHistoryDAO;
import com.ubo.CafeWhereIGo.user.mileage.vo.MileageHistoryVO;

@Transactional
@Service
public class MileageHitoryServiceImpl implements MileageHistoryService{

	@Autowired
	MileageHistoryDAO mileageHistoryDAO; 
	
	@Override
	public void addMileageHistory(MileageHistoryVO mileageHistory) {
		// TODO Auto-generated method stub
		mileageHistoryDAO.insertMileageHistory(mileageHistory);
	}

	@Override
	public List<MileageHistoryVO> getMileageHistoryByUserId(String user_id) {
		// TODO Auto-generated method stub
		List<MileageHistoryVO> mileageHistoryList = mileageHistoryDAO.selectMileageHistoryByUserId(user_id);
		return mileageHistoryList;
	}

	@Override
	public List<MileageHistoryVO> getOneMileageHistory(String mileageHistory_id) {
		// TODO Auto-generated method stub
		List<MileageHistoryVO> mileageHistoryList = mileageHistoryDAO.selectOneMileageHistory(mileageHistory_id);
		return mileageHistoryList;
	}

	@Override
	public void modifyMileageHistory(MileageHistoryVO mileageHistory) {
		// TODO Auto-generated method stub
		mileageHistoryDAO.updateMileageHistory(mileageHistory);
	}

	@Override
	public void deleteMileageHistory(int mileageHistory_id) {
		// TODO Auto-generated method stub
		mileageHistoryDAO.deleteMileageHistory(mileageHistory_id);
	}
	
}
