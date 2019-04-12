<%@page import="com.vigplan.vo.MemberVo" %>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Join Page</title>
</head>
<body>
<%
	MemberVo vo = (MemberVo)request.getAttribute("mvo");
%>
<h2>가입 환영합니다.</h2>
<h3>가입 시 입력하신 정보입니다.</h3>
ID :<%=vo.getId() %><br>
Password : <%=vo.getPw() %><br>
닉네임 : <%vo.getNickname(); %>
이메일 : <%=vo.getEmail() %>
<a href="<%= request.getContextPath() %>/member/login">Login</a>
<!-- input type="button" value="로그인" onclick="location.href=/VigPlan/WEB-INF/views/memeber/login_form.jsp'" -->
<input type="button" value="메인페이지" onclick="location.href=/VigPlan/WEB-INF/views/memeber/index_html'">


</body>
</html>