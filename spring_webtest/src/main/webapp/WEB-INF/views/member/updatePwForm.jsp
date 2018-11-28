<%@ page contentType="text/html; charset=UTF-8" %> 
<%@ include file="/ssi/ssi.jsp" %>

<!DOCTYPE html> 
<html> 
<head> 
<meta charset="UTF-8"> 
<title></title> 
<script type="text/javascript">
function inCheck(f){
	
	if(f.mypasswd.value==""){
		alert("기존패스워드를 입력하세요");
		f.mypasswd.focus();
		return false;
	}
	if(f.mypasswd.value!="${dto.passwd}"){
		alert("기존패스워드가 틀렸습니다");
		f.mypasswd.focus();
		return false;
	}
	if(f.passwd.value==""){
		alert("새로운 패스워드를 입력하세요");
		f.passwd.focus();
		return false;
	}
	if(f.repasswd.value==""){
		alert("패스워드확인을 입력하세요");
		f.repasswd.focus();
		return false;
	}
	if(f.passwd.value!=f.repasswd.value){
		alert("비밀번호가 일치하지 않습니다. 다시 입력하세요.");
		f.repasswd.focus();
		return false;
	}
}
</script>
 
</head> 
<body>
<div class="container">
<h2>패스워드 변경</h2>
 
<FORM name='frm' method='POST' action='./updatePw'
	onsubmit="return inCheck(this)">
	<input type="hidden" name="id" value="${param.id}">
	
  <TABLE class="table">
  	<tr>
  		<th>기존패스워드</th>
  		<td><input type="password" name="mypasswd" value="1234"></td>
  	</tr>
    <TR>
      <TH>새로운 패스워드</TH>
      <TD><input type="password" name="passwd"></TD>
    </TR>
    <TR>
      <TH>새로운 패스워드 확인</TH>
      <TD><input type="password" name="repasswd"></TD>
    </TR>
  </TABLE>
  
    <input type='submit' value='패스워드 수정'>
    <input type='button' value='취소' onclick="history.back()">

</FORM>
  </DIV>
 
 
</body>
</html>