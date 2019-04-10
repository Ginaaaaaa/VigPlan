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
</head>
<body>
	<div class="container">
		<br> <br>
		<h2>수정하기</h2>
		<br>
		<form class="form-inline"
			action="<%=request.getContextPath()/*ServletStudy*/%>/board"
			method="POST">
			<input type="hidden" name="a" value="edit">
			<div class="form-group">
				<label for="title" class="mb-2 mr-sm-2">제목:</label> 
				<input type="text" class="form-control mb-2 mr-sm-2" name="title">
			</div>
			<br> <br>

			<div class="form-group">
				<label for="writer" class="mb-2 mr-sm-2">작성자</label> 
				<input type="text" class="form-control mb-2 mr-sm-2" name="writer">
			</div>

			<div class="form-group">
				<label for="content" class="mb-2 mr-sm-2">내용</label> 
				<input type="text" class="form-control mb-2 mr-sm-2" name="content">
			</div>

			<div class="form-group">
				<label for="password" class="mb-2 mr-sm-2">비밀번호</label> 
				<input type="password" class="form-control mb-2 mr-sm-2" name="password">
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