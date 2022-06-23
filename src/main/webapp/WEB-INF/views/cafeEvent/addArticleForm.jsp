<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    isELIgnored="false"  
%>
<%@ page import="java.util.Date" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="contextPath"  value="${pageContext.request.contextPath}"  /> 
<c:set var="now" value="<%=new Date() %>"/> 

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>카페어디가-이벤트</title>
		
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
			.article_subject{
				width: 60%;
			}
			.cafename{
				width:20%;
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
				margin-top: 20px;
				margin-bottom: 10px;
			}
			.dateinfo{
				text-align:end;
			}
			.previewImg{
				width:100px;
				height:100px;
				object-fit:scale-down;
				display:none;
			}
			#preview_img_wrapper{
				height: 200px;
				border:1px solid #b9b9b9;
				overflow-y:scroll;
			}
			.add_cafe_button{
				font-family: 'Jua', sans-serif;
				font-size:20px;
				margin-right:2px;
			}
			.no-text-decoration{
				text-decoration: none;
			}
			.link-text-always-black{
				color:black;
			}
			.icon{
				width:20px;
				height:20px;
			}
			.img_added{
				display:none;
			}
			.float-right{
				float:right;
			}
			
		</style>
		<script>
			var img_count=0;
			function on_profile_photo_changed(inputbox){
				
			}
			function add_img_input(){
				img_count++;
				
				var img_maximum_per_td=12;
				
				var preview_img_wrapper = document.getElementById("preview_img_wrapper");
				preview_img_wrapper.style.display="inherit";
				
				var img_input_table = document.getElementById("img_input_table");
				img_input_table.style.display="inherit";
				
				var preview_img_table = document.getElementById("preview_img_table");
				var preview_img_table_tbody = preview_img_table.children[0];
				
				var img_input_table = document.getElementById("img_input_table");
				var img_input_table_tbody = img_input_table.children[0];
				
				var img_tr = document.createElement("tr");
				var img_td = document.createElement("td");
				var img_input_box = document.createElement("input");
				
				var img_preview = document.createElement("img");
				img_preview.setAttribute("class","previewImg");
				
				
				/* var preview_img_row; */
				var preview_img_td_size = 0;
				var preview_img_td = document.createElement("td");
				
				var preview_img_row=undefined;
				
				if(preview_img_table_tbody==null || preview_img_table_tbody==undefined){
					preview_img_table_tbody = document.createElement("tbody");
					preview_img_table.appendChild(preview_img_table_tbody);
				}
				
				if(img_input_table_tbody==null || img_input_table_tbody==undefined){
					img_input_table_tbody = document.createElement("tbody");
					img_input_table.appendChild(img_input_table_tbody);
				}
				
				var preview_img_row_size = preview_img_table.children[0].children.length;
				var last_preview_img_row = preview_img_table.children[0].children[preview_img_row_size-1];
				
				if(preview_img_row_size>0){
					preview_img_table_tbody = preview_img_table.children[0];
					img_input_table_tbody = img_input_table.children[0];
					
					preview_img_td_size = last_preview_img_row.children.length;
					
					if(preview_img_td_size>=img_maximum_per_td){
						var number_of_img_total = (preview_img_row_size-1)*14 + preview_img_td_size;
						img_preview.setAttribute("id","img"+String(number_of_img_total+1)+"_preview");
						//preview tr 새로 만듦
						//preview tr id 부여
						preview_img_row = document.createElement("tr");
						preview_img_row.setAttribute("id","imgPreview_row"+String(preview_img_row_size+1))
						
						//preview td 새로 만듦
						//preview td id 부여
						preview_img_td.setAttribute("id","imgPreview"+String(number_of_img_total+1)+"_td")
						preview_img_row.appendChild(preview_img_td);
						//preview img 새로 만듦
						//preview img id 부여
						//preview img class 부여
						
						preview_img_td.appendChild(img_preview);
						preview_img_table_tbody.appendChild(preview_img_row);
					}else if(preview_img_td_size>0){
						/* preview_img_td = last_preview_img_row.children[preview_img_td_size-1]; */
						var number_of_img_total = (preview_img_row_size-1)*14 + preview_img_td_size;
						img_preview.setAttribute("id","img"+String(number_of_img_total+1)+"_preview");
						preview_img_td.appendChild(img_preview);
						preview_img_td.setAttribute("id","imgPreview"+String(number_of_img_total+1)+"_td");
						last_preview_img_row.appendChild(preview_img_td);
					}else{
						var number_of_img_total = (preview_img_row_size-1)*14 + preview_img_td_size;
						img_preview.setAttribute("id","img"+String(number_of_img_total+1)+"_preview");
						preview_img_td.appendChild(img_preview);
						preview_img_td.setAttribute("id","imgPreview"+String(number_of_img_total+1)+"_td");
						last_preview_img_row.appendChild(preview_img_td);
					}
				}else{
					img_preview.setAttribute("id","img"+String(1)+"_preview");
					preview_img_td.appendChild(img_preview);
					preview_img_td.setAttribute("id","imgPreview"+String(1)+"_td");
					var preview_img_row = document.createElement("tr")
					preview_img_row.setAttribute("id","imgPreview_row"+String(1))
					preview_img_row.appendChild(preview_img_td);
					preview_img_table_tbody.appendChild(preview_img_row);				
				}
				
				img_input_box.setAttribute("type","file");
				img_input_box.setAttribute("id","img"+String(img_count));
				img_input_box.setAttribute("name","img"+String(img_count));
				img_input_box.setAttribute("accept","image/*");
				img_input_box.setAttribute("onchange","add_img(this)");
				
				var img_delete_button = document.createElement("button");
				img_delete_button.innerText= "삭제";
				img_delete_button.setAttribute("id",img_input_box.id+"_delButtton");
				img_delete_button.setAttribute("onclick","del_img_input(this)");
				
				img_td.setAttribute("id","img"+String(img_count)+"_td");
				img_td.appendChild(img_input_box);
				img_td.appendChild(img_delete_button);
				
				img_tr.setAttribute("id","img_row"+String(img_count));
				img_tr.appendChild(img_td);
				
				img_input_table_tbody.appendChild(img_tr);
			}
			function del_img_input(inputButton){
				var inputButton_id = inputButton.id;//img1
				var temp = inputButton_id.split("_");
				
				var inputBox_id = temp[0];
				temp = inputBox_id.split("img");
				
				var img_tr_no = temp[1];
				var img_tr= document.getElementById("img_row"+img_tr_no);
				
				var preview_img = document.getElementById(inputBox_id+"_preview");
				var preview_td = document.getElementById("imgPreview"+img_tr_no+"_td");
				
				
				var preview_tr = preview_td.parentElement;
				
				img_tr.remove();
				preview_img.remove();
				if(preview_tr.children.length<=1){
					preview_tr.remove();
				}else{
					preview_td.remove();	
				}
				
				
				img_count--;
				
				previewImgOrderSort();
				imgInputOrderSort();
			}
			function add_img(inputBox){
				console.log("clicked");
				var inputbox_id = inputBox.id;//img1
				var preview_img = document.getElementById(inputbox_id+"_preview");
				preview_img.style.display="inherit";
				var fReader = new FileReader();
				fReader.readAsDataURL(inputBox.files[0]);
				fReader.onloadend=function(event){
					preview_img.src = event.target.result;
				}
			}
			function previewImgOrderSort(){
				var previewTrPrefix = "imgPreview_row";
				
				var previewTdPrefix = "imgPreview";
				var previewTdPostfix = "_td";
				
				var previewImgPrefix = "img";
				var previewImgPostfix = "_preview"
				
				var preview_img_table = document.getElementById("preview_img_table");
				var preview_img_table_tbody = preview_img_table.children[0];
				
				var NumberOfPreviewTr = preview_img_table_tbody.children.length;
				if (NumberOfPreviewTr>0){
					for(var i = 1; i<=NumberOfPreviewTr; i++){
						var previewTr = preview_img_table_tbody.children[i-1];
						previewTr.setAttribute("id", previewTrPrefix + String(i));
						
						var NumberOfPreviewTd =  previewTr.children.length;
						if(NumberOfPreviewTd>0){
							for(var j = 1; j<=NumberOfPreviewTd; j++){
								var previewTd = previewTr.children[j-1];
								previewTd.setAttribute("id", previewTdPrefix+String(j)+previewTdPostfix);
								var previewImg = previewTd.children[0];
								previewImg.setAttribute("id", previewImgPrefix+String(j)+previewImgPostfix);
							}
						}
					}
					
				}
				
				
			}
			function imgInputOrderSort(){
				var img_input_table = document.getElementById("img_input_table");
				var img_input_table_tbody = img_input_table.children[0];
				
				var imgInputTrPrefix = "img_row";
				
				var imgInputTdPrefix = "img";
				var imgInputTdPostfix = "_td";
				
				var imgInputPrefix = "img";
				
				var delButtonPrefix = "img";
				var delButtonPostfix = "_delButtton";
				
				var NumberOfImgInputTr = img_input_table_tbody.children.length;
				if (NumberOfImgInputTr>0){
					for(var i = 1; i<=NumberOfImgInputTr; i++){
						var imgInputTr = img_input_table_tbody.children[i-1];
						imgInputTr.setAttribute("id", imgInputTrPrefix + String(i));
						
						var NumberOfImgInputTd =  imgInputTr.children.length;
						if(NumberOfImgInputTd>0){
							var imgInputTd = imgInputTr.children[0];
							imgInputTd.setAttribute("id", imgInputTdPrefix+String(i)+imgInputTdPostfix);
						
							var imgInput = imgInputTd.children[0];
							imgInput.setAttribute("id", imgInputPrefix+String(i));
							imgInput.setAttribute("name", imgInputPrefix+String(i));
							
							var delButton = imgInputTd.children[1];
							delButton.setAttribute("id", delButtonPrefix+String(i)+delButtonPostfix);
							
						}
					}
					
				}
			}
		</script>
	</head>
	
	<body>
		<section id="mainContainer">
			<div id="mainContentWrapper">
				<h1 id="pageTitle">이벤트</h1>
				<div id="formWrapper">
					<form method="post" action="${contextPath}/cafeEvent/addArticle.do" enctype="multipart/form-data">
						<div id="formContentWrapper">
							<div id="top_formWrapper">
								<input id="text_input" name="cafe_name" class="text_input cafename" type="text" placeholder="카페명">
								<input id="text_input" name="article_title" class="text_input article_subject" type="text" placeholder="글제목" required>
								<div id="top_formWrapper_inner">
									<p>${loginSession.user_id}</p>
									<p class="text_color_gray dateinfo">
										<fmt:formatDate value="${now}" pattern="YYYY.MM.dd"/> 작성
									</p>
								</div>
							</div>
							<hr id="add_aricle_hr">
							<div>
								<textarea id="textarea" name="article_body" rows="50" cols="100"></textarea>
							</div>
						</div>
						<div style="display:flex; justify-content:flex-end; margin-top:30px;">
							<a href="#" class="add_cafe_button no-text-decoration link-text-always-black" onclick="add_img_input();return false;">
									<img style="margin-right:2px;" class="icon" src="${contextPath}/resources/image/cafe_add_icon.svg"/>사진추가
							</a>
						</div>
						<div id="preview_img_wrapper">
							<table id="preview_img_table">
				
							</table>
						</div>
						<table id="img_input_table">
							
						</table>
						<div id="submitWrapper">
							<input id="submitButton" type="submit" value="글쓰기">
						</div>
					</form>
				</div>
			</div>
		</section>
	</body>
</html>