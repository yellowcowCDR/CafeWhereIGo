<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    isELIgnored="false"  
%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %> 
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="contextPath"  value="${pageContext.request.contextPath}"  />
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>footer</title>
		<style>
			.footer_text{
				text-align:center;
				margin:0px;
			}
		</style>	
	</head>
	
	<body>
		<footer>
			<p class="footer_text">상호명: 카페어디가(주) | 대표명: 홍길동 | 사업자 등록번호: 000-00-00000 | 통신판매업신고: 2022-대전유성-0000 | 주소: 대전광역시 유성구 봉산동 302<br>
			<p class="footer_text">&copy; All Rights Reserved by Dae Ryeon Choi.</p>
		</footer>
	</body>
</html>