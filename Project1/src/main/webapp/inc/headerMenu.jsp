<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<header>
    <!-- 헤더 전체 영역 -->
  <div class="header_area">
   <nav class="navbar">
      <!-- 로고 영역 시작 -->
      <div class="logo_area"> <!-- 로고이미지 누르면 메인페이지 이동 -->
        <a href="./MainPage.cu" >CAFE ONDA</a>
      </div>
      <!-- 로고 영역 끝 -->
      
      <!-- 상단 메뉴영역 시작 -->
      <div class="menu_area">
          <ul class="menu_area_ul">
              <li><a href="">ABOUT</a></li>
              <li><a href="">NOTICE</a></li>
              <li><a href="">MENU</a></li>
              <li><a href="">RESERVATION</a></li>
              <li><a href="">OTHERS</a></li>
          </ul>
      </div>
      <!-- 상단 메뉴영역 끝 -->
      
      <!-- 로그인 영역 시작 -->
      <%
      String id=(String)session.getAttribute("id");
      if(id == null) { // 세션값이 없을 경우 보여질 메뉴
    	  %><div class="login_area">
          <ul class="login_area_ul">
            <li><a href="./CustomerLoginForm.cu">MemberShip</a></li>
            <li><a href="">CART</a></li>
          </ul>
          </div>
          <%
      } else { // 세션값이 있을 경우 보여질 메뉴
    	  %><div class="login_area">
          <ul class="login_area_ul">
            <li><a href="./CustomerMypage.cu">MY</a></li>
            <li><a href="">CART</a></li>
            <li><a href="./CustomerLogout.cu">LOGOUT</a></li>
          </ul>
          </div>
          <%
      }
      %>
      
      <!-- 로그인 영역 끝 -->
   </nav>
  </div>
</header>  