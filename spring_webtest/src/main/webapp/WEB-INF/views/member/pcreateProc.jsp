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
 
<h2>아이디 및 이메일 중복확인</h2>
 <div class="container">
 ${str }
  
    <input type='button' value='다시시도' onclick="history.back()">
  </DIV>
 
 
</body>
</html>
