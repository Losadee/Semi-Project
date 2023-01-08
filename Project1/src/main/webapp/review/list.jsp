<%@page import="java.util.Map"%>
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

List<Map<String, Object>> reviewList 
				= (List<Map<String, Object>>)request.getAttribute("reviewList");
int startPage 	= (Integer)request.getAttribute("startPage");
int pageBlock 	= (Integer)request.getAttribute("pageBlock");
int currentPage = (Integer)request.getAttribute("currentPage");
int endPage 	= (Integer)request.getAttribute("endPage");
int pageCount 	= (Integer)request.getAttribute("pageCount");
int count 		= (Integer)request.getAttribute("count");
	%>
	<a href="./MainPage.cu">메인페이지</a>
	<a href="./MyOrderForm.rv">리뷰 쓰기(주문목록 페이지로 이동)</a><br>
	전체 글의 개수 :
	<%=count%>
	<table border="1">
		<tr>
			<td>글번호</td>
			<td>작성자</td>
			<td>글제목</td>
			<td>메뉴</td>
			<td>별점</td>
			<td>등록일</td>
			<td>조회수</td>
		</tr>
		<%
		for (int i = 0; i < reviewList.size(); i++) {
			ReviewDTO dto = (ReviewDTO)reviewList.get(i).get("dto");
			String menu = (String)reviewList.get(i).get("menu");
		%>
		<tr>
			<td><%=dto.getRv_num() %></td>
			<td><%=dto.getCus_id() %></td>
			<td><!-- 제목을 눌렀을 때 글 내용으로 가는 방법 구현 -->
				<!-- get 방식으로 파라미터 num을 들고 다니며 넘겨줌 --> 
				<a href="./ReviewContent.rv?num=<%=dto.getRv_num() %>"><%=dto.getRv_title() %></a>
			</td>
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
	<br>
	<!--  페이징 처리 -->

	<%
	
	// 10페이지 이전
	if(startPage > pageBlock) {	// 10페이지 이상 되어야 나옴
		%>
		<a href="./ReviewList.rv?pageNum=<%=startPage - pageBlock%>">[10페이지 이전]</a>
		<%
	}
	
	// 이전 currentPage-1
	if(currentPage > 1) {	// 현재 페이지가 1페이지보다 크면 이전 보이기
		%>
		<a href="./ReviewList.rv?pageNum=<%=currentPage - 1%>">[1페이지 이전]</a>
		<%
	}
	for(int i = startPage; i <= endPage; i++) {
		%>
		<a href="./ReviewList.rv?pageNum=<%=i%>"><%=i%></a>
		<%
	}

	// 다음 currentPage+1
	if (currentPage < endPage) {	// 현재 페이지가 마지막 페이지보다 작을 때 다음 보이기
		%>
		<a href="./ReviewList.rv?pageNum=<%=currentPage + 1%>">[1페이지 다음]</a>
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