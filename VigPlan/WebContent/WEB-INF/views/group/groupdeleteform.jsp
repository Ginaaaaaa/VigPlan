<%@ page import="com.vigplan.vo.GroupVo" %>
<%@ page import="com.vigplan.dao.group.GroupDao" %>
<%@ page import="java.util.List" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="../includes/header.jsp" %>
<%
GroupVo group = (GroupVo) request.getAttribute("group");
%>
<script type="text/javascript">
	function check(frm){
		var password = frm.pw.value;
		
		if(password == ""){
			$('#check').html("비밀번호를 적어도 1자 이상 입력해주십시오.").css("color","red");
			return false;
		} else{
			return true;
		}
	}
</script>


		<br> <br>
		<h3><strong>그룹 삭제</strong></h3>
		<br> <br>
	<form action="<%= request.getContextPath() %>/group/delete" method="post">
	<input type="hidden" name="gNo" value="<%=group.getgNo()%>">
	<div>비밀번호 입력 : <input type="password" name="pw"><button type="submit" onclick="return check(this.form)">확인</div>
	<br>
	<div id="check"></div>
	</form>
<%@include file="../includes/footer.jsp" %>