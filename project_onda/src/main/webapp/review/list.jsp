<%@page import="java.util.Map"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="com.itwillbs.review.db.ReviewDTO"%>
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
					SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
					
					List<Map<String, Object>> reviewList 
									= (List<Map<String, Object>>)request.getAttribute("reviewList");
					int startPage 	= (Integer)request.getAttribute("startPage");
					int pageBlock 	= (Integer)request.getAttribute("pageBlock");
					int currentPage = (Integer)request.getAttribute("currentPage");
					int endPage 	= (Integer)request.getAttribute("endPage");
					int pageCount 	= (Integer)request.getAttribute("pageCount");
					int count 		= (Integer)request.getAttribute("count");
					%>
	
					<table class="table table-hover">
						<thead>
						<tr>
							<th scope="col">글번호</th>
							<th scope="col">작성자</th>
							<th scope="col">글제목</th>
							<th scope="col">메뉴</th>
							<th scope="col">별점</th>
							<th scope="col">등록일</th>
							<th scope="col">조회수</th>
						</tr>
						</thead>
					<%
					for (int i = 0; i < reviewList.size(); i++) {
						ReviewDTO dto = (ReviewDTO)reviewList.get(i).get("dto");
						String menu = (String)reviewList.get(i).get("menu");
					%>
					<tr>
						<td><%=dto.getRv_num() %></td>
						<td><%=dto.getCus_id().replaceAll("(?!.{4}).", "*") %></td>
						<td><a href="./ReviewContent.rv?num=<%=dto.getRv_num() %>"><%=dto.getRv_title() %></a></td>
						<td><%=menu %></td>
						<td><%
							for(int j = 0; j < dto.getRv_star(); j++) {
							%>
							<img src="./img/starImg.png" alt="Star Image" width=20px height=20px>
							<%
							}
							%>
						</td>
						<td><%=dateFormat.format(dto.getRv_date()) %></td>
						<td><%=dto.getRv_view() %></td>
					</tr>
					<%
					}
					%>
					</table>
					
					<!--  페이징 처리 -->
					<%
					String cus_id = (String)session.getAttribute("cus_id");
					if(cus_id != null) {
						%>
						<div class="col-md-10 mb-2 text-left">
							<input type="button" value="글쓰기" class="btn btn-primary btn-shadow btn-lg" onclick="location.href='./paymentList.pa'">
                   		</div>
                   	<%	
					}	
					%>
						
					<nav aria-label="Page navigation example">
						<ul class="pagination justify-content-center">
					    	
					    	<%
							// 10페이지 이전 
							if(startPage > pageBlock){
								%>
					     	 <li class="page-item"><a class="page-link" href="./ReviewList.rv?pageNum=<%=startPage-pageBlock%>">Prev</a></li>
					     	 <%	
							}
					    	%>
					    	
					    	<%
					    	for(int i=startPage;i<=endPage;i++){
								%>
								<li class="page-item"><a class="page-link" href="./ReviewList.rv?pageNum=<%=i%>"><%=i %></a></li>
								<%
							}
					    	%>
					    	
					      <%
					       if(endPage < pageCount){
							%>
					       <li class="page-item"><a class="page-link" href="./ReviewList.rv?pageNum=<%=startPage+pageBlock%>">Next</a></li>
					      <%
							}
							%>
					 	</ul>
					</nav>
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