<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<h2><spring:message code="codeclass.header.modify"></spring:message></h2>

<form:form modelAttribute="codeClass" action="modify">
<table>
	<tr>
		<td><spring:message code="codeclass.classCode"/></td>	
		<td><form:input path="classCode"/></td>	
		<td><font color="red"><form:errors path="classCode"></form:errors></font></td>	
	
	</tr>
	<tr>
		<td><spring:message code="codeclass.className"/></td>	
		<td><form:input path="className"/></td>	
		<td><font color="red"><form:errors path="className"></form:errors></font></td>	
	
	</tr>

</table>
</form:form>

<div>
	<button type="submit" id="btnModify"><spring:message code="action.modify"/></button>
	<button type="submit" id="btnList"><spring:message code="action.list"/></button>
</div>
<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
<script>

	$(document).ready(function(){
		
		var formObj=$("#codeClass");
		
		$("#btnModify").on("click",function(){
			formObj.submit();
			
		});
		
		$("#btnList").on("click",function(){
			self.location="list";
		});
		
	});
	


</script>