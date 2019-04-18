<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
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
</body>
</html>





