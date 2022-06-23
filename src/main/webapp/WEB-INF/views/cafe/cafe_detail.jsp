<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    isELIgnored="false"  
%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="contextPath"  value="${pageContext.request.contextPath}"  />
<c:set var="user_id"  value="${loginSession.user_id}"  />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>카페어디가-카페상세</title>
<link href="${contextPath}/resources/css/commons/starRatings.css" rel="stylesheet">
<link href="${contextPath}/resources/css/cafe/detail.css" rel="stylesheet">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=6ee71689aaa8aa4f420e61071a31891c&libraries=services"></script>
<script type="text/javascript" src="${contextPath}/resources/js/cafe/detail.js"></script>
<script type="text/javascript" src="${contextPath}/resources/js/cart/addCart.js"></script>
<script type="text/javascript" src="${contextPath}/resources/js/order/addOrder.js"></script>
<script type="text/javascript" src="${contextPath}/resources/js/cafe/cafeReview.js"></script>

<style>
	
</style>
<script>
	<c:if test="${loginSession == null }">
		var isWished=false;
	</c:if>
	<c:if test="${loginSession != null }">
		var isWished=${isLikeCafe};
	</c:if>
	
	let parkingLogNameList=[
	    <c:forEach var="parkingLot" items="${parkingLotList}">
	        '${parkingLot.parking_lot_name}',
	    </c:forEach>
	];

	let addrList =[
	    <c:forEach var="parkingLot" items="${parkingLotList}">
	        '${parkingLot.parking_lot_location1}',
	    </c:forEach>
	];
	
	
	function onWishClicked(){
		var wishicon = document.getElementById("wish_icon");
		if(!isWished){
			wishicon.src="${contextPath}/resources/image/heart_red.svg";
			isWished=true;
		}else{
			wishicon.src="${contextPath}/resources/image/heart_empty.svg";
			isWished=false;
		}
		toggleLikeCafe("${contextPath}",${cafeInfo.cafe_id});
	}
	$(document).ready(function(){
		$('ul.tabs li').click(function(){
		     var tab_id = $(this).attr('data-tab');// Tab ID를 가져온다
		
		     $('ul.tabs li').removeClass('current'); //커서 삭제
		     $('.tab-content').removeClass('current');//커서 삭제
		
		     $(this).addClass('current');//커서 등록
		     $("#"+tab_id).addClass('current');//커서 등록
		     if(tab_id=="tab-6"){
		    	parkinglot_tab_ciliked();
		     }
		})
	})
</script>
</head>
<body>
	<section id="mainContainer">
		 <div id="mainWrapper">
		 	<div id="cafeinfoWrapper">
		 		<div id="mainphotoWrapper">
		 			<%-- <img id="mainImage" class="img_scaleDown" src="${contextPath}/resources/image/cafeImage/cafe1.jpg"> --%>
		 			<img id="mainImage" class="img_scaleDown" src="${contextPath}/cafe/downloadCafeMainImage.do?cafe_id=${cafeInfo.cafe_id}">
		 		</div>
		 		<div id="infowapper">
		 				<input type="hidden" name="cafe_id" value="${cafeInfo.cafe_id}">
	 					<h1 class="cafe_name">${cafeInfo.cafe_name}</h1>
	 					<p>${cafeInfo.open_time}~${cafeInfo.close_time}</p>
 						<p>${cafeInfo.cafe_location1}</p>
 						<p>${cafeInfo.cafe_location2}</p>
 						
 						<p>Tel. ${cafeInfo.phonenum1}-${cafeInfo.phonenum2}-${cafeInfo.phonenum3}</p>
 						
 						<div style="display:flex;">
								<img class="theme_score_icon" src="${contextPath}/resources/image/coffee_icon.svg"><p class="icon_text">${themeScoreMap.coffeeScore}</p>
								<img class="theme_score_icon" src="${contextPath}/resources/image/drink_icon.svg"><p class="icon_text">${themeScoreMap.drinkScore}</p>
								<img class="theme_score_icon" src="${contextPath}/resources/image/dessert_icon.svg"><p class="icon_text">${themeScoreMap.dessertScore}</p>
								<img class="theme_score_icon" src="${contextPath}/resources/image/scenery_icon.svg"><p class="icon_text">${themeScoreMap.viewScore}</p>
								<img class="theme_score_icon" src="${contextPath}/resources/image/atmosphere_icon.svg"><p class="icon_text">${themeScoreMap.moodScore}</p>
								<img class="theme_score_icon" src="${contextPath}/resources/image/mute_icon.svg"><p class="icon_text">${themeScoreMap.quietScore}</p>
						</div>
 						<div style="display:flex;">
 							<c:if test="${facilityInfo != null}">
	 							<img class="facility_icon" src="${contextPath}/resources/image/parking_icon.svg">
	 							<c:if test="${facilityInfo.parking_lot == true}">
	 								<p class="icon_text">있음</p>
	 							</c:if>
	 							<c:if test="${facilityInfo.parking_lot == false}">
	 								<p class="icon_text">없음</p>
	 							</c:if>
 							
								<img class="facility_icon" src="${contextPath}/resources/image/socket_icon.svg">
								<c:if test="${facilityInfo.power_plug == true}">
	 								<p class="icon_text">있음</p>
	 							</c:if>
								<c:if test="${facilityInfo.power_plug == false}">
	 								<p class="icon_text">없음</p>
	 							</c:if>
								
								<img class="facility_icon" src="${contextPath}/resources/image/wifi_icon.svg">
								<c:if test="${facilityInfo.wifi == true}">
	 								<p class="icon_text">있음</p>
	 							</c:if>
								<c:if test="${facilityInfo.wifi == false}">
	 								<p class="icon_text">없음</p>
	 							</c:if>
 							</c:if>
 							<c:if test="${facilityInfo == null}"> 
 								<img class="facility_icon" src="${contextPath}/resources/image/parking_icon.svg">
	 							<p class="icon_text">없음</p>
	 						
								<img class="facility_icon" src="${contextPath}/resources/image/socket_icon.svg">
								<p class="icon_text">없음</p>
	 							
								<img class="facility_icon" src="${contextPath}/resources/image/wifi_icon.svg">
								<p class="icon_text">없음</p>
 							</c:if>
 						</div>
 						<div>
 						</div>
	 					<a id="wish_wrapper_link" href="javascript:onWishClicked()">
		 					<div id="wish_wrapper">
		 						<c:if test="${loginSession == null }">
	 								<img id="wish_icon" src="${contextPath}/resources/image/heart_empty.svg">
	 							</c:if>
	 							<c:if test="${loginSession != null }">
	 								<c:if test="${isLikeCafe == true }">
	 									<img id="wish_icon" src="${contextPath}/resources/image/heart_red.svg">
	 								</c:if>
	 								<c:if test="${isLikeCafe == false }">
	 									<img id="wish_icon" src="${contextPath}/resources/image/heart_empty.svg">
	 								</c:if>
	 								
	 							</c:if>
	 							<p style="color: black; margin-left:2px;">찜하기</p>
		 					</div>
	 					</a>
		 		</div>
		 	</div>
		 	<div class="container">
				<ul class="tabs">
				    <li class="tab-link tab-menu-font current" data-tab="tab-1">홈</li>
				    <li class="tab-link tab-menu-font" data-tab="tab-2">메뉴</li>
				    <li class="tab-link tab-menu-font" data-tab="tab-3">단체석예약</li>
				    <li class="tab-link tab-menu-font" data-tab="tab-4">리뷰</li>
				    <li class="tab-link tab-menu-font" data-tab="tab-5">사진</li>
				    <li class="tab-link tab-menu-font" data-tab="tab-6">주차장정보</li>
				</ul>
				
				<div id="tab-1" class="tab-content scrollable current">
					<c:forEach var="article" items="${cafeHomeArticle}">
						<p class="no-top_bottom_margin">${article}</p>
					</c:forEach>
				</div>
				<div id="tab-2" class="tab-content scrollable">
					<table width="100%">
						<c:forEach var='goods' items="${goodsList}" varStatus="status">
							<c:if test="${status.index>0}">	
								<tr>
									<td colspan="100">
										<hr class="productrow_under_line">
									</td>
								</tr>
							</c:if>
							<tr id="goodsRow">
								<td width="80px">
									<%-- <img class="product_image" src="${contextPath}/resources/image/americano.jpeg"> --%>
									<input type="hidden" name="goods_id" value="${goods.goods_id}">
									<img class="product_image" src="${contextPath}/cafe/downloadGoodsPhoto.do?cafe_id=${cafeInfo.cafe_id}&goods_id=${goods.goods_id}">
								</td>
								<td width="500px">
									<div>
										<h3 class="productName no-top_bottom_margin margin-left-10px">${goods.goods_name}</h3>
										<p class="productDescription no-top_bottom_margin margin-left-10px">${goods.description}</p>
									</div>
									
									
								</td>
								<td>
									<div style="display:flex; align-items:center;">
										<p class="no-top_bottom_margin margin-right-5px">Take-Out</p>
										<input type="checkbox" id="checker" class="margin-right-10px" name="is_takeout" value="y"/>
									</div>
								</td>
								<td width="70px">
									<p class="no-top_bottom_margin">${goods.price}원</p>
									<input type='hidden' name='unitPrice' value='${goods.price}'>
								</td>
								<td width="45px"><p class="no-top_bottom_margin">수량</p></td>
								<td style="width:70px;">
									<input style="width:100%;" class="numberInput" type="number" name="quantity" min=0 value=0 onchange="setGoodsTotalPriceCafeDatail(this.parentNode.parentNode)">
								</td>
								<td width="90px">
									<p class="price-text no-top_bottom_margin">총 0원</p>
									<input type='hidden' name="goods_unit_totalPrice" value="0">
								</td>
								<td width="28px"><input type="button" class="cartAddButton" onclick="addGoodsCart('${contextPath}',this.parentNode.parentNode)" value="담기"></td>
								<td width="28px"><input type="button" class="orderAddButton" value="주문" onclick="sendSingleGoodsOrderToOrderForm('${contextPath}',this.parentNode.parentNode)"></td>
							</tr>
							<c:if test="${goodsList.size()==1}">
								<tr>
									<td colspan="100">
										<hr class="productrow_under_line">
									</td>
								</tr>
							</c:if>			
						</c:forEach>
					</table>
				</div>
				<div id="tab-3" class="tab-content scrollable">
					<table width="100%">
						<c:forEach var="groupSeat" items="${groupSeatList}" varStatus="status">
							<c:if test="${status.index>0}">	
								<tr>
									<td colspan="100">
										<hr class="productrow_under_line">
									</td>
								</tr>
							</c:if>
							<tr>
							<td width="80px">
								<input type="hidden" name="seat_id" value="${groupSeat.groupseat_id}">
								<img class="product_image" src="${contextPath}/cafe/downloadGroupSeatPhoto.do?cafe_id=${cafeInfo.cafe_id}&groupSeat_id=${groupSeat.groupseat_id}">
							</td>
							<td width="480px">
								<div>
									<h3 class="productName no-top_bottom_margin margin-left-10px">${groupSeat.seat_name}</h3>
								</div>
							</td>
							<td width="70px">
								<p class="no-top_bottom_margin">${groupSeat.price}원(1H)</p>
								<input type="hidden" name="unitPrice" value="${groupSeat.price}">
							</td>
							<td>
								<table>
									<tr>
										<td>날짜</td>
										<td><input type="date" name="reservation_date" onchange="setGroupSeatTotalPriceCafeDatail(this.parentNode.parentNode.parentNode.parentNode.parentNode.parentNode)"></td>
									</tr>
									<tr>
										<td>시작시간</td>
										<td><input type="time" name="start_time" onchange="setGroupSeatTotalPriceCafeDatail(this.parentNode.parentNode.parentNode.parentNode.parentNode.parentNode)"></td>
									</tr>
									<tr>
										<td>종료시간</td>
										<td><input type="time" name="end_time" onchange="setGroupSeatTotalPriceCafeDatail(this.parentNode.parentNode.parentNode.parentNode.parentNode.parentNode)"></td>
									</tr>
								</table>
							</td>
							<td width="90px">
								<p class="price-text no-top_bottom_margin">총 0원</p>
								<input type="hidden" name="groupSeat_unit_totalPrice">
							</td>
							<td width="28px"><input type="button" class="cartAddButton" onclick="addGroupSeatCart('${contextPath}',this.parentNode.parentNode)" value="담기"></td>
							<td width="28px"><input type="button" class="orderAddButton" value="주문" onclick="sendSingleGroupSeatOrderToOrderForm('${contextPath}',this.parentNode.parentNode)"></td>
							
						</tr>
						
						</c:forEach>
						<c:if test="${groupSeatList.size()==1}">
							<tr>
								<td colspan="100">
									<hr class="productrow_under_line">
								</td>
							</tr>
						</c:if>	
					</table>
				</div>
				<div id="tab-4" class="tab-content">
					<div class="scrollable" style="height:230px;">
						<table>
							<c:forEach var="cafeReviewMap" items="${reviewMapList}" varStatus="status">
								<c:if test="${status.index != 0}">
									<tr><td colspan="100"><hr class="productrow_under_line"></td></tr>
								</c:if>
								<tr>
								<td width="80px">
									<img class="product_image" src="${contextPath}/cafe/downloadCafeReviewImage.do?cafe_id=${cafeInfo.cafe_id}&review_id=${cafeReviewMap.cafeReview.review_id}" onerror="this.src='${contextPath}/resources/image/cafe1.svg'">
									<input type="hidden" name="order_id" value="${cafeReviewMap.cafeReview.orderAndReservation_OrderAndReservation_id}">
									<input type="hidden" name="review_id" value="${cafeReviewMap.cafeReview.review_id}">
									<input type="hidden" name="imageFilename" value="${cafeReviewMap.cafeReviewPhoto.filename}">
								</td>
								<td width="900px" class="reply-content-td">
									<c:forEach var="review_content" items="${cafeReviewMap.cafeReview.review_content_list}">
										<p class="productDescription no-top_bottom_margin">
											${review_content}
										</p>
									</c:forEach>
									
									<input type="hidden" name="productDescription" value="${cafeReviewMap.cafeReview.review_content}">
									
									<input type="hidden" name="coffeeScore" value="${cafeReviewMap.themeScore.coffee_score}">
									<input type="hidden" name="drinkScore" value="${cafeReviewMap.themeScore.drink_score}">
									<input type="hidden" name="dessertScore" value="${cafeReviewMap.themeScore.dessert_score}">
									<input type="hidden" name="viewScore" value="${cafeReviewMap.themeScore.view_score}">
									<input type="hidden" name="moodScore" value="${cafeReviewMap.themeScore.mood_score}">
									<input type="hidden" name="quietScore" value="${cafeReviewMap.themeScore.quiet_score}">
								</td>
								
								<td width="100px">
									<p class="productDescription no-top_bottom_margin margin-left-10px margin-right-10px">
										${cafeReviewMap.cafeReview.user_user_id}
									</p>
								</td>
								<td width="28px"><input type="button" class="cartAddButton" onclick="changeToReviewModifyForm('${contextPath}', this.parentNode.parentNode)" value="수정"></td>
								<td width="28px"><input type="button" class="cancelButton" onclick="deleteReiview('${contextPath}', ${cafeReviewMap.cafeReview.review_id}, '${loginSession.user_id}', '${cafeReviewMap.cafeReview.user_user_id}')" value="삭제"></td>
							</tr>
							</c:forEach>
						</table>
					</div>
					<div class="bottom-content-wrapper">
          				<table>
          					<tr>
          						<td>
          							<div style="display:flex; justify-content: flex-start; align-items:center;">
          								<p class="productDescription margin-right-10px no-top_bottom_margin">리뷰상품선택</p>
	          							<input type="hidden" id="review_id_for_modify">
	          							<select id="orderHistory" name="orderHistory">
	          								<c:if test="${orderHistoryMapList!=null and orderHistoryMapList.size()>0}">
	          									
		          								<c:forEach var="orderHistoryMap" items="${orderHistoryMapList}">
		          									<option value="${orderHistoryMap.order_id}">
		          										${orderHistoryMap.representedOrderName}(<fmt:formatDate pattern="yy.MM.dd" value="${orderHistoryMap.orderDate}"/>)
	          										</option>
		          								</c:forEach>
	          								</c:if>
	          								<c:if test="${orderHistoryMapList==null or orderHistoryMapList.size()<=0}">
	          								<option value="-1">리뷰할상품없음</option>
	          								</c:if>
	          							</select>
	          							<p class="productDescription margin-left-30px margin-right-10px no-top_bottom_margin">카페점수</p>
	          							<p class="no-top_bottom_margin">커피</p>
	          							<!-- <input type="number" name="coffee_score" class="score_inputbox" min=0 max=100 value=0 onchange="cafeScoreInputValidation(this)"> -->
	          							<div class="rate">
										    <input type="radio" id="coffeeStar5" name="coffeeRate" value="5" />
										    <label for="coffeeStar5" title="5점">5 stars</label>
										    <input type="radio" id="coffeeStar4" name="coffeeRate" value="4" />
										    <label for="coffeeStar4" title="4점">4 stars</label>
										    <input type="radio" id="coffeeStar3" name="coffeeRate" value="3" />
										    <label for="coffeeStar3" title="3점">3 stars</label>
										    <input type="radio" id="coffeeStar2" name="coffeeRate" value="2" />
										    <label for="coffeeStar2" title="2점">2 stars</label>
										    <input type="radio" id="coffeeStar1" name="coffeeRate" value="1" />
										    <label for="coffeeStar1" title="1점">1 star</label>
										</div>
										  <p class="no-top_bottom_margin margin-left-10pxquiet">음료</p>
										  <!-- <input type="number" name="drink_score" class="score_inputbox" min=0 max=100 value=0 onchange="cafeScoreInputValidation(this)"> -->
										  <div class="rate">
										    <input type="radio" id="drinkStar5" name="drinkRate" value="5" />
										    <label for="drinkStar5" title="5점">5 stars</label>
										    <input type="radio" id="drinkStar4" name="drinkRate" value="4" />
										    <label for="drinkStar4" title="4점">4 stars</label>
										    <input type="radio" id="drinkStar3" name="drinkRate" value="3" />
										    <label for="drinkStar3" title="3점">3 stars</label>
										    <input type="radio" id="drinkStar2" name="drinkRate" value="2" />
										    <label for="drinkStar2" title="2점">2 stars</label>
										    <input type="radio" id="drinkStar1" name="drinkRate" value="1" />
										    <label for="drinkStar1" title="1점">1 star</label>
										</div>
										  <p class="no-top_bottom_margin margin-left-10pxquiet">디저트</p>
										  <!-- <input type="number" name="dessert_score" class="score_inputbox" min=0 max=100 value=0 onchange="cafeScoreInputValidation(this)"> -->
										  <div class="rate">
										    <input type="radio" id="dessertStar5" name="dessertRate" value="5" />
										    <label for="dessertStar5" title="5점">5 stars</label>
										    <input type="radio" id="dessertStar4" name="dessertRate" value="4" />
										    <label for="dessertStar4" title="4점">4 stars</label>
										    <input type="radio" id="dessertStar3" name="dessertRate" value="3" />
										    <label for="dessertStar3" title="3점">3 stars</label>
										    <input type="radio" id="dessertStar2" name="dessertRate" value="2" />
										    <label for="dessertStar2" title="2점">2 stars</label>
										    <input type="radio" id="dessertStar1" name="dessertRate" value="1" />
										    <label for="dessertStar1" title="1점">1 star</label>
										</div>
										  <p class="no-top_bottom_margin margin-left-10pxquiet">뷰</p>
										  <!-- <input type="number" name="scenery_score" class="score_inputbox" min=0 max=100 value=0 onchange="cafeScoreInputValidation(this)"> -->
										  <div class="rate">
										    <input type="radio" id="viewStar5" name="viewRate" value="5" />
										    <label for="viewStar5" title="5점">5 stars</label>
										    <input type="radio" id="viewStar4" name="viewRate" value="4" />
										    <label for="viewStar4" title="4점">4 stars</label>
										    <input type="radio" id="viewStar3" name="viewRate" value="3" />
										    <label for="viewStar3" title="3점">3 stars</label>
										    <input type="radio" id="viewStar2" name="viewRate" value="2" />
										    <label for="viewStar2" title="2점">2 stars</label>
										    <input type="radio" id="viewStar1" name="viewRate" value="1" />
										    <label for="viewStar1" title="1점">1 star</label>
										</div>
										  <p class="no-top_bottom_margin margin-left-10pxquiet">분위기</p>
										  <!-- <input type="number" name="mood_score" class="score_inputbox" min=0 max=100 value=0 onchange="cafeScoreInputValidation(this)"> -->
										  <div class="rate">
										    <input type="radio" id="moodStar5" name="moodRate" value="5" />
										    <label for="moodStar5" title="5점">5 stars</label>
										    <input type="radio" id="moodStar4" name="moodRate" value="4" />
										    <label for="moodStar4" title="4점">4 stars</label>
										    <input type="radio" id="moodStar3" name="moodRate" value="3" />
										    <label for="moodStar3" title="3점">3 stars</label>
										    <input type="radio" id="moodStar2" name="moodRate" value="2" />
										    <label for="moodStar2" title="2점">2 stars</label>
										    <input type="radio" id="moodStar1" name="moodRate" value="1" />
										    <label for="moodStar1" title="1점">1 star</label>
										</div>
										  <p class="no-top_bottom_margin margin-left-10pxquiet">조용함</p>
										  <!-- <input type="number" name="mute_score" class="score_inputbox" min=0 max=100 value=0 onchange="cafeScoreInputValidation(this)"> -->
										  <div class="rate">
										    <input type="radio" id="quietStar5" name="quietRate" value="5" />
										    <label for="quietStar5" title="5점">5 stars</label>
										    <input type="radio" id="quietStar4" name="quietRate" value="4" />
										    <label for="quietStar4" title="4점">4 stars</label>
										    <input type="radio" id="quietStar3" name="quietRate" value="3" />
										    <label for="quietStar3" title="3점">3 stars</label>
										    <input type="radio" id="quietStar2" name="quietRate" value="2" />
										    <label for="quietStar2" title="2점">2 stars</label>
										    <input type="radio" id="quietStar1" name="quietRate" value="1" />
										    <label for="quietStar1" title="1점">1 star</label>
										</div>
	          							
          							</div>
          						</td>
          						<td></td>
          					</tr>
          					<tr>
          						<td class=""><textarea id="review_content" name="review_content" style="width:1065px; height:100px;"></textarea></td>
          						<td id="reviewWriteButtonTd" class="vertical-align-top"><button style="width: 97px;height:100px;margin-left: 10px;" onclick="addReview('${contextPath}')">글쓰기</button></td>
          					</tr>
          					<tr>
          						<td style="text-align:end;"><p id="reviewPhotoIndicator" class="reviewPhotoIndicator"></p></td>
          						<td id="reviewPhotoSelectTd"><button class="reviewPhotoSelectButton" onclick="showFileSelectWindow()">사진첨부</button></td>
          						
          					</tr>
          					<tr>
          						<td class="vertical-align-center" colspan="2">
          							<input type="file" id="review_photo" name="review_photo" onchange="setFilenameIndicator(this.value)" value="사진첨부" accept=".gif, .jpg, .png">
          							<input type="hidden" id="review_photo_filename" name="review_photo_filename">
       							</td>
          					</tr>
          				</table>
          			</div>
				</div>
				<div id="tab-5" class="tab-content scrollable">
					<table align="center">
						<c:set var="NumberOfImageColumnMax" value="7"/>
						<c:set var="cafeImageIt" value="${cafePhotoMapList.iterator()}"/>
						<c:set var="numOfCafeImageRow" value="${cafePhotoMapList.size()/NumberOfImageColumnMax+1}"/>
						
						<c:forEach begin="1" end="${numOfCafeImageRow}">
							<tr>
								<c:forEach var="colIndex" begin="0" end="${NumberOfImageColumnMax-1}">
									<c:if test="${cafeImageIt.hasNext()}">
										<c:if test="${colIndex!=0}">
											<td><div class="photo_spacer"></div></td>
										</c:if>
										<td>
											<c:set var="cafePhoto" value="${cafeImageIt.next()}"/>
											<c:if test="${cafePhoto.photo_type == 'cafePhoto'}">
												<img class="cafe_photo" src="${contextPath}/cafe/downloadCafeImage.do?cafe_id=${cafePhoto.cafe_id}&photo_id=${cafePhoto.photo_id}">
											</c:if>
											
											<c:if test="${cafePhoto.photo_type == 'cafeReviewPhoto'}">
												<img class="cafe_photo" src="${contextPath}/cafe/downloadCafeReviewImage.do?cafe_id=${cafePhoto.cafe_id}&review_id=${cafePhoto.review_id}">
											</c:if>
										</td>
										
										
									</c:if>
								</c:forEach>
							</tr>
						</c:forEach>
					</table>
				</div>
          		<div id="tab-6" class="tab-content">
          			<div id="map" style="width:100%; height:100%;">
          				
          			</div>
          		</div>
          		
        	</div>
		 	<div id="cafemenuWrapper">
	 		</div>
		 </div>
	</section>
</body>
</html>