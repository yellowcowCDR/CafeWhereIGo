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
				width:1700px;
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
			.replyModifyButton{
				background-color:#1F364B;
				font-family: 'Jua', sans-serif;
			    font-size:15px;
			    color:white;
			    border: 1px solid white;
			    border-radius:5px;
			}
			.replyDeleteButton{
				background-color:#E50F0F;
				font-family: 'Jua', sans-serif;
			    font-size:15px;
			    color:white;
			    border: 1px solid white;
			    border-radius:5px;
			}
			#replyAddButton{
				margin-left:10px;
				background-color:#1F364B;
				font-family: 'Jua', sans-serif;
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
				justify-content:space-between;
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
			#article_subject{
				font-weight: bold;
				font-size:20px;
				margin-left:10px;
				margin-top:10px;
				margin-bottom:10px;
				
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
			#replyFormWrapper{
				display:flex;
				width:100%;
				align-content:center;
				margin-bottom: 10px;
			}
			.dateinfo{
				text-align:end;
			}
			#article_body{
				overflow: scroll;
				width: 100%;
				height: 400px;
				-ms-overflow-style: none;
				
			}
			#article_body::-webkit-scrollbar{
				display:none; 
			}
			#article_subject_wrapper{
				display:flex;
				align-items:center;
			}
			#thumbs_up_icon{
				margin-left:10px;
				height:35px;
			}
			.profile_picture{
				height:25px;
				margin:0px;
			}
			.reply_writer_id_td{
				width:100px;
				
			}
			.reply_writer_id_td *{
				overflow:hidden;
				text-overflow: ellipsis;
			}
			.reply_writer_id{
				font-weight:bold;
				margin-left:5px;
			}
			#replyTable{
				width:99%;
				table-layout: fixed;
			}
			#replyTable tr td{
			 	height:25px;
				vertical-align: top;
			}
			.profile_picture_td{
				width:25px;
			}
			.reply_modify_button_td, .reply_delete_button_td{
				text-align: right;
			}
			#addReplyFormWrapper{
				width:100%;
				display:flex;			
			}
			.reply_body{
				margin-left:5px;
			}
		</style>
		<script>
			var isLike = false;
			function onLikeClick(){
				var likeIcon = document.getElementById("thumbs_up_icon");
				if(!isLike){
					likeIcon.src="${contextPath}/resources/image/thumbs_up_icon_blue.svg";
					isLike=true;
				}
				else{
					likeIcon.src="${contextPath}/resources/image/thumbs_up_icon_empty.svg";
					isLike=false;
				}
			}
		</script>
	</head>
	
	<body>
		<section id="mainContainer">
			<div id="mainContentWrapper">
				<h1 id="pageTitle">오늘의 카페</h1>
				<div id="formWrapper">
					
						<div id="formContentWrapper">
							<div id="top_formWrapper">
								<div id="article_subject_wrapper">
									<h6 id="article_subject">[카페 광안] 시원한 광안리 뷰를 자랑하는 카페</h6>
									<a href="javascript:onLikeClick()"><img id="thumbs_up_icon" src="${contextPath}/resources/image/thumbs_up_icon_empty.svg"></a>
									<p class="text_color_gray">좋아요 10K</p>
								</div>
								<div id="top_formWrapper_inner">
									<p>dltnstls12</p>
									<p class="text_color_gray dateinfo">2022.04.21 작성</p>
									<p class="text_color_gray">조회수 12K</p>
								</div>
							</div>
							<hr id="add_aricle_hr">
							<div id="article_body">
								
							</div>
						</div>
						<div id="replyFormWrapper">
							<table id="replyTable">
								<tr>
									<td class="profile_picture_td">
										<img class="profile_picture" src="${contextPath}/resources/image/blank-profile-picture.svg">
									</td>
									<td style="width:10%" class="reply_writer_id_td">
										<p class="reply_writer_id">dltnstlasdfasdfasdfSZDs12</p>
									</td>
									<td style="width:82%" class="reply_body_td">
										<p class="reply_body">와우.. 한번 가보고 싶네요.</p>
									</td>
									<td style="width:4%" class="reply_modify_button_td">
										<button class="replyModifyButton">수정</button>
									</td>
									<td style="width:4%" class="reply_delete_button_td">
										<button class="replyDeleteButton">삭제</button>
									</td>
								</tr>
							</table>
						</div>
						<form>
							<div id="addReplyFormWrapper">
								<input style="width:93%" id="replyTextInput" type="text">
								<input style="width:7%" id="replyAddButton" type="submit" value="글쓰기">	
							</div>
						</form>
				</div>	
			</div>
		</section>
	</body>
</html>