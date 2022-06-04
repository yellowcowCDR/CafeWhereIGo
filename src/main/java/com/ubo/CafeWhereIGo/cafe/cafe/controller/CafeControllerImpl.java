package com.ubo.CafeWhereIGo.cafe.cafe.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.StringTokenizer;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.MultipartRequest;
import org.springframework.web.servlet.ModelAndView;

import com.ubo.CafeWhereIGo.cafe.cafe.service.CafeService;
import com.ubo.CafeWhereIGo.cafe.cafe.vo.CafeSearchResultVO;
import com.ubo.CafeWhereIGo.cafe.cafe.vo.CafeVO;
import com.ubo.CafeWhereIGo.cafe.cafePhoto.service.CafePhotoServiceImpl;
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
import com.ubo.CafeWhereIGo.cafeHomeArticle.vo.CafeHomeArticleVO;
import com.ubo.CafeWhereIGo.likedcafe.vo.LikedCafeVO;
import com.ubo.CafeWhereIGo.user.vo.UserVO;

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
	CafePhotoServiceImpl cafePhotoService;
	
	@Override
	@RequestMapping(value= "/cafe/search.do" ,method={RequestMethod.POST,RequestMethod.GET})
	public ModelAndView search(HttpServletRequest request, HttpServletResponse response) throws Exception{
		
		List<CafeSearchResultVO> cafeSearchResultList = cafeService.getCafeList();
		
		
		ModelAndView mav=new ModelAndView();
		String viewName = "/cafe/search";
		mav.setViewName(viewName);
		mav.addObject("cafeList",cafeSearchResultList);
		
		return mav;
	}
	
	@Override
	@RequestMapping(value="/cafe/cafe_detail.do" ,method={RequestMethod.POST,RequestMethod.GET})
	public ModelAndView detail(@RequestParam("cafe_id") int cafe_id,HttpServletRequest request, HttpServletResponse response) throws Exception{
		CafeVO cafe = cafeService.getCafeDetail(cafe_id);
		CafeHomeArticleVO homeArticle = cafeService.selectHomeArticle(cafe_id);
		String[] homeArticleLines =homeArticle.getArticle_content().split("\r\n");
		List<GoodsVO> goodsList = goodsService.getGoods(cafe_id);
		List<GroupSeatVO> groupSeatList = groupSeatService.getGroupSeatList(cafe_id);
		
		ModelAndView mav=new ModelAndView();
		String viewName = "/cafe/cafe_detail";
		mav.setViewName(viewName);
		mav.addObject("cafeInfo", cafe);
		mav.addObject("cafeHomeArticle", homeArticleLines);
		mav.addObject("goodsList", goodsList);
		mav.addObject("groupSeatList", groupSeatList);
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
	public ModelAndView modifyCafe(MultipartRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
	

	@Override
	@RequestMapping(value="/cafe/shutdownCafe.do" ,method={RequestMethod.POST,RequestMethod.GET})
	public ModelAndView shutdownCafe(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@RequestMapping(value="/cafe/addReview.do" ,method={RequestMethod.POST,RequestMethod.GET})
	public ModelAndView addReview(MultipartRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@RequestMapping(value="/cafe/modifyReview.do" ,method={RequestMethod.POST,RequestMethod.GET})
	public ModelAndView modifyReview(MultipartRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@RequestMapping(value="/cafe/deleteReview.do" ,method={RequestMethod.POST,RequestMethod.GET})
	public ModelAndView deleteReview(MultipartRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@RequestMapping(value="/cafe/showReview.do" ,method={RequestMethod.POST,RequestMethod.GET})
	public ModelAndView showReview(MultipartRequest request, HttpServletResponse response) throws Exception {
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
		final String CURR_GOODS_IMAGE_DIR = CURR_IMAGE_REPO_PATH+"/"+cafe_id+"/groupSeat";
		for(int i=0; i<imageFileInfoList.size(); i++) {
			GroupSeatPhotoInfoVO filenameInfo = (GroupSeatPhotoInfoVO) imageFileInfoList.get(i);
			int groupSeat_id = filenameInfo.getGroupSeat_id();
			String filename = filenameInfo.getFilename();
			String OrgFilename = filenameInfo.getOrgFilename();
			MultipartFile mFile = multipartRequest.getFile(filename);
			if(!OrgFilename.equals("") || OrgFilename!=null) {
				String IMG_PATH=CURR_GOODS_IMAGE_DIR+"/"+groupSeat_id+"/"+OrgFilename;
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
	private void cafePhotoUpload(MultipartHttpServletRequest multipartRequest, int cafe_id, int photoSize) throws IllegalStateException, IOException {
		final String CURR_GOODS_IMAGE_DIR = CURR_IMAGE_REPO_PATH+"/"+cafe_id+"/cafePhoto";
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
		if(imageFile != null) {
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
		File imageDir=new File(filePath);
		
		GoodsPhotoVO goodsPhoto = (GoodsPhotoVO)goodsService.getGoodsPhoto(goods_id);
		String imageFileName = goodsPhoto.getFilename();
		File imageFile = new File(filePath+"/"+imageFileName);
		logger.debug("imageFileName: "+imageFileName);
		if(imageFile != null) {
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
		if(imageFile != null) {
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
}
