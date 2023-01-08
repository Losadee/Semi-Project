<%@page import="java.text.SimpleDateFormat"%>
<%@page import="com.itwillbs.review.db.ReviewDAO"%>
<%@page import="com.itwillbs.review.db.ReviewDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>review/content.jsp</title>
</head>
<body>
	<%
	SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
	// 가져오기
	ReviewDTO dto = (ReviewDTO)request.getAttribute("dto");
	String menu = (String)request.getAttribute("menu");
	%>
	<table border="1">
		<tr>
			<td>글번호</td>
			<td><%=dto.getRv_num()%></td>
		</tr>
		<tr>
			<td>작성자</td>
			<td><%=dto.getCus_id()%></td>
		</tr>
		<tr>
			<td>글제목</td>
			<td><%=dto.getRv_title()%></td>
		</tr>
		<tr>
			<td>메뉴</td>
			<td><%=menu%></td>
		</tr>
		<tr>
			<td>등록일</td>
			<td><%=dateFormat.format(dto.getRv_date())%></td>
		</tr>
		<tr>
			<td>별점</td>
			<td><%
			for(int i = 0; i < dto.getRv_star(); i++) {
			%>
			<img src="./img/starImg.png" alt="Star Image" width=20px height=20px>
			<%
			}
			%></td>
		</tr>
		<tr>
			<td>조회수</td>
			<td><%=dto.getRv_view()%></td>
		</tr>

		<tr>
			<td>글내용</td>
			<td><%=dto.getRv_content()%></td>
		</tr>
		<tr>
			<td colspan="2">
				<%
				// 세션값 가져오기
				String id = (String) session.getAttribute("id");
				// 글쓴이와 로그인(세션값) 일치하면 => 글수정, 글삭제 버튼 보이기
				if (dto.getCus_id().equals(id)) {
				%> <input type="button" value="글수정" onclick="location.href='./ReviewUpdateForm.rv?num=<%=dto.getRv_num()%>'">
				 <input type="button" value="글삭제" onclick="location.href='./ReviewDelete.rv?num=<%=dto.getRv_num()%>'"> <%
 }					
 %> <input type="button" value="리뷰목록" onclick="location.href='./ReviewList.rv'">
			</td>
		</tr>
	</table>



</body>
</html>