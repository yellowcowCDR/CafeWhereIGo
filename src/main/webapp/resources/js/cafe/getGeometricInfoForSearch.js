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
	let cafe_region1 = document.getElementById("cafe_region1_value");
	
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
	let cafe_region2 = document.getElementById("cafe_region2_value");
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
	let cafe_region3 = document.getElementById("cafe_region3_value");
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
	if(prev_cafe_location3!='선택' && prev_cafe_location3!=''){
		initDong(dongSelector, prev_cafe_location3);
	}
}

function leeChanged(e){
	let cafe_region4 = document.getElementById("cafe_region4_value");
	cafe_region4.value= e.options[e.selectedIndex].text
}

function cafeLocation1Init(){
	if(prev_cafe_location1!=null && prev_cafe_location1!="" && prev_cafe_location1!="선택"){
		var sidoCode=initSido(sidoSelector, prev_cafe_location1);
		initSiGoonList(sidoCode)
	}
}

function initSido(sidoSelector, sido){
	var sidoOptions = sidoSelector.children;
	for(var i=0; i<sidoOptions.length; i++){
		if(sidoOptions[i].innerText == sido){
			sidoOptions[i].selected=true;
			var cafe_region1 = document.getElementById("cafe_region1_value");
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
			var cafe_region2 = document.getElementById("cafe_region2_value");
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
			var cafe_region3 = document.getElementById("cafe_region3_value");
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
			var cafe_region4 = document.getElementById("cafe_region4_value");
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
				if(prev_cafe_location2!=null && prev_cafe_location2!="" && prev_cafe_location2!="선택"){
					var sigoonSelector = document.getElementById("region2");
					var sigoonCode=initSigoon(sigoonSelector,prev_cafe_location2)
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
				if(prev_cafe_location3!=null && prev_cafe_location3!="" && prev_cafe_location3!="선택"){
				var dongSelector = document.getElementById("region3");
				initDong(dongSelector,prev_cafe_location3)
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
				if(prev_cafe_location4!=null && prev_cafe_location4!="" && prev_cafe_location4!="선택"){
					var leeSelector = document.getElementById("region4");
					initLee(leeSelector,prev_cafe_location4)
				}
			}
		});
}
