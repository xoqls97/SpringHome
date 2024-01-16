<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<jsp:include page="../layout/header.jsp"></jsp:include>

<form action="/board/list" method="get">
	<table class="table">
		<thead>
			<tr>
				<th scope="col">#</th>
				<th scope="col">제목</th>
				<th scope="col">작성자</th>
				<th scope="col">시간</th>
				<th scope="col">댓글 수</th>
				<th scope="col">파일 수</th>
				<th scope="col">조회수</th>
			</tr>
		</thead>
		<tbody>

			<c:forEach items="${list }" var="bvo">
				<tr>
					<th scope="row">${bvo.bno }</th>
					<td><a href="/board/detail?bno=${bvo.bno }">${bvo.title }</a></td>
					<td>${bvo.writer }</td>
					<td>${bvo.reg_at }</td>
					<td>${bvo.cmt_qty }</td>
					<td>${bvo.has_file }</td>
					<td>${bvo.read_count }</td>

				</tr>
			</c:forEach>
		</tbody>
	</table>

</form>
<script type="text/javascript">
        const deletemsg =`<c:out value="${deletemsg}"/>`;
        if(deletemsg > 0){
            alert("게시글 삭제 성공!!");
        };
    </script>

<jsp:include page="../layout/footer.jsp"></jsp:include>