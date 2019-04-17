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
<form name="invite" method="post" action="<%= request.getContextPath() %>/group/search">
	<input type="hidden" name="gNo" value="<%=group.getgNo() %>">
	<input type="text" name="searchid" placeholder="초대하고 싶은 아이디 입력">
	<button type="submit">검색</button>
</form>
</body>
</html>