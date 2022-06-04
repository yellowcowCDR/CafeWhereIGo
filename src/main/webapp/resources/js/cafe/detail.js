window.onload= parkinglot_tab_ciliked;
let parkingLot_cursor=0;
function parkinglot_tab_ciliked(){
		//var container = document.getElementById('map'); //지도를 담을 영역의 DOM 레퍼런스
		var mapContainer = document.getElementById('map'), // 지도를 표시할 div 
	    mapOption = {
	        center: new kakao.maps.LatLng(33.450701, 126.570667), // 지도의 중심좌표
	        level: 4 // 지도의 확대 레벨
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
	            content: '<div style="width:max-content;text-align:center;padding:6px 6px 6px 6px;"><h5 style="margin-bottom:0px;"><b>'+parkingLogNameList[parkingLot_cursor++]+'</b></h5><p style="margin-bottom:0px;">'+result[0].address.address_name+'</p></div>'
	        });
	        infowindow.open(map, marker);
	
	        // 지도의 중심을 결과값으로 받은 위치로 이동시킵니다
	        map.setCenter(coords);
	    } 
	}
	
	addrList.forEach(address => geocoder.addressSearch(address, geocoderCallbackFunction));
}

function setTotalPrice(goodsRow){
	var elements = goodsRow.getElementsByTagName('input');
	
	var unitPrice = elements['unitPrice'].value;
	
	var quantity = elements['quantity'].value;
	
	var totalPriceInput = elements['totalPrice'];
	totalPriceInput.value = unitPrice*quantity; 
	
	var temp = goodsRow.getElementsByClassName("price-text");
	var totalPriceIndicator = temp[0];
	totalPriceIndicator.innerText ="총 "+unitPrice*quantity+"원"
}