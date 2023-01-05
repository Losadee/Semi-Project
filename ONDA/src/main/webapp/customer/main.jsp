<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>customer/main.jsp</title>
</head>
<body>
<%
String id=(String)session.getAttribute("id");
// id가 null(세션값이 없으면) loginForm.jsp 이동
if(id==null) {
	response.sendRedirect("./CustomerLoginForm.cu");
}
%>
<h1>메인 페이지</h1>
<%-- <%=session.getAttribute("id") %>님이 로그인 하셨습니다.<br> --%>
<%=id %>님이 로그인 하셨습니다.<br>


</body>
</html>