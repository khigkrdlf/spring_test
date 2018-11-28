<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="root" value="${pageContext.request.contextPath }"/>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">

<!-- jQuery library -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>

<!-- Popper JS -->
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"></script>

<!-- Latest compiled JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"></script>

</head>
<body>
<!-- 상단 메뉴 -->
<div style="background-color: #E6FFFF;">
<table class="table">
  <tr>
    <td class="td">
        <img style="width:100%;height:35%;"class="img" src="${root}/images/main1.jpg">
    </td>
  </tr>
  
  <tr>
    <td class="td">
   <ul class="nav nav-pills">
  <li class="nav-item">
    <a class="nav-link active" href="${root }/">홈</a>
  </li>
  <li class="nav-item dropdown">
    <a class="nav-link dropdown-toggle" data-toggle="dropdown" href="#">게시판</a>
    <div class="dropdown-menu">
      <a class="dropdown-item" href="${root }/bbs/create">게시판 등록</a>
      <a class="dropdown-item" href="${root }/bbs/list">게시판 목록</a>
    </div>
  </li>
  <li class="nav-item dropdown">
    <a class="nav-link dropdown-toggle" data-toggle="dropdown" href="#">메모</a>
    <div class="dropdown-menu">
      <a class="dropdown-item" href="${root }/memo/create">메모 등록</a>
      <a class="dropdown-item" href="${root }/memo/list">메모 목록</a>
    </div>
  </li>
  <li class="nav-item dropdown">
    <a class="nav-link dropdown-toggle" data-toggle="dropdown" href="#">이미지</a>
    <div class="dropdown-menu">
      <a class="dropdown-item" href="${root }/img/create">이미지 등록</a>
      <a class="dropdown-item" href="${root }/img/list">이미지 목록</a>
    </div>
  </li>
  <li class="nav-item dropdown">
    <a class="nav-link dropdown-toggle" data-toggle="dropdown" href="#">게시판</a>
    <div class="dropdown-menu">
      <a class="dropdown-item" href="${root }/board/create">게시판 등록</a>
      <a class="dropdown-item" href="${root }/board/list">게시판 목록</a>
    </div>
  </li>
  <li class="nav-item dropdown">
    <a class="nav-link dropdown-toggle" data-toggle="dropdown" href="#">팀</a>
    <div class="dropdown-menu">
      <a class="dropdown-item" href="${root }/team/create">팀 등록</a>
      <a class="dropdown-item" href="${root }/team/list">팀 목록</a>
    </div>
  </li>
  <c:choose>
  <c:when test="${empty id }">
      <li class="nav-item"><a class="nav-link" href="${root}/member/agree"> Sign Up</a></li>
      <li class="nav-item"><a class="nav-link" href="${root}/member/login"> Login</a></li>  	
  </c:when>
  <c:otherwise>
  	<c:if test="${grade!='A'}">
      <li class="nav-item"><a class="nav-link" href="${root}/member/read"> My Info</a></li>
      <li class="nav-item"><a class="nav-link" href="${root}/member/delete">회원탈퇴</a></li>
  	</c:if>
      <li class="nav-item"><a class="nav-link" href="${root}/member/logout"> Logout</a></li>    
  </c:otherwise>
  </c:choose>
	<c:if test="${not empty id && grade=='A' }">
     <li id="admin"><a class="nav-link" href="${root }/admin/list">회원목록</a></li>  
     <li class="nav-item dropdown" id="admin">
    <a class="nav-link dropdown-toggle" data-toggle="dropdown" href="#">직원</a>
    <div class="dropdown-menu">
    <a class="dropdown-item" href="${root }/team/list">직원목록</a>
    <a class="dropdown-item" href="${root }/team/create">직원등록</a>
    </div>
  </li>
  	</c:if>
    </ul> 
    </td> 
  </tr>
 
</table>
</div>
<!-- 상단 메뉴 끝 -->
 
 
 
<!-- 내용 시작 -->
<div style="width: 100%; padding-top: 10px;">