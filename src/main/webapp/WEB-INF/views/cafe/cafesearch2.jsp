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
		<title>카페어디가-카페검색</title>
		
		<!-- BootStrap -->
	    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
	    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
		
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
			#inputLabel{
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
		</style>
	</head>
	
	<body>
		<section id="mainContainer">
			<div id="mainContentWrapper">
				<h1 id="pageTitle">카페찾기</h1>
				<div>
					<div id="search_condition_form_container">
						<form>
							<table>
								<tr id="formRow">
									<td>
										<label id="inputLabel" for="region1">지역1</label>
										<select id="region1">
											<option value="서울">서울</option>
										</select>	
									</td>
									
									<td>
										<label id="inputLabel" for="region2">지역2</label>
										<select id="region2">
											<option value="강남구">강남구</option>
										</select>	
									</td>
									
									<td>
										<label id="inputLabel" for="region3">지역3</label>
										<select id="region3">
											<option value="논현동">논현동</option>
										</select>	
									</td>
								</tr>
								<tr id="formRow">
									<td>
										<label id="inputLabel" for="isPlugExist">콘센트</label>
										<input type="checkbox" id="isPlugExist" name="isPlugExist">
										<label id="inputLabel" for="isParkingLotExist">주차장</label>
										<input type="checkbox" id="isParkingLotExist" name="isParkingLotExist">
										<label id="inputLabel" for="isParkingLotExist">Wi-Fi</label>
										<input type="checkbox" id="isWifiExist" name="isWifiExist">
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
											<option value="전체">전체</option>
											<option value="분위기좋은카페">분위기좋은카페</option>
											<option value="커피장인">커피장인</option>
											<option value="음료맛집">음료맛집</option>
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
							<tr>
								<td>
									<a class="no-margin-top-bottom" href="${contextPath}/cafe/cafe_detail.do">카페 블루</a>
								</td>
								<td>
									<p class="no-margin-top-bottom">대전 서구 둔산동</p>
								</td>
								<td>
									<p class="no-margin-top-bottom">50+</p>
								</td>
								<td id="facilityInfo">
									<img class="tiny_icon" src="${contextPath}/resources/image/parking_icon.svg">
									<img class="tiny_icon" src="${contextPath}/resources/image/socket_icon.svg">
									<img class="tiny_icon" src="${contextPath}/resources/image/wifi_icon.svg">
								</td>
								<td style="width:120px;">
									<div style="display:flex;">
										<img class="theme_score_icon" src="${contextPath}/resources/image/coffee_icon.svg"><p class="icon_text no-margin-top-bottom">70</p>
										<img class="theme_score_icon" src="${contextPath}/resources/image/dessert_icon.svg"><p class="icon_text no-margin-top-bottom">70</p>
										<img class="theme_score_icon" src="${contextPath}/resources/image/scenery_icon.svg"><p class="icon_text no-margin-top-bottom">70</p>
										<img class="theme_score_icon" src="${contextPath}/resources/image/socket_icon.svg"><p class="icon_text no-margin-top-bottom">70</p>
										<img class="theme_score_icon" src="${contextPath}/resources/image/wifi_icon.svg"><p class="icon_text no-margin-top-bottom">70</p>
									</div>
								</td>
								<td>
									<p class="no-margin-top-bottom">2022.04.21</p>
								</td>
							</tr>
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
		</section>
	</body>
</html>