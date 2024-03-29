<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<jsp:include page="../layout/header.jsp"></jsp:include>
<div class="container-md">
	<h1>Board Modify Page</h1>
	<c:set value="${bdto.bvo }" var="bvo" />
	<form action="/board/modify" method="post" enctype="multipart/form-data">
		<div class="mb-3">
			<label for="bno" class="form-label">번호</label> <input type="text"
				name="bno" class="form-control" id="bno" value="${bvo.bno }"
				readonly="readonly">
		</div>

		<div class="mb-3">
			<label for="title" class="form-label">제목</label> <input type="text"
				name="title" class="form-control" id="title" value="${bvo.title }">
		</div>

		<!-- <sec:authentication property="principal.mvo.email" var="authEmail"/> -->
		<div class="mb-3">
			<label for="writer" class="form-label">작성자</label> <input type="text"
				name="writer" class="form-control" id="writer"
				value="${bvo.writer }" readonly="readonly">
		</div>

		<div class="mb-3">
			<label for="reg_date" class="form-label">작성일</label> <span
				class="badge text-bg-primary">${bvo.read_count }</span> <input
				type="text" name="reg_date" class="form-control" id="reg_date"
				value="${bvo.reg_at }" readonly="readonly">
		</div>

		<div class="mb-3">
			<label for="content" class="form-label">내용</label>
			<textarea name="content" class="form-control" id="content" rows="3">${bvo.content }</textarea>
		</div>

		<!-- 파일 표시라인 -->
		<c:set value="${bdto.flist }" var="flist"></c:set>
		<label for="content" class="form-labe">file</label>
		<ul class="list-group list-group-flush">
			<c:forEach items="${flist }" var="fvo">
				<li class="list-group-item"><c:choose>
						<c:when test="${fvo.fileType ==1 }">
							<div>
								<img alt=""
									src="/upload/${fvo.saveDir }/${fvo.uuid}/${fvo.fileName}">
							</div>
						</c:when>
						<c:otherwise>
							<div>
								<!-- 일반표시 -->
								<img alt="" src="/resources/image/zz.png"
									style="width: 20px; height: 20px;">이미지 없음
							</div>
						</c:otherwise>
					</c:choose>
					<div class="ms-2 me-auto">
						<div class="fw-bold">${fvo.fileName }</div>
						<span class="badge rounded-pill text-bg-secondary">${fvo.fileSize }
							Byte</span>
						<button type="button" data-uuid="${fvo.uuid }"
							class="btn btn-outline-danger file-x">x</button>
					</div></li>
			</c:forEach>
		</ul>
		
		<!-- 파일 등록 라인 -->
		<div class="mb-3">
		<input type="file" name="file" class="form-control" id="file" multiple="multiple" style="display:none">
		<button type="button" class="btn btn-primary" id="trigger">FileUpload</button>
		</div>
		<!-- 파일 목록 표시 라인 -->
		<div class="mb-3" id="fileZone">
		</div>
		<a href="/board/list"><button type="button" class="btn btn-primary">리스트</button></a>
		<button type="submit" class="btn btn-success" id="regBtn">수정완료</button>
	</form>
</div>

<script src="/resources/js/boardModify.js"></script>



<jsp:include page="../layout/footer.jsp"></jsp:include>