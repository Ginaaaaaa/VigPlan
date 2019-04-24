<%@page import="com.vigplan.vo.MemberVo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@page import="com.vigplan.vo.BoardVo"%>
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
<style>
table th {
	text-align: center;
}

.table {
	margin: auto;
	width: 50% !important;
}

div.absolute {
  position: absolute;
  width: 35%;
  bottom: 150px;
  right: 10px;

} 

div.title {
	position: absolute;
	left: 10px;
}

</style>

</head>
<%
	MemberVo authUser = (MemberVo) session.getAttribute("authUser");
%>
<body>
	<div class="container" align="left">
		<br> 
		<br>
		<div class="title">
		<h3>새 글 작성</h3>
		</div>
		<br>
		
		<form class="form-inline"
			action="<%=request.getContextPath()/*ServletStudy*/%>/board"
			method="POST">
			<input type="hidden" name="a" value="write"> <input
				type="hidden" name="writer" value="<%=authUser.getNickname()%>">
			<input type="hidden" name="memberNo" value="<%=authUser.getNo()%>">
			<table class="table" border="2" width="500">

				<tr>
					<td align="center">제목</td>
					<td><input type="text" size="40" name="title"></td>
				</tr>
				<tr>
					<td colspan="2"><textarea cols="100" rows="20" name="content"></textarea>
					</td>
				</tr>
				<tr>
					<td align="center">파일 첨부</td>
					<td><input type="file" name="fileName"></td>
				</tr>
				<tr>
					<td align="center">비밀번호</td>
					<td><input type="password" name="password"></td>
				</tr>
			</table>
			<br>
			<div class="absolute">
				<button type="submit" class="btn btn-primary mb-2">완료</button>
			</div>
		</form>
	</div>

</body>
</html>