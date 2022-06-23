/**
 * 
 */
function searchCafeHome(contextPath, theme){
	var searchForm= document.createElement("form");
	searchForm.method="post";
	searchForm.action=contextPath+"/cafe/search.do";
	
	var formContent =
	`<input type="hidden" name="theme" value="${theme}">`
	
	searchForm.innerHTML=formContent;
	document.body.appendChild(searchForm);
	searchForm.submit();
	
}