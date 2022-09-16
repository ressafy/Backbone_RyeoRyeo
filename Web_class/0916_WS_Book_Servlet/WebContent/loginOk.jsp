<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<% String name = (String)request.getAttribute("memberName"); %>
<%= name %> 님    login OK..........<br>
<a href="main?sign=memberInfo">회원정보 보기</a>
</body>
</html>