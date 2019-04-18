<%@ page import="com.vigplan.vo.GroupVo" %>
<%@ page import="com.vigplan.dao.group.GroupDao" %>
<%@ page import="java.util.List" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
<title>Insert title here</title>
</head>
<body>
<%
GroupVo group = (GroupVo) request.getAttribute("group");
%>
<div class="container">
		<br> <br>
		<h3><strong><%=group.getgName() %> 그룹</strong></h3>
		<br> <br>
<table class="table">
<form action="<%= request.getContextPath() %>/group/update?gNo=<%=group.getgNo()%>" method="get" onsubmit="return <%= request.getContextPath() %>/group/update?gNo=<%=group.getgNo()%>">
<input type="hidden" name="gNo" value="<%=group.getgNo() %>">
	
	<tr><th> 모임명 </th><td><%=group.getgName() %> </td></tr>
	<tr><th> 생성일 </th><td><%=group.getgRegdate() %></td></tr>
	<tr><td> <button type="submit">그룹명 수정</button></td>
	<td><a href="<%= request.getContextPath() %>/group/delete?gNo=<%=group.getgNo()%>"">그룹 삭제</a> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	<a href="<%= request.getContextPath() %>/group/search?gNo=<%=group.getgNo()%>"">맴버 초대하기</a></td></tr>
</form> 
</table>
<!-- TODO: 하단에 소속 멤버 표시 -->
</div>
</body>
</html>