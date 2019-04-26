<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <script>
     $(document).ready(function() {
	 $("#regist_btn").click(function() { 
			location.assign('<%= request.getContextPath() %>/member');
			</script>
    <div class="sidebar-fixed position-fixed sidebar-dark bg-secondary">
      <div style="text-align:center">
      <a class="logo-wrapper waves-effect" style="padding-bottom: 15px; padding-top: 20px;">
            <h3 style="text-align:center;"><strong>Vig Plan</strong></h3>
          <img src="img/icon/high-five.png" class="img-fluid" alt="" width="120" height="120">
      </a>
      <hr>
    </div>
   <form action="<%= request.getContextPath() %>/member/login" method="post">
    <div class="list-group list-group-flush">

      <div style="padding-right : 40px;">
      <label class="text-white">아이디</label><input type = "text" name="id" value=""class="list-group-item list-group-item-action waves-effect" style="height: 35px">
      <br>
      <label class="text-white">비밀번호</label><input type ="password" name="pw" value="" class="list-group-item list-group-item-action waves-effect" style="height: 35px">
    </div>
        <br>
        <div class=btn-group>
              <button class="btn btn-outline-white btn-md" type="submit">로그인</button> &nbsp;
              <a href="<%= request.getContextPath() %>/member" class="btn btn-outline-white btn-md">회원가입</a></button>
            </div>
      </div>
    </div>
  </div>
  </form>
    