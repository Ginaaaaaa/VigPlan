<%@page import="com.vigplan.vo.MVo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="../includes/header.jsp" %>
<%
MVo moim = (MVo) request.getAttribute("moim");
%>
<br> <br>
		<h3><strong>모임 수정하기</strong></h3>
		<br> <br>
<form action="<%= request.getContextPath() %>/moim/update" method="post">
<table class="table">
<input type="hidden" name="mNo" value="<%= moim.getmNo() %>">
<tr><td>모임명</td><td><input type="text" name="mTitle" value="<%=moim.getmTitle()%>"></td></tr>
<tr><td>날짜</td><td><input type="datetime-local" name="mDate" value="<%=moim.getmDate()%>"></td></tr>
<tr><td>소개</td><td><input type="text" name="mContent" value="<%=moim.getmContent()%>"></td></tr>
<tr><td><input type="submit" value="모임 수정">
</table>
</form>
<%@include file="../includes/footer.jsp" %>