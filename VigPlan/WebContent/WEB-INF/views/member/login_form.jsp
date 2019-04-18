<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

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
</form>
</body>
</html>

