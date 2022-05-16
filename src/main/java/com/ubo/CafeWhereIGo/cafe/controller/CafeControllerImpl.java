package com.ubo.CafeWhereIGo.cafe.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller("cafeController")
public class CafeControllerImpl {
	@RequestMapping(value= "/cafe/search.do" ,method={RequestMethod.POST,RequestMethod.GET})
	public ModelAndView search(HttpServletRequest request, HttpServletResponse response) throws Exception{
		ModelAndView mav=new ModelAndView();
		String viewName = "/cafe/search";
		mav.setViewName(viewName);
		
		return mav;
	}
	
	@RequestMapping(value="/cafe/cafe_detail.do" ,method={RequestMethod.POST,RequestMethod.GET})
	public ModelAndView detail(HttpServletRequest request, HttpServletResponse response) throws Exception{
		ModelAndView mav=new ModelAndView();
		String viewName = "/cafe/cafe_detail";
		mav.setViewName(viewName);
		
		return mav;
	}
	
	
}
