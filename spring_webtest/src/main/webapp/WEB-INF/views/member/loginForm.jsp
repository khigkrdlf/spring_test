<%@ page contentType="text/html; charset=UTF-8" %> 
<%@ include file="/ssi/ssi.jsp" %> 

<!DOCTYPE html> 
<html> 
<head> 
<meta charset="UTF-8"> 
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<title></title> 

<%-- <link href="<%=root%>/css/style.css" rel="Stylesheet" type="text/css"> --%>
</head> 
<body>
<div class="container" >  
<h2>로그인</h2>
 
<FORM name='frm' method='POST' action='${root }/member/login'>


  <TABLE>
    <TR>
      <TH>아이디</TH>
      <TD><input type="text" name="id" value='abc12'>
      <c:choose>
      	<c:when test="${c_id=='Y' }">
         <input type='checkbox' name='c_id' value='Y' checked='checked'> ID 저장 
      	</c:when>
      	<c:otherwise>
         <input type='checkbox' name='c_id' value='Y' > ID 저장 
      	</c:otherwise>
      </c:choose>

      </TD>
    </TR>
    <TR>
      <TH>비밀번호</TH>
      <TD><input type="password" name="passwd" value="1234" ></TD>
    </TR>
  </TABLE>
  
  <DIV class='bottom'>
    <input type='submit' value='로그인'>
    <input type='button' value='회원가입' onclick="location.href='agree'">
  </DIV>
	<div class='bottom'>
	<a style="cursor:pointer; text-decoration:none;" onclick="location.href='idf'">아이디</a>
	/
	<a style="cursor:pointer; text-decoration:none;" onclick="location.href='pwf'">비밀번호찾기</a>
	</div>
<!-- 	댓글 처리용 -->
	<input type="hidden" name="flag" value="${param.flag }">
	<input type="hidden" name="nPage" value="${param.nPage }">
	<input type="hidden" name="bbsno" value="${param.bbsno }">
	<input type="hidden" name="num" value="${param.num }">
	<input type="hidden" name="col" value="${param.col }">
	<input type="hidden" name="word" value="${param.word }">
	<input type="hidden" name="nowPage" value="${param.nowPage }">
</FORM>
 
 </div>
</body>
</html>