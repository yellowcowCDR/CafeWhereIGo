package com.ubo.CafeWhereIGo.siteManager.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.ubo.CafeWhereIGo.cafe.cafe.vo.CafeSearchParameterForManagementVO;
import com.ubo.CafeWhereIGo.user.user.vo.UserSearchParameterVO;

public interface SiteManagerController {

	ModelAndView userinfo(@ModelAttribute UserSearchParameterVO userSearchParameter, HttpServletRequest request, HttpServletResponse response) throws Exception;

	ModelAndView cafeManagerManagement(@ModelAttribute UserSearchParameterVO userSearchParameter, HttpServletRequest request, HttpServletResponse response) throws Exception;

	ModelAndView cafeManagement(@ModelAttribute CafeSearchParameterForManagementVO cafeSearchParameterForManagement, HttpServletRequest request, HttpServletResponse response) throws Exception;

//	ModelAndView addCafeForm(HttpServletRequest request, HttpServletResponse response) throws Exception;

	ResponseEntity<Map<String, String>> banUser(@RequestParam("user_id")String user_id, HttpServletRequest request, HttpServletResponse response) throws Exception;
	
	ResponseEntity<Map<String, String>> reRegisterUsers(@RequestParam("user_id")String user_id, HttpServletRequest request, HttpServletResponse response) throws Exception;
}