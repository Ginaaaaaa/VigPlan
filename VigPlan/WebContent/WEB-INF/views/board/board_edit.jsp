<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="com.vigplan.vo.BoardVo"%>
<%@include file="../includes/header.jsp" %>
	<%
		BoardVo item = (BoardVo) request.getAttribute("item");
	%>
	
		<br> <br>
		<h2>수정하기</h2>
		<br>
		<form class="form-inline" action="<%=request.getContextPath()%>/board"
			method="POST">
			
			<input type="hidden" name="a" value="editer">
			<input type="hidden" name="id" value="<%= item.getId() %>">
			<div class="form-group">
				<label for="title" class="mb-2 mr-sm-2">제목</label> 
				<input type="text" class="form-control mb-2 mr-sm-2" name="title"
					value="<%= item.getTitle()%>">
			</div>

			<div class="form-group">
				<label for="content" class="mb-2 mr-sm-2">수정 내용:</label> 
				<input type="text" class="form-control mb-2 mr-sm-2" name="content"
					value="<%= item.getContent() %>">
			</div>

			<!-- div class="form-group">
				<label for="id" class="mb-2 mr-sm-2">id:</label> <input type="text"
					class="form-control mb-2 mr-sm-2" name="id">
			</div -->

			<button type="submit" class="btn btn-primary mb-2">수정완료</button>
		</form>
<%@include file="../includes/footer.jsp" %>