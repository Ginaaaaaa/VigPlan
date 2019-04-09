<%@page import="com.vigplan.dao.MemberDAO"%>
<%@page import="com.vigplan.vo.MemberVO"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%
	request.setCharacterEncoding("EUC-KR");

	String id = request.getParameter("id");			// login.jsp에서 입력한 아이디를  받음
	String pw = request.getParameter("pw");			// login.jsp에서 입력한 비밀번호를  받음

	MemberDAO dao = MemberDAO.getInstance();
	int checkNum = dao.userCheck(id, pw);			// 회원 체크
	if (checkNum == -1) {
%>
<script language="javascript">
	alert("아이디가 존재하지 않습니다.");
	history.go(-1);
</script>
<%
	} else if (checkNum == 0) {
%>
<script language="javascript">
	alert("비밀번호가 틀립니다.");
	history.go(-1);
</script>
<%
	} else if (checkNum == 1) {
		MemberVO vo = vo.getMemeber(id);

		if (vo == null) {
%>
<script language="javascript">
	alert("존재하지 않는 회원 입니다.");
	history.go(-1);
</script>
<%
	} else {
			String name = vo.getName();
			session.setAttribute("id", id);
			session.setAttribute("name", name);
			session.setAttribute("ValidMem", "yes");		// 정상적으로 로그인 되었다면 ValidMem에 yes값을 저장
			response.sendRedirect("main.jsp");				// main 화면으로 리다이렉트
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