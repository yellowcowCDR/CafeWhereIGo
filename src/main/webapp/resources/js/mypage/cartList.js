/**
 * 
 */
function modifyGoodsCart(contextPath, goodsRow){
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

function deleteGoodsCart(contextPath, cart_id){
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

function modifyGroupSeatCart(contextPath){
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

function deleteGroupSeatCart(contextPath, cart_id){
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

function setGoodsTotalPrice(goodsCartRow){
	var elements = goodsCartRow.getElementsByTagName('input');
	
	var unitPrice = parseInt(elements['unitPrice'].value);
	
	var quantity = parseInt(elements['quantity'].value);
	
	var totalPriceInput = elements['totalPrice'];
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
		
		var totalPriceInput = elements['totalPrice'];
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
	    var priceElement = inputlist['totalPrice'];
	    var price = parseInt(priceElement.value);
		totalPrice+=price;
	});
	
	groupSeatCartRowList.forEach(function(groupSeatCartRow){
		var inputlist = groupSeatCartRow.getElementsByTagName('input');
	    var priceElement = inputlist['totalPrice'];
	    var price = parseInt(priceElement.value);
		totalPrice+=price;
	});
	
	var totalPriceIndicator = document.getElementById("totalCost");
	totalPriceIndicator.innerText="총 "+totalPrice +"원";
}

function toggleGoodsCartSelect(){
	var goodsCartRowList = document.getElementsByName("goodsRow");
	
	var isAllGoodsCartChecked=true;
	goodsCartRowList.forEach(function(goodsCartRow){
		var inputlist = goodsCartRow.getElementsByTagName('input');
	    var checkboxElement = inputlist['goodsCartChecked'];
	    var isChecked = checkboxElement.checked;
		isAllGoodsCartChecked &= isChecked;
	});
	
	if(isAllGoodsCartChecked){
		goodsCartRowList.forEach(function(goodsCartRow){
			var inputlist = goodsCartRow.getElementsByTagName('input');
		    var checkboxElement = inputlist['goodsCartChecked'];
		    checkboxElement.checked=false;
		});
	}else{
		goodsCartRowList.forEach(function(goodsCartRow){
			var inputlist = goodsCartRow.getElementsByTagName('input');
		    var checkboxElement = inputlist['goodsCartChecked'];
		    checkboxElement.checked=true;
		});
	}
}

function toggleGroupSeatCartSelect(){
	var groupSeatCartRowList = document.getElementsByName("groupSeatRow");
	
	var isAllGroupSeatCartChecked=true;
	groupSeatCartRowList.forEach(function(groupSeatCartRow){
		var inputlist = groupSeatCartRow.getElementsByTagName('input');
	    var checkboxElement = inputlist['groupSeatCartChecked'];
	    var isChecked = checkboxElement.checked;
		isAllGroupSeatCartChecked &= isChecked;
		
	});
	
	groupSeatCartRowList.forEach(function(groupSeatCartRow){
		var inputlist = groupSeatCartRow.getElementsByTagName('input');
	    var checkboxElement = inputlist['groupSeatCartChecked'];
		if(isAllGroupSeatCartChecked){
			checkboxElement.checked=false;
		}else{
			checkboxElement.checked=true;
		}
	});
}