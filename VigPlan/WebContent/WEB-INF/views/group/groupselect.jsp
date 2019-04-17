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
<table border="1">
<form action="<%= request.getContextPath() %>/group/update?gNo=<%=group.getgNo()%>" method="get" onsubmit="return <%= request.getContextPath() %>/group">
<input type="hidden" name="gNo" value="<%=group.getgNo() %>">
	<tr><td> 모임명 </td><td><%=group.getgName() %> </td></tr>
	<tr><td> 생성일 </td><td><%=group.getgRegdate() %></td></tr>
	<tr><td> <button type="submit">그룹명 수정</button></td>
	<td><a href="<%= request.getContextPath() %>/group/delete?gNo=<%=group.getgNo()%>"">그룹 삭제</a>
	<a href="<%= request.getContextPath() %>/group/search?gNo=<%=group.getgNo()%>"">맴버 초대하기</a></td></tr>
</form> 
</table>
</body>
</html>