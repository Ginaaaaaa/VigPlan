<%@ page import="com.vigplan.vo.GroupVo" %>
<%@ page import="com.vigplan.vo.MVo" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="../includes/header.jsp" %>

<script type="text/javascript" src="<%= request.getContextPath() %>/js/moment-with-locales.js"></script>
<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/tempusdominus-bootstrap-4/5.0.1/js/tempusdominus-bootstrap-4.min.js"></script>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/tempusdominus-bootstrap-4/5.0.1/css/tempusdominus-bootstrap-4.min.css" />

        <script type="text/javascript">
        
        function check(frm){
        	var title = frm.mTitle.value;
        	var date = frm.mDate.value;
        	if(title == ""){
        		window.alert("모임명을 작성해주세요.");
       		 return false;
        	} else if(date == ""){
        		window.alert("모임 날짜를 작성해주세요.");
        		return false;
        	} else{
        		return true;
        	}
        }

        
            $(function () {
                $('#datetimepicker2').datetimepicker({
                    format: 'LLLL',
                    sideBySide: true,
                    minDate: new Date(),
                    locale: 'ko'                    
                });
            });
        </script>

		<br><br>
		<h3><strong>모임 만들기</strong></h3>
		<br><br>
<%
GroupVo group = (GroupVo) request.getAttribute("group");
%>
<form action="<%= request.getContextPath() %>/moim/write" method="post">
<table class="table">
<input type="hidden" name="gNo" value="<%=group.getgNo()%>">
<tr><td>모임명</td><td><input class="form-control" type="text" name="mTitle"></td></tr>
<tr><td>날짜</td><td><div class="input-group date" id="datetimepicker2" data-target-input="nearest">
                    <input type="text" name="mDate" id="datetimepicker2" class="form-control datetimepicker-input" data-target="#datetimepicker2"/>
                    	<div class="input-group-append" data-target="#datetimepicker2" data-toggle="datetimepicker">
                    		<div class="input-group-text"><i class="fa fa-calendar"></i></div>
                    	</div>
                	</div>
             	</td>
</tr>
<tr><td>소개</td><td><input class="form-control" type="text" name="mContent"></td></tr>
<tr><td><input type="submit" value="모임 생성" onclick="return check(this.form)">
<input type="reset" value="다시작성">
<input type="button" value="목록보기" onclick="location.href='<%= request.getContextPath() %>/group/select?gNo=<%=group.getgNo()%>'"></td></tr>
</table>
</form>

<%@include file="../includes/footer.jsp" %>