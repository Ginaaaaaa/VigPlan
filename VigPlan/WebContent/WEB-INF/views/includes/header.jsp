<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <meta http-equiv="x-ua-compatible" content="ie=edge">
  <title>Material Design Bootstrap</title>
  <!-- Font Awesome -->
  <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.8.1/css/all.css">
  <!-- Bootstrap core CSS -->
  <link href="<%=request.getContextPath() %>/css/bootstrap.min.css" rel="stylesheet">
  <!-- Material Design Bootstrap -->
  <link href="<%=request.getContextPath() %>/css/vigplan.theme.css" rel="stylesheet">
  <!-- Your custom styles (optional) -->
  <link href="<%=request.getContextPath() %>/css/style.css" rel="stylesheet">
  <script src="<%= request.getContextPath() %>/js/jquery-3.3.1.min.js"></script>
  <script src="<%= request.getContextPath() %>/js/popper.min.js"></script>
  <script src="<%= request.getContextPath() %>/js/bootstrap.min.js"></script>
  
  <style>
  

    .map-container{
overflow:hidden;
padding-bottom:56.25%;
position:relative;
height:0;
}
.map-container iframe{
left:0;
top:0;
height:100%;
width:100%;
position:absolute;
}

.picture{
  padding-left:15px;
}

.center{
  display: block;
  margin-left:auto;
  margin-right: auto;

}
  </style>
</head>

<body>

  <!--Main Navigation-->
  <header>

    <!-- Navbar -->

    <!-- Sidebar -->
    <%-- 세션 체크  --%>
	<%@include file="sidebar.jsp" %>
    <!-- Sidebar -->
  </header>

    <!--Main layout-->
    <main class="pt-5 mx-lg-5">
      
      <br>
      
      <div class="container" style="text-align:center">