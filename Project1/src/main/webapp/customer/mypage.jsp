<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>member/main.jsp</title>
<link href="./css/menu.css" rel="stylesheet" type="text/css">
<link href="./css/mypageMenu.css" rel="stylesheet" type="text/css">
</head>
<body>
<jsp:include page="../inc/headerMenu.jsp"></jsp:include>
<jsp:include page="../inc/mypageMenu.jsp"></jsp:include>
<%
// 세션값이 null이면 로그인페이지로 이동
String id=(String)session.getAttribute("id");
if(id==null){
	response.sendRedirect("./CustomerLoginForm.cu");
}
%>
<div class="cont_right">
<%=id %> 님 안녕하세요.
<!-- admin사용자만 보이게 설정 
 문자열 비교 => 문자열.equals(문자열)
 id null이면 equals 사용못함  --> 

<%
if(id != null) {
	if(id.equals("admin")) {
	%><a href="./CustomerList.cu">회원목록</a><br>
	<%
	}
}
%>
</div>
</body>
</html>