package com.ubo.CafeWhereIGo.test.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller("testController")
public class TestControllerImpl {
	@RequestMapping(value= "/test/test.do" ,method={RequestMethod.POST,RequestMethod.GET})
	public ModelAndView search(HttpServletRequest request, HttpServletResponse response) throws Exception{
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		ModelAndView mav=new ModelAndView();
		String viewName = "/test/test";
		mav.setViewName(viewName);
		
		return mav;
	}
}
