<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
   if(session.getAttribute("ValidMem") == null) {            // ValidMem값에 아무것도 없다면 로그인이 되지 않은 것이므로 login 화면으로 포워드
%>      
   <jsp:forward page="login.jsp" />
<%
   }

   String name = (String)session.getAttribute("name");
   String id = (String)session.getAttribute("id");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

   <h1><%= name%>님 안녕하세요.</h1><br />            <!-- 로그인이 정상적으로 되었다는 메세지 출력 -->
   <form action="logout.jsp method="post">
      <input type="submit" value="로그아웃">      <input type="button" value="정보수정" onclick="javascript:window.location='modify.jsp'">
   </form>

</body>
</html>