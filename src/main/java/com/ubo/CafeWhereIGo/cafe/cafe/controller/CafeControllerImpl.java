package com.ubo.CafeWhereIGo.cafe.cafe.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ResourceLoader;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;
import com.ubo.CafeWhereIGo.cafe.cafe.service.CafeService;
import com.ubo.CafeWhereIGo.cafe.cafe.vo.CafeSearchParameterVO;
import com.ubo.CafeWhereIGo.cafe.cafe.vo.CafeSearchResultVO;
import com.ubo.CafeWhereIGo.cafe.cafe.vo.CafeVO;
import com.ubo.CafeWhereIGo.cafe.cafePhoto.service.CafePhotoService;
import com.ubo.CafeWhereIGo.cafe.cafePhoto.vo.CafePhotoVO;
import com.ubo.CafeWhereIGo.cafe.facilityInfo.vo.FacilityInfoVO;
import com.ubo.CafeWhereIGo.cafe.goods.service.GoodsService;
import com.ubo.CafeWhereIGo.cafe.goods.vo.GoodsVO;
import com.ubo.CafeWhereIGo.cafe.goodsphoto.vo.GoodsPhotoInfoVO;
import com.ubo.CafeWhereIGo.cafe.goodsphoto.vo.GoodsPhotoVO;
import com.ubo.CafeWhereIGo.cafe.groupseat.service.GroupSeatService;
import com.ubo.CafeWhereIGo.cafe.groupseat.vo.GroupSeatVO;
import com.ubo.CafeWhereIGo.cafe.groupseatphoto.vo.GroupSeatPhotoInfoVO;
import com.ubo.CafeWhereIGo.cafe.groupseatphoto.vo.GroupSeatPhotoVO;
import com.ubo.CafeWhereIGo.cafe.parkinglot.vo.ParkingLotVO;
import com.ubo.CafeWhereIGo.cafe.review.service.CafeReviewService;
import com.ubo.CafeWhereIGo.cafe.review.vo.CafeReviewVO;
import com.ubo.CafeWhereIGo.cafe.reviewPhoto.vo.CafeReviewPhotoVO;
import com.ubo.CafeWhereIGo.cafe.themescore.vo.ThemeScoreVO;
import com.ubo.CafeWhereIGo.cafeHomeArticle.vo.CafeHomeArticleVO;
import com.ubo.CafeWhereIGo.likedcafe.vo.LikedCafeVO;
import com.ubo.CafeWhereIGo.orderAndReservation.service.OrderAndReservationService;
import com.ubo.CafeWhereIGo.user.user.vo.UserVO;

@Controller("cafeController")
public class CafeControllerImpl implements CafeController {
	protected static String CURR_IMAGE_REPO_PATH = "/Users/choedaelyeon/server_data/cafe/file_repo/photo/cafe/";
	Logger logger = LoggerFactory.getLogger(CafeControllerImpl.class);
	
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
	private OrderAndReservationService orderAndReservationService;
	
	@Autowired
	ResourceLoader resourceLoader;
	
	@Override
	@RequestMapping(value= "/cafe/search.do" ,method={RequestMethod.POST,RequestMethod.GET})
	public ModelAndView search(@ModelAttribute CafeSearchParameterVO cafeSearchParameter, HttpServletRequest request, HttpServletResponse response) throws Exception{
		cafeSearchParameter.setBusiness_state("open");
		List<CafeSearchResultVO> cafeSearchResultList = cafeService.getCafeList(cafeSearchParameter);
		
		logger.debug("[@CafeControllerImpl, search] region1: " + request.getParameter("cafe_location1"));
		logger.debug("[@CafeControllerImpl, search] region2: " + request.getParameter("cafe_location2"));
		logger.debug("[@CafeControllerImpl, search] region3: " + request.getParameter("cafe_location3"));
		logger.debug("[@CafeControllerImpl, search] region3: " + request.getParameter("cafe_location4"));
		
		logger.debug("[@CafeControllerImpl, search] searchKeword: " + request.getParameter("searchKeyword"));
		
		ModelAndView mav=new ModelAndView();
		String viewName = "/cafe/search";
		mav.setViewName(viewName);
		mav.addObject("cafeList",cafeSearchResultList);
		mav.addObject("cafeSearchParameter",cafeSearchParameter);
		return mav;
	}
	
	@Override
	@RequestMapping(value="/cafe/cafe_detail.do" ,method={RequestMethod.POST,RequestMethod.GET})
	public ModelAndView detail(@RequestParam("cafe_id") int cafe_id, HttpServletRequest request, HttpServletResponse response) throws Exception{
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		ModelAndView mav=new ModelAndView();
		CafeVO cafe = cafeService.getCafeDetail(cafe_id);
		Map<String, Object> themeScoreMap = cafeService.getThemeScoreAverage(cafe_id);
		CafeHomeArticleVO homeArticle = cafeService.selectHomeArticle(cafe_id);
		String[] homeArticleLines =homeArticle.getArticle_content().split("\r\n");
		List<GoodsVO> goodsList = goodsService.getGoods(cafe_id);
		List<GroupSeatVO> groupSeatList = groupSeatService.getGroupSeatList(cafe_id);
		List<Map<String,Object>> reviewMapList=  cafeReviewService.getCafeReviewList(cafe_id);
		List<Map<String,Object>> cafePhotoMapList = cafePhotoService.getAllPhoto(cafe_id);
		List<ParkingLotVO> parkingLotList = cafeService.selectParkingLot(cafe_id);
		FacilityInfoVO facilityInfo = cafeService.getFacilityInfo(cafe_id);
		HttpSession loginSession = request.getSession();
		UserVO userInfo =(UserVO) loginSession.getAttribute("loginSession");
		if(userInfo!=null) {
			// get Like Cafe Info
			String user_id = userInfo.getUser_id();
			boolean isLikeCafe = cafeService.isLikeCafe(user_id, cafe_id);
			mav.addObject("isLikeCafe", isLikeCafe);
			
			List<Map> orderHistoryMapList=orderAndReservationService.getOrderAndReservationForCafeDetail(user_id, cafe_id);
			mav.addObject("orderHistoryMapList", orderHistoryMapList);
		}
		
		String viewName = "/cafe/cafe_detail";
		mav.setViewName(viewName);
		mav.addObject("cafeInfo", cafe);
		mav.addObject("themeScoreMap", themeScoreMap);
		mav.addObject("cafeHomeArticle", homeArticleLines);
		mav.addObject("goodsList", goodsList);
		mav.addObject("groupSeatList", groupSeatList);
		mav.addObject("reviewMapList", reviewMapList);
		mav.addObject("cafePhotoMapList",cafePhotoMapList);
		mav.addObject("parkingLotList",parkingLotList);
		mav.addObject("facilityInfo",facilityInfo);
		return mav;
	}

	@Override
	@RequestMapping(value="/cafe/addCafe.do" ,method={RequestMethod.POST,RequestMethod.GET})
	public ModelAndView addCafe(MultipartHttpServletRequest multipartRequest, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		multipartRequest.setCharacterEncoding("utf-8");
		
		int goodsSize=0;
		int groupSeatSize=0;
		int photoSize=0;
		int parkingLotSize=0;
		
		HttpSession session =multipartRequest.getSession();
		UserVO userInfo = (UserVO) session.getAttribute("loginSession");
		
		CafeVO cafeInfo = new CafeVO();
		FacilityInfoVO facilityInfo = new FacilityInfoVO();
		
		CafeHomeArticleVO homeArticle = new CafeHomeArticleVO();
		
		Enumeration enu= multipartRequest.getParameterNames();
		
		while(enu.hasMoreElements()){
			String name = (String)enu.nextElement();
			String value=multipartRequest.getParameter(name);
			logger.debug("@[CafeController, addCafe] parameter name: " + name);
			logger.debug("@[CafeController, addCafe] parameter value: " + value);
			if(name.equals("cafe_name")) {
				cafeInfo.setCafe_name(value);
			}else if(name.equals("cafe_location2")) {
				cafeInfo.setCafe_location2(value);
			}else if(name.equals("phonenum1")) {
				cafeInfo.setPhonenum1(value);
			}else if(name.equals("phonenum2")) {
				cafeInfo.setPhonenum2(value);
			}else if(name.equals("phonenum3")) {
				cafeInfo.setPhonenum3(value);
			}else if(name.equals("parking_lot")) {
				if(value.equals("on")) {
					facilityInfo.setParking_lot(true);
				}else {
					facilityInfo.setParking_lot(false);
				}
			}else if(name.equals("wifi")) {
				if(value.equals("on")) {
					facilityInfo.setWifi(true);
				}else {
					facilityInfo.setWifi(false);
				}
			}else if(name.equals("power_plug")) {
				if(value.equals("on")) {
					facilityInfo.setPower_plug(true);
				}else {
					facilityInfo.setPower_plug(false);
				}
			}else if(name.equals("numberOfSeat")){
				int numberOfSeat = Integer.parseInt(value);
				cafeInfo.setNumber_of_seat(numberOfSeat);
			}else if(name.equals("homeArticle_content")) {
				if(value!=null && !value.equals("")) {
					homeArticle.setUser_user_id(userInfo.getUser_id());
					homeArticle.setArticle_content(value);
				}
			}else if(name.equals("goodsSize")) {
				goodsSize = Integer.parseInt(value);
			}else if(name.equals("groupSeatSize")) {
				groupSeatSize = Integer.parseInt(value);
			}else if(name.equals("photoSize")) {
				photoSize = Integer.parseInt(value);
			}else if(name.equals("parkingLotSize")) {
				parkingLotSize = Integer.parseInt(value);
			}
		}
		
		// CafeManager Info Init
		cafeInfo.setUser_user_id(userInfo.getUser_id());
		
		//Cafe Status Init
		cafeInfo.setBusiness_state("open");
		
		//Cafe Address1 Init
		String cafe_location1="";
		for(int i=0; i<4; i++) {			
			String addrValue= multipartRequest.getParameter("cafe_region"+i);
			if(addrValue!=null && addrValue!=""){
				if(i<3) {
					cafe_location1 += addrValue + " ";
				}else {
					cafe_location1 += addrValue;
				}
				
			}
		}
		cafeInfo.setCafe_location1(cafe_location1);
		
		//Business Time Init
		String opentime="";
		String closetime="";
		for(int i=1; i<4; i++) {
			String opentimeVal = multipartRequest.getParameter("openTime"+i);
			String closetimeVal = multipartRequest.getParameter("closeTime"+i);
			if(i==1) {
				opentime += opentimeVal +":";
				closetime += closetimeVal + ":";
			}else if(i==2) {
				if(opentimeVal.length()==1) {
					opentime += "0"+opentimeVal + " ";
				}else {
					opentime += opentimeVal +" ";
				}
				if(closetimeVal.length()==1) {
					closetime += "0"+closetimeVal + " ";
				}else {
					closetime += closetimeVal + " ";
				}
			}else {
				opentime += opentimeVal;
				closetime += closetimeVal;
			}
		}
		cafeInfo.setOpen_time(opentime);
		cafeInfo.setClose_time(closetime);
		int cafe_id=cafeService.addCafe(cafeInfo);
		
		
		//Cafe Main Photo Upload
		cafeMainPhotoUpload(multipartRequest,cafe_id);
		
		//Facility Info Init
		facilityInfo.setCafe_cafe_id(cafe_id);
		cafeService.registerFacilityInfo(facilityInfo);
		
		//HomeArticle Init
		String homeArticleContent = homeArticle.getArticle_content();
		if(homeArticleContent!=null && !homeArticleContent.equals("")) {
			homeArticle.setCafe_cafe_id(cafe_id);
			cafeService.registerHomeArticle(homeArticle);
		}
		
		//Cafe Photo Upload
		cafePhotoUpload(multipartRequest, cafe_id, photoSize);
		//Parking Lot Info Init
		List<ParkingLotVO> parkingLotList = new ArrayList<ParkingLotVO>();
		for(int i=1; i<=parkingLotSize; i++) {
			ParkingLotVO parkingLotInfo = new ParkingLotVO();
			String parkingLotName = multipartRequest.getParameter("parkingLot"+i+"_name");
			String parkingLotLocation1 = multipartRequest.getParameter("parkingLot"+i+"_location1");
			String parkingLotLocation2 = multipartRequest.getParameter("parkingLot"+i+"_location2");
			
			parkingLotInfo.setParking_lot_name(parkingLotName);
			parkingLotInfo.setParking_lot_location1(parkingLotLocation1);
			parkingLotInfo.setParking_lot_location2(parkingLotLocation2);
			parkingLotInfo.setCafe_cafe_id(cafe_id);
			
			parkingLotList.add(parkingLotInfo);
		}
		if(parkingLotList.size()>0) cafeService.registerParkingLot(parkingLotList);
		
		/*
		 * add Goods
		 * */
		//save Goods Info
		List<GoodsPhotoInfoVO> goodsImageFileInfoList = goodsService.registerGoods(multipartRequest, cafe_id, goodsSize);
		//save Goods Image
		goodsPhotoUpload(multipartRequest, goodsImageFileInfoList, cafe_id, goodsSize);
		
		
		/*
		 * add GroupSeat
		 * */
		//save GroupSeat Info
		List<GroupSeatPhotoInfoVO> groupSeatImageFileInfoList = groupSeatService.registerGroupSeat(multipartRequest, cafe_id, goodsSize);
		//save Goods Image
		groupSeatPhotoUpload(multipartRequest, groupSeatImageFileInfoList, cafe_id, groupSeatSize);
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("/cafeManager/addCafeForm");
		return mav;
	}

	@Override
	@RequestMapping(value="/cafe/modifyCafe.do" ,method={RequestMethod.POST,RequestMethod.GET})
	public ModelAndView modifyCafe(MultipartHttpServletRequest multipartRequest, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		multipartRequest.setCharacterEncoding("utf-8");
		
		int goodsSize=0;
		int groupSeatSize=0;
		int photoSize=0;
		int parkingLotSize=0;
		
		int cafe_id=0;
		
		HttpSession session =multipartRequest.getSession();
		UserVO userInfo = (UserVO) session.getAttribute("loginSession");
		
		CafeVO cafeInfo = new CafeVO();
		FacilityInfoVO facilityInfo = new FacilityInfoVO();
		
		CafeHomeArticleVO homeArticle = new CafeHomeArticleVO();
		
		Enumeration enu= multipartRequest.getParameterNames();
		
		
		while(enu.hasMoreElements()){
			String name = (String)enu.nextElement();
			String value=multipartRequest.getParameter(name);
			logger.debug("@[CafeController, modifyCafe] parameter name: " + name);
			logger.debug("@[CafeController, modifyCafe] parameter value: " + value);
			if(name.equals("cafe_id")) {
				cafe_id = Integer.parseInt(value);
				cafeInfo.setCafe_id(cafe_id);
			}else if(name.equals("cafe_name")) {
				cafeInfo.setCafe_name(value);
			}else if(name.equals("cafe_location2")) {
				cafeInfo.setCafe_location2(value);
			}else if(name.equals("phonenum1")) {
				cafeInfo.setPhonenum1(value);
			}else if(name.equals("phonenum2")) {
				cafeInfo.setPhonenum2(value);
			}else if(name.equals("phonenum3")) {
				cafeInfo.setPhonenum3(value);
			}else if(name.equals("parking_lot")) {
				if(value.equals("on")) {
					facilityInfo.setParking_lot(true);
				}else {
					facilityInfo.setParking_lot(false);
				}
			}else if(name.equals("wifi")) {
				if(value.equals("on")) {
					facilityInfo.setWifi(true);
				}else {
					facilityInfo.setWifi(false);
				}
			}else if(name.equals("power_plug")) {
				if(value.equals("on")) {
					facilityInfo.setPower_plug(true);
				}else {
					facilityInfo.setPower_plug(false);
				}
			}else if(name.equals("numberOfSeat")){
				int numberOfSeat = Integer.parseInt(value);
				cafeInfo.setNumber_of_seat(numberOfSeat);
			}else if(name.equals("homeArticle_content")) {
				if(value!=null && !value.equals("")) {
					homeArticle.setUser_user_id(userInfo.getUser_id());
					homeArticle.setArticle_content(value);
				}
			}else if(name.equals("goodsSize")) {
				goodsSize = Integer.parseInt(value);
			}else if(name.equals("groupSeatSize")) {
				groupSeatSize = Integer.parseInt(value);
			}else if(name.equals("photoSize")) {
				photoSize = Integer.parseInt(value);
			}else if(name.equals("parkingLotSize")) {
				parkingLotSize = Integer.parseInt(value);
			}
			
			//Cafe Address1 Init
			String cafe_location1="";
			for(int i=0; i<4; i++) {			
				String addrValue= multipartRequest.getParameter("cafe_region"+i);
				if(addrValue!=null && addrValue!=""){
					if(i<3) {
						cafe_location1 += addrValue + " ";
					}else {
						cafe_location1 += addrValue;
					}
					
				}
			}
			cafeInfo.setCafe_location1(cafe_location1);
			
			//Business Time Init
			String opentime="";
			String closetime="";
			for(int i=1; i<4; i++) {
				String opentimeVal = multipartRequest.getParameter("openTime"+i);
				String closetimeVal = multipartRequest.getParameter("closeTime"+i);
				if(i==1) {
					opentime += opentimeVal +":";
					closetime += closetimeVal + ":";
				}else if(i==2) {
					if(opentimeVal.length()==1) {
						opentime += "0"+opentimeVal + " ";
					}else {
						opentime += opentimeVal +" ";
					}
					if(closetimeVal.length()==1) {
						closetime += "0"+closetimeVal + " ";
					}else {
						closetime += closetimeVal + " ";
					}
				}else {
					opentime += opentimeVal;
					closetime += closetimeVal;
				}
			}
			cafeInfo.setOpen_time(opentime);
			cafeInfo.setClose_time(closetime);
		}
		
		// CafeManager Info Init
		cafeInfo.setUser_user_id(userInfo.getUser_id());
		
		//Cafe Status Init
		cafeInfo.setBusiness_state("open");
		
		//Cafe Address1 Init
		String cafe_location1="";
		for(int i=0; i<4; i++) {			
			String addrValue= multipartRequest.getParameter("cafe_region"+i);
			if(addrValue!=null && addrValue!=""){
				if(i<3) {
					cafe_location1 += addrValue + " ";
				}else {
					cafe_location1 += addrValue;
				}
				
			}
		}
		cafeInfo.setCafe_location1(cafe_location1);
		
		//Business Time Init
		String opentime="";
		String closetime="";
		for(int i=1; i<4; i++) {
			String opentimeVal = multipartRequest.getParameter("openTime"+i);
			String closetimeVal = multipartRequest.getParameter("closeTime"+i);
			if(i==1) {
				opentime += opentimeVal +":";
				closetime += closetimeVal + ":";
			}else if(i==2) {
				if(opentimeVal.length()==1) {
					opentime += "0"+opentimeVal + " ";
				}else {
					opentime += opentimeVal +" ";
				}
				if(closetimeVal.length()==1) {
					closetime += "0"+closetimeVal + " ";
				}else {
					closetime += closetimeVal + " ";
				}
			}else {
				opentime += opentimeVal;
				closetime += closetimeVal;
			}
		}
		cafeInfo.setOpen_time(opentime);
		cafeInfo.setClose_time(closetime);
		
		//update cafe info
		cafeService.modifyCafe(cafeInfo);
		
		//update cafe Main Photo
		String filename = "cafeMainPhoto";
		MultipartFile mCafeMainPhotoFile = multipartRequest.getFile(filename);
		//if cafe image size>0, change image
		if(mCafeMainPhotoFile.getSize()>0) {
			deleteCafeMainPhoto(cafe_id);
			changeCafeMainPhoto(multipartRequest, cafe_id);
		}
		
		//update facility info
		facilityInfo.setCafe_cafe_id(cafe_id);
		cafeService.modifyFacilityInfo(facilityInfo);
		
		//update cafe home article
		homeArticle.setCafe_cafe_id(cafe_id);
		cafeService.modifyHomeArticle(homeArticle);
		
		//update cafe goods
		updateGoods(multipartRequest,cafe_id, goodsSize);
		
		//update cafe group seat
		updateGroupSeat(multipartRequest,cafe_id, groupSeatSize);
		
		//update cafe photo
		updateCafePhoto(multipartRequest, cafe_id, photoSize);
		
		//update parking lot info
		updateParkingLot(multipartRequest, cafe_id, parkingLotSize);
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("redirect:/cafeManager/modifyCafeForm.do?cafe_id="+cafe_id);
		return mav;
	}
	

	@Override
	@RequestMapping(value="/cafe/shutdownCafe.do" ,method={RequestMethod.POST,RequestMethod.GET})
	public ResponseEntity<Map<String, Object>> shutdownCafe(@RequestParam("cafe_id") int cafe_id, HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		Map<String, Object> result = new HashMap<String, Object>();
		
		CafeVO cafeInfo = new CafeVO();
		cafeInfo.setCafe_id(cafe_id);
		cafeInfo.setBusiness_state("close");
		
		// shutdown cafe
		cafeService.modifyCafe(cafeInfo);
		// get business state
		cafeInfo = cafeService.getCafeDetail(cafe_id);
		String business_state=cafeInfo.getBusiness_state();
		
		result.put("business_state", business_state);
		
		return ResponseEntity.ok().body(result);
	}
	
	@Override
	@RequestMapping(value="/cafe/undoShutdownCafe.do" ,method={RequestMethod.POST,RequestMethod.GET})
	public ResponseEntity<Map<String, Object>> undoShutdownCafe(int cafe_id, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@RequestMapping(value="/cafe/shutdownMultipleCafe.do" ,method={RequestMethod.POST,RequestMethod.GET})
	public ResponseEntity<Map<String, Object>> shutdownMultipleCafe(@RequestParam("cafeIdList") String cafeIdList, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		 Gson gson = new Gson();
		 Map<String, Object> map = gson.fromJson(cafeIdList, Map.class);
		 Map<Integer, Map<String, String>> resultMap = new HashMap<Integer, Map<String, String>>();
		 for(Map.Entry<String, Object> entry : map.entrySet()) {
			 logger.debug("[@CafeController, shutdownMultipleCafe"+entry.getKey() + "=" + entry.getValue());
			 // shutdown cafe
			 int cafe_id = Integer.parseInt((String)entry.getValue());
			 CafeVO cafeInfo = new CafeVO();
			 cafeInfo.setCafe_id(cafe_id);
			 cafeInfo.setBusiness_state("close");
			 cafeService.modifyCafe(cafeInfo);
			 
			 // get cafe status
			 cafeInfo = cafeService.getCafeDetail(cafe_id);
			 String business_state= cafeInfo.getBusiness_state();
			 Map<String,String> result = new HashMap<String, String>();
			 result.put("business_state", business_state);
			 resultMap.put(cafe_id, result);
		 }
		 String responseStr = gson.toJson(resultMap);
		 //response
		 Map<String,Object> responseMap = new HashMap<String,Object>();
		 responseMap.put("response", responseStr);
		 
		return ResponseEntity.ok().body(responseMap);
	}

	@Override
	@RequestMapping(value="/cafe/undoShutdownMultipleCafe.do" ,method={RequestMethod.POST,RequestMethod.GET})
	public ResponseEntity<Map<String, Object>> undoShutdownMultipleCafe(@RequestParam("cafeIdList") String cafeIdList, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		Gson gson = new Gson();
		 Map<String, Object> map = gson.fromJson(cafeIdList, Map.class);
		 Map<Integer, Map<String, String>> resultMap = new HashMap<Integer, Map<String, String>>();
		 for(Map.Entry<String, Object> entry : map.entrySet()) {
			 logger.debug("[@CafeController, shutdownMultipleCafe"+entry.getKey() + "=" + entry.getValue());
			 // shutdown cafe
			 int cafe_id = Integer.parseInt((String)entry.getValue());
			 CafeVO cafeInfo = new CafeVO();
			 cafeInfo.setCafe_id(cafe_id);
			 cafeInfo.setBusiness_state("open");
			 cafeService.modifyCafe(cafeInfo);
			 
			 // get cafe status
			 cafeInfo = cafeService.getCafeDetail(cafe_id);
			 String business_state= cafeInfo.getBusiness_state();
			 Map<String,String> result = new HashMap<String, String>();
			 result.put("business_state", business_state);
			 resultMap.put(cafe_id, result);
		 }
		 String responseStr = gson.toJson(resultMap);
		 //response
		 Map<String,Object> responseMap = new HashMap<String,Object>();
		 responseMap.put("response", responseStr);
		 
		return ResponseEntity.ok().body(responseMap);
	}

	@Override
	@RequestMapping(value="/cafe/addReview.do" ,method={RequestMethod.POST})
	public ResponseEntity addReview(MultipartHttpServletRequest multipartRequest, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		multipartRequest.setCharacterEncoding("utf-8");
		
		HttpSession session =multipartRequest.getSession();
		UserVO userInfo = (UserVO) session.getAttribute("loginSession");
		String user_id = userInfo.getUser_id();
		
		int cafe_id=0;
		int orderAndReservation_id=0;
		CafeReviewVO cafeReview = new CafeReviewVO();
		ThemeScoreVO themeScore = new ThemeScoreVO();
		
		Enumeration enu= multipartRequest.getParameterNames();
		
		cafeReview.setUser_user_id(user_id);
		while(enu.hasMoreElements()){
			String name = (String)enu.nextElement();
			String value=multipartRequest.getParameter(name);
			logger.debug("@[CafeController, addReview] parameter name: " + name);
			logger.debug("@[CafeController, addReview] parameter value: " + value);
			if(name.equals("cafe_id")){
				cafe_id = Integer.parseInt(value);
				cafeReview.setCafe_cafe_id(cafe_id);
				themeScore.setCafe_cafe_id(cafe_id);
			}else if(name.equals("orderAndReservation_id")) {
				orderAndReservation_id = Integer.parseInt(value);
				cafeReview.setOrderAndReservation_OrderAndReservation_id(orderAndReservation_id);
			}else if(name.equals("coffeeRate")) {
				int coffee_score = Integer.parseInt(value);
				themeScore.setCoffee_score(coffee_score);
			}else if(name.equals("drinkRate")) {
				int drink_score = Integer.parseInt(value);
				themeScore.setDrink_score(drink_score);
			}else if(name.equals("dessertRate")) {
				int dessert_score = Integer.parseInt(value);
				themeScore.setDessert_score(dessert_score);
			}else if(name.equals("viewRate")) {
				int view_score = Integer.parseInt(value);
				themeScore.setView_score(view_score);
			}else if(name.equals("moodRate")) {
				int mood_score = Integer.parseInt(value);
				themeScore.setMood_score(mood_score);
			}else if(name.equals("quietRate")) {
				int quiet_score = Integer.parseInt(value);
				themeScore.setQuiet_score(quiet_score);
			}else if(name.equals("review_content")) {
				cafeReview.setReview_content(value);
			}
		}
		Map<String,Object> cafeReviewMap = new HashMap<String,Object>();
		cafeReviewMap.put("cafeReview", cafeReview);
		cafeReviewMap.put("themeScore", themeScore);
		
		//add Review and Cafe Review Score
		int review_id = cafeReviewService.addCafeReview(cafeReviewMap);
		
		//add Review Image Upload
		cafeReviewPhotoUpload(multipartRequest, cafe_id, review_id);
		
		
		return ResponseEntity.noContent().build();
	}

	@Override
	@RequestMapping(value="/cafe/modifyReview.do" ,method={RequestMethod.POST,RequestMethod.GET})
	public ResponseEntity modifyReview(MultipartHttpServletRequest multipartRequest, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		multipartRequest.setCharacterEncoding("utf-8");
		
		HttpSession session =multipartRequest.getSession();
		UserVO userInfo = (UserVO) session.getAttribute("loginSession");
		String user_id = userInfo.getUser_id();
		
		int cafe_id=0;
		int review_id=0;
		int orderAndReservation_id=0;
		String filenameFromUserInput="";
		
		CafeReviewVO cafeReview = new CafeReviewVO();
		ThemeScoreVO themeScore = new ThemeScoreVO();
		
		Enumeration enu= multipartRequest.getParameterNames();
		
		cafeReview.setUser_user_id(user_id);
		while(enu.hasMoreElements()){
			String name = (String)enu.nextElement();
			String value=multipartRequest.getParameter(name);
			logger.debug("@[CafeController, addReview] parameter name: " + name);
			logger.debug("@[CafeController, addReview] parameter value: " + value);
			if(name.equals("cafe_id")){
				cafe_id = Integer.parseInt(value);
				cafeReview.setCafe_cafe_id(cafe_id);
				themeScore.setCafe_cafe_id(cafe_id);
			}else if(name.equals("review_id")) {
				review_id = Integer.parseInt(value);
				cafeReview.setReview_id(review_id);
				themeScore.setReview_review_id(review_id);
			}else if(name.equals("orderAndReservation_id")) {
				orderAndReservation_id = Integer.parseInt(value);
				cafeReview.setOrderAndReservation_OrderAndReservation_id(orderAndReservation_id);
			}else if(name.equals("coffeeRate")) {
				int coffee_score = Integer.parseInt(value);
				themeScore.setCoffee_score(coffee_score);
			}else if(name.equals("drinkRate")) {
				int drink_score = Integer.parseInt(value);
				themeScore.setDrink_score(drink_score);
			}else if(name.equals("dessertRate")) {
				int dessert_score = Integer.parseInt(value);
				themeScore.setDessert_score(dessert_score);
			}else if(name.equals("viewRate")) {
				int view_score = Integer.parseInt(value);
				themeScore.setView_score(view_score);
			}else if(name.equals("moodRate")) {
				int mood_score = Integer.parseInt(value);
				themeScore.setMood_score(mood_score);
			}else if(name.equals("quietRate")) {
				int quiet_score = Integer.parseInt(value);
				themeScore.setQuiet_score(quiet_score);
			}else if(name.equals("review_content")) {
				cafeReview.setReview_content(value);
			}else if(name.equals("review_photo_filename")) {
				filenameFromUserInput=value;
			}
		}
		Map<String,Object> cafeReviewMap = new HashMap<String,Object>();
		cafeReviewMap.put("cafeReview", cafeReview);
		cafeReviewMap.put("themeScore", themeScore);
		
		//add Review and Cafe Review Score
		cafeReviewService.modifyCafeReview(cafeReviewMap);
		
		
		String filename = "review_photo";
		MultipartFile mFile = multipartRequest.getFile(filename);
		//if file size>0
		if(mFile.getSize()>0) {
			/* change Review Photo */
			CafeReviewPhotoVO cafeReviewPhoto = cafeReviewService.getCafeReviewPhoto(review_id);
			//if exists previous image
			if(cafeReviewPhoto != null) {
				//delete Review Photo 
				deleteReivewPhoto(review_id, cafe_id);
				
				//change Review Image
				cafeReviewPhotoModify(multipartRequest, cafe_id, review_id);
			}
			//else
			else {
				//add Review Image
				cafeReviewPhotoUpload(multipartRequest, cafe_id, review_id);
			}
		}
		//else
		else if(filenameFromUserInput.equals("")){
			//if filename is empty string
			/* delete photo */
			// delete file and data in DB
			deleteReivewPhoto(review_id, cafe_id);
			cafeReviewService.deleteCafeReviewPhoto(review_id);
		}
		
		return ResponseEntity.noContent().build();
	}

	@Override
	@RequestMapping(value="/cafe/deleteReview.do" ,method={RequestMethod.POST,RequestMethod.GET})
	public ResponseEntity deleteReview(@RequestParam("review_id") int review_id, HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		
		//delete reivew
		int cafe_id = cafeReviewService.deleteCafeReview(review_id);
		// delete review photo
		deleteReivewPhoto(review_id, cafe_id);
		
		return ResponseEntity.noContent().build();
	}

	@Override
	@RequestMapping(value="/cafe/showReview.do" ,method={RequestMethod.POST,RequestMethod.GET})
	public ModelAndView showReview(MultipartHttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@RequestMapping(value="/cafe/likeCafe.do" ,method={RequestMethod.POST,RequestMethod.GET})
	public ResponseEntity likeCafe(@ModelAttribute LikedCafeVO  likedCafe, HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		
		
		String result = "ok";
		ResponseEntity resEntity =new ResponseEntity(result, HttpStatus.OK);
		return resEntity;	
	}
	
	private void cafeMainPhotoUpload(MultipartHttpServletRequest multipartRequest, int cafe_id) throws IllegalStateException, IOException {		
		final String CURR_GOODS_IMAGE_DIR = CURR_IMAGE_REPO_PATH+"/"+cafe_id+"/cafePhoto";
		String filename = "cafeMainPhoto";
		String photoType = "main";
		MultipartFile mFile = multipartRequest.getFile(filename);
		String OrgFilename = mFile.getOriginalFilename();
		UUID uuid = UUID.randomUUID();
		String uuidStr=uuid.toString();
		String orgFilenameWithUUID = uuidStr + "_" +OrgFilename;
		
		
		if(!orgFilenameWithUUID.equals("") || orgFilenameWithUUID!=null) {
			String IMG_PATH=CURR_GOODS_IMAGE_DIR+"/"+orgFilenameWithUUID;
			File file = new File(IMG_PATH);
			if(mFile.getSize()>0) {
				if(!file.exists()) {
					if(file.getParentFile().mkdirs()) {
						file.createNewFile();
					}
				}
				mFile.transferTo((new File(IMG_PATH)));
				CafePhotoVO cafePhoto = new CafePhotoVO(orgFilenameWithUUID, photoType, cafe_id);
				cafePhotoService.addCafePhoto(cafePhoto);
			}
		}
	}
	
	private void goodsPhotoUpload(MultipartHttpServletRequest multipartRequest, int cafe_id, int goods_id, String inputname)throws Exception {
		final String CURR_GOODS_IMAGE_DIR = CURR_IMAGE_REPO_PATH+"/"+cafe_id+"/goods";
		
		MultipartFile mFile = multipartRequest.getFile(inputname);
		String OrgFilename = mFile.getOriginalFilename();
		UUID uuid = UUID.randomUUID();
		String uuidStr=uuid.toString();
		String orgFilenameWithUUID = uuidStr + "_" +OrgFilename;
		
		if(!OrgFilename.equals("") || OrgFilename!=null) {
			String IMG_PATH=CURR_GOODS_IMAGE_DIR+"/"+goods_id+"/"+orgFilenameWithUUID;
			File file = new File(IMG_PATH);
			if(mFile.getSize()>0) {
				if(!file.exists()) {
					if(file.getParentFile().mkdirs()) {
						file.createNewFile();
					}
				}
				mFile.transferTo((new File(IMG_PATH)));
				GoodsPhotoVO goodsPhoto = new GoodsPhotoVO(goods_id, orgFilenameWithUUID);
				goodsService.registerGoodsPhoto(goodsPhoto);
			}
		}
		
	}
	
	private void goodsPhotoUpload(MultipartHttpServletRequest multipartRequest, List<GoodsPhotoInfoVO> imageFileInfoList, int cafe_id, int goodsSize)throws Exception {
		final String CURR_GOODS_IMAGE_DIR = CURR_IMAGE_REPO_PATH+"/"+cafe_id+"/goods";
		for(int i=0; i<imageFileInfoList.size(); i++) {
			GoodsPhotoInfoVO filenameInfo = (GoodsPhotoInfoVO) imageFileInfoList.get(i);
			int goods_id = filenameInfo.getGoods_id();
			String filename = filenameInfo.getFilename();
			String OrgFilename = filenameInfo.getOrgFilename();
			MultipartFile mFile = multipartRequest.getFile(filename);
			if(!OrgFilename.equals("") || OrgFilename!=null) {
				String IMG_PATH=CURR_GOODS_IMAGE_DIR+"/"+goods_id+"/"+OrgFilename;
				File file = new File(IMG_PATH);
				if(mFile.getSize()>0) {
					if(!file.exists()) {
						if(file.getParentFile().mkdirs()) {
							file.createNewFile();
						}
					}
					mFile.transferTo((new File(IMG_PATH)));
				}
			}
		}
	}
	private void groupSeatPhotoUpload(MultipartHttpServletRequest multipartRequest, List<GroupSeatPhotoInfoVO> imageFileInfoList, int cafe_id, int goodsSize) throws IOException {
		final String CURR_GROUPSEAT_IMAGE_DIR = CURR_IMAGE_REPO_PATH+"/"+cafe_id+"/groupSeat";
		for(int i=0; i<imageFileInfoList.size(); i++) {
			GroupSeatPhotoInfoVO filenameInfo = (GroupSeatPhotoInfoVO) imageFileInfoList.get(i);
			int groupSeat_id = filenameInfo.getGroupSeat_id();
			String filename = filenameInfo.getFilename();
			String OrgFilename = filenameInfo.getOrgFilename();
			MultipartFile mFile = multipartRequest.getFile(filename);
			if(!OrgFilename.equals("") || OrgFilename!=null) {
				String IMG_PATH=CURR_GROUPSEAT_IMAGE_DIR+"/"+groupSeat_id+"/"+OrgFilename;
				File file = new File(IMG_PATH);
				if(mFile.getSize()>0) {
					if(!file.exists()) {
						if(file.getParentFile().mkdirs()) {
							file.createNewFile();
						}
					}
					mFile.transferTo((new File(IMG_PATH)));
				}
			}
		}
	}
	private void groupSeatPhotoUpload(MultipartHttpServletRequest multipartRequest, int cafe_id, int groupSeat_id, String inputname)throws Exception {
		final String CURR_GROUPSEAT_IMAGE_DIR = CURR_IMAGE_REPO_PATH+"/"+cafe_id+"/groupSeat";
		
		MultipartFile mFile = multipartRequest.getFile(inputname);
		String OrgFilename = mFile.getOriginalFilename();
		UUID uuid = UUID.randomUUID();
		String uuidStr=uuid.toString();
		String orgFilenameWithUUID = uuidStr + "_" +OrgFilename;
		
		if(!OrgFilename.equals("") || OrgFilename!=null) {
			String IMG_PATH=CURR_GROUPSEAT_IMAGE_DIR+"/"+groupSeat_id+"/"+orgFilenameWithUUID;
			File file = new File(IMG_PATH);
			if(mFile.getSize()>0) {
				if(!file.exists()) {
					if(file.getParentFile().mkdirs()) {
						file.createNewFile();
					}
				}
				mFile.transferTo((new File(IMG_PATH)));
				GroupSeatPhotoVO groupSeatPhoto = new GroupSeatPhotoVO(groupSeat_id, orgFilenameWithUUID);
				groupSeatService.registerGroupSeatPhoto(groupSeatPhoto);
			}
		}
		
	}
	private void cafePhotoUpload(MultipartHttpServletRequest multipartRequest, int cafe_id, int photoSize) throws IllegalStateException, IOException {
		final String CURR_CAFE_IMAGE_DIR = CURR_IMAGE_REPO_PATH+"/"+cafe_id+"/cafePhoto";
		String photoType = "normal";
		for(int i=1; i<=photoSize; i++) {
			String filename = "cafe"+i+"_photo_file";
			MultipartFile mFile = multipartRequest.getFile(filename);
			logger.debug("[@GoodsService, addGoods] multipartRequest is null?: "+(multipartRequest==null));
			logger.debug("[@GoodsService, addGoods] file key name: "+"goodsphoto"+i);
			logger.debug("[@GoodsService, addGoods] filename: "+filename);
			logger.debug("[@GoodsService, addGoods] mFile is null?: "+(mFile==null));
			
			String OrgFilename = mFile.getOriginalFilename();
			UUID uuid = UUID.randomUUID();
			String uuidStr=uuid.toString();
			String orgFilenameWithUUID = uuidStr + "_" +OrgFilename;
			
			
			if(!orgFilenameWithUUID.equals("") || orgFilenameWithUUID!=null) {
				String IMG_PATH=CURR_CAFE_IMAGE_DIR+"/"+orgFilenameWithUUID;
				File file = new File(IMG_PATH);
				if(mFile.getSize()>0) {
					if(!file.exists()) {
						if(file.getParentFile().mkdirs()) {
							file.createNewFile();
						}
					}
					mFile.transferTo((new File(IMG_PATH)));
					CafePhotoVO cafePhoto = new CafePhotoVO(orgFilenameWithUUID, photoType, cafe_id);
					cafePhotoService.addCafePhoto(cafePhoto);
				}
			}
		}
	}
	
	private void cafePhotoUpload(MultipartHttpServletRequest multipartRequest, int cafe_id, String inputname)throws Exception {
		final String CURR_CAFE_IMAGE_DIR = CURR_IMAGE_REPO_PATH+"/"+cafe_id+"/cafePhoto";
		
		MultipartFile mFile = multipartRequest.getFile(inputname);
		String OrgFilename = mFile.getOriginalFilename();
		UUID uuid = UUID.randomUUID();
		String uuidStr=uuid.toString();
		String orgFilenameWithUUID = uuidStr + "_" +OrgFilename;
		
		if(!OrgFilename.equals("") || OrgFilename!=null) {
			String IMG_PATH=CURR_CAFE_IMAGE_DIR+"/"+orgFilenameWithUUID;
			File file = new File(IMG_PATH);
			if(mFile.getSize()>0) {
				if(!file.exists()) {
					if(file.getParentFile().mkdirs()) {
						file.createNewFile();
					}
				}
				mFile.transferTo((new File(IMG_PATH)));
				CafePhotoVO cafePhoto = new CafePhotoVO(orgFilenameWithUUID, "normal", cafe_id);
				cafePhotoService.addCafePhoto(cafePhoto);
			}
		}
		
	}
	
	private void cafeReviewPhotoUpload(MultipartHttpServletRequest multipartRequest, int cafe_id, int review_id) throws IOException {
		final String CURR_REVIEW_IMAGE_DIR = CURR_IMAGE_REPO_PATH+"/"+cafe_id+"/cafeReviewPhoto"+"/"+review_id;
		
		String filename = "review_photo";
		MultipartFile mFile = multipartRequest.getFile(filename);
		logger.debug("[@CafeController, addCafeReview] multipartRequest is null?: "+(multipartRequest==null));
		logger.debug("[@CafeController, addCafeReview] filename: "+filename);
		logger.debug("[@CafeController, addCafeReview] mFile is null?: "+(mFile==null));
		
		String OrgFilename = mFile.getOriginalFilename();
		UUID uuid = UUID.randomUUID();
		String uuidStr=uuid.toString();
		String orgFilenameWithUUID = uuidStr + "_" +OrgFilename;
		
		
		if(!orgFilenameWithUUID.equals("") || orgFilenameWithUUID!=null) {
			String IMG_PATH=CURR_REVIEW_IMAGE_DIR+"/"+orgFilenameWithUUID;
			File file = new File(IMG_PATH);
			if(mFile.getSize()>0) {
				if(!file.exists()) {
					if(file.getParentFile().mkdirs()) {
						file.createNewFile();
					}
				}
				mFile.transferTo((new File(IMG_PATH)));
				CafeReviewPhotoVO cafePhoto = new CafeReviewPhotoVO(review_id, orgFilenameWithUUID);
				cafeReviewService.addCafeReviewPhoto(cafePhoto);
			}
		}
	}
	private void cafeReviewPhotoModify(MultipartHttpServletRequest multipartRequest, int cafe_id, int review_id) throws IOException {
		final String CURR_REVIEW_IMAGE_DIR = CURR_IMAGE_REPO_PATH+"/"+cafe_id+"/cafeReviewPhoto"+"/"+review_id;
		
		String filename = "review_photo";
		MultipartFile mFile = multipartRequest.getFile(filename);
		logger.debug("[@CafeController, cafeReviewPhotoModify] multipartRequest is null?: "+(multipartRequest==null));
		logger.debug("[@CafeController, cafeReviewPhotoModify] filename: "+filename);
		logger.debug("[@CafeController, cafeReviewPhotoModify] mFile is null?: "+(mFile==null));
		
		String OrgFilename = mFile.getOriginalFilename();
		UUID uuid = UUID.randomUUID();
		String uuidStr=uuid.toString();
		String orgFilenameWithUUID = uuidStr + "_" +OrgFilename;
		
		
		if(!orgFilenameWithUUID.equals("") || orgFilenameWithUUID!=null) {
			String IMG_PATH=CURR_REVIEW_IMAGE_DIR+"/"+orgFilenameWithUUID;
			File file = new File(IMG_PATH);
			if(mFile.getSize()>0) {
				if(!file.exists()) {
					if(file.getParentFile().mkdirs()) {
						file.createNewFile();
					}
				}
				mFile.transferTo((new File(IMG_PATH)));
				logger.debug("[@CafeController, cafeReviewPhotoModify] orgFilenameWithUUID: "+orgFilenameWithUUID);
				CafeReviewPhotoVO cafePhoto = new CafeReviewPhotoVO(review_id, orgFilenameWithUUID);
				cafeReviewService.modifyCafeReviewPhoto(cafePhoto);
			}
		}
	}
	protected boolean isDummyFile(String name) {
		boolean filenameValidation = false;
		StringTokenizer tokenizer = new StringTokenizer(name,".");
		
		if(tokenizer.countTokens()<=1) {
			filenameValidation=true;
		}
		return filenameValidation;
	}
	
	@RequestMapping("/cafe/downloadCafeMainImage.do")
	public void downloadCafeMainImage(@RequestParam("cafe_id") int cafe_id,
			                 HttpServletResponse response) throws Exception {
		OutputStream out = response.getOutputStream();
		String filePath=CURR_IMAGE_REPO_PATH+"/"+cafe_id+"/"+"cafePhoto";
		File imageDir=new File(filePath);
		
		CafePhotoVO cafeMainPhoto = (CafePhotoVO)cafePhotoService.getCafeMainPhoto(cafe_id);
		String imageFileName = cafeMainPhoto.getFilename();
		File imageFile = new File(filePath+"/"+imageFileName);
		logger.debug("imageFileName: "+imageFileName);
		if(imageFile!=null && imageFile.exists()) {
			response.setHeader("Cache-Control","no-cache");
			response.addHeader("Content-disposition", "attachment; fileName="+imageFileName);
			FileInputStream in=new FileInputStream(imageFile); 
			byte[] buffer=new byte[1024*8];
			while(true){
				int count=in.read(buffer); //���ۿ� �о���� ���ڰ���
				if(count==-1)  //������ �������� �����ߴ��� üũ
					break;
				out.write(buffer,0,count);
			}
			in.close();
		}
		out.close();
	}
	@RequestMapping("/cafe/downloadCafeImage.do")
	public void downloadCafeImage(@RequestParam("cafe_id") int cafe_id, @RequestParam("photo_id") int photo_id,
			                 HttpServletResponse response) throws Exception {
		OutputStream out = response.getOutputStream();
		String filePath=CURR_IMAGE_REPO_PATH+"/"+cafe_id+"/"+"cafePhoto";
		File imageDir=new File(filePath);
		
		CafePhotoVO cafeMainPhoto = cafePhotoService.getOneCafePhoto(photo_id);
		String imageFileName = cafeMainPhoto.getFilename();
		File imageFile = new File(filePath+"/"+imageFileName);
		logger.debug("imageFileName: "+imageFileName);
		if(imageFile!=null && imageFile.exists()) {
			response.setHeader("Cache-Control","no-cache");
			response.addHeader("Content-disposition", "attachment; fileName="+imageFileName);
			FileInputStream in=new FileInputStream(imageFile); 
			byte[] buffer=new byte[1024*8];
			while(true){
				int count=in.read(buffer); //���ۿ� �о���� ���ڰ���
				if(count==-1)  //������ �������� �����ߴ��� üũ
					break;
				out.write(buffer,0,count);
			}
			in.close();
		}
		out.close();
	}
	@RequestMapping("/cafe/downloadGoodsPhoto.do")
	public void downloadGoodsPhoto(@RequestParam("cafe_id") int cafe_id,@RequestParam("goods_id") int goods_id,
			                 HttpServletResponse response) throws Exception {
		OutputStream out = response.getOutputStream();
		String filePath=CURR_IMAGE_REPO_PATH+"/"+cafe_id+"/"+"goods"+"/"+goods_id;
		
		GoodsPhotoVO goodsPhoto = (GoodsPhotoVO)goodsService.getGoodsPhoto(goods_id);
		if(goodsPhoto!=null) {
			String imageFileName = goodsPhoto.getFilename();
			File imageFile = new File(filePath+"/"+imageFileName);
			logger.debug("imageFileName: "+imageFileName);
			if(imageFile!=null && imageFile.exists()) {
				response.setHeader("Cache-Control","no-cache");
				response.addHeader("Content-disposition", "attachment; fileName="+imageFileName);
				FileInputStream in=new FileInputStream(imageFile); 
				byte[] buffer=new byte[1024*8];
				while(true){
					int count=in.read(buffer); //���ۿ� �о���� ���ڰ���
					if(count==-1)  //������ �������� �����ߴ��� üũ
						break;
					out.write(buffer,0,count);
				}
				in.close();
			}
		}
		out.close();
	}
	@RequestMapping("/cafe/downloadGroupSeatPhoto.do")
	public void downloadGroupSeatPhoto(@RequestParam("cafe_id") int cafe_id,@RequestParam("groupSeat_id") int groupSeat_id,
			                 HttpServletResponse response) throws Exception {
		OutputStream out = response.getOutputStream();
		String filePath=CURR_IMAGE_REPO_PATH+"/"+cafe_id+"/"+"groupSeat"+"/"+groupSeat_id;
		File imageDir=new File(filePath);
		
		GroupSeatPhotoVO goodsPhoto = (GroupSeatPhotoVO)groupSeatService.getGroupSeatPhoto(groupSeat_id);
		String imageFileName = goodsPhoto.getFilename();
		File imageFile = new File(filePath+"/"+imageFileName);
		logger.debug("imageFileName: "+imageFileName);
		if(imageFile!=null && imageFile.exists()) {
			response.setHeader("Cache-Control","no-cache");
			response.addHeader("Content-disposition", "attachment; fileName="+imageFileName);
			FileInputStream in=new FileInputStream(imageFile); 
			byte[] buffer=new byte[1024*8];
			while(true){
				int count=in.read(buffer); //���ۿ� �о���� ���ڰ���
				if(count==-1)  //������ �������� �����ߴ��� üũ
					break;
				out.write(buffer,0,count);
			}
			in.close();
		}
		out.close();
	}
	@RequestMapping("/cafe/downloadCafeReviewImage.do")
	public void downloadCafeReviewImage(@RequestParam("cafe_id") int cafe_id,
			@RequestParam("review_id") int review_id, HttpServletRequest request, HttpServletResponse response) throws Exception {
		OutputStream out = response.getOutputStream();
		String filePath=CURR_IMAGE_REPO_PATH+"/"+cafe_id+"/"+"cafeReviewPhoto"+"/"+review_id;
		File imageDir=new File(filePath);

		File imageFile;
		String imageFileName;
		CafeReviewPhotoVO cafeReviewPhoto = (CafeReviewPhotoVO)cafeReviewService.getCafeReviewPhoto(review_id);
		if(cafeReviewPhoto != null) {
			imageFileName = cafeReviewPhoto.getFilename();
			imageFile = new File(filePath+"/"+imageFileName);
			
			
			if(imageFile!=null && imageFile.exists()) {
				response.setHeader("Cache-Control","no-cache");
				response.addHeader("Content-disposition", "attachment; fileName="+imageFileName);
				FileInputStream in=new FileInputStream(imageFile); 
				byte[] buffer=new byte[1024*8];
				while(true){
					int count=in.read(buffer); //���ۿ� �о���� ���ڰ���
					if(count==-1)  //������ �������� �����ߴ��� üũ
						break;
					out.write(buffer,0,count);
				}
				in.close();
			}
		}
		out.close();
	}
	@RequestMapping(value= "/cafe/toggleLikeCafe.do" ,method={RequestMethod.POST})
	public ResponseEntity toggleLikeCafe(@RequestParam("cafe_id") int cafe_id, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		HttpSession loginSession = request.getSession();
		UserVO userInfo = (UserVO)loginSession.getAttribute("loginSession");
		String user_id = userInfo.getUser_id();
		cafeService.toggleLikeCafe(user_id, cafe_id);
		return ResponseEntity.noContent().build();
	}
	
	private void changeCafeMainPhoto(MultipartHttpServletRequest multipartRequest, int cafe_id) throws IllegalStateException, IOException {		
		final String CURR_GOODS_IMAGE_DIR = CURR_IMAGE_REPO_PATH+"/"+cafe_id+"/cafePhoto";
		String filename = "cafeMainPhoto";
		String photoType = "main";
		MultipartFile mFile = multipartRequest.getFile(filename);
		String OrgFilename = mFile.getOriginalFilename();
		UUID uuid = UUID.randomUUID();
		String uuidStr=uuid.toString();
		String orgFilenameWithUUID = uuidStr + "_" +OrgFilename;
		
		if(!orgFilenameWithUUID.equals("") || orgFilenameWithUUID!=null) {
			String IMG_PATH=CURR_GOODS_IMAGE_DIR+"/"+orgFilenameWithUUID;
			File file = new File(IMG_PATH);
			if(mFile.getSize()>0) {
				if(!file.exists()) {
					if(file.getParentFile().mkdirs()) {
						file.createNewFile();
					}
				}
				mFile.transferTo((new File(IMG_PATH)));
				CafePhotoVO prevCafeMainPhoto = cafePhotoService.getCafeMainPhoto(cafe_id);
				if(prevCafeMainPhoto == null) {
					CafePhotoVO cafePhoto = new CafePhotoVO(orgFilenameWithUUID, photoType, cafe_id);
					cafePhotoService.addCafePhoto(cafePhoto);
				}else {
					int prevCafeMainPhoto_id = prevCafeMainPhoto.getPhoto_id();
					CafePhotoVO cafePhoto = new CafePhotoVO(prevCafeMainPhoto_id, orgFilenameWithUUID, photoType, cafe_id);
					cafePhotoService.modifyCafePhoto(cafePhoto);
				}
			}
		}
	}
	
	private void changeGoodsPhoto(MultipartHttpServletRequest multipartRequest, int cafe_id, int goods_id, String inputname)throws Exception {
		final String CURR_GOODS_IMAGE_DIR = CURR_IMAGE_REPO_PATH+"/"+cafe_id+"/goods";
		
		MultipartFile mFile = multipartRequest.getFile(inputname);
		String OrgFilename = mFile.getOriginalFilename();
		UUID uuid = UUID.randomUUID();
		String uuidStr=uuid.toString();
		String orgFilenameWithUUID = uuidStr + "_" +OrgFilename;
		
		if(!OrgFilename.equals("") || OrgFilename!=null) {
			String IMG_PATH=CURR_GOODS_IMAGE_DIR+"/"+goods_id+"/"+orgFilenameWithUUID;
			File file = new File(IMG_PATH);
			if(mFile.getSize()>0) {
				if(!file.exists()) {
					if(file.getParentFile().mkdirs()) {
						file.createNewFile();
					}
				}
				mFile.transferTo((new File(IMG_PATH)));
				
				GoodsPhotoVO prevGoodsPhoto = goodsService.getGoodsPhoto(goods_id);
				if(prevGoodsPhoto != null) {
					prevGoodsPhoto.setFilename(orgFilenameWithUUID);
					goodsService.modifyGoodsPhoto(prevGoodsPhoto);
				}else {
					GoodsPhotoVO newGoodsPhoto = new GoodsPhotoVO(goods_id, orgFilenameWithUUID);
					goodsService.registerGoodsPhoto(newGoodsPhoto);
				}
			}
		}
	}
	
	private void changeGroupSeatPhoto(MultipartHttpServletRequest multipartRequest, int cafe_id, int groupSeat_id, String inputname)throws Exception {
		final String CURR_GROUPSEAT_IMAGE_DIR = CURR_IMAGE_REPO_PATH+"/"+cafe_id+"/groupSeat";
		
		MultipartFile mFile = multipartRequest.getFile(inputname);
		String OrgFilename = mFile.getOriginalFilename();
		UUID uuid = UUID.randomUUID();
		String uuidStr=uuid.toString();
		String orgFilenameWithUUID = uuidStr + "_" +OrgFilename;
		
		if(!OrgFilename.equals("") || OrgFilename!=null) {
			String IMG_PATH=CURR_GROUPSEAT_IMAGE_DIR+"/"+groupSeat_id+"/"+orgFilenameWithUUID;
			File file = new File(IMG_PATH);
			if(mFile.getSize()>0) {
				if(!file.exists()) {
					if(file.getParentFile().mkdirs()) {
						file.createNewFile();
					}
				}
				mFile.transferTo((new File(IMG_PATH)));
				
				GroupSeatPhotoVO prevGroupSeatPhoto = groupSeatService.getGroupSeatPhoto(groupSeat_id);
				if(prevGroupSeatPhoto != null) {
					prevGroupSeatPhoto.setFilename(orgFilenameWithUUID);
					groupSeatService.modifyGroupSeatPhoto(prevGroupSeatPhoto);
				}else {
					GroupSeatPhotoVO newGroupSeatPhoto = new GroupSeatPhotoVO(groupSeat_id, orgFilenameWithUUID);
					groupSeatService.registerGroupSeatPhoto(newGroupSeatPhoto);
				}
			}
		}
	}
	
	private void changeCafePhoto(MultipartHttpServletRequest multipartRequest, int cafe_id, int photo_id, String inputname)throws Exception {
		final String CURR_CAFE_IMAGE_DIR = CURR_IMAGE_REPO_PATH+"/"+cafe_id+"/cafePhoto";
		
		MultipartFile mFile = multipartRequest.getFile(inputname);
		String OrgFilename = mFile.getOriginalFilename();
		UUID uuid = UUID.randomUUID();
		String uuidStr=uuid.toString();
		String orgFilenameWithUUID = uuidStr + "_" +OrgFilename;
		
		if(!OrgFilename.equals("") || OrgFilename!=null) {
			String IMG_PATH=CURR_CAFE_IMAGE_DIR+"/"+orgFilenameWithUUID;
			File file = new File(IMG_PATH);
			if(mFile.getSize()>0) {
				if(!file.exists()) {
					if(file.getParentFile().mkdirs()) {
						file.createNewFile();
					}
				}
				mFile.transferTo((new File(IMG_PATH)));
				
				CafePhotoVO prevCafePhoto = cafePhotoService.getOneCafePhoto(photo_id);
				if(prevCafePhoto != null) {
					prevCafePhoto.setFilename(orgFilenameWithUUID);
					cafePhotoService.modifyCafePhoto(prevCafePhoto);
				}else {
					CafePhotoVO newGroupSeatPhoto = new CafePhotoVO(orgFilenameWithUUID, photo_id);
					cafePhotoService.addCafePhoto(newGroupSeatPhoto);
				}
			}
		}
	}
	
	public void deleteCafeMainPhoto(int cafe_id) {
		String imageDirPath=CURR_IMAGE_REPO_PATH+"/"+cafe_id+"/"+"cafePhoto";
		CafePhotoVO cafeMainPhoto = cafePhotoService.getCafeMainPhoto(cafe_id);
		String imageFilePath= imageDirPath + "/" + cafeMainPhoto.getFilename();
		File cafePhotoFile = new File(imageFilePath);
		if(cafePhotoFile.exists()) {
			cafePhotoFile.delete();
		}
	}
	
	public void deleteGoodsPhoto(int cafe_id, int goods_id) {
		final String CURR_GOODS_IMAGE_DIR = CURR_IMAGE_REPO_PATH+cafe_id+"/goods"+"/"+ goods_id;
		File goodsPhotoDir = new File(CURR_GOODS_IMAGE_DIR);
		
		if (goodsPhotoDir.exists()) {
			GoodsPhotoVO goodsPhoto = goodsService.getGoodsPhoto(goods_id);
			if(goodsPhoto != null) {
				String goodsPhotoFilename= goodsPhoto.getFilename();
				String goodsPhotoFilePath = CURR_GOODS_IMAGE_DIR+"/"+goodsPhotoFilename;
				logger.debug("[@CafeControllerImpl, deleteGoodsPhoto] goodsPhotoFilePath: "+ goodsPhotoFilePath);
				//delete file
				File goodsPhotoFile = new File(goodsPhotoFilePath);
				if(goodsPhotoFile.exists()) {
					goodsPhotoFile.delete();
				}else {
					logger.debug("[@CafeControllerImpl, deleteGoodsPhoto] attempted to delete goods photo, file not exists.");
				}
				//delete directory
				goodsPhotoDir.delete();
			}
		}
	}
	
	public void deleteCafePhoto(int cafe_id, int photo_id) {
		final String CURR_CAFE_IMAGE_DIR = CURR_IMAGE_REPO_PATH+"/"+cafe_id+"/cafePhoto";
		File cafePhotoDir = new File(CURR_CAFE_IMAGE_DIR);
		
		if (cafePhotoDir.exists()) {
			CafePhotoVO cafePhoto = cafePhotoService.getOneCafePhoto(photo_id);
			if(cafePhoto != null) {
				String cafePhotoFilename= cafePhoto.getFilename();
				String cafePhotoFilePath = CURR_CAFE_IMAGE_DIR+"/"+cafePhotoFilename;
				logger.debug("[@CafeControllerImpl, deleteCafePhoto] cafePhotoFilePath: "+ cafePhotoFilePath);
				//delete file
				File cafePhotoFile = new File(cafePhotoFilePath);
				if(cafePhotoFile.exists()) {
					cafePhotoFile.delete();
				}else {
					logger.debug("[@CafeControllerImpl, deleteCafePhoto] attempted to delete cafe photo, file not exists.");
				}
			}
		}
	}
	
	public void deleteGroupSeatPhoto(int cafe_id, int groupseat_id) {
		final String CURR_GROUPSEAT_IMAGE_DIR = CURR_IMAGE_REPO_PATH+"/"+cafe_id+"/groupSeat";
		File groupSeatPhotoDir = new File(CURR_GROUPSEAT_IMAGE_DIR);
		
		if(groupSeatPhotoDir.exists()) {
			GroupSeatPhotoVO groupSeatPhoto = groupSeatService.getGroupSeatPhoto(groupseat_id);
			if(groupSeatPhoto != null) {
				String groupSeatPhotoFilename= groupSeatPhoto.getFilename();
				String groupSeatPhotoFilePath = CURR_GROUPSEAT_IMAGE_DIR+"/"+groupSeatPhotoFilename;
				logger.debug("[@CafeControllerImpl, deleteGroupSeatPhoto] groupSeatPhotoFilePath: "+ groupSeatPhotoFilePath);
				//delete file
				File groupSeatPhotoFile = new File(groupSeatPhotoFilePath);
				if(groupSeatPhotoFile.exists()) {
					groupSeatPhotoFile.delete();
				}else {
					logger.debug("[@CafeControllerImpl, deleteGroupSeatPhoto] attempted to delete groupSeat photo, file not exists.");
				}
				//delete directory
				groupSeatPhotoDir.delete();
			}
		}
	}
	
	public void deleteReivewPhoto(int review_id, int cafe_id) {
		final String CURR_REVIEW_IMAGE_DIR = CURR_IMAGE_REPO_PATH+"/"+cafe_id+"/cafeReviewPhoto"+"/"+review_id;
		
		File dir = new File(CURR_REVIEW_IMAGE_DIR);
		if(dir.exists()) {
			File filelist[] = dir.listFiles();
			if(filelist!=null) {
				for(File file:filelist) {
					file.delete();
				}
				dir.delete();
			}
		}
	}
	public void updateGoods(MultipartHttpServletRequest multipartRequest, int cafe_id, int goodsSize) throws Exception {
		int matchedGoodsInputIndex = 0;
		List<GoodsVO> prevGoodsList = goodsService.getGoods(cafe_id);
		for(int i=0; i<prevGoodsList.size(); i++) {
			boolean isPrevGoodsExists = false;
			GoodsVO prevGoods = (GoodsVO)prevGoodsList.get(i);
			int prev_goods_id = prevGoods.getGoods_id();
			for(int j=1; j<=goodsSize; j++) {
				String good_id_str= multipartRequest.getParameter("goods"+j+"_id");
				if(good_id_str!=null && !good_id_str.equals("")) {
					int goods_id = Integer.parseInt(good_id_str);
					if(prev_goods_id== goods_id) {
						isPrevGoodsExists=true;
						matchedGoodsInputIndex=j;
					}
				}
			}
			if(!isPrevGoodsExists) {
				// Delete Goods
					// Delete Goods Photo File
					deleteGoodsPhoto(cafe_id,prev_goods_id);
					// Delete Goods Photo
					goodsService.deleteGoodsPhoto(prev_goods_id);
					//Delete Goods
					goodsService.deleteGoods(prev_goods_id);
			}else {
				//update Goods
					//update Goods Info
					String newGoodsName = multipartRequest.getParameter("productName"+matchedGoodsInputIndex);
					int newGoodsPrice= Integer.parseInt(multipartRequest.getParameter("productPrice"+matchedGoodsInputIndex));
					String newGoodsDescription = multipartRequest.getParameter("productDescription"+matchedGoodsInputIndex);
					
					GoodsVO goodsToModify = new GoodsVO(prev_goods_id, newGoodsName, newGoodsPrice, newGoodsDescription);
					goodsService.modifyGoods(goodsToModify);
					
					//update Goods Photo
					String GoodsPhotoInputname = "menu"+matchedGoodsInputIndex+"_photo_file";
					MultipartFile mGoodsPhotoFile = multipartRequest.getFile(GoodsPhotoInputname);
					// if image file input size>0
					if(mGoodsPhotoFile.getSize()>0) {
						deleteGoodsPhoto(cafe_id, prev_goods_id);
						changeGoodsPhoto(multipartRequest, cafe_id, prev_goods_id, GoodsPhotoInputname);
					}
			}
			
		}
		// if new Goods, add Goods
		for(int j=1; j<=goodsSize; j++) {
			String goods_id_str= multipartRequest.getParameter("goods"+j+"_id");
			
			if(goods_id_str == null || goods_id_str.equals("")) {		
				String goodsName = multipartRequest.getParameter("productName"+j);
				int goodsPrice = Integer.parseInt(multipartRequest.getParameter("productPrice"+j));
				String goodsDescription = multipartRequest.getParameter("productDescription"+j);
				GoodsVO newGoods = new GoodsVO(goodsName, goodsPrice, goodsDescription, cafe_id);
				int newGoods_id = goodsService.registerGoods(newGoods);
				
				//add Goods Photo
				String goodsPhotoInputName= "menu"+j+"_photo_file";
				goodsPhotoUpload(multipartRequest, cafe_id, newGoods_id, goodsPhotoInputName);
			}
		}
	}
	
	public void updateGroupSeat(MultipartHttpServletRequest multipartRequest, int cafe_id, int groupSeatSize) throws Exception {
		int matchedGroupSeatInputIndex = 0;
		List<GroupSeatVO> prevGroupSeatList = groupSeatService.getGroupSeatList(cafe_id);
		for(int i=0; i<prevGroupSeatList.size(); i++) {
			boolean isPrevGroupSeatExists = false;
			GroupSeatVO prevGroupSeat = (GroupSeatVO)prevGroupSeatList.get(i);
			int prev_groupSeat_id = prevGroupSeat.getGroupseat_id();
			for(int j=1; j<=groupSeatSize; j++) {
				String groupSeat_id_str= multipartRequest.getParameter("groupSeat"+j+"_id");
				if(groupSeat_id_str!=null && !groupSeat_id_str.equals("")) {
					int groupSeat_id = Integer.parseInt(groupSeat_id_str);
					if(prev_groupSeat_id== groupSeat_id) {
						isPrevGroupSeatExists=true;
						matchedGroupSeatInputIndex=j;
					}
				}
			}
			if(!isPrevGroupSeatExists) {
				// Delete Goods
					// Delete GroupSeat Photo File
					deleteGroupSeatPhoto(cafe_id,prev_groupSeat_id);
					// Delete GroupSeat Photo
					groupSeatService.deleteGroupSeatPhoto(prev_groupSeat_id);
					//Delete GroupSeat
					groupSeatService.deleteGroupSeat(prev_groupSeat_id);
			}else {
				//update GroupSeat
					//update GroupSeat Info
					String newGroupSeatName = multipartRequest.getParameter("groupSeatName"+matchedGroupSeatInputIndex);
					int newGroupSeatPrice= Integer.parseInt(multipartRequest.getParameter("groupSeatPrice"+matchedGroupSeatInputIndex));
					String newGroupSeatDescription = multipartRequest.getParameter("groupSeatDescription"+matchedGroupSeatInputIndex);
					
					GroupSeatVO groupSeatToModify = new GroupSeatVO(prev_groupSeat_id, newGroupSeatName, newGroupSeatPrice, newGroupSeatDescription);
					groupSeatService.modifyGroupSeat(groupSeatToModify);
					
					//update GroupSeat Photo
					String groupSeatPhotoInputname = "groupSeat"+matchedGroupSeatInputIndex+"_photo_file_input";
					MultipartFile mGroupSeatPhotoFile = multipartRequest.getFile(groupSeatPhotoInputname);
					// if image file input size>0
					if(mGroupSeatPhotoFile.getSize()>0) {
						deleteGroupSeatPhoto(cafe_id, prev_groupSeat_id);
						changeGroupSeatPhoto(multipartRequest, cafe_id, prev_groupSeat_id, groupSeatPhotoInputname);
					}
			}
			
		}
		// if new GroupSeat, add GroupSeat
		for(int j=1; j<=groupSeatSize; j++) {
			String groupSeat_id_str= multipartRequest.getParameter("groupSeat"+j+"_id");
			
			if(groupSeat_id_str == null || groupSeat_id_str.equals("")) {		
				String groupSeatName = multipartRequest.getParameter("groupSeatName"+j);
				int groupSeatPrice = Integer.parseInt(multipartRequest.getParameter("groupSeatPrice"+j));
				String groupSeatDescription = multipartRequest.getParameter("groupSeatDescription"+j);
				GroupSeatVO newGroupSeat = new GroupSeatVO(groupSeatName, groupSeatPrice, groupSeatDescription, cafe_id);
				int newGroupSeat_id = groupSeatService.registerGroupSeat(newGroupSeat);
				
				//add GroupSeat Photo
				String groupSeatPhotoInputName= "groupSeat"+j+"_photo_file_input";
				groupSeatPhotoUpload(multipartRequest, cafe_id, newGroupSeat_id, groupSeatPhotoInputName);
			}
		}
	}
	
	public void updateCafePhoto(MultipartHttpServletRequest multipartRequest, int cafe_id, int cafePhotoSize) throws Exception {
		int matchedCafePhotoInputIndex = 0;
		List<CafePhotoVO> prevCafePhotoList = cafePhotoService.getCafePhoto(cafe_id);
		
		for(int i=0; i<prevCafePhotoList.size(); i++) {
			boolean isPrevCafePhotoExists = false;
			CafePhotoVO prevCafePhoto = (CafePhotoVO)prevCafePhotoList.get(i);
			int prev_cafePhoto_id = prevCafePhoto.getPhoto_id();
			for(int j=1; j<=cafePhotoSize; j++) {
				String cafePhoto_id_str= multipartRequest.getParameter("cafePhoto"+j+"_id");
				if(cafePhoto_id_str!=null && !cafePhoto_id_str.equals("")) {
					int cafePhoto_id = Integer.parseInt(cafePhoto_id_str);
					if(prev_cafePhoto_id== cafePhoto_id) {
						isPrevCafePhotoExists=true;
						matchedCafePhotoInputIndex=j;
					}
				}
			}
			if(!isPrevCafePhotoExists) {
				logger.debug("[@CafeControllerImpl, updateCafePhoto] delete Cafe Photo entered");
				// Delete Cafe Photo File
				deleteCafePhoto(cafe_id, prev_cafePhoto_id);
				// Delete Cafe Photo
				cafePhotoService.deleteCafePhoto(prev_cafePhoto_id);
			}else {
				logger.debug("[@CafeControllerImpl, updateCafePhoto] update Cafe Photo entered");
				//update Cafe Photo
				String cafePhotoInputname = "cafe"+matchedCafePhotoInputIndex+"_photo_file_input";
				logger.debug("[@CafeControllerImpl, updateCafePhoto] cafePhotoInputname: "+cafePhotoInputname);
				MultipartFile mCafePhotoFile = multipartRequest.getFile(cafePhotoInputname);
				// if image file input size>0
				if(mCafePhotoFile.getSize()>0) {
					deleteCafePhoto(cafe_id, prev_cafePhoto_id);
					changeCafePhoto(multipartRequest, cafe_id, prev_cafePhoto_id, cafePhotoInputname);
				}
			}
			
		}
		// if new Cafe Photo, add Cafe Photo
		for(int j=1; j<=cafePhotoSize; j++) {
			String cafePhoto_id_str= multipartRequest.getParameter("cafePhoto"+j+"_id");
			
			if(cafePhoto_id_str == null || cafePhoto_id_str.equals("")) {					
				//add Cafe Photo
				String groupSeatPhotoInputName= "cafe"+j+"_photo_file_input";
				cafePhotoUpload(multipartRequest, cafe_id, groupSeatPhotoInputName);
			}
		}
	}
	
	public void updateParkingLot(MultipartHttpServletRequest multipartRequest, int cafe_id, int parkingLotSize) throws Exception {
		int matchedParkingLotInputIndex = 0;
		List<ParkingLotVO> prevParkingLotList = cafeService.selectParkingLot(cafe_id);
		for(int i=0; i<prevParkingLotList.size(); i++) {
			boolean isPrevParkingLotExists = false;
			ParkingLotVO prevParkingLot = (ParkingLotVO)prevParkingLotList.get(i);
			int prev_parkingLot_id = prevParkingLot.getParking_lot_id();
			for(int j=1; j<=parkingLotSize; j++) {
				String parkingLot_id_str= multipartRequest.getParameter("parkingLot"+j+"_id");
				if(parkingLot_id_str!=null && !parkingLot_id_str.equals("")) {
					int parkingLot_id = Integer.parseInt(parkingLot_id_str);
					if(prev_parkingLot_id== parkingLot_id) {
						isPrevParkingLotExists=true;
						matchedParkingLotInputIndex=j;
					}
				}
			}
			if(!isPrevParkingLotExists) {
				// Delete parkingLot
					//Delete parkingLot
					cafeService.deleteParkingLot(prev_parkingLot_id);
			}else {
				//update parkingLot
					//update parkingLot Info
					String newParkingLotName = multipartRequest.getParameter("parkingLot"+matchedParkingLotInputIndex+"_name");
					String newParkingLotLocation1 = multipartRequest.getParameter("parkingLot"+matchedParkingLotInputIndex+"_location1");
					String newParkingLotLocation2 = multipartRequest.getParameter("parkingLot"+matchedParkingLotInputIndex+"_location2");
					
					ParkingLotVO parkingLotToModify = new ParkingLotVO(prev_parkingLot_id, newParkingLotName, newParkingLotLocation1, newParkingLotLocation2);
					cafeService.modifyParkingLot(parkingLotToModify);
			}
			
		}
		// if new parkingLot, add parkingLot
		for(int j=1; j<=parkingLotSize; j++) {
			String goods_id_str= multipartRequest.getParameter("parkingLot"+j+"_id");
			
			if(goods_id_str == null || goods_id_str.equals("")) {		
				String newParkingLotName = multipartRequest.getParameter("parkingLot"+j+"_name");
				String newParkingLotLocation1 = multipartRequest.getParameter("parkingLot"+j+"_location1");
				String newParkingLotLocation2 = multipartRequest.getParameter("parkingLot"+j+"_location2");
				ParkingLotVO newParkingLot = new ParkingLotVO(newParkingLotName, newParkingLotLocation1, newParkingLotLocation2, cafe_id);
				
				cafeService.registerParkingLot(newParkingLot);
			}
		}
	}
}


	