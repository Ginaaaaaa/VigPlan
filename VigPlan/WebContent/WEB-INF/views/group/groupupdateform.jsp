<%@ page import="com.vigplan.vo.GroupVo" %>
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
		<h3><strong>그룹 수정</strong></h3>
		<br> <br>
<form action="<%= request.getContextPath() %>/group/update" name="gupdate" method="post" onsubmit="return <%= request.getContextPath() %>/group">
<table class="table">
<input type="hidden" name="gNo" value="<%= group.getgNo() %>">
<tr><th>모임명</th><td><input type="text" name="gName" value="<%=group.getgName()%>"></td></tr>
<tr><td><input type="submit" value="모임 수정" >
</table>
</form>
</div>

</body>
</html>