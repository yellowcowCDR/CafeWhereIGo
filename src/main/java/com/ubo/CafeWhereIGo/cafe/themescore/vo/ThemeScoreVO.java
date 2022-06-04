package com.ubo.CafeWhereIGo.cafe.themescore.vo;

import org.springframework.stereotype.Component;

@Component
public class ThemeScoreVO {
	private int theme_score_id;
	private int coffee_score;
	private int dessert_score;
	private int drink_score;
	private int mood_score;
	private int quiet_score;
	private int view_score;
	private int cafe_cafe_id;
	private int review_review_id;
	public ThemeScoreVO() {
		super();
	}
	
	public ThemeScoreVO(int coffee_score, int dessert_score, int drink_score, int mood_score, int quiet_score,
			int view_score, int cafe_cafe_id, int review_review_id) {
		super();
		this.coffee_score = coffee_score;
		this.dessert_score = dessert_score;
		this.drink_score = drink_score;
		this.mood_score = mood_score;
		this.quiet_score = quiet_score;
		this.view_score = view_score;
		this.cafe_cafe_id = cafe_cafe_id;
		this.review_review_id = review_review_id;
	}

	public ThemeScoreVO(int theme_score_id, int coffee_score, int dessert_score, int drink_score, int mood_score,
			int quiet_score, int view_score, int cafe_cafe_id, int review_review_id) {
		super();
		this.theme_score_id = theme_score_id;
		this.coffee_score = coffee_score;
		this.dessert_score = dessert_score;
		this.drink_score = drink_score;
		this.mood_score = mood_score;
		this.quiet_score = quiet_score;
		this.view_score = view_score;
		this.cafe_cafe_id = cafe_cafe_id;
		this.review_review_id = review_review_id;
	}

	public int getTheme_score_id() {
		return theme_score_id;
	}

	public void setTheme_score_id(int theme_score_id) {
		this.theme_score_id = theme_score_id;
	}

	public int getCoffee_score() {
		return coffee_score;
	}

	public void setCoffee_score(int coffee_score) {
		this.coffee_score = coffee_score;
	}

	public int getDessert_score() {
		return dessert_score;
	}

	public void setDessert_score(int dessert_score) {
		this.dessert_score = dessert_score;
	}

	public int getDrink_score() {
		return drink_score;
	}

	public void setDrink_score(int drink_score) {
		this.drink_score = drink_score;
	}

	public int getMood_score() {
		return mood_score;
	}

	public void setMood_score(int mood_score) {
		this.mood_score = mood_score;
	}

	public int getQuiet_score() {
		return quiet_score;
	}

	public void setQuiet_score(int quiet_score) {
		this.quiet_score = quiet_score;
	}

	public int getView_score() {
		return view_score;
	}

	public void setView_score(int view_score) {
		this.view_score = view_score;
	}

	public int getCafe_cafe_id() {
		return cafe_cafe_id;
	}

	public void setCafe_cafe_id(int cafe_cafe_id) {
		this.cafe_cafe_id = cafe_cafe_id;
	}

	public int getReview_review_id() {
		return review_review_id;
	}

	public void setReview_review_id(int review_review_id) {
		this.review_review_id = review_review_id;
	}
}
