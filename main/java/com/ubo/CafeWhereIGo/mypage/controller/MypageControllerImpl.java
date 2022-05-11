package com.ubo.CafeWhereIGo.mypage.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller("mypageController")
public class MypageControllerImpl {
	@RequestMapping(value= "/mypage/userinfo.do" ,method={RequestMethod.POST,RequestMethod.GET})
	public ModelAndView loginform(HttpServletRequest request, HttpServletResponse response) throws Exception{
		ModelAndView mav=new ModelAndView();
		String viewName = "/mypage/userinfo";
		mav.setViewName(viewName);
		
		return mav;
	}
	@RequestMapping(value= "/mypage/wishlist.do" ,method={RequestMethod.POST,RequestMethod.GET})
	public ModelAndView wishlist(HttpServletRequest request, HttpServletResponse response) throws Exception{
		ModelAndView mav=new ModelAndView();
		String viewName = "/mypage/wishlist";
		mav.setViewName(viewName);
		
		return mav;
	}
	@RequestMapping(value= "/mypage/orderReservationList.do" ,method={RequestMethod.POST,RequestMethod.GET})
	public ModelAndView orderlist(HttpServletRequest request, HttpServletResponse response) throws Exception{
		ModelAndView mav=new ModelAndView();
		String viewName = "/mypage/orderReservationList";
		mav.setViewName(viewName);
		
		return mav;
	}
	@RequestMapping(value= "/mypage/cartList.do" ,method={RequestMethod.POST,RequestMethod.GET})
	public ModelAndView reservationlist(HttpServletRequest request, HttpServletResponse response) throws Exception{
		ModelAndView mav=new ModelAndView();
		String viewName = "/mypage/cartList";
		mav.setViewName(viewName);
		
		return mav;
	}
}
