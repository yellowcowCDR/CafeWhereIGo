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
		<title>카페어디가-회원가입</title>
		<link rel="preconnect" href="https://fonts.googleapis.com">
	    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
	    <link href="https://fonts.googleapis.com/css2?family=Jua&display=swap" rel="stylesheet">
	    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
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
			.profile_img_preview{
				width: 230px;
				height: 230px;
				object-fit: scale-down;
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
			
			#profile_photo_file_input{
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
			}
			#radio_button_row{
				text-align:center;
			}
			.input_container_outer{
				width:100%;
				display:flex;
				justify-content:center;
			}		
			.business_number{
				display: none;
			}
			.no-top_bottom_margin{
				margin-top:0px;
				margin-bottom:0px;
						
			}
			#idOverlapCheckResult{
				font-size:15px;
			}
			#pwValidationResult{
				font-size:15px;
			}	
		</style>
		
		<script>
			var id_overapped=true;
			var pw_validated=false;
			function select_profile_photo(){
				var profile_preview = document.getElementById("profile_img_preview");
				var profile_photo = document.getElementById("profile_photo_file_input");
				profile_photo.click();
			}
			function on_profile_photo_changed(inputbox){
				var inputbox_id = inputbox.id;
				var inputbox_id_tokens = inputbox_id.split("_");
				var img_id = inputbox_id_tokens[0];
				var preview_img = document.getElementById(img_id+"_img_preview");
				var fReader = new FileReader();
				fReader.readAsDataURL(inputbox.files[0]);
				fReader.onloadend=function(event){
					preview_img.src = event.target.result;
				}
			}
			function onRadioButtonChange(src){
				var user_role = src.value;
				var business_number_elements=document.getElementsByClassName("business_number");
				var bussiness_number_inputbox = document.getElementById("bussiness_number_inputbox");
				
				if(user_role == "cafe_manager"){
					for(var i=0; i<business_number_elements.length; i++){
						business_number_elements[i].style.display="block";
					}
					bussiness_number_inputbox.style.width="100%";
					bussiness_number_inputbox.attributes.required=true;
					
				}
				else{
					for(var i=0; i<business_number_elements.length; i++){
						business_number_elements[i].style.display="none";
					}
					bussiness_number_inputbox.style.width="100%";
					bussiness_number_inputbox.attributes.required=false;
				}
				
			}
			function onIdInputChanged(inputbox){
				var id = inputbox.value;
				var overlappedText = "이미 사용중인 ID입니다.";
				var nonOverlappedText = "사용가능한 ID입니다.";
				var idOverlapCheckResult_label = document.getElementById("idOverlapCheckResult");
				
				console.log(id);
				if (id==""){
					idOverlapCheckResult_label.style.display="none";
				}else{
					idOverlapCheckResult_label.style.display="block";
					$.ajax({
						url:"${contextPath}/user/overlapped.do",
						async:true,
						method:"post",
						data:{
							user_id: id
						},
						dataType:"json",
						success: function(data){
							console.log("succeed to communicate..");
							console.log("result:"+data);
							if(data == false){
								$("#idOverlapCheckResult").text(nonOverlappedText);
								$("#idOverlapCheckResult").css("color","green");
								id_overapped=false;
							}else{
								$("#idOverlapCheckResult").text(overlappedText);
								$("#idOverlapCheckResult").css("color","red");
								id_overapped=true;
							}
							
						},
						error:function(data){
							console.log("falied to communicate..");
						}
					});
				}
			}
			function passwordValidation(){
				var user_pw = document.getElementById("user_pw");
				var user_pw_repeat = document.getElementById("user_pw_repeat");
				var pwValidationResult = document.getElementById("pwValidationResult");
				if(user_pw.value=="" && user_pw_repeat.value==""){
					pwValidationResult.style.display="none";
					pwValidationResult.innerText="";
					pw_validated=false;
				}else{
					if(user_pw.value==user_pw_repeat.value){
						pwValidationResult.style.display="none";
						pwValidationResult.innerText="";
						pw_validated=true;
					}else{
						pwValidationResult.style.display="block";
						pwValidationResult.innerText="비밀번호가 일치하지 않습니다.";
						pwValidationResult.style.color="red"
						pw_validated=false;
					}
				}
			}
			function registerUser(){
				var registerForm = document.getElementById("register_form");
				registerForm.action = "${contextPath}/user/registerUser.do" 
				//var inputFormList = document.getElementsByClass("input_box")
				registerForm.submit();
			}
		</script>
	</head>
	<body>
		<section id="register_section">
			<div class="content_wrapper">
				<h1 class="page_title">회원가입</h1>
				<div class="form_wrapper">
					<form id="register_form" enctype="multipart/form-data" method="post">
					<div class="form_wrapper-inner">		
							<div class="image_container">
								<a href="javascript:select_profile_photo();">
									<img id="profile_img_preview" class="profile_img_preview" name="profile_img" src="${contextPath}/resources/image/add_picture.svg">
								</a>
							</div>
						<div class="input_container_outer">
						<div class="input_container">
							<div class="input_container_inner">
								<table id="userinfo_input_table">
									<tr>
										<td>
											<input type="file" id="profile_photo_file_input" name="profile_photo_file_input" onchange="on_profile_photo_changed(this)">
										</td>
									</tr>
									<tr>
										<td>
											<label class="register_label" for="user_id">ID</label>
										</td>
									</tr>
									<tr>
										<td>
											<input type="text" id="user_id" name="user_id" class="input_box" onkeyup="onIdInputChanged(this)" required="필수입력항목입니다.">
										</td>
									</tr>
									<tr>
										<td>
											<p id="idOverlapCheckResult" class="no-top_bottom_margin" style="display:none;"></p>
										</td>
									</tr>
									<tr>
										<td>
											<label class="register_label" for="user_pw">PW</label>
										</td>
									</tr>
									<tr>
										<td>
											<input type="password" id="user_pw" name="user_pw" class="input_box" onKeyUp="passwordValidation()" required="필수입력항목입니다.">
										</td>
									</tr>
									<tr>
										<td>
											<label class="register_label" for="user_pw_repeat">PW 재입력</label>
										</td>
									</tr>
									<tr>
										<td>
											<input type="password" id="user_pw_repeat" class="input_box" onKeyUp="passwordValidation()" required="필수입력항목입니다.">
										</td>
									</tr>
									<tr>
										<td>
											<p id="pwValidationResult" class="no-top_bottom_margin" style="display:none;"></p>
										</td>
									</tr>
									<tr>
										<td>
											<label class="register_label" for="user_name">이름</label>
										</td>
									</tr>
									<tr>
										<td>
											<input type="text" id="user_name" name="user_name" class="input_box" required="필수입력항목입니다.">
										</td>
									</tr>
									<tr>
										<td>
											<label class="register_label">Phone</label>
										</td>
									</tr>
									<tr>
										<td>
											<select style="height:25px;" id="user_phone_num1" name="user_phone_num1">
												<option value="010">010</option>
												<option value="011">011</option>
												<option value="016">016</option>
												<option value="018">018</option>
											</select>
											-
											<input class="phonenum-input" type="text" name="user_phone_num2" class="input_box" required="필수입력항목입니다.">
											-
											<input class="phonenum-input" type="text" name="user_phone_num3" class="input_box" required="필수입력항목입니다.">
										</td>
									</tr>
									<tr>
										<td>
											<label class="register_label" for="user_email">E-Mail</label>
										</td>
									</tr>
									<tr>
										<td>
											<input type="email" id="user_email" name="user_email" class="input_box" required="필수입력항목입니다.">
										</td>
									</tr>
									<tr class="business_number">
										<td>
											<label class="register_label" for="bussiness_number_inputbox">사업자등록번호</label>
										</td>
									</tr>
									<tr class="business_number">
										<td>
											<input type="text" id="bussiness_number_inputbox" name="bussiness_number" class="input_box" placeholder="000-00-00000" required="필수입력항목입니다.">
										</td>
									</tr>
									<tr id="radio_button_row">
										<td>
											<label class="authority_level_select_label" for="normal_user">일반사용자</label>
											<input type="radio" id="normal_user_radiobutton" name="user_role" value="normal_user" checked onchange="onRadioButtonChange(this)">
											<label class="authority_level_select_label" for="cafe_manager">카페관리자</label>
											<input type="radio" id="cafe_manager_radiobutton" name="user_role" value="cafe_manager" onchange="onRadioButtonChange(this)">
										</td>
									</tr>
								</table>
							</div>
						</div>
						</div>
						<input type="hidden" name="sns_account" value="no">
						<div id="submit_button_wrapper">
							<input id="registerButton" class="submit_button" type="button" value="회원가입" onclick="registerUser()">
						</div>
						</div>
					</form>
				</div>
			</div>
		</section>
	</body>
</html>