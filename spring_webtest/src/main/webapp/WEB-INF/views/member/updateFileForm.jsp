<%@ page contentType="text/html; charset=UTF-8" %> 
<%@ include file="/ssi/ssi.jsp" %> 
 
<!DOCTYPE html> 
<html> 
<head> 
<meta charset="UTF-8"> 
<title></title> 

</head> 
<body>
<div class="container">
<h2>파일수정</h2>
 
<FORM name='frm' method='POST' enctype="multipart/form-data" action='./updateFile'>
	<input type="hidden" name="id" value="${param.id}">
	<input type="hidden" name="oldfile" value="${param.oldfile}">
  <TABLE class="table">
  	<tr>
      <td colspan="2" style="text-align:center; width:50%; height:50%;">
      <img src="${root }/member/storage/${param.oldfile}">
  	</tr>
    <TR>
      <TH>파일</TH>
      <TD><input type="file" name="fnameMF"></TD>
    </TR>
  </TABLE>
  
    <input type='submit' value='수정'>
    <input type='button' value='취소' onclick="history.back()">
</FORM>
  </DIV>
 
 
</body>
</html>