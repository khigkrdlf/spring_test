
<%@ page contentType="text/html; charset=UTF-8" %> 
<%@ include file="/ssi/ssi.jsp" %> 

<!DOCTYPE html> 
<html> 
<head> 
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
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
function iread(no){
	var url = "read";
	url = url + "?no="+no;
	url += "&col=${col}";
	url += "&word=${word}";
	url += "&nowPage=${nowPage}";
	location.href = url;
}

</script>
<%-- <link href="<%=root%>/css/style.css" rel="Stylesheet" type="text/css"> --%>
</head> 
<!-- *********************************************** -->
<body>

<!-- *********************************************** -->
 <div class="search">
<form action="./list" method="post">

 <select name="col">
 	<option value="No"<c:if test="${col=='No'}">selected</c:if>>No</option>
 	<option value="title"<c:if test="${col=='title'}">selected</c:if>>제목</option>
 	<option value="total">전체</option>
  </select>
  <input type="text" name="word" value="${word}">
  <button class="btn btn-default">검색</button>
  <button type="button" onclick="location.href='create'" class="btn btn-success">등록</button>
  </form>
 </div>
 
<DIV class="container">
<span class=""></span>
<h2>목록</h2>

  <TABLE class="table table-hover">
    <TR>
      <TH>No</TH>
      <TH>Img</TH>
      <TH>제목</TH>
      <TH>조회수</TH>
      <TH>등록일</TH>
    </TR>
    
    <c:choose>
    <c:when test="${empty list}">
    <tbody>
    <tr>
	    <td colspan="8">
		등록된 글이 없습니다.
		</td>
	</tr>
	</tbody>
    </c:when>
    <c:otherwise>
    <c:forEach var="dto" items="${list}">
  <TR>
    	<td>${dto.no}</td>
    	<td><img src='${root }/img/storage/${dto.fname}' class="img-rounded" alt="Cinque Terre" width="200px" heigh = "200px"></td>
    	<td><a href="javascript:iread('${dto.no}')">${dto.title}</a></td>
    	<td>${dto.viewcnt}</td>
    	<td>${dto.wdate}</td>
    </TR> 
   </c:forEach>
      	</c:otherwise>
    
    </c:choose>

  </TABLE>
  <DIV class='bottom'>
   
    ${paging}
   
  </DIV>
  
</DIV>

<!-- *********************************************** -->

</body>
<!-- *********************************************** -->
</html> 