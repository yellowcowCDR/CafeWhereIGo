/**
 * 
 */
var goodsSize;
var groupSeatSize;
var photoSize;
var parkingLotSize;

var sidoSelector;
var sigoonSelector;
var dongSelector;
var leeSelector;

var cafeLocationTokens;
var sido="";
var sigoon="";
var dong="";
var lee="";

window.onload=function(){
	goodsSize = document.getElementById("goodsSize");
	groupSeatSize = document.getElementById("groupSeatSize");
	photoSize = document.getElementById("photoSize");
	parkingLotSize = document.getElementById("parkingLotSize");
	
	initPhonenum1();
	
	sidoSelector = document.getElementById("region1");
	sigoonSelector = document.getElementById("region2");
	dongSelector = document.getElementById("region3");
	leeSelector = document.getElementById("region4");
	
	cafeLocationTokens = cafeLocation1.split(" ");
	cafeLocation1Init();
}

$(function(){
	$.ajax({
		type: "get",
		url: "https://api.vworld.kr/req/data?key=3D86E57E-20E4-3D63-A23B-FB9112A499A1&domain=http://localhost:8080&service=data&version=2.0&request=getfeature&format=json&size=1000&page=1&geometry=false&attribute=true&crs=EPSG:3857&geomfilter=BOX(13663271.680031825,3894007.9689600193,14817776.555251127,4688953.0631258525)&data=LT_C_ADSIDO_INFO",
		async: false,
		dataType: 'jsonp',
		success: function(data) {
			let html = "<option>선택</option>";
	
			data.response.result.featureCollection.features.forEach(function(f){
				console.log(f.properties)
				let regionCode = f.properties.ctprvn_cd;
				let region = f.properties.ctp_kor_nm;
				
				html +=`<option value="${regionCode}">${region}</option>`
				
			})
			
	        $('#region1').html(html);
			
		},
		error: function(xhr, stat, err) {}
	});
	
});

function sidoChanged(e){
	let sidoValue = e.value;
	let cafe_region1 = document.getElementById("cafe_region1");
	
		cafe_region1.value= e.options[e.selectedIndex].text
		$.ajax({
			type: "get",
			url: "https://api.vworld.kr/req/data?key=3D86E57E-20E4-3D63-A23B-FB9112A499A1&domain=http://localhost:8080&service=data&version=2.0&request=getfeature&format=json&size=1000&page=1&geometry=false&attribute=true&crs=EPSG:3857&geomfilter=BOX(13663271.680031825,3894007.9689600193,14817776.555251127,4688953.0631258525)&data=LT_C_ADSIGG_INFO",
			data : {attrfilter : 'sig_cd:like:'+sidoValue},
			async: false,
			dataType: 'jsonp',
			success: function(data) {
				let html = "<option>선택</option>";
	
				data.response.result.featureCollection.features.forEach(function(f){
					console.log(f.properties)
					let regionCode = f.properties.sig_cd;
					let region = f.properties.sig_kor_nm;
					
					html +=`<option value="${regionCode}">${region}</option>`
					 
				})
	            $('#region2').html(html);			
			},
			error: function(xhr, stat, err) {}
		});
	
}

function sigoonChanged(e){
	let sigoonValue = e.value;
	let cafe_region2 = document.getElementById("cafe_region2");
	cafe_region2.value= e.options[e.selectedIndex].text
	$.ajax({
		type: "get",
		url: "https://api.vworld.kr/req/data?key=3D86E57E-20E4-3D63-A23B-FB9112A499A1&domain=http://localhost:8080&service=data&version=2.0&request=getfeature&format=json&size=1000&page=1&geometry=false&attribute=true&crs=EPSG:3857&geomfilter=BOX(13663271.680031825,3894007.9689600193,14817776.555251127,4688953.0631258525)&data=LT_C_ADEMD_INFO",
		data : {attrfilter : 'emd_cd:like:'+sigoonValue},
		async: false,
		dataType: 'jsonp',
		success: function(data) {
			let html = "<option>선택</option>";

			data.response.result.featureCollection.features.forEach(function(f){
				console.log(f.properties)
				let regionCode = f.properties.emd_cd;
				let region = f.properties.emd_kor_nm;
				
				html +=`<option value="${regionCode}">${region}</option>`
				
			})
            $('#region3').html(html);
			
		},
		error: function(xhr, stat, err) {}
	});
}

function dongChanged(e){
	let dongValue = e.value;
	let cafe_region3 = document.getElementById("cafe_region3");
	cafe_region3.value= e.options[e.selectedIndex].text
	$.ajax({
		type: "get",
		url: "https://api.vworld.kr/req/data?key=3D86E57E-20E4-3D63-A23B-FB9112A499A1&domain=http://localhost:8080&service=data&version=2.0&request=getfeature&format=json&size=1000&page=1&geometry=false&attribute=true&crs=EPSG:3857&geomfilter=BOX(13663271.680031825,3894007.9689600193,14817776.555251127,4688953.0631258525)&data=LT_C_ADRI_INFO",
		data : {attrfilter : 'li_cd:like:'+dongValue},
		async: false,
		dataType: 'jsonp',
		success: function(data) {
			let html = "<option>선택</option>";

			data.response.result.featureCollection.features.forEach(function(f){
				console.log(f.properties)
				let region = f.properties.li_kor_nm;
				html +=`<option value="${region}">${region}</option>`
				
			})
            $('#region4').html(html);
			
		},
		error: function(xhr, stat, err) {}
	});

}

function leeChanged(e){
	let cafe_region4 = document.getElementById("cafe_region4");
	cafe_region4.value= e.options[e.selectedIndex].text
}

function cafeLocation1Init(){

	if(cafeLocationTokens.length>=1){
		sido = cafeLocationTokens[0];
		var sidoCode=initSido(sidoSelector, sido);
		initSiGoonList(sidoCode)
	}
}

function initSido(sidoSelector, sido){
	var sidoOptions = sidoSelector.children;
	for(var i=0; i<sidoOptions.length; i++){
		if(sidoOptions[i].innerText == sido){
			sidoOptions[i].selected=true;
			var cafe_region1 = document.getElementById("cafe_region1");
			cafe_region1.value=sidoOptions[i].innerText;
			return sidoOptions[i].value;
		}
	}
}

function initSigoon(sigoonSelector,sigoon){
	var sigoonOptions = sigoonSelector.children;
	for(var i=0; i<sigoonOptions.length; i++){
		if(sigoonOptions[i].innerText == sigoon){
			sigoonOptions[i].selected=true;
			var cafe_region2 = document.getElementById("cafe_region2");
			cafe_region2.value=sigoonOptions[i].innerText;
			return sigoonOptions[i].value;
		}
	}
}

function initDong(dongSelector,dong){
	var dongOptions = dongSelector.children;
	for(var i=0; i<dongOptions.length; i++){
		if(dongOptions[i].innerText == dong){
			dongOptions[i].selected=true;
			var cafe_region3 = document.getElementById("cafe_region3");
			cafe_region3.value=dongOptions[i].innerText;
			return dongOptions[i].value;
		}
	}
}

function initLee(leeSelector,lee){
	var leeOptions = leeSelector.children;
	for(var i=0; i<leeOptions.length; i++){
		if(leeOptions[i].innerText == lee){
			leeOptions[i].selected=true;
			var cafe_region4 = document.getElementById("cafe_region4");
			cafe_region4.value=leeOptions[i].innerText;
			return leeOptions[i].value;
		}
	}
}

function initSiGoonList(sidoCode){
	let html = "<option>선택</option>";
	$.ajax({
			type: "get",
			url: "https://api.vworld.kr/req/data?key=3D86E57E-20E4-3D63-A23B-FB9112A499A1&domain=http://localhost:8080&service=data&version=2.0&request=getfeature&format=json&size=1000&page=1&geometry=false&attribute=true&crs=EPSG:3857&geomfilter=BOX(13663271.680031825,3894007.9689600193,14817776.555251127,4688953.0631258525)&data=LT_C_ADSIGG_INFO",
			data : {attrfilter : 'sig_cd:like:'+sidoCode},
			async: false,
			dataType: 'jsonp',
			success: function(data) {
				let html = "<option>선택</option>";
	
				data.response.result.featureCollection.features.forEach(function(f){
					console.log(f.properties)
					let regionCode = f.properties.sig_cd;
					let region = f.properties.sig_kor_nm;
					
					html +=`<option value="${regionCode}">${region}</option>`
					 
				})
	            $('#region2').html(html);
			},
			error: function(xhr, stat, err) {},
			complete: function(jqXHR, textStatus){
				if(cafeLocationTokens.length>=2){
					var sigoon = cafeLocationTokens[1];
					var sigoonSelector = document.getElementById("region2");
					var sigoonCode=initSigoon(sigoonSelector,sigoon)
					initDongList(sigoonCode);
				}
			}
		});
}

function initDongList(sigoonCode){
	let html = "<option>선택</option>";
			$.ajax({
			type: "get",
			url: "https://api.vworld.kr/req/data?key=3D86E57E-20E4-3D63-A23B-FB9112A499A1&domain=http://localhost:8080&service=data&version=2.0&request=getfeature&format=json&size=1000&page=1&geometry=false&attribute=true&crs=EPSG:3857&geomfilter=BOX(13663271.680031825,3894007.9689600193,14817776.555251127,4688953.0631258525)&data=LT_C_ADEMD_INFO",
			data : {attrfilter : 'emd_cd:like:'+sigoonCode},
			async: false,
			dataType: 'jsonp',
			success: function(data) {
				let html = "<option>선택</option>";
	
				data.response.result.featureCollection.features.forEach(function(f){
					console.log(f.properties)
					let regionCode = f.properties.emd_cd;
					let region = f.properties.emd_kor_nm;
					
					html +=`<option value="${regionCode}">${region}</option>`
					
				})
	            $('#region3').html(html);
				
			},
			error: function(xhr, stat, err) {},
			complete: function(jqXHR, textStatus){
				if(cafeLocationTokens.length>=3){
				var dong = cafeLocationTokens[2];
				var dongSelector = document.getElementById("region3");
				initDong(dongSelector,dong)
				}
			}
		});
}
function initLeeList(dongCode){
	let html = "<option>선택</option>";
			$.ajax({
			type: "get",
			url: "https://api.vworld.kr/req/data?key=3D86E57E-20E4-3D63-A23B-FB9112A499A1&domain=http://localhost:8080&service=data&version=2.0&request=getfeature&format=json&size=1000&page=1&geometry=false&attribute=true&crs=EPSG:3857&geomfilter=BOX(13663271.680031825,3894007.9689600193,14817776.555251127,4688953.0631258525)&data=LT_C_ADRI_INFO",
			data : {attrfilter : 'li_cd:like:'+dongCode},
			async: false,
			dataType: 'jsonp',
			success: function(data) {
				let html = "<option>선택</option>";
	
				data.response.result.featureCollection.features.forEach(function(f){
					console.log(f.properties)
					let region = f.properties.li_kor_nm;
					html +=`<option value="${region}">${region}</option>`
					
				})
	            $('#region4').html(html);
				
			},
			error: function(xhr, stat, err) {},
			complete: function(jqXHR, textStatus){
				if(cafeLocationTokens.length==4){
					var lee = cafeLocationTokens[3];
					var leeSelector = document.getElementById("region4");
					initLee(leeSelector,lee)
				}
			}
		});
}

function initPhonenum1(){
	phonenum1Selector= document.getElementById("user_phone_number1");
	var phonenum1Options = phonenum1Selector.children;
	for(var i=0; i<phonenum1Options.length; i++){
		if(phonenum1Options[i].innerText == phonenum1){
			phonenum1Options[i].selected=true;
		}
	}
}

function setParkingLotAddress1(parkingLotNo){
	 new daum.Postcode({
	        oncomplete: function(data) {
	            // 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분입니다.
	            // 예제를 참고하여 다양한 활용법을 확인해 보세요
				var parkingLotAddress1 = document.getElementById("parkingLot"+parkingLotNo+"_location1")
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
							<input id="menu${numOfGoods}_photo_file_input" class="photo_file_input" name="menu${numOfGoods}_photo_file" type="file" onchange="on_goods_photo_changed(this)">
							<input type='hidden' name='goodsIndex' value="${numOfGoods}">
						</td>
						<td width="420px">
							<div>
								<input type="text" id="productName${numOfGoods}" name="productName${numOfGoods}" placeholder="상품명">
								<input type="text" id="productPrice${numOfGoods}" name="productPrice${numOfGoods}" placeholder="상품가격(원)">
								<textarea rows="2" style="width:100%; margin-top:5px" id="productDescription${numOfGoods}" name="productDescription${numOfGoods}" placeholder="상품설명"></textarea>
							</div>
						</td>									
						
						<td width="28px" style="text-align:center;"><input type="button" class="orderDeleteButton" onclick="deleteGoods(this.parentNode.parentNode);" value="삭제"></td>	
					</tr>`;
	menuTable.innerHTML += element;
	
}

function addGroupSeat(contextPath, groupSeatTable){
	//numOfGroupSeat++;
	var numOfGroupSeat = ++groupSeatSize.value;
	var element = `<tr id="groupSeatHrRow${numOfGroupSeat}"><td colspan="100"><hr style="width:100%; color:#a8a2a2;"></td></tr>
					<tr id="groupSeatRow${numOfGroupSeat}">
						<td width="80px">
							<a id="groupSeat${numOfGroupSeat}" href="#" onclick="select_goods_photo(this); return false;">
								<img id="groupSeat${numOfGroupSeat}_img" class="product_image" src="${contextPath}/resources/image/add_picture.svg">
							</a>
							<input id="groupSeat${numOfGroupSeat}_photo_file_input" class="photo_file_input" name="groupSeat${numOfGroupSeat}_photo_file_input" type="file" onchange="on_goods_photo_changed(this)">
							<input type='hidden' name='groupSeatIndex' value="${numOfGroupSeat}">
						</td>
						<td width="420px">
							<div>
								<input type="text" id="groupSeatName${numOfGroupSeat}" name="groupSeatName${numOfGroupSeat}" placeholder="상품명">
								<input type="text" id="groupSeatPrice${numOfGroupSeat}" name="groupSeatPrice${numOfGroupSeat}" placeholder="상품가격(원)">
								<textarea rows="2" style="width:100%;  margin-top:5px" id="groupSeatDescription${numOfGroupSeat}" name="groupSeatDescription${numOfGroupSeat}" placeholder="상품설명"></textarea>
							</div>
						</td>
						<td width="28px" style="text-align:center;"><input type="button" class="orderDeleteButton"onclick="deleteGroupSeat(this.parentNode.parentNode);" value="삭제"></td>
					</tr>`;
	groupSeatTable.innerHTML += element;
}

function addPhoto(contextPath, groupSeatTable){
	var numOfPhoto = ++photoSize.value;
	var element=""; 
	if(numOfPhoto>1){ 
		element+= `<tr id="cafePhotoHrRow${numOfPhoto}"><td colspan="100"><hr style="width:100%;"></td></tr>`
	}
	element+= `<tr id="cafePhotoRow${numOfPhoto}">
					<td width="80px">
						<a id="cafePhoto${numOfPhoto}" href="#" onclick="select_goods_photo(this); return false;">
							<img class="product_image" id="cafe${numOfPhoto}_img" src="${contextPath}/resources/image/add_picture.svg">
						</a>
						<input type="hidden" name="cafePhotoIndex" value="${numOfPhoto}">
					</td>
					<td width="420px">
						<input id="cafe${numOfPhoto}_photo_file_input" name="cafe${numOfPhoto}_photo_file_input" type="file" onchange="on_goods_photo_changed(this)"></td>
					<td width="28px" style="text-align:center;"><input type="button" class="orderDeleteButton" onclick="deletePhoto(this.parentNode.parentNode);" value="삭제"></td>
				</tr>`;
	groupSeatTable.innerHTML += element;
}

function addParkingLot(parkingLotTable){
	var numOfParkingLot = ++parkingLotSize.value;
	var element="";
	if(numOfParkingLot>1){ 
		element += `<tr id="parkingLotHrRow${numOfParkingLot}"><td colspan="100"><hr style="width:100%;"></td></tr>`
	}
	element += `<tr id="parkingLotRow${numOfParkingLot}">
				<td width="80px">
					<table width="550px">
						<tr>
							<td>
								<h3 id="parinkingLotIndicator${numOfParkingLot}" class="productName no-top_bottom_margin margin-left-10px">주차장${numOfParkingLot}</h3>
								<input type="hidden" name="parkingLotIndex" value="${numOfParkingLot}">
							</td>
						</tr>
						<tr><td><input type="text" width="550px" class="address_input_box" id="parkingLot${numOfParkingLot}_name" name="parkingLot${numOfParkingLot}_name" placeholder="주차장명"></td></tr>
						<tr><td><input type="text" width="550px" class="address_input_box" id="parkingLot${numOfParkingLot}_location1" name="parkingLot${numOfParkingLot}_location1" placeholder="주소" readonly><button onclick="setParkingLotAddress1(${numOfParkingLot});return false;">주소찾기</button></td></tr>
						<tr><td><input type="text" width="100%" class="address_input_box" id="parkingLot${numOfParkingLot}_location2" name="parkingLot${numOfParkingLot}_location2" placeholder="상세주소"></td></tr>
					</table>
				</td>
				<td width="28px" style="text-align:center;"><input type="button" class="orderDeleteButton" onclick="deleteParkingLot(this.parentNode.parentNode)" value="삭제"></td>
				
			</tr>`;
	parkingLotTable.innerHTML += element;
}

function deleteGoods(container){
	//if(numOfGoods>1){
	var rowNum=parseInt(container.id.substring(container.id.length-1,container.id.length));
	if(rowNum ==1){
		var hrRow = document.getElementById("hrRow"+(goodsSize.value-1));
		if(hrRow != null){
			hrRow.remove();
		}
		container.remove();
		
		goodsSize.value--;
		sortGoodsIndex(container);
	}
	else if(goodsSize.value>1){
		var hrRow = document.getElementById("hrRow"+goodsSize.value);
		if(hrRow != null){
			hrRow.remove();
		}
		
		container.remove();
		
		goodsSize.value--;
		
		sortGoodsIndex(container);
	}
}
function deleteGroupSeat(container){
	var rowNum=parseInt(container.id.substring(container.id.length-1,container.id.length));
	if(rowNum ==1){
		var hrRow = document.getElementById("groupSeatHrRow"+(groupSeatSize.value-1));
		if(hrRow != null){
			hrRow.remove();
		}
		container.remove();
		
		groupSeatSize.value--;
		sortGroupSeatIndex(container);
	}
	else if(groupSeatSize.value>1){
		var hrRow = document.getElementById("groupSeatHrRow"+groupSeatSize.value);
		if(hrRow != null){
			hrRow.remove();
		}
		
		container.remove();
		
		groupSeatSize.value--;
		sortGroupSeatIndex(container);
	}
}

function deletePhoto(container){
	var rowNum=parseInt(container.id.substring(container.id.length-1,container.id.length));
	if(rowNum ==1){
		var hrRow = document.getElementById("cafePhotoHrRow"+(photoSize.value-1));
		if(hrRow != null){
			hrRow.remove();
		}
		container.remove();
		
		photoSize.value--;
		sortCafePhotoIndex(container);
	}
	else if(photoSize.value>1){
		var hrRow = document.getElementById("cafePhotoHrRow"+photoSize.value);
		if(hrRow != null){
			hrRow.remove();
		}
		container.remove();
		
		photoSize.value--;
		sortCafePhotoIndex(container);
	}
}

function deleteParkingLot(container){
	if(parkingLotSize.value>1){
		var hrRow = document.getElementById("parkingLotHrRow"+parkingLotSize.value);
		if(hrRow != null){
			hrRow.remove();
		}
		
		container.remove();
		
		parkingLotSize.value--;
		
		sortParkingLotIndex(container);
	}
}

function sortGoodsIndex(container){
	var currentInputList = container.getElementsByTagName("input");
	var currentGoodsIndex = parseInt(currentInputList.namedItem("goodsIndex").value);
	var goodsSizeInt= parseInt(goodsSize.value);
	//else if currentGoodsIndex == goodsSize.value
	if(goodsSizeInt>1){
		for(var i=currentGoodsIndex+1; i<=goodsSizeInt+1; i++){
			//hrRow
			var hrRow =document.getElementById(`hrRow${i}`)
			if(hrRow != null){
				hrRow.id = `hrRow${i-1}`
			}
			//goods id
			var goods_id=document.getElementById(`goods${i}_id`);
			if(goods_id!=null){
				goods_id.id=`goods${i-1}_id`;
				goods_id.name=`goods${i-1}_id`;
			}
			//productRow
			var productRow = document.getElementById(`productRow${i}`)
			productRow.id = `productRow${i-1}`
			
			//goods index
			var inputList = productRow.getElementsByTagName("input");
			var goodsIndex = inputList.namedItem("goodsIndex");
			goodsIndex.value=i-1
			
			//menu${status.count}
			var menu = document.getElementById(`menu${i}`);
			menu.id = `menu${i-1}`
			
			//menu${status.count}_img
			var menu_img = document.getElementById(`menu${i}_img`);
			menu_img.id = `menu${i-1}_img`
			
			//menu${status.count}_photo_file_input
			var menu_photo_file_input = document.getElementById(`menu${i}_photo_file_input`)
			menu_photo_file_input.id = `menu${i-1}_photo_file_input`
			menu_photo_file_input.name= `menu${i-1}_photo_file`
			
			//goodsPhotoName${status.count}
			var goodsPhotoName = document.getElementById(`goodsPhotoName${i}`);
			if(goodsPhotoName != null){
				goodsPhotoName.id = `goodsPhotoName${i-1}`;
				goodsPhotoName.name=`goodsPhotoName${i-1}`;
			}
			
			//productName${status.count}
			var productName = document.getElementById(`productName${i}`);
			productName.id=`productName${i-1}`;
			productName.name=`productName${i-1}`;
			
			//productPrice${status.count}
			var productPrice = document.getElementById(`productPrice${i}`);
			productPrice.id=`productPrice${i-1}`;
			productPrice.name=`productPrice${i-1}`;
			
			//productDescription${status.count}
			var productDescription = document.getElementById(`productDescription${i}`);
			productDescription.id=`productDescription${i-1}`;
			productDescription.name=`productDescription${i-1}`;
		}	
	}
}

function sortGroupSeatIndex(container){
	var currentInputList = container.getElementsByTagName("input");
	var currentGroupSeatIndex = parseInt(currentInputList.namedItem("groupSeatIndex").value);
	var groupSeatSizeInt= parseInt(groupSeatSize.value);
	//else if currentGoodsIndex == goodsSize.value
	if(groupSeatSizeInt>1){
		for(var i=currentGroupSeatIndex+1; i<=groupSeatSizeInt+1; i++){
			//hrRow
			var groupSeatHrRow =document.getElementById(`groupSeatHrRow${i}`)
			if(groupSeatHrRow != null){
				groupSeatHrRow.id = `groupSeatHrRow${i-1}`
			}
			//groupSeat id
			var groupSeat_id=document.getElementById(`groupSeat${i}_id`);
			if(groupSeat_id!=null){
				groupSeat_id.id=`groupSeat${i-1}_id`;
				groupSeat_id.name=`groupSeat${i-1}_id`;
			}
			//groupSeatRow
			var groupSeatRow = document.getElementById(`groupSeatRow${i}`)
			groupSeatRow.id = `groupSeatRow${i-1}`
			
			//group seat index
			var inputList = groupSeatRow.getElementsByTagName("input");
			var groupSeatIndex = inputList.namedItem("groupSeatIndex");
			groupSeatIndex.value=i-1
			
			//groupSeat${status.count}
			var groupSeat = document.getElementById(`groupSeat${i}`);
			groupSeat.id = `groupSeat${i-1}`
			
			//groupSeat${status.count}_img
			var groupSeat_img = document.getElementById(`groupSeat${i}_img`);
			groupSeat_img.id = `groupSeat${i-1}_img`
			
			//groupSeat${status.count}_photo_file_input
			var groupSeat_photo_file_input = document.getElementById(`groupSeat${i}_photo_file_input`)
			groupSeat_photo_file_input.id = `groupSeat${i-1}_photo_file_input`
			groupSeat_photo_file_input.name= `groupSeat${i-1}_photo_file_input`
			
			//groupSeatPhotoName${status.count}
			var groupSeatPhotoName = document.getElementById(`groupSeatPhotoName${i}`);
			if(groupSeatPhotoName != null){
				groupSeatPhotoName.id = `groupSeatPhotoName${i-1}`;
				groupSeatPhotoName.name=`groupSeatPhotoName${i-1}`;
			}
			
			//groupSeatName${status.count}
			var groupSeatName = document.getElementById(`groupSeatName${i}`);
			groupSeatName.id=`groupSeatName${i-1}`;
			groupSeatName.name=`groupSeatName${i-1}`;
			
			//groupSeatPrice${status.count}
			var groupSeatPrice = document.getElementById(`groupSeatPrice${i}`);
			groupSeatPrice.id=`groupSeatPrice${i-1}`;
			groupSeatPrice.name=`groupSeatPrice${i-1}`;
			
			//groupSeatDescription${status.count}
			var groupSeatDescription = document.getElementById(`groupSeatDescription${i}`);
			groupSeatDescription.id=`groupSeatDescription${i-1}`;
			groupSeatDescription.name=`groupSeatDescription${i-1}`;
		}	
	}
}

function sortCafePhotoIndex(container){
	var currentInputList = container.getElementsByTagName("input");
	var currentCafePhotoIndex = parseInt(currentInputList.namedItem("cafePhotoIndex").value);
	var photoSizeInt= parseInt(photoSize.value);
	//else if currentGoodsIndex == photoSize.value
	if(photoSizeInt>1){
		for(var i=currentCafePhotoIndex+1; i<=photoSizeInt+1; i++){
			//hrRow
			var cafePhotoHrRow =document.getElementById(`cafePhotoHrRow${i}`)
			if(cafePhotoHrRow != null){
				cafePhotoHrRow.id = `cafePhotoHrRow${i-1}`
			}
			//cafePhoto id 
			var cafePhoto_id=document.getElementById(`cafePhoto${i}_id`);
			if(cafePhoto_id!=null){
				cafePhoto_id.id=`cafePhoto${i-1}_id`;
				cafePhoto_id.name=`cafePhoto${i-1}_id`;
			}
			//cafePhotoRow
			var cafePhotoRow = document.getElementById(`cafePhotoRow${i}`)
			cafePhotoRow.id = `cafePhotoRow${i-1}`
			
			//cafePhoto index
			var inputList = cafePhotoRow.getElementsByTagName("input");
			var cafePhotoIndex = inputList.namedItem("cafePhotoIndex");
			cafePhotoIndex.value=i-1;
			
			//cafePhoto${status.count}
			var cafePhoto = document.getElementById(`cafePhoto${i}`);
			cafePhoto.id = `cafePhoto${i-1}`
			
			//cafePhoto${status.count}_img
			var cafePhoto_img = document.getElementById(`cafe${i}_img`);
			cafePhoto_img.id = `cafe${i-1}_img`
			
			//cafePhoto${status.count}_photo_file_input
			var cafe_photo_file = document.getElementById(`cafe${i}_photo_file_input`)
			cafe_photo_file.id = `cafe${i-1}_photo_file_input`
			cafe_photo_file.name= `cafe${i-1}_photo_file_input`
			
			//cafePhotoName${status.count}
			var cafePhotoName = document.getElementById(`cafePhotoName${i}`);
			if(cafePhotoName != null){
				cafePhotoName.id = `cafePhotoName${i-1}`;
				cafePhotoName.name=`cafePhotoName${i-1}`;
			}
		}	
	}
}

function sortParkingLotIndex(container){
	var currentInputList = container.getElementsByTagName("input");
	var currentParkingLotIndex = parseInt(currentInputList.namedItem("parkingLotIndex").value);
	var parkingLotSizeInt= parseInt(parkingLotSize.value);
	//else if currentGoodsIndex == photoSize.value
	if(parkingLotSizeInt>1){
		for(var i=currentParkingLotIndex+1; i<=parkingLotSizeInt+1; i++){
			//hrRow
			var parkingLotHrRow =document.getElementById(`parkingLotHrRow${i}`)
			if(parkingLotHrRow != null){
				parkingLotHrRow.id = `parkingLotHrRow${i-1}`
			}
			
			//parkingLotRow
			var parkingLotRow = document.getElementById(`parkingLotRow${i}`)
			parkingLotRow.id = `parkingLotRow${i-1}`
			
			//parkingLot id 
			var parkingLot_id=document.getElementById(`parkingLot${i}_id`);
			if(parkingLot_id!=null){
				parkingLot_id.id=`parkingLot${i-1}_id`;
				parkingLot_id.name=`parkingLot${i-1}_id`;
			}
			
			//parinkingLotIndicator${status.count}
			var parinkingLotIndicator = document.getElementById(`parinkingLotIndicator${i}`);
			parinkingLotIndicator.id=`parinkingLotIndicator${i-1}`;
			parinkingLotIndicator.innerText=`주차장${i-1}`; 
			
			//parking lot index
			var inputList = parkingLotRow.getElementsByTagName("input");
			var parkingLotIndex = inputList.namedItem("parkingLotIndex");
			parkingLotIndex.value=i-1;
			
			//parkingLot${status.index+1}_name
			var parkingLot_name = document.getElementById(`parkingLot${i}_name`)
			parkingLot_name.id = `parkingLot${i-1}_name`
			parkingLot_name.name= `parkingLot${i-1}_name`
			
			//parkingLot${status.index+1}_location1
			var parkingLot_location1 = document.getElementById(`parkingLot${i}_location1`)
			parkingLot_location1.id = `parkingLot${i-1}_location1`
			parkingLot_location1.name= `parkingLot${i-1}_location1`
			
			//parkingLot${status.index+1}_location2
			var parkingLot_location2 = document.getElementById(`parkingLot${i}_location2`)
			parkingLot_location2.id = `parkingLot${i-1}_location2`
			parkingLot_location2.name= `parkingLot${i-1}_location2`
		}	
	}
}

function select_cafe_photo_with_button(photo_input_id){
	let photo_input = document.getElementById(`cafe${photo_input_id}_photo_file_input`);
	photo_input.click();
}