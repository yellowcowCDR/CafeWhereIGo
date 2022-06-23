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
		<title>카페어디가-주문예약</title>
		
		<!-- BootStrap -->
	    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
	    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
		
		<!-- google font -->
		<link rel="preconnect" href="https://fonts.googleapis.com">
	    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
	    <link href="https://fonts.googleapis.com/css2?family=Jua&display=swap" rel="stylesheet">
		
		<!-- User Defined -->
		<script type="text/javascript" src="${contextPath}/resources/js/order/addOrder.js"></script>
		
		<style>
			#top_menu{
				display:flex;
				justify-content:flex-end;
			}
			#formWrapper{
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
			.tableHeader{
				
			}
			.tableTitle{
				font-family: 'Jua', sans-serif;
				color:white;	
				margin-left:5px;
				margin-top:5px;
				margin-bottom:5px;	
			}
			#orderTable{
				width:1000px;
			}
			#reservationTable{
				margin-top:10px;
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
			#orderCancel{
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
			#orderCancelContainer{
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
			#kakaopayButton{
				background-color:#FAE100;
				border:none;
				font-family: 'Jua', sans-serif;
			    font-size:20px;
			    color:white;
			    border: none;
			    border-radius:5px;
			}
			#naverpayButton{
				background-color:#19CE60;
				margin-left:10px;
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
			.takeout_check_td{
				width:100px;
			}
		</style>
		<script>
			window.onload=function(){
				var checkbox = document.getElementById("checkSaveMileage");
				checkbox.checked= false;
				
				var current_mileage = document.getElementById("current_mileage");
				var current_available_mileage = document.getElementById("current_available_mileage");
				var mileage_to_use = document.getElementById("mileage_to_use");
				var mileage_to_add = document.getElementById("mileage_to_add");
				
				current_mileage.disabled=false;
				current_available_mileage.disabled=false;
				mileage_to_use.disabled=false;
				mileage_to_add.disabled=true;
			}
			
		</script>
	</head>
	
	<body>
		<section id="mainContainer">
			<div id="mainContentWrapper">
				<h1 id="pageTitle">주문/예약</h1>
				<div id="formWrapper">
					
					<form>
						<div id="formContentWrapper">
							<div id="orderCancelContainer"> 
								<div align="center" id="orderCancel" class="align-right">
									<button class="blueButton">선택한 주문/예약취소</button>
								</div>	
							</div>
							<c:if test="${orderList!=null}">
								<table align="center" id="orderTable">
									<tr class="tableHeaderRow">
										<th colspan="100" class="tableHeader">
											<div class="tableTitleWrapper">
												<h4 class="tableTitle no-margin">주문</h4>
											</div>
										</th>
									</tr>
									<c:forEach var="order" items="${orderList}" varStatus="status">
										<c:if test="${status.index>0}">
											<tr><td colspan="100"><hr style="width:100%"><td></tr>
										</c:if>
											<tr name='goodsRow'>
												<td width="13px"><input class="checkboxInput" name="goodsOrderChecked" type="checkbox"></td>
												<td width="80px">
													<input type="hidden" name="cafe_id" value="${order.cafe_cafe_id}">
													<input type="hidden" name="goods_id" value="${order.goods_goods_id}">
													<img class="product_image" src="${contextPath}/resources/image/americano.jpeg">
												</td>
												<td width="410px">
													<div>
													    <h3 class="productName no-top_bottom_margin margin-left-10px">${order.goods_name}</h3>
														<c:forEach var="description" items="${order.goods_description}">
													       <p class="productDescription no-top_bottom_margin margin-left-10px">${description}</p>
														</c:forEach>
													</div>
												</td>
												<td class="takeout_check_td">
													<div style="display:flex; align-items:center;">
														<p class="no-top_bottom_margin margin-right-5px">Take-Out</p>
														<input type="checkbox" id="is_takeout" class="margin-right-10px" name="is_takeout" <c:if test="${order.is_takeout == true}">checked</c:if> />
													</div>
												</td>
										       <td width="70px">
										       		<p class="no-top_bottom_margin">${order.goods_price}원</p>
										       		<input type="hidden" name="unitPrice" value="${order.goods_price}">
									       		</td>
										       <td width="45px"><p class="no-top_bottom_margin">수량</p></td>
										       <td>
										           <input class="numberInput" type="number" min="0" name="quantity" onchange="setGoodsTotalPrice(this.parentNode.parentNode)" value="${order.order_quantity}">
										       </td>
										       <td width="70px">
										       		<p class="price-text no-top_bottom_margin">${order.order_quantity * order.goods_price}원</p>
										       		<input type="hidden" name="goods_unit_totalPrice" value="${order.order_quantity * order.goods_price}">
									       		</td>
										       <td width="28px"><input type="button" class="orderModifyButton" value="변경"></td>
										       <td width="28px"><input type="button" class="orderDeleteButton" value="취소"></td>
										   
										   </tr>
										</c:forEach>
								</table>
							</c:if>
							<c:if test="${reservationList==null}">
								<script>
									alert("reservationList is null");							
								</script>
							</c:if>
							<c:if test="${reservationList!=null && reservationList.size()>0}">
							<table align="center" id="reservationTable">
								<tr class="tableHeaderRow">
									<th colspan="100" class="tableHeader"><h4 class="tableTitle no-margin">예약</h4></th>
								</tr>
								<c:forEach var="reservation" items="${reservationList}" varStatus="status">
									<c:if test="${status.index>0}">
										<tr><td colspan="100"><hr></td></tr>
									</c:if>
									<tr name='groupSeatRow'>
										<td width="13px"><input class="checkboxInput" name="groupSeatOrderChecked" type="checkbox"></td>
										<td width="80px">
											<input type="hidden" name="cafe_id" value="${reservation.cafe_cafe_id}">
											<input type="hidden" name="seat_id" value="${reservation.groupseat_groupseat_id}">
											<img class="product_image" src="${contextPath}/cafe/downloadGroupSeatPhoto.do?cafe_id=${reservation.cafe_cafe_id}&groupSeat_id=${reservation.groupseat_groupseat_id}">
										</td>
										<td width="410px">
											<div>
												<h3 class="productName no-top_bottom_margin margin-left-10px">${reservation.seat_name}</h3>
											</div>
										</td>
										<td width="70px">
											<p class="no-top_bottom_margin">${reservation.unitPrice}원(1H)</p>
											<input type="hidden" name="unitPrice" value="${reservation.unitPrice}">
										</td>
										<td>
											<table>
												<tr>
													<td>날짜</td>
													<td><input type="date" name="reservation_date" onchange="setGroupSeatTotalPrice(this.parentNode.parentNode.parentNode.parentNode.parentNode.parentNode)" value="${reservation.reservation_date}"></td>
												</tr>
												<tr>
													<td>시작시간</td>
													<td><input type="time" name="start_time" onchange="setGroupSeatTotalPrice(this.parentNode.parentNode.parentNode.parentNode.parentNode.parentNode)" value="${reservation.start_time}"></td>
												</tr>
												<tr>
													<td>종료시간</td>
													<td><input type="time" name="end_time" onchange="setGroupSeatTotalPrice(this.parentNode.parentNode.parentNode.parentNode.parentNode.parentNode)" value="${reservation.end_time}"></td>
												</tr>
											</table>
										</td>
										<td width="70px">
											<p class="price-text no-top_bottom_margin">${reservation.totalPrice}원</p>
											<input type="hidden" name="groupSeat_unit_totalPrice" value="${reservation.totalPrice}">
										</td>
										<td width="28px"><input type="button" class="orderModifyButton" value="변경"></td>
										<td width="28px"><input type="button" class="orderDeleteButton" value="취소"></td>
										
									</tr>
								</c:forEach>
							</table>
							</c:if>
						</div>
						
					</form>
					<div id="mileageTableContainer" class="align-center">
						<div style="width:908px;" class="align-left">
							<table align="right">
								<tr><td colspan="2"><h3><b>마일리지조회</b></h3></td></tr>
								<tr>
									<td>현재보유점수</td>
									<td><input type="text" id="current_mileage" class="mileageInput" value="${user_mileage}" readonly>점</td>
								</tr>
								<tr>
									<td>사용가능점수</td>
									<td><input type="text" id="current_available_mileage" class="mileageInput" value="${user_mileage}" readonly>점</td>
								</tr>
								<tr>
									<td>사용점수</td>
									<td><input type="text" id="mileage_to_use" class="mileageInput"  name="mileageToUse" value="0" onchange="onMileagePointChanged()" onblur="onMileagePointChanged()">점</td>
								</tr>
								<tr>
									<td>적립액</td>
									<td><input type="text" id="mileage_to_add" class="mileageInput" name="mileageToAdd" value="<fmt:formatNumber value='${allTotalPrice*0.001}' pattern='0'/>" readonly>점</td>
								</tr>
								<tr>
									<td>마일리지사용/적립</td>
									<td><input type="checkbox" id="checkSaveMileage" name="isMileageAdd" onchange="onMileageCheckboxChanged(this)"></td>
								</tr>
							</table>
						</div>
					</div>
					<div class="align-center">
						<div style="width:1000px;" class="align-right">
							<h3 id="totalCost">총 ${allTotalPrice}원</h3>
							<input type="hidden" id="allTotalPrice" name="allTotalPrice" value="${allTotalPrice}">
						</div>
					</div>
					<div id="payWrapper">
							<%-- <input id="kakaopayButton" type="button" value="카카오페이결제" onclick="addMultipleOrder('${contextPath}')">
							<input id="naverpayButton" type="button" value="네이버페이결제" onclick="addMultipleOrder('${contextPath}')"> --%>
							<input id="naverpayButton" type="button" value="결제확정" onclick="addMultipleOrder('${contextPath}')">
					</div>	
				</div>
			</div>
		</section>
	</body>
</html>