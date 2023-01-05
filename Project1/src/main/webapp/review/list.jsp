<%@page import="java.text.SimpleDateFormat"%>
<%@page import="com.itwillbs.review.db.ReviewDTO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>review/list.jsp</title>
</head>
<body>
<h1>리뷰 목록</h1>
<%
SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

List<ReviewDTO> reviewList 
				= (List<ReviewDTO>)request.getAttribute("reviewList");
int startPage 	= (Integer)request.getAttribute("startPage");
int pageBlock 	= (Integer)request.getAttribute("pageBlock");
int currentPage = (Integer)request.getAttribute("currentPage");
int endPage 	= (Integer)request.getAttribute("endPage");
int pageCount 	= (Integer)request.getAttribute("pageCount");
int count 		= (Integer)request.getAttribute("count");
	%>
	<a href="#">메인페이지</a>
	<a href="#">리뷰 쓰기(주문목록 페이지로 이동)</a><br>
	전체 글의 개수 :
	<%=count%>
	<table border="1">
		<tr>
			<td>글번호</td>
			<td>글쓴이</td>
			<td>제목</td>
			<td>등록일</td>
			<td>조회수</td>
		</tr>
		<%
		for (int i = 0; i < reviewList.size(); i++) {
			ReviewDTO dto = reviewList.get(i);
		%>
		<tr>
			<td><%=dto.getRv_num() %></td>
			<td><%=dto.getCus_id() %></td>
			<td><!-- 제목을 눌렀을 때 글 내용으로 가는 방법 구현 -->
				<!-- get 방식으로 파라미터 num을 들고 다니며 넘겨줌 --> 
				<a href="ReviewContent.rv?num=<%=dto.getRv_num() %>"><%=dto.getRv_title() %></a>
			</td>
			<td><%=dto.getRv_date() %></td>
			<td><%=dto.getRv_view() %></td>
		</tr>
		<%
		}
		%>
	</table>
	<br>
	<!--  페이징 처리 -->
	<!-- <a href="list.jsp?pageNum=1">1</a> -->
	<!-- <a href="list.jsp?pageNum=2">2</a> -->
	<!-- <a href="list.jsp?pageNum=3">3</a> -->
	<!-- <a href="list.jsp?pageNum=4">4</a> -->
	<!-- <a href="list.jsp?pageNum=5">5</a> -->
	<%
// 	// 한 화면에 보여줄 페이지 개수 설정
// 	int pageBlock = 3;
// 	// currentPage 	pageBlock =>  startPage
// 	// 1  ~ 10(0~9)    10     =>  0*10+1=> 1
// 	// 11 ~ 20(10~19)  10	  =>  1*10+1=> 11
// 	// 21 ~ 30(20~29)  10	  =>  2*10+1=> 21
// 	int startPage = ((currentPage - 1) / pageBlock) * pageBlock + 1;
// 	System.out.println("startPage=" + startPage);
// 	// startPage  pageBlock	 =>	 endRow
// 	// 	 1 	     	 10		 =>	   10
// 	// 	 11     	 10		 =>	   20
// 	//	 21 	     10		 =>	   30
// 	int endPage = startPage + pageBlock - 1;
// 	// 글이 있는 페이지만 보이기 1~10 => 1~2
// 	// 전체 페이지 개수 구하기
// 	// 20개 글 / 10 글개수 나머지 0 => 2 페이지 + 나머지 없으면 0
// 	// 15개 글 / 10 글개수 나머지 5 => 1 페이지 + 나머지 있으면 1
// 	int pageCount = count / pageSize + ((count % pageSize != 0) ? 1 : 0);
// 	System.out.println("pageCount=" + pageCount);
// 	// endPage 수정
// 	if(endPage > pageCount) {
// 		endPage = pageCount;
// 	}
// 	System.out.println("endPage=" + endPage);
	
	// 10페이지 이전
	if(startPage > pageBlock) {	// 10페이지 이상 되어야 나옴
		%>
		<a href="ReviewList.rv?pageNum=<%=startPage - pageBlock%>">[10페이지 이전]</a>
		<%
	}
	
	// 이전 currentPage-1
	if(currentPage > 1) {	// 현재 페이지가 1페이지보다 크면 이전 보이기
		%>
		<a href="ReviewList.rv?pageNum=<%=currentPage - 1%>">[1페이지 이전]</a>
		<%
	}
	for(int i = startPage; i <= endPage; i++) {
		%>
		<a href="ReviewList.rv?pageNum=<%=i%>"><%=i%></a>
		<%
	}

	// 다음 currentPage+1
	if (currentPage < endPage) {	// 현재 페이지가 마지막 페이지보다 작을 때 다음 보이기
		%>
<%-- 		<a href="list.jsp?pageNum=<%=currentPage + 1%>">[1페이지 다음]</a> --%>
		<%
	}
	
	// 10페이지 다음
	if(endPage != pageCount) {	// 10페이지 이상 되어야 나옴
		%>
		<a href="ReviewList.rv?pageNum=<%=startPage + pageBlock%>">[10페이지 다음]</a>
		<%
	}
	%>
	


</body>
</html>