<%@ page import="com.vigplan.vo.GroupVo" %>
<%@ page import="com.vigplan.vo.MemberVo" %>
<%@ page import="com.vigplan.dao.group.GroupDao" %>
<%@ page import="com.vigplan.dao.member.MemberDao" %>
<%@ page import="java.util.List" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
<title>Insert title here</title>
<script typr="text/javascript">
//
</script>
</head>
<body>
<br> <br>
		<h3><strong>아이디 검색 결과</strong></h3>
		<br> <br>
<div class="container">

	<table class="table">
	<thead>
	<tr>
	<th>아이디</th>
	<th>닉네임</th>
	<th>초대버튼</th>
	</tr>
	</thead>
	<%	
	GroupVo group = (GroupVo) request.getAttribute("group");
List<MemberVo> list = (List<MemberVo>)request.getAttribute("list");
for(MemberVo vo: list){	
%>
	<tbody>
	<tr>
	<form action="<%= request.getContextPath() %>/group/invite" method="post">
	<input type="hidden" name="gNo" value="<%= group.getgNo() %>">
	<input type="hidden" name="no" value="<%=vo.getNo() %>">
	<td><%=vo.getId() %></td>
	<td><%=vo.getNickname() %></td>
	<td><button type="sumit">초대</button></td>
	</form>
	<%
}
%>
	</tr>
	</tbody>
	</table>
</div>
</body>
</html>