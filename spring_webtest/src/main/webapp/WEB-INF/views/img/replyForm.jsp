<%@ page contentType="text/html; charset=UTF-8" %> 
<%@ include file="/ssi/ssi.jsp" %> 

 
<!DOCTYPE html> 
<html> 
<head> 
<meta charset="UTF-8"> 
<title></title> 
<script type="text/javascript">
function incheck(f){
	if(f.title.value==""){
		alert("제목을 입력하세요");
		f.title.focus();
		return false;
	}
	if(f.content.value==""){
		alert("내용을 입력하세요");
		f.content.focus();
		return false;
	}
	if(f.passwd.value==""){
		alert("비밀번호를 입력하세요");
		f.passwd.focus();
		return false;
	}
	
}
</script>
<style type="text/css"> 
* { 
	font-family: gulim; 
	font-size: 20px; 

} 
.img {
	text-align: center;
	border-style: solid;
	border-width: 1px;
	padding: 10px;
	margin: 20px auto;
}
.centerImg {
	text-align: center;
	border-style: solid;
	border-width: 1px;
	width: 330px;
	padding: 10px;
	margin: 20px auto;
}
.info {
	text-align: center;
	border-style: solid;
	border-width: 1px;
	width: 45%;
	height: 40%;
	padding: 10px;
	margin: 20px auto;
}
.now {
	margin-right:0;
	border-style:solid;
	border-width: 2px;
	border-color: red;
	width: 100px;
	height: 100px;
}
.tableTH {
	width: 20%;
	text-align: center;
}
</style> 
<link href="${root}/css/style.css" rel="Stylesheet" type="text/css">
</head> 
<!-- *********************************************** -->
<body>

<!-- *********************************************** -->
 
<DIV style="text-align: center"><h2>답변</h2></DIV>
 
<FORM name='frm' method='POST' action='./reply' 
enctype="multipart/form-data" onsubmit="return incheck(this)">
<input type="hidden" name="no" value="${dto.no}">
<input type="hidden" name="grpno" value="${dto.grpno}">
<input type="hidden" name="indent" value="${dto.indent}">
<input type="hidden" name="ansnum" value="${dto.ansnum}">
<input type="hidden" name="col" value="${param.col}">
<input type="hidden" name="word" value="${param.word}">
<input type="hidden" name="nowPage" value="${param.nowPage}">

  <TABLE style="margin:auto">
    <TR>
      <TH>사진</TH>
      <TD>
       <input type="file" name="fnameMF" required>
      </TD>
    </TR>
    <TR>
      <TH>제목</TH>
      <TD><input type="text" name="title" value="[답변]${dto.title}"></TD>
    </TR>
    <tr>
    	<th>내용</th>
    	<td><textarea rows="10" cols="45" name="content"></textarea></td>
    </tr>
    <tr>
    	<th>비밀번호</th>
    	<td><input type="password" name="passwd"></td>
    </tr>
  </TABLE>
  
  <DIV style="text-align: center">
    <input type='submit' value='등록'>
    <input type='button' value='취소' onclick="history.back()">
  </DIV>
</FORM>
 
 
<!-- *********************************************** -->

</body>
<!-- *********************************************** -->
</html>