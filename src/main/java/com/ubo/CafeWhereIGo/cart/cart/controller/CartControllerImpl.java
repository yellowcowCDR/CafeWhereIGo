package com.ubo.CafeWhereIGo.cart.cart.controller;

import java.sql.Date;
import java.time.LocalDate;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.ubo.CafeWhereIGo.cart.cart.service.CartService;
import com.ubo.CafeWhereIGo.cart.goodsCart.vo.GoodsCartVO;
import com.ubo.CafeWhereIGo.cart.groupSeatCart.vo.GroupSeatCartVO;
import com.ubo.CafeWhereIGo.user.vo.UserVO;

@Controller("cartController")
public class CartControllerImpl implements CartController {
	Logger logger = LoggerFactory.getLogger(CartControllerImpl.class);
	
	@Autowired
	CartService cartService;
	
	@Override
	@RequestMapping(value= "/cart/cartform.do" ,method={RequestMethod.POST,RequestMethod.GET})
	public ModelAndView cartform(HttpServletRequest request, HttpServletResponse response) throws Exception{
		ModelAndView mav=new ModelAndView();
		String viewName = "/cart/cartform";
		mav.setViewName(viewName);
		
		return mav;
	}
	
	@Override
	@RequestMapping(value= "/cart/addGoodsCart.do" ,method={RequestMethod.POST})
	public ResponseEntity addGoodsCart(@ModelAttribute GoodsCartVO goodsCart,HttpServletRequest request, HttpServletResponse response) throws Exception{
		ResponseEntity resEntity = null;
//		String result = cartService.addCart();
		
		if(goodsCart!=null) {
			logger.debug("[@CartControllerImpl, addGoodsCart] goods id: "+goodsCart.getGoods_id());
			logger.debug("[@CartControllerImpl, addGoodsCart] cafe Id: "+goodsCart.getCafe_cafe_id());
			logger.debug("[@CartControllerImpl, addGoodsCart] quantity: "+goodsCart.getQuantity());
			logger.debug("[@CartControllerImpl, addGoodsCart] is_Takeout id: "+goodsCart.is_Takeout());
			
			HttpSession loginSession = request.getSession();
			UserVO userInfo = (UserVO) loginSession.getAttribute("loginSession");
			String user_id = userInfo.getUser_id();
			
			goodsCart.setUser_user_id(user_id);
			goodsCart.setCart_state("complete");
			
			cartService.addGoodsCart(goodsCart);
			
		}else {
			logger.debug("[@CartControllerImpl, addGoodsCart] goodsCart is null?: "+(goodsCart==null));
		}
		
		return ResponseEntity.noContent().build();
	}
	
	@Override
	@RequestMapping(value= "/cart/addGroupSeatCart.do" ,method={RequestMethod.POST})
	public ResponseEntity addGroupSeatCart(@ModelAttribute GroupSeatCartVO groupSeatsCart, HttpServletRequest request, HttpServletResponse response) throws Exception{
		ResponseEntity resEntity = null;
//		String result = cartService.addCart();
		if(groupSeatsCart!=null) {
		    logger.debug("[@CartControllerImpl, addGoodsCart] group seat id: "+groupSeatsCart.getGroupSeat_id());
		    logger.debug("[@CartControllerImpl, addGoodsCart] cafe Id: "+groupSeatsCart.getCafe_cafe_id());
		    String dateStr = request.getParameter("reservation_date");
		    LocalDate dateTemp = LocalDate.parse(dateStr);
			Date reservation_date = java.sql.Date.valueOf(dateTemp);
			groupSeatsCart.setCart_date(reservation_date);
		    logger.debug("[@CartControllerImpl, addGoodsCart] reservation date: "+groupSeatsCart.getReservation_date().toString());
		    logger.debug("[@CartControllerImpl, addGoodsCart] reservation start time: "+groupSeatsCart.getStart_time());
		    logger.debug("[@CartControllerImpl, addGoodsCart] reservation end time: "+groupSeatsCart.getEnd_time());
		    
		    HttpSession loginSession = request.getSession();
		    UserVO userInfo = (UserVO) loginSession.getAttribute("loginSession");
		    String user_id = userInfo.getUser_id();
		    
		    groupSeatsCart.setUser_user_id(user_id);
		    groupSeatsCart.setCart_state("complete");
		    
		    cartService.addGroupSeatCart(groupSeatsCart);
		    
		}else {
		    logger.debug("[@CartControllerImpl, addGoodsCart] groupSeatsCart is null?: "+(groupSeatsCart==null));
		}
		return ResponseEntity.noContent().build();
	}
}
