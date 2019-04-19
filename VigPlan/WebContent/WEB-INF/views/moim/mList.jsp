<%@ page import="com.vigplan.vo.MVo" %>
<%@ page import="com.vigplan.dao.moim.MDao" %>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="../includes/header.jsp" %>
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

<a class="button" href="./moim/write" >모임 만들기</a>


<table class="table">
      <tr>
            <td>번호</td>
            <td>모임명</td>
            <td>날짜</td>
            <td>소개</td>
      </tr>
      <tr>
      
<%
List<MVo> list = (List<MVo>)request.getAttribute("list");
 for(MVo vo: list){
	%>
	</tr>
	<td> <%=vo.getmNo() %></td>
	<td><a href="./moim/select?mNo=<%=vo.getmNo() %>"><%=vo.getmTitle() %></a></td>
	<td> <%=vo.getmDate() %></td>
	<td> <%=vo.getmContent() %></td>
	<td> <a href="./moim/update?mNo=<%=vo.getmNo()%>">수정</a>
	<td> <a href="./moim/delete?mNo=<%=vo.getmNo()%>" onclick="return cancel()">삭제</a>
	<tr>
	<%
}
%>
</tr>
</table>
<%@include file="../includes/footer.jsp" %>