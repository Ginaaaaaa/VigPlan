<%@page import="com.vigplan.vo.MemberVo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="../includes/header.jsp" %>


<%
MemberVo authUser = (MemberVo)session.getAttribute("authUser");%>
	<div class="container">
		<br> <br>
		<h2>글쓰기</h2>

		<br>
		<form class="form-inline"
			action="<%=request.getContextPath()/*ServletStudy*/%>/board"
			method="POST"> 
			<input type="hidden" name="a" value="write">
			<input type="hidden" name="writer" value="<%=authUser.getNickname() %>">
			<input type="hidden" name="memberNo" value="<%=authUser.getNo() %>">
			<div class="form-group">
				<label for="title" class="mb-2 mr-sm-2">제목:</label> <input
					type="text" class="form-control mb-2 mr-sm-2" name="title">
			</div>
			

			<div class="form-group">
				<label for="content" class="mb-2 mr-sm-2">내용</label> <input
					type="text" class="form-control mb-2 mr-sm-2" name="content">
			</div>

			<div class="form-group">
				<label for="password" class="mb-2 mr-sm-2">비밀번호</label> <input
					type="password" class="form-control mb-2 mr-sm-2" name="password">
			</div>


			<!--     <div class="form-group">
    <label for="content" class="mb-2 mr-sm-2">내용</label>
    <input type="content" class="form-control mb-2 mr-sm-2" name="content">
    </div> -->

			<button type="submit" class="btn btn-primary mb-2">완료</button>
		</form>
<%@include file="../includes/footer.jsp" %>