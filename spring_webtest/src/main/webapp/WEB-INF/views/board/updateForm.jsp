<%@ page language="java" contentType="text/html; charset=UTF-8"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<div class="container">
  <h2>글수정</h2>
  <form action="./update" method="post" enctype="multipart/form-data">
  
  <input type="hidden" name="num" value="${dto.num}">
  <input type="hidden" name="oldfile" value="${dto.filename}">
  <input type="hidden" name="col" value="${param.col}">
  <input type="hidden" name="word" value="${param.word}">
  <input type="hidden" name="nowPage" value="${param.nowPage}">
  
    <div class="form-group">
      <label for="name">성명</label>
      <input type="text" class="form-control" id="name" required="required" name="name" value="${dto.name}">
    </div>
    <div class="form-group">
      <label for="subject">제목</label>
      <input type="text" class="form-control" id="subject" required="required" name="subject" value="${dto.subject}">
    </div>
    <div class="form-group">
      <label for="content">내용</label>
      <textarea rows="10" cols="" class="form-control" id="content" required="required" name="content">${dto.content}</textarea>
    </div>
    <div class="form-group">
      <label for="pwd">비밀번호</label>
      <input type="password" class="form-control" id="pwd" required="required" name="passwd">
    </div>
    <div class="form-group">
      <label for="filename">파일</label>
      <input type="file" class="form-control" id="filename" name="filenameMF">
    </div>
    
    <button type="submit" class="btn btn-primary">수정</button>
    <button type="reset" class="btn btn-primary">취소</button>
  </form>
</div>
</body>
</html>