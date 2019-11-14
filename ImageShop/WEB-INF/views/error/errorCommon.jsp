<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h2><spring:message  code="common.error.errorOccurred"/></h2>
	<a href="javascript:window.history.back();"><spring:message code="common.error.backPage"/></a>
	<a href="/"><spring:message code="common.error.returnHome"/></a>

</body>
</html>