<%@ page contentType="text/html; charset=UTF-8" %> 
<%@ include file="/ssi/ssi.jsp" %> 
 
<!DOCTYPE html> 
<html> 
<head> 
<meta charset="UTF-8"> 

<script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.6.4/jquery.js"></script>
<script type="text/javascript">

function pwfind(id){
	if(id==""){
		alert("아이디을 입력해 주세요");
		document.frm.id.focus();
	}else{
		var url = "pwfind";
		
		$.ajax({
			url:url,
			type:"GET",
			dataType:'text',
			data:{"id":id},
			success:function(data){
				$("#pwfind").text(data.trim()).css("color","red");
			}
		});
	}
}


</script>
<%-- <link href="<%=root%>/css/style.css" rel="Stylesheet" type="text/css"> --%>
</head> 
<body>
<div class="container">
<h2>비밀번호 찾기</h2>
 
<FORM name='frm'>
  <TABLE>
     
     <TR>
      <TH>아이디</TH>
      <TD><input type="text" name="id" size="20"></TD>
      <td>본인 아이디를 적어 주세요.</td>
    </TR>
  </TABLE>


  <input type="button" value="찾기" 
      		onclick="pwfind(document.frm.id.value)">
  <br>
  <br>
  <div id=pwfind></div>
  <br>
    <input type='reset' value='다시시도'>
    <input type='button' value='로그인' onclick="location.href='${root}/member/login.do'">
  </DIV>
</FORM>
 
 
</body>
</html>