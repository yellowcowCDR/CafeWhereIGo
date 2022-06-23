package com.ubo.CafeWhereIGo.cafe.themescore.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ubo.CafeWhereIGo.cafe.themescore.vo.ThemeScoreVO;

@Repository
public class ThemeScoreDAOImpl implements ThemeScoreDAO {
	@Autowired
	SqlSession sqlSession;

	@Override
	public void insertThemeScore(ThemeScoreVO themeScore) {
		// TODO Auto-generated method stub
		sqlSession.insert("mapper.cafeThemeScore.insertThemeScore", themeScore);
	}

	@Override
	public List<ThemeScoreVO> selectThemeScores(int cafe_id) {
		// TODO Auto-generated method stub
		List<ThemeScoreVO> themeScoreList = sqlSession.selectList("mapper.cafeThemeScore.selectThemeScores", cafe_id);
		return themeScoreList;
	}

	@Override
	public ThemeScoreVO selectThemeScore(int review_id) {
		// TODO Auto-generated method stub
		ThemeScoreVO themeScore = (ThemeScoreVO)sqlSession.selectOne("mapper.cafeThemeScore.selectThemeScore", review_id);
		return themeScore;
	}

	@Override
	public void updateThemeScore(ThemeScoreVO themeScore) {
		// TODO Auto-generated method stub
		sqlSession.update("mapper.cafeThemeScore.updateThemeScore", themeScore);
	}

	@Override
	public void deleteThemeScore(int review_id) {
		// TODO Auto-generated method stub
		sqlSession.delete("mapper.cafeThemeScore.deleteThemeScore", review_id);
	}
	
	
}
