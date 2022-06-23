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
