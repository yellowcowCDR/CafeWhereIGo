/**
 * 
 */

function initCafeLocationSelector(location1, location2, location3, location4){
	let cafe_location1_selector = document.getElementById("region1");
	let cafe_location2_selector = document.getElementById("region2");
	let cafe_location3_selector = document.getElementById("region3");
	let cafe_location4_selector = document.getElementById("region4");
	
	let cafe_location1_options = cafe_location1_selector.children;
	let cafe_location2_options = cafe_location2_selector.children;
	let cafe_location3_options = cafe_location3_selector.children;
	let cafe_location4_options = cafe_location4_selector.children;
	
	if(prev_cafe_location1!= null && prev_cafe_location1!="" && prev_cafe_location1!="선택"){
		for(let i=0; i<cafe_location1_options.length; i++){
		    if(cafe_location1_options[i].innerText == location1){
		        cafe_location1_options[i].selected=true;
		    }
		}
	}
	if(prev_cafe_location2!= null && prev_cafe_location2!="" && prev_cafe_location2!="선택"){
		for(let i=0; i<cafe_location2_options.length; i++){
		     if(cafe_location2_options[i].innerText == location2){
		        cafe_location2_options[i].selected=true;
		    }
		}
	}
	if(prev_cafe_location3!= null && prev_cafe_location3!="" && prev_cafe_location3!="선택"){
		for(let i=0; i<cafe_location3_options.length; i++){
		     if(cafe_location3_options[i].innerText == location3){
		        cafe_location3_options[i].selected=true;
		    }
		}
	}
	if(prev_cafe_location4!= null && prev_cafe_location4!="" && prev_cafe_location4!="선택"){
		for(let i=0; i<cafe_location4_options.length; i++){
		     if(cafe_location4_options[i].innerText == location4){
		        cafe_location4_options[i].selected=true;
		    }
		}
	}
}

function initNumOfSeat(numOfSeat){
	var numOfSeatSelector = document.getElementById("numOfSeat");
	var numOfSeatOptions = numOfSeatSelector.children;
	for(let i=0; i<numOfSeatOptions.length; i++){
	    if(parseInt(numOfSeatOptions[i].value)==numOfSeat){
			numOfSeatOptions[i].selected=true;
	    }
	}	
}

function initCafeThemeSelector(selectedTheme){
	let themeSelector = document.getElementById("themeSelector");
	let themeOptions = themeSelector.children;
	if(selectedTheme=='all'){
		selectedTheme = '';
	}
	
	for(let i=0; i< themeOptions.length;i++){
		if(themeOptions[i].value ==selectedTheme){
			themeOptions[i].selected = true ;
		}
	}
}

function initSortingOptionSelector(selectedOption){
	let sortingOptionSelector = document.getElementById("sortingOptionSelector");
	let sortingOptions = sortingOptionSelector.children;
	
	for(let i=0; i<sortingOptions.length; i++){
		if(sortingOptions[i].value ==selectedOption){
			sortingOptions[i].selected = true ;
		}
	}
}

function searchCafe(contextPath, chapter, pageNum){
	let cafe_location1_selector = document.getElementById("region1");
	let cafe_location2_selector = document.getElementById("region2");
	let cafe_location3_selector = document.getElementById("region3");
	let cafe_location4_selector = document.getElementById("region4");
	
	let cafe_location1_options = cafe_location1_selector.children;
	let cafe_location2_options = cafe_location2_selector.children;
	let cafe_location3_options = cafe_location3_selector.children;
	let cafe_location4_options = cafe_location4_selector.children;
	
	let cafe_location1;
	let cafe_location2;
	let cafe_location3;
	let cafe_location4;
	
	for(let i=0; i<cafe_location1_options.length; i++){
	    if(cafe_location1_options[i].selected){
	        cafe_location1 =cafe_location1_options[i].innerText;
	    }
	}
	for(let i=0; i<cafe_location2_options.length; i++){
	    if(cafe_location2_options[i].selected){
	        cafe_location2 =cafe_location2_options[i].innerText;
	    }
	}
	
	for(let i=0; i<cafe_location3_options.length; i++){
	    if(cafe_location3_options[i].selected){
	        cafe_location3 =cafe_location3_options[i].innerText;
	    }
	}
	
	for(let i=0; i<cafe_location4_options.length; i++){
	    if(cafe_location4_options[i].selected){
	        cafe_location4 =cafe_location4_options[i].innerText;
	    }
	}
	
	var isPlugExist = document.getElementById("isPlugExist").checked;
	var isParkingLotExist = document.getElementById("isParkingLotExist").checked;
	var isWifiExist = document.getElementById("isWifiExist").checked;
	var isDontCare = document.getElementById("isDontCare").checked;
	
	var numOfSeatSelector = document.getElementById("numOfSeat");
	var numOfSeatOptions = numOfSeatSelector.children;
	var numOfSeat=0;
	for(let i=0; i<numOfSeatOptions.length; i++){
	    if(numOfSeatOptions[i].selected){
	        numOfSeat =parseInt(numOfSeatOptions[i].value);
	    }
	}
	
	var themeSelector = document.getElementById("themeSelector");
	var themeOptions = themeSelector.children;
	var theme;
	for(let i=0; i<themeOptions.length; i++){
	    if(themeOptions[i].selected){
	        theme =themeOptions[i].value;
	    }
	}
	
	var sortingOptionSelector = document.getElementById("sortingOptionSelector");
	var sortingOptions = sortingOptionSelector.children;
	var sortingOption;
	for(let i=0; i<sortingOptions.length; i++){
	    if(sortingOptions[i].selected){
	        sortingOption =sortingOptions[i].value;
	    }
	}
	
	var searchKeyword = document.getElementById("searchKeword").value;
	
	//send Search Condition
	var searchForm = document.createElement("form");
	searchForm.method="post";
	searchForm.url=contextPath+"/cafe/search.do";
	
	var formContent = 
		"<input type='hidden' name='cafe_location1' value='"+cafe_location1+"'>"+
		"<input type='hidden' name='cafe_location2' value='"+cafe_location2+"'>"+
		"<input type='hidden' name='cafe_location3' value='"+cafe_location3+"'>"+
		"<input type='hidden' name='cafe_location4' value='"+cafe_location4+"'>"+
		
		"<input type='hidden' name='dontCare' value='"+isDontCare+"'>"+
		"<input type='hidden' name='power_plug' value='"+isPlugExist+"'>"+
		"<input type='hidden' name='parking_lot' value='"+isParkingLotExist+"'>"+
		"<input type='hidden' name='wifi' value='"+isWifiExist+"'>"+
		
		"<input type='hidden' name='number_of_seat' value='"+numOfSeat+"'>"+
		
		"<input type='hidden' name='theme' value='"+theme+"'>"+
		
		"<input type='hidden' name='sortingOption' value='"+sortingOption+"'>"+
		"<input type='hidden' name='searchKeyword' value='"+searchKeyword+"'>"
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

