<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"	isELIgnored="false"
	%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="contextPath"  value="${pageContext.request.contextPath}"  />
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>카페어디가-메인페이지</title>
		
		<!-- Google Font -->
	    <link rel="preconnect" href="https://fonts.googleapis.com">
	    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
	    <link href="https://fonts.googleapis.com/css2?family=Jua&display=swap" rel="stylesheet">
	    
		<style>
			.body_container{
				margin:50px;
			}
		
			.cafe-theme-section{
				margin-top:50px;
			}
			.cafe-theme-card-first{
				height:300px;
				margin-right:15px;
			}
			.cafe-theme-card-second{
				height:300px;
				margin-left:15px;
				margin-right:15px;
			}
			.cafe-theme-card-third{
				height:300px;
				margin-left:15px;
			}
			.cafe-theme-card-list{

			}
			.cafe-theme-card-title{
				font-family: 'Jua', sans-serif;
			    font-size:35px;
			    color:white;
			}
			.cafe-theme-card-img{
				height:300px;
			}
			.cafe-theme-card-img-overlay{
				height:300px;
			}
			.today-cafe-slide{
				height:300px;
				margin-top:50px;
				margin-bottom:50px;
			}
			.today-cafe-slide-img{
				height:300px;
			}
			
		</style>
		<script>
			window.onload=function(){
				<c:if test="${msgList != null}">
					<c:forEach var="msg" items="${msgList}">			
							alert("${msg}");
					</c:forEach>
				</c:if>
			}
		</script>
		
	</head>
	<body>
		<section class="body_container">
			<section class="d-flex justify-content-between cafe-theme-section">
				<a href="http://www.daum.net">
					<div class="card bg-dark text-white cafe-theme-card-first">
					  <img src="${contextPath}/resources/image/cafe1.jpg" class="card-img cafe-theme-card-img" alt="...">
					  <div class="card-img-overlay">
					    <h5 class="card-title cafe-theme-card-title">#뷰가좋은카페</h5>
					  </div>
					</div>
				</a>
				<a href="http://www.daum.net">
					<div class="card bg-dark text-white cafe-theme-card-second">
					  <img src="${contextPath}/resources/image/cafe1.jpg" class="card-img cafe-theme-card-img" alt="...">
					  <div class="card-img-overlay">
					    <h5 class="card-title cafe-theme-card-title">#커피장인</h5>
					  </div>
					</div>
				</a>
				<a href="http://www.daum.net">
					<div class="card bg-dark text-white cafe-theme-card-third">
					  <img src="${contextPath}/resources/image/cafe1.jpg" class="card-img cafe-theme-card-img" alt="...">
					  <div class="card-img-overlay">
					    <h5 class="card-title cafe-theme-card-title">#맛있는디저트</h5>
					  </div>
					</div>
				</a>
			</section>
			<section>
				<div id="carouselExampleIndicators" class="carousel slide today-cafe-slide" data-bs-ride="carousel">
					<div class="card-img-overlay">
				    	<h5 class="card-title cafe-theme-card-title">#오늘의 카페</h5>
				 	</div>
					<div class="carousel-indicators">
					  <button type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide-to="0" class="active" aria-current="true" aria-label="Slide 1"></button>
					  <button type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide-to="1" aria-label="Slide 2"></button>
					  <button type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide-to="2" aria-label="Slide 3"></button>
					</div>
					<div class="carousel-inner">
					  <div class="carousel-item active">
					  	<a href="http://www.daum.net">
							<img src="${contextPath}/resources/image/today-cafe1.jpg" class="d-block w-100 today-cafe-slide-img" alt="...">
						</a>
					  </div>
					  <div class="carousel-item">
					  	<a href="http://www.daum.net">
							<img src="${contextPath}/resources/image/today-cafe1.jpg" class="d-block w-100 today-cafe-slide-img" alt="...">
						</a>
					  </div>
					  <div class="carousel-item">
					  	<a href="http://www.daum.net">
							<img src="${contextPath}/resources/image/today-cafe1.jpg" class="d-block w-100 today-cafe-slide-img" alt="...">
						</a>
					  </div>
					</div>
					<button class="carousel-control-prev" type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide="prev">
						<span class="carousel-control-prev-icon" aria-hidden="true"></span>
						<span class="visually-hidden">Previous</span>
					</button>
					<button class="carousel-control-next" type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide="next">
						<span class="carousel-control-next-icon" aria-hidden="true"></span>
						<span class="visually-hidden">Next</span>
					</button>
				</div>
			</section>
		</section>
	</body>
</html>