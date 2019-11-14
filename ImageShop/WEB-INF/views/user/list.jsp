<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<h2><spring:message code="user.header.list" /></h2>
<a href="register"><spring:message code="action.new"></spring:message></a>


	<table border="1">
		<tr>
			<th align="center" width="60"><spring:message code="user.no"></spring:message> </th>	
			<th align="center" width="80"><spring:message code="user.userId"></spring:message> </th>	
			<th align="center" width="300"><spring:message code="user.userPw"></spring:message> </th>	
			<th align="center" width="100"><spring:message code="user.userName"></spring:message> </th>	
			<th align="center" width="100"><spring:message code="user.job"></spring:message> </th>	
			<th align="center" width="180"><spring:message code="user.regdate"></spring:message> </th>	
		</tr>
		<c:choose>
			<c:when test="${empty list }">
				<tr>
					<td colspan="6">
						<spring:message code="common.listEmpty"></spring:message>
					</td>
				</tr>
				</c:when>
		</c:choose>
		
		<c:otherwise>
			<c:forEach items="${list }" var="member">
				<tr>
					<td align="center">${member.userNo }</td>
					<td align="center"><a href="/user/read?userNo=${member.userNo }">${member.userId}</a></td>
					<td align="left">${member.userPw }</td>
					<td align="right">${member.userName }</td>
					<td align="right">${member.job }</td>
					<td align="center"><fmt:formatDate value="${member.regDate }" pattern="yyyy-MM-dd HH:mm"/></td>
				</tr>
			
			</c:forEach>
		</c:otherwise>
		</table>
		
		<script>
			var result="${msg}";
			
			if(result==="SUCCESS"){
				alert("<spring:message code='common.processSuccess'/>");
			}
		
		</script>