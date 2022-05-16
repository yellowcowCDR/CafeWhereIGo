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
		<title>카페어디가-카페검색</title>
		
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
			#inputLabel{
				font-family: 'Jua', sans-serif;
			    font-size:20px;
			    color:black;
			}
			#submitButton{
				background-color:#1F364B;
				font-family: 'Jua', sans-serif;
			    font-size:20px;
			    color:white;
			    border: 1px solid white;
			    border-radius:5px;
			}
			
			#searchKeword{
				width:130px;
			}
			.tiny_icon{
				height:20px;
				margin:0px;
			}
			.result_table{
				margin-top:5px;
				margin-bottom:10px;
				width:100%;
			}
			.result_table tr, .result_table th, .result_table td{
				border: 1px solid #b9b9b9;
			}
			.result_table tr{
							
			}
			.result_table th{
				background-color: #6e7580;
				color:white;
			}
			.result_table td *{
				margin:0px;
			}
			.result_table td img, .result_table td p{
				vertical-align:middle;
			}
			.pagination_wrapper{
				display:flex;
				justify-content:center;
			}
			#search_form_wrapper{
				display:flex;
				justify-content:center;
				margin-bottom:8px;
			}
			#search_form_wrapper *{
				margin-left:2px;
				margin-right:2px;
			}
			#searchKewordBox{
				width:400px;
				
			}
			#sortingOptions{
				margin-right:3px;
			}
			#add_article_button{
				background-color:#1F364B;
				font-family: 'Jua', sans-serif;
			    font-size:20px;
			    color:white;
			    border: 1px solid white;
			    border-radius:5px;
			}
			#searchButton{
				background-color:#1F364B;
				font-family: 'Jua', sans-serif;
			    font-size:20px;
			    color:white;
			    border: 1px solid white;
			    border-radius:5px;
			}
			.article_subject{
				text-decoration: none;
			}
		</style>
	</head>
	
	<body>
		<section id="mainContainer">
			<div id="mainContentWrapper">
				<h1 id="pageTitle">카페탐방후기</h1>
				<div>
					<div id="top_menu">
						<select id="sortingOptions">
							<option>게시일순</option>
							<option>좋아요많은순</option>
							<option>조회수많은순</option>
						</select>
						<a href="${contextPath}/cafeTourReview/addArticleForm.do"><button id="add_article_button">글쓰기</button></a>
					</div>
					<div id="tableWrapper">
						<table class="result_table">
							<tr>
								<th>No.</th>
								<th>제목</th>
								<th>작성자</th>
								<th>좋아요</th>
								<th>조회수</th>
								<th>게시일</th>
							</tr>
							<tr>
								<td>
									<p>1</p>
								</td>
								<td>
									<a class="article_subject" href="${contextPath}/cafeTourReview/detail.do">[카페 광안] 광안리에 있는 카페에 다녀왔습니다.</a>
								</td>
								<td>
									<p>dltnstls22</p>
								</td>
								<td>
									10K
								</td>
								<td>
									12K
								</td>
								<td>
									<p>2022.04.21</p>
								</td>
							</tr>
						</table>
						<form>
							<div id="search_form_wrapper">
								
									<select>
										<option>전체검색</option>
										<option>제목</option>
										<option>작성자</option>
									</select>
									<input id="searchKewordBox" type="text">
									<input id="searchButton" type="submit" value="검색">
							</div>
						</form>
						<div class="pagination_wrapper">
							<ul class="pagination pagination-sm">
							    <li class="page-item"><a class="page-link" href="#">Previous</a></li>
							    <li class="page-item"><a class="page-link" href="#">1</a></li>
							    <li class="page-item"><a class="page-link" href="#">2</a></li>
							    <li class="page-item"><a class="page-link" href="#">3</a></li>
							    <li class="page-item"><a class="page-link" href="#">4</a></li>
							    <li class="page-item"><a class="page-link" href="#">5</a></li>
							    <li class="page-item"><a class="page-link" href="#">Next</a></li>
							</ul>
						</div>
					</div>
				</div>
			</div>
		</section>
	</body>
</html>