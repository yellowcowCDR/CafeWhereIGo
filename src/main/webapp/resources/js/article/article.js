let reply_bk;

function changeToModifyReplyForm(reply_row, writer, current_user) {
   	if(writer!=current_user){
		alert("작성자만 수정할 수 있습니다");
	}else{
		// 클릭한 수정 버튼의 부모(tr) reply_body_td에 있는 기존 p 태그 제거
	    let reply_body_td = reply_row.children[2];
	    let reply_body = reply_body_td.children[0];
	    reply_bk = reply_body;
	    reply_body_td.removeChild(reply_body_td.children[0]);
	    // textarea element 생성
	    let text_input = document.createElement("input");
	    text_input.type = "text";
	    text_input.style.width = "100%";
	    text_input.value = reply_body.textContent;
	    // textarea를 reply_body_td의 자식으로 추가
	    reply_body_td.appendChild(text_input);
	    // 버튼 글자를 각각 등록, 취소로 변경
	    let reply_mod_button = reply_row.children[3].children[0];
	    let reply_del_button = reply_row.children[4].children[0];
	    reply_mod_button.innerText = "등록";
	    reply_mod_button.setAttribute("onclick", "commitModifyReply(this.parentNode.parentNode)");
	    reply_del_button.innerText = "취소";
	    reply_del_button.setAttribute("onclick", "cancelModifyReply(this.parentNode.parentNode)");
	    // 등록 버튼을 누르면 서버에 반영(reply_id를 이용)
	    // reply_id는 맨 끝 열에 hidden처리하여 포함할 것
	}
}

function commitModifyReply(reply_row) {
    let reply_body_td = reply_row.children[2];
    let text_input = reply_body_td.children[0];
    let reply_content = text_input.value;
    let reply_id_td = reply_row.children[5];
    let reply_id = reply_id_td.children[0].value;
    
    // 댓글 수정을 서버에 요청
    $.ajax({
		url:"/CafeWhereIGo/qna/modifyReply.do",
		method:"POST",
		data:{"reply_id": reply_id, "reply_content": reply_content},
		success:function(){
			location.reload();
		},
		error:function(jqXHR, textStatus, errorThrown){
			alert("댓글 수정에 실패하였습니다. 에러코드 "+jqXHR.status);	
		}
    })
    // 새로고침
}

function cancelModifyReply(reply_row) {
    let reply_body_td = reply_row.children[2];
    //input 태그를 p태그로 되돌림
    reply_body_td.removeChild(reply_body_td.children[0])
    reply_body_td.appendChild(reply_bk);
    // 수정/삭제버튼 원상복구
    let reply_mod_button = reply_row.children[3].children[0];
    let reply_del_button = reply_row.children[4].children[0];
    let reply_id_td = reply_row.children[5];
    let reply_id = reply_id_td.children[0].value;
    reply_mod_button.innerText = "수정";
    reply_mod_button.setAttribute("onclick", "changeToModifyReplyForm(this.parentNode.parentNode)");
    reply_del_button.innerText = "삭제";
    reply_del_button.setAttribute("onclick", "deleteReply(" + reply_id + ")");
}

function deleteReply(reply_row){
	let reply_id_td = reply_row.children[5];
    let reply_id = reply_id_td.children[0].value;
	var deleteRequestUrl = "/CafeWhereIGo/qna/deleteReply.do";
	$.ajax({
		url: deleteRequestUrl,
		method: "POST",
		data:{"reply_id":reply_id},
		success:function(){
			location.reload();
		},
		error:function(jqXHR, textStatus, errorThrown){
			alert("댓글 등록에 실패하였습니다. 에러코드 "+jqXHR.status);	
		}
	});
}

function searchArticle(contextPath, articleType, chapter, pageNum){
	var sortingOptionSelector = document.getElementById("sortingOptions");
	var sortingOptions = sortingOptionSelector.children;
	var sortingOption;
	for(var i=0; i<sortingOptions.length; i++){
		if(sortingOptions[i].selected){
			sortingOption = sortingOptions[i].value;
		}
	}
	
	
	var searchOptionSelector = document.getElementById("searchConditions");
	var searchOptions=searchOptionSelector.children;
	var searchOption;
	for(var i=0; i<searchOptions.length; i++){
		if(searchOptions[i].selected){
			searchOption = searchOptions[i].value;
		}
	}
	
	var searchWordBox = document.getElementById("searchKewordBox");
	var searchWord = searchWordBox.value;
	
	
	//send Search Condition
	var searchForm = document.createElement("form");
	searchForm.method="post";
	searchForm.url=contextPath+"/"+articleType+"/search.do";
	
	var formContent = 
		"<input type='hidden' name='sortingOption' value='"+sortingOption+"'>"+
		"<input type='hidden' name='searchCondition' value='"+searchOption+"'>"+
		"<input type='hidden' name='searchWords' value='"+searchWord+"'>"
		;
		
	if(chapter!=undefined && pageNum!=undefined){
		formContent +=
		"<input type='hidden' name='chapter' value='"+chapter+"'>"+
		"<input type='hidden' name='pageNum' value='"+pageNum+"'>"
	}
	searchForm.innerHTML=formContent;
	document.body.appendChild(searchForm);
	searchForm.submit();
}