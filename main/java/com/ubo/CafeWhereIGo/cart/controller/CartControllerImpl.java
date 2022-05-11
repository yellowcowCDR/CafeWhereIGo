package com.ubo.CafeWhereIGo.cart.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller("cartController")
public class CartControllerImpl {
	@RequestMapping(value= "/cart/cart.do" ,method={RequestMethod.POST,RequestMethod.GET})
	public ModelAndView cart(HttpServletRequest request, HttpServletResponse response) throws Exception{
		ModelAndView mav=new ModelAndView();
		String viewName = "/cart/cart";
		mav.setViewName(viewName);
		
		return mav;
	}
}
