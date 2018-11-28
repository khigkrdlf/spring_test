<%@ page contentType="text/html; charset=UTF-8" %> 
<%@ include file="/ssi/ssi.jsp" %> 

<!DOCTYPE html> 
<html> 
<head> 
<meta charset="UTF-8"> 
<title></title> 

</head> 
<body>
 
<div class="container">
<h2>비밀번호 변경</h2>
<c:choose>
	<c:when test="${flag }">패스워드변경을 완료하였습니다.</c:when>
	<c:otherwise>패스워드변경을 실패했습니다.</c:otherwise>
</c:choose>

 
    <input type='button' value='다시시도' onclick="history.back()">
    <input type='button' value='회원정보' onclick="location.href='./read'">
  </DIV>

 
 
</body>
</html>