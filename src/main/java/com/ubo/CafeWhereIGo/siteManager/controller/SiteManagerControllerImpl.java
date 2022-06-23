package com.ubo.CafeWhereIGo.siteManager.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.ubo.CafeWhereIGo.cafe.cafe.service.CafeService;
import com.ubo.CafeWhereIGo.cafe.cafe.vo.CafeSearchParameterForManagementVO;
import com.ubo.CafeWhereIGo.user.user.service.UserService;
import com.ubo.CafeWhereIGo.user.user.vo.UserSearchParameterVO;

@Controller("siteManagerController")
public class SiteManagerControllerImpl implements SiteManagerController {
	Logger logger = LoggerFactory.getLogger(SiteManagerControllerImpl.class);
	
	@Autowired
	UserService userService;
	
	@Autowired
	CafeService cafeService;
	
	@Override
	@RequestMapping(value= "/siteManager/userManagement.do" ,method={RequestMethod.POST,RequestMethod.GET})
	public ModelAndView userinfo(@ModelAttribute UserSearchParameterVO userSearchParameter, HttpServletRequest request, HttpServletResponse response) throws Exception{
		List<Map> userList = userService.getUserList(userSearchParameter);
		
		logger.debug("[@SiteManagerControllerImpl, userinfo] searchCondition: " + userSearchParameter.getSearchCondition());
		logger.debug("[@SiteManagerControllerImpl, userinfo] searchWords: " + userSearchParameter.getSearchWords());
		logger.debug("[@SiteManagerControllerImpl, userinfo] searchWords from request: " + request.getParameter("searchWords"));
		
		ModelAndView mav=new ModelAndView();
		String viewName = "/siteManager/userManagement";
		mav.setViewName(viewName);
		mav.addObject("userList", userList);
		mav.addObject("userSearchParameter",userSearchParameter);
		return mav;
	}
	
	@Override
	@RequestMapping(value= "/siteManager/cafeManagerManagement.do" ,method={RequestMethod.POST,RequestMethod.GET})
	public ModelAndView cafeManagerManagement(@ModelAttribute UserSearchParameterVO userSearchParameter, HttpServletRequest request, HttpServletResponse response) throws Exception{
		List<Map> cafeManagerList = userService.getCafeManagerList(userSearchParameter);
		
		ModelAndView mav=new ModelAndView();
		String viewName = "/siteManager/cafeManagerManagement";
		mav.setViewName(viewName);
		mav.addObject("cafeManagerList", cafeManagerList);
		mav.addObject("userSearchParameter",userSearchParameter);
		return mav;
	}
	
	@Override
	@RequestMapping(value= "/siteManager/cafeManagement.do" ,method={RequestMethod.POST,RequestMethod.GET})
	public ModelAndView cafeManagement(@ModelAttribute CafeSearchParameterForManagementVO cafeSearchParameterForManagement, HttpServletRequest request, HttpServletResponse response) throws Exception{
		List<Map> cafeList = cafeService.getCafeListForManagement(cafeSearchParameterForManagement);
		
		ModelAndView mav=new ModelAndView();
		String viewName = "/siteManager/cafeManagement";
		mav.setViewName(viewName);
		mav.addObject("cafeList", cafeList);
		return mav;
	}
	
//	@Override
//	@RequestMapping(value= "/siteManager/mainPageManagement.do" ,method={RequestMethod.POST,RequestMethod.GET})
//	public ModelAndView addCafeForm(HttpServletRequest request, HttpServletResponse response) throws Exception{
//		ModelAndView mav=new ModelAndView();
//		String viewName = "/siteManager/mainPageManagement";
//		mav.setViewName(viewName);
//		
//		return mav;
//	}
	
	@Override
	@RequestMapping(value= "/siteManager/banUser.do" ,method={RequestMethod.POST,RequestMethod.GET})
	public ResponseEntity<Map<String, String>> banUser(@RequestParam("user_id") String user_id, HttpServletRequest request, HttpServletResponse response) throws Exception{
		userService.banUser(user_id);
		
		String join_state = userService.getJoinState(user_id);
		
		logger.debug("[@SiteManagerController, banUser] join_state: "+join_state);
		
		Map<String, String> result = new HashMap<String, String>();
		
		result.put("join_state", join_state);
		
		return ResponseEntity.ok().body(result);
		
	}
	
	@Override
	@RequestMapping(value= "/siteManager/reRegisterUsers.do" ,method={RequestMethod.POST,RequestMethod.GET})
	public ResponseEntity<Map<String, String>> reRegisterUsers(@RequestParam("user_id") String user_id, HttpServletRequest request, HttpServletResponse response) throws Exception{
		userService.reRegisterUser(user_id);
		
		String join_state = userService.getJoinState(user_id);
		
		
		Map<String, String> result = new HashMap<String, String>();
		
		result.put("join_state", join_state);
		
		return ResponseEntity.ok().body(result);
	}
	
}
