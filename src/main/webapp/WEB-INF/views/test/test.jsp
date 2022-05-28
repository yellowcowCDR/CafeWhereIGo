<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    isELIgnored="false"  
%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>주소로 장소 표시하기</title>
    
</head>
<body>
<div id="map" style="width:100%;height:350px;"></div>
<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=6ee71689aaa8aa4f420e61071a31891c&libraries=services"></script>
<script type="text/javascript">
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
            content: '<div style="width:max-content;text-align:center;padding:6px 6px 6px 6px;"><h5 style="margin-bottom:0px;"><b>우리회사</b></h5><p style="margin-bottom:0px;">'+result[0].address.address_name+'</p></div>'
        });
        infowindow.open(map, marker);

        // 지도의 중심을 결과값으로 받은 위치로 이동시킵니다
        map.setCenter(coords);
    } 
}

var addrList =['대전 서구 둔산서로 65', '대전 서구 대덕대로220번길 38','대전 서구 대덕대로 248']

// 주소로 좌표를 검색합니다
addrList.forEach(address => geocoder.addressSearch(address, geocoderCallbackFunction));
//geocoder.addressSearch('대전 유성구 봉산동 302', geocoderCallbackFunction);    
</script>
<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<script>
	function searchPostcode(){
	    new daum.Postcode({
	        oncomplete: function(data) {
	            // 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분입니다.
	            // 예제를 참고하여 다양한 활용법을 확인해 보세요.
	            console.log("address: "+data.roadAddress);
	            console.log("address: "+data.jibunAddress);
	        }
	    }).open();
	}
</script>
<button onclick="searchPostcode()">주소찾기</button>
</body>
</html>