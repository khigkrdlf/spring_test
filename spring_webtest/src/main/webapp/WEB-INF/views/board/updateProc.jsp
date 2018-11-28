<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<script type="text/javascript">
function listb(){
	var url = "list.do";
	url += "?col=${col}";
	url += "&word=${word}";
	url += "&nowPage=${nowPage}";
	
	location.href = url;
}
</script>
<body>
<div class="container">

<c:choose>
	<c:when test="${pflag==false }">비밀번호 오류입니다.<br><br>
	<button onclick="history.back()">다시시도</button>
	</c:when>
	<c:when test="${flag }">수정을 성공했습니다.<br><br>
	<button onclick="listb()">목록</button>
	</c:when>
	<c:otherwise>수정을 실패했습니다.<br><br>
	<button onclick="history.back()">다시시도</button>
	</c:otherwise>	
</c:choose>

</div>
</body>
</html>