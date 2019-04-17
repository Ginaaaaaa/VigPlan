<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="com.vigplan.vo.PlaceVo"%>
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

		<br> <br> <br> <br>

		<table class="table">
			<thead>
				<tr>
					<th>제목</th>
					<th>링크</th>
					<th>설명</th>
					<th>전화</th>
					<th>주소</th>
					<th>도로명 주소</th>
					<th>x좌표</th>
					<th>y좌표</th>
				</tr>
			</thead>
			<tbody>

				<%
					PlaceVo item = (PlaceVo) request.getAttribute("item");
					//object로 받아온 것 바꿔줌
				%>
				<tr>
					<td><%=item.getTitle()%></td>
					<td><%=item.getLink()%></td>
					<td><%=item.getDescription()%></td>
					<td><%=item.getTelephone()%></td>
					<td><%=item.getAddress()%></td>
					<td><%=item.getRoadAddress()%></td>
					<td><%=item.getMapx()%></td>
					<td><%=item.getMapy()%></td>
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

		<a href="<%=request.getContextPath()%>/place"
			class="btn btn-secondary btn-sm">리스트</a>



		<div class="modal" id="myModal1">
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-header">
						<!--  <h4 class="modal-title">Modal Heading</h4> -->
						<button type="button" class="close" data-dismiss="modal">&times;</button>
					</div>
					<form action="<%=request.getContextPath()%>/place" method="POST">
						<input type="hidden" name="a" value="edit"> 
						<input type="hidden" name="pk" value="<%=item.getPk()%>">
						<div class="modal-body">
							<br> <br> 게시글을 수정하시겠습니까? <br> <br> <br>
							<div class="modal-footer">


								<input type="submit" value="YES" class="btn btn-primary">

								<button type="button" class="btn btn-danger"
									data-dismiss="modal">NO</button>

							</div>
						</div>
					</form>

				</div>
			</div>
		</div>
	</div>
	
	
	<div class="modal" id="myModal">
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-header">
						<!--  <h4 class="modal-title">Modal Heading</h4> -->
						<button type="button" class="close" data-dismiss="modal">&times;</button>
					</div>
					<form action="<%=request.getContextPath()%>/place" method="POST">
						<input type="hidden" name="a" value="delete"> 
						<input type="hidden" name="pk" value="<%=item.getPk()%>">
						<div class="modal-body">
							<br> <br> 게시글을 삭제하시겠습니까? <br> <br> <br>
							<div class="modal-footer">


								<input type="submit" value="YES" class="btn btn-primary">

								<button type="button" class="btn btn-danger"
									data-dismiss="modal">NO</button>

							</div>
						</div>
					</form>

				</div>
			</div>
		</div>
	</div>
	

</body>
</html>