/**
 * 
 */
function addReview(contextPath){
	var cafe_id_input = document.getElementsByName("cafe_id");
	var cafe_id = cafe_id_input[0].value;
	
	var orderAndReservation_id_input = document.getElementById("orderHistory");
	var orderAndReservation_id=orderAndReservation_id_input.value;
	
	var coffeeRateInput = document.getElementsByName("coffeeRate");
	var coffeeRate=0;
	for(var i=0; i<coffeeRateInput.length;i++)
    {
        if(coffeeRateInput[i].checked){
            coffeeRate=coffeeRateInput[i].value;
        }
    }
	
	var drinkRateInput = document.getElementsByName("drinkRate");
	var drinkRate=0;
	for(var i=0; i<drinkRateInput.length;i++)
    {
        if(drinkRateInput[i].checked){
            drinkRate=drinkRateInput[i].value;
        }
    }

	var dessertRateInput = document.getElementsByName("dessertRate");
	var dessertRate=0;
	for(var i=0; i<dessertRateInput.length;i++)
    {
        if(dessertRateInput[i].checked){
            dessertRate=dessertRateInput[i].value;
        }
    }
	
	var viewRateInput = document.getElementsByName("viewRate");
	var viewRate=0;
	for(var i=0; i<viewRateInput.length;i++)
    {
        if(viewRateInput[i].checked){
            viewRate=viewRateInput[i].value;
        }
    }

	var moodRateInput = document.getElementsByName("moodRate");
	var moodRate=0;
	for(var i=0; i<moodRateInput.length;i++)
    {
        if(moodRateInput[i].checked){
            moodRate=moodRateInput[i].value;
        }
    }
	
	var quietRateInput = document.getElementsByName("quietRate");
	var quietRate=0;
	for(var i=0; i<quietRateInput.length;i++)
    {
        if(quietRateInput[i].checked){
            quietRate=quietRateInput[i].value;
        }
    }

	var reviewContentInput = document.getElementById("review_content");
	var reviewContentInput = reviewContentInput.cloneNode();
	
	var reviewImageInput = document.getElementById("review_photo").cloneNode();
	
	var formObj= document.createElement("form");
	formObj.innerHTML =
	'<input type="hidden" name="cafe_id" value=' +cafe_id+ '>'+
	'<input type="hidden" name="orderAndReservation_id" value=' +orderAndReservation_id+ '>'+
	'<input type="hidden" name="coffeeRate" value=' +coffeeRate+ '>'+
	'<input type="hidden" name="drinkRate" value=' +drinkRate+ '>'+
	'<input type="hidden" name="dessertRate" value=' +dessertRate+ '>'+
	'<input type="hidden" name="viewRate" value=' +viewRate+ '>'+
	'<input type="hidden" name="moodRate" value=' +moodRate+ '>'+
	'<input type="hidden" name="quietRate" value=' +quietRate+ '>';
	formObj.appendChild(reviewContentInput);
	formObj.appendChild(reviewImageInput);
	
	var formData = new FormData(formObj);
	
	$.ajax({             
    	type: "POST",          
        enctype: 'multipart/form-data',  
        url: contextPath+"/cafe/addReview.do",        
        data: formData,          
        processData: false,    
        contentType: false,      
        cache: false,           
        timeout: 600000,       
        success: function (data) { 
        	alert("complete");           
        	location.reload();      
        },          
        error: function (e) {  
        	console.log("ERROR : ", e);         
            alert("fail");      
         }     
	});
}

function changeToReviewModifyForm(contextPath, review_row){
	var reviewWriteButtonTd = document.getElementById("reviewWriteButtonTd");
	var inputList = review_row.getElementsByTagName("input");
	
	// load review_id
	var review_id = inputList.namedItem("review_id").value;
	
	// set review_id for modify
	var review_id_input = document.getElementById("review_id_for_modify");
	review_id_input.value=review_id;
	
	// load orderAndReservation_id
	var order_id = inputList.namedItem("order_id").value;
	
	// set orderHistory select
	var orderHistorySelector= document.getElementById("orderHistory");
	var options = orderHistorySelector.children;
	for(var i=0; i<options.length;i++){
		if(options[i].value == order_id){
			options[i].selected=true;
		}
	}
	
	// get cafe score
	var coffeeScore = inputList.namedItem("coffeeScore").value;
	var drinkScore = inputList.namedItem("drinkScore").value;
	var dessertScore = inputList.namedItem("dessertScore").value;
	var viewScore = inputList.namedItem("viewScore").value;
	var moodScore = inputList.namedItem("moodScore").value;
	var quietScore = inputList.namedItem("quietScore").value;
	
	// set cafe score
	setCafeScore("coffee", coffeeScore);
	setCafeScore("drink", drinkScore);
	setCafeScore("dessert", dessertScore);
	setCafeScore("view", viewScore);
	setCafeScore("mood", moodScore);
	setCafeScore("quiet", quietScore);
	
	//get review content
	let reviewInput = document.getElementById("review_content");
	let reviewTd = review_row.getElementsByClassName("reply-content-td")[0];
	let reviewTextElements = reviewTd.getElementsByTagName("p");
	let reviewText = "";
	for(var i=0; i<reviewTextElements.length; i++){
		reviewText +=reviewTextElements[i].innerText;
		if(i<(reviewTextElements.length-1)){
			 reviewText +="\n";
		}
	}
	
	//set review content
	reviewInput.value=reviewText;
	
	//get image filename
	var filename = inputList.namedItem("imageFilename").value;
	var fileNameToken = filename.split("_");
	var filenameShort = "";
	for(var i=1; i< fileNameToken.length; i++){
	    filenameShort+=fileNameToken[i];
	    if(i<(fileNameToken.length-1)){
	        filenameShort += "_";
	    }
	}
	
	//change button form
	let reviewPhotoSelectTd = document.getElementById("reviewPhotoSelectTd");
	let buttonForm = '<button onclick="showFileSelectWindow()" class=\'reviewPhotoChangeButton\'">수정</button>'+
					'<button onclick="deleteReviewPhoto()" class=\'reviewPhotoDeleteButton\'">삭제</button>';
	reviewPhotoSelectTd.innerHTML= buttonForm;				
	
	//set image filename
	var filenameIndicator = document.getElementById("reviewPhotoIndicator");
	filenameIndicator.innerText=filenameShort;
	var filenameInput  = document.getElementById("review_photo_filename");
	filenameInput.value= filename;
	
	var reviewModifyButtonForm =
	'<button style="width: 97px;height:60px;margin-left: 10px; margin-bottom:10px" onclick="modifyReview(\''+contextPath+'\')">수정</button>'+
	'<button style="width: 97px;height:30px;margin-left: 10px;" onclick="changeToReviewInputForm(\''+contextPath+'\')">취소</button>';
	reviewWriteButtonTd.innerHTML=reviewModifyButtonForm;
}
function changeToReviewInputForm(contextPath){
	
	var orderHistorySelector= document.getElementById("orderHistory");
	var options = orderHistorySelector.children;
	options[0].selected=true;
	
	deselectAllCafeScore();
	
	var review_id_input = document.getElementById("review_id_for_modify");
	review_id_input.value="";
	
	let reviewInput = document.getElementById("review_content");
	reviewInput.value="";
	
	// change file button form
	var buttonForm= '<button class="reviewPhotoSelectButton" onclick="showFileSelectWindow()">사진첨부</button>';
	let reviewPhotoSelectTd = document.getElementById("reviewPhotoSelectTd");
	reviewPhotoSelectTd.innerHTML= buttonForm;
	
	// change filename indicator text
	var filenameIndicator = document.getElementById("reviewPhotoIndicator");
	filenameIndicator.innerText="";
	
	// filenameInput init
	var filenameInput = document.getElementById("review_photo_filename");
	filenameInput.value="";
	
	//fileInput init
	var fileInput = document.getElementById("review_photo");
	fileInput.value="";
	
	// change review button form 
	var reviewWriteButtonTd = document.getElementById("reviewWriteButtonTd");
	 var reviewModifyButtonForm =
	'<button style="width: 97px;height:100px;margin-left: 10px;" onclick="addReview(\''+contextPath+'\')">글쓰기</button>';
	reviewWriteButtonTd.innerHTML=reviewModifyButtonForm;
}
function modifyReview(contextPath){
	// get Review Id
	var review_id = document.getElementById("review_id_for_modify").value;
	var cafe_id_input = document.getElementsByName("cafe_id");
	var cafe_id = cafe_id_input[0].value;
	
	var orderAndReservation_id_input = document.getElementById("orderHistory");
	var orderAndReservation_id=orderAndReservation_id_input.value;
	
	var coffeeRateInput = document.getElementsByName("coffeeRate");
	var coffeeRate=0;
	for(var i=0; i<coffeeRateInput.length;i++)
    {
        if(coffeeRateInput[i].checked){
            coffeeRate=coffeeRateInput[i].value;
        }
    }
	
	var drinkRateInput = document.getElementsByName("drinkRate");
	var drinkRate=0;
	for(var i=0; i<drinkRateInput.length;i++)
    {
        if(drinkRateInput[i].checked){
            drinkRate=drinkRateInput[i].value;
        }
    }

	var dessertRateInput = document.getElementsByName("dessertRate");
	var dessertRate=0;
	for(var i=0; i<dessertRateInput.length;i++)
    {
        if(dessertRateInput[i].checked){
            dessertRate=dessertRateInput[i].value;
        }
    }
	
	var viewRateInput = document.getElementsByName("viewRate");
	var viewRate=0;
	for(var i=0; i<viewRateInput.length;i++)
    {
        if(viewRateInput[i].checked){
            viewRate=viewRateInput[i].value;
        }
    }

	var moodRateInput = document.getElementsByName("moodRate");
	var moodRate=0;
	for(var i=0; i<moodRateInput.length;i++)
    {
        if(moodRateInput[i].checked){
            moodRate=moodRateInput[i].value;
        }
    }
	
	var quietRateInput = document.getElementsByName("quietRate");
	var quietRate=0;
	for(var i=0; i<quietRateInput.length;i++)
    {
        if(quietRateInput[i].checked){
            quietRate=quietRateInput[i].value;
        }
    }

	var reviewContentInput = document.getElementById("review_content");
	
	var reviewImageInput = document.getElementById("review_photo").cloneNode();
	var reviewImageFilenameInput = document.getElementById("review_photo_filename").cloneNode();
	
	var reviewContentInput = document.getElementById("review_content");
	var reviewContentInput = reviewContentInput.cloneNode();
	
	var formObj= document.createElement("form");
	formObj.innerHTML =
	'<input type="hidden" name="review_id" value=' +review_id+ '>'+
	'<input type="hidden" name="cafe_id" value=' +cafe_id+ '>'+
	'<input type="hidden" name="orderAndReservation_id" value=' +orderAndReservation_id+ '>'+
	'<input type="hidden" name="coffeeRate" value=' +coffeeRate+ '>'+
	'<input type="hidden" name="drinkRate" value=' +drinkRate+ '>'+
	'<input type="hidden" name="dessertRate" value=' +dessertRate+ '>'+
	'<input type="hidden" name="viewRate" value=' +viewRate+ '>'+
	'<input type="hidden" name="moodRate" value=' +moodRate+ '>'+
	'<input type="hidden" name="quietRate" value=' +quietRate+ '>';
	
	formObj.appendChild(reviewContentInput);
	formObj.appendChild(reviewImageInput);
	formObj.appendChild(reviewImageFilenameInput);
	
	var formData = new FormData(formObj);
	
	$.ajax({             
    	type: "POST",          
        enctype: 'multipart/form-data',  
        url: contextPath+"/cafe/modifyReview.do",        
        data: formData,          
        processData: false,    
        contentType: false,      
        cache: false,           
        timeout: 600000,       
        success: function (data) { 
        	alert("complete");           
        	location.reload();      
        },          
        error: function (e) {  
        	console.log("ERROR : ", e);         
            alert("fail");      
         }     
	});
}

function deleteReiview(contextPath, review_id, user_id, writter_id){
	if(user_id == ''){
		alert("로그인 후 이용해주세요.");
	}else if(user_id!=writter_id){
		alert("작성자만 삭제할 수 있습니다.");
	}else{
		$.ajax({
			url: contextPath+"/cafe/deleteReview.do",
			async:true,
			method:"post",
			data:{
				"review_id":review_id
			},
			dataType:"json",
			success: function(data, textStatus, jqXHR){
				console.log("succeed to communicate..("+textStatus+")");
				alert("리뷰가 삭제되었습니다.");
				location.reload();
			},
			error:function(request,status,error){
				console.log("삭제에 실패하였습니다. ("+request.status+")");
			}
		});
	}
}
function setFilenameIndicator(filepath){
	let filepathToken = filepath.split("\\");
	let filename= filepathToken[filepathToken.length-1];
	
	let reviewPhotoIndicator = document.getElementById("reviewPhotoIndicator");
	reviewPhotoIndicator.innerText=filename;
	
}
function showFileSelectWindow(){
	let fileInput = document.getElementById("review_photo");
	fileInput.click();
}

function setCafeScore(category, score){
	var radioButton = document.getElementById(category+"Star"+score);
	radioButton.checked=true;
}

function deselectAllCafeScore(){
	var radioButton;
	for(var i=1; i<=5; i++){
		radioButton = document.getElementById("coffeeStar"+i);
		radioButton.checked=false;
	}
	for(var i=1; i<=5; i++){
		radioButton = document.getElementById("drinkStar"+i);
		radioButton.checked=false;
	}
	for(var i=1; i<=5; i++){
		radioButton = document.getElementById("dessertStar"+i);
		radioButton.checked=false;
	}
	for(var i=1; i<=5; i++){
		radioButton = document.getElementById("viewStar"+i);
		radioButton.checked=false;
	}
	for(var i=1; i<=5; i++){
		radioButton = document.getElementById("moodStar"+i);
		radioButton.checked=false;
	}
	for(var i=1; i<=5; i++){
		radioButton = document.getElementById("quietStar"+i);
		radioButton.checked=false;
	}
}
function deleteReviewPhoto(){
	var fileInput = document.getElementById("review_photo");
	var filenameInput = document.getElementById("review_photo_filename");
	var reviewPhotoIndicator = document.getElementById("reviewPhotoIndicator");
	fileInput.value = ""
	filenameInput.value = ""
	reviewPhotoIndicator.innerText="";
}