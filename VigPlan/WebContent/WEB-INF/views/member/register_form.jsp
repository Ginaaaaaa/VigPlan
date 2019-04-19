<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="../includes/header.jsp" %>

	<form action="<%= request.getContextPath() %>/member" method="post">
		<table border="2">
			<tr align="center">
			</tr>
			<tr>
			<td>ID</td>
			<td><input type="text" name="id" value="" size="20"></td>
			</tr>
			<tr>
			<td>Password</td>
			<td><input type="password" name="pw" value="" size="20"></td>
			</tr>
			<tr>
			<td>Nickname</td>
			<td><input type="text" name="nickname" value="" size="20"></td>
			</tr>
			<tr>
			<td>Email</td>
			<td><input type="text" name="email" value="" size="20"></td>
			</tr>
			<tr align="center">
			<td colspan="2"><input type="submit" value="확인">
			<input type="reset" value="취소"></td>
		</table>
	</form>

<%@include file="../includes/footer.jsp" %>






