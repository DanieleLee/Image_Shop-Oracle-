<%@page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ page session="false" %>
<html>
<head>
	<title>Home</title>
</head>
<body>
<h1>
	<!-- 메세지 프로퍼티파일로부터 내용가져오기 -->
	<spring:message code="common.homeWelcome"/>
</h1>

<P>   ${serverTime} </P>
</body>
</html>
