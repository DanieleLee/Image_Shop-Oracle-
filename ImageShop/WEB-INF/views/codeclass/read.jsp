<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
    

	<h2><spring:message code="codeclass.header.read"/></h2>

	<form:form modelAttribute="codeClass">
	   <table>
	   	 <tr>
	   		<td><spring:message code="codeclass.classCode"/></td>
	     	<td><form:input path="classCode" readonly/></td>
	     	<td><font color="red"><form:errors path="classCode"/></font></td>
	     </tr>
	    <tr>
	   		<td><spring:message code="codeclass.className"/></td>
	     	<td><form:input path="className" readonly/></td>
	     	<td><font color="red"><form:errors path="className"/></font></td>
	     </tr>
	     
	   </table>
	</form:form>
	
	<div>
		<button type="submit" id="btnEdit">
		<spring:message code="action.edit"/></button>
		<button type="submit" id="btnRemove">
		<spring:message code="action.remove"/></button>
		<button type="submit" id="btnList">
		<spring:message code="action.list"/></button >
	</div>
	<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
	<script type="text/javascript">
		$(document).ready(function(){
			
			var formObj=$("#codeClass");
			
			$("#btnEdit").on("click",function(){
				var classCode=$("#classCode");
				var classCodeVal=classCode.val();
				
				self.location="modify?classCode="+
						classCodeVal;
				});
			
			$("#btnRemove").on("click",function(){
				formObj.attr("action","/codeclass/remove");
				formObj.submit();
			});
			
			$("#btnList").on("click",function(){
				self.location="list";
			});
			
		});
	
	
	</script>
