<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
 <script type="text/javascript">
 $(document).ready(function() {
	 $("#regist_btn").click(function() {
		 	alert('회원가입 페이지로 이동합니다.');
			location.assign('/VigPlan/member'); 
	 });
 });
 
 $(document).ready(function() {
	 $("#login_btn").click(function() {
		 	alert('로그인 페이지로 이동합니다.');
			location.assign('/VigPlan/member/login'); 
	 });
 });
 
 $(document).ready(function() {
	 $("#board_btn").click(function() {
		 	alert('게시판으로 이동합니다.');
			location.assign('/VigPlan/board'); 
	 });
 });
 
 $(document).ready(function() {
	 $("#group_btn").click(function() {
		 	alert('그룹으로 이동합니다.');
			location.assign('/VigPlan/group'); 
	 });
 });
 
 $(document).ready(function() {
	 $("#moim_btn").click(function() {
		 	alert('모임으로 이동합니다.');
			location.assign('/VigPlan/moim'); 
	 });
 });
 
 </script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

</head>
<body>

<div class="container">
	<h1>메인페이지</h1>
	<hr>
	<button id="regist_btn" class="btn">회원가입 하기</button>
	<button id="login_btn" class="btn">로그인 하기</button>
	<button id="board_btn" class="btn">게시판</button>
	<button id="group_btn" class="btn">그룹</button>
	<button id="moim_btn" class="btn">모임</button>
</div>

</body>
</html>