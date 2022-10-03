<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<%@ include file="/include/head.jsp" %>
</head>
<body>
	<%@ include file="/include/nav.jsp" %>

	<%-- 페이지만의 내용 --%>
	<div class="container p-4">
	<form action = "main">
		 <input type = "hidden" name = "sign" value="updateNote">
		<h2>노트북 정보 수정</h2>
		  <button class="btn btn-warning" type = "submit">수정</button>
		  <table class="table table-striped">
		      <tr>
		        <td>고유번호</td><td><input value = "${note.noteCode }" name = "noteCode" readonly></td>
		      </tr>
		      <tr>
		        <td>모델명</td><td><input value = "${note.model }" name = "model"></td>
		      </tr>
		      <tr>
		        <td>가격</td><td><input value = "${note.price }" name = "price"></td>
		      </tr>
		      <tr>
		        <td>제조사</td><td><input value = "${note.company }" name = "company"></td>
		      </tr>
		  </table>
	</form>
	  
	
	</div>
<%@ include file="/include/footer.jsp" %>