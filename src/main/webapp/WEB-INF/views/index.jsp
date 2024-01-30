<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<jsp:include page="layout/header.jsp"></jsp:include>
<h1>Hello world! ㅋㅋ</h1>
<script type="text/javascript">
	const registermsg = <c:out value="${registermsg}"/>;
	if (registermsg > 0) {
		alert("게시글 등록 성공!!");
	};
</script>
<script type="text/javascript">
    const memberinsertmsg=`<c:out value="${memberinsertmsg}"/>`;
    if(memberinsertmsg>0){
    	alert('회원가입 성공!');
    }
</script>

<jsp:include page="layout/footer.jsp"></jsp:include>
