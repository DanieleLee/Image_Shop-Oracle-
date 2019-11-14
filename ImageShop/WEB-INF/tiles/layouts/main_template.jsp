<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<!DOCTYPE html>
<html>
<head>
	<title><tiles:getAsString name="title"/></title>
<meta charset="UTF-8">

</head>
<script type="http://code.jquery.com/jquery-3.1.0.min.js"></script>
<body>
	<tiles:insertAttribute name="header"/>
	<tiles:insertAttribute name="menu"/>
	<div align="center">
		<tiles:insertAttribute name="content"/>
	</div>

	<tiles:insertAttribute name="footer"/>
</body>
</html>