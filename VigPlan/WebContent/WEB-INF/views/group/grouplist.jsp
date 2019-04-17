<%@ page import="com.vigplan.vo.GroupVo" %>
<%@ page import="com.vigplan.dao.group.GroupDao" %>
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
	<a href="./group/write" class="button">그룹 만들기</a>
	<div>
		<table border="1">
			<tr><td>가입한 그룹 목록</td>
				<td>그룹 생성일</td>				
			</tr>
<%			
List<GroupVo> list = (List<GroupVo>)request.getAttribute("list");
for(GroupVo vo: list){					
%>
	<tr><td><a href="group/select?gNo=<%=vo.getgNo()%>"><%=vo.getgName()%></a></td>
		<td><%=vo.getgRegdate()%></td>
	</tr>
	
	<%
}
%>
		</table>
	</div>
</body>
</html>