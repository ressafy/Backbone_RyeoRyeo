<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import = "dto.Member"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<% Member m = (Member)session.getAttribute("member"); %>
	<%= m.getName()%>님 login ok~!!! 
	<form action="main" >
		<input type = "hidden" name = "sign" value="logout">
		<input type = "submit" value="logout">
	</form>
	<br><a href = "main?sign=memberUpdateForm">회원 정보 수정</a>
	
</body>
</html>