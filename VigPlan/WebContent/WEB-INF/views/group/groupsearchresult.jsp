<%@ page import="com.vigplan.vo.GroupVo" %>
<%@ page import="com.vigplan.vo.MemberVo" %>
<%@ page import="com.vigplan.dao.group.GroupDao" %>
<%@ page import="com.vigplan.dao.member.MemberDao" %>
<%@ page import="java.util.List" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%if(!"embedded".equals(request.getParameter("a"))){%>   <!-- 문자열 비교는 .equals() -->
<%@include file="../includes/header.jsp" %>
<% } %>
		<br> <br>
		<h3><strong>아이디 검색 결과</strong></h3>
		<br> <br>

	<table class="table">
	
	<tr>
	<th>아이디</th>
	<th>닉네임</th>
	<th>초대버튼</th>
	</tr>

	<%
	GroupVo group = (GroupVo) request.getAttribute("group");
	List<MemberVo> list = (List<MemberVo>)request.getAttribute("list");
for(MemberVo vo: list){	
%>
	<tr><td colspan="3" style="border-top: hidden; padding-top: 0; padding-bottom:0;">
	<form action="<%= request.getContextPath() %>/group/invite" method="post">
	<input type="hidden" name="gNo" value="<%= group.getgNo() %>">
	<input type="hidden" name="no" value="<%=vo.getNo() %>">
	<table class="table"><tr>
	<td align="center" style="padding-top: 5; padding-bottom: 5px;"><%=vo.getId() %></td>
	<td align="center" style="padding-top: 5; padding-bottom: 5px;"><%=vo.getNickname() %></td>
	<td align="center" style="padding-top: 5; padding-bottom: 5px;"><button type="submit">초대</button></td></tr></table>
	</form>
	</td>
	</tr>
	<%
}
%>

	</table>
<%if(!"embedded".equals(request.getParameter("a"))){%>
<%@include file="../includes/footer.jsp" %>
<% } %>