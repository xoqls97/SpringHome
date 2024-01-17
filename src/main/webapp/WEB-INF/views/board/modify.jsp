<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<jsp:include page="../layout/header.jsp"></jsp:include>
<div class="container-md">
<h1>Board Modify Page</h1>
<%-- <c:set value="${bdto.bvo }" var="bvo" /> --%>
<form action="/board/modify" method="post">
<div class="mb-3">
  <label for="bno" class="form-label">번호</label>
  <input type="text" name="bno" class="form-control" id="bno" value="${bvo.bno }" readonly="readonly">
</div>

<div class="mb-3">
  <label for="title" class="form-label">제목</label>
  <input type="text" name="title" class="form-control" id="title" value="${bvo.title }" >
</div>

<!-- <sec:authentication property="principal.mvo.email" var="authEmail"/> -->
<div class="mb-3">
  <label for="writer" class="form-label">작성자</label>
  <input type="text" name="writer" class="form-control" id="writer" value="${bvo.writer }" readonly="readonly">
</div>

<div class="mb-3">
  <label for="reg_date" class="form-label">작성일</label>
<span class="badge text-bg-primary">${bvo.read_count }</span>
  <input type="text" name="reg_date" class="form-control" id="reg_date" value="${bvo.reg_at }" readonly="readonly">
</div>

<div class="mb-3">
  <label for="content" class="form-label">내용</label>
  <textarea name="content" class="form-control" id="content" rows="3" >${bvo.content }</textarea>
</div>

<button type="submit" class="btn btn-success">수정완료</button>
</form>
<a href="/board/list"><button type="button" class="btn btn-danger">취소</button></a>

</div>





<jsp:include page="../layout/footer.jsp"></jsp:include>