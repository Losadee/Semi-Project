<%@page import="java.text.SimpleDateFormat"%>
<%@page import="com.itwillbs.board.db.BoardDTO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
    
    <meta name='viewport' content='width=device-width, initial-scale=1'>
	<script src='https://kit.fontawesome.com/a076d05399.js' crossorigin='anonymous'></script>
	<!--Get your own code at fontawesome.com-->
	
	<title>QNA</title>
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
						<h2>QNA</h2>
					</div>
					<div class="row mt-5">
					<%
					List<BoardDTO> reboardList
					=(List<BoardDTO>)request.getAttribute("reboardList");
					int startPage=(Integer)request.getAttribute("startPage");
					int pageBlock=(Integer)request.getAttribute("pageBlock");
					int currentPage=(Integer)request.getAttribute("currentPage");
					int endPage=(Integer)request.getAttribute("endPage");
					int pageCount=(Integer)request.getAttribute("pageCount");
					int count 		= (Integer)request.getAttribute("count");
					
					%>
					<table class="table table-hover">
						<thead>
						    <tr>
						      <th scope="col">글번호</th>
						      <th scope="col">작성자</th>
						      <th scope="col">글제목</th>
						      <th scope="col">등록일</th>
						      <th scope="col">조회수</th>
						    </tr>
					  </thead>
				    <%
					 // 날짜 => 모양 문자열 변경
					SimpleDateFormat dateFormat=new SimpleDateFormat("yyyy.MM.dd");
				 
				    for(int i=0; i < reboardList.size(); i++){
				    	BoardDTO dto = reboardList.get(i);
				   	 %>
						<tr>
					    <td><%=dto.getQna_num() %></td>
				   		
				   		<%
				   		String cus_id = dto.getCus_id();
				   		if(cus_id.equals("admin")){
				   		%>
				   			<td><%=dto.getCus_id() %></td>
				   		<%
				   		} else {
				   		%>
				   			<td><%=dto.getCus_id().replaceAll("(?!.{4}).", "*")%></td>
				   		<%
				   		}
				   		%>
				   		
				   		<td><a href="./BoardContent.bo?num=<%=dto.getQna_num()%>">
					    <% 
					    
				    // 답글 들여쓰기
					if(dto.getQna_re_lev() > 0) {
						int w = dto.getQna_re_lev() * 10;
				    	%> 
					    <img src="./img/none.png" width="<%=w%>">
<%-- 				    	<i class='fas fa-caret-square-right' style='font-size:24px; color:skyblue' width="<%=w%>"></i> --%>
						<% 
				    }
					%>
					<%=dto.getQna_title() %></a></td>
				    <td><%=dateFormat.format(dto.getQna_reg()) %></td>
				    <td><%=dto.getQna_view() %></td>
					    </tr>    	
					   	<%
					    }
					    %>
				    
					</table>
						<%
						 String cus_id1 = (String)session.getAttribute("cus_id");
						if(cus_id1!=null) {
							%>
						<div class="col-md-10 mb-2 text-left">
							<input type="button" value="글쓰기" class="btn btn-primary btn-shadow btn-lg" onclick="location.href='./BoardWriteForm.bo'">
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
					     	 <li class="page-item"><a class="page-link" href="./ReplyList.bo?pageNum=<%=startPage-pageBlock%>">Prev</a></li>
					     	 <%	
							}
					    	%>
					    	
					    	<%
					    	for(int i=startPage;i<=endPage;i++){
								%>
								<li class="page-item"><a class="page-link" href="./ReplyList.bo?pageNum=<%=i%>"><%=i %></a></li>
								<%
							}
					    	%>
					    	
					      <%
					       if(endPage < pageCount){
							%>
					       <li class="page-item"><a class="page-link" href="./ReplyList.bo?pageNum=<%=startPage+pageBlock%>">Next</a></li>
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