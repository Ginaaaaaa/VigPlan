<%@page import="com.vigplan.vo.BoardVo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="com.vigplan.vo.BoardVo"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>

<script language="javascript">



	function checkForm(frm) {
		var password = frm.password.value;
		var id = frm.id.value;
		
		if (password.length == 0) {
			alert('비밀번호를 입력하세요.');
			frm.password.focus();
		} else {
			checkPasswordAsync(frm, id, password);
			//frm.submit();
		}
	}
	
	function checkPasswordAsync(frm, id, password) {
		//alert(password);
		$.ajax({
			url: "<%= request.getContextPath() %>/board",
			data: {
				'a': 'checkpw',
				'id': id,
				'password': password
			},
			success: function(data) {
				if (data == "success") {
					frm.submit();
				} else {
					alert("비밀번호 맞지 않음");
					frm.password.focus();
				}
			},
			error: function(request,response,error) {
				alert("Error:" + error)
			}
		});
		
	}
	
</script>

<title>Insert title here</title>
</head>
<body>

	<div class="container">

		<br> <br>
		<br> <br>

		<table class="table">
			<thead>
				<tr>
					<th>제목</th>
					<th>작성자</th>
					<th>내용</th>
					<th>날짜</th>
				</tr>
			</thead>
			<tbody>
			
				<%
					BoardVo item = (BoardVo) request.getAttribute("item");
					
					//object로 받아온 것 바꿔줌
				%>
				<tr>
					<td><%=item.getTitle()%></td>
					<td><%=item.getWriter()%></td>
					<td><%=item.getContent()%></td>
					<td><%=item.getReg_date()%></td>
				</tr>



			</tbody>
		</table>

</body>
</html>