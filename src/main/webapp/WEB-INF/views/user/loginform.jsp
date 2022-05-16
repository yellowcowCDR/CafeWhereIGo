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
		<title>카페어디가-로그인</title>
		
		<!-- Google Font -->
	    <!-- <link rel="preconnect" href="https://fonts.googleapis.com">
	    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
	    <link href="https://fonts.googleapis.com/css2?family=Jua&display=swap" rel="stylesheet"> -->
	   
		<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
	    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
	    
		<style>
			.mainContainer{
				width:100%;
				display:flex;
				justify-content:center;
				margin-top:80px;
			}
			.loginFormContainer{
				width:400px;
				margin-bottom:50px;
			}
			.loginFormWrapper{
				width:100%;
				border: 1px solid #b9b9b9;
				border-radius: 7px;
			}
			.loginFormContainer-inner{
				width:87%;
				margin:25px;
			}
			.page_title {
			    font-family: 'Jua', sans-serif;
			    font-size:35px;
			    color:black;
			}
			.login-input{
				width:100%;
				height:35px;
				border:1px solid #b9b9b9;
				border-radius:5px;
			}
			.submit-button{
				margin-top:10px;
				width:100%;
				background-color:#1F364B;
				border:1px solid #b9b9b9;
				border-radius:5px;
			}
			.submit-button-text{
				font-family: 'Jua', sans-serif;
			    font-size:20px;
			    color:white;
			}
			.loginform{
				width:100%;
			}
			.input-table{
				width:100%;
			}
			hr{
				width:100%;
			}
			hr.dashed {
			  border-top: 3px dashed #bbb;
			}
			
			/* Dotted border */
			hr.dotted {
			  border-top: 3px dotted #bbb;
			}
			
			/* Solid border */
			hr.solid {
			  border-top: 1px solid #787878;
			}
			
			/* Rounded border */
			hr.rounded {
			  border-top: 8px solid #bbb;
			  border-radius: 5px;
			}
			
			.sns-login-button{
				width:100%;
				/* background-color:#1F364B; */
				 border:1px solid #ffffff; 
				border-radius:5px;
				color:white;
				font-family: 'Jua', sans-serif;
			    font-size:20px;
			}
			.sns-kakao-login-button{
				background-color:#FAE100;
				margin-bottom:2px;
			}
			.sns-naver-login-button{
				background-color:#19CE60;
			}
		</style>
	</head>
	
	<body>
	
		
		<section class="mainContainer">
			<div class="loginFormContainer">
				<h1 class="page_title">로그인</h1>
				<div class="loginFormWrapper">
					<div class="loginFormContainer-inner">
						<form class="loginform" action="${contextPath}/user/login.do" method="POST">
							<table class="input-table">
								<tr>
									<td><input type="text" class="login-input" name="user_id" placeholder="ID입력" required></td>							
								</tr>
								<tr>							
									<td><input type="password" class="login-input" name="user_pw" placeholder="비밀번호입력" required></td>
								</tr>
								<tr>
									<td><input type="submit" class="submit-button submit-button-text" value='로그인'></td>
								</tr>
							</table>
						</form>
						<hr class="solid">
						<button class="sns-login-button sns-kakao-login-button">카카오로그인</button>
						<button class="sns-login-button sns-naver-login-button">네이버로그인</button>
					</div>
				</div>
			</div>
		</section>
	</body>
</html>