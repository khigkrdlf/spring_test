<%@ page contentType="text/html; charset=UTF-8" %> 
<%@ include file="/ssi/ssi.jsp" %> 
 
 
<!DOCTYPE html> 
<html> 
<head> 
<meta charset="UTF-8"> 
<title></title> 
<script type="text/javascript">
function blist(){
	var url = "list";
	url = url +"?col=<%=request.getParameter("col")%>";
	url = url +"&word=<%=request.getParameter("word")%>";
	url = url +"&nowPage=<%=request.getParameter("nowPage")%>";
	location.href = url;
}
function incheck(f){
	if(f.passwd.value==0){
		alert("비밀번호를 입력하세요");
		f.passwd.focus();
		return false;
	}
}
</script>
<style type="text/css"> 
*{ 
  font-family: gulim; 
  font-size: 20px; 
} 
</style> 
<%-- <link href="<%=root%>/css/style.css" rel="Stylesheet" type="text/css"> --%>
</head> 
<body>
<div class="container">
<h2>삭제</h2>
<c:choose>
	<c:when test="${flag }">
		답변글이 존재합니다.<br>
		부모글을 삭제할 수 없습니다.
		<br>
		    <input type='button' value='목록' onclick="blist()">
	</c:when>
	<c:otherwise>
삭제하면 복구를 할 수 없습니다.<br>
<FORM name='frm' method='POST' action='./delete'
onsubmit = "return incheck(this)">
<input type="hidden" name="bbsno" value="<%=request.getParameter("bbsno") %>">
<input type="hidden" name="oldfile" value="<%=request.getParameter("oldfile") %>">
<input type="hidden" name="col" value="<%=request.getParameter("col") %>">
<input type="hidden" name="word" value="<%=request.getParameter("word") %>">
<input type="hidden" name="nowPage" value="<%=request.getParameter("nowPage") %>">
  <TABLE>
    <TR>
      <TH>패스워드</TH>
      <TD><input type="password" name="passwd"></TD>
    </TR>
  </TABLE>
  <br>

    <input type='submit' value='확인'>
    <input type='button' value='취소' onclick="history.back()">

</FORM>
	</c:otherwise>
</c:choose>
</div>
</body>
</html>