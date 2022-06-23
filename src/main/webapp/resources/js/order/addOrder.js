function sendSingleGoodsOrderToOrderForm(actionContextUrl,goodsRow){
	let elements = goodsRow.getElementsByTagName('input');
	
	let cafeId = document.getElementsByName('cafe_id')[0].value;
	
	let goodsId = elements['goods_id'].value;
	
	let quantity = elements['quantity'].value;
	
	let isTakeout = elements['is_takeout'].checked;
	
	let totalPriceInput = elements['goods_unit_totalPrice'];
	let totalPrice = totalPriceInput.value; 
	
	let formObj = document.createElement("form");
	formObj.method="post";
	formObj.action=actionContextUrl+"/orderAndReservation/orderAndReservationForm.do";
	formObj.innerHTML=
	'<input type="hidden" name="goods_cafe_id1" value=' +cafeId+ '>'+
	'<input type="hidden" name="goods_id1" value=' +goodsId+ '>'+
	'<input type="hidden" name="quantity1" value=' +quantity+ '>'+
	'<input type="hidden" name="totalPrice1" value=' +totalPrice+ '>'+
	'<input type="hidden" name="isTakeout1" value=' +isTakeout+ '>'+
	'<input type="hidden" name="numberOfGoods" value=' +1+ '>';
	document.body.appendChild(formObj);
	formObj.submit();
}

function sendSingleGroupSeatOrderToOrderForm(actionContextUrl,groupSeatRow){
	let elements = groupSeatRow.getElementsByTagName('input');
	
	let cafeId = document.getElementsByName('cafe_id')[0].value;
	
	let seatId = elements['seat_id'].value;
	
	var reservation_date = elements['reservation_date'].value;
	var start_time = elements['start_time'].value;
	var end_time = elements['end_time'].value;
	var unitPrice = elements['unitPrice'].value;
	
	let totalPriceInput = elements['groupSeat_unit_totalPrice'];
	let totalPrice = totalPriceInput.value; 
	
	let formObj = document.createElement("form");
	formObj.method="post";
	formObj.action=actionContextUrl+"/orderAndReservation/orderAndReservationForm.do";
	formObj.innerHTML=
	'<input type="hidden" name="groupSeat_cafe_id1" value=' +cafeId+ '>'+
	'<input type="hidden" name="seat_id1" value=' +seatId+ '>'+
	'<input type="hidden" name="reservation_date1" value=' +reservation_date+ '>'+
	'<input type="hidden" name="start_time1" value=' +start_time+ '>'+
	'<input type="hidden" name="end_time1" value=' +end_time+ '>'+
	'<input type="hidden" name="unitPrice1" value=' +unitPrice+ '>'+
	'<input type="hidden" name="totalPrice1" value=' +totalPrice+ '>'+
	'<input type="hidden" name="numberOfReservation" value=' +1+ '>';
	document.body.appendChild(formObj);
	formObj.submit();
} 
function sendMultipleOrderToOrderForm(actionContextUrl){
	
	let formObj = document.createElement("form");
	formObj.method="post";
	formObj.action=actionContextUrl+"/orderAndReservation/orderAndReservationForm.do";
	
	let goodsOrderCount =0;
	
	//get goodsRow list
	let goodsRowList = document.getElementsByName("goodsRow");
	
	for(let i=0; i<goodsRowList.length;i++){
		//get input tag list
		let goodsInputTagList = goodsRowList[i].getElementsByTagName("input");
		//get checkbox input element
		let checkboxInput = goodsInputTagList.namedItem("goodsCartChecked");
		
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
		let checkboxInput = groupSeatInputTagList.namedItem("groupSeatCartChecked");
		
		//make goodsRow List
		if(checkboxInput.checked){
			groupSeatOrderCount++;
			
			let cafe_id= groupSeatInputTagList.namedItem("cafe_id").value;
			let seat_id= groupSeatInputTagList.namedItem("seat_id").value;
			let reservation_date= groupSeatInputTagList.namedItem("reservation_date").value;
			let start_time= groupSeatInputTagList.namedItem("start_time").value;
			let end_time= groupSeatInputTagList.namedItem("end_time").value;
			var unitPrice = groupSeatInputTagList.namedItem("unitPrice").value; 
			
			formObj.innerHTML+=
				'<input type="hidden" name="groupSeat_cafe_id'+ groupSeatOrderCount +'" value=' +cafe_id+ '>'+
				'<input type="hidden" name="seat_id'+ groupSeatOrderCount +'" value=' +seat_id+ '>'+
				'<input type="hidden" name="reservation_date'+ groupSeatOrderCount +'" value=' +reservation_date+ '>'+
				'<input type="hidden" name="start_time'+ groupSeatOrderCount +'" value=' +start_time+ '>'+
				'<input type="hidden" name="end_time'+ groupSeatOrderCount +'" value=' +end_time+ '>'+
				'<input type="hidden" name="unitPrice'+ groupSeatOrderCount +'" value=' +unitPrice+ '>';
		}
	}
	formObj.innerHTML+='<input type="hidden" name="numberOfReservation" value=' +groupSeatOrderCount+ '>';
	document.body.appendChild(formObj);
	formObj.submit();
}
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
	var goodsCartRowList = document.getElementsByName("goodsRow");
	var groupSeatCartRowList = document.getElementsByName("groupSeatRow");
	
	var totalPrice=0;
	
	goodsCartRowList.forEach(function(goodsCartRow){
		var inputlist = goodsCartRow.getElementsByTagName('input');
	    var priceElement = inputlist['goods_unit_totalPrice'];
	    var price = parseInt(priceElement.value);
		totalPrice+=price;
	});
	
	groupSeatCartRowList.forEach(function(groupSeatCartRow){
		var inputlist = groupSeatCartRow.getElementsByTagName('input');
	    var priceElement = inputlist['groupSeat_unit_totalPrice'];
	    var price = parseInt(priceElement.value);
		totalPrice+=price;
	});
	
	var totalPriceIndicator = document.getElementById("totalCost");
	totalPriceIndicator.innerText="총 "+totalPrice +"원";
}
function modifyGoodsOrder(contextPath, goodsRow){
	var elements = goodsRow.getElementsByTagName('input');
	var cafeId = elements['cafe_id'].value;
	
	var cartId = elements['cart_id'].value;
	var goodsId = elements['goods_id'].value;
	var quantity = elements['quantity'].value;
	var isTakeout = elements['is_takeout'].checked;
	
	$.ajax({
		method: "POST",
		data: {
			"cafe_cafe_id":cafeId,
			"cart_id": cartId,
			"goods_id": goodsId,
			"quantity": quantity,
			"is_takeout": isTakeout
		},
		url: contextPath+"/cart/modifyGoodsCart.do",
		success: function(data){
			alert("장바구니가 변경되었습니다.");
			location.reload();
		},
		error:function(jqXHR, textStatus, errorThrown){
			alert("장바구니 변경에 실패하였습니다. 에러코드 "+jqXHR.status);	
		}
	});
}

function deleteGoodsOrder(contextPath, cart_id){
	$.ajax({
		method: "POST",
		data: {"cart_id": cart_id},
		url: contextPath+"/cart/deleteGoodsCart.do",
		success: function(data){
			alert("장바구니가 삭제되었습니다.");
			location.reload();
		},
		error:function(jqXHR, textStatus, errorThrown){
			alert("장바구니 삭제에 실패하였습니다. 에러코드 "+jqXHR.status);	
		}
	});
}

function modifyGroupSeatReservation(contextPath){
	var elements = groupSeatRow.getElementsByTagName('input');
	
	var cafe_id = elements['cafe_id'].value;
	
	var groupSeat_id = elements['seat_id'].value;
	var reservation_date = elements['reservation_date'].value;
	var start_time = elements['start_time'].value;
	var end_time = elements['end_time'].value;
	$.ajax({
		method: "POST",
		data: {
			"cart_id": cart_id
		},
		url: contextPath+"/cart/modifyGroupSeatCart.do",
		success: function(data){
			alert("장바구니가 변경되었습니다.");
			location.reload();
		},
		error:function(jqXHR, textStatus, errorThrown){
			alert("장바구니 변경에 실패하였습니다. 에러코드 "+jqXHR.status);	
		}
	});
}

function deleteGroupSeatReservation(contextPath, cart_id){
	$.ajax({
		method: "POST",
		data: {"cart_id": cart_id},
		url: contextPath+"/cart/deleteGroupSeatCart.do",
		success: function(data){
			alert("장바구니가 삭제되었습니다.");
			location.reload();
		},
		error:function(jqXHR, textStatus, errorThrown){
			alert("장바구니 삭제에 실패하였습니다. 에러코드 "+jqXHR.status);	
		}
	});
}

