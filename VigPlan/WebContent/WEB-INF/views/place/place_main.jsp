<%@page import="com.vigplan.vo.PlaceVo"%>
<%@page import="java.util.List"%>
<%@page import="com.vigplan.vo.MVo" %>
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
<%
MVo moim = (MVo)request.getAttribute("moim");	//	NULL
	%>
	<div class="container">
		<br> <br>
		<h3>
			<strong>장소</strong>
		</h3>
		<br> <br>
		<table class="table">
			<thead>
				<tr>
				
					<th>제목</th>
					<th>링크</th>
					<th>설명</th>
					<th>전화번호</th>
					<th>주소</th>
					<th>도로명 주소</th>
					<th>x좌표</th>
					<th>y좌표</th>
					
				</tr>
			</thead>
			<tbody>
				<%
					List<PlaceVo> list = (List<PlaceVo>) request.getAttribute("list");
					for (PlaceVo vo : list) {
				%>
				<tr>
					<td><a
						href="<%=request.getContextPath()%>/place?a=content&pk=<%=vo.getPk()%>&mNo=<%=moim.getmNo() %>"><%=vo.getTitle()%><%--</a> --%></td>
					
					<td><%=vo.getLink()%></td>
					<td><%=vo.getDescription()%></td>
					<td><%=vo.getTelephone() %></td>
					<td><%=vo.getAddress() %></td>
					<td><%=vo.getRoadAddress() %></td>
					<td><%=vo.getMapx() %></td>
					<td><%=vo.getMapy() %></td>
				</tr>

				<%
					}
				%>
			</tbody>
		</table>

		
	<a href="<%= request.getContextPath() %>/place?a=form&mNo=<%=moim.getmNo() %>" class="btn btn-primary">장소 등록</a>
	</div>
</body>
</body>
</html>