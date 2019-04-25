<%@ page import="com.vigplan.dao.member.MemberDao" %>    
<%@ page import="com.vigplan.vo.MemberVo" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="../includes/header.jsp" %>

<title>회원정보</title>
<%
	MemberVo authUser = (MemberVo)session.getAttribute("authUser");
%>
	<br> <br>
	<h3><strong>회원관리 상세 페이지</strong></h3>
	<br> <br>
	<table class="table">
	<tr>
		<td>회원번호</td>
		<td>아이디</td>
		<td>패스워드</td>
		<td>닉네임</td>
		<td>이메일</td>
		<td>가입날짜</td>
		</tr>
		<tr>
<td> <%=authUser.getNo() %></td>
<td> <%=authUser.getId() %></td>
<td> <%=authUser.getPw() %></td>
<td> <%=authUser.getNickname() %></td>
<td> <%=authUser.getEmail() %></td>
<td> <%=authUser.getRegdate() %></td>
<td> <a href="<%= request.getContextPath() %>/member/update?No=<%=authUser.getNo()%>">수정</a>
<td> <a href="<%= request.getContextPath() %>/MemberDao/deleteMember?No=<%=authUser.getNo()%>" onclick="return cancel()">삭제</a>
</tr>
</table>

<%@include file="../includes/footer.jsp" %>


