<%@ page contentType="text/html; charset=UTF-8" %> 
<%@ include file="../ssi/ssi.jsp" %> 

<!DOCTYPE html> 
<html> 
<head> 
<meta charset="UTF-8"> 
<title></title> 

<%-- <link href="<%=root%>/css/style.css" rel="Stylesheet" type="text/css"> --%>
</head> 
<body>
 
<div class="container">
<h2>회원탈퇴처리</h2>
<c:choose>
	<c:when test="${flag }">탈퇴되었습니다. 자동 로그아웃됩니다.<br><br>
    <input type='submit' value='홈' onclick="location.href='../index.jsp'">
	</c:when>
	<c:otherwise>탈퇴가 실패되었습니다.<br><br>
    <input type='submit' value='홈' onclick="location.href='../index.jsp'">
    <input type='button' value='다시시도' onclick="history.back()">
	</c:otherwise>
</c:choose>

    </DIV>

 
</body>
</html>