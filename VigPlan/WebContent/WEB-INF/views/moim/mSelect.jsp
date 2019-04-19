<%@ page import="com.vigplan.vo.MVo" %>
<%@ page import="com.vigplan.dao.moim.MDao" %>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type = "text/javascript">     
function cancel() {
    var msg = confirm("모임을 삭제하시겠습니까?");
    if( msg == true ) {
       document.write ("모임이 삭제되었습니다.");
       return true;
    } else {
       window.alert('취소하였습니다.');
       return false;
    }
 }
      </script>
</head>
<body>
<%
MVo moim = (MVo)request.getAttribute("moim");
	%>
	<h1>모임 상세정보</h1>
	<table>
	<tr>
		<td>번호</td>
		<td>모임명</td>
		<td>모임날짜</td>
		<td>모임장소</td>
		<td>모임소개</td>
	</tr>
	<tr>
	<td> <%=moim.getmNo() %></td>
	<td><%=moim.getmTitle() %></a></td>
	<td> <%=moim.getmDate() %></td>
	<td> <%=moim.getmPlace() %></td>
	<td> <%=moim.getmContent() %></td>
	<td> <a href="<%= request.getContextPath() %>/moim/update?mNo=<%=moim.getmNo()%>">수정</a>
	<td> <a href="<%= request.getContextPath() %>/moim/delete?mNo=<%=moim.getmNo()%>" onclick="return cancel()">삭제</a>
	</tr>
	</table>

</body>
</html>