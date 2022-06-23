package com.ubo.CafeWhereIGo.user.mileage.dao;

import java.util.List;

import com.ubo.CafeWhereIGo.user.mileage.vo.MileageHistoryVO;

public interface MileageHistoryDAO {
	public void insertMileageHistory(MileageHistoryVO mileageHistory);
	
	public List<MileageHistoryVO> selectMileageHistoryByUserId(String user_id);

	public List<MileageHistoryVO> selectOneMileageHistory(String mileageHistory_id);
	
	public void updateMileageHistory(MileageHistoryVO mileageHistory);

	public void deleteMileageHistory(int mileageHistory_id);
}
