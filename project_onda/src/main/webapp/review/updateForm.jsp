<%@page import="com.itwillbs.review.db.ReviewDAO"%>
<%@page import="com.itwillbs.review.db.ReviewDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
 	<!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <script src="https://cdn.tutorialjinni.com/jquery/3.4.1/jquery.min.js"></script>
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
    <link rel="stylesheet" href="./css/review.css">

    <!-- Modernizr JS for IE8 support of HTML5 elements and media queries -->
    <script src="https://cdnjs.cloudflare.com/ajax/libs/modernizr/2.8.3/modernizr.js"></script>
	<title>REVIEW</title>
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
						<h2>REVIEW</h2>
					</div>
					<div class="row mt-5">
					<%
					ReviewDTO dto = (ReviewDTO) request.getAttribute("dto");
					String menu = (String)request.getAttribute("menu");
					%>
					<script type="text/javascript">
					$(document).ready(function() {
					
				        $('input:radio[name="star"][value="<%=dto.getRv_star() %>"]').prop('checked', true);
					
					});
					</script>
					<form action="./ReviewUpdatePro.rv" method="post" name="review" id="review">
						<input type="hidden" name="num" value=<%=dto.getRv_num() %>>
						<table class="table">
							<tr>
								<th>작성자</th>
								<td><input type="text" name="name" value="<%=dto.getCus_id()%>" readonly></td>
							</tr>
							<tr>
								<th>글제목</th>
								<td><input type="text" name="rv_title" value="<%=dto.getRv_title()%>"></td>
							</tr>
							<tr>
								<th>메뉴</th>
								<td><input type="text" name="menu" value="<%=menu %>" readonly></td>
							</tr>
							<tr>
								<th>별점</th>
								<td><fieldset>
								<input type="radio" name="star" value="5" id="rate1"><label
									for="rate1">★</label>
								<input type="radio" name="star" value="4" id="rate2"><label
									for="rate2">★</label>
								<input type="radio" name="star" value="3" id="rate3"><label
									for="rate3">★</label>
								<input type="radio" name="star" value="2" id="rate4"><label
									for="rate4">★</label>
								<input type="radio" name="star" value="1" id="rate5"><label
									for="rate5">★</label>
								</fieldset></td>
							</tr>
							<tr>
								<th>글내용</th>
								<td><textarea name="rv_content" rows="10" cols="100"><%=dto.getRv_content() %></textarea></td>
							</tr>
							
						</table>
						<div class="text-right">
							<input type="submit" value="글수정" class="btn btn-primary btn-shadow btn-lg">
						</div>	
					</form>
					</div>
      			</div>
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
					