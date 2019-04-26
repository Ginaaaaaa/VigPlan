<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<div class="sidebar-fixed position-fixed sidebar-dark bg-secondary">
      <div style="text-align:center">
      <a class="logo-wrapper waves-effect" style="padding-bottom: 15px; padding-top: 20px;">
            <h3 style="text-align:center;"><strong>Vig Plan</strong></h3>
          <img src="img/icon/high-five.png" class="img-fluid" alt="" width="108" height="200">
      </a>
    </div>
    <hr>
    
        <br>
        <div class="round-button">
            <a href="http://example.com"></a>
        </div>
        <br>
        <div style="text-align : center">
        <div class=btn-group>
          
            <a href="<%= request.getContextPath()%>/member/info" class="btn btn-outline-white btn-sm">내 정보</a> &nbsp;
            <a href="<%= request.getContextPath()%>/member/logout" class="btn btn-outline-white btn-sm">로그아웃</a>
            
          </div>
        </div>
        <br>
    
        <br>
        <div style="text-align:left;margin-bottom:200px;">
        <h4>내 그룹</h4>

<ul>
  <li>Coffee</li>
  <li>Tea</li>
  <li>Milk</li>
</ul>
<a href="">+그룹</a>
</div>
<br>

<hr>
<a href="">후기</a>
      </div>
    </div>
  </div>