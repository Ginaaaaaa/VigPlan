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
<div class="container">
		<br> <br>
		<h3><strong>그룹 목록</strong></h3>
		<br> <br>
	<a href="./group/write" class="button">그룹 만들기</a>
		<table class="table">
		<thead>
			<tr><th>가입한 그룹 목록</th>
				<th>그룹 생성일</th>				
			</tr>
			</thead>
			<tbody>
<%			
List<GroupVo> list = (List<GroupVo>)request.getAttribute("list");
for(GroupVo vo: list){					
%>
	<tr><td><a href="group/select?gNo=<%=vo.getgNo()%>"><%=vo.getgName()%></a></td>
		<td><%=vo.getgRegdate()%></td>
	</tr>
	
	<%
}
%>
</tbody>
		</table>
	</div>
</body>
</html>