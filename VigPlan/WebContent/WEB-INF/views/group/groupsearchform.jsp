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
		<h3><strong>아이디로 그룹 초대</strong></h3>
		<br> <br>
<form name="invite" method="post" action="<%= request.getContextPath() %>/group/search">
	<input type="hidden" name="gNo" value="<%=group.getgNo() %>">
	<input type="text" name="searchid" placeholder="초대하고 싶은 아이디 입력">
	<button type="submit">검색</button>
</form>
</div>
</body>
</html>