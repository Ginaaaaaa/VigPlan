<%@ page import="com.vigplan.vo.GroupVo" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="../includes/header.jsp" %>
<%
GroupVo group = (GroupVo) request.getAttribute("group");
%>
		<br> <br>
		<h3><strong>그룹 수정</strong></h3>
		<br> <br>
<form action="<%= request.getContextPath() %>/group/update" name="gupdate" method="post">
<table class="table">
<input type="hidden" name="gNo" value="<%= group.getgNo() %>">
<tr><th>수정할 그룹명</th><td><input type="text" name="gName" value="<%=group.getgName()%>"></td></tr>
<tr><td><input type="submit" value="수정하기" >
</table>
</form>
<%@include file="../includes/footer.jsp" %>