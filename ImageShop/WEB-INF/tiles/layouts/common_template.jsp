<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<!DOCTYPE html>
<html>
<head>
	<title><tiles:getAsString name="title"/></title>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<!-- 메인템플릿 파일: header, menu, content, footer 4단의 레이아웃구성 -->
<script type="http://code.jquery.com/jquery-3.1.0.min.js"></script>
<body>

	<tiles:insertAttribute name="header"/>
	
	<div align="center">
		<tiles:insertAttribute name="content"/>
	</div>
</body>
</html>