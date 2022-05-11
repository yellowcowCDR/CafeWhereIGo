<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    isELIgnored="false"  
%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<c:set var="contextPath"  value="${pageContext.request.contextPath}"  /> 
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title><tiles:insertAttribute name="title" /></title>
		<link rel="shortcut icon" href="${contextPath}/resources/image/cafe_black_24dp.svg">
		<style>
			#wrap header{
				z-index:99999;
			}
		</style>
	</head>
	
	<body>
		<div id="wrap">
				<header>
					   <tiles:insertAttribute name="header" />
				</header>
				<aside>
					 <tiles:insertAttribute name="side" />
				</aside>
				<article>
				 	<tiles:insertAttribute name="body" />
				</article>
				<div class="clear"></div>
				<footer>
	        		<tiles:insertAttribute name="footer" />
	        	</footer>
			</div>
	</body>
</html>