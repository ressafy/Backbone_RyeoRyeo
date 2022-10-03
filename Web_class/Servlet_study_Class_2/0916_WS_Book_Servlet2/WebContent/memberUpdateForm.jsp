<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
회원 정보 수정
<form action="main" method = "post">
		<input type="hidden" name ="sign" value="memberUpdate">
		ID<input name = "id" value="${member.id}" readonly><br> 
		PW<input name = "pw" readonly><br>
		NAME<input name = "name" value = "${member.name}"><br>
		<input type = "submit" value="수정">
	</form>
</body>
</html>