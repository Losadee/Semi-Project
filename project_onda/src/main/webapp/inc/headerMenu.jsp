<div class="boxed-page">
 <nav id="navbar-header" class="navbar navbar-expand-lg">
    <div class="container">
      <a class="navbar-brand navbar-brand-center d-flex align-items-center only-desktop" href="./MainPage.cu">
          <img src="./img/logo.png" alt="">
      </a>
        <div class="collapse navbar-collapse justify-content-between" id="navbarSupportedContent">
            <ul class="navbar-nav d-flex justify-content-between">
                <li class="nav-item only-desktop">
                </li>
                <div class="d-flex flex-lg-row flex-column">
                    <li class="nav-item active">
                        <a class="nav-link" href="./About.cu">ABOUT</a>
                    </li>
                    <li class="nav-item dropdown">
                        <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                        SERVICE
                        </a>
                        <div class="dropdown-menu" aria-labelledby="navbarDropdown">
                        <a class="dropdown-item" href="./NotiList.no">NOTICE</a>
                        <a class="dropdown-item" href="./ReviewList.rv">REVIEW</a>
                        <a class="dropdown-item" href="./ReplyList.bo">Q&A</a>
                        </div>
                    </li>
                    <li class="nav-item dropdown">
                        <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                        MENU
                        </a>
                        <div class="dropdown-menu" aria-labelledby="navbarDropdown">
                        <a class="dropdown-item" href="./CoffeeList.mn?menu_category=coffee">COFFEE</a>
                        <a class="dropdown-item" href="./VeberageList.mn?menu_category=veberage">VEBERAGE</a>
                        <a class="dropdown-item" href="./FoodList.mn?menu_category=food">FOOD</a>
                        </div>
                    </li>
                    <li class="nav-item dropdown">
                        <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                        RESERVATION
                        </a>
                        <div class="dropdown-menu" aria-labelledby="navbarDropdown">
                        <a class="dropdown-item" href="./reservationInfo.re">INFO</a>
                        <a class="dropdown-item" href="./reservationForm.re">RESERVATION</a>
                        </div>
                    </li>
                </div>
            </ul>
            
            <%
			 String cus_id=(String)session.getAttribute("cus_id");
			 if(cus_id == null) { // 세션값이 없을 경우 보여질 메뉴
			 %>
		    <ul class="navbar-nav d-flex justify-content-between">
                <div class="d-flex flex-lg-row flex-column">
                    <li class="nav-item">
                        <a class="nav-link" href="./CustomerLoginForm.cu">MEMBERSHIP</a>
                    </li>
                </div>
            </ul>
			<%
			 } else if(cus_id.equals("admin")) { // 세션값이 있고 admin일 경우 보여질 메뉴
			 %>
			 <ul class="navbar-nav d-flex justify-content-between">
                <div class="d-flex flex-lg-row flex-column">
                	<li class="nav-item">
                        <a class="nav-link" href="./CustomerAdminpage.cu">ADMIN</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="./CustomerLogout.cu">LOGOUT</a>
                    </li>
                </div>
            </ul>
			<%
			 } else { // 세션값이 있고 일반 회원일 경우 보여질 메뉴
			 %>
			 <ul class="navbar-nav d-flex justify-content-between">
                <div class="d-flex flex-lg-row flex-column">
                	<li class="nav-item">
                        <a class="nav-link" href="./CustomerMypage.cu">MY</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="./CustomerLogout.cu">LOGOUT</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="./CartList.ca">CART</a>
                    </li>
                </div>
            </ul>
			<%	 
			 }
			 %>
        </div>
    </div>
 </nav>
</div> 