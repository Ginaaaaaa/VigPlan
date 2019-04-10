<%@page import="com.vigplan.vo.BoardVo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
<title>Insert title here</title>
</head>
<body>
<div class="container">

<br> <br>
		<h2>내용</h2>
		<br> <br>
		<table class="table">
			<thead>
				<tr>
					<th>제목</th>
					<th>작성자</th>
					<th>내용</th>
					<th>날짜</th>
				</tr>
			</thead>
			<tbody>
			<%	
BoardVo item = (BoardVo)request.getAttribute("item");
//object로 받아온 것 바꿔줌
%>
			<tr>
					<td><%=item.getTitle()%></td>
					<td><%=item.getWriter()%></td>
					<td><%=item.getContent()%></td>
					<td><%=item.getReg_date()%></td>
				</tr>
			
			
			
			</tbody>
			</table>
			<a href="<%=request.getContextPath()%>/board?a=edit"
			class="btn btn-secondary btn-sm">수정</a>
			
			<a href="<%=request.getContextPath()%>/board?a=delete&id=<%=item.getId()%>"
			class="btn btn-secondary btn-sm">삭제</a>
			
	
</div>
</body>
</html>