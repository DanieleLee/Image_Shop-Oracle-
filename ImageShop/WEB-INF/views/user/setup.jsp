<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
 <%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2><spring:message code="user.header.register"></spring:message></h2>
	<form:form modelAttribute="member" action="setup">
		<table>
			<tr>
				<td><spring:message code="user.userId"></spring:message></td>
				<td><form:input path="userId"/></td>
				<td><font color="red"><form:errors path="userId"></form:errors></font></td>
			
			</tr>
			<tr>
				<td><spring:message code="user.userPw"></spring:message></td>
				<td><form:input path="userPw"/></td>
				<td><font color="red"><form:errors path="userPw"></form:errors></font></td>
			
			</tr>
			<tr>
				<td><spring:message code="user.userName"></spring:message></td>
				<td><form:input path="userName"/></td>
				<td><font color="red"><form:errors path="userName"></form:errors></font></td>
			
			</tr>
		
		</table>
	</form:form>
	
	<div>
		<button type="submit" id="btnRegister"><spring:message code="action.register"></spring:message></button>
		<button type="submit" id="btnList"><spring:message code="action.list"></spring:message></button>
	
	</div>
	<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
	<script >
		$(document).ready(function(){
			var formObj=$("#member");
			
			$("#btnRegister").on("click",function(){
				formObj.submit();
			});
			
			$("#btnList").on("click",function(){
				self.location="list";
			});
			
		});
	
	
	</script>
</body>
</html>