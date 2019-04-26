<%@page import="com.vigplan.vo.MemberVo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="../includes/header.jsp" %>

<!--  $(document).ready(function() { -->
<!-- 	 $("#regist_btn").click(function() { -->
<%-- <%-- 			location.assign('<%= request.getContextPath() %>/member');  --%> 
<!-- 	 }); -->
<!-- 	 $("#login_btn").click(function() { -->
<%-- <%-- 			location.assign('<%= request.getContextPath() %>/member/login');  --%> 
<!--  	 }); -->
<!--  	 $("#logout_btn").click(function() { -->
<%-- <%-- 			location.assign('<%= request.getContextPath() %>/member/logout');  --%> 
<!-- 	 }); -->
<!-- 	 $("#board_btn").click(function() { -->
<%-- <%-- 			location.assign('<%= request.getContextPath() %>/board');  --%> 
<!-- 	 }); -->
<!--  	 $("#group_btn").click(function() { -->
<%-- <%-- 			location.assign('<%= request.getContextPath() %>/group');  --%> 
<!-- 	 }); -->
<!--   }); -->

<script>
$(document).ready(function() {
	$("#board_btn").click(function() {
		location.assign('<%= request.getContextPath() %>/board'); 
	});
	$("#group_btn").click(function() {
		location.assign('<%= request.getContextPath() %>/group'); 
	});
});
</script>
 


  <font size="7em">
  <div class= "title">
        "VigPlan은 VigTeam에서 개발한 <br>
        웹 기반 모임 관리 사이트입니다."
  </div>
      </font>
<br>
<br>
    <div class="picture" >
<img src="https://www.gettingsmart.com/wp-content/uploads/2017/02/Schedule-calendar-Feature-Image.jpg" height= "400px" width="850px">
</div>
<br><br><br>

<div class="container" style="text-align:center">
    <div style="float: left;">
      <img src="./img/colormap.png"><br><br>
      <font size="4em">
      모임 장소, 더 이상 고민하지 마세요
    </font>
    </div>
    <div style="float: right;">
        <img src="./img/colordance.png"><br><br>
        <font size="4em">
    협찬, 광고 없는 100% 리얼 후기
    </font>
    </div>
    <div style="float: center;">
    <img src="./img/colormoim.png"><br><br>
    <font size="4em">
    모임 관리를 더욱 편리하게
    </font>
    </div>
  </div>

 


<%-- <% --%>
<!--   MemberVo authUser = (MemberVo)session.getAttribute("authUser"); -->
<%-- %> --%>
<!-- 	<h1>메인페이지</h1> -->
<%-- <% if (authUser != null) { %> --%>
<%-- 	<h3>현재 사용자: <%= authUser.getNickname() %>(<%= authUser.getId() %>)</h3> --%>
<%-- <% } %> --%>
<!-- 	<hr> -->
<!-- 	<button id="regist_btn" class="btn">회원가입 하기</button> -->
<%-- <% if (authUser == null) { %>	 --%>
<!-- 	<button id="login_btn" class="btn">로그인 하기</button> -->
<%-- <% } else { %> --%>
<!-- 	<button id="logout_btn" class="btn">로그아웃 하기</button> -->
<%-- <% } %> --%>
<!-- 	<button id="board_btn" class="btn">게시판</button> -->
<!-- 	<button id="group_btn" class="btn">그룹</button> -->

<button id="board_btn" class="btn">게시판</button>
<button id="group_btn" class="btn">그룹</button>
<%@include file="../includes/footer.jsp" %>