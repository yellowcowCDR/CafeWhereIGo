package com.ubo.CafeWhereIGo.article.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import com.ubo.CafeWhereIGo.article.vo.SearchConditionVO;

public interface ArticleController {

	ModelAndView addArticleForm(HttpServletRequest request, HttpServletResponse response) throws Exception;

	ModelAndView modifyArticleForm(int article_id, HttpServletRequest request, HttpServletResponse response)
			throws Exception;

	ModelAndView addArticle(MultipartHttpServletRequest multipartRequest, HttpServletResponse response)
			throws Exception;

	ModelAndView deleteArticle(int article_id, HttpServletRequest request, HttpServletResponse response)
			throws Exception;

	ModelAndView search(SearchConditionVO condition, HttpServletRequest request, HttpServletResponse response)
			throws Exception;

	ModelAndView detail(int article_id, HttpServletRequest request, HttpServletResponse response) throws Exception;

	ModelAndView modifyArticle(@RequestParam Map<String, String> paramMap, MultipartHttpServletRequest multipartRequest, HttpServletResponse response)
			throws Exception;

}