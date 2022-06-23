/**
 * 
 */
function changeBusinessStateToClose(contextPath, cafeRow){
	var doClose = window.confirm("휴업처리를 진행하시겠습니까?")
		if(doClose){
		var inputList = cafeRow.getElementsByTagName("input");
		var cafe_id = inputList.namedItem("cafe_id").value;
		
		var business_state_indicator = cafeRow.getElementsByClassName("business-state-indicator");
		$.ajax({
			method: "POST",
			data: {
				"cafe_id":cafe_id,
			},
			url: contextPath+"/cafe/shutdownCafe.do",
			success: function(data){
				alert("휴업처리가 완료되었습니다.");
				var business_state = data["business_state"]
				if(business_state == "close"){	
					business_state_indicator[0].innerHTML="휴업";
				}
			},
			error:function(jqXHR, textStatus, errorThrown){
				alert("휴업처리에 실패하였습니다. 에러코드 "+jqXHR.status);	
			}
		});
	}
}

function changeBusinessStateToCloseMutiple(contextPath){
	var doClose = window.confirm("휴업처리를 진행하시겠습니까?")
	if(doClose){
		var cafeRow = document.getElementsByName("cafeRow");
		var cafeIdJson ={}
		var addCnt=0;
		for(var i=0; i<cafeRow.length; i++){
			var inputList = cafeRow[i].getElementsByTagName("input");
			var cafeSelectCheckbox = inputList.namedItem("checkboxInput");
			if(cafeSelectCheckbox.checked){
				var cafe_id = inputList.namedItem("cafe_id").value;
				cafeIdJson[addCnt++]= cafe_id
			}
		}
		if(addCnt>0){
			var cafeIdListStr = JSON.stringify(cafeIdJson);
			
			$.ajax({
				method: "POST",
				data: {
					"cafeIdList":cafeIdListStr,
				},
				url: contextPath+"/cafe/shutdownMultipleCafe.do",
				success: function(data){
					alert("휴업처리가 완료되었습니다.");
					for(var i=0; i<addCnt;i++){
						var cafe_id = cafeIdJson[i];
						var jsonStr = data["response"];
						var parsedJson = JSON.parse(jsonStr);
						
						
						for(var j=0; j<cafeRow.length; j++){
							var inputList = cafeRow[j].getElementsByTagName("input");
							var cafe_id_input = inputList.namedItem("cafe_id").value;
							if(cafe_id == cafe_id_input){
								// get business state from json
								var business_state  = parsedJson[cafe_id]["business_state"];
								
								// set business state to indicator
								var business_state_indicator = cafeRow[j].getElementsByClassName("business-state-indicator")[0];
								
								if(business_state =="close"){
									business_state_indicator.innerText = "휴업";
								}
							}
						}
					}
					//location.reload();
				},
				error:function(jqXHR, textStatus, errorThrown){
					alert("휴업처리에 실패하였습니다. 에러코드 "+jqXHR.status);	
				}
			});
		}
	}
}
function changeBusinessStateToOpenMutiple(contextPath){
	var doOpen = window.confirm("영업을 재개하시겠습니까?")
	if(doOpen){
		var cafeRow = document.getElementsByName("cafeRow");
		var cafeIdJson ={}
		var addCnt=0;
		for(var i=0; i<cafeRow.length; i++){
			var inputList = cafeRow[i].getElementsByTagName("input");
			var cafeSelectCheckbox = inputList.namedItem("checkboxInput");
			if(cafeSelectCheckbox.checked){
				var cafe_id = inputList.namedItem("cafe_id").value;
				cafeIdJson[addCnt++]= cafe_id
			}
		}
		if(addCnt>0){
			var cafeIdListStr = JSON.stringify(cafeIdJson);
			
			$.ajax({
				method: "POST",
				data: {
					"cafeIdList":cafeIdListStr,
				},
				url: contextPath+"/cafe/undoShutdownMultipleCafe.do",
				success: function(data){
					alert("영업재개처리가 완료되었습니다.");
					for(var i=0; i<addCnt;i++){
						var cafe_id = cafeIdJson[i];
						var jsonStr = data["response"];
						var parsedJson = JSON.parse(jsonStr);
						
						
						for(var j=0; j<cafeRow.length; j++){
							var inputList = cafeRow[j].getElementsByTagName("input");
							var cafe_id_input = inputList.namedItem("cafe_id").value;
							if(cafe_id == cafe_id_input){
								// get business state from json
								var business_state  = parsedJson[cafe_id]["business_state"];
								
								// set business state to indicator
								var business_state_indicator = cafeRow[j].getElementsByClassName("business-state-indicator")[0];
								
								if(business_state =="open"){
									business_state_indicator.innerText = "영업중";
								}
							}
						}
					}
					//location.reload();
				},
				error:function(jqXHR, textStatus, errorThrown){
					alert("영업재개처리에 실패하였습니다. 에러코드 "+jqXHR.status);	
				}
			});
		}
	}
}
