<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    isELIgnored="false"  
%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="contextPath"  value="${pageContext.request.contextPath}"  /> 
<c:set var="requestURI" value="${pageContext.request.requestURL}"/>
<c:set var="article" value="${articleMap['article']}"/>
<c:set var="articlePhotoList" value="${articleMap['articlePhotoList']}"/>
<c:set var="replies" value="${articleMap['replies']}"/>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>카페어디가-오늘의카페</title>
		<!-- BootStrap -->
	    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
	    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
		<script src="https://code.jquery.com/jquery-3.6.0.js" integrity="sha256-H+K7U5CnXl1h5ywQfKtSj8PCmoN9aaq30gDh27Xc0jk=" crossorigin="anonymous"></script>
		<link rel="preconnect" href="https://fonts.googleapis.com">
	    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
	    <link href="https://fonts.googleapis.com/css2?family=Jua&display=swap" rel="stylesheet">
		<script type="text/javascript" src="${contextPath}/resources/js/article/article.js"></script>
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
				width: 99%;
				height: 400px;
				-ms-overflow-style: none;
				margin-left:10px;
				margin-right:10px;
				margin-top:10px;
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
				object-fit:cover;
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
				margin-bottom:20px;	
			}
			.reply_body{
				margin-left:5px;
			}
			.article_body_photo{
				max-width:100%;
				display:block;
				margin-bottom:10px;
			}
			
			.dropbtn {
				background-color:white;
				padding: 0px;
				font-size: 30px;
				font-weight:bold;
				border: none;
				cursor: pointer;
							  
			}
			
			.dropdown {
				width: 30px;
				position: relative;
				display: inline-block;
				
			}
			
			.dropdown-content {
			  display: none;
			  position: absolute;
			  min-width: 90px;
			  overflow: auto;
			  box-shadow: 0px 8px 16px 0px rgba(0,0,0,0.2);
			  /* border: 1px solid #b9b9b9; */
			  background-color:white;
			  z-index: 999;
			  
			}
			
			.dropdown-content a {
			  color: black;
			  padding: 12px 0px;
			  text-decoration: none;
			  display: block;
			}

			.show {display: block;}
			
			.dropdown_icon{
				height: 100%;
				
			}
			.no-top-bottom-margin{
				margin-top:0px;
				margin-bottom:0px;
			}
		</style>
		<script>
			var article_writer_id = "${article.user_user_id}"
			
			<c:if test="${loginSession ne null}">
				var isLike = ${isLiked};
				
				window.onload=function(){
					var likeIcon = document.getElementById("thumbs_up_icon");
					
					var title = document.getElementById("article_subject").textContent;
					if(isLike){
						likeIcon.src="${contextPath}/resources/image/thumbs_up_icon_blue.svg";			
					}
					else{
						likeIcon.src="${contextPath}/resources/image/thumbs_up_icon_empty.svg";
					}
				}
			</c:if>
			
				function onLikeClick(){
					<c:if test="${loginSession != null}">
						var likeIcon = document.getElementById("thumbs_up_icon");
						var user_id= "${loginSession.user_id}";
						var article_id ="${article.article_id}";
						if(!isLike){					
							$.ajax({
								method: "POST",
								data: {"user_id": user_id, "article_id": article_id},
								url: "${contextPath}/todaysCafe/like.do",
								success: function(data){
									likeIcon.src="${contextPath}/resources/image/thumbs_up_icon_blue.svg";
									isLike=true;
								},
								error:function(jqXHR, textStatus, errorThrown){
									alert("좋아요에 실패하였습니다. 에러코드 "+jqXHR.status);	
								}
							});
						}
						else{
							
							$.ajax({
								method: "POST",
								data: {"user_id": user_id, "article_id": article_id},
								url: "${contextPath}/todaysCafe/like.do",
								success: function(data){
									likeIcon.src="${contextPath}/resources/image/thumbs_up_icon_empty.svg";
									isLike=false;
								},
								error:function(jqXHR, textStatus, errorThrown){
									alert("좋아요 취소에 실패하였습니다. 에러코드 "+jqXHR.status);	
								}
							});
						}
					</c:if>
					<c:if test="${loginSession == null}">
						alert("로그인 후 이용해주세요");
					</c:if>
				}
			
			
			function addReply(){
				<c:if test="${loginSession != null}">
					var replyTextInput = document.getElementById("replyTextInput");
					var replyText = replyTextInput.value;
					var user_id= "${loginSession.user_id}";
					var article_id ="${article.article_id}";
					
					$.ajax({
						method: "POST",
						data: {"user_id": user_id, "article_id": article_id, "replyText": replyText},
						url: "${contextPath}/todaysCafe/addReply.do",
						success: function(data){
							location.reload();
						},
						error:function(jqXHR, textStatus, errorThrown){
							alert("댓글 등록에 실패하였습니다. 에러코드 "+jqXHR.status);	
						}
					});
				</c:if>
				<c:if test="${loginSession==null}">
					alert("로그인 후 이용해주세요");
				</c:if>
			}
			
			
			function dropdownClicked(event){
				document.getElementById("myDropdown").classList.toggle("show");
			}
			window.onclick = function(event) {
				  if (!event.target.matches('.dropbtn')) {
				    var dropdowns = document.getElementsByClassName("dropdown-content");
				    var i;
				    for (i = 0; i < dropdowns.length; i++) {
				      var openDropdown = dropdowns[i];
				      if (openDropdown.classList.contains('show')) {
				        openDropdown.classList.remove('show');
				      }
				    }
				  }
				}
			function goToModifyForm(){
				<c:if test="${loginSession != null}">
					if("${loginSession.user_id}" == article_writer_id){
						var url = "${contextPath}/todaysCafe/modifyArticleForm.do?article_id=${article.article_id}"	
						location.href=url;
					}else{
						alert("작성자만 수정할 수 있습니다");
					}
				</c:if>
				<c:if test="${loginSession == null}">
					alert("로그인 후 이용해주세요");
				</c:if>
			}
			function articleDelete(){
				<c:if test="${loginSession != null}">
					if("${loginSession.user_id}" == article_writer_id){
						var url = "${contextPath}/todaysCafe/deleteArticle.do?article_id=${article.article_id}"	
						location.href=url;
					}else{
						alert("작성자만 삭제할 수 있습니다");
					}
				</c:if>
				<c:if test="${loginSession == null}">
					alert("로그인 후 이용해주세요");
				</c:if>
			}
		</script>
	</head>
	
	<body>
		<section id="mainContainer">
			<div id="mainContentWrapper">
				<h1 id="pageTitle">오늘의카페</h1>
				<div id="formWrapper">
					
						<div id="formContentWrapper">
							<div id="top_formWrapper">
								<div id="article_subject_wrapper">
									<h6 id="article_subject">[${article.cafe_name}] ${article.article_title}</h6>
									<a href="javascript:onLikeClick()"><img id="thumbs_up_icon" src="${contextPath}/resources/image/thumbs_up_icon_empty.svg"></a>
									<p class="text_color_gray">좋아요 ${likedCount}</p>
								</div>
								<div id="top_formWrapper_inner">
									<p>${article.user_user_id}</p>
									<p class="text_color_gray dateinfo"><fmt:formatDate value="${article.created_date}" pattern="YYYY.MM.dd"/> 작성</p>
									<p class="text_color_gray">조회수 ${article.view_count}</p>
									<div class="dropdown">
										<button class="dropbtn" onclick="dropdownClicked(event)">⋮</button>
										<div id="myDropdown" class="dropdown-content">
										  <a href="#" onclick="goToModifyForm();">수정</a>
										  <a href="#" onclick="articleDelete();">삭제</a>
										</div>
									</div>
								</div>
						
							</div>
							<hr id="add_aricle_hr">
							<div id="article_body">
								<c:forEach var="article_body_text" items="${article_body_texts}">
									<p class="no-top-bottom-margin">${article_body_text}</p>
								</c:forEach>
								<div id="image_wrapper">
									<c:forEach var='articlePhoto' items="${articlePhotoList}">
										<img src="${contextPath}/article/download.do?article_id=${article.article_id}&fileName=${articlePhoto.filename}" class="article_body_photo" alt="Aritcle Photo"/>
									</c:forEach>
								</div>
							</div>
						</div>
						<div id="replyFormWrapper">
							<table id="replyTable">
								<c:forEach var="reply" items="${replies}" varStatus ="status">
									
									<tr>
										<td class="profile_picture_td">
											<img class="profile_picture" src="${contextPath}/user/download.do?user_id=${reply.user_user_id}" onerror="this.src='${contextPath}/resources/image/blank-profile-picture.svg'">
										</td>
										<td style="width:166px" class="reply_writer_id_td">
											<p class="reply_writer_id">${reply.user_user_id}</p>
										</td>
										<td style="width:1360px" class="reply_body_td">
											<p class="reply_body">${reply.reply_content}</p>
										</td>
										<td style="width:45px" class="reply_modify_button_td">
											<c:if test="${loginSession != null}">
												<c:if test="${loginSession.user_id== reply.user_user_id}">
													<button class="replyModifyButton" onclick="changeToModifyReplyForm(this.parentNode.parentNode,'${reply.user_user_id}','${loginSession.user_id}')">수정</button>
												</c:if>
												<c:if test="${loginSession.user_id!= reply.user_user_id}">
													<button class="replyModifyButton" onclick="alert('작성자만 수정할 수 있습니다')">수정</button>
												</c:if>
											</c:if>
											
											<c:if test="${loginSession == null}">
												<button class="replyModifyButton" onclick="alert('로그인 후 이용해주세요')">수정</button>
											</c:if>
										</td>
										<td style="width:45px" class="reply_delete_button_td">
											<c:if test="${loginSession != null}">
												<c:if test="${loginSession.user_id== reply.user_user_id}">
													<button class="replyDeleteButton" onclick="deleteReply(this.parentNode.parentNode)">삭제</button>
												</c:if>
												<c:if test="${loginSession.user_id!= reply.user_user_id}">
													<button class="replyDeleteButton" onclick="alert('작성자만 삭제할 수 있습니다')">삭제</button>
												</c:if>
											</c:if>
											<c:if test="${loginSession == null}">
												<button class="replyDeleteButton" onclick="alert('로그인 후 이용해주세요')">삭제</button>
											</c:if>
										</td>
										<td style="width:0px">
							                <input type="hidden" name="reply_id" value="${reply.reply_id}">
							            </td>
									</tr>
								</c:forEach>
							</table>
						</div>
					
						<div id="addReplyFormWrapper">
							<input style="width:93%" id="replyTextInput" name="replyTextInput" type="text">
							<input style="width:7%" id="replyAddButton" type="button" value="글쓰기" onclick="addReply()">
						</div>
				</div>	
			</div>
		</section>
	</body>
</html>