<%@page import="com.vigplan.vo.MemberVo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="../includes/header.jsp" %>
 <script type="text/javascript">
 $(document).ready(function() {
	 $("#regist_btn").click(function() {
			location.assign('<%= request.getContextPath() %>/member'); 
	 });
	 $("#login_btn").click(function() {
			location.assign('<%= request.getContextPath() %>/member/login'); 
	 });
	 $("#logout_btn").click(function() {
			location.assign('<%= request.getContextPath() %>/member/logout'); 
	 });
	 $("#board_btn").click(function() {
			location.assign('<%= request.getContextPath() %>/board'); 
	 });
	 $("#group_btn").click(function() {
			location.assign('<%= request.getContextPath() %>/group'); 
	 });
 });
 
 </script>
<%
MemberVo authUser = (MemberVo)session.getAttribute("authUser");
%>
	<h1>메인페이지</h1>
<% if (authUser != null) { %>
	<h3>현재 사용자: <%= authUser.getNickname() %>(<%= authUser.getId() %>)</h3>
<% } %>
	<hr>
	<button id="regist_btn" class="btn">회원가입 하기</button>
<% if (authUser == null) { %>	
	<button id="login_btn" class="btn">로그인 하기</button>
<% } else { %>
	<button id="logout_btn" class="btn">로그아웃 하기</button>
<% } %>
	<button id="board_btn" class="btn">게시판</button>
	<button id="group_btn" class="btn">그룹</button>
<%@include file="../includes/footer.jsp" %>