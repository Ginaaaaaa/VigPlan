<%@page import="com.vigplan.vo.MVo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>Insert title here</title>
</head>
<body>
<%
MVo moim = (MVo) request.getAttribute("moim");
%>
<h1>모임 수정하기</h1>
<form action="<%= request.getContextPath() %>/moim/update" method="post" onsubmit="return <%= request.getContextPath() %>/moim">
<table border="1">
<input type="hidden" name="mNo" value="<%= moim.getmNo() %>">
<tr><td>모임명</td><td><input type="text" name="mTitle" value="<%=moim.getmTitle()%>"></td></tr>
<tr><td>날짜</td><td><input type="datetime-local" name="mDate" value="<%=moim.getmDate()%>"></td></tr>
<tr><td>장소</td><td><input type="text" name="mPlace" value="<%=moim.getmPlace()%>"></td></tr>
<tr><td>소개</td><td><input type="text" name="mContent" value="<%=moim.getmContent()%>"></td></tr>
<tr><td><input type="submit" value="모임 수정">
</table>
</form>


</body>
</html>