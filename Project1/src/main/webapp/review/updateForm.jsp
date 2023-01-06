<%@page import="com.itwillbs.review.db.ReviewDAO"%>
<%@page import="com.itwillbs.review.db.ReviewDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>review/updateForm.jsp</title>
<link href="./review/review.css" rel="stylesheet"/>
</head>
<body>
	<%
	//세션값 가져오기 -> content.jsp에서 세션값이 일치해야 글수정 버튼이 보이므로 가져올 필요 X
	// String id=(String)session.getAttribute("id");

	// dto 값 가져오기
	ReviewDTO dto = (ReviewDTO) request.getAttribute("dto");
	ReviewDAO dao = new ReviewDAO();
	String menu = dao.findMenu(dto.getMenu_num());
	%>
	<script type="text/javascript" src="./script/jquery-3.6.3.js"></script>
	<script type="text/javascript">

	
	$("input:radio[name ='star']:input[value='<%=dto.getMenu_num() %>']").attr("checked", true);
	



	</script>
	<h1>글수정</h1>
	<form action="./ReviewUpdatePro.rv" method="post">
		<input type="hidden" name="num" value=<%=dto.getRv_num()%>>
		<table border="1">
			<tr>
				<td>작성자</td>
				<td><input type="text" name="name" value="<%=dto.getCus_id()%>" readonly></td>
			</tr>
			<tr>
				<td>글제목</td>
				<td><input type="text" name="subject" value="<%=dto.getRv_title()%>"></td>
			</tr>
			<tr>
				<td>메뉴</td>
				<td><input type="text" name="name" value="<%=menu %>" readonly></td>
			</tr>
			<tr>
				<td>별점</td>
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
				<td>글내용</td>
				<!-- textarea는 value="" 동작하지 않음 -->
				<td><textarea name="content" rows="10" cols="20"><%=dto.getRv_content()%></textarea></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="글수정"></td>
			</tr>
		</table>
	</form>
</body>
</html>