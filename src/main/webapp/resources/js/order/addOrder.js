function sendOrderToOrderForm(actionContextUrl,goodsRow){
	var elements = goodsRow.getElementsByTagName('input');
	
	var cafeId = document.getElementsByName('cafe_id')[0].value;
	
	var goodsId = elements['goods_id'].value;
	
	var quantity = elements['quantity'].value;
	
	var isTakeout = elements['is_takeout'].checked;
	
	var totalPriceInput = elements['totalPrice'];
	var totalPrice = totalPriceInput.value; 
	
	var formObj = document.createElement("form");
	formObj.method="post";
	formObj.action=actionContextUrl+"/orderAndReservation/orderAndReservationForm.do";
	formObj.innerHTML=
	'<input type="hidden" name="cafe_id" value=' +cafeId+ '>'+
	'<input type="hidden" name="goods_id1" value=' +goodsId+ '>'+
	'<input type="hidden" name="quantity1" value=' +quantity+ '>'+
	'<input type="hidden" name="totalPrice1" value=' +totalPrice+ '>'+
	'<input type="hidden" name="isTakeout1" value=' +isTakeout+ '>'+
	'<input type="hidden" name="numberOfGoods" value=' +1+ '>';
	document.body.appendChild(formObj);
	var a=1;
	formObj.submit();
}