<%@page import="com.vigplan.vo.MemberVo" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="../includes/header.jsp" %>

<%
	String id=(String)request.getAttribute("id");
	String pw=(String)request.getAttribute("pw");
%>

	<form action="<%= request.getContextPath() %>/member/login" method="post">
		<table border="2">
			<tr align="center">
		<td>Id</td>
		<td><input type="text" value="1111" size="20"></td>
		</tr>
		<tr>
		<td>Password</td>
		<td><input type="password" name="pw" value="1111" size="21"></td>
	</table>

<input type="button" value="로그아웃" onclick="location.href='/VigPlan/member/logout'">
<input type="button" value="회원정보 " onclick="location.href='/VigPlan/member/info'">
</form>
<%@include file="../includes/footer.jsp" %>
