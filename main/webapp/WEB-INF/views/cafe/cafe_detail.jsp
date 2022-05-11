<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    isELIgnored="false"  
%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<c:set var="contextPath"  value="${pageContext.request.contextPath}"  /> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>카페어디가-카페상세</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=6ee71689aaa8aa4f420e61071a31891c"></script>
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
		    	parkinglot_tab_ciliked();
		     }
		})
	})
	
	function parkinglot_tab_ciliked(){
		var container = document.getElementById('map'); //지도를 담을 영역의 DOM 레퍼런스
		var options = { //지도를 생성할 때 필요한 기본 옵션
			center: new kakao.maps.LatLng(33.450701, 126.570667), //지도의 중심좌표.
			level: 3 //지도의 레벨(확대, 축소 정도)
		};
		
		var map = new kakao.maps.Map(container, options); //지도 생성 및 객체 리턴
		
		
		var positions = [
		    {
		        title: '카카오', 
		        latlng: new kakao.maps.LatLng(33.450705, 126.570677)
		    },
		    {
		        title: '생태연못', 
		        latlng: new kakao.maps.LatLng(33.450936, 126.569477)
		    },
		    {
		        title: '텃밭', 
		        latlng: new kakao.maps.LatLng(33.450879, 126.569940)
		    },
		    {
		        title: '근린공원',
		        latlng: new kakao.maps.LatLng(33.451393, 126.570738)
		    }
		];
		var imageSrc = "https://t1.daumcdn.net/localimg/localimages/07/mapapidoc/markerStar.png";
		
		for (var i = 0; i < positions.length; i ++) {
		    
		    // 마커 이미지의 이미지 크기 입니다
		    var imageSize = new kakao.maps.Size(24, 35); 
		    
		    // 마커 이미지를 생성합니다    
		    var markerImage = new kakao.maps.MarkerImage(imageSrc, imageSize); 
		    
		    // 마커를 생성합니다
		    var marker = new kakao.maps.Marker({
		        map: map, // 마커를 표시할 지도
		        position: positions[i].latlng, // 마커를 표시할 위치
		        title : positions[i].title, // 마커의 타이틀, 마커에 마우스를 올리면 타이틀이 표시됩니다
		        image : markerImage // 마커 이미지 
		    });
		}
	}
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
</script>
</head>
<body>
	<section id="mainContainer">
		 <div id="mainWrapper">
		 	<div id="cafeinfoWrapper">
		 		<div id="mainphotoWrapper">
		 			<img id="mainImage" class="img_scaleDown" src="${contextPath}/resources/image/cafeImage/cafe1.jpg">
		 		</div>
		 		<div id="infowapper">
	 					<h1 class="cafe_name">카페 블루</h1>
 						<p>대전 서구 둔산동 1350</p>
 						<p>Tel. 042-222-2222</p>
 						<div style="display:flex;">
								<img class="theme_score_icon" src="${contextPath}/resources/image/coffee_icon.svg"><p class="icon_text">70</p>
								<img class="theme_score_icon" src="${contextPath}/resources/image/dessert_icon.svg"><p class="icon_text">70</p>
								<img class="theme_score_icon" src="${contextPath}/resources/image/scenery_icon.svg"><p class="icon_text">70</p>
								<img class="theme_score_icon" src="${contextPath}/resources/image/socket_icon.svg"><p class="icon_text">70</p>
								<img class="theme_score_icon" src="${contextPath}/resources/image/wifi_icon.svg"><p class="icon_text">70</p>
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
					안녕하세요! 세계 바리스타 대회 우승자가 운영하는 카페 블루입니다!
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
									<input type="checkbox" id="is_takeout" class="margin-right-10px" name="is_takeout"/>
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
									<input type="checkbox" id="is_takeout" class="margin-right-10px" name="is_takeout"/>
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
					</table>
				</div>
				<div id="tab-3" class="tab-content scrollable">
					<table>
						<tr>
							<td width="80px"><img class="product_image" src="${contextPath}/resources/image/danchaeseat.jpeg"></td>
							<td width="480px">
								<div>
									<h3 class="productName no-top_bottom_margin margin-left-10px">4인석</h3>
								</div>
							</td>
							
							<td>
								<table>
									<tr>
										<td>날짜</td>
										<td><input type="date"></td>
									</tr>
									<tr>
										<td>시작시간</td>
										<td><input type="time"></td>
									</tr>
									<tr>
										<td>종료시간</td>
										<td><input type="time"></td>
									</tr>
								</table>
							</td>
							<td width="70px"><p class="no-top_bottom_margin">3500원</p></td>
							<td width="28px"><input type="button" class="cartAddButton" value="담기"></td>
								<td width="28px"><input type="button" class="orderAddButton" value="주문"></td>
							
						</tr>
						<tr><td colspan="100"><hr class="productrow_under_line"></td></tr>
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
							<tr><td colspan="100"><hr class="productrow_under_line"></td></tr>
						</table>
					</div>
					<div class="bottom-content-wrapper">
          				<table>
          					<tr>
          						<td>
          							<div style="display:flex; justify-content: flex-start; align-items:center;">
          								<p class="productDescription margin-right-10px no-top_bottom_margin">리뷰상품선택(최근순)</p>
	          							<select>
	          								<option>아메리카노 외 1건</option>
	          							</select>
	          							<p class="productDescription margin-left-30px margin-right-10px no-top_bottom_margin">카페점수</p>
	          							<p class="no-top_bottom_margin margin-right-5px">커피</p>
	          							<input type="number" name="coffee_score" class="score_inputbox" min=0 max=100 value=0 onchange="cafeScoreInputValidation(this)">
	          							<p class="no-top_bottom_margin margin-left-10px margin-right-5px">음료</p>
	          							<input type="number" name="coffee_score" class="score_inputbox" min=0 max=100 value=0 onchange="cafeScoreInputValidation(this)">
	          							<p class="no-top_bottom_margin margin-left-10px margin-right-5px">디저트</p>
	          							<input type="number" name="coffee_score" class="score_inputbox" min=0 max=100 value=0 onchange="cafeScoreInputValidation(this)">
	          							<p class="no-top_bottom_margin margin-left-10px margin-right-5px">뷰</p>
	          							<input type="number" name="coffee_score" class="score_inputbox" min=0 max=100 value=0 onchange="cafeScoreInputValidation(this)">
	          							<p class="no-top_bottom_margin margin-left-10px margin-right-5px">분위기</p>
	          							<input type="number" name="coffee_score" class="score_inputbox" min=0 max=100 value=0 onchange="cafeScoreInputValidation(this)">
	          							<p class="no-top_bottom_margin margin-left-10px margin-right-5px">조용함</p>
	          							<input type="number" name="coffee_score" class="score_inputbox" min=0 max=100 value=0 onchange="cafeScoreInputValidation(this)">
          							</div>
          						</td>
          						<td></td>
          					</tr>
          					<tr>
          						<td class="vertical-align-center"><textarea style="width:1099px; height:100px;"></textarea></td>
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
						<tr>
							<td><img class="cafe_photo" src="${contextPath}/resources/image/add_picture.svg"></td>
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
						<tr>
							<td><img class="cafe_photo" src="${contextPath}/resources/image/add_picture.svg"></td>
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