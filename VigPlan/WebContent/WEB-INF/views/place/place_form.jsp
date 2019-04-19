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
		<h2>장소 등록</h2>
		<br>
		<form class="form-inline"
			action="<%=request.getContextPath()%>/place"
			method="POST">
			<input type="hidden" name="a" value="insert">
			<div class="form-group">
				<label for="title" class="mb-2 mr-sm-2">제목</label> <input
					type="text" class="form-control mb-2 mr-sm-2" name="title">
			</div>
			<br> <br>

			<div class="form-group">
				<label for="link" class="mb-2 mr-sm-2">링크</label> <input
					type="text" class="form-control mb-2 mr-sm-2" name="link">
			</div>

			<div class="form-group">
				<label for="description" class="mb-2 mr-sm-2">설명</label> <input
					type="text" class="form-control mb-2 mr-sm-2" name="description">
			</div>

			<div class="form-group">
				<label for="telephone" class="mb-2 mr-sm-2">전화</label> <input
					type="text" class="form-control mb-2 mr-sm-2" name="telephone">
			</div>
			
			<div class="form-group">
				<label for="address" class="mb-2 mr-sm-2">주소</label> <input
					type="text" class="form-control mb-2 mr-sm-2" name="address">
			</div>
			
			<div class="form-group">
				<label for="roadAddress" class="mb-2 mr-sm-2">도로명 주소</label> <input
					type="text" class="form-control mb-2 mr-sm-2" name="roadAddress">
			</div>
			
			<div class="form-group">
				<label for="mapx" class="mb-2 mr-sm-2">x좌표</label> <input
					type="text" class="form-control mb-2 mr-sm-2" name="mapx">
			</div>
			
			<div class="form-group">
				<label for="mapy" class="mb-2 mr-sm-2">y좌표</label> <input
					type="text" class="form-control mb-2 mr-sm-2" name="mapy">
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