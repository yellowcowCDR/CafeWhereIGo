/*window.onload= parkinglot_tab_ciliked;*/
let parkingLot_cursor=0;
function parkinglot_tab_ciliked(){
	var addrCnt =0;
	var mapContainer = document.getElementById('map'), // 지도를 표시할 div 
        mapOption = {
            center: new kakao.maps.LatLng(33.450701, 126.570667), // 지도의 중심좌표
            level: 3 // 지도의 확대 레벨
        };  

    // 지도를 생성합니다    
    var map = new kakao.maps.Map(mapContainer, mapOption); 

    // 주소-좌표 변환 객체를 생성합니다
    var geocoder = new kakao.maps.services.Geocoder();

    // 주소-좌표 변환 콜백함수
    var geocoderCallbackFunction = function(result, status) {

        // 정상적으로 검색이 완료됐으면 
        if (status === kakao.maps.services.Status.OK) {

            var coords = new kakao.maps.LatLng(result[0].y, result[0].x);

            // 결과값으로 받은 위치를 마커로 표시합니다
            var marker = new kakao.maps.Marker({
                map: map,
                position: coords
            });

            // 인포윈도우로 장소에 대한 설명을 표시합니다
            var infowindow = new kakao.maps.InfoWindow({
                content: '<div style="width:max-content;text-align:center;padding:6px 6px 6px 6px;"><h5 style="margin-bottom:0px;"><b>'+parkingLogNameList[addrCnt++]+'</b></h5><p style="margin-bottom:0px;">'+result[0].address.address_name+'</p></div>'
            });
            infowindow.open(map, marker);

            // 지도의 중심을 결과값으로 받은 위치로 이동시킵니다
            map.setCenter(coords);
        } 
    }

    //var addrList =['대전 서구 둔산서로 65', '대전 서구 대덕대로220번길 38','대전 서구 대덕대로 248']

    // 주소로 좌표를 검색합니다
    addrList.forEach(address => geocoder.addressSearch(address, geocoderCallbackFunction));
    //geocoder.addressSearch('대전 유성구 봉산동 302', geocoderCallbackFunction);
}

function setGoodsTotalPriceCafeDatail(goodsRow){
	var elements = goodsRow.getElementsByTagName('input');
	
	var unitPrice = elements['unitPrice'].value;
	
	var quantity = elements['quantity'].value;
	
	var totalPriceInput = elements['goods_unit_totalPrice'];
	totalPriceInput.value = unitPrice*quantity; 
	
	var temp = goodsRow.getElementsByClassName("price-text");
	var totalPriceIndicator = temp[0];
	totalPriceIndicator.innerText ="총 "+unitPrice*quantity+"원"
}

function setGroupSeatTotalPriceCafeDatail(goodsRow){
	var elements = goodsRow.getElementsByTagName('input');
	
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
		
		var temp = goodsRow.getElementsByClassName("price-text");
		var totalPriceIndicator = temp[0];
		totalPriceIndicator.innerText ="총 "+totalPrice+"원"
	}
}
function toggleLikeCafe(contextPath, cafe_id){
	$.ajax({
		method: "POST",
		data: {
			"cafe_id": cafe_id,
		},
		url: contextPath+"/cafe/toggleLikeCafe.do",
		success: function(data){
		},
		error:function(jqXHR, textStatus, errorThrown){
			alert("찜하기에 실패하였습니다. 에러코드 "+jqXHR.status);	
		}
	});
}
function cafeScoreInputValidation(e){
		var value =e.value;
		if(value>100){
			alert("점수 값은 100보다 작아야 합니다.");
			e.value=100;
		}else if(value<0){
			alert("점수 값은 0보다 커야 합니다.");
			e.value=0;
		}
	}