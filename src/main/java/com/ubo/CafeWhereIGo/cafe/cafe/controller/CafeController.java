package com.ubo.CafeWhereIGo.cafe.cafe.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.MultipartRequest;
import org.springframework.web.servlet.ModelAndView;

import com.ubo.CafeWhereIGo.cafe.cafe.vo.CafeSearchParameterVO;
import com.ubo.CafeWhereIGo.likedcafe.vo.LikedCafeVO;

public interface CafeController {

	ModelAndView search(@ModelAttribute CafeSearchParameterVO cafeSearchParameter, HttpServletRequest request, HttpServletResponse response) throws Exception;

	ModelAndView detail(@RequestParam("cafe_id") int cafe_id, HttpServletRequest request, HttpServletResponse response) throws Exception;

	ModelAndView addCafe(MultipartHttpServletRequest multipartRequest, HttpServletResponse response) throws Exception;

	ModelAndView modifyCafe(MultipartHttpServletRequest request, HttpServletResponse response) throws Exception;

	ResponseEntity<Map<String, Object>> shutdownCafe(@RequestParam("cafe_id") int cafe_id, HttpServletRequest request, HttpServletResponse response) throws Exception;

	ResponseEntity<Map<String, Object>> undoShutdownCafe(@RequestParam("cafe_id") int cafe_id, HttpServletRequest request, HttpServletResponse response) throws Exception;
	
	ResponseEntity<Map<String, Object>> shutdownMultipleCafe(@RequestParam("cafeIdList") String cafeIdList, HttpServletRequest request, HttpServletResponse response) throws Exception;
	
	ResponseEntity<Map<String, Object>> undoShutdownMultipleCafe(@RequestParam("cafeIdList") String cafeIdList, HttpServletRequest request, HttpServletResponse response) throws Exception;
	
	ResponseEntity addReview(MultipartHttpServletRequest request, HttpServletResponse response) throws Exception;

	ResponseEntity modifyReview(MultipartHttpServletRequest request, HttpServletResponse response) throws Exception;

	ResponseEntity deleteReview(@RequestParam("review_id") int review_id, HttpServletRequest request, HttpServletResponse response) throws Exception;

	ModelAndView showReview(MultipartHttpServletRequest request, HttpServletResponse response) throws Exception;

	ResponseEntity likeCafe(LikedCafeVO likedCafe, HttpServletRequest request, HttpServletResponse response)
			throws Exception;

}