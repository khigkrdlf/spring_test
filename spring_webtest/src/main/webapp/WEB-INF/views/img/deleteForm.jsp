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
 
<h2 style="text-align: center">삭제</h2>
 
<FORM name='frm' method='POST' action='./deleteProc'>
<input type="hidden" name="no" value="${param.no}">
<input type="hidden" name="oldfile" value="${param.oldfile}">
  <c:choose>
  <c:when test="${flag }">답변 있는 부모글은 삭제할 수 없습니다.
    <input type='button' value='홈' onclick="location.href='${root}/'">
    <input type='button' value='목록' onclick="location.href='./list'">
	</c:when>
	<c:otherwise>
  <div style="text-align: center">
  삭제를 하시면 더이상 되돌릴수 없습니다.<br>
  그래도 삭제를 원하시면 비밀번호를 입력하세요.
 <table style="text-align: center">
 <tr>
 <th style="margin:auto">비밀번호</th>
 <td style="margin:auto" ><input type="password" name="passwd"></td>
 
 </tr>
 </table>
  
  
  
  </div>
  
  <DIV style="text-align: center">
    <input type='submit' value='삭제'>
    <input type='button' value='취소' onclick="history.back()">
  </DIV>
  </c:otherwise>
  </c:choose>
</FORM>
 
 
<!-- *********************************************** -->

</body>
<!-- *********************************************** -->
</html> 

