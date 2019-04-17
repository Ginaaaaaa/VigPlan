<%@ page import="com.vigplan.vo.GroupVo" %>
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
<h1>그룹 수정하기</h1>
<form action="<%= request.getContextPath() %>/group/update" name="gupdate" method="post" onsubmit="return <%= request.getContextPath() %>/group">
<table border="1">
<input type="hidden" name="gNo" value="<%= group.getgNo() %>">
<tr><td>모임명</td><td><input type="text" name="gName" value="<%=group.getgName()%>"></td></tr>
<tr><td><input type="submit" value="모임 수정" >
</table>
</form>


</body>
</html>