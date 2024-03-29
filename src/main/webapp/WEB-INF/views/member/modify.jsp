<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/security/tags"
	prefix="sec"%>
<jsp:include page="../layout/header.jsp"></jsp:include>

<title>외원정보수정</title>
<h4 class="mb-3">회원정보 수정</h4>
<form action="/member/modify" method="post" id="modifyForm">
	<sec:authentication property="principal.mvo.email" var="authEmail" />
	<div class="mb-3">
		<label for="e" class="form-label">Email</label> <input type="text"
			name="email" class="form-control" id="e" readonly="readonly"
			value=${authEmail }>
	</div>
	<div class="mb-3">
		<label for="p" class="form-label">Password</label> <input
			type="password" name="pwd" class="form-control" id="p" value="">
	</div>
	<div class="mb-3">
		<label for="n" class="form-labe">NickName</label> <input type="text"
			name="nickname" class="form-control" id="n" value="">
	</div>
	<button type="submit" class="btn btn-dark">수정</button>
</form>
<a href="/member/delete?email=${authEmail }"><button type="button"
		class="btn btn-danger">삭제</button></a>












<jsp:include page="../layout/footer.jsp"></jsp:include>