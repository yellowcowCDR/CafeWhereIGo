package com.ubo.CafeWhereIGo.user.user.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

public interface UserController {

	ModelAndView loginform(HttpServletRequest request, HttpServletResponse response) throws Exception;
	public ModelAndView login(HttpServletRequest request, HttpServletResponse response) throws Exception;
//	ModelAndView login(String user_id, String user_pw, HttpServletRequest request, HttpServletResponse response)
//			throws Exception;
	public ModelAndView logout(HttpServletRequest request, HttpServletResponse response) throws Exception;
	public ModelAndView registerform(HttpServletRequest request, HttpServletResponse response) throws Exception;
	public ResponseEntity overlapped(@RequestParam("user_id") String id,HttpServletRequest request, HttpServletResponse response) throws Exception;
	public ModelAndView registerUser(MultipartHttpServletRequest multipartRequest, HttpServletResponse response) throws Exception;
	public void download(@RequestParam("article_id") String article_id, HttpServletResponse response) throws Exception;
	ModelAndView modifyUser(MultipartHttpServletRequest multipartRequest, HttpServletResponse response)
			throws Exception;
}