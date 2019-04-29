<%@page import="com.vigplan.vo.KakaoApiVo" %>
<%@page import="com.vigplan.vo.MemberVo" %>
<%@page import="com.vigplan.vo.PlaceVo" %>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="com.vigplan.vo.MVo"%>
<%@include file="../includes/header.jsp" %>
<%
MVo moim = (MVo)request.getAttribute("moim");
	%>		
	<div class="container">
		<br> <br>
		<h2>장소 등록</h2>
		<br>
		<form id="registerForm" class="form-inline"
			action="<%=request.getContextPath()%>/place"
			method="POST">
			<input type="hidden" name="a" value="insert">
			<input type="hidden" name="mNo" value="<%=moim.getmNo()%>">
			<div class="form-group">
				<label for="title" class="mb-2 mr-sm-2">제목</label> <input
					type="text" class="form-control mb-2 mr-sm-2" name="title">
			</div>
			<br> <br>

			<div class="form-group">
				<label for="link" class="mb-2 mr-sm-2">링크</label> <input
					type="text" class="form-control mb-2 mr-sm-2" name="link">
			</div>

			<div class="form-group">
				<label for="description" class="mb-2 mr-sm-2">설명</label> <input
					type="text" class="form-control mb-2 mr-sm-2" name="description">
			</div>

			<div class="form-group">
				<label for="telephone" class="mb-2 mr-sm-2">전화</label> <input
					type="text" class="form-control mb-2 mr-sm-2" name="telephone">
			</div>
			
			<div class="form-group">
				<label for="address" class="mb-2 mr-sm-2">주소</label> <input
					type="text" class="form-control mb-2 mr-sm-2" name="address">
			</div>
			
			<div class="form-group">
				<label for="roadAddress" class="mb-2 mr-sm-2">도로명 주소</label> <input
					type="text" class="form-control mb-2 mr-sm-2" name="roadAddress">
			</div>
			
			<div class="form-group">
				<label for="mapx" class="mb-2 mr-sm-2">x좌표</label> <input
					type="text" class="form-control mb-2 mr-sm-2" name="mapx">
			</div>
			
			<div class="form-group">
				<label for="mapy" class="mb-2 mr-sm-2">y좌표</label> <input
					type="text" class="form-control mb-2 mr-sm-2" name="mapy">
			</div>


			<!--     <div class="form-group">
    <label for="content" class="mb-2 mr-sm-2">내용</label>
    <input type="content" class="form-control mb-2 mr-sm-2" name="content">
    </div> -->

			<button type="submit" class="btn btn-primary mb-2">완료</button>
		</form>
	</div>

	<div id="searchList">
	</div>

	<script>
	function insertPlace(placeId) {
		var sourceForm = document.getElementById("place_" + placeId);
		var targetForm = document.getElementById("registerForm");
		
		//console.log(sourceForm.place_name.value);
		//console.log(targetForm);
		
		targetForm.title.value = sourceForm.place_name.value;
		targetForm.link.value = sourceForm.place_url.value;
	}
	function searchKeyword(frm) {
		
		$.ajax({
			url: "<%= request.getContextPath() %>/place/search",
			data: {
				"keyword": frm.keyword.value
			}, 
			success: function(data) {
				$("#searchList").html(data);
			}, 
			error: function(request,response,error) {
				console.err(error);
			}
			
		});
		
	}
	
	$(document).ready(function() {
		$("#searchList").load("<%= request.getContextPath() %>/place/search");


	});
	</script>
	

<%@include file="../includes/footer.jsp" %>






