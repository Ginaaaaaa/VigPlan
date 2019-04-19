<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="../includes/header.jsp" %>
<br> <br>
		<h3><strong>모임 만들기</strong></h3>
		<br> <br>
<form action="<%= request.getContextPath() %>/moim/write" method="post">
<table border="1">
<tr><td>모임명</td><td><input type="text" name="mTitle"></td></tr>
<tr><td>날짜</td><td><input type="datetime-local" name="mDate"></td></tr>
<tr><td>장소</td><td><input type="text" name="mPlace"></td></tr>
<tr><td>소개</td><td><input type="text" name="mContent"></td></tr>
<tr><td><input type="submit" value="모임 생성">
<input type="reset" value="다시작성">
<input type="button" value="목록보기" onclick="location.href='<%= request.getContextPath() %>/moim'"></td></tr>
</table>
</form>
<%@include file="../includes/footer.jsp" %>