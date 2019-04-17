<%@ page import="com.vigplan.vo.GroupVo" %>
<%@ page import="com.vigplan.vo.MemberVo" %>
<%@ page import="com.vigplan.dao.group.GroupDao" %>
<%@ page import="com.vigplan.dao.member.MemberDao" %>
<%@ page import="java.util.List" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%			
List<MemberVo> list = (List<MemberVo>)request.getAttribute("list");
for(MemberVo vo: list){		
	
GroupVo group = (GroupVo) request.getAttribute("group");
%>
<form action="<%= request.getContextPath() %>/group/invite" method="post">
<input type="hidden" name="gNo" value="<%= group.getgNo() %>">
<input type="hidden" name="no" value="<%=vo.getNo() %>">
	<table>
	<tr>
	<td>아이디</td>
	<td>이메일</td>
	<td>초대</td>
	</tr>
	<tr>
	<td><%=vo.getId() %></td>
	<td><%=vo.getNickname() %></td>
	<td><button type="sumit">초대</button> </td>
	</tr>
	</table>
</form>
	<%
}
%>
</body>
</html>