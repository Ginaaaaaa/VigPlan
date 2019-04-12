<%@ page import="com.vigplan.vo.MVo" %>
<%@ page import="com.vigplan.dao.MDao" %>
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


<%
List<MVo> list = (List<MVo>)request.getAttribute("list");
for(MVo vo: list){
	%>
	<li><%=vo %></li>
	<%
}
%>



</body>
</html>