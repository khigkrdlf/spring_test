<%@ page contentType="text/html; charset=UTF-8" %> 
<%@ include file="/ssi/ssi.jsp" %>
 
<!DOCTYPE html> 
<html> 
<head> 
<meta charset="UTF-8"> 
<title></title> 

<style type="text/css"> 
* {
	font-family: font-family:font-family: "Raleway", Arial, sans-serif;
	font-size: 20px;
}

.search{
	width:80%;
	text-align: center;
	margin: 2px auto;
}	
</style> 

<script type="text/javascript">
function inputCheck(f) {
	if (f.fname.value == "") {
		alert("사진을 첨부하세요");
		f.fname.focus();
		
		return false;
	}
	if (f.title.value == "") {
		alert("제목을 입력하세요");
		f.title.focus();
		
		return false;
	}
	if (f.content.value == "") {
		alert("내용을 입력하세요");
		f.content.focus();
		
		return false;
	}
	if (f.passwd.value == "") {
		alert("패스워드를 입력하세요");
		f.passwd.focus();
		
		return false;
	}
}
</script>


<link href="${root}/css/style.css" rel="Stylesheet" type="text/css">
</head> 
<!-- *********************************************** -->
<body>

<!-- *********************************************** -->

<FORM name='frm' method='POST' action='./create'
	  enctype="multipart/form-data" onsubmit="return inputCheck(this)">
  <TABLE style="margin:auto;">
    <TR>
      <TH>사진</TH>
      <TD>
       <input type="file" name="fnameMF" required>
      </TD>
    </TR>
    <TR>
      <TH>제목</TH>
      <TD>
       <input type="text" name="title">
      </TD>
    </TR>
    <TR>
      <TH>내용</TH>
      <TD>
       <textarea rows="10" cols="50" name="content"></textarea>
      </TD>
    </TR>
    <TR>
      <TH>패스워드</TH>
      <TD>
       <input type="password" name="passwd">
      </TD>
    </TR>
  </TABLE>
  
  <DIV style="text-align: center">
    <input type='submit' value='글 작성'>
    <input type='reset' value='재입력'>
    <input type='button' value='뒤로가기' onclick="history.back()">
  </DIV>
</FORM>
 
 
<!-- *********************************************** -->

</body>
<!-- *********************************************** -->
</html>