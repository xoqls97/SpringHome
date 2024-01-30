<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<jsp:include page="../layout/header.jsp"></jsp:include>
<title>회원가입</title>
<h1>회원가입 페이지</h1>

<form action="/member/register" method="post">
	<div class="mb-3">
		<label for="e" class="form-label">Email</label> <input type="email"
			name="email" class="form-control" id="e" placeholder="email">
		<button type="button" class="btn btn-outline-success" id="checkBtn">check</button>
	</div>
	<input type="hidden" name="" class="form-control" id="hiddenEmail" placeholder="example@naver.com">

	<div class="mb-3">
		<label for="p" class="form-label">Password</label> <input type="text"
			name="pwd" class="form-control" id="p">
	</div>
	<div class="mb-3">
		<label for="pwd" class="form-label">pwd check</label> <input
			type="password" name="" class="form-control" id="pwdCheck"
			placeholder="password">
	</div>

	<div class="mb-3">
		<label for="n" class="form-label">NickName</label> <input type="text"
			name="nickname" class="form-control" id="n" placeholder="NickName">
	</div>

	<button type="submit" class="btn btn-dark" id="regBtn" disabled="disabled">회원가입</button>
</form>

<script src="/resources/js/memberRegister.js"></script>

<jsp:include page="../layout/footer.jsp"></jsp:include>