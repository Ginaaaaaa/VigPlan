<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="../includes/header.jsp" %>
<script type="text/javascript">
// function conf() {
//     var msg = confirm("그룹을 만드시겠습니까?");
//     if( msg == true ) {
//        window.alert ("그룹이 생성되었습니다.");
//        return true;
//     } else {
//        window.alert('취소하였습니다.');
//        return false;
//     }
//  }
 
 function checkf(){
	 gform=document.gwriteform;
	 if(gform.gName.value == ""){
		 window.alert("그룹명을 작성해주세요.");
		 return false;
	 } else if(gform.gPw.value == ""){
		 window.alert("그룹 비밀번호를 작성해주세요.");
		 return false;
	 }	else if(gform.gPw.value != gform.gPw1.value){
		 window.alert("비밀번호 확인이 일치하지 않습니다.");
		 return false;
	 }
	 else {
		 var msg = confirm("그룹을 만드시겠습니까?");
	    if(msg) {
	        window.alert ("그룹이 생성되었습니다.");
	        return true;
	     } else {
	        alert('취소하였습니다.');
	        return false;
	     }
	  }
	 }

      </script>
</head>
<body>
		<br> <br>
		<h3><strong>그룹 만들기</strong></h3>
		<br> <br>
<form name="gwriteform" action="<%= request.getContextPath() %>/group/write" method="post" onsubmit="return checkf()">
	<div>그룹명&nbsp;&nbsp;&nbsp;&nbsp;: <input type="text" name="gName"><br>
		 비밀번호 : <input type="password" name="gPw"></div>
		 비밀번호 확인 :<input type="password" name="gPw1"></div>
		 <br>
	<div style="text-align:center">
	<input type="submit" value="그룹 생성">
	<input type="button" value="홈으로" onclick="location.href='<%= request.getContextPath() %>/'">
	</div>
</form>
<%@include file="../includes/footer.jsp" %>
