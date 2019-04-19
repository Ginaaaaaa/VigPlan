<%@page import="com.vigplan.vo.BoardVo"%>
<%@page import="com.vigplan.vo.MemberVo" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="com.vigplan.vo.BoardVo"%>
<%@include file="../includes/header.jsp" %>

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

<% MemberVo authUser = (MemberVo) session.getAttribute("authUser"); %>
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
		<%
				Long memberNo = item.getMemberNo();
				Long testMemberNo = authUser.getNo();
				
				if(memberNo.equals(testMemberNo)) {%> 
					<button type="button" class="btn btn-secondary btn-sm"
			data-toggle="modal" data-target="#myModal1">수정</button>
		<%-- 			<a href="<%=request.getContextPath()%>/board?a=delete&id=<%=item.getId()%>"
				class="btn btn-secondary btn-sm" data-toggle="modal"
				data-target="#myModal">삭제</a> --%>

		<button type="button" class="btn btn-secondary btn-sm"
			data-toggle="modal" data-target="#myModal">삭제</button>

		<a href="<%=request.getContextPath()%>/board"
			class="btn btn-secondary btn-sm">리스트</a>







		<div class="modal" id="myModal1">
			<div class="modal-dialog">
				<div class="modal-content">

					<!-- Modal Header -->
					<div class="modal-header">
						<!--  <h4 class="modal-title">Modal Heading</h4> -->
						<button type="button" class="close" data-dismiss="modal">&times;</button>
					</div>
					<form action="<%=request.getContextPath()%>/board" method="POST">
					<input type="hidden" name="a" value="edit">
					<input type="hidden" name="id" value="<%=item.getId()%>">
						<div class="modal-body">
							게시글을 수정하시겠습니까?<br> <br> 비밀번호를 입력해주세요.<br> 
							<label for="password">비밀번호:</label> 
							<input type="password" name="password">
						</div>

						<!-- Modal footer -->
						<div class="modal-footer">


							<input type="button" class="btn btn-primary" value="YES" onclick="checkForm(this.form)">
							<button type="button" class="btn btn-danger" data-dismiss="modal">NO</button>
						
						</div>
					</form>

					<!-- Modal body -->
	<%-- 				<div class="modal-body">게시글을 수정하시겠습니까?</div><br><br>
					<input type=password>
					<!-- 패스워드 입력 폼 -->
					<!-- Modal footer -->
					<div class="modal-footer">
						<a
							href="<%=request.getContextPath()%>/board?a=edit&id=<%=item.getId()%>"
							button type="button" class="btn btn-primary">YES</a>
						<button type="button" class="btn btn-danger" data-dismiss="modal">NO</button>
					</div> --%>

				</div>
			</div>
		</div>



		<div class="modal" id="myModal">

			<div class="modal-dialog">
				<div class="modal-content">
					<!-- Modal Header -->
					<div class="modal-header">
						<!--  <h4 class="modal-title">Modal Heading</h4> -->
						<button type="button" class="close" data-dismiss="modal">&times;</button>
					</div>

					<!-- Modal body -->


					<form action="<%=request.getContextPath()%>/board" method="POST">
					<input type="hidden" name="a" value="delete">
					<input type="hidden" name="id" value="<%=item.getId()%>">
						<div class="modal-body">
							게시글을 삭제하시겠습니까?<br> <br> 비밀번호를 입력해주세요.<br> 
							<label for="password">비밀번호:</label> 
							<input type="password" name="password">
						</div>

						<!-- Modal footer -->
						<div class="modal-footer">


							<input type="button" class="btn btn-primary" value="YES" onclick="checkForm(this.form)">
							<button type="button" class="btn btn-danger" data-dismiss="modal">NO</button>
						
						</div>
					</form>
				</div>
			</div>

		</div>
					
				<% } else { %>
				
				<a href="<%=request.getContextPath()%>/board"
			class="btn btn-secondary btn-sm">리스트</a>
					
				<%} %>
				
<%@ include file="../includes/footer.jsp" %>