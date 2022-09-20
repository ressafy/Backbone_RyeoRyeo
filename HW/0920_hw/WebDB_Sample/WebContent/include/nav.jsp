<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<nav class="navbar navbar-expand-sm bg-dark navbar-dark">
	<ul class="navbar-nav me-auto">
		<li class="nav-item"><a class="nav-link" href="#">상품 목록</a></li>
		<li class="nav-item"><a class="nav-link" href="#">상품 정보 등록</a></li>
	<span id = "loginSpan">
		<c:choose>
			<c:when test="${member == null }">
				<form action = "main" method = "get">
					<input type = "hidden" name="sign" value="login">
					ID <input name = "id">
					PW <input name = "pw" type ="password">
					<input type = "submit" id = "loginBtn" value = "login"> login  
				</form>
			</c:when>
			<c:otherwise>
				${member.name }
				<form action = "main" method = "POST">
				<input type = "hidden" name = "sign" value="logout">
				<input type = "submit" value ="logout">
				</form>
			</c:otherwise>
		</c:choose>
	</span>
	</ul>
</nav>