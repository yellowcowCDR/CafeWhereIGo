package com.ubo.CafeWhereIGo.cart.cart.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.servlet.ModelAndView;

import com.ubo.CafeWhereIGo.cart.goodsCart.vo.GoodsCartVO;
import com.ubo.CafeWhereIGo.cart.groupSeatCart.vo.GroupSeatCartVO;

public interface CartController {

	ModelAndView cartform(HttpServletRequest request, HttpServletResponse response) throws Exception;

	ResponseEntity addGoodsCart(@ModelAttribute GoodsCartVO goodsCart, HttpServletRequest request, HttpServletResponse response) throws Exception;

	ResponseEntity addGroupSeatCart(@ModelAttribute GroupSeatCartVO groupSeatsCart, HttpServletRequest request, HttpServletResponse response) throws Exception;

}