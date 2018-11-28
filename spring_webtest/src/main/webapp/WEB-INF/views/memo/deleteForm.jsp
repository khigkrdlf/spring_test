<%@ page contentType="text/html; charset=UTF-8"%>
<%@ include file="/ssi/ssi.jsp"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
<script type="text/javascript">
function mlist(){
	var url = "list";
	url = url +"?col=${param.col}";
	url = url +"&word=${param.word}";
	url = url +"&nowPage=${param.nowPage}";
	location.href = url;
}
</script>

</head>
<body>
<div class="container">
	<h2>삭제 확인</h2>
	<c:choose>
		<c:when test="${flag }">
		답변글이 존재합니다.<br>
		부모글을 삭제할 수 없습니다.
		<br>
		    <input type='button' value='목록' onclick="mlist()">
		</c:when>
		<c:otherwise>
	<form method="POST" action="delete">
		<input type="hidden" name="memono" value="${param.memono}">
		<input type="hidden" name="col" value="${param.col}">
		<input type="hidden" name="word" value="${param.word}">
		<input type="hidden" name="nowPage" value="${param.nowPage}">
		<div>
			삭제를 하면 복구 될 수 없습니다.<br>
			<br> 삭제하시려면 삭제버튼을 클릭하세요.<br>
			<br> 취소는 '목록'버튼을 누르세요.<br>
			<br> <input type="submit" value="삭제처리"> <input
				type="button" value="목록" onclick="mlist()">
		</div>
	</form>
		</c:otherwise>
	</c:choose>
		
	</div>
</body>
</html>
