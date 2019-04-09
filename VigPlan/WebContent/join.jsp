<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script language="JavaScript" src="members.js" ></script>		<!-- JavaScript언어를 사용하겠다고 선언 -->
</head>
<body>
	<form action="joinGo.jsp" method="post" name="reg_frm">		<!-- form태그에 name값을 주어 members.js파일에서 사용 -->
		아이디 : <input type="text" name="id" size="20"><br />
		비밀번호 : <input type="password" name="pw" size="20"><br />
		비밀번호 확인 : <input type="password" name="pw_check" size="20"><br />
		닉네임 : <input type="text" name="name" size="20"><br />
		메일 <input type="text" name="eMail" size="20"><br />
		<input type="button" value="회원가입" onclick="infoConfirm()">
			<input type="reset" value="취소" onclick="javascript:window.location='login.jsp'">
	</form>	             					<!-- onclick = 버튼 클릭 시 실행 -->
</body>
</html>