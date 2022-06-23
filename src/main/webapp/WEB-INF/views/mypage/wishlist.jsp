<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    isELIgnored="false"  
%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="contextPath"  value="${pageContext.request.contextPath}"  /> 
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>카페어디가-마이페이지</title>
		<link rel="preconnect" href="https://fonts.googleapis.com">
	    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
	    <link href="https://fonts.googleapis.com/css2?family=Jua&display=swap" rel="stylesheet">
	    
		<style>
			#register_section{
				margin-left:150px;
				margin-right:150px;
			}
			.page_title{
				font-family:'Malgun Gothic';
				font-weight: bold;
			    font-size:40px;
			    color:black;		
			}
			.register_label{
				font-family: 'Jua', sans-serif;
			    font-size:20px;
			    color:black;		
			}
			.authority_level_select_label{
				font-family: 'Jua', sans-serif;
			    font-size:18px;
			    color:black;		
			}
			.phonenum-input{
				width: 50px;
				border: 1px solid #b9b9b9;
				border-radius:5px;
			}
			
			.input_box{
				width:100%;
				height:25px;
				border: 1px solid #b9b9b9;
				border-radius:5px;
			}
			.input_box:disabled{
				background-color: #ebebeb;
			}
			.input_box_mileage{
				width:100px;
				height:25px;
				border: 1px solid #b9b9b9;
				border-radius:5px;
			}
			.profile_photo_preview{
				width: 140px;
				height: 140px;
			}
			.submit_button{
				width:300px;
				background-color:#1F364B;
				font-family: 'Jua', sans-serif;
			    font-size:20px;
			    color:white;
			    border: 1px solid white;
			    border-radius:5px;
			}
			.form_wrapper{		
				margin-top:50px;
				margin-bottom:0px;
				margin-left:0px;
				margin-right:0px;
				
				display:flex;
				justify-content:center;
			}
			.form_wrapper-inner{
			
				width:500px;
				
			}
			.input_container{
				display:flex;
				justify-content:center;
				width:95%;
				border: 1px solid #b9b9b9;
				border-radius:5px;
				margin-top:10px;
			}
			.content_wrapper{
				margin-top:20px;
				margin-bottom:50px;
			}
			
			#profile_photo{
				display:none;
			}
			#register_form{
				
			}
			.image_container{
				display:flex;
				justify-content: center
			}
			#userinfo_input_table{
				width:100%;
				align:center;
			}
			#submit_button_wrapper{
				display:flex;
				justify-content:center;
				margin-top:10px;
			}
			.input_container_inner{
				width:95%;
				margin-bottom:10px;
			}
			#radio_button_row{
				text-align:center;
			}
			.input_container_outer{
				width:100%;
				display:flex;
				justify-content:center;
			}
			.a-no-text-decoration{
				text-decoration:none;
			}
			.a-color-black{
				color:black;
			}
			.a-color-black:hover, .a-color-black:visited {
				color:black;
			}				
			.list-style-none{
				list-style: none;
			}
			#content_wrapper_inner{
				display:flex;
				margin-top:50px;
			}
			.left-nav_font-style{
				font-family:'Malgun Gothic';
				font-weight: bold;
				font-size:20px;
			}
			#left-nav-ul{
				width:320px;
				margin-left:40px;
			}
			#search_condition_form_container{
				display:flex;
				justify-content:flex-end;
			}
			#submitButton{
				background-color:#1F364B;
				font-family: 'Jua', sans-serif;
			    font-size:20px;
			    color:white;
			    border: 1px solid white;
			    border-radius:5px;
			}
			#wishlistMultiDeleteButton{
				background-color:#1F364B;
				font-family: 'Jua', sans-serif;
			    font-size:20px;
			    color:white;
			    border: 1px solid white;
			    border-radius:5px;
			}
			.wishlistDeleteButton{
				background-color:#E50F0F;
				font-family: 'Jua', sans-serif;
			    font-size:17px;
			    color:white;
			    border: 1px solid white;
			    border-radius:5px;
			}
			#formRow{
				text-align:right;
			}
			#searchKeword{
				width:130px;
			}
			.tiny_icon{
				height:20px;
				margin:0px;
			}
			.result_table{
				margin-top:5px;
				margin-bottom:10px;
				width:100%;
			}
			.result_table tr, .result_table th, .result_table td{
				border: 1px solid #b9b9b9;
			}
			.result_table tr{
							
			}
			.result_table th{
				background-color: #6e7580;
				color:white;
			}
			.result_table td img, .result_table td p{
				vertical-align:middle;
			}
			.pagination_wrapper{
				display:flex;
				justify-content:center;
			}
			.no-margin-top-bottom{
				margin-top:0px;
				margin-bottom:0px;	
			}
			#facilityInfo{
				text-align:center;
			}
			#searchUIWrapper{
				width:1200px;
			}
			.align-right{
				display:flex;
				justify-content: flex-end;
			}
			.margin-top-20px{
				margin-top: 20px;
			}
			.theme_score_icon{
				height:20px;
				margin:0px;
			}
			.icon_text{
				margin-right:5px;
			}
			#formRow{
				text-align:right;
			}
		</style>
		
		<script>
			function select_profile_photo(){
				var profile_preview = document.getElementById("profile_photo_preview");
				var profile_photo = document.getElementById("profile_photo");
				profile_photo.click();
			}
		</script>
	</head>
	<body>
		<section id="register_section">
			<div class="content_wrapper">
				<h1 class="page_title">마이페이지</h1>
				<div id="content_wrapper_inner">
					<div id="nav-left-menu-wrapper">
						<ul id="left-nav-ul">
							<li class="list-style-none"><a class="a-no-text-decoration a-color-black left-nav_font-style" href="${contextPath}/mypage/userinfo.do">회원정보</a></li>
							<li class="list-style-none"><a class="a-no-text-decoration a-color-black left-nav_font-style" href="${contextPath}/mypage/wishlist.do">찜한카페목록</a></li>
							<li class="list-style-none"><a class="a-no-text-decoration a-color-black left-nav_font-style" href="${contextPath}/mypage/cartList.do">장바구니조회</a></li>
							<li class="list-style-none"><a class="a-no-text-decoration a-color-black left-nav_font-style" href="${contextPath}/mypage/orderReservationList.do">주문/예약내역조회</a></li>
						</ul>
					</div>
					<div id="searchUIWrapper">
						<div id="search_condition_form_container">
						<form>
							<table>
								<tr id="formRow1">
									<td colspan="100">
										<label class="inputLabel" for="region1">지역1</label>
										<select id="region1" name="cafe_location1_selector" onchange="sidoChanged(this)">
											<option>선택</option>
										</select>
										<input type="hidden" id="cafe_region1_value">
										<label class="inputLabel" for="region2">지역2</label>
										<select id="region2" name="cafe_location2_selector" onchange="sigoonChanged(this)">
											<option>선택</option>
										</select>
										<input type="hidden" id="cafe_region2_value">
										<label class="inputLabel" for="region3">지역3</label>
										<select id="region3" name="cafe_location3_selector" onchange="dongChanged(this)">
											<option>선택</option>
										</select>
										<input type="hidden" id="cafe_region3_value">
										<label class="inputLabel" for="region3">지역4</label>
										<select id="region4" name="cafe_location4_selector">
											<option>선택</option>
										</select>
										<input type="hidden" id="cafe_region4_value">
									</td>
								</tr>
								<tr id="formRow">
									<td>
										<label id="inputLabel" for="isPlugExist">콘센트</label>
										<input type="checkbox" id="isPlugExist" name="isPlugExist">
										<label id="inputLabel" for="isParkingLotExist">주차장</label>
										<input type="checkbox" id="isParkingLotExist" name="isParkingLotExist">
										<label id="inputLabel" for="isDontCare">무관</label>
										<input type="checkbox" id="isDontCare" name="isDontCare">
									</td>
									<td>
										<label id="inputLabel" for="numOfSeat">좌석수</label>
										<select id="numOfSeat">
											<option value="10+">10+</option>
											<option value="20+">20+</option>
											<option value="50+">50+</option>
											<option value="100+">100+</option>
											<option value="150+">150+</option>
											<option value="200+">200+</option>
											<option value="300+">300+</option>
										</select>
									</td>
									<td>
										<label id="inputLabel" for="theme">테마선택</label>
										<select id="theme">
											<option value="분위기좋은카페">분위기좋은카페</option>
											<option value="커피장인">커피장인</option>
											<option value="디저트맛집">디저트맛집</option>
											<option value="조용한카페">조용한카페</option>
											<option value="뷰가좋은카페">뷰가좋은카페</option>
										</select>
									</td>
								</tr>
								<tr id="formRow">
									<td></td>
									<td>
										<label id="inputLabel" for="sortingCondition">정렬</label>
										<select id="sortingCondition">
											<option value="카페이름순">카페이름순</option>
											<option value="등록일순">등록일순</option>
										</select>
									</td>
									<td>
										<label id="inputLabel" for="searchKeword">검색어</label>
										<input type="text" id="searchKeword">
									</td>
								</tr>
								<tr id="formRow">
								<td></td>
								<td></td>
									<td>
										<input type="submit" id="submitButton" value="검색">
									</td>
								</tr>
							</table>
						</form>
					</div>
					<div class="align-right margin-top-20px"><button id="wishlistMultiDeleteButton">선택항목삭제</button></div>
					<div id="tableWrapper">
						<table class="result_table">
							<tr>
								<th>카페명</th>
								<th>주소</th>
								<th width="70px">좌석수</th>
								<th width="80px">시설</th>
								<th>카페지수</th>
								<th width="100px">등록일</th>
							</tr>
							
							<c:forEach var="cafe" items="${likedCafeList}">
							<tr class="resultRow">
								<td>
									<a class="no-margin-top-bottom" href="${contextPath}/cafe/cafe_detail.do?cafe_id=${cafe.cafe_id}">${cafe.cafe_name}</a>
								</td>
								<td>
									<p class="no-margin-top-bottom">${cafe.cafe_location1} ${cafe.cafe_location2}</p>
								</td>
								<td>
									<p class="no-margin-top-bottom">${cafe.number_of_seat}</p>
								</td>
								<td id="facilityInfo">
									<c:if test="${cafe.parking_lot == true}"><img class="tiny_icon" src="${contextPath}/resources/image/parking_icon.svg"></c:if>
									<c:if test="${cafe.parking_lot == false}"><img class="tiny_icon" src="${contextPath}/resources/image/parking_icon_unavailable.svg"></c:if>
									
									<c:if test="${cafe.power_plug == true}"><img class="tiny_icon" src="${contextPath}/resources/image/socket_icon.svg"></c:if>
									<c:if test="${cafe.power_plug == false}"><img class="tiny_icon" src="${contextPath}/resources/image/socket_icon_unavailable.svg"></c:if>
									
									<c:if test="${cafe.wifi == true}"><img class="tiny_icon" src="${contextPath}/resources/image/wifi_icon.svg"></c:if>
									<c:if test="${cafe.wifi == false}"><img class="tiny_icon" src="${contextPath}/resources/image/wifi_icon_unavilable.svg"></c:if>
								</td>
								<td style="width:120px;">
									<div style="display:flex;">
										<img class="theme_score_icon" src="${contextPath}/resources/image/coffee_icon.svg"><p class="icon_text no-margin-top-bottom">${cafe.coffee_score}</p>
										<img class="theme_score_icon" src="${contextPath}/resources/image/drink_icon.svg"><p class="icon_text no-margin-top-bottom">${cafe.drink_score}</p>
										<img class="theme_score_icon" src="${contextPath}/resources/image/dessert_icon.svg"><p class="icon_text no-margin-top-bottom">${cafe.dessert_score}</p>
										<img class="theme_score_icon" src="${contextPath}/resources/image/scenery_icon.svg"><p class="icon_text no-margin-top-bottom">${cafe.view_score}</p>
										<img class="theme_score_icon" src="${contextPath}/resources/image/atmosphere_icon.svg"><p class="icon_text no-margin-top-bottom">${cafe.mood_score}</p>
										<img class="theme_score_icon" src="${contextPath}/resources/image/mute_icon.svg"><p class="icon_text no-margin-top-bottom">${cafe.quiet_score}</p>
									</div>
								</td>
								<td>
									<p class="no-margin-top-bottom"><fmt:formatDate value="${cafe.created_date}" pattern="YYYY.MM.dd"/></p>
								</td>
							</tr>
							</c:forEach>
						</table>
						<div class="pagination_wrapper">
							<ul class="pagination pagination-sm">
							    <li class="page-item"><a class="page-link" href="#">Previous</a></li>
							    <li class="page-item"><a class="page-link" href="#">1</a></li>
							    <li class="page-item"><a class="page-link" href="#">2</a></li>
							    <li class="page-item"><a class="page-link" href="#">3</a></li>
							    <li class="page-item"><a class="page-link" href="#">4</a></li>
							    <li class="page-item"><a class="page-link" href="#">5</a></li>
							    <li class="page-item"><a class="page-link" href="#">Next</a></li>
							</ul>
						</div>
					</div>
					</div>
				</div>
			</div>
		</section>
	</body>
</html>