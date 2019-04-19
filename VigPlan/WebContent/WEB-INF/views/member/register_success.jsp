<%@page import="com.vigplan.vo.MemberVo" %>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="../includes/header.jsp" %>

<%
	MemberVo vo = (MemberVo)request.getAttribute("vo");
System.out.println(vo);
%>
<h2>가입 환영합니다.</h2>
<h3>가입 시 입력하신 정보입니다.</h3>
회원번호 : <%=vo.getNo() %><br>
ID :<%=vo.getId() %><br>
Password :<%=vo.getPw() %><br>
닉네임 : <%=vo.getNickname() %><br>
이메일 : <%=vo.getEmail() %><br>
가입날짜 : <%=vo.getRegdate() %>
<a href="<%= request.getContextPath() %>/member/login">Login</a>
<a href="<%= request.getContextPath() %>/member">메인페이지</a>

<%@include file="../includes/footer.jsp" %>
