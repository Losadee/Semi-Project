<%@page import="com.itwillbs.review.db.OrdersDTO"%>
<%@page import="java.net.URLDecoder"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>review/writeForm.jsp</title>
<link href="./css/star.css" rel="stylesheet"/>
</head>
<body>
	<%
	// 세션값 가져요기
	String id = (String)session.getAttribute("id");
	System.out.println("id = " + id);
// 	if(id == null) {
// 		response.sendRedirect("./MemberLoginForm.me");
// 	}
	String menu = request.getParameter("menu");
	%>
	<h1>글쓰기</h1>
	<form action="./ReviewWritePro.rv" name="review" id="review" method="post">
		<table border="1">
			<tr>
				<td>작성자</td>
				<td><input type="text" name="id" value="<%=id %>" readonly></td>
			</tr>
			<tr>
				<td>글제목</td>
				<td><input type="text" name="subject"></td>
			</tr>
			<tr>
				<td>메뉴</td>
				<td><input type="text" name="menu" value="<%=menu %>" readonly></td>
			</tr>
			<tr>
				<td>별점</td>
				<td>	
				<fieldset>
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
				<td>글내용</td>
				<td><textarea class="col-auto form-control" name="content" id="reviewContents"
				  placeholder="메뉴에 대한 리뷰를 남겨주세요!"></textarea></td>
			</tr>
			<tr>
				<td><input type="submit" value="글쓰기"></td>
				<td><input type="button" value="리뷰 목록" onclick="location.href='./ReviewList.rv'"></td>
			</tr>
		</table>

	<div>
		
	</div>
		
	</form>
</body>
</html>