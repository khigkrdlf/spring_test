<%@ page contentType="text/html; charset=UTF-8" %> 
<%@ include file="/ssi/ssi.jsp" %> 
<c:choose>
	<c:when test="${flag }">중복되어서 사용할 수 없습니다.</c:when>
	<c:otherwise>중복아님, 사용 가능합니다.</c:otherwise>
</c:choose>

