<%@ page import="com.vigplan.vo.GroupVo" %>
<%@ page import="com.vigplan.vo.MVo" %>
<%@ page import="com.vigplan.dao.group.GroupDao" %>
<%@ page import="java.util.List" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="../includes/header.jsp" %>

		<br> <br>
		<h3><strong>그룹 목록</strong></h3>
		<br> <br>
	<a href="./group/write" class="button">그룹 만들기</a>
		<table class="table">
		<thead>
			<tr><th>가입한 그룹 목록</th>
				<th>그룹 생성일</th>				
			</tr>
			</thead>
			<tbody>
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
</tbody>
		</table>
	<%@include file="../includes/footer.jsp" %>