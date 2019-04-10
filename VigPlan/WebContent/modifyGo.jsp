<%@page import="com.vigplan.dao.MemberDAO" %>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<% request.setCharacterEncoding("UTF-8");%>

<jsp:useBean id="vo" class="com.vigplan.vo.MemberVO" scope="page" />
<jsp:setProperty name="vo" property="*" />

<%
   String id = (String)session.getAttribute("id");
   vo.setId(id);
   
   MemberDao dao = MemberDAO.getInstance();
   int ri = dao.updateMember(vo);               // updateMember를 이용하여 users 테이블 안의 데이터들을 update 시켜줌
   
   if(ri == 1) {
%>      
   <script language="javascript">
      alert("정보수정 되었습니다.");
      document.location.href="main.jsp";
   </script>   
<%    
   } else {
%>
   <script language="javascript">
      alert("정보수정 실패");
      history.go(-1);
   </script>
<%
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