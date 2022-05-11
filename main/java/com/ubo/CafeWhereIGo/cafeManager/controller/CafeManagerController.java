package com.ubo.CafeWhereIGo.cafeManager.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller("cafeManagerController")
public class CafeManagerController {
	@RequestMapping(value= "/cafeManager/userinfo.do" ,method={RequestMethod.POST,RequestMethod.GET})
	public ModelAndView userinfo(HttpServletRequest request, HttpServletResponse response) throws Exception{
		ModelAndView mav=new ModelAndView();
		String viewName = "/cafeManager/userinfo";
		mav.setViewName(viewName);
		
		return mav;
	}
	@RequestMapping(value= "/cafeManager/cafeManagement.do" ,method={RequestMethod.POST,RequestMethod.GET})
	public ModelAndView cafeManagement(HttpServletRequest request, HttpServletResponse response) throws Exception{
		ModelAndView mav=new ModelAndView();
		String viewName = "/cafeManager/cafeManagement";
		mav.setViewName(viewName);
		
		return mav;
	}
	@RequestMapping(value= "/cafeManager/orderReservationList.do" ,method={RequestMethod.POST,RequestMethod.GET})
	public ModelAndView orderAndReservation(HttpServletRequest request, HttpServletResponse response) throws Exception{
		ModelAndView mav=new ModelAndView();
		String viewName = "/cafeManager/orderReservationList";
		mav.setViewName(viewName);
		
		return mav;
	}
	@RequestMapping(value= "/cafeManager/addCafeForm.do" ,method={RequestMethod.POST,RequestMethod.GET})
	public ModelAndView addCafeForm(HttpServletRequest request, HttpServletResponse response) throws Exception{
		ModelAndView mav=new ModelAndView();
		String viewName = "/cafeManager/addCafeForm";
		mav.setViewName(viewName);
		
		return mav;
	}
	@RequestMapping(value= "/cafeManager/modifyCafeForm.do" ,method={RequestMethod.POST,RequestMethod.GET})
	public ModelAndView modifyCafeForm(HttpServletRequest request, HttpServletResponse response) throws Exception{
		ModelAndView mav=new ModelAndView();
		String viewName = "/cafeManager/modifyCafeForm";
		mav.setViewName(viewName);
		
		return mav;
	}
}
