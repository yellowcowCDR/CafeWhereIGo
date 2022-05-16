package com.ubo.CafeWhereIGo.siteManager.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller("siteManagerController")
public class SiteManagerController {
	@RequestMapping(value= "/siteManager/userManagement.do" ,method={RequestMethod.POST,RequestMethod.GET})
	public ModelAndView userinfo(HttpServletRequest request, HttpServletResponse response) throws Exception{
		ModelAndView mav=new ModelAndView();
		String viewName = "/siteManager/userManagement";
		mav.setViewName(viewName);
		
		return mav;
	}
	
	@RequestMapping(value= "/siteManager/cafeManagerManagement.do" ,method={RequestMethod.POST,RequestMethod.GET})
	public ModelAndView cafeManagerManagement(HttpServletRequest request, HttpServletResponse response) throws Exception{
		ModelAndView mav=new ModelAndView();
		String viewName = "/siteManager/cafeManagerManagement";
		mav.setViewName(viewName);
		
		return mav;
	}
	
	@RequestMapping(value= "/siteManager/cafeManagement.do" ,method={RequestMethod.POST,RequestMethod.GET})
	public ModelAndView cafeManagement(HttpServletRequest request, HttpServletResponse response) throws Exception{
		ModelAndView mav=new ModelAndView();
		String viewName = "/siteManager/cafeManagement";
		mav.setViewName(viewName);
		
		return mav;
	}
	
	@RequestMapping(value= "/siteManager/mainPageManagement.do" ,method={RequestMethod.POST,RequestMethod.GET})
	public ModelAndView addCafeForm(HttpServletRequest request, HttpServletResponse response) throws Exception{
		ModelAndView mav=new ModelAndView();
		String viewName = "/siteManager/mainPageManagement";
		mav.setViewName(viewName);
		
		return mav;
	}
}
