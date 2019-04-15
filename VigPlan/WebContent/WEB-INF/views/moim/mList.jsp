<%@ page import="com.vigplan.vo.MVo" %>
<%@ page import="com.vigplan.dao.moim.MDao" %>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html>


<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<div class="col-md-12"><a class="button" href="./moim/write" >모임 만들기</a></div>


<table>
      <tr>
            <td>번호</td>
            <td>모임명</td>
            <td>날짜</td>
            <td>장소</td>
            <td>소개</td>
      </tr>
      <tr>
      
<%
List<MVo> list = (List<MVo>)request.getAttribute("list");
 for(MVo vo: list){
	%>
	</tr>
	<td> <%=vo.getmNo() %></td>
	<td><a href="#"><%=vo.getmTitle() %></a></td>
	<td> <%=vo.getmDate() %></td>
	<td> <%=vo.getmPlace() %></td>
	<td> <%=vo.getmContent() %></td>
	<td> <a href="./moim/update?mNo=<%=vo.getmNo()%>">수정</a>
	<td> <a href="./moim/delete?mNo=<%=vo.getmNo()%>">삭제</a>
	<tr>
	<%
}
%>
</tr>
</table>


</body>
</html>