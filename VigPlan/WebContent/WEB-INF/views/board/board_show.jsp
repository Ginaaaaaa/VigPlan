<%@page import="com.vigplan.vo.BoardVo"%>
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

<script language="javascript">
	function checkForm(frm) {
		var password = frm.password.value;
		if (password.length == 0) {
			alert('비밀번호를 입력하세요.');
			frm.password.focus();
		} else {
			frm.submit();
		}
	}
</script>

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
					BoardVo item = (BoardVo) request.getAttribute("item");
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


		<%-- 			<a href="<%=request.getContextPath()%>/board?a=edit&id=<%=item.getId()%>"
			class="btn btn-secondary btn-sm" >수정</a>
			
			<a href="<%=request.getContextPath()%>/board?a=delete&id=<%=item.getId()%>"
			class="btn btn-secondary btn-sm">삭제</a> --%>

		<button type="button" class="btn btn-secondary btn-sm"
			data-toggle="modal" data-target="#myModal1">수정</button>
		<%-- 			<a href="<%=request.getContextPath()%>/board?a=delete&id=<%=item.getId()%>"
				class="btn btn-secondary btn-sm" data-toggle="modal"
				data-target="#myModal">삭제</a> --%>

		<button type="button" class="btn btn-secondary btn-sm"
			data-toggle="modal" data-target="#myModal">삭제</button>

		<a href="<%=request.getContextPath()%>/board"
			class="btn btn-secondary btn-sm">리스트</a>







		<div class="modal" id="myModal1">
			<div class="modal-dialog">
				<div class="modal-content">

					<!-- Modal Header -->
					<div class="modal-header">
						<!--  <h4 class="modal-title">Modal Heading</h4> -->
						<button type="button" class="close" data-dismiss="modal">&times;</button>
					</div>
					<form action="<%=request.getContextPath()%>/board" method="POST">
					<input type="hidden" name="a" value="edit">
					<input type="hidden" name="id" value="<%=item.getId()%>">
						<div class="modal-body">
							게시글을 수정하시겠습니까?<br> <br> 비밀번호를 입력해주세요.<br> 
							<label for="password">비밀번호:</label> 
							<input type="password" name="password">
						</div>

						<!-- Modal footer -->
						<div class="modal-footer">


							<input type="button" class="btn btn-primary" value="YES" onclick="checkForm(this.form)">
							<button type="button" class="btn btn-danger" data-dismiss="modal">NO</button>
						
						</div>
					</form>

					<!-- Modal body -->
	<%-- 				<div class="modal-body">게시글을 수정하시겠습니까?</div><br><br>
					<input type=password>
					<!-- 패스워드 입력 폼 -->
					<!-- Modal footer -->
					<div class="modal-footer">
						<a
							href="<%=request.getContextPath()%>/board?a=edit&id=<%=item.getId()%>"
							button type="button" class="btn btn-primary">YES</a>
						<button type="button" class="btn btn-danger" data-dismiss="modal">NO</button>
					</div> --%>

				</div>
			</div>
		</div>







		<div class="modal" id="myModal">

			<div class="modal-dialog">
				<div class="modal-content">
					<!-- Modal Header -->
					<div class="modal-header">
						<!--  <h4 class="modal-title">Modal Heading</h4> -->
						<button type="button" class="close" data-dismiss="modal">&times;</button>
					</div>

					<!-- Modal body -->


					<form action="<%=request.getContextPath()%>/board" method="POST">
					<input type="hidden" name="a" value="delete">
					<input type="hidden" name="id" value="<%=item.getId()%>">
						<div class="modal-body">
							게시글을 삭제하시겠습니까?<br> <br> 비밀번호를 입력해주세요.<br> 
							<label for="password">비밀번호:</label> 
							<input type="password" name="password">
						</div>

						<!-- Modal footer -->
						<div class="modal-footer">


							<input type="button" class="btn btn-primary" value="YES" onclick="checkForm(this.form)">
							<button type="button" class="btn btn-danger" data-dismiss="modal">NO</button>
						
						</div>
					</form>
				</div>
			</div>

		</div>

	</div>
</body>
</html>