package com.ubo.CafeWhereIGo.cafe.cafe.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.MultipartRequest;
import org.springframework.web.servlet.ModelAndView;

import com.ubo.CafeWhereIGo.likedcafe.vo.LikedCafeVO;

public interface CafeController {

	ModelAndView search(HttpServletRequest request, HttpServletResponse response) throws Exception;

	ModelAndView detail(@RequestParam("cafe_id") int cafe_id, HttpServletRequest request, HttpServletResponse response) throws Exception;

	ModelAndView addCafe(MultipartHttpServletRequest multipartRequest, HttpServletResponse response) throws Exception;

	ModelAndView modifyCafe(MultipartRequest request, HttpServletResponse response) throws Exception;

	ModelAndView shutdownCafe(HttpServletRequest request, HttpServletResponse response) throws Exception;

	ModelAndView addReview(MultipartRequest request, HttpServletResponse response) throws Exception;

	ModelAndView modifyReview(MultipartRequest request, HttpServletResponse response) throws Exception;

	ModelAndView deleteReview(MultipartRequest request, HttpServletResponse response) throws Exception;

	ModelAndView showReview(MultipartRequest request, HttpServletResponse response) throws Exception;

	ResponseEntity likeCafe(LikedCafeVO likedCafe, HttpServletRequest request, HttpServletResponse response)
			throws Exception;

}