<%@ page contentType="text/html; charset=UTF-8"%>
<%@ include file="/ssi/ssi.jsp"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
<script type="text/javascript">
	function inputCheck(f) {
		if (f.title.value == "") {
			alert("title을 입력해 주세요");
			f.focus();
			return false;
		}
		if (f.content.value == "") {
			alert("내용을 입력해 주세요");
			f.focus();
			return false;
		}
		if (f.passwd.value == "") {
			alert("비밀번호를 입력해 주세요");
			f.focus();
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

	<DIV style="text-align: center">수정</DIV><br><br>

	<FORM name='frm' method='POST' action='./updaProc'
		onsubmit="return inputCheck(this)" enctype="multipart/form-data">
		<input type="hidden" name="no" value="${dto.no}"> <input
			type="hidden" name="oldfile" value="${dto.fname}">
		

		<table style="margin:auto">
			<tr>
				<td colspan="2" align="center"  style="margin:auto"><img
					src="${root }/img/storage/${dto.fname}" width="200px" height="200px">

				</td>
			</tr>
			<TR>
				<TH>파일</TH>
				<TD><input type="file" name="fnameMF"></TD>
			</TR>

			<tr>
				<th>제목</th>
				<TD><input type="text" name="title"
					value="${dto.title}"></TD>
			</tr>
			<TR>
				<TH>content</TH>
				<TD><textarea rows="8" cols="40" name="content">${dto.content}</textarea></TD>

			</TR>

			<tr>
				<th>패스워드</th>
				<TD><input type="password" name="passwd"></TD>
			</tr>

		</TABLE>	<br><br>

		<DIV style="text-align: center">
			<input type='submit' value='수정'> <input type='button'
				value='취소' onclick="history.back()">
		</DIV>
	</FORM>


	<!-- *********************************************** -->

</body>
<!-- *********************************************** -->
</html>
