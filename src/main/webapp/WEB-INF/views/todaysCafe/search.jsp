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
		<title>카페어디가-오늘의카페</title>
		
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
			#add_article_link{
				text-decoration: none;
			}
			#add_article_link{
				text-decoration: none;
			}
		</style>

		<script>
			function goArticelForm(){ 
				<c:if test="${loginSession ne null}">
				location.href="${contextPath}/todaysCafe/addArticleForm.do"
				</c:if>
				<c:if test="${loginSession eq null}">
				alert("로그인이 필요합니다.");
				location.href="${contextPath}/user/loginform.do"
				</c:if>
			}
			function onSortingOptionChanged(sortingOptions){
				var sortingOption = sortingOptions.value;
				console.log("sortingOption: " + sortingOption);
				var chapter = "${searchCondition.chapter}";
				var pageNum = "${searchCondition.pageNum}"
				
				location.href = "${contextPath}/todaysCafe/search.do?chapter="+chapter+"&pageNum="+pageNum+"&sortingOption="+sortingOption;
			}
			function initSortingOption(){
				let sortingOptionSeletor= document.getElementById("sortingOptions");
				let sortingOptions = sortingOptionSeletor.children;
				let sortingOption = "${searchCondition.sortingOption}";
			
				for(var i=0;i<sortingOptions.length; i++){
					if(sortingOptions[i].value == sortingOption){
						sortingOptions[i].selected=true;
					}
				}
				
			}
			function initSearchOption(){
				let searchConditionSeletor= document.getElementById("searchConditions");
				let searchConditions = searchConditionSeletor.children;
				let searchCondition = "${searchCondition.searchCondition}";
			
				for(var i=0;i<searchConditions.length; i++){
					if(searchConditions[i].value == searchCondition){
						searchConditions[i].selected=true;
					}
				}
			}
			function initSearchWord(){
				let searchKewordBox = document.getElementById("searchKewordBox");
				searchKewordBox.value= "${searchCondition.searchWords}";
			}
			window.onload = function(){
				initSortingOption();
				initSearchWord();
			}
		</script>
		
	</head>
	
	<body>
		<section id="mainContainer">
			<div id="mainContentWrapper">
				<h1 id="pageTitle">오늘의카페</h1>
				<div>
					<div id="top_menu">
						<select id="sortingOptions" name="sortingOption" onchange="onSortingOptionChanged(this);">
							<option value="recent">최근순</option>
							<option value="old">오래된순</option>
							<option value="like">좋아요많은순</option>
							<option value="view">조회수많은순</option>
						</select>
						<a id="add_article_link" href="javascript:goArticelForm()"><button id="add_article_button">글쓰기</button></a>
					</div>
					<div id="tableWrapper">
						<table class="result_table">
							<tr>
								<th width="50px">No.</th>
								<th>제목</th>
								<th width="150px">작성자</th>
								<th width="70px">좋아요</th>
								<th width="70px">조회수</th>
								<th width="90px">게시일</th>
							</tr>
							<c:forEach var="article" items="${articleList}">
								<tr>
									<td>
										<p>${article.search_result_no}</p>
									</td>
									<td>
										<a class="article_subject" href="${contextPath}/todaysCafe/detail.do?article_id=${article.article_id}">[${article.cafe_name}] ${article.article_title}</a>
									</td>
									<td>
										<p>${article.user_user_id}</p>
									</td>
									<td>
										<p>${article.likeCount}</p>
									</td>
									<td>
										<p>${article.view_count}</p>
									</td>
									<td>
										<p><fmt:formatDate value="${article.created_date}" pattern="YYYY.MM.dd"/></p>
									</td>
								</tr>
							</c:forEach>
						</table>
						<form>
							<div id="search_form_wrapper">
								
									<select id="searchConditions" name="searchCondition">
										<option value="all">전체검색</option>
										<option value="title">제목</option>
										<option value="writer">작성자</option>
									</select>
									<input id="searchKewordBox" name="searchWords" type="text">
									<input id="searchButton" type="submit" value="검색">
							</div>
						</form>
						<div class="pagination_wrapper">
							<ul class="pagination pagination-sm">
								<c:if test="${searchCondition.chapter<=1}">
							    	<li class="page-item disabled"><a class="page-link" href="#">Previous</a></li>
							    </c:if>
							    <c:if test="${searchCondition.chapter>1}">
							    	<li class="page-item"><a class="page-link" href="${contextPath}/todaysCafe/search.do?chapter=${searchCondition.chapter-1}&pageNum=5">Previous</a></li>
							    </c:if>
							    <c:forEach begin="1" end="5" step="1" varStatus="status">
							   		<li class="page-item"><a class="page-link" href="${contextPath}/todaysCafe/search.do?chapter=1&pageNum=${status.index}">${status.index}</a></li>
							    </c:forEach>
							    <li class="page-item"><a class="page-link" href="${contextPath}/todaysCafe/search.do?chapter=${searchCondition.chapter+1}&pageNum=1">Next</a></li>
							</ul>
						</div>
					</div>
				</div>
			</div>
		</section>
	</body>
</html>