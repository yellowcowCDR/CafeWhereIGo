/**
 * 
 */

function initSearchWords(){
	var searchWordsInput = document.getElementById("searchInputBox");
	searchWordsInput.value=prevSearchWords;
}

function initSearchCondition(){
	var searchConditionSelector = document.getElementById("searchOptionSelector");
	var searchOptions = searchConditionSelector.children;
	for(var i=0; i<searchOptions.length; i++){
		if(searchOptions[i].value == prevSearchCondition)
		{
			searchOptions[i].selected =true;
		}
	}
}

function initJoin_stateOption(){
	var joinStateSelector = document.getElementById("joinStateSelector");
	var joinStateOptions = joinStateSelector.children;
	for(var i=0; i<joinStateOptions.length; i++){
		if(joinStateOptions[i].value == prevJoin_stateOption)
		{
			joinStateOptions[i].selected =true;
		}
	}
}

function initSortingOption(){
	var sortingOptionSelector = document.getElementById("sortingOptionSelector");
	var sortingOptions = sortingOptionSelector.children;
	for(var i=0; i<sortingOptions.length; i++){
		if(sortingOptions[i].value == sortingOption)
		{
			sortingOptions[i].selected =true;
		}
	}
}

function searchUser(contextPath, chapter, pageNum){
	var sortingOptionSelector = document.getElementById("sortingOptionSelector");
	var sortingOptions = sortingOptionSelector.children;
	var sortingOption;
	for(var i=0; i<sortingOptions.length; i++){
		if(sortingOptions[i].selected){
			sortingOption = sortingOptions[i].value;
		}
	}
	
	var joinStateSelector = document.getElementById("joinStateSelector");
	var joinStateOptions=joinStateSelector.children;
	var joinState;
	for(var i=0; i<joinStateOptions.length; i++){
		if(joinStateOptions[i].selected){
			joinState = joinStateOptions[i].value;
		}
	}
	
	var searchOptionSelector = document.getElementById("searchOptionSelector");
	var searchOptions=searchOptionSelector.children;
	var searchOption;
	for(var i=0; i<searchOptions.length; i++){
		if(searchOptions[i].selected){
			searchOption = searchOptions[i].value;
		}
	}
	
	var searchWordBox = document.getElementById("searchInputBox");
	var searchWord = searchWordBox.value;
	
	
	//send Search Condition
	var searchForm = document.createElement("form");
	searchForm.method="post";
	searchForm.url=contextPath+"/siteManager/cafeManagerManagement.do";
	
	var formContent = 
		"<input type='hidden' name='sortingOption' value='"+sortingOption+"'>"+
		"<input type='hidden' name='join_state' value='"+joinState+"'>"+
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
function banUser(contextPath, userRow){
	var inputList = userRow.getElementsByTagName("input");
	var user_id = inputList.namedItem("user_id").value;
	var join_state_indicator = userRow.getElementsByClassName("join_status_td");
	$.ajax({
		type: "post",
		url: `${contextPath}/siteManager/banUser.do`,
		async: false,
		data: {
			"user_id":user_id,
		},
		success: function(data){
			alert("강제탈퇴 처리가 완료되었습니다.");
			var join_state = data["join_state"]
			
			if(join_state == "banned"){	
				join_state_indicator[0].innerHTML="강제탈퇴";
			}
		},
		error:function(jqXHR, textStatus, errorThrown){
			alert("강제탈퇴 처리에 실패하였습니다. 에러코드 "+jqXHR.status);	
		}
	});
}
function banSelectedUser(contextPath){
	
}
function reRegisterUser(contextPath, userRow){
	var inputList = userRow.getElementsByTagName("input");
	var user_id = inputList.namedItem("user_id").value;
	var join_state_indicator = userRow.getElementsByClassName("join_status_td");
	$.ajax({
		type: "post",
		url: `${contextPath}/siteManager/reRegisterUsers.do`,
		async: false,
		data: {
			"user_id":user_id,
		},
		success: function(data){
			alert("상태복귀 처리가 완료되었습니다.");
			var join_state = data["join_state"]
			
			if(join_state == "joined"){	
				join_state_indicator[0].innerHTML="회원가입";
			}
		},
		error:function(jqXHR, textStatus, errorThrown){
			alert("상태복귀 처리에 실패하였습니다. 에러코드 "+jqXHR.status);	
		}
	});
}