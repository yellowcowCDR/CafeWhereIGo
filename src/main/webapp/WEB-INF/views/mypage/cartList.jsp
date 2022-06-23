<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    isELIgnored="false"  
%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<c:set var="contextPath"  value="${pageContext.request.contextPath}"/> 
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>카페어디가-마이페이지</title>
		
		<!-- google font -->
		<link rel="preconnect" href="https://fonts.googleapis.com">
	    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
	    <link href="https://fonts.googleapis.com/css2?family=Jua&display=swap" rel="stylesheet">
	    
	    <!-- jquery -->
	    <script src="https://code.jquery.com/jquery-3.6.0.js" integrity="sha256-H+K7U5CnXl1h5ywQfKtSj8PCmoN9aaq30gDh27Xc0jk=" crossorigin="anonymous"></script>
	    
	    <!-- user defined  -->
	    <script type="text/javascript" src="${contextPath}/resources/js/order/addOrder.js"></script>
	    <script type="text/javascript" src="${contextPath}/resources/js/mypage/cartList.js"></script>
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
				width:1200px;		
				margin-top:50px;
				margin-bottom:0px;
				margin-left:0px;
				margin-right:0px;
				

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
			
			
			.image_container{
				display:flex;
				justify-content: center
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
			.orderlistDeleteButton{
				background-color:#E50F0F;
				font-family: 'Jua', sans-serif;
			    font-size:15px;
			    color:white;
			    border: 1px solid white;
			    border-radius:5px;
			}
			#tableTitle{
				font-family: 'Jua', sans-serif;
				color:white;	
				margin-left:5px;
				margin-top:5px;
				margin-bottom:5px;	
			}
			#orderListTable{
				width:100%;
				margin-bottom:20px;
			}
			#orderListTable tr,#orderListTable th, #orderListTable td{
				border: 1px solid #b9b9b9;
			}
			#orderListTable th, #orderListTable td{
				margin:0px; 
			}
			#orderListTable th{
				background-color: #6e7580;
				color:white;
			}
			#orderListTable td *{
				
				
			}
			.cancelbutton_td{
				text-align:center;
				width:60px;
			}
			.pagination_wrapper{
				display:flex;
				justify-content:center;
			}
			.searchFormWrapper{
				float:right;
				margin-bottom:20px;
			}
			#searchButton{
				background-color:#1F364B;
				font-family: 'Jua', sans-serif;
			    font-size:17px;
			    color:white;
			    border: 1px solid white;
			    border-radius:5px;
			}
			#searchInputBox{
				width:200px;
				height:25px;
			}
			.product_image{
				width:80px;
				height:80px;
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
			#orderTable{
				width:1000px;
				margin-bottom:20px;
			}
			#reservationTable{
				margin-top:0px;
				width:1000px;
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
				width:1000px;
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
			.numberInput{
				width:70px;
			}
			.no-top_bottom_margin{
				margin-top:0px;
				margin-bottom:0px;
				
			}
			.orderModifyButton{
				
				background-color:#1F364B;
				font-family: 'Jua', sans-serif;
			    font-size:17px;
			    color:white;
			    border: none;
			    border-radius:5px;
			}
			.orderDeleteButton{
				
				background-color:#E50F0F;
				font-family: 'Jua', sans-serif;
			    font-size:17px;
			    color:white;
			    border: none;
			    border-radius:5px;
			    margin-left:5px;
			    margin-right:5px;
			}
			#payWrapper{
				display:flex;
				justify-content: center;
				margin-top:20px;
				margin-bottom:20px;
			}
			#orderButton{
			 	width:160px;
			 	height:30px;
				background-color:#1F364B;
				border:none;
				font-family: 'Jua', sans-serif;
			    font-size:20px;
			    color:white;
			    border: none;
			    border-radius:5px;
			}
			.margin-top-20px{
				margin-top: 20px;
			}
			.reservation-time-td{
				width:
			}
			.takeout_check_td{
				width:100px;
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
					<div class="form_wrapper">
						<div class="orderCancelContainer"> 
							<div align="center" class="orderCancel align-right">
								<button class="blueButton" onclick="toggleGoodsCartSelect()">전체주문선택/취소</button>
							</div>	
						</div>
						<div class="tableWrapper">
						<table align="center" id="orderTable">
								<tr class="tableHeaderRow">
									<th colspan="100" class="tableHeader">
										<div class="tableTitleWrapper">
											<h4 id="tableTitle" class="no-margin">주문</h4>
										</div>
									</th>
								</tr>
								<c:forEach var="goodsCart" items="${goodsCartList}" varStatus="status">
									<c:if test="${status.index>0}">
										<tr><td colspan="100"><hr style="width:100%"><td></tr>
									</c:if>
									<tr name="goodsRow">
										<td width="13px"><input class="checkboxInput" type="checkbox" name="goodsCartChecked"></td>
										<td width="80px">
											<input type="hidden" name="cart_id" value="${goodsCart.cart_id}">
											<input type="hidden" name="cafe_id" value="${goodsCart.cafe_cafe_id}">
											<input type="hidden" name="goods_id" value="${goodsCart.goods_id}" >
											<img class="product_image" src="${contextPath}/cafe/downloadGoodsPhoto.do?cafe_id=${goodsCart.cafe_cafe_id}&goods_id=${goodsCart.goods_id}">
										</td>
										<td width="420px">
											<div>
												<h3 class="productName no-top_bottom_margin margin-left-10px">${goodsCart.goods_name}</h3>
												<p class="productDescription no-top_bottom_margin margin-left-10px">${goodsCart.description}</p>
											</div>
										</td>
										<td class="takeout_check_td">
											<div style="display:flex; align-items:center;">
												<p class="no-top_bottom_margin margin-right-5px">Take-Out</p>
												<input type="checkbox" id="is_takeout" class="margin-right-10px" name="is_takeout" <c:if test="${(goodsCart.is_takeout) == true}">checked</c:if> />
											</div>
										</td>
										<td width="70px">
											<p class="no-top_bottom_margin">${goodsCart.price}원</p>
											<input type="hidden" name="unitPrice" value="${goodsCart.price}원">
										</td>
										<td width="45px"><p class="no-top_bottom_margin">수량</p></td>
										<td>
											<input class="numberInput" type="number" name="quantity" min=0 onchange="setGoodsTotalPrice(this.parentNode.parentNode)" value="${goodsCart.quantity}">
										</td>
										<td width="70px">
											<p class="price-text no-top_bottom_margin">${goodsCart.price * goodsCart.quantity}원</p>
											<input type="hidden" name="goods_unit_totalPrice" value="${goodsCart.price * goodsCart.quantity}">
										</td>
										<td width="28px"><input type="button" class="orderModifyButton" onclick="modifyGoodsCart('${contextPath}', this.parentNode.parentNode)" value="변경"></td>
										<td width="28px"><input type="button" class="orderDeleteButton" onclick="deleteGoodsCart('${contextPath}',${goodsCart.cart_id})" value="삭제"></td>
									</tr>							
								</c:forEach>
							</table>
							<div class="orderCancelContainer"> 
								<div align="center" class="orderCancel align-right">
									<button class="blueButton" onclick="toggleGroupSeatCartSelect()">전체예약선택/취소</button>
								</div>	
							</div>
							<table align="center" id="reservationTable">
								<tr class="tableHeaderRow">
									<th colspan="100" class="tableHeader"><h4 id="tableTitle" class="no-margin">예약</h4></th>
								</tr>
								<c:forEach var="groupSeatCart" items="${groupSeatCartList}" varStatus="status">
									<c:if test="${status.index>0}">
										<tr><td colspan="100"><hr></td></tr>
									</c:if>
									<tr name="groupSeatRow">
										<td width="13px"><input class="checkboxInput" type="checkbox" name="groupSeatCartChecked"></td>
										<td width="80px">
											<input type="hidden" name="cafe_id" value="${groupSeatCart.cafe_cafe_id}">
											<input type="hidden" name="seat_id" value="${groupSeatCart.groupSeat_id}" >
											<img class="product_image" src="${contextPath}/cafe/downloadGroupSeatPhoto.do?cafe_id=${groupSeatCart.cafe_cafe_id}&groupSeat_id=${groupSeatCart.groupSeat_id}">
										</td>
										<td width="410px">
											<div>
												<h3 class="productName no-top_bottom_margin margin-left-10px">${groupSeatCart.seat_name}</h3>
												<p class="productDescription no-top_bottom_margin margin-left-10px">${groupSeatCart.description}</p>
											</div>
										</td>
										<td width="70px">
											<p class="no-top_bottom_margin">${groupSeatCart.price}원(1H)</p>
											<input type='hidden' name="unitPrice" value="${groupSeatCart.price}">
										</td>
										<td>
											<table>
												<tr>
													<td>날짜</td>
													<td><input type="date" name="reservation_date" onchange="setGroupSeatTotalPrice(this.parentNode.parentNode.parentNode.parentNode.parentNode.parentNode)" value="${groupSeatCart.reservation_date}"></td>
												</tr>
												<tr>
													<td>시작시간</td>
													<td><input type="time" onchange="setGroupSeatTotalPrice(this.parentNode.parentNode.parentNode.parentNode.parentNode.parentNode)" name="start_time" value="${groupSeatCart.start_time}"></td>
												</tr>
												<tr>
													<td>종료시간</td>
													<td><input type="time" onchange="setGroupSeatTotalPrice(this.parentNode.parentNode.parentNode.parentNode.parentNode.parentNode)" name="end_time" value="${groupSeatCart.end_time}"></td>
												</tr>
											</table>
										</td>
										<td width="70px">
											<p class="price-text no-top_bottom_margin">${groupSeatCart.totalPrice}원</p>
											<input type="hidden" name="groupSeat_unit_totalPrice" value="${groupSeatCart.totalPrice}">
										</td>
										<td width="28px"><input type="button" class="orderModifyButton" value="변경"></td>
										<td width="28px"><input type="button" class="orderDeleteButton" onclick="deleteGroupSeatCart('${contextPath}',${groupSeatCart.cart_id})" value="삭제"></td>
										
									</tr>
								</c:forEach>
							</table>
							<div class="align-center margin-top-20px">
								<div style="width:1000px;" class="align-right">
									<h2 id="totalCost">총 ${allTotalPrice}원</h2>
								</div>
							</div>
							<div id="payWrapper">
								<input id="orderButton" type="button" value="주문/예약확정" onclick="sendMultipleOrderToOrderForm('${contextPath}')">
							</div>	
						</div>
					</div>
				</div>
			</div>
		</section>
	</body>
</html>