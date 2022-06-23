package com.ubo.CafeWhereIGo.cafe.themescore.dao;

import java.util.List;

import com.ubo.CafeWhereIGo.cafe.themescore.vo.ThemeScoreVO;

public interface ThemeScoreDAO {
	public void insertThemeScore(ThemeScoreVO themeScore);
	public List<ThemeScoreVO> selectThemeScores(int cafe_id);
	public ThemeScoreVO selectThemeScore(int review_id);
	public void updateThemeScore(ThemeScoreVO themeScore);
	public void deleteThemeScore(int review_id);
}
