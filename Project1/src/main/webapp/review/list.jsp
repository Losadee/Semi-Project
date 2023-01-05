<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>board/list.jsp</title>
</head>
<body>
<h1>리뷰 리스트 (헤더 부분 클릭시 열릴 페이지)</h1>
<%

// List<BoardDTO> boardList 
// 				= (List<BoardDTO>)request.getAttribute("boardList");
// int startPage 	= (Integer)request.getAttribute("startPage");
// int pageBlock 	= (Integer)request.getAttribute("pageBlock");
// int currentPage = (Integer)request.getAttribute("currentPage");
// int endPage 	= (Integer)request.getAttribute("endPage");
// int pageCount 	= (Integer)request.getAttribute("pageCount");
// int count 		= (Integer)request.getAttribute("count");
%>
<!-- 	<a href="MemberMain.me">메인페이지</a> -->
<!-- 	<a href="BoardWriteForm.bo">글쓰기</a> -->
<!-- 	<h1>글목록</h1> -->
<!-- 	전체 글의 개수 : -->
<%-- 	<%=count%> --%>
<!-- 	<table border="1"> -->
<!-- 		<tr> -->
<!-- 			<td>번호</td> -->
<!-- 			<td>글쓴이</td> -->
<!-- 			<td>제목</td> -->
<!-- 			<td>등록일</td> -->
<!-- 			<td>조회수</td> -->
<!-- 		</tr> -->
<%-- 		<% --%>
// 		for (int i = 0; i < boardList.size(); i++) {
// 			BoardDTO dto = boardList.get(i);
<%-- 		%> --%>
<!-- 		<tr> -->
<%-- 			<td><%=dto.getNum()%></td> --%>
<%-- 			<td><%=dto.getName()%></td> --%>
<!-- 			<td>제목을 눌렀을 때 글 내용으로 가는 방법 구현 -->
<!-- 				get 방식으로 파라미터 num을 들고 다니며 넘겨줌  -->
<%-- 				<a href="BoardContent.bo?num=<%=dto.getNum()%>"><%=dto.getSubject()%></a> --%>
<!-- 			</td> -->
<%-- 			<td><%=dto.getDate()%></td> --%>
<%-- 			<td><%=dto.getReadcount()%></td> --%>
<!-- 		</tr> -->
<%-- 		<% --%>
// 		}
<%-- 		%> --%>
<!-- 	</table> -->
<!-- 	<br> -->
<!-- 	<!--  페이징 처리 --> -->
<!-- 	<!-- <a href="list.jsp?pageNum=1">1</a> --> -->
<!-- 	<!-- <a href="list.jsp?pageNum=2">2</a> --> -->
<!-- 	<!-- <a href="list.jsp?pageNum=3">3</a> --> -->
<!-- 	<!-- <a href="list.jsp?pageNum=4">4</a> --> -->
<!-- 	<!-- <a href="list.jsp?pageNum=5">5</a> --> -->
<%-- 	<% --%>
// // 	// 한 화면에 보여줄 페이지 개수 설정
// // 	int pageBlock = 3;
// // 	// currentPage 	pageBlock =>  startPage
// // 	// 1  ~ 10(0~9)    10     =>  0*10+1=> 1
// // 	// 11 ~ 20(10~19)  10	  =>  1*10+1=> 11
// // 	// 21 ~ 30(20~29)  10	  =>  2*10+1=> 21
// // 	int startPage = ((currentPage - 1) / pageBlock) * pageBlock + 1;
// // 	System.out.println("startPage=" + startPage);
// // 	// startPage  pageBlock	 =>	 endRow
// // 	// 	 1 	     	 10		 =>	   10
// // 	// 	 11     	 10		 =>	   20
// // 	//	 21 	     10		 =>	   30
// // 	int endPage = startPage + pageBlock - 1;
// // 	// 글이 있는 페이지만 보이기 1~10 => 1~2
// // 	// 전체 페이지 개수 구하기
// // 	// 20개 글 / 10 글개수 나머지 0 => 2 페이지 + 나머지 없으면 0
// // 	// 15개 글 / 10 글개수 나머지 5 => 1 페이지 + 나머지 있으면 1
// // 	int pageCount = count / pageSize + ((count % pageSize != 0) ? 1 : 0);
// // 	System.out.println("pageCount=" + pageCount);
// // 	// endPage 수정
// // 	if(endPage > pageCount) {
// // 		endPage = pageCount;
// // 	}
// // 	System.out.println("endPage=" + endPage);
	
// 	// 10페이지 이전
// 	if(startPage > pageBlock) {	// 10페이지 이상 되어야 나옴
<%-- 		%> --%>
<%-- 		<a href="BoardList.bo?pageNum=<%=startPage - pageBlock%>">[10페이지 이전]</a> --%>
<%-- 		<% --%>
// 	}
	
// 	// 이전 currentPage-1
// 	if(currentPage > 1) {	// 현재 페이지가 1페이지보다 크면 이전 보이기
<%-- 		%> --%>
<%-- 		<a href="BoardList.bo?pageNum=<%=currentPage - 1%>">[1페이지 이전]</a> --%>
<%-- 		<% --%>
// 	}
// 	for(int i = startPage; i <= endPage; i++) {
<%-- 		%> --%>
<%-- 		<a href="BoardList.bo?pageNum=<%=i%>"><%=i%></a> --%>
<%-- 		<% --%>
// 	}

// 	// 다음 currentPage+1
// 	if (currentPage < endPage) {	// 현재 페이지가 마지막 페이지보다 작을 때 다음 보이기
<%-- 		%> --%>
<%-- <%-- 		<a href="list.jsp?pageNum=<%=currentPage + 1%>">[1페이지 다음]</a> --%> --%>
<%-- 		<% --%>
// 	}
	
// 	// 10페이지 다음
// 	if(endPage != pageCount) {	// 10페이지 이상 되어야 나옴
<%-- 		%> --%>
<%-- 		<a href="BoardList.bo?pageNum=<%=startPage + pageBlock%>">[10페이지 다음]</a> --%>
<%-- 		<% --%>
// 	}
<%-- 	%> --%>
	

</body>
</html>