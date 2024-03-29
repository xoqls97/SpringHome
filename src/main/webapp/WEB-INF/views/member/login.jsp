<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<jsp:include page="../layout/header.jsp"></jsp:include>
<title>로그인</title>
<h4 class="mb-3">로그인페이지</h4>

<form action="/member/login" method="post">
	<div class="mb-3">
		<label for="e" class="form-label">Email</label> <input type="email"
			name="email" class="form-control" id="e" placeholder="email">
	</div>

	<div class="mb-3">
		<label for="p" class="form-label">Password</label> <input
			type="password" name="pwd" class="Form-control" id="p">
	</div>

	<c:if test="${not empty param.errMsg }">
		<div class="mb-3 text-danger">
			<c:choose>
				<c:when test="${param.errMsg eq 'Bad credentials' }">
					<c:set value="이메일 & 비밀번호가 일치하지 않습니다." var="errText"></c:set>
				</c:when>
				<c:otherwise>
					<c:set value="관리자문의" var="errText"></c:set>
				</c:otherwise>
			</c:choose>
			${errText }
		</div>
	</c:if>
	<button type="submit" class="btn btn-dark">로그인</button>
</form>
<script type="text/javascript">
	const deletemsg = `<c:out value="${deletemsg}"/>`;
	if (deletemsg > 0) {
		alert('멤버 삭제성공!!');
	};
</script>





<jsp:include page="../layout/footer.jsp"></jsp:include>