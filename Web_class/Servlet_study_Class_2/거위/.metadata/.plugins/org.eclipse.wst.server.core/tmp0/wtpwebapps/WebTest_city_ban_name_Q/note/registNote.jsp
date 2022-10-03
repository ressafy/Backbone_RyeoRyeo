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
	
	  <h2>노트북 정보 등록</h2>
	  <form id="registForm" action = "note" method = "GET">
	  	<input type="hidden" name="action" value="registNote">
	    <div class="form-group">
	      <label for="noteCode">고유번호</label>
	      <input type="text" class="form-control" name="noteCode" placeholder="고유번호 입력">
	    </div>
	    <div class="form-group">
	      <label for="model">모델명</label>
	      <input type="text" class="form-control" name="model" placeholder="모델명 입력">
	    </div>
	    <div class="form-group">
	      <label for="price">가격</label>
	      <input type="number" class="form-control" name="price" placeholder="가격 입력" >
	    </div>
	    	    <div class="form-group">
	      <label for="company">제조사</label>
	      <input type="text" class="form-control" name="company" placeholder="제조사 입력" >
	    </div>

	    <button type="submit" class="btn btn-primary" id="regist">등록</button>
	    <a class="btn btn-secondary" href="#" >취소</a>
	  </form>
	
	
	</div>
<%@ include file="/include/footer.jsp" %>