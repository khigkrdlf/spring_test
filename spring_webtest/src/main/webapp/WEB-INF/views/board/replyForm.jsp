<%@ page language="java" contentType="text/html; charset=UTF-8"%>
   <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<div class="container">
  <h2>답변</h2>
  <form action="./reply" method="post" enctype="multipart/form-data">
    <div class="form-group">
    <input type="hidden" name="ref" value="${dto.ref}">
    <input type="hidden" name="indent" value="${dto.indent}">
    <input type="hidden" name="ansnum" value="${dto.ansnum}">
    
    <input type="hidden" name="num" value="${dto.num}">
    
    <input type="hidden" name="col" value="${param.col}">
    <input type="hidden" name="word" value="${param.word}">
    <input type="hidden" name="nowPage" value="${param.nowPage}">
    
      <label for="name">성명</label>
      <input type="text" class="form-control" id="name" required="required" name="name">
    </div>
    <div class="form-group">
      <label for="subject">제목</label>
      <input type="text" class="form-control" id="subject" required="required" name="subject">
    </div>
    <div class="form-group">
      <label for="content">내용</label>
      <textarea rows="10" cols="" class="form-control" id="content" required="required" name="content"></textarea>
    </div>
    <div class="form-group">
      <label for="pwd">비밀번호</label>
      <input type="password" class="form-control" id="pwd" required="required" name="passwd">
    </div>
    <div class="form-group">
      <label for="filename">파일</label>
      <input type="file" class="form-control" id="filename" name="filenameMF">
    </div>
    
    <button type="submit" class="btn btn-primary">등록</button>
    <button type="reset" class="btn btn-primary">취소</button>
  </form>
</div>
</body>
</html>