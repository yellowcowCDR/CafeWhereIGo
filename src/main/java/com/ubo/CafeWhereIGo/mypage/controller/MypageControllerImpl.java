package com.ubo.CafeWhereIGo.mypage.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.ubo.CafeWhereIGo.cart.cart.service.CartService;
import com.ubo.CafeWhereIGo.cart.goodsCart.vo.GoodsCartSearchResultVO;
import com.ubo.CafeWhereIGo.cart.groupSeatCart.vo.GroupSeatCartSearchResultVO;
import com.ubo.CafeWhereIGo.user.vo.UserVO;

@Controller("mypageController")
public class MypageControllerImpl {
	@Autowired
	CartService cartService;
	
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
		HttpSession loginSession = request.getSession();
		UserVO userInfo = (UserVO)loginSession.getAttribute("loginSession");
		String user_id = userInfo.getUser_id();
		
		List<GoodsCartSearchResultVO> goodsCartList = cartService.getGoodsCartListbyUserId(user_id);
		
		List<GroupSeatCartSearchResultVO> groupSeatCartList = cartService.getGroupSeatCartListbyUserId(user_id);
		
		ModelAndView mav=new ModelAndView();
		String viewName = "/mypage/cartList";
		mav.setViewName(viewName);
		mav.addObject("goodsCartList",goodsCartList);
		mav.addObject("groupSeatCartList",groupSeatCartList);
		return mav;
	}
}
