package com.ubo.CafeWhereIGo.user.mileage.Service;

import java.util.List;

import com.ubo.CafeWhereIGo.user.mileage.vo.MileageHistoryVO;

public interface MileageHistoryService {
	public void addMileageHistory(MileageHistoryVO mileageHistory);
	
	public List<MileageHistoryVO> getMileageHistoryByUserId(String user_id);

	public List<MileageHistoryVO> getOneMileageHistory(String mileageHistory_id);
	
	public void modifyMileageHistory(MileageHistoryVO mileageHistory);

	public void deleteMileageHistory(int mileageHistory_id);
}
