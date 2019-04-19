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
<%
		PlaceVo item = (PlaceVo) request.getAttribute("item");
	%>
<div class="container">
		<br> <br>
		<h2>장소 수정</h2>
		<br>
		<form class="form-inline"
			action="<%=request.getContextPath()/*ServletStudy*/%>/place"
			method="POST"> 
			<input type="hidden" name="a" value="editer">
			<input type="hidden" name="pk" value="<%= item.getPk()%>">
	
			<div class="form-group">
				<label for="title" class="mb-2 mr-sm-2"></label>제목<input
					type="text" class="form-control mb-2 mr-sm-2" name="title" value="<%= item.getTitle()%>">
			</div>
			<br> <br>

			<div class="form-group">
				<label for="link" class="mb-2 mr-sm-2">링크</label> <input
					type="text" class="form-control mb-2 mr-sm-2" name="link" value="<%= item.getLink()%>">
			</div>

			<div class="form-group">
				<label for="description" class="mb-2 mr-sm-2">설명</label> <input
					type="text" class="form-control mb-2 mr-sm-2" name="description" value="<%= item.getDescription()%>">
			</div>

			<div class="form-group">
				<label for="telephone" class="mb-2 mr-sm-2">전화번호</label> <input
					type="text" class="form-control mb-2 mr-sm-2" name="telephone" value="<%= item.getTelephone()%>">
			</div>
			
			<div class="form-group">
				<label for="address" class="mb-2 mr-sm-2">주소</label> <input
					type="text" class="form-control mb-2 mr-sm-2" name="address" value="<%= item.getAddress()%>">
			</div>
			
			<div class="form-group">
				<label for="roadAddress" class="mb-2 mr-sm-2">도로명 주소</label> <input
					type="text" class="form-control mb-2 mr-sm-2" name="roadAddress" value="<%= item.getRoadAddress()%>">
			</div>
			
			<div class="form-group">
				<label for="mapx" class="mb-2 mr-sm-2">x좌표</label> <input
					type="text" class="form-control mb-2 mr-sm-2" name="mapx" value="<%= item.getMapx()%>">
			</div>
			
			<div class="form-group">
				<label for="mapy" class="mb-2 mr-sm-2">y좌표</label> <input
					type="text" class="form-control mb-2 mr-sm-2" name="mapy" value="<%= item.getMapy()%>">
			</div>


			<!--     <div class="form-group">
    <label for="content" class="mb-2 mr-sm-2">내용</label>
    <input type="content" class="form-control mb-2 mr-sm-2" name="content">
    </div> -->

			<button type="submit" class="btn btn-primary mb-2">완료</button>
		</form>
	</div>

</body>
</html>