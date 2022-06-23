function addMultipleOrder(actionContextUrl){
	
	let formObj = document.createElement("form");
	formObj.method="post";
	formObj.action=actionContextUrl+"/orderAndReservation/registerOrderAndReservation.do";
	
	let goodsOrderCount =0;
	
	//get goodsRow list
	let goodsRowList = document.getElementsByName("goodsRow");
	
	for(let i=0; i<goodsRowList.length;i++){
		//get input tag list
		let goodsInputTagList = goodsRowList[i].getElementsByTagName("input");
		//get checkbox input element
		let checkboxInput = goodsInputTagList.namedItem("goodsOrderChecked");
		
		//make goodsRow List
		if(checkboxInput.checked){
			goodsOrderCount++;
			
			let cafe_id= goodsInputTagList.namedItem("cafe_id").value;
			let goods_id= goodsInputTagList.namedItem("goods_id").value;
			let quantity= goodsInputTagList.namedItem("quantity").value;
			let is_takeout = goodsInputTagList.namedItem("is_takeout").checked; 
			formObj.innerHTML+=
				'<input type="hidden" name="goods_cafe_id'+ goodsOrderCount +'" value=' +cafe_id+ '>'+
				'<input type="hidden" name="goods_id'+ goodsOrderCount +'" value=' +goods_id+ '>'+
				'<input type="hidden" name="quantity'+ goodsOrderCount +'" value=' +quantity+ '>'+
				'<input type="hidden" name="isTakeout'+ goodsOrderCount +'" value=' +is_takeout+ '>';
		}
		
		
	}
	formObj.innerHTML+='<input type="hidden" name="numberOfGoods" value=' +goodsOrderCount+ '>';
	
	let groupSeatOrderCount =0;
	
	//get goodsRow list
	let groupSeatList = document.getElementsByName("groupSeatRow");
	
	for(let i=0; i<groupSeatList.length;i++){
		//get input tag list
		let groupSeatInputTagList = groupSeatList[i].getElementsByTagName("input");
		//get checkbox input element
		let checkboxInput = groupSeatInputTagList.namedItem("groupSeatOrderChecked");
		
		//make goodsRow List
		if(checkboxInput.checked){
			groupSeatOrderCount++;
			
			let cafe_id= groupSeatInputTagList.namedItem("cafe_id").value;
			let seat_id= groupSeatInputTagList.namedItem("seat_id").value;
			let reservation_date= groupSeatInputTagList.namedItem("reservation_date").value;
			let start_time= groupSeatInputTagList.namedItem("start_time").value;
			let end_time= groupSeatInputTagList.namedItem("end_time").value;
			 
			formObj.innerHTML+=
				'<input type="hidden" name="groupSeat_cafe_id'+ groupSeatOrderCount +'" value=' +cafe_id+ '>'+
				'<input type="hidden" name="seat_id'+ groupSeatOrderCount +'" value=' +seat_id+ '>'+
				'<input type="hidden" name="reservation_date'+ groupSeatOrderCount +'" value=' +reservation_date+ '>'+
				'<input type="hidden" name="start_time'+ groupSeatOrderCount +'" value=' +start_time+ '>'+
				'<input type="hidden" name="end_time'+ groupSeatOrderCount +'" value=' +end_time+ '>';
		}
	}
	formObj.innerHTML+='<input type="hidden" name="numberOfReservation" value=' +groupSeatOrderCount+ '>';
	
	let isMileageAdd = document.getElementById("checkSaveMileage").checked;
	let mileage_to_use = document.getElementById("mileage_to_use").value;
	let mileage_to_add = document.getElementById("mileage_to_add").value;
	
	formObj.innerHTML+=
				'<input type="hidden" name="isMileageAdd" value=' +isMileageAdd+ '>'+
				'<input type="hidden" name="mileageToUse" value=' +mileage_to_use+ '>'+
				'<input type="hidden" name="mileageToAdd" value=' +mileage_to_add+ '>';
				
	document.body.appendChild(formObj);
	formObj.submit();
}
function getGoodsTotalPrice(){
	var goodsPriceInputList = document.getElementsByName("goods_unit_totalPrice");
	var goodsTotalPrice = 0;
	for(var i=0;i<goodsPriceInputList.length;i++){
		var goodsPrice = parseInt(goodsPriceInputList[i].value);
		goodsTotalPrice+= goodsPrice;
	}
	return goodsTotalPrice;
}
function getGroupSeatTotalPrice(){
	var groupSeatPriceInputList = document.getElementsByName("groupSeat_unit_totalPrice");
	var groupSeatTotalPrice = 0;
	for(var i=0;i<groupSeatPriceInputList.length;i++){
		var groupSeatPrice = parseInt(groupSeatPriceInputList[i].value);
		groupSeatTotalPrice+= groupSeatPrice;
	}
	return groupSeatTotalPrice;
}
function onMileagePointChanged(){
	var totalPriceIndicator= document.getElementById("totalCost");
	var mileage_to_use_input = document.getElementById("mileage_to_use")
	var mileage_to_use = mileage_to_use_input.value;
	if(mileage_to_use ==""){
		mileage_to_use_input.value=0;
		mileage_to_use =0;
	}else{
		mileage_to_use = parseInt(mileage_to_use);
	}
	var goodsTotalPrice =getGoodsTotalPrice(); 
	
	var groupSeatTotalPrice = getGroupSeatTotalPrice();
	
	var totalPrice = (goodsTotalPrice+groupSeatTotalPrice)- mileage_to_use; 
	
	totalPriceIndicator.innerText= "총 "+totalPrice+"원";
}
function onMileageCheckboxChanged(checkbox){
	var checkbox_value = checkbox.checked;
	
	var current_mileage = document.getElementById("current_mileage");
	var current_available_mileage = document.getElementById("current_available_mileage");
	var mileage_to_use = document.getElementById("mileage_to_use");
	var mileage_to_add = document.getElementById("mileage_to_add");
	var totalPriceIndicator= document.getElementById("totalCost");
	if(!checkbox_value){
		current_mileage.disabled=false;
		current_available_mileage.disabled=false;
		mileage_to_use.disabled=false;
		mileage_to_add.disabled=true;
		
		var goodsTotalPrice =getGoodsTotalPrice(); 
		var groupSeatTotalPrice = getGroupSeatTotalPrice();
		var totalPrice = (goodsTotalPrice+groupSeatTotalPrice); 
		totalPriceIndicator.innerText= "총 "+totalPrice+"원";
	}else{
		current_mileage.disabled=false;
		current_available_mileage.disabled=true;
		mileage_to_use.disabled=true;
		mileage_to_add.disabled=false;
		
		onMileagePointChanged();
		
	}
}

function setGoodsTotalPrice(goodsCartRow){
	var elements = goodsCartRow.getElementsByTagName('input');
	
	var unitPrice = parseInt(elements['unitPrice'].value);
	
	var quantity = parseInt(elements['quantity'].value);
	
	var totalPriceInput = elements['goods_unit_totalPrice'];
	totalPriceInput.value = unitPrice*quantity; 
	
	var temp = goodsCartRow.getElementsByClassName("price-text");
	var totalPriceIndicator = temp[0];
	totalPriceIndicator.innerText =unitPrice*quantity+"원"
	
	setTotalPrice();
}

function setGroupSeatTotalPrice(groupSeatCartRow){
	var elements = groupSeatCartRow.getElementsByTagName('input');
	
	var unitPrice = parseInt(elements['unitPrice'].value);
	
	var reservation_date=elements['reservation_date'].value;
	var start_time=elements['start_time'].value;
	var end_time=elements['end_time'].value;
	if(reservation_date!='' && start_time!='' && end_time!='' ){
		var start_date = new Date(reservation_date+"T"+start_time);
		var end_date = new Date(reservation_date+"T"+end_time);;
		
		var timeDiff = end_date-start_date;
		
		var timeDiffToMinute = Math.round(timeDiff/(60*1000));
		var unitPricePerMinute = unitPrice/60;
		
		var totalPrice = Math.round(timeDiffToMinute*unitPricePerMinute);
		
		var totalPriceInput = elements['groupSeat_unit_totalPrice'];
		totalPriceInput.value = totalPrice; 
		
		var temp = groupSeatCartRow.getElementsByClassName("price-text");
		var totalPriceIndicator = temp[0];
		totalPriceIndicator.innerText =totalPrice+"원"
	}
	setTotalPrice();
}
function setTotalPrice(){
	var goodsCartRowList = document.getElementsByName("goodsOrderRow");
	var groupSeatCartRowList = document.getElementsByName("reservationRow");
	
	var totalPrice=0;
	
	goodsCartRowList.forEach(function(goodsCartRow){
		var inputlist = goodsCartRow.getElementsByTagName('input');
	    var priceElement = inputlist['goods_unit_totalPrice'];
	    var price = parseInt(priceElement.value);
		var order_state = inputlist['order_state'].value;
		
		if(order_state == "complete"){
			totalPrice+=price;
		}
	});
	
	groupSeatCartRowList.forEach(function(groupSeatCartRow){
		var inputlist = groupSeatCartRow.getElementsByTagName('input');
	    var priceElement = inputlist['groupSeat_unit_totalPrice'];
		var reservation_state = inputlist['reservation_state'].value;
	    var price = parseInt(priceElement.value);
		if(reservation_state == "complete"){
			totalPrice+=price;
		}
	});
	
	let isMileageAdd = document.getElementById("checkSaveMileage").checked;
	let mileage_to_use = document.getElementById("mileage_to_use").value;
	if(!isMileageAdd){
		totalPrice-=mileage_to_use
	}
	
	var totalPriceIndicator = document.getElementById("totalCost");
	totalPriceIndicator.innerText="총 "+totalPrice +"원";
}
function modifyGoodsOrder(contextPath, goodsRow){
	var elements = goodsRow.getElementsByTagName('input');
	var cafeId = elements['cafe_id'].value;
	var orderId = elements['order_id'].value;
	var goodsId = elements['goods_id'].value;
	var quantity = elements['quantity'].value;
	var isTakeout = elements['is_takeout'].checked;
	
	$.ajax({
		method: "POST",
		data: {
			"order_id": orderId,
			"order_quantity": quantity,
			"is_takeout": isTakeout
		},
		url: contextPath+"/orderAndReservation/goodsOrderModify.do",
		success: function(data){
			alert("주문이 변경되었습니다.");
			location.reload();
		},
		error:function(jqXHR, textStatus, errorThrown){
			alert("주문변경에 실패하였습니다. 에러코드 "+jqXHR.status);	
		}
	});
}

function cancelGoodsOrder(contextPath, order_id){
	$.ajax({
		method: "POST",
		data: {"order_id": order_id},
		url: contextPath+"/orderAndReservation/goodsOrderCancel.do",
		success: function(data){
			alert("주문이 취소되었습니다.");
			location.reload();
		},
		error:function(jqXHR, textStatus, errorThrown){
			alert("주문취소가 실패하였습니다. 에러코드 "+jqXHR.status);	
		}
	});
}

function modifyGroupSeatReservation(contextPath, groupSeatRow){
	var elements = groupSeatRow.getElementsByTagName('input');
	
	var reservation_id = elements['reservation_id'].value;
	var reservation_date = elements['reservation_date'].value;
	var start_time = elements['start_time'].value;
	var end_time = elements['end_time'].value;
	$.ajax({
		method: "POST",
		data: {
			"reservation_id": reservation_id,
			"reservation_date": reservation_date,
			"start_time": start_time,
			"end_time": end_time,
		},
		url: contextPath+"/orderAndReservation/reservationModify.do",
		success: function(data){
			alert("예약이 변경되었습니다.");
			location.reload();
		},
		error:function(jqXHR, textStatus, errorThrown){
			alert("예약변경에 실패하였습니다. 에러코드 "+jqXHR.status);	
		}
	});
}

function cancelGroupSeatReservation(contextPath, reservation_id){
	$.ajax({
		method: "POST",
		data: {"reservation_id": reservation_id},
		url: contextPath+"/orderAndReservation/reservationCancel.do",
		success: function(data){
			alert("예약이 취소되었습니다.");
			location.reload();
		},
		error:function(jqXHR, textStatus, errorThrown){
			alert("예약취소가 실패하였습니다. 에러코드 "+jqXHR.status);	
		}
	});
}
function cancelOrderAndReservation(contextPath, order_id){
	if(window.confirm("주문을 취소하시겠습니까")){
		$.ajax({
			method: "POST",
			data: {"orderAndReservation_id": order_id},
			url: contextPath+"/orderAndReservation/orderAndReservationCancel.do",
			success: function(data){
				alert("주문이 취소되었습니다.");
				location.reload();
			},
			error:function(jqXHR, textStatus, errorThrown){
				alert("주문취소가 실패하였습니다. 에러코드 "+jqXHR.status);	
			}
		});
	}
}
function toggleGoodsOrderSelect(){
	var goodsOrderRowList = document.getElementsByName("goodsOrderRow");
	
	var isAllGoodsOrderChecked=true;
	goodsOrderRowList.forEach(function(goodsCartRow){
		var inputlist = goodsCartRow.getElementsByTagName('input');
	    var checkboxElement = inputlist['goodsOrderChecked'];
	    var isChecked = checkboxElement.checked;
		isAllGoodsOrderChecked &= isChecked;
	});
	
	if(isAllGoodsOrderChecked){
		goodsOrderRowList.forEach(function(goodsCartRow){
			var inputlist = goodsCartRow.getElementsByTagName('input');
		    var checkboxElement = inputlist['goodsOrderChecked'];
		    checkboxElement.checked=false;
		});
	}else{
		goodsOrderRowList.forEach(function(goodsCartRow){
			var inputlist = goodsCartRow.getElementsByTagName('input');
		    var checkboxElement = inputlist['goodsOrderChecked'];
		    checkboxElement.checked=true;
		});
	}
}

function toggleResrvationSelect(){
	var reservationRowList = document.getElementsByName("reservationRow");
	
	var isAllReservationChecked=true;
	reservationRowList.forEach(function(groupSeatCartRow){
		var inputlist = groupSeatCartRow.getElementsByTagName('input');
	    var checkboxElement = inputlist['reservationChecked'];
	    var isChecked = checkboxElement.checked;
		isAllReservationChecked &= isChecked;
		
	});
	
	reservationRowList.forEach(function(groupSeatCartRow){
		var inputlist = groupSeatCartRow.getElementsByTagName('input');
	    var checkboxElement = inputlist['reservationChecked'];
		if(isAllReservationChecked){
			checkboxElement.checked=false;
		}else{
			checkboxElement.checked=true;
		}
	});
}

function searchOrder(contextPath, chapter, pageNum){
	var sortingOptionSelector = document.getElementById("sortingOptionSelector");
	var sortingOptions = sortingOptionSelector.children;
	var sortingOption;
	for(var i=0; i<sortingOptions.length; i++){
		if(sortingOptions[i].selected){
			sortingOption = sortingOptions[i].value;
		}
	}
	
	
	var orderStatusSelector = document.getElementById("orderStatusSelector");
	var orderStatuses=orderStatusSelector.children;
	var orderStatus;
	for(var i=0; i<orderStatuses.length; i++){
		if(orderStatuses[i].selected){
			orderStatus = orderStatuses[i].value;
		}
	}
	
	var searchInputBox = document.getElementById("searchInputBox");
	var searchWord = searchInputBox.value;
	
	
	//send Search Condition
	var searchForm = document.createElement("form");
	searchForm.method="post";
	searchForm.url=contextPath+"/"+articleType+"/search.do";
	
	var formContent = 
		"<input type='hidden' name='sortingOption' value='"+sortingOption+"'>"+
		"<input type='hidden' name='orderStatus' value='"+orderStatus+"'>"+
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