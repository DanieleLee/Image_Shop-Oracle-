<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<h2><spring:message code="codedetail.header.register"></spring:message></h2>

<form:form modelAttribute="codeDetail" action="register">
<table>
	<tr> 
		<td><spring:message code="codedetail.classCode"/></td>	
		<td><form:select path="classCode" items="${classCodeList }" itemValue="value" itemLabel="label"/></td>	
		<td><font color="red"><form:errors path="classCode"></form:errors></font></td>	
	
	</tr>
	<tr>
		<td><spring:message code="codedetail.codeValue"/></td>	
		<td><form:input path="codeValue"/></td>	
		<td><font color="red"><form:errors path="classValue"></form:errors></font></td>	
	
	</tr>
	<tr>
		<td><spring:message code="codedetail.codeName"/></td>	
		<td><form:input path="codeName"/></td>	
		<td><font color="red"><form:errors path="className"></form:errors></font></td>	
	
	</tr>

</table>
</form:form>

<div>
	<button type="submit" id="btnRegister"><spring:message code="action.register"/></button>
	<button type="submit" id="btnList"><spring:message code="action.list"/></button>
</div>
<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
<script>

	$(document).ready(function(){
		
		var formObj=$("#codeDetail");
		
		$("#btnRegister").on("click",function(){
			formObj.submit();
			
		});
		
		$("#btnList").on("click",function(){
			self.location="list";
		});
		
	});
	


</script>