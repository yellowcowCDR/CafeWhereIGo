package com.ubo.CafeWhereIGo.cafe.cafe.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ubo.CafeWhereIGo.cafe.cafe.vo.CafeSearchResultVO;
import com.ubo.CafeWhereIGo.cafe.cafe.vo.CafeVO;

@Repository
public class CafeDAOImpl implements CafeDAO {
	Logger logger = LoggerFactory.getLogger(CafeDAOImpl.class);
	@Autowired
	SqlSession sqlSession;

	@Override
	public void insertCafe(CafeVO cafeInfo) {
		// TODO Auto-generated method stub
		sqlSession.insert("mapper.cafe.insertCafe", cafeInfo);
	}

	@Override
	public List<CafeSearchResultVO> selectCafeList() {
		// TODO Auto-generated method stub
		List<CafeSearchResultVO> cafeSearchResultList= sqlSession.selectList("mapper.cafe.selectCafeList");
		logger.debug("[@CafeDAOImpl, selectCafeList] cafeSearchResultList is null?: " +(cafeSearchResultList==null));
		return cafeSearchResultList;
	}

	@Override
	public CafeVO selectCafeDetail(int cafe_id) {
		// TODO Auto-generated method stub
		CafeVO cafeInfo = (CafeVO) sqlSession.selectOne("mapper.cafe.selectCafe",cafe_id);
		return cafeInfo;
	}

	@Override
	public void updateCafe(CafeVO cafeInfo) {
		// TODO Auto-generated method stub
		sqlSession.update("mapper.cafe.insertCafe", cafeInfo);
	}

	@Override
	public void deleteCafe(int cafe_id) {
		// TODO Auto-generated method stub
		sqlSession.delete("mapper.cafe.deleteCafe", cafe_id);
	}

	@Override
	public int getRecentCafeId() {
		// TODO Auto-generated method stub
		int cafe_id = (Integer)sqlSession.selectOne("mapper.cafe.selectRecentCafeId");
		return cafe_id;
	}
	
	
}
