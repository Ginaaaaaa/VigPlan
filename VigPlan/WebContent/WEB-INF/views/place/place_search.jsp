<%@page import="com.vigplan.vo.KakaoApiVo"%>
<%@page import="com.vigplan.vo.MemberVo"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<script>
function callPage(pageNo) {
	var frm = document.frm;
	var display = parseInt(frm.size.value);
	var newPage = (pageNo - 1) * size + 1;
	
	//alert("new start pos:" + newStart);
	frm.page.value = newPage;
	frm.submit();
}
</script>

		<form name='frm' method='GET'
			action='<%=request.getContextPath()%>/place/search'>
	<div class='aside_menu'>
		<div class='menu_line' style='clear: both;'></div>
		<div class="container">
			<br> <br>
		</form>
			<h3>
				<strong>검색</strong>
			</h3>
			<aside style='float: right;'> <input type='text'
				name='keyword' 
				<% if (request.getParameter("keyword") != null) { %>
				value='<%= request.getParameter("keyword") %>'
				<% } %>
				 placeholder="특수문자는 사용할수 없습니다.">
			<button type='button' onclick="searchKeyword(this.form)">검색</button>
			<input type="hidden" name="size" value="<%= request.getAttribute("nSize") %>">
			<input type="hidden" name="page" value="<%= request.getAttribute("nPage") %>">
			</aside>
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
						List<KakaoApiVo> list = (List<KakaoApiVo>) request.getAttribute("list");
						if (list != null) {
							for (KakaoApiVo vo : list) {
					%>
					<tr>
						<td><a href="#" onclick="insertPlace(<%= vo.getId() %>)"><%=vo.getPlace_name()%></a></td>
						<td><a href="#" onclick="insertPlace(<%= vo.getId() %>)"><%=vo.getPlace_url()%></a></td>
						<td><%=vo.getPhone()%></td>
						<td><%=vo.getAddress_name()%>
						<form id="place_<%= vo.getId() %>">
						

						<input type="hidden" name="place_url" value="<%= vo.getPlace_url() %>">
						<input type="hidden" name="place_name" value="<%= vo.getPlace_name() %>">
						<input type="hidden" name="phone" value="<%= vo.getPhone() %>">
						<input type="hidden" name="address_name" value="<%= vo.getAddress_name() %>">
						<input type="hidden" name="road_address_name" value="<%= vo.getRoad_address_name() %>">
						<input type="hidden" name="x" value="<%= vo.getX() %>">
						<input type="hidden" name="y" value="<%= vo.getY() %>">
						
						</form>
						</td>
						
					</tr>
					
					<%
						}
						}
					%>
				</tbody>
			</table>
			
		</div>
		