<%@page import="java.sql.Timestamp"%>
<%@page import="com.vigplan.dao.*" %>
<%@page import="com.vigplan.vo.*" %>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% request.setCharacterEncoding("UTF-8");%>
<jsp:useBean id="vo" class="com.vigplan.vo.MemberVO"/>		<!-- 자바빈 사용 액션태그 -->
<jsp:setProperty name="vo" property="*" />
    
<%
	vo.setrDate(new Timestamp(System.currentTimeMillis()));		// vo에 rdate 삽입, rdate는 서버에서 생성되는 시간이기 떄문
	MemberDAO dao = MemberDAO.getInstence();					// 존재하는 id인지 확인
	if(dao.confirmId(vo.getId()) == MemberDAO.MEMBER_EXISTENT) {	// 싱글톤 패턴, 특징은 클래스로부터 바로 객체를 getInstence해서 가져올 수 있음.
%>
	<script language="javascript">
		alert("아이디가 이미 존재 합니다.");
		history.back();
	</script>		
<%
	} else {
		int ri = dao.insertMember(vo);					// 정상적으로 회원가입이 되었다면 세션에 ID 저장
		if(ri == MemberDAO.MEMBER_JOIN_SUCCESS) {
			session.setAttribute("id", vo.getID());
%>
	<script language="javascript">
		alert("회원가입을 축하 합니다.");
		document.location.href="login.jsp";
	</script>
<%
		} else {
%>
	<script language="javascript">
		alert("회원가입에 실패했습니다.");
		document.location.href="login.jsp";
	</script>
<%
		}
	}
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

</body>
</html>