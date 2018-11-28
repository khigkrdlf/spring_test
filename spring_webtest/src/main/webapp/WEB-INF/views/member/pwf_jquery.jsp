<%@ page contentType="text/html; charset=UTF-8" %> 
<%@ include file="/ssi/ssi.jsp" %> 
<c:choose>
	<c:when test="${flag }">${dto.mname} 님의 비밀번호는 ${dto.passwd}입니다.</c:when>
	<c:otherwise>등록되어있지 않은 아이디입니다. 다시시도 해주세요.</c:otherwise>
</c:choose>
