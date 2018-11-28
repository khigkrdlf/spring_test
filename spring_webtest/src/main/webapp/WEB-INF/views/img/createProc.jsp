<%@ page contentType="text/html; charset=UTF-8" %> 
<%@ include file="../ssi/ssi.jsp" %>

<!DOCTYPE html> 
<html> 
<head> 
<meta charset="UTF-8"> 
<title></title> 
<style type="text/css"> 
* {
	font-family: font-family:font-family: "Raleway", Arial, sans-serif;
	font-size: 20px;
}

.search{
	width:80%;
	text-align: center;
	margin: 2px auto;
}	
</style> 

<link href="${root}/css/style.css" rel="Stylesheet" type="text/css">
</head> 
<!-- *********************************************** -->
<body>

<!-- *********************************************** -->
 
<DIV class="title">결과 처리</DIV>

<div class="content">
<c:choose>
	<c:when test="${flag }">글 작성이 완료 되었습니다.
  <DIV class='bottom'>
    <input type='button' value='목록' onclick="location.href='./list.do'">
  </DIV>
	</c:when>
	<c:otherwise>글 작성을 실패했습니다.
  <DIV class='bottom'>
    <input type='button' value='다시 시도' onclick="history.back()">
    <input type='button' value='목록' onclick="location.href='./list.do'">
  </DIV>
	</c:otherwise>
</c:choose>

</div>
 
 
<!-- *********************************************** -->

</body>
<!-- *********************************************** -->
</html>