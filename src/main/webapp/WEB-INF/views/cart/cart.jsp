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
		<title>카페어디가-장바구니</title>
		
		<!-- BootStrap -->
	    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
	    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
		
		<link rel="preconnect" href="https://fonts.googleapis.com">
	    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
	    <link href="https://fonts.googleapis.com/css2?family=Jua&display=swap" rel="stylesheet">
		
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
			#tableTitle{
				font-family: 'Jua', sans-serif;
				color:white;	
				margin-left:5px;
				margin-top:5px;
				margin-bottom:5px;	
			}
			#orderTable{
				width:908px;
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
			#orderCancel{
				width:908px;
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
		</style>
	</head>
	
	<body>
		<section id="mainContainer">
			<div id="mainContentWrapper">
				<h1 id="pageTitle">장바구니</h1>
				<div id="formWrapper">
					
					<form>
						<div id="formContentWrapper">
							<div id="orderCancelContainer"> 
								<div align="center" id="orderCancel" class="align-right">
									<button class="blueButton">선택한 주문/예약취소</button>
								</div>	
							</div>
							<table align="center" id="orderTable">
								<tr class="tableHeaderRow">
									<th colspan="9" class="tableHeader">
										<div class="tableTitleWrapper">
											<h4 id="tableTitle" class="no-margin">주문</h4>
										</div>
									</th>
								</tr>
								<tr>
									<td width="13px"><input class="checkboxInput" type="checkbox"></td>
									<td width="80px"><img class="product_image" src="${contextPath}/resources/image/americano.jpeg"></td>
									<td width="420px">
										<div>
											<h3 class="productName no-top_bottom_margin margin-left-10px">아메리카노(ice)</h3>
											<p class="productDescription no-top_bottom_margin margin-left-10px">아라비카산 원두로 로스팅하여 만든 아메리카노</p>
										</div>
									</td>
									<td width="70px"><p class="no-top_bottom_margin">3500원</p></td>
									<td width="45px"><p class="no-top_bottom_margin">수량</p></td>
									<td>
										<input class="numberInput" type="number" min=0 value=0>
									</td>
									<td width="70px"><p class="no-top_bottom_margin">3500원</p></td>
									<td width="28px"><input type="button" class="orderModifyButton" value="변경"></td>
									<td width="28px"><input type="button" class="orderDeleteButton" value="취소"></td>
									
								</tr>
							</table>
							<table align="center" id="reservationTable">
								<tr class="tableHeaderRow">
									<th colspan="7" class="tableHeader"><h4 id="tableTitle" class="no-margin">예약</h4></th>
								</tr>
								<tr>
									<td width="13px"><input class="checkboxInput" type="checkbox"></td>
									<td width="80px"><img class="product_image" src="${contextPath}/resources/image/danchaeseat.jpeg"></td>
									<td width="420px">
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
									<td width="28px"><input type="button" class="orderModifyButton" value="변경"></td>
									<td width="28px"><input type="button" class="orderDeleteButton" value="취소"></td>
									
								</tr>
							</table>
						</div>
						
					</form>
					<div class="align-center">
						<div style="width:908px;" class="align-right">
							<h3 id="totalCost">총 7000원</h3>
						</div>
					</div>
					<div id="payWrapper">
						<input id="orderButton" type="button" value="주문/예약확정">
					</div>	
				</div>
			</div>
		</section>
	</body>
</html>