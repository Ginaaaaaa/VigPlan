<%@ page import="com.vigplan.vo.GroupVo" %>
<%@ page import="com.vigplan.vo.MemberVo" %>
<%@ page import="com.vigplan.dao.group.GroupDao" %>
<%@ page import="java.util.List" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="../includes/header.jsp" %>
<%
GroupVo group = (GroupVo) request.getAttribute("group");
%>
		<br> <br>
		<h3><strong><%=group.getgName() %> 그룹</strong></h3>
		<br> <br>
<table class="table">
<form action="<%= request.getContextPath() %>/group/update" method="get">
<input type="hidden" name="gNo" value="<%=group.getgNo() %>">
	
	<tr><th> 그룹명 </th><td><%=group.getgName() %> </td></tr>
	<tr><th> 생성일 </th><td><%=group.getgRegdate() %></td></tr>
	<tr><th> 멤버 목록</th><td>
	<%
List<MemberVo> list = (List<MemberVo>)request.getAttribute("list");
for(MemberVo vo: list){	
%>
	<%=vo.getId()%> &nbsp;
	<%
	}
	%>
	</td>
	</tr>
	<tr><td> <button type="submit">그룹명 수정</button></td>
	<td><a href="<%= request.getContextPath() %>/group/delete?gNo=<%=group.getgNo()%>"">그룹 삭제</a> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	<a href="<%= request.getContextPath() %>/group/search?gNo=<%=group.getgNo()%>"">맴버 초대하기</a></td></tr>
</form> 
</table>
<%@include file="../includes/footer.jsp" %>