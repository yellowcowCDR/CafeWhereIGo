let goodsSize;
let groupSeatSize;
let photoSize;
let parkingLotSize;

window.onload=function(){
	goodsSize = document.getElementById("goodsSize");
	groupSeatSize = document.getElementById("groupSeatSize");
	photoSize = document.getElementById("photoSize");
	parkingLotSize = document.getElementById("parkingLotSize");
}


function setParkingLotAddress1(parkingLotNo){
	 new daum.Postcode({
	        oncomplete: function(data) {
	            // 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분입니다.
	            // 예제를 참고하여 다양한 활용법을 확인해 보세요
				var parkingLotAddress1 = document.getElementById("parkingLot"+parkingLotNo+"_Address1")
	            parkingLotAddress1.value=data.jibunAddress;
	        }
	    }).open();
}

function addGoods(contextPath, menuTable){
	//numOfGoods++;
	var numOfGoods = ++goodsSize.value;
	var element = `<tr id="hrRow${numOfGoods}"><td colspan="100"><hr style="width:100%; color:#a8a2a2;"></td></tr>
					<tr id="productRow${numOfGoods}">
						<td width="80px">
							<a id="menu${numOfGoods}" href="#" onclick="select_goods_photo(this); return false;">
								<img class="product_image" id="menu${numOfGoods}_img" src="${contextPath}/resources/image/add_picture.svg">
							</a>
							<input id="menu${numOfGoods}_photo_file_input" class="photo_file_input" name="goodsphoto${numOfGoods}" type="file" onchange="on_goods_photo_changed(this)">
						</td>
						<td width="420px">
							<div>
								<input type="text" id="productName1" name="goods${numOfGoods}_name" placeholder="상품명">
								<input type="text" id="productPrice1" name="goods${numOfGoods}_price" placeholder="상품가격(원)">
								<textarea rows="2" style="width:100%; margin-top:5px" name="goods${numOfGoods}_description" placeholder="상품설명"></textarea>
							</div>
						</td>									
						
						<td width="28px" style="text-align:center;"><input type="button" class="orderDeleteButton" onclick="deleteGoods(this.parentNode.parentNode);" value="취소"></td>	
					</tr>`;
	menuTable.innerHTML += element;
	
}

function addGroupSeat(contextPath, groupSeatTable){
	//numOfGroupSeat++;
	var numOfGroupSeat = ++groupSeatSize.value;
	var element = `<tr id="hrRow${numOfGroupSeat}"><td colspan="100"><hr style="width:100%; color:#a8a2a2;"></td></tr>
					<tr id="groupSeatRow${numOfGroupSeat}">
						<td width="80px">
							<a id="groupSeat${numOfGroupSeat}" href="#" onclick="select_goods_photo(this); return false;">
								<img id="groupSeat${numOfGroupSeat}_img" class="product_image" src="${contextPath}/resources/image/add_picture.svg">
							</a>
							<input id="groupSeat${numOfGroupSeat}_photo_file_input" class="photo_file_input" name="groupSeatPhoto${numOfGroupSeat}" type="file" onchange="on_goods_photo_changed(this)">
						</td>
						<td width="420px">
							<div>
								<input type="text" id="groupSeat${numOfGroupSeat}_seatName" name="groupSeat${numOfGroupSeat}_name" placeholder="상품명">
								<input type="text" id="groupSeat${numOfGroupSeat}_price" name="groupSeat${numOfGroupSeat}_price" placeholder="상품가격(원)">
								<textarea rows="2" style="width:100%;  margin-top:5px" name="groupSeat${numOfGroupSeat}_description" placeholder="상품설명"></textarea>
							</div>
						</td>
						<td width="28px" style="text-align:center;"><input type="button" class="orderDeleteButton"onclick="deleteGroupSeat(this.parentNode.parentNode);" value="삭제"></td>
					</tr>`;
	groupSeatTable.innerHTML += element;
}

function addPhoto(contextPath, groupSeatTable){
	var numOfPhoto = ++photoSize.value;
	var element = `<tr id="hrRow${numOfPhoto}"><td colspan="100"><hr style="width:100%; color:#a8a2a2;"></td></tr>
					<tr id="cafePhoto${numOfPhoto}">
						<td width="80px">
							<a id="cafe${numOfPhoto}" href="#" onclick="select_goods_photo(this); return false;">
								<img class="product_image" id="cafe${numOfPhoto}_img" src="${contextPath}/resources/image/add_picture.svg">
							</a>
							
						</td>
						<td><input id="cafe${numOfPhoto}_photo_file_input" name="cafePhoto${numOfPhoto}" type="file" onchange="on_goods_photo_changed(this)"></td>
						<td width="28px" style="text-align:center;"><input type="button" class="orderDeleteButton" onclick="deletePhoto(this.parentNode.parentNode);" value="삭제"></td>
					</tr>`;
	groupSeatTable.innerHTML += element;
}

function addParkingLot(parkingLotTable){
	var numOfParkingLot = ++parkingLotSize.value;
	var element = `<tr id="hrRow${numOfParkingLot}"><td colspan="100"><hr style="width:100%; color:#a8a2a2;"></td></tr>
					<tr id="parkingLotRow${numOfParkingLot}">
						<td width="80px">
							<table width="550px">
								<tr><td><h3 class="productName no-top_bottom_margin margin-left-10px">주차장${numOfParkingLot}</h3></td></tr>
								<tr><td><input type="text" width="550px" class="address_input_box" name="parkingLot${numOfParkingLot}_name" placeholder="주차장명"></td></tr>
								<tr><td><input type="text" width="550px" id="parkingLot${numOfParkingLot}_Address1" class="address_input_box" name="parkingLot${numOfParkingLot}_location1" placeholder="주소" readonly><button onclick="setParkingLotAddress1(${numOfParkingLot});return false;">주소찾기</button></td></tr>
								<tr><td><input type="text" width="100%" class="address_input_box" name="parkingLot${numOfParkingLot}_location2" placeholder="상세주소"></td></tr>
							</table>
						</td>
						<td width="28px" style="text-align:center;"><input type="button" class="orderDeleteButton" onclick="deleteParkingLot(this.parentNode.parentNode)" value="삭제"></td>
						
					</tr>`;
	parkingLotTable.innerHTML += element;
}

function deleteGoods(container){
	//if(numOfGoods>1){
	if(goodsSize.value>1){
		var hrRow = document.getElementById("hrRow"+goodsSize.value);
		if(hrRow != undefined){
			hrRow.remove();
		}
		
		container.remove();
		
		goodsSize.value--;
		//numOfGoods--;
	}
}
function deleteGroupSeat(container){
	if(goodsSize.value>1){
		var hrRow = document.getElementById("hrRow"+goodsSize.value);
		if(hrRow != undefined){
			hrRow.remove();
		}
		
		container.remove();
		
		goodsSize.value--;
	}
}

function deletePhoto(container){
	if(photoSize.value>1){
		var hrRow = document.getElementById("hrRow"+photoSize.value);
		if(hrRow != undefined){
			hrRow.remove();
		}
		container.remove();
		
		photoSize.value--;
	}
}

function deleteParkingLot(container){
	if(parkingLotSize.value>1){
		var hrRow = document.getElementById("hrRow"+parkingLotSize.value);
		if(hrRow != undefined){
			hrRow.remove();
		}
		
		container.remove();
		
		parkingLotSize.value--;
	}
}