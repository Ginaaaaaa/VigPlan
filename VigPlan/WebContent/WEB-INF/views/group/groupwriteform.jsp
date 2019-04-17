<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
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
	 if(gform.gName.value == "" || gform.gPw.value == ""){
		 window.alert("필수 입력란이 비었습니다. 확인해주세요.");
		 return false;
	 } else {
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
<form name="gwriteform" action="<%= request.getContextPath() %>/group/write" method="post" onsubmit="return <%= request.getContextPath() %>/group">
	<div>그룹명&nbsp;&nbsp;&nbsp;&nbsp;: <input type="text" name="gName"></div>
	<div>비밀번호 : <input type="password" name="gPw"></div>
	<input type="submit" value="그룹 생성" onclick="return checkf()">
	<input type="button" value="목록보기" onclick="location.href='<%= request.getContextPath() %>/group'">
</form>
</body>
</html>