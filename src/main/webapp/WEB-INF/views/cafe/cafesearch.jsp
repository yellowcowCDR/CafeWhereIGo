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
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>카페어디가-카페검색</title>
		
		<!-- BootStrap -->
	    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
	    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
		<script src="${contextPath}/resources/js/jquery-3.6.0.min.js"></script>
		<script type="text/javascript" charset="utf-8" src="${contextPath}/resources/js/cafe/getGeometricInfoForSearch.js"></script>
		<script type="text/javascript" charset="utf-8" src="${contextPath}/resources/js/cafe/searchCafe.js"></script>
		<style>
			#mainContainer{
				width: 100%;
				display:flex;
				justify-content:center;
			}
			#mainContentWrapper{
				width:75%;
				margin-top:20px;
			}
			#search_condition_form_container{
				display:flex;
				justify-content:flex-end;
			}
			#pageTitle{
				font-family:'Malgun Gothic';
				font-weight: bold;
			    font-size:40px;
			    color:black;
			}
			.inputLabel{
				font-family: 'Jua', sans-serif;
			    font-size:20px;
			    color:black;
			}
			#submitButton{
				background-color:#1F364B;
				font-family: 'Jua', sans-serif;
			    font-size:20px;
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
			.theme_score_icon{
				height:20px;
				margin:0px;
			}
			.icon_text{
				margin-right:5px;
			}
			.result_table .resultRow:hover{
				background-color:#d2ebf7;
			}
		</style>
		<script>
			var prev_cafe_location1='${cafeSearchParameter.cafe_location1}';
			var prev_cafe_location2='${cafeSearchParameter.cafe_location2}';
			var prev_cafe_location3='${cafeSearchParameter.cafe_location3}';
			var prev_cafe_location4='${cafeSearchParameter.cafe_location4}';
			
			var sidoSelector;
			var sigoonSelector;
			var dongSelector;
			var leeSelector;
			
			window.onload=function(){
				/* initCafeLocationSelector(
					'${cafeSearchParameter.cafe_location1}',
					'${cafeSearchParameter.cafe_location2}',
					'${cafeSearchParameter.cafe_location3}',
					'${cafeSearchParameter.cafe_location4}'
				); */
				
				initNumOfSeat(${cafeSearchParameter.number_of_seat});
				initCafeThemeSelector('${cafeSearchParameter.theme}');
				initSortingOptionSelector('${cafeSearchParameter.sortingOption}');
				
				sidoSelector = document.getElementById("region1");
				sigoonSelector = document.getElementById("region2");
				dongSelector = document.getElementById("region3");
				leeSelector = document.getElementById("region4");
				cafeLocation1Init();
			}
		</script>
	</head>
	
	<body>
		<section id="mainContainer">
			<div id="mainContentWrapper">
				<h1 id="pageTitle">카페찾기</h1>
				<div>
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
								<tr id="formRow2">
									<td>
										<label class="inputLabel" for="isPlugExist">콘센트</label>
										<input type="checkbox" id="isPlugExist" name="power_plug"
											<c:if test="${cafeSearchParameter.power_plug}">checked</c:if>
										>
										
										<label class="inputLabel" for="isParkingLotExist">주차장</label>
										<input type="checkbox" id="isParkingLotExist" name="parking_lot"
											<c:if test="${cafeSearchParameter.parking_lot}">checked</c:if>
										>
										
										<label class="inputLabel" for="isWifiExist">Wi-Fi</label>
										<input type="checkbox" id="isWifiExist" name="wifi"
											<c:if test="${cafeSearchParameter.wifi}">checked</c:if>
										>
										
										<label class="inputLabel" for="isDontCare">무관</label>
										<input type="checkbox" id="isDontCare" name="dontCare"
											<c:if test="${cafeSearchParameter.dontCare}">checked</c:if>
										>
									</td>
									<td>
										<label class="inputLabel" for="numOfSeat">좌석수</label>
										<select id="numOfSeat" name="number_of_seat">
											<option value="0">선택</option>
											<option value="10">10+</option>
											<option value="20">20+</option>
											<option value="50">50+</option>
											<option value="100">100+</option>
											<option value="150">150+</option>
											<option value="200">200+</option>
											<option value="300">300+</option>
										</select>
									</td>
									<td>
										<label class="inputLabel" for="theme">테마선택</label>
										<select id="themeSelector" name="theme">
											<option value="all">전체</option>
											<option value="mood">분위기좋은카페</option>
											<option value="coffee">커피장인</option>
											<option value="drink">음료맛집</option>
											<option value="dessert">디저트맛집</option>
											<option value="quiet">조용한카페</option>
											<option value="view">뷰가좋은카페</option>
										</select>
									</td>
								</tr>
								<tr id="formRow3">
									<td></td>
									<td>
										<label class="inputLabel" for="sortingOptionSelector">정렬</label>
										<select id="sortingOptionSelector" name="sortingOption">
											<option value="cafename">카페이름순</option>
											<option value=numOfSeat>좌석수순</option>
											<option value="recent">등록일순</option>
										</select>
									</td>
									<td>
										<label class="inputLabel" for="searchKeword">검색어</label>
										<input type="text" id="searchKeword" name="searchKeyword" value="${cafeSearchParameter.searchKeyword}">
									</td>
								</tr>
								<tr id="formRow4">
								<td></td>
								<td></td>
									<td style="text-align:end">
										<button type="button" id="submitButton" onclick="searchCafe('${contextPath}')">검색</button>
									</td>
								</tr>
							</table>
						</form>
					</div>
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
							
							<c:forEach var="cafe" items="${cafeList}">
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
							    <c:if test="${searchCondition.chapter<=1}">
							    	<li class="page-item disabled"><a class="page-link" href="#">Previous</a></li>
							    </c:if>
							    <c:if test="${searchCondition.chapter>1}">
							    	<li class="page-item"><a class="page-link" onclick="searchCafe('${contextPath}', ${searchCondition.chapter-1}, 5)">Previous</a></li>
							    </c:if>
							    <c:forEach begin="1" end="5" step="1" varStatus="status">
							   		<li class="page-item"><a class="page-link" onclick="searchCafe('${contextPath}', 1, ${status.index})">${status.index}</a></li>
							    </c:forEach>
							    <li class="page-item"><a class="page-link" onclick="searchCafe('${contextPath}', ${searchCondition.chapter+1}, 1)">Next</a></li>
							</ul>
						</div>
					</div>
				</div>
			</div>
		</section>
	</body>
</html>