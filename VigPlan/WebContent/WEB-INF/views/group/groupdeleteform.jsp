<%@ page import="com.vigplan.vo.GroupVo" %>
<%@ page import="com.vigplan.dao.group.GroupDao" %>
<%@ page import="java.util.List" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
GroupVo group = (GroupVo) request.getAttribute("group");
%>
	<form action="<%= request.getContextPath() %>/group/delete?gNo=<%=group.getgNo()%>" method="post" onsubmit="return <%= request.getContextPath() %>/group">
	<div>비밀번호 입력 : <input type="password" name="pw"></div>
	<div><button type="submit">확인</div>
	</form>
</body>
</html>