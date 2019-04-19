<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="../includes/header.jsp" %>

	<form action="<%= request.getContextPath() %>/member/login" method="post">
		<table border="2">
			<tr align="center">
		<td>ID</td>
		<td><input type="text" name="id" value="" size="20"></td>
		</tr>
		<tr>
		<td>Password</td>
		<td><input type="password" name="pw" value="" size="20"></td>
		</tr>
		<tr>
		<td colspan="2" align="center"><input type="submit" value="전송">
		</tr>
	</table>

<%@include file="../includes/footer.jsp" %>


