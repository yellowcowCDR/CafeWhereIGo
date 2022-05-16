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
		<title>카페어디가-점포관리자</title>
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
			.profilePhoto_preview{
				width: 200px;
				height: 200px;
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
			
				width:900px;
				
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
			
			#profilePhoto{
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
			.address_input_box{
				width:80%;
				height:25px;
				border: 1px solid #b9b9b9;
				border-radius:5px;
			}
			.checkbox_label{
				font-family: 'Jua', sans-serif;
				margin-left:5px;
			}
			.product_image{
				width:90px;
				height:90px;
				object-fit: scale-down;
			}
			.tableTitle{
				font-family: 'Jua', sans-serif;
				color:white;	
				margin-left:5px;
				margin-top:5px;
				margin-bottom:5px;	
			}
			.no-top_bottom_margin{
				margin-top:0px;
				margin-bottom:0px;
				
			}
			#orderTable{
				margin-top:20px;
				width:95%;
			}
			#reservationTable{
				
				width:95%;
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
			.productName{
				font-family: 'Jua', sans-serif;
				font-size:27px;
				font-weight:bold;
			}
			.productDescription{
				font-weight: bold;
			}
			.tableTitleWrapper{
				display:flex;
				align-content:center;
			}
			.tableHeaderRow{
				background-color:#1F364B;
			}
			.add_button_wrapper{
				display:flex;
				justify-content:flex-end;
				width:95%;
			}
			.link-text-always-black{
				color:black;
			}
			.add_cafe_button{
				font-family: 'Jua', sans-serif;
				font-size:20px;
				margin-right:2px;
			}
			.icon{
				width:20px;
				height:20px;
			}
			.no-text-decoration{
				text-decoration: none;
			}
			.photo_file_input{
				display:none;
			}
		</style>
		
		<script>
			function select_profilePhoto(){
				var profile_preview = document.getElementById("profilePhoto_preview");
				var profilePhoto = document.getElementById("profilePhoto");
				profilePhoto.click();
			}
			function on_profilePhoto_changed(inputbox){
				var inputbox_id = inputbox.id;
				var inputbox_id_tokens = inputbox_id.split("_");
				var img_id = inputbox_id_tokens[0];
				var preview_img = document.getElementById(img_id+"_preview");
				var fReader = new FileReader();
				fReader.readAsDataURL(inputbox.files[0]);
				fReader.onloadend=function(event){
					preview_img.src = event.target.result;
				}
			}
			function select_goods_photo(img_link){
				var img_link_id = img_link.id;
				var product_photo_file_input = document.getElementById(img_link_id+"_photo_file_input");
				product_photo_file_input.click();
			}
			function on_goods_photo_changed(inputbox){
				var inputbox_id = inputbox.id;
				var inputbox_id_tokens = inputbox_id.split("_");
				var img_id = inputbox_id_tokens[0];
				var preview_img = document.getElementById(img_id+"_img");
				var fReader = new FileReader();
				fReader.readAsDataURL(inputbox.files[0]);
				fReader.onloadend=function(event){
					preview_img.src = event.target.result;
				}
			}
		</script>
	</head>
	<body>
		<section id="register_section">
			<div class="content_wrapper">
				<h1 class="page_title">점포관리자</h1>
				<div id="content_wrapper_inner">
					<div id="nav-left-menu-wrapper">
						<ul id="left-nav-ul">
							<li class="list-style-none"><a class="a-no-text-decoration a-color-black left-nav_font-style" href="${contextPath}/cafeManager/userinfo.do">회원정보</a></li>
							<li class="list-style-none"><a class="a-no-text-decoration a-color-black left-nav_font-style" href="${contextPath}/cafeManager/cafeManagement.do">점포관리</a></li>
							<li class="list-style-none"><a class="a-no-text-decoration a-color-black left-nav_font-style" href="${contextPath}/cafeManager/orderReservationList.do">주문/예약관리</a></li>
						</ul>
					</div>
					<div class="form_wrapper">
						<form id="register_form">
						<div class="form_wrapper-inner">		
								<div class="image_container">
									<a href="javascript:select_profilePhoto();">
										<img id="profilePhoto_preview" class="profilePhoto_preview" name="profilePhoto_preview" src="${contextPath}/resources/image/add_picture.svg">
									</a>
								</div>
							<div class="input_container_outer">
							<div class="input_container">
								<div class="input_container_inner">
									<table id="userinfo_input_table">
										<tr>
											<td>
												<input type="file" id="profilePhoto" name="profilePhoto" onchange="on_profilePhoto_changed(this)">
											</td>
										</tr>
										<tr>
											<td>
												<label class="register_label" for="cafe_name">점포명</label>
											</td>
										</tr>
										<tr>
											<td>
												<input type="text" id="cafe_name" class="input_box" disabled>
											</td>
										</tr>
										<tr>
											<td>
												<label class="register_label" for="address1">주소</label>
												
											</td>
										</tr>
										<tr>
											<td>
												<input type="text" id="address1" class="input_box" placeholder="주소">
											</td>
										</tr>
										<tr>
											<td>
												<input type="text" id="address1" class="input_box" placeholder="상세주소">
											</td>
										</tr>
										
										<tr>
											<td>
												<label class="register_label" for="user_name">이름</label>
											</td>
										</tr>
										<tr>
											<td>
												<input type="text" id="user_name" class="input_box">
											</td>
										</tr>
										<tr>
											<td>
												<label class="register_label">Phone</label>
											</td>
										</tr>
										<tr>
											<td>
												<select style="height:25px;" id="user_phone_number1" name="user_phone_num1">
													<option value="010">010</option>
													<option value="011">011</option>
													<option value="016">016</option>
													<option value="018">018</option>
												</select>
												-
												<input class="phonenum-input" type="text" name="user_phone_num2" class="input_box">
												-
												<input class="phonenum-input" type="text" name="user_phone_num3" class="input_box">
											</td>
										</tr>	
										<tr>
											<td>
												<label class="register_label" for="user_name">이용가능시설</label>
											</td>
										</tr>
										<tr>
											<td>
												<label class="checkbox_label">주차장</label>
												<input type="checkbox" value="parking_lot_exist">
												<label class="checkbox_label">콘센트</label>
												<input type="checkbox" value="plug_sokcet_exist">
												<label class="checkbox_label">Wi-Fi</label>
												<input type="checkbox" value="wifi_exist">
											</td>
										</tr>
									</table>
								</div>
							</div>
							</div>
							<table align="center" id="orderTable">
								<tr class="tableHeaderRow">
									<th colspan="9" class="tableHeader">
										<div class="tableTitleWrapper">
											<h4 class="tableTitle no-margin">카페소개</h4>
										</div>
									</th>
								</tr>
								<tr>
									<td><textarea rows="10" style="width:100%;"></textarea></td>
								</tr>
							</table>
							<table align="center" id="orderTable">
								<tr>
									<th colspan=3 style="text-align:right;">
										<a href="${contextPath}/cafeManager/addCafeForm.do" class="add_cafe_button no-text-decoration link-text-always-black">
											<img style="margin-right:2px;" class="icon" src="${contextPath}/resources/image/cafe_add_icon.svg"/>메뉴등록
										</a>
									</th>
								</tr>
								<tr class="tableHeaderRow">
									<th colspan="3" class="tableHeader">
										<div class="tableTitleWrapper">
											<h4 class="tableTitle no-margin">메뉴</h4>
										</div>
									</th>
								</tr>
								<tr>
									<td width="80px">
										<a id="menu1" href="#" onclick="select_goods_photo(this); return false;">
											<img class="product_image" id="menu1_img" src="${contextPath}/resources/image/add_picture.svg">
										</a>
										<input id="menu1_photo_file_input" class="photo_file_input" name="menu1_photo_file" type="file" onchange="on_goods_photo_changed(this)">
									</td>
									<td width="420px">
										<div>
											<input type="text" id="productName1" placeholder="상품명">
											<input type="text" id="productPrice1" placeholder="상품가격(원)">
											<textarea rows="2" style="width:100%; margin-top:5px" placeholder="상품설명"></textarea>
										</div>
									</td>									
									
									<td width="28px" style="text-align:center;"><input type="button" class="orderDeleteButton" value="취소"></td>
									
								</tr>
							</table>
							
							<table align="center" id="orderTable">
								<tr>
									<th colspan=3 style="text-align:right;">
										<a href="${contextPath}/cafeManager/addCafeForm.do" id="group_seat1" class="add_cafe_button no-text-decoration link-text-always-black">
											<img style="margin-right:2px;" class="icon" src="${contextPath}/resources/image/cafe_add_icon.svg"/>단체석등록
										</a>
									</th>
								</tr>
								<tr class="tableHeaderRow">
									<th colspan="3" class="tableHeader"><h4 class="tableTitle no-margin">단체석</h4></th>
								</tr>
								<tr>
									<td width="80px">
										<a id="groupSeat1" href="#" onclick="select_goods_photo(this); return false;">
											<img id="groupSeat1_img" class="product_image" src="${contextPath}/resources/image/add_picture.svg">
										</a>
										<input id="groupSeat1_photo_file_input" class="photo_file_input" name="groupSeat1_photo_file_input" type="file" onchange="on_goods_photo_changed(this)">
									</td>
									<td width="420px">
										<div>
											<input type="text" id="groupSeatName1" placeholder="상품명">
											<input type="text" id="groupSeatPrice1" placeholder="상품가격(원)">
											<textarea rows="2" style="width:100%; margin-top:5px" placeholder="상품설명"></textarea>
										</div>
									</td>
									<td width="28px" style="text-align:center;"><input type="button" class="orderDeleteButton" value="취소"></td>
									
								</tr>
							</table>
							<table align="center" id="orderTable">
								<tr>
									<th colspan=3 style="text-align:right;">
										<a href="${contextPath}/cafeManager/addCafeForm.do" class="add_cafe_button no-text-decoration link-text-always-black">
											<img style="margin-right:2px;" class="icon" src="${contextPath}/resources/image/cafe_add_icon.svg"/>사진추가
										</a>
									</th>
								</tr>
								<tr class="tableHeaderRow">
									<th colspan="3" class="tableHeader">
										<div class="tableTitleWrapper">
											<h4 class="tableTitle no-margin">사진</h4>
										</div>
									</th>
								</tr>
								<tr>
									<td width="80px">
										<a id="cafe1" href="#" onclick="select_goods_photo(this); return false;">
											<img class="product_image" id="cafe1_img" src="${contextPath}/resources/image/add_picture.svg">
										</a>
										<input id="cafe1_photo_file_input"  name="cafe1_photo_file" type="file" onchange="on_goods_photo_changed(this)">
									</td>
									<td width="28px" style="text-align:center;"><input type="button" class="orderDeleteButton" value="취소"></td>
									
								</tr>
							</table>
							<table align="center" id="orderTable">
								<tr>
									<th colspan=2 style="text-align:right;">
										<a href="${contextPath}/cafeManager/addCafeForm.do" class="add_cafe_button no-text-decoration link-text-always-black">
											<img style="margin-right:2px;" class="icon" src="${contextPath}/resources/image/cafe_add_icon.svg"/>주차장추가
										</a>
									</th>
								</tr>
								<tr class="tableHeaderRow">
									<th colspan="2" class="tableHeader">
										<div class="tableTitleWrapper">
											<h4 class="tableTitle no-margin">주차장정보</h4>
										</div>
									</th>
								</tr>
								<tr>
									<td width="80px">
										<table width="550px">
											<tr><td><h3 class="productName no-top_bottom_margin margin-left-10px">주차장1</h3></td></tr>
											<tr><td><input type="text" width="550px" class="address_input_box" placeholder="주차장명"></td></tr>
											<tr><td><input type="text" width="550px" class="address_input_box" placeholder="주소"><button onclick="return false;">주소찾기</button></td></tr>
											<tr><td><input type="text" width="100%" class="address_input_box" placeholder="상세주소"></td></tr>
												
										</table>
									</td>
									<td width="28px" style="text-align:center;"><input type="button" class="orderDeleteButton" value="취소"></td>
									
								</tr>
							</table>
							<div id="submit_button_wrapper">
								<input class="submit_button" type="submit" value="점포정보수정">
							</div>
							</div>
						</form>
					</div>
				</div>
			</div>
		</section>
	</body>
</html>