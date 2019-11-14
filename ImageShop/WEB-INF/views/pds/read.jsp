<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
  <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
 <%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 
	<h2><spring:message code="pds.header.read" /></h2>

<form:form modelAttribute="pds" action="modify" enctype="multipart/form-data">
	<form:hidden path="itemId" />
	
	<table>
		<tr>
			<td><spring:message code="pds.itemName" /></td>
			<td><form:input path="itemName"  /></td>
			<td><font color="red"><form:errors path="itemName" /></font></td>
		</tr>
		<tr>
			<td><spring:message code="pds.itemFile" /></td>
			<td><div class="uploadedList"></div></td>
		</tr>
		<tr>
			<td><spring:message code="pds.itemDescription" /></td>
			<td><form:textarea path="description"/></td>
			<td><font color="red"><form:errors path="description"></form:errors></font></td>
		</tr>
	</table>
</form:form>

<div>
	<button type="submit" id="btnList"><spring:message code="action.list"/></button>
</div>

<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
<script>
	$(document).ready(function() {

		var formObj = $("#item");
	

		$("#btnList").on("click",function(){
			self.location="list";
		});
	});
</script>

<script type="text/javascript">
	$(document).ready(function(){
		
		function getOriginalName(fileName){
			var idx=fileName.indexOf("_")+1;
			return fileName.substr(idx);
			
		}
			var itemId=${pds.itemId};
			
			console.log("itemId:"+itemId);
			
			$.getJSON("/pds/getAttach/"+itemId,function(list){
				$(list).each(function(){
					console.log("data:"+this);
					
					var data=this;
					
					console.log("data:"+data);
					console.log("getOriginaName(data):"+getOriginalName(data));
					
					var str = "<div><a href='/pds/downloadFile?fullName="+data+"'>" + getOriginalName(data)+"</a></div>";
					
					$(".uploadedList").append(str);
				});
			});
		
	});
</script>
