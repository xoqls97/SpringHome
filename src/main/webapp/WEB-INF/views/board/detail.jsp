<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%-- <%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %> --%>

<jsp:include page="../layout/header.jsp"></jsp:include>
<div class="container-md">
	<h1>Board Detail Page</h1>
	<%-- <c:set value="${bto.bvo }" var="bvo"/> --%>

	<div class="mb-3">
		<label for="bno" class="form-label">번호</label> <input type="text"
			name="bno" class="form-control" id="bno" value="${bvo.bno }"
			readonly="readonly">
	</div>

	<div class="mb-3">
		<label for="title" class="form-label">제목</label> <input type="text"
			name="title" class="form-control" id="title" value="${bvo.title }"
			readonly="readonly">
	</div>

	<!-- <sec:authentication property="principal.mvo.email" var="authEmail"/> -->
	<div class="mb-3">
		<label for="writer" class="form-label">작성자</label> <input type="text"
			name="writer" class="form-control" id="writer" value=${bvo.writer }
			readonly="readonly">
	</div>

	<div class="mb-3">
		<label for="reg_date" class="form-label">작성일</label> <span
			class="badge text-bg-primary">${bvo.read_count }</span> <input
			type="text" name="reg_date" class="form-control" id="reg_date"
			value="${bvo.reg_at }" readonly="readonly">
	</div>

	<div class="mb-3">
		<label for="content" class="form-label">내용</label>
		<textarea name="content" class="form-control" id="content" rows="3"
			readonly="readonly">${bvo.content }</textarea>
	</div>
</div>

<a href="/board/list"><button type="button" class="btn btn-primary">리스트</button></a>
<a href="/board/modify?bno=${bvo.bno }"><button type="button"
		class="btn btn-success">수정</button></a>
<a href="/board/delete?bno=${bvo.bno }"><button type="button"
		class="btn btn-danger">삭제</button></a>

<!-- 댓글 등록 라인 -->
<div class="input-group mb-3">
	<span class="input-group-text" id="cmtWriter">${bvo.writer }</span> <input
		type="text" class="form-control" id="cmtText"
		aria-label="Amount (to the nearest dollar)">
	<button type="button" class="btn btn-success" id="cmtPostBtn">Post</button>
</div>

<!-- 댓글 표시 라인 -->
<ul class="list-group list-group-flush" id="cmtListArea">
	<li class="list-group-item">
		<div class="mb-3">
			<div class="fw-bold">Writer</div>
			content
		</div> <span class="badge rounded-pill text-bg=warning">modAt</span>
	</li>
</ul>

<!-- 댓글 더보기 버튼 -->

<!-- 모달창 라인 -->




<script type="text/javascript">
	let bnoVal = `<c:out value="${bvo.bno}"/>`;
	console.log(bnoVal);
</script>
<script src="/resources/js/boardComment.js"></script>
<script type="text/javascript">
	spreadCommentList(bnoVal); 
</script>

<script type="text/javascript">
	const modifymsg = `<c:out value="${modifymsg}"/>`;
	if (modifymsg > 0) {
		alert("게시글 수정 성공!!");
	};
</script>

<jsp:include page="../layout/footer.jsp"></jsp:include>