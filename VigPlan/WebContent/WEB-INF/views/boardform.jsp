<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@page import="com.vigplan.vo.BoardVo"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<!--  Javascript 넣기 -->
<script language="javascript">
function checkForm(frm) {
	var password = frm.password.value;
	var title = frm.title.value;
	var writer = frm.writer.value;
	var content = frm.content.value;

	if(password.length == 0) {
		alert('비번을 입력하세요.');
		frm.password.focus(); // 커서를 이름 쪽으로 옮겨줌
	} else if (title.length == 0) {
		alert('제목을 입력해 주세요');
		frm.title.focus();
		
	} else if (writer.length == 0) {
		alert('작성자를 입력해 주세요');
		frm.writer.focus();
		
	} else if (content.length == 0) {
		alert('내용을 입력해 주세요');
		frm.content.focus();
	}

	else {
		frm.submit(); // 전송
	}
	
}

</script>
</head>
<body>
<form action="<%= request.getContextPath()/*ServletStudy*/ %>/board"
		method="POST">

		<label for="password">비밀번호</label>
		<input type="text" name="password"><br>
		<label for="title">제목</label>
		<input type="text" name="title"><br>
		<label for="writer">작성자</label>
		<input type="text" name="writer"><br>
		<label for="content">내용</label>
		<input type="text" name="content"><br>

		<input type="button" value="전송" onclick="checkForm(this.form)">
	</form>
</body>
</html>