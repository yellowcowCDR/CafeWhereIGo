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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.ubo.CafeWhereIGo.cart.cart.service.CartService;
import com.ubo.CafeWhereIGo.cart.goodsCart.vo.GoodsCartVO;
import com.ubo.CafeWhereIGo.cart.groupSeatCart.vo.GroupSeatCartVO;
import com.ubo.CafeWhereIGo.user.user.vo.UserVO;

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
			logger.debug("[@CartControllerImpl, addGoodsCart] is_Takeout id: "+goodsCart.getIs_takeout());
			
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
	public ResponseEntity getGoodsCart(GoodsCartVO goodsCart, HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	@Override
	@RequestMapping(value="/cart/modifyGoodsCart.do", method={RequestMethod.POST})
	public ResponseEntity modifyGoodsCart(@ModelAttribute GoodsCartVO goodsCart, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		logger.debug("[@CartControllerImpl, modifyGoodsCart] is_takeout: "+goodsCart.getIs_takeout());
		boolean is_takeout = Boolean.parseBoolean(request.getParameter("is_takeout"));
		logger.debug("[@CartControllerImpl, modifyGoodsCart] from request, is_takeout: "+is_takeout);
		logger.debug("[@CartControllerImpl, modifyGoodsCart] After VO Setting, is_takeout: "+goodsCart.getIs_takeout());
		goodsCart.setIs_Takeout(is_takeout);
		cartService.modifyGoodsCart(goodsCart);
		return ResponseEntity.noContent().build();
	}
	
	
	@Override
	@RequestMapping(value="/cart/deleteGoodsCart.do",method={RequestMethod.POST})
	public ResponseEntity deleteGoodsCart(@RequestParam("cart_id") int cart_id, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		
		cartService.deleteGoodsCart(cart_id);
		
		return ResponseEntity.noContent().build();
	}
	
	
	@Override
	@RequestMapping(value= "/cart/addGroupSeatCart.do" ,method={RequestMethod.POST})
	public ResponseEntity addGroupSeatCart(@ModelAttribute GroupSeatCartVO groupSeatCart, HttpServletRequest request, HttpServletResponse response) throws Exception{
		ResponseEntity resEntity = null;
//		String result = cartService.addCart();
		if(groupSeatCart!=null) {
		    logger.debug("[@CartControllerImpl, addGoodsCart] group seat id: "+groupSeatCart.getGroupSeat_id());
		    logger.debug("[@CartControllerImpl, addGoodsCart] cafe Id: "+groupSeatCart.getCafe_cafe_id());
		    String dateStr = request.getParameter("reservation_date");
		    LocalDate dateTemp = LocalDate.parse(dateStr);
			Date reservation_date = java.sql.Date.valueOf(dateTemp);
			groupSeatCart.setCart_date(reservation_date);
		    logger.debug("[@CartControllerImpl, addGoodsCart] reservation date: "+groupSeatCart.getReservation_date().toString());
		    logger.debug("[@CartControllerImpl, addGoodsCart] reservation start time: "+groupSeatCart.getStart_time());
		    logger.debug("[@CartControllerImpl, addGoodsCart] reservation end time: "+groupSeatCart.getEnd_time());
		    
		    HttpSession loginSession = request.getSession();
		    UserVO userInfo = (UserVO) loginSession.getAttribute("loginSession");
		    String user_id = userInfo.getUser_id();
		    
		    groupSeatCart.setUser_user_id(user_id);
		    groupSeatCart.setCart_state("complete");
		    
		    cartService.addGroupSeatCart(groupSeatCart);
		    
		}else {
		    logger.debug("[@CartControllerImpl, addGoodsCart] groupSeatsCart is null?: "+(groupSeatCart==null));
		}
		return ResponseEntity.noContent().build();
	}
	
	@Override
	public ResponseEntity getGroupSeatCart(GroupSeatCartVO groupSeatCart, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@RequestMapping(value="/cart/modifyGroupSeatCart.do", method={RequestMethod.POST})
	public ResponseEntity modifyGroupSeatCart(@ModelAttribute GroupSeatCartVO groupSeatCart, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		cartService.modifyGroupSeatCart(groupSeatCart);
		
		return ResponseEntity.noContent().build();
	}

	@Override
	@RequestMapping(value="/cart/deleteGroupSeatCart.do",method={RequestMethod.POST})
	public ResponseEntity deleteGroupSeatCart(int cart_id, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		cartService.deleteGroupSeatCart(cart_id);
		
		return ResponseEntity.noContent().build();
	}
	
}
