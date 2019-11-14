<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 <%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
 <%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2><spring:message code="board.header.register"></spring:message></h2>

	<form:form modelAttribute="board" action="register">
		<table>
			<tr>
				<td><spring:message code="board.title"/></td>
				<td><form:input path="title"/></td>
				<td><font color="red"><form:errors path="title"></form:errors></font></td>
			
			</tr>
			<tr>
				<td><spring:message code="board.writer"/></td>
				<td><form:input path="writer" readonly="true"/></td>
				<td><font color="red"><form:errors path="writer"></form:errors></font></td>
			
			</tr>
			<tr>
				<td><spring:message code="board.content"/></td>
				<td><form:input path="content"/></td>
				<td><font color="red"><form:errors path="content"></form:errors></font></td>
			
			</tr>
		</table>
	
	</form:form>

	<div>
		<sec:authorize access="isAuthenticated()">
			<button type="submit" id="btnRegister"><spring:message code="action.register"/></button>
		</sec:authorize>
	
		<button type="submit" id="btnList"><spring:message code="action.list"/></button>
	</div>
	<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
	<script >
		$(document).ready(function(){
			var formObj=$("#board");
			
			$("#btnRegister").on("click",function(){
				formObj.submit();
			});
			
			$("#btnList").on("click",function(){
				self.location="list";
			});
		})
	
	</script>
</body>
</html>