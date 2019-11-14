<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
 <%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

	<h2><spring:message code="codedetail.header.read"/></h2>
	<form:form modelAttribute="codeDetail">
		<table>
			<tr>
			<td><spring:message code="codedetail.classCode"/></td>	
			<td><form:select path="classCode" items="${classCodeList }" itemValue="value" itemLabel="label" readonly/></td>	
			<td><font color="red"><form:errors path="classCode"></form:errors></font></td>	
			
			</tr>
			
			<tr>
			<td><spring:message code="codedetail.codeValue"/></td>	
			<td><form:input path="codeValue"  readonly/></td>	
			<td><font color="red"><form:errors path="codeValue"></form:errors></font></td>	
			
			</tr>
			
			<tr>
		<td><spring:message code="codedetail.codeName"/></td>	
		<td><form:input path="codeName" readonly/></td>	
		<td><font color="red"><form:errors path="className"></form:errors></font></td>	
	
	</tr>		
		</table>
	
	</form:form>
	
	<div>
	<button type="submit" id="btnEdit"><spring:message code="action.edit"/></button>
	<button type="submit" id="btnRemove"><spring:message code="action.remove"/></button>
	<button type="submit" id="btnList"><spring:message code="action.list"/></button>
</div>
	
	<script>
		$(document).ready(function(){
			var formObj=$("#codeDetail");
			
			$("#btnEdit").on("click",function(){
				
				formObj.attr("action","/codedetail/modify");
				formObj.attr("method","get");
				formObj.submit();
				
				var classCode=$("#classCode");
				var classCodeVal=classCode.val();
				
				var codeValue=$("#codeValue");
				var codeValueVal=codeValue.val();
				
				self.location="modify?classCode="+classCodeVal+"&"+"codeValue="+codeValueVal;
				
				
			$("btnRemove").on("click",function(){
				formObj.attr("action","remove");
				formObj.submit();
			});	
			
			$("btnList").on("click",function(){
				self.location="list";
			});	
				
			});
			
			
		});
	
	
	</script>


