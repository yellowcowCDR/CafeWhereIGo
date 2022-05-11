<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    isELIgnored="false"
    session="true"  
%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%-- <c:if test="${loginSession ne null}">
	<c:set var="isLogin" value="${true}"/>
</c:if>
<c:if test="${loginSession eq null}">
	<c:set var="isLogin" value="${false}"/>
</c:if> --%>
<c:set var="isLogin" value="${false}"/>
<c:set var="userAuthority" value="cafe_manager"/>
<c:set var="contextPath"  value="${pageContext.request.contextPath}"  />

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
		
		<!-- Google Font -->
	    <link rel="preconnect" href="https://fonts.googleapis.com">
	    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
	    <link href="https://fonts.googleapis.com/css2?family=Jua&display=swap" rel="stylesheet">
	    <!-- BootStrap -->
	    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
	    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
		<style>
			header{
				display:flex;
				align-items:center;
			}
			#trademark_container{
				margin-left:15px;
				display:flex;
				align-items:center;
				float:left;
			}
			#trademark_title, #trademark_img{
			    margin: 0px;
   				padding: 0px;
			}
			#trademark_title {
			    float: right;
			    font-family: 'Jua', sans-serif;
			    font-size:35px;
			    color:white;
			}
			#main_menu_container{
				display:flex;
				align-items:center;
				float:left;
			}
			.main_menu_ul{
				display:flex;
				align-items:center;
				list-style: none;
				margin:0;
			}
			.main_menu_li{
				display:flex;
				align-items:center;
			}
			.main_menu_li a{
				margin-left:10px;
			}
			.main_menu_button{
				color: white;
			    text-decoration: none;
			    font-family: 'Jua', sans-serif;
			    font-size: 26px;
			}
			.main_menu_button-underline{
				color: white;
			    font-family: 'Jua', sans-serif;
			    font-size: 26px;
			}
			.main_menu_button-underline:hover, .main_menu_button-underline:visited{
				color: white;
			}
			.main_menu_button:hover, .main_menu_button:visited{
				color: white;
			}
			.main_menu_text{
			}
			header{
				width:100%;
				height:60px;
				background-color: #1F364B;
			}
			#QuickSearchForm{
				margin-left:60px;
			}
			
			#memberContainer{
				margin-left:15px;
				float:right;
			}
			
			.member_ul{
				display:flex;
				align-items:center;
				list-style: none;
				margin:0;
				padding:0;
			}
			
			.menu_element{
				margin-left:15px;
			}
			.profile_img{
				width:40px;
				height:40px;
				object-fit: cover;
				background-color:white;
			}
			#header_navbar{
				position: fixed;
			}
			#header_navbar *{
				z-index:100;
			}
		</style>
		<script>
			console.log("loginSession is Null: "+"${loginSession eq null}");
			console.log("isLogin: "+"${isLogin}");
			console.log("user role: "+"${loginSession.user_role}");
		</script>
	</head>
	<body>
		<header id="header_navbar">
			<a href="${contextPath}/main/main.do">
				<div id="trademark_container">
	                <img id="trademark_img" src="${contextPath}/resources/image/cafe_white_24dp.svg" />
	                <h1 id="trademark_title">카페어디가?!</h1>
				</div>
			</a>
			<div id="main_menu_container">
				<ul class="main_menu_ul">
					<li class="main_menu_li">
						<a class="main_menu_button" href="${contextPath}/todaysCafe/search.do">오늘의카페</a>
					</li>
					<li class="main_menu_li">
						<a class="main_menu_button" href="${contextPath}/cafe/search.do">카페찾기</a>
					</li>
					<li class="main_menu_li">
						<a class="main_menu_button" href="${contextPath}/cafeEvent/search.do">이벤트</a>
					</li>
					<li class="main_menu_li">
						<a class="main_menu_button" href="${contextPath}/qna/search.do">Q&A</a>
					</li>
					<li class="main_menu_li">
						<a class="main_menu_button" href="${contextPath}/cafeTourReview/search.do">카페탐방후기</a>
					</li>
				</ul>
				<form id="QuickSearchForm" class="d-flex">
					<input class="form-control me-2" type="search" placeholder="카페찾기">
					<input class="btn btn-light" type="submit" value="검색">
				</form>
			</div>

			
			<div id="memberContainer" class="d-flex">
				<c:if test="${loginSession ne null}">
					<img class="profile_img" src="${contextPath}/user/download.do?user_id=${loginSession.user_id}" onerror="this.src='${contextPath}/resources/image/blank-profile-picture.svg'"/>
				</c:if>
				<c:if test="${loginSession eq null}">
					<img class="profile_img" src="${contextPath}/resources/image/blank-profile-picture.svg"/>
				</c:if>
				<div id="main_menu_container">
					<ul class="member_ul">
						<c:if test="${loginSession eq null}">
						<li class="main_menu_li">
							<a class="main_menu_button" href="${contextPath}/user/loginform.do">로그인</a>
						</li>
						<li class="main_menu_li">
							<a class="main_menu_button" href="${contextPath}/user/registerform.do">회원가입</a>
						</li>
						</c:if>
						<c:if test="${loginSession ne null}">
							<c:if test="${loginSession.user_role eq 'normal_user' }">
								<li class="main_menu_li">
									<a class="main_menu_button-underline"  href="${contextPath}/mypage/userinfo.do">${loginSession.user_id}님</a>
								</li>
							</c:if>
							<c:if test="${loginSession.user_role eq 'cafe_manager' }">
								<li class="main_menu_li">
									<a class="main_menu_button-underline"  href="${contextPath}/cafeManager/userinfo.do">${loginSession.user_id}님</a>
								</li>
							</c:if>
							<c:if test="${loginSession.user_role eq 'site_manager' }">
								<li class="main_menu_li">
									<a class="main_menu_button-underline"  href="${contextPath}/siteManager/userManagement.do">${loginSession.user_id}님</a>
								</li>
							</c:if>
							<li class="main_menu_li">
								<a class="main_menu_button" href="${contextPath}/user/logout.do">로그아웃</a>
							</li>
						</c:if>
					</ul>
				</div>
			</div>
		</header>
	</body>
</html>