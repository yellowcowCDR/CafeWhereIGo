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
		<title>카페어디가-점포관리</title>
		
		<!-- BootStrap -->
	    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
	    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
		
		<!-- Google Font -->
		<link rel="preconnect" href="https://fonts.googleapis.com">
	    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
	    <link href="https://fonts.googleapis.com/css2?family=Jua&display=swap" rel="stylesheet">
		
		<!-- jquery -->
	   <script src="${contextPath}/resources/js/jquery-3.6.0.min.js"></script>
		
		<script type="text/javascript" src="${contextPath}/resources/js/cafeManager/cafeManagement.js"></script>
		
		<style>
			#top_menu{
				display:flex;
				justify-content:flex-end;
			}
			#formWrapper{
				display:flex;
				margin-top:50px;
			}
			#mainContainer{
				width: 100%;
				display:flex;
				justify-content:center;
			}
			#mainContentWrapper{
				width:75%;
				margin-top:20px;
			}
			#pageTitle{
				font-family:'Malgun Gothic';
				font-weight: bold;
			    font-size:40px;
			    color:black;
			}
			.cafe_image{
				width:90px;
				height:90px;
				object-fit: scale-down;
			}
			.productName{
				font-family: 'Jua', sans-serif;
				font-size:27px;
				font-weight:bold;
				
			}
			.tableHeaderRow{
				background-color:#1F364B;
			}
			.tableHeader{
				
			}
			#tableTitle{
				font-family: 'Jua', sans-serif;
				color:white;	
				margin-left:5px;
				margin-top:5px;
				margin-bottom:5px;	
			}
			#orderTable{
				width:1080px;
			}
			#reservationTable{
				margin-top:10px;
				width:908px;
			}
			.tableTitleWrapper{
				display:flex;
				align-content:center;
			}
			.blueButton{
				background-color:#1F364B;
				font-family: 'Jua', sans-serif;
			    font-size:15px;
			    color:white;
			    border: none;
			    border-radius:5px;
			}
			.align-left{
				display:flex;
				justify-content:flex-start;
			}
			.align-right{
				display:flex;
				justify-content:flex-end;
			}
			.align-center{
				display:flex;
				justify-content:center;
			}
			.vertical-center{
				display:flex;
				align-content:center;
			}
			.orderCancel{
				width:1080px;
			}
			.checkboxInput{
				margin-left:10px;
				margin-right:10px;
			}
			#orderTable, #reservationTable{
				border: 1px solid #b9b9b9;
			}
			.productDescription{
				font-weight: bold;
			}
			.orderCancelContainer{
				display:flex;
				justify-content: center;
				margin-bottom:3px;
			}
			.no-top_bottom_margin{
				margin-top:0px;
				margin-bottom:0px;
				
			}
			.numberInput{
				width:70px;
			}
			#payWrapper{
				display:flex;
				justify-content: center;
				margin-top:20px;
				margin-bottom:20px;
			}
			#orderButton{
				background-color:#1F364B;
				border:none;
				font-family: 'Jua', sans-serif;
			    font-size:20px;
			    color:white;
			    border: none;
			    border-radius:5px;
			}
			
			.orderModifyButton{
				
				background-color:#1F364B;
				font-family: 'Jua', sans-serif;
			    font-size:17px;
			    color:white;
			    border: none;
			    border-radius:5px;
			}
			.cafeDeleteButton{
				
				background-color:#E50F0F;
				font-family: 'Jua', sans-serif;
			    font-size:17px;
			    color:white;
			    border: none;
			    border-radius:5px;
			    margin-left:5px;
			    margin-right:5px;
			}
			.cafeDeleteAllButton{
				background-color:#E50F0F;
				font-family: 'Jua', sans-serif;
			    font-size:17px;
			    color:white;
			    border: none;
			    border-radius:5px;
			    margin-top:0px;
			    margin-left:0px;
			    margin-right:3px;
			}
			.margin-left-10px{
				margin-left:10px;
			}
			#totalCost{
				font-weight:bold;
			}
			#mileageTableContainer{
				margin-top:30px;
			}
			.mileageInput{
				width:150px;
			}
			.icon{
				width:20px;
				height:20px;
			}
			.no-text-decoration{
				text-decoration: none;
			}
			.link-text-always-black:hover{
				color:black;
			}
			.link-text-always-black{
				color:black;
			}
			#add_cafe_button{
				font-family: 'Jua', sans-serif;
				font-size:20px;
				margin-right:2px;
			}
			.facility_icon{
				height:20px;
				margin:0px;
			}
			.theme_score_icon{
				height:20px;
				margin:0px;
			}
			#formContentWrapper{
				margin-bottom:20px;
			}
			#left-nav-ul{
				width:fit-content;
				margin-left:20px;
			}
			.nav-list{
				width: fit-content;
				list-style: none;
			}
			
			.list-style-none{
				list-style: none;
			}
			.a-no-text-decoration{
				text-decoration:none;
			}
			.a-color-black{
				color:black;
			}
			.left-nav_font-style{
				font-family:'Malgun Gothic';
				font-weight: bold;
				font-size:20px;
			}
			.icon_text{
				padding-right:5px;
			}
			#nav-left-menu-wrapper{
				width:fit-content;
			}
		</style>
	</head>
	
	<body>
		<section id="mainContainer">
			<div id="mainContentWrapper">
				<h1 id="pageTitle">점포관리</h1>
				<div id="formWrapper">
					<div id="nav-left-menu-wrapper">
						<ul id="left-nav-ul">
							<li class="nav-list"><a class="a-no-text-decoration a-color-black left-nav_font-style" href="${contextPath}/cafeManager/userinfo.do">회원정보</a></li>
							<li class="nav-list"><a class="a-no-text-decoration a-color-black left-nav_font-style" href="${contextPath}/cafeManager/cafeManagement.do">점포관리</a></li>
							<li class="nav-list"><a class="a-no-text-decoration a-color-black left-nav_font-style" href="${contextPath}/cafeManager/orderReservationList.do">주문/예약관리</a></li>
						</ul>
					</div>
					<div style="margin-left:100px;">
						<div id="formContentWrapper">
							<div class="orderCancelContainer"> 
								
								<div align="center" class="orderCancel align-right">
									<input type="button" class="cafeDeleteAllButton" onclick="changeBusinessStateToCloseMutiple('${contextPath}')" value="선택항목휴업">
									<input type="button" class="orderModifyButton"  onclick="changeBusinessStateToOpenMutiple('${contextPath}')" value="선택항목영업재개">
								</div>	
							</div>
							<table align="center" id="orderTable">
								<tr class="tableHeaderRow">
									<th colspan="9" class="tableHeader">
										<div class="tableTitleWrapper">
											<h4 id="tableTitle" class="no-margin">점포</h4>
										</div>
									</th>
								</tr>
								<c:if test="${cafeSearchResultList!=null &&cafeSearchResultList.size()<=0}">
									<tr>
										<td width="13px"><input class="checkboxInput" type="checkbox"></td>
										<td width="80px"><img class="cafe_image" src="${contextPath}/resources/image/americano.jpeg"></td>
										<td width="380px">
											<div>
												<a href="${contextPath}/cafe/cafe_detail.do" class="no-text-decoration link-text-always-black">
													<h3 class="productName no-top_bottom_margin margin-left-10px">카페 블루</h3>
												</a>
												<p class="productDescription no-top_bottom_margin margin-left-10px">대전 서구 둔산동 1350</p>
												
											</div>
										</td>
										<td>
											<div style="display:flex;" class="margin-left-10px">
												<c:if test="${cafeSearchResult.parking_lot == true}"><img class="facility_icon" src="${contextPath}/resources/image/parking_icon.svg"></c:if>
												<c:if test="${cafeSearchResult.power_plug == true}"><img class="facility_icon" src="${contextPath}/resources/image/socket_icon.svg"></c:if>
												<c:if test="${cafeSearchResult.wifi == true}"><img class="facility_icon" src="${contextPath}/resources/image/wifi_icon.svg"></c:if>
											</div>
										</td>
										<td>
											<div style="display:flex;" class="margin-left-10px">
													<img class="theme_score_icon" src="${contextPath}/resources/image/coffee_icon.svg"><p class="icon_text no-top_bottom_margin">${cafe.coffee_score}</p>
												<img class="theme_score_icon" src="${contextPath}/resources/image/drink_icon.svg"><p class="icon_text no-top_bottom_margin">${cafe.drink_score}</p>
												<img class="theme_score_icon" src="${contextPath}/resources/image/dessert_icon.svg"><p class="icon_text no-top_bottom_margin">${cafe.dessert_score}</p>
												<img class="theme_score_icon" src="${contextPath}/resources/image/scenery_icon.svg"><p class="icon_text no-top_bottom_margin">${cafe.view_score}</p>
												<img class="theme_score_icon" src="${contextPath}/resources/image/atmosphere_icon.svg"><p class="icon_text no-top_bottom_margin">${cafe.mood_score}</p>
												<img class="theme_score_icon" src="${contextPath}/resources/image/mute_icon.svg"><p class="icon_text no-top_bottom_margin">${cafe.quiet_score}</p>
											</div>
										</td>
										<td width="28px"><a href="${contextPath}/cafeManager/modifyCafeForm.do"><input type="button" class="orderModifyButton" value="관리"></a></td>
										<td width="28px"><input type="button" class="cafeDeleteButton" value="휴업"></td>
									</tr>
								</c:if>
								<c:forEach var="cafeSearchResult" items="${cafeSearchResultList}" varStatus="status">
									<c:if test="${status.index>0}">
										<tr>
											<td colspan="100">
												<hr>
											</td>
										</tr>
									</c:if>
									<tr name="cafeRow">
										<td width="13px"><input class="checkboxInput" name="checkboxInput" type="checkbox"></td>
										<td width="80px">
											<img class="cafe_image" src="${contextPath}/cafe/downloadCafeMainImage.do?cafe_id=${cafeSearchResult.cafe_id}" onerror="this.src='${contextPath}/resources/image/add_picture.svg'">
											<input type="hidden" name="cafe_id" value="${cafeSearchResult.cafe_id}">
										</td>
										<td width="380px">
											<div>
												<a href="${contextPath}/cafe/cafe_detail.do?cafe_id=${cafeSearchResult.cafe_id}" class="no-text-decoration link-text-always-black">
													<h3 class="productName no-top_bottom_margin margin-left-10px">${cafeSearchResult.cafe_name}</h3>
												</a>
												<p class="productDescription no-top_bottom_margin margin-left-10px">${cafeSearchResult.cafe_location1}</p>
												<p class="productDescription no-top_bottom_margin margin-left-10px">${cafeSearchResult.cafe_location2}</p>
											</div>
										</td>
										<td style="padding-right:20px;">
											<div style="display:flex;" class="margin-left-10px">
												<c:if test="${cafeSearchResult.parking_lot == true}"><img class="facility_icon" src="${contextPath}/resources/image/parking_icon.svg"></c:if>
												<c:if test="${cafeSearchResult.parking_lot == false}"><img class="facility_icon" src="${contextPath}/resources/image/parking_icon_unavailable.svg"></c:if>
												
												<c:if test="${cafeSearchResult.power_plug == true}"><img class="facility_icon" src="${contextPath}/resources/image/socket_icon.svg"></c:if>
												<c:if test="${cafeSearchResult.power_plug == false}"><img class="facility_icon" src="${contextPath}/resources/image/socket_icon_unavailable.svg"></c:if>
												
												<c:if test="${cafeSearchResult.wifi == true}"><img class="facility_icon" src="${contextPath}/resources/image/wifi_icon.svg"></c:if>
												<c:if test="${cafeSearchResult.wifi == false}"><img class="facility_icon" src="${contextPath}/resources/image/wifi_icon_unavilable.svg"></c:if>
											</div>
										</td>
										<td style="padding-right:20px;">
											<div style="display:flex;" class="margin-left-10px">
													<img class="theme_score_icon" src="${contextPath}/resources/image/coffee_icon.svg"><p class="icon_text no-top_bottom_margin">${cafeSearchResult.coffee_score}</p>
													<img class="theme_score_icon" src="${contextPath}/resources/image/drink_icon.svg"><p class="icon_text no-top_bottom_margin">${cafeSearchResult.drink_score}</p>
													<img class="theme_score_icon" src="${contextPath}/resources/image/dessert_icon.svg"><p class="icon_text no-top_bottom_margin">${cafeSearchResult.dessert_score}</p>
													<img class="theme_score_icon" src="${contextPath}/resources/image/scenery_icon.svg"><p class="icon_text no-top_bottom_margin">${cafeSearchResult.view_score}</p>
													<img class="theme_score_icon" src="${contextPath}/resources/image/atmosphere_icon.svg"><p class="icon_text no-top_bottom_margin">${cafeSearchResult.mood_score}</p>
													<img class="theme_score_icon" src="${contextPath}/resources/image/mute_icon.svg"><p class="icon_text no-top_bottom_margin">${cafeSearchResult.quiet_score}</p>
											</div>
										</td>
										<td>
											<c:if test="${cafeSearchResult.business_state == 'open'}">
												<p style="padding-right:10px;" class="business-state-indicator no-top_bottom_margin">영업중</p>
											</c:if>
											<c:if test="${cafeSearchResult.business_state == 'close'}">
												<p style="padding-right:10px;" class="business-state-indicator no-top_bottom_margin">휴업</p>
											</c:if>
										</td>
										<td width="28px"><a href="${contextPath}/cafeManager/modifyCafeForm.do?cafe_id=${cafeSearchResult.cafe_id}"><input type="button" class="orderModifyButton" value="관리"></a></td>
										<td width="28px"><input type="button" class="cafeDeleteButton" onclick="changeBusinessStateToClose('${contextPath}', this.parentNode.parentNode)" value="휴업"></td>
									</tr>	
								</c:forEach>
							</table>
							<div class="orderCancelContainer">
								<div align="center" class="orderCancel align-right">
									<a href="${contextPath}/cafeManager/addCafeForm.do" id="add_cafe_button" class="no-text-decoration link-text-always-black">
										<img style="margin-right:2px;" class="icon" src="${contextPath}/resources/image/cafe_add_icon.svg"/>점포등록
									</a>
								</div>
							</div>
						</div>
						
					</div>
				</div>
			</div>
		</section>
	</body>
</html>