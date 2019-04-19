<%@page import="com.vigplan.vo.PlaceVo"%>
<%@page import="com.vigplan.vo.MemberVo"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="../includes/header.jsp" %>

<script>
function callPage(pageNo) {
	var frm = document.frm;
	var display = parseInt(frm.display.value);
	var newStart = (pageNo - 1) * display + 1;
	
	//alert("new start pos:" + newStart);
	frm.start.value = newStart;
	frm.submit();
}
</script>

<%
	MemberVo authUser = (MemberVo) session.getAttribute("authUser");
%>
	<div class='aside_menu'>
		<form name='frm' method='GET'
			action='<%=request.getContextPath()%>/place/search'>
			<aside style='float: right;'> <input type='text'
				name='keyword' 
				<% if (request.getParameter("keyword") != null) { %>
				value='<%= request.getParameter("keyword") %>'
				<% } %>
				 placeholder="특수문자는 사용할수 없습니다.">
			<button type='submit'>검색</button>
			<input type="hidden" name="start" value="<%= request.getAttribute("nStart") %>">
			<input type="hidden" name="display" value="<%= request.getAttribute("nDisplay") %>">
			</aside>
		</form>
		<div class='menu_line' style='clear: both;'></div>
		<div class="container">
			<br> <br>
			<h3>
				<strong>검색</strong>
			</h3>
			<br> <br>
			<table class="table">
				<thead>
					<tr>
						<th>이름</th>
						<th>홈페이지</th>
						<th>전화번호</th>
						<th>주소</th>
					</tr>
				</thead>
				<tbody>
					<%
						//	request에서  list 어트리뷰트를 받아와서
						//	있으면(not null) 루프
						List<PlaceVo> list = (List<PlaceVo>) request.getAttribute("list");
						if (list != null) {
							for (PlaceVo vo : list) {
					%>
					<tr>
						<td><%=vo.getTitle()%></td>
						<td><%=vo.getLink()%></td>
						<td><%=vo.getTelephone()%></td>
						<td><%=vo.getAddress()%></td>
					</tr>
					<%
						}
						}
					%>
				</tbody>
			</table>
			<%
			if (request.getParameter("keyword") != null) {
				for (int i = 0; i < 10; i++) {
					%>
					<a href="#" onclick="callPage(<%= i+1 %>)"><%= i+1 %></a>
					<%
				}
			}
			%>
<%@include file="../includes/footer.jsp" %>
