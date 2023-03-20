<%@page import="java.text.DecimalFormat"%>
<%@page import="com.itwillbs.menu.db.MenuDTO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>

<html>
<head>
<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- Bootstrap CSS -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">

<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="description" content="Resto">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

<!-- External CSS -->
<link rel="stylesheet" href="./vendor/bootstrap/bootstrap.min.css">
<link rel="stylesheet" href="./vendor/select2/select2.min.css">
<link rel="stylesheet" href="./vendor/owlcarousel/owl.carousel.min.css">
<link rel="stylesheet" href="https://cdn.rawgit.com/noelboss/featherlight/1.7.13/release/featherlight.min.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/tempusdominus-bootstrap-4/5.0.1/css/tempusdominus-bootstrap-4.min.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.8.1/css/brands.css">

<!-- Fonts -->
<link href="https://fonts.googleapis.com/css2?family=Gowun+Dodum&display=swap" rel="stylesheet">
<link rel="stylesheet" href="https://cdn.linearicons.com/free/1.0.0/icon-font.min.css">
<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.8.1/css/all.css" integrity="sha384-50oBUHEmvpQ+1lW4y57PTFmhCaXp0ML5d60M1M7uH2+nqUivzIebhndOJK28anvf" crossorigin="anonymous">

<!-- CSS -->
<link rel="stylesheet" href="./css/style.min.css">
<link rel="stylesheet" href="./css/style.css">

<!-- Modernizr JS for IE8 support of HTML5 elements and media queries -->
<script src="https://cdnjs.cloudflare.com/ajax/libs/modernizr/2.8.3/modernizr.js"></script>
<title>COFFEE</title>
</head>
<jsp:include page="../inc/headerMenu.jsp"></jsp:include>
<body data-spy="scroll" data-target="#navbar">
	<div id="canvas-overlay"></div>
	<div class="boxed-page">
		<section id="gtco-menu" class="section-padding">
			<div class="container">
				<div class="section-content">
					<div class="row mb-5">
						<div class="col-md-12">
							<div class="heading-section text-center">
								<h2>COFFEE</h2>
							</div>
						</div>
           	 		</div>		
						<div class="row">
								<%
								String cus_id = (String) session.getAttribute("cus_id");
								//로그인이 안된 상태면 장바구니 담기 불가----------------------------------------------------
								DecimalFormat df = new DecimalFormat("###,###");
								
								List<MenuDTO> menuList = (List<MenuDTO>) request.getAttribute("menuList");

								for (int i = 0; i < menuList.size(); i++) {
									MenuDTO dto = menuList.get(i);
								%>
								
								<div class="col-lg-4 menu-wrap">
									<div class="heading-menu">
										<form action="./CartAddPro.ca" method="post" class="menu">
											<input type="hidden" id="menu_num" name="menu_num" value="<%=dto.getMenu_num()%>"> 
											<input type="hidden" id="menu_category" name="menu_category" value="<%=dto.getMenu_category()%>"> 
											<img src="./img/<%=dto.getMenu_img()%>" alt="MenuImg" width="225" style="border-radius: 7px;">
											<h4 class="menu-title"><%=dto.getMenu_name()%></h4>
											<p>
												<%=dto.getMenu_detail()%>
											</p>
											<b style="font-size: 17px"><%=df.format(dto.getMenu_price())%>원</b> <br>
											<div class ="menu-num">
											수량:  <input type="number" class="number" step="1" min="0" id="crt_num" name="crt_count" required value="0" style="text-align: left; width: 40px; height: 17px;"><br>
											</div>
											<%
											if (cus_id == null) {
											%>
											<input type="button" class="btn btn-primary" value="로그인하고 담기" onclick="location.href='./CustomerLoginForm.cu'">
											<%
											} else {
											%>
												<input type="submit" class="btn btn-primary" value="장바구니">
											<%
											}
											%>
										</form>
								  	</div>
								</div>
								<%
								}
								%>
					</div>	
				</div>
			</div>
		</section>
	</div>
</body>
<!-- Option 1: Bootstrap Bundle with Popper -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>

<!-- footer -->
<jsp:include page="../inc/footerMain.jsp"></jsp:include>
<!-- External JS -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/moment.js/2.22.2/moment.min.js"></script>
<script src="./vendor/bootstrap/popper.min.js"></script>
<script src="./vendor/bootstrap/bootstrap.min.js"></script>
<script src="./vendor/select2/select2.min.js "></script>
<script src="./vendor/owlcarousel/owl.carousel.min.js"></script>
<script src="https://cdn.rawgit.com/noelboss/featherlight/1.7.13/release/featherlight.min.js"></script>
<script src="./vendor/stellar/jquery.stellar.js" type="text/javascript" charset="utf-8"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/tempusdominus-bootstrap-4/5.0.1/js/tempusdominus-bootstrap-4.min.js"></script>
<!-- Option 1: Bootstrap Bundle with Popper -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>

<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.10.2/dist/umd/popper.min.js" integrity="sha384-7+zCNj/IqJ95wo16oMtfsKbZ9ccEh31eOz1HGyDuCQ6wgnyJNSYdrPa03rtR1zdB" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.min.js" integrity="sha384-QJHtvGhmr9XOIpI6YVutG+2QOK9T+ZnN4kzFN1RtK3zEFEIsxhlmWl5/YESvpZ13" crossorigin="anonymous"></script>
<!-- Main JS -->
<script src="./js/app.min.js "></script>
</html>