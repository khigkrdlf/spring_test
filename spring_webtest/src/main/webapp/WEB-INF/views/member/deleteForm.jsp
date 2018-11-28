<%@ page contentType="text/html; charset=UTF-8" %> 
<%@ include file="/ssi/ssi.jsp" %> 

<!DOCTYPE html> 
<html> 
<head> 
<meta charset="UTF-8"> 
<title></title> 
 
<%-- <link href="<%=root%>/css/style.css" rel="Stylesheet" type="text/css"> --%>
</head> 
<body>
 
<div class="container">
<h2>회원탈퇴</h2>
 
<FORM name='frm' method='POST' action='./delete'>
<input type="hidden" name="id" value="${id}">
<input type="hidden" name="col" value="${param.col}">
<input type="hidden" name="word" value="${param.word}">
<input type="hidden" name="nowPage" value="${param.nowPage}">
탈퇴를 하시면 더이상 컨테츠를 제공받으실 수 없습니다.<br>
그래도 탈퇴를 원하시면 아래 버튼을 클릭하세요.

<br/>
<br/>
    <input type='submit' value='탈퇴'>
    <input type='button' value='취소' onclick="history.back()">
</FORM>
  </DIV>
 
 
</body>
</html>