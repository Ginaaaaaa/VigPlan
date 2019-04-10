<%@page import="com.vigplan.dao.MemberDAO" %>
<%@page import="com.vigplan.vo.MemberVO" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
   String id = (String)session.getAttribute("id");            // 세션에 저장되어있는 id를 dao안에있는 getMember메소드에 넘겨 해당id 값들을 vao에 저장
   MemberDAO dao = MemberDAO.getInstance();
   MemberVO vo = dao.getMember(id);
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script> language="JavaScript" src="members.js" ></script>
</head>
<body>

   <form action="modifyGo.jsp" method="post" name="reg_frm">
      아이디 : <%= vo.getId()%><br />
      비밀번호 : <input type="password" name="pw" size="20"><br />
      비밀번호 확인 : <input type="password" name="pw_ckeck" size="20"><br />
      닉네임 : <%= vo.getName()%><br />
      메일 : <input type="text" name="eMail" size="20" value="<%= vo.geteMail() %>"><br />
      <input type="button" value="수정" onclick="updateInfoConfirm()">      <input type="reset" value="취소" onclick="javascript:window.location='login.jsp'">
         </form>      <!-- 수정 버튼을 누르면 member.js안의 updateInfoConfirm메소드가 실행되어 비밀번호 확인 -->

</body>
</html>