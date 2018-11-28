<%@ page contentType="text/html; charset=UTF-8" %> 
<%@ include file="/ssi/ssi.jsp" %> 
 
<!DOCTYPE html> 
<html> 
<head> 
<meta charset="UTF-8"> 
<title></title> 

<script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.6.4/jquery.js"></script>
<script type="text/javascript">

function idfind(email){
	if(email==""){
		alert("이메일을 입력해 주세요");
		document.frm.email.focus();
	}else{
		var url = "idfind";
		
		$.ajax({
			url:url,
			type: "GET",
			dataType:'text',
			data:{"email":email},
			success:function(data){
				$("#idfind").text(data.trim()).css("color","red");
			}
		});
	}
}


</script>
<link href="${root}/css/style.css" rel="Stylesheet" type="text/css">
</head> 
<body>
<div class="container"> 
<h2>아이디 찾기</h2>
 
<FORM name='frm'>
  <TABLE>
     
     <TR>
      <TH>이메일</TH>
      <TD><input type="text" name="email" size="25"></TD>
      <td>본인 이메일을 적어 주세요.</td>
    </TR>
  </TABLE>


  <input type="button" value="찾기" 
      		onclick="idfind(document.frm.email.value)">

  <br>
  <div id=idfind></div>
  <br>
    <input type='reset' value='다시시도'>
    <input type='button' value='로그인' onclick="location.href='${root}/member/login'">
</FORM>
  </DIV>
 
 
</body>
</html>