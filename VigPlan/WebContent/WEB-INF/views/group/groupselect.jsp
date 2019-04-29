<%@ page import="com.vigplan.vo.GroupVo" %>
<%@ page import="com.vigplan.vo.MemberVo" %>
<%@ page import="com.vigplan.vo.MVo" %>
<%@ page import="com.vigplan.dao.group.GroupDao" %>
<%@ page import="java.util.*" %>

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
<form name="frmUpdate" action="<%= request.getContextPath() %>/group/update" method="get">
	<input type="hidden" name="gNo" value="<%=group.getgNo() %>">
</form>
	<tr><th> 그룹명 </th><td><%=group.getgName() %> </td></tr>
	<tr><th> 생성일 </th><td><%=group.getgRegdate().substring(0,10) %></td></tr>
	<tr><th> 멤버 목록</th><td>

<%
List<MemberVo> list = (List<MemberVo>)request.getAttribute("list");
for(MemberVo vo: list){	
%>
 
<!-- form id="user_<%= vo.getNo() %>" -->
 <button class="button" 
 	data-toggle="modal"
 	data-target="#exampleModal" 
 	data-no="<%= vo.getNo() %>"
 	data-id="<%= vo.getId() %>"
 	data-nickname="<%= vo.getNickname() %>"
 	data-email="<%= vo.getEmail().substring(0,3) %>********">
<%=vo.getId() %></button>
<!-- input type="hidden" name="no" value="<%= vo.getNo()  %>">
<input type="hidden" name="userId" value="<%=vo.getId() %>">
<input type="hidden" name="nickname" value="<%=vo.getNickname() %>">
<input type="hidden" name="email" value="<%=vo.getEmail() %>">
</form -->



<%
					}

%>

	</td>
	</tr>
	<tr><td> <button onclick="document.frmUpdate.submit();">그룹명 수정</button></td>
	<td><a href="<%= request.getContextPath() %>/group/delete?gNo=<%=group.getgNo()%>">그룹 삭제</a> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	<a href="<%= request.getContextPath() %>/group/search?gNo=<%=group.getgNo()%>">맴버 초대하기</a></td></tr>

</table>


<div class="modal fade" id="exampleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
  <div class="modal-dialog modal-sm" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="exampleModalLabel">회원 정보</h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-body">
      
        아이디 : <span class="user-id"></span> <br>
        닉네임 :  <span class="user-nickname"></span><br>
        이메일 : <span class="user-email"></span>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-secondary" data-dismiss="modal">닫기</button>
      </div>
    </div>
  </div>
</div>

<script>
$("#exampleModal").on("show.bs.modal", function(event) {
	var sender = $(event.relatedTarget);
	var nickname = $(sender).data('nickname');
	var modal = $(this);
	modal.find(".user-id").text(sender.data('id'));
	modal.find(".user-nickname").text(sender.data('nickname'));
	modal.find(".user-email").text(sender.data('email'));
});
</script>
<table class="table">
	<h3>모임 리스트</h3>
	<thead>
		<tr>
			<th>모임 번호</th>
			<th>모임명</th>
			<th>모임날짜</th>
		</tr>
	</thead>
	<tbody>
		<%
			List<MVo> mlist = (List<MVo>) request.getAttribute("mlist");
			for (MVo mvo : mlist) {
		%>
		<tr>
			<td><%=mvo.getmNo()%></td>
			<td>
			<a href="<%=request.getContextPath()%>/moim/select?mNo=<%=mvo.getmNo()%>"><%=mvo.getmTitle()%></a></td>
			<td><%=mvo.getmDate()%></td>
		</tr>
		<%
			}
		%>
	</tbody>
	<form action="<%=request.getContextPath()%>/moim/write">
		<input type="hidden" name="gNo" value=<%=group.getgNo()%>>
		<button type="submit" class="btn btn-primary">모임 만들기</button>
	</form>
</table>
<%@include file="../includes/footer.jsp"%>