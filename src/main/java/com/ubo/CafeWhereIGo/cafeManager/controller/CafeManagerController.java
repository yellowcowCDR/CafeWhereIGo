package com.ubo.CafeWhereIGo.cafeManager.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.ubo.CafeWhereIGo.cafe.cafe.service.CafeService;
import com.ubo.CafeWhereIGo.cafe.cafe.vo.CafeSearchParameterVO;
import com.ubo.CafeWhereIGo.cafe.cafe.vo.CafeSearchResultVO;
import com.ubo.CafeWhereIGo.cafe.cafe.vo.CafeVO;
import com.ubo.CafeWhereIGo.cafe.cafePhoto.service.CafePhotoService;
import com.ubo.CafeWhereIGo.cafe.cafePhoto.vo.CafePhotoVO;
import com.ubo.CafeWhereIGo.cafe.facilityInfo.vo.FacilityInfoVO;
import com.ubo.CafeWhereIGo.cafe.goods.service.GoodsService;
import com.ubo.CafeWhereIGo.cafe.goods.vo.GoodsVO;
import com.ubo.CafeWhereIGo.cafe.goodsphoto.vo.GoodsPhotoVO;
import com.ubo.CafeWhereIGo.cafe.groupseat.service.GroupSeatService;
import com.ubo.CafeWhereIGo.cafe.groupseat.vo.GroupSeatVO;
import com.ubo.CafeWhereIGo.cafe.groupseatphoto.vo.GroupSeatPhotoVO;
import com.ubo.CafeWhereIGo.cafe.parkinglot.vo.ParkingLotVO;
import com.ubo.CafeWhereIGo.cafe.review.service.CafeReviewService;
import com.ubo.CafeWhereIGo.cafeHomeArticle.vo.CafeHomeArticleVO;
import com.ubo.CafeWhereIGo.orderAndReservation.service.OrderAndReservationService;
import com.ubo.CafeWhereIGo.user.user.vo.UserVO;

@Controller("cafeManagerController")
public class CafeManagerController {
	@Autowired
	CafeService cafeService;
	
	@Autowired
	GoodsService goodsService;
	
	@Autowired
	GroupSeatService groupSeatService;
	
	@Autowired
	CafePhotoService cafePhotoService;
	
	@Autowired
	CafeReviewService cafeReviewService;
	
	@Autowired
	OrderAndReservationService orderAndReservationService;
	
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
		
		HttpSession loginSession = request.getSession();
		UserVO userInfo = (UserVO)loginSession.getAttribute("loginSession");
		
		if(userInfo != null) {
			String user_id = userInfo.getUser_id();
			CafeSearchParameterVO cafeSearchParameter = new CafeSearchParameterVO();
			cafeSearchParameter.setUser_user_id(user_id);
			List<CafeSearchResultVO> cafeSearchResultList = cafeService.getCafeList(cafeSearchParameter);
			mav.addObject("cafeSearchResultList", cafeSearchResultList);
		}
		
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
	public ModelAndView modifyCafeForm(@RequestParam("cafe_id") int cafe_id, HttpServletRequest request, HttpServletResponse response) throws Exception{
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		ModelAndView mav=new ModelAndView();
		CafeVO cafe = cafeService.getCafeDetail(cafe_id);
		CafePhotoVO cafoMainPhoto = cafePhotoService.getCafeMainPhoto(cafe_id);
		Map<String, Object> themeScoreMap = cafeService.getThemeScoreAverage(cafe_id);
		CafeHomeArticleVO homeArticle = cafeService.selectHomeArticle(cafe_id);
		String[] homeArticleLines =homeArticle.getArticle_content().split("\r\n");
		List<GoodsVO> goodsList = goodsService.getGoods(cafe_id);
		List<GroupSeatVO> groupSeatList = groupSeatService.getGroupSeatList(cafe_id);
		List<Map<String,Object>> reviewMapList=  cafeReviewService.getCafeReviewList(cafe_id);
		List<Map<String,Object>> cafePhotoMapList = cafePhotoService.getAllPhoto(cafe_id);
		List<ParkingLotVO> parkingLotList = cafeService.selectParkingLot(cafe_id);
		FacilityInfoVO facilityInfo = cafeService.getFacilityInfo(cafe_id);
		
		//goods
		List<Map> goodsMapList = new ArrayList<Map>();
		for(int i=0; i<goodsList.size();i++) {
			Map<String, Object> goodsMap=new HashMap<String, Object>();
			
			GoodsVO goods = goodsList.get(i);
			int goods_id = goods.getGoods_id();
			GoodsPhotoVO goodsPhoto = goodsService.getGoodsPhoto(goods_id);
			goodsMap.put("goods", goods);
			goodsMap.put("goodsPhoto",goodsPhoto);
			
			goodsMapList.add(goodsMap);
		}
		
		//group seat
		List<Map> groupSeatMapList = new ArrayList<Map>();
		for(int i=0; i<groupSeatList.size();i++) {
			Map<String, Object> groupSeatMap=new HashMap<String, Object>();
			
			GroupSeatVO groupSeat = groupSeatList.get(i);
			int groupseat_id = groupSeat.getGroupseat_id();
			GroupSeatPhotoVO groupSeatPhoto = groupSeatService.getGroupSeatPhoto(groupseat_id);
			groupSeatMap.put("groupSeat", groupSeat);
			groupSeatMap.put("groupSeatPhoto",groupSeatPhoto);
			
			groupSeatMapList.add(groupSeatMap);
		}
		
		
		HttpSession loginSession = request.getSession();
		UserVO userInfo =(UserVO) loginSession.getAttribute("loginSession");
		
		mav.addObject("cafeInfo", cafe);
		mav.addObject("cafoMainPhoto", cafoMainPhoto);
		mav.addObject("user_name", userInfo.getUser_name());
		
		mav.addObject("cafeHomeArticle", homeArticle);
		mav.addObject("goodsMapList", goodsMapList);
		mav.addObject("groupSeatMapList", groupSeatMapList);
		
		mav.addObject("cafePhotoMapList",cafePhotoMapList);
		mav.addObject("parkingLotList",parkingLotList);
		mav.addObject("facilityInfo",facilityInfo);
		
		String viewName = "/cafeManager/modifyCafeForm";
		mav.setViewName(viewName);
		
		return mav;
	}
	
}
