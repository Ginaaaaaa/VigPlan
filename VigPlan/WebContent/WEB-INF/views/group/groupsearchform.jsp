<%@ page import="com.vigplan.vo.GroupVo" %>
<%@ page import="com.vigplan.dao.group.GroupDao" %>
<%@ page import="java.util.List" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="../includes/header.jsp" %>
<%
GroupVo group = (GroupVo) request.getAttribute("group");
%>
		<br> <br>
		<h3><strong>아이디로 그룹 초대</strong></h3>
		<br> <br>
<form name="invite" method="post" action="<%= request.getContextPath() %>/group/search">
	<input type="hidden" name="gNo" value="<%=group.getgNo() %>">
	<input type="text" name="searchid" placeholder="초대하고 싶은 아이디 입력">
	<button type="submit">검색</button>
</form>
<%@include file="../includes/footer.jsp" %>