<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    isELIgnored="false"  
%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<c:set var="contextPath"  value="${pageContext.request.contextPath}"  />
<c:set var="user_id"  value="${loginSession.user_id}"  />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>카페어디가-카페상세</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=6ee71689aaa8aa4f420e61071a31891c&libraries=services"></script>
<script type="text/javascript" src="${contextPath}/resources/js/cafe/detail.js"></script>
<script type="text/javascript" src="${contextPath}/resources/js/cart/addCart.js"></script>
<script type="text/javascript" src="${contextPath}/resources/js/order/addOrder.js"></script>
<style>
	#mainContainer{
		display:flex;
		justify-content:center;
	}
	#mainWrapper{
		margin-top:50px;
		width:1200px;
	}
	#cafeinfoWrapper{
		display:flex;
		justify-content:flex-start;
	}
	#infowapper{
		display:block;
		margin-left: 10px;
	}
	#infowapper *{
		margin-bottom: 0px;
		
		
	}
	.img_scaleDown{
		object-fit: scale-down;
	}
	#mainImage{
		width:340px;
		height:300px;
	}
	#wish_wrapper{
		display: flex;
	}
	#wish_wrapper_link{
		text-decoration: none;
	}
	#wish_icon{
		height: 30px;
	}
	.cafe_name{
		font-weight:bold;
	}
	.theme_score_icon{
		height:20px;
		margin:0px;
	}
	.facility_icon{
		height:20px;
		margin:0px;
	}
	.icon_text{
		margin-right:5px;
	}
	.container{
	    width: 100%;
	    height: 500px;
	    margin: 0;
	    padding:0;
    }
    ul.tabs{
        margin: 0px;
        padding: 0px;
        list-style: none;
        background-color: #1F364B;
    }
    ul.tabs li{
        background: none;
        color: white;
        display: inline-block;
        padding: 10px 15px;
        cursor: pointer;
    }

    ul.tabs li.current{
        /* background: #ededed; */
        color: white;
        text-decoration:underline;
        text-underline-position:under;
    }
	ul.tabs li.current:text-decoration{
		color:white;
	}
    .tab-content{
    	height:430px;
        display: none;
        background: white;
        border: 1px solid #b9b9b9;

        padding: 15px;
    }

    .tab-content.current{
        display: inherit;
    }
    .tab-menu-font{
    	font-family: 'Jua', sans-serif;
		font-size:23px;
		/* font-weight:bold; */
    }
    .product_image{
		width:90px;
		height:90px;
		object-fit: scale-down;
	}
	.no-top_bottom_margin{
		margin-top:0px;
		margin-bottom:0px;
				
	}
	.productName{
		font-family: 'Jua', sans-serif;
		font-size:27px;
		font-weight:bold;
		
	}
	.productDescription{
		font-weight: bold;
	}
	.cartAddButton{
		
		background-color:#1F364B;
		font-family: 'Jua', sans-serif;
	    font-size:17px;
	    color:white;
	    border: none;
	    border-radius:5px;
	}
	.orderAddButton{
		
		background-color:#1F364B;
		font-family: 'Jua', sans-serif;
	    font-size:17px;
	    color:white;
	    border: none;
	    border-radius:5px;
	    margin-left:5px;
	    margin-right:5px;
	}
	.productrow_under_line{
		width:100%;
		color: gray;
	}
	.price-text{
		margin-left:10px;
	}
	.reply-content-td{
		vertical-align:top;
	}
	.margin-right-10px{
		margin-right:10px;
	}
	.margin-left-5px{
		margin-left:5px;
	}
	.margin-left-10px{
		margin-left:10px;
	}
	.margin-left-20px{
		margin-left:10px;
	}
	.margin-left-30px{
		margin-left:30px;
	}
	.cafe_photo{
		width:150px;
		height:150px;
		overflow:hidden;
		
	}
	.photo_spacer{
		margin-right:5px;
	}
	.scrollable{
		 overflow-y: scroll;
	}
	.vertical-align-center{
		vertical-align:center;
	}
	.margin-right-5px{
		margin-right:5px;
	}
	.takeout_check_td{
		width:100px;
	}
	.score_inputbox{
		width: 60px;
	}
</style>
<script>
	var isWished=false;
	
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
	}
	$(document).ready(function(){
		$('ul.tabs li').click(function(){
		     var tab_id = $(this).attr('data-tab');// Tab ID를 가져온다
		
		     $('ul.tabs li').removeClass('current'); //커서 삭제
		     $('.tab-content').removeClass('current');//커서 삭제
		
		     $(this).addClass('current');//커서 등록
		     $("#"+tab_id).addClass('current');//커서 등록
		     if(tab_id=="tab-6"){
		    	//parkinglot_tab_ciliked();
		     }
		})
	})
	
	
	function cafeScoreInputValidation(e){
		var value =e.value;
		if(value>100){
			alert("점수 값은 100보다 작아야 합니다.");
			e.value=100;
		}else if(value<0){
			alert("점수 값은 0보다 커야 합니다.");
			e.value=0;
		}
	}
	function cacluateGoodsTotalPrice(){
		
	}
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
								<img class="theme_score_icon" src="${contextPath}/resources/image/coffee_icon.svg"><p class="icon_text">70</p>
								<img class="theme_score_icon" src="${contextPath}/resources/image/drink_icon.svg"><p class="icon_text">70</p>
								<img class="theme_score_icon" src="${contextPath}/resources/image/dessert_icon.svg"><p class="icon_text">70</p>
								<img class="theme_score_icon" src="${contextPath}/resources/image/scenery_icon.svg"><p class="icon_text">70</p>
								<img class="theme_score_icon" src="${contextPath}/resources/image/atmosphere_icon.svg"><p class="icon_text">70</p>
								<img class="theme_score_icon" src="${contextPath}/resources/image/mute_icon.svg"><p class="icon_text">70</p>
						</div>
 						<div style="display:flex;">
 							<img class="facility_icon" src="${contextPath}/resources/image/parking_icon.svg"><p class="icon_text">있음</p>
							<img class="facility_icon" src="${contextPath}/resources/image/socket_icon.svg"><p class="icon_text">있음</p>
							<img class="facility_icon" src="${contextPath}/resources/image/wifi_icon.svg"><p class="icon_text">있음</p>
 						</div>
 						<div>
 						</div>
	 					<a id="wish_wrapper_link" href="javascript:onWishClicked()">
		 					<div id="wish_wrapper">
	 							<img id="wish_icon" src="${contextPath}/resources/image/heart_empty.svg">
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
						<tr>
							<td width="80px"><img class="product_image" src="${contextPath}/resources/image/americano.jpeg"></td>
							<td width="500px">
								<div>
									<h3 class="productName no-top_bottom_margin margin-left-10px">아메리카노(ice)</h3>
									<p class="productDescription no-top_bottom_margin margin-left-10px">아라비카산 원두로 로스팅하여 만든 아메리카노</p>
								</div>
							</td>
							<td class="takeout_check_td">
								<div style="display:flex; align-items:center;">
									<p class="no-top_bottom_margin margin-right-5px">Take-Out</p>
									<input type="checkbox" id="is_takeout" class="margin-right-10px" name="is_takeout"/>
								</div>
							</td>
							<td width="70px">
								<p class="no-top_bottom_margin">3500원</p>
								
							</td>
							<td width="45px"><p class="no-top_bottom_margin">수량</p></td>
							<td style="width:70px;">
								<input style="width:100%;" class="numberInput" type="number" min=0 value=0>
							</td>
							<td width="70px"><p class="price-text no-top_bottom_margin">3500원</p></td>
							<td width="28px"><input type="button" class="cartAddButton" value="담기"></td>
							<td width="28px"><input type="button" class="orderAddButton" value="주문"></td>
						</tr>
						<tr><td colspan="100"><hr class="productrow_under_line"></td></tr>
						<tr>
							<td width="80px"><img class="product_image" src="${contextPath}/resources/image/americano.jpeg"></td>
							<td width="500px">
								<div>
									
									<h3 class="productName no-top_bottom_margin margin-left-10px">아메리카노(ice)</h3>
									<p class="productDescription no-top_bottom_margin margin-left-10px">아라비카산 원두로 로스팅하여 만든 아메리카노</p>
								</div>
							</td>
							<td>
								<div style="display:flex; align-items:center;">
									<p class="no-top_bottom_margin margin-right-5px">Take-Out</p>
									<input type="checkbox" class="margin-right-10px" name="is_takeout"/>
								</div>
							</td>
							<td width="70px"><p class="no-top_bottom_margin">3500원</p></td>
							<td width="45px"><p class="no-top_bottom_margin">수량</p></td>
							<td style="width:70px;">
								<input style="width:100%;" class="numberInput" type="number" min=0 value=0>
							</td>
							<td width="70px"><p class="price-text no-top_bottom_margin">3500원</p></td>
							<td width="28px"><input type="button" class="cartAddButton" value="담기"></td>
							<td width="28px"><input type="button" class="orderAddButton" value="주문"></td>
						</tr>
						<tr><td colspan="100"><hr class="productrow_under_line"></td></tr>
						<tr>
							<td width="80px"><img class="product_image" src="${contextPath}/resources/image/americano.jpeg"></td>
							<td width="500px">
								<div>
									<h3 class="productName no-top_bottom_margin margin-left-10px">아메리카노(ice)</h3>
									<p class="productDescription no-top_bottom_margin margin-left-10px">아라비카산 원두로 로스팅하여 만든 아메리카노</p>
								</div>
							</td>
							<td>
								<div style="display:flex; align-items:center;">
									<p class="no-top_bottom_margin margin-right-5px">Take-Out</p>
									<input type="checkbox" class="margin-right-10px" name="is_takeout"/>
								</div>
							</td>
							<td width="70px"><p class="no-top_bottom_margin">3500원</p></td>
							<td width="45px"><p class="no-top_bottom_margin">수량</p></td>
							<td style="width:70px;">
								<input style="width:100%;" class="numberInput" type="number" min=0 value=0>
							</td>
							<td width="70px"><p class="price-text no-top_bottom_margin">총 3500원</p></td>
							<td width="28px"><input type="button" class="cartAddButton" value="담기"></td>
							<td width="28px"><input type="button" class="orderAddButton" value="주문"></td>
						</tr>
						<c:forEach var='goods' items="${goodsList}">
							<tr>
								<td colspan="100">
									<hr class="productrow_under_line">
								</td>
							</tr>
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
									<input style="width:100%;" class="numberInput" type="number" name="quantity" min=0 value=0 onchange="setTotalPrice(this.parentNode.parentNode)">
								</td>
								<td width="90px">
									<p class="price-text no-top_bottom_margin">총 0원</p>
									<input type='hidden' name="totalPrice" value="0">
								</td>
								<td width="28px"><input type="button" class="cartAddButton" onclick="addGoodsCart('${contextPath}',this.parentNode.parentNode)" value="담기"></td>
								<td width="28px"><input type="button" class="orderAddButton" value="주문" onclick="sendOrderToOrderForm('${contextPath}',this.parentNode.parentNode)"></td>
							</tr>		
						</c:forEach>
					</table>
				</div>
				<div id="tab-3" class="tab-content scrollable">
					<table width="100%">
						<tr>
							<td width="80px"><img class="product_image" src="${contextPath}/resources/image/danchaeseat.jpeg"></td>
							<td width="480px">
								<div>
									<h3 class="productName no-top_bottom_margin margin-left-10px">4인석</h3>
								</div>
							</td>
							<td width="70px"><p class="no-top_bottom_margin">3500원</p></td>
							<td>
								<table>
									<tr>
										<td>날짜</td>
										<td><input type="date"></td>
									</tr>
									<tr>
										<td>시작시간</td>
										<td><input type="time" id="res_start_time"></td>
									</tr>
									<tr>
										<td>종료시간</td>
										<td><input type="time" id="res_close_time"></td>
									</tr>
								</table>
							</td>
							<td width="90px"><p class="no-top_bottom_margin">총 3500원</p></td>
							<td width="28px"><input type="button" class="cartAddButton" value="담기"></td>
								<td width="28px"><input type="button" class="orderAddButton" value="주문"></td>
							
						</tr>
						<c:forEach var="groupSeat" items="${groupSeatList}">
							<tr>
								<td colspan="100">
									<hr class="productrow_under_line">
								</td>
							</tr>
							<tr>
							<td width="80px"><img class="product_image" src="${contextPath}/cafe/downloadGroupSeatPhoto.do?cafe_id=${cafeInfo.cafe_id}&groupSeat_id=${groupSeat.groupseat_id}"></td>
							<td width="480px">
								<input type="hidden" name="groupseat_id" value="${groupSeat.groupseat_id}">
								<div>
									<h3 class="productName no-top_bottom_margin margin-left-10px">${groupSeat.seat_name}</h3>
								</div>
							</td>
							<td width="70px"><p class="no-top_bottom_margin">${groupSeat.price}원</p></td>
							<td>
								<table>
									<tr>
										<td>날짜</td>
										<td><input type="date" name="reservation_date"></td>
									</tr>
									<tr>
										<td>시작시간</td>
										<td><input type="time" name="start_time"></td>
									</tr>
									<tr>
										<td>종료시간</td>
										<td><input type="time" name="end_time"></td>
									</tr>
								</table>
							</td>
							<td width="90px"><p class="no-top_bottom_margin">총 3500원</p></td>
							<td width="28px"><input type="button" class="cartAddButton" onclick="addGroupSeatCart('${contextPath}',this.parentNode.parentNode)" value="담기"></td>
							<td width="28px"><input type="button" class="orderAddButton" value="주문"></td>
							
						</tr>
							
						</c:forEach>
					</table>
				</div>
				<div id="tab-4" class="tab-content">
					<div class="scrollable" style="height:230px;">
						<table>
							<tr>
								<td width="80px"><img class="product_image" src="${contextPath}/resources/image/americano.jpeg"></td>
								<td width="900px" class="reply-content-td">
									<p class="productDescription no-top_bottom_margin">
										와..여기 커피맛집이네요<br>
										강추합니다!
									</p>
								</td>
								
								<td width="100px">
									<p class="productDescription no-top_bottom_margin margin-left-10px margin-right-10px">
										dltnstls12
									</p>
								</td>
								<td width="28px"><input type="button" class="cartAddButton" value="수정"></td>
								<td width="28px"><input type="button" class="orderAddButton" value="삭제"></td>
							</tr>
							<c:forEach var="cafeReview" items="${cafeReviewList}">
								<tr><td colspan="100"><hr class="productrow_under_line"></td></tr>
								<tr>
								<td width="80px"><img class="product_image" src="${contextPath}/resources/image/americano.jpeg"></td>
								<td width="900px" class="reply-content-td">
									<p class="productDescription no-top_bottom_margin">
										${cafeReview.review_content}
									</p>
								</td>
								
								<td width="100px">
									<p class="productDescription no-top_bottom_margin margin-left-10px margin-right-10px">
										${cafeReview.user_user_id}
									</p>
								</td>
								<td width="28px"><input type="button" class="cartAddButton" value="수정"></td>
								<td width="28px"><input type="button" class="orderAddButton" value="삭제"></td>
							</tr>
							</c:forEach>
						</table>
					</div>
					<div class="bottom-content-wrapper">
          				<table>
          					<tr>
          						<td>
          							<div style="display:flex; justify-content: flex-start; align-items:center;">
          								<p class="productDescription margin-right-10px no-top_bottom_margin">리뷰상품선택(최근순)</p>
	          							<select name="orderHistory">
	          								<option value="1">아메리카노 외 1건</option>
	          							</select>
	          							<p class="productDescription margin-left-30px margin-right-10px no-top_bottom_margin">카페점수</p>
	          							<p class="no-top_bottom_margin margin-right-5px">커피</p>
	          							<input type="number" name="coffee_score" class="score_inputbox" min=0 max=100 value=0 onchange="cafeScoreInputValidation(this)">
	          							<p class="no-top_bottom_margin margin-left-10px margin-right-5px">음료</p>
	          							<input type="number" name="drink_score" class="score_inputbox" min=0 max=100 value=0 onchange="cafeScoreInputValidation(this)">
	          							<p class="no-top_bottom_margin margin-left-10px margin-right-5px">디저트</p>
	          							<input type="number" name="dessert_score" class="score_inputbox" min=0 max=100 value=0 onchange="cafeScoreInputValidation(this)">
	          							<p class="no-top_bottom_margin margin-left-10px margin-right-5px">뷰</p>
	          							<input type="number" name="scenery_score" class="score_inputbox" min=0 max=100 value=0 onchange="cafeScoreInputValidation(this)">
	          							<p class="no-top_bottom_margin margin-left-10px margin-right-5px">분위기</p>
	          							<input type="number" name="mood_score" class="score_inputbox" min=0 max=100 value=0 onchange="cafeScoreInputValidation(this)">
	          							<p class="no-top_bottom_margin margin-left-10px margin-right-5px">조용함</p>
	          							<input type="number" name="mute_score" class="score_inputbox" min=0 max=100 value=0 onchange="cafeScoreInputValidation(this)">
          							</div>
          						</td>
          						<td></td>
          					</tr>
          					<tr>
          						<td class="vertical-align-center"><textarea name="review_content" style="width:1099px; height:100px;"></textarea></td>
          						<td class="vertical-align-center"><button style="height:100px;">글쓰기</button></td>
          					</tr>
          					<tr>
          						<td class="vertical-align-center" colspan="2"><input type="file" id="review_photo" name="review_photo" value="사진첨부" accept=".gif, .jpg, .png"></td>
          					</tr>
          				</table>
          			</div>
				</div>
				<div id="tab-5" class="tab-content scrollable">
					<table align="center">	
						<tr>
							<td><img class="cafe_photo" src="${contextPath}/resources/image/americano.jpeg"></td>
							<td><div class="photo_spacer"></div></td>
							<td><img class="cafe_photo" src="${contextPath}/resources/image/add_picture.svg"></td>
							<td><div class="photo_spacer"></div></td>
							<td><img class="cafe_photo" src="${contextPath}/resources/image/add_picture.svg"></td>
							<td><div class="photo_spacer"></div></td>
							<td><img class="cafe_photo" src="${contextPath}/resources/image/add_picture.svg"></td>
							<td><div class="photo_spacer"></div></td>
							<td><img class="cafe_photo" src="${contextPath}/resources/image/add_picture.svg"></td>
							<td><div class="photo_spacer"></div></td>
							<td><img class="cafe_photo" src="${contextPath}/resources/image/add_picture.svg"></td>
						</tr>
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