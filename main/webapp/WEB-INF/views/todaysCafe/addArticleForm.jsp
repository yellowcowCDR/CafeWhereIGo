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
		<title>카페어디가-카페탐방후기</title>
		
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
			#mainContainer{
				width: 100%;
				display:flex;
				justify-content:center;
			}
			#mainContentWrapper{
				width:75%;
				margin-top:20px;
			}
			#search_condition_form_container{
				display:flex;
				justify-content:flex-end;
			}
			#pageTitle{
				font-family:'Malgun Gothic';
				font-weight: bold;
			    font-size:40px;
			    color:black;
			}
			#submitButton{
				width:100px;
				background-color:#1F364B;
				font-family: 'Jua', sans-serif;
			    font-size:20px;
			    color:white;
			    border: 1px solid white;
			    border-radius:5px;
			}
			
			.tiny_icon{
				height:20px;
				margin:0px;
			}
			#formWrapper{
				margin-top:50px;
			}
			#formContentWrapper{
				border: 1px solid #b9b9b9;
				margin-bottom:10px;
			}
			#top_formWrapper{
				display:flex;
			}
			#top_formWrapper_inner{
				display:flex;
				justify-content: flex-end;
				align-items:center;
				width:40%;
			}
			#top_formWrapper_inner *{
				margin:0px;
				
				margin-left:25px;
				margin-right:25px;
			}
			.text_input{
				border:none;
			}
			.text_input::placeholder{
				font-weight: bold;
				font-size:20px;
				color: #b9b9b9;
			}
			.article_subject{
				width: 60%;
				border-left: 1px solid #b9b9b9;
				border-right: 1px solid #b9b9b9;
			}
			.cafename{
				width:20%;
				margin-left:10px;
			}
			.text_input:focus{
				outline:none;
			}
			#textarea{
				width:100%;
				height:500px;
				border: none;
			}
			#textarea:focus{
				outline:none;
			}
			#add_aricle_hr{
				margin: 0px;
			}
			.text_color_gray{
				color: #b9b9b9;
			}
			#top_formWrapper #text_input{
				height:40px;
			}
			#top_formWrapper p{
				margin-top:0px;
				margin-bottom:0px;
			}
			#submitWrapper{
				display:flex;
				justify-content: center;
				
				margin-bottom: 10px;
			}
			.dateinfo{
				text-align:end;
			}
		</style>
	</head>
	
	<body>
		<section id="mainContainer">
			<div id="mainContentWrapper">
				<h1 id="pageTitle">오늘의카페</h1>
				<div id="formWrapper">
					<form>
						<div id="formContentWrapper">
							<div id="top_formWrapper">
								<input id="text_input" class="text_input cafename" type="text" placeholder="카페명" required>
								<input id="text_input" class="text_input article_subject" type="text" placeholder="글제목" required>
								<div id="top_formWrapper_inner">
									<p>dltnstls12</p>
									<p class="text_color_gray dateinfo">2022.04.21 작성</p>
								</div>
							</div>
							<hr id="add_aricle_hr">
							<div>
								<textarea id="textarea" rows="50"></textarea>
							</div>
						</div>
						<div id="submitWrapper">
							<input id="submitButton" type="submit" value="글쓰기">
						</div>
					</form>
				</div>
			</div>
		</section>
	</body>
</html>