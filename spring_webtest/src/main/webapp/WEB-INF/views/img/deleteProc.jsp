<%@ page contentType="text/html; charset=UTF-8" %> 
<%@ include file ="/ssi/ssi.jsp" %> 

<!DOCTYPE html> 
<html> 
<head> 
<meta charset="UTF-8"> 
<title></title> 
<style type="text/css"> 
*{ 
  font-family: gulim; 
  font-size: 20px; 
} 
</style> 
<link href="${root}/css/style.css" rel="Stylesheet" type="text/css">
</head> 
<!-- *********************************************** -->
<body>

<!-- *********************************************** -->
 
<DIV class="title">번호삭제 처리</DIV>
 
<div class="content">
<c:choose>
	<c:when test="${pflag==false }">비밀번호가 틀렸습니다.
	<input type='button' value='다시시도' onclick="history.back()">
    <input type='button' value='홈' onclick="location.href='${root}/'">
    <input type='button' value='목록' onclick="location.href='./list'">
    </c:when>
	<c:when test="${flag }">삭제되었습니다.
    <input type='button' value='홈' onclick="location.href='${root}/'">
    <input type='button' value='목록' onclick="location.href='./list'">
	</c:when>
	<c:otherwise>삭제를 실패했습니다.
    <input type='button' value='다시시도' onclick="history.back()">
    <input type='button' value='홈' onclick="location.href='${root}/'">
    <input type='button' value='목록' onclick="location.href='./list'">
	</c:otherwise>
</c:choose>

</div>
 
<!-- *********************************************** -->

</body>
<!-- *********************************************** -->
</html> 

