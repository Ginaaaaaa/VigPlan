<%@page import="com.vigplan.vo.PlaceVo"%>
<%@page import="com.vigplan.vo.MemberVo" %>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>

<title>Insert title here</title>
</head>
<%
MemberVo authUser = (MemberVo)session.getAttribute("authUser");%>
<body>
<div class='aside_menu'>
  <form name='frm' method='GET' action='<%= request.getContextPath() %>/place/search'>
    <aside style='float: right;'>
      <input type='text' name='keyword' value='' placeholder="특수문자는 사용할수 없습니다.">
      <button type='submit'>검색</button>    
    </aside> 
  </form>
  <div class='menu_line' style='clear: both;'></div>
  
	<div class="container">
		<br> <br>
		<h3><strong>전체글보기</strong></h3>
		<br> <br>
		<table class="table">
			<thead>
				<tr>
					<th></th>
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
  List<PlaceVo> list = (List)request.getAttribute("list");
  for (PlaceVo vo : list) {
  if (list != null) {
  %>
 
		<tr>
		<td><%=vo.getTitle()%></td>
					<td><a href="<%= request.getContextPath() %>/board?a=show&id=<%=vo.getId()%>"><%=vo.getTitle()%></a></td>
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
	  <% %>
</div>


</body>
</html>