<%@ page contentType="text/html; charset=UTF-8" %> 
<%@ include file="../ssi/ssi.jsp" %> 

<!DOCTYPE html> 
<html> 
<head> 
<meta charset="UTF-8"> 
<title></title> 
<script type="text/javascript">
function mread(){
	var url = "read.do";
	url = url + "?id=${param.id}";
	
	location.href = url;
}

</script>

<%-- <link href="<%=root%>/css/style.css" rel="Stylesheet" type="text/css"> --%>
</head> 
<body>
 
<div class="container">
<h2>정보수정</h2>
<c:choose>
	<c:when test="${flag }">정보수정을 완료하였습니다.</c:when>
	<c:otherwise>정보수정을 실패했습니다.</c:otherwise>
</c:choose>

	

    <input type='submit' value='정보확인' onclick="mread()">
    <input type='button' value='다시시도' onclick="history.back()">
  </DIV>

 
 
</body>
</html>