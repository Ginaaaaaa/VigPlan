<%@page import="com.vigplan.vo.MemberVO" %>

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
	MemberVO vo = (MemberVO)request.getAttribute("mvo");
%>
<h2>가입 환영합니다.</h2>
<h3>가입 시 입력하신 정보입니다.</h3>
ID :<%=vo.getId() %><br>
Password : <%=vo.getPassword() %><br>
닉네임 : <%vo.getNickName(); %>
이메일 : <%=vo.geteMail() %>
<input type="button" value="로그인" onclick="location.href=/member_servlet/login_form.jsp'"><p>
<input type="button" value="메인페이지" onclick="location.href=/member_servlet/index.html'"><p>


</body>
</html>