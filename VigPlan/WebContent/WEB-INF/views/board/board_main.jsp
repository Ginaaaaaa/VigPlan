<%@page import="com.vigplan.vo.BoardVo"%>
<%@page import="java.util.List"%>
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

<!--  
<title>Insert title here</title>
</head>
<body>
	<h1>전체 글보기</h1>
	
	<ul>
<%--  <%
List<BoardVo> list = (List<BoardVo>)request.getAttribute("list"); 
for(BoardVo vo: list) {
%>
<li><%= vo %></li>
<%
}
%> --%>
</ul>
-->


</head>
<body>

	<div class="container">
		<br> <br>
		<h2>전체 글보기</h2>
		<br> <br>
		<table class="table">
			<thead>
				<tr>
					<th></th>
					<th>제목</th>
					<th>작성자</th>
					<th>조회수</th>
					<th>작성일</th>
				</tr>
			</thead>
			<tbody>
				<%
					List<BoardVo> list = (List<BoardVo>) request.getAttribute("list");
					for (BoardVo vo : list) {
				%>
				<tr>
					<td><%=vo.getId()%></td>
					<td><a href="<%= request.getContextPath() %>/board?a=show&id=<%=vo.getId()%>"><%=vo.getTitle()%></a></td>
					<td><%=vo.getWriter()%></td>
					<td><%=vo.getView_cnt()%></td>
					<td><%=vo.getReg_date()%></td>
				</tr>

				<%
					}
				%>
			</tbody>
		</table>

		<!-- button type="button" class="btn btn-secondary btn-sm" onclick="location.href='board?a=form'">글쓰기</button -->
		<a href="<%=request.getContextPath()%>/board?a=form"
			class="btn btn-secondary btn-sm">글쓰기</a>
		<!-- <input type="button" value="글쓰기" > -->
	</div>
</body>
</html>