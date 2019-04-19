<%@page import="com.vigplan.vo.BoardVo"%>
<%@page import="com.vigplan.vo.MemberVo" %>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="../includes/header.jsp" %>
	<%
MemberVo authUser = (MemberVo)session.getAttribute("authUser");%>
		<br> <br>
		<h3><strong>전체글보기</strong></h3>
		<br> <br>
		<table class="table">
			<thead>
				<tr>
					<th></th>
					<th>제목</th>
					<th>작성자</th>
					<th>조회수</th>
					<th>작성일</th>
				</tr>
			</thead>
			<tbody>
				<%
					List<BoardVo> list = (List<BoardVo>) request.getAttribute("list");
					for (BoardVo vo : list) {
				%>
				<tr>
					<td><%=vo.getId()%></td>
					<td><a href="<%= request.getContextPath() %>/board?a=show&id=<%=vo.getId()%>"><%=vo.getTitle()%></a></td>
					<td><%=vo.getWriter()%></td>
					<td><%=vo.getView_cnt()%></td>
					<td><%=vo.getReg_date()%></td>
				</tr>

				<%
					}
				%>
			</tbody>
		</table>
	
		<!-- button type="button" class="btn btn-secondary btn-sm" onclick="location.href='board?a=form'">글쓰기</button -->
		<a href="<%=request.getContextPath()%>/board?a=form"
			class="btn btn-secondary btn-sm">글쓰기</a>

<%@include file="../includes/footer.jsp"%>