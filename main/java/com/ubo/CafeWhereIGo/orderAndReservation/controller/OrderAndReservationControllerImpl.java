package com.ubo.CafeWhereIGo.orderAndReservation.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller("orderAndReservationController")
public class OrderAndReservationControllerImpl {
	@RequestMapping(value= "/orderAndReservation/orderAndReservation.do" ,method={RequestMethod.POST,RequestMethod.GET})
	public ModelAndView orderAndReservation(HttpServletRequest request, HttpServletResponse response) throws Exception{
		ModelAndView mav=new ModelAndView();
		String viewName = "/orderAndReservation/orderAndReservation";
		mav.setViewName(viewName);
		
		return mav;
	}
}
