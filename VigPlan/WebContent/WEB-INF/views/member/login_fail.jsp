<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="../includes/header.jsp" %>
<script>
alert('로그인 실패');
document.location.href="<%=request.getContextPath()%>/member/login";
</script>
<%@include file="../includes/footer.jsp" %>
