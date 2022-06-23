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
		</style>
		
		<script>
			function select_profile_photo(){
				var profile_preview = document.getElementById("profile_photo_preview");
				var profile_photo = document.getElementById("profile_photo");
				profile_photo.click();
			}
			
			function phonenum_init(){
				var user_phone_number1_selector = document.getElementById("user_phone_number1");
				var phonenum1 = "${loginSession.phonenum1}";
				
				var phonenum_options=user_phone_number1_selector.children;
				
				for(var i=0; i<phonenum_options.length; i++){
					if(phonenum_options[i].value == phonenum1){
						phonenum_options[i].selected=true;
					}
				}
			}
			
			window.onload = function(){
				phonenum_init();
			};
			
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
									<a href="javascript:select_profile_photo();">
										<img class="profile_photo_preview" name="profile_photo_preview" src="${contextPath}/user/download.do?user_id=${loginSession.user_id}" onerror='this.src="${contextPath}/resources/image/blank-profile-picture.svg"'>
									</a>
								</div>
							<div class="input_container_outer">
							<div class="input_container">
								<div class="input_container_inner">
									<table id="userinfo_input_table">
										<tr>
											<td>
												<input type="file" id="profile_photo" name="profile_photo">
											</td>
										</tr>
										<tr>
											<td>
												<label class="register_label" for="user_id">ID</label>
											</td>
										</tr>
										<tr>
											<td>
												<input type="text" id="user_id" class="input_box" value=${loginSession.user_id} disabled>
											</td>
										</tr>
										<tr>
											<td>
												<input type="hidden" name="user_id_hidden" value="${loginSession.user_id}">
											</td>
										</tr>
										<tr>
											<td>
												<label class="register_label" for="user_pw">PW</label>
											</td>
										</tr>
										<tr>
											<td>
												<input type="password" id="user_pw" class="input_box">
											</td>
										</tr>
										<tr>
											<td>
												<label class="register_label" for="user_pw_repeat">PW 재입력</label>
											</td>
										</tr>
										<tr>
											<td>
												<input type="password" id="user_pw_repeat" class="input_box">
											</td>
										</tr>
										<tr>
											<td>
												<label class="register_label" for="user_name">이름</label>
											</td>
										</tr>
										<tr>
											<td>
												<input type="text" id="user_name" class="input_box" value=${loginSession.user_name}>
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
													<option value="017">017</option>
													<option value="018">018</option>
													<option value="019">019</option>
												</select>
												-
												<input class="phonenum-input" type="text" name="user_phone_num2" class="input_box" value="${loginSession.phonenum2}">
												-
												<input class="phonenum-input" type="text" name="user_phone_num3" class="input_box" value="${loginSession.phonenum3}">
											</td>
										</tr>
										<tr>
											<td>
												<label class="register_label" for="user_email">E-Mail</label>
											</td>
										</tr>
										<tr>
											<td>
												<input type="email" id="user_email" class="input_box" value="${loginSession.user_email}">
											</td>
										</tr>
										<tr>
											<td>
												<label class="register_label" for="mileageScore">사업자번호</label>
											</td>
										</tr>
										<tr>
											<td>
												<input type="text" id="bussiness_number_forView" class="input_box" value="${loginSession.company_registration_number}">
											</td>
										</tr>
										<tr>
											<td>
												<input type="hidden" name="user_authority" value="${loginSession.user_role}">
											</td>
										</tr>
									</table>
								</div>
							</div>
							</div>
							<div id="submit_button_wrapper">
								<input class="submit_button" type="submit" value="회원정보수정">
							</div>
							</div>
						</form>
					</div>
				</div>
			</div>
		</section>
	</body>
</html>