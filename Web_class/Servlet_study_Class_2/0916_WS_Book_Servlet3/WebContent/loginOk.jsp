<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	${member.name}님 login Ok!
	<form action="" method = "post">
		<input type ="hidden" name = "sign" value="logout">
		<input type = "submit" value = "logout">
	</form>
</body>
</html>