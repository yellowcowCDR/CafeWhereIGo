/**
 * 
 */

function addGoodsCart(contextPath, goodsRow){
	var elements = goodsRow.getElementsByTagName('input');
	
	var cafeId = document.getElementsByName('cafe_id')[0].value;
	
	var goodsId = elements['goods_id'].value;
	
	var quantity = elements['quantity'].value;
	
	var isTakeout = elements['is_takeout'].checked;
	
	var totalPriceInput = elements['goods_unit_totalPrice'];
	var totalPrice = totalPriceInput.value;
	
	$.ajax({
		url: contextPath+"/cart/addGoodsCart.do",
		async:true,
		method:"post",
		data:{
			"cafe_cafe_id":cafeId,
			"goods_id":goodsId,
			"quantity":quantity,
			"is_Takeout":isTakeout,
		},
		dataType:"json",
		success: function(data, textStatus, jqXHR){
			console.log("succeed to communicate..("+textStatus+")");
			alert("상품이 장바구니에 추가되었습니다.");
		},
		error:function(request,status,error){
			console.log("falied to communicate..("+request.status+")");
		}
		
	});
}

function addGroupSeatCart(contextPath, groupSeatRow){
	var elements = groupSeatRow.getElementsByTagName('input');
	
	var cafe_id = document.getElementsByName('cafe_id')[0].value;
	
	var groupSeat_id = elements['seat_id'].value;
	var reservation_date = elements['reservation_date'].value;
	var start_time = elements['start_time'].value;
	var end_time = elements['end_time'].value;
	
	$.ajax({
		url: contextPath+"/cart/addGroupSeatCart.do",
		async:true,
		method:"post",
		data:{
			"cafe_cafe_id":cafe_id,
			"groupSeat_id":groupSeat_id,
			"reservation_date": reservation_date,
			"start_time":start_time,
			"end_time":end_time
		},
		dataType:"json",
		success: function(data, textStatus, jqXHR){
			console.log("succeed to communicate..("+textStatus+")");
			alert("상품이 장바구니에 추가되었습니다.");
		},
		error:function(request,status,error){
			console.log("falied to communicate..("+request.status+")");
		}
	});
}