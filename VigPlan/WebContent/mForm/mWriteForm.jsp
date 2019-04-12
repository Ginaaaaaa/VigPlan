<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>


<h1>모임 만들기</h1>
<form action="<%= request.getContextPath() %>/MWriteServlet" method="post" onsubmit="return mList.jsp">
<table border="1">
<tr><td>모임명</td><td><input type="text" name="mTitle"></td></tr>
<tr><td>날짜</td><td><input type="datetime-local" name="mDate"></td></tr>
<tr><td>장소</td><td><input type="text" name="mPlace"></td></tr>
<tr><td>소개</td><td><input type="text" name="mContent"></td></tr>
<tr><td><input type="submit" value="모임 생성">
<input type="reset" value="다시작성">
<input type="button" value="목록보기" onclick="location.href='mList.jsp'"></td></tr>
</table>
</form>

</body>
</html>
