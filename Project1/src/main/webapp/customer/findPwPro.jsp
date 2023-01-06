<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>member/findPwPro.jsp</title>
</head>
<body>
<%
String pass = (String)request.getAttribute("pass");
%>
<h1>비밀번호 찾기</h1>
<form action="./MemberLoginForm.me" method=post>
<%
if(pass != null) {
%>
<h4>회원님의 비밀번호는 </h4>
<%=pass %>
<h4>입니다. </h4>
<input type="submit" value="로그인하기">
<%	
} else {
%>
<h4>등록된 정보가 없습니다.</h4>
<input type="button" value="다시 찾기" onclick="history.back()">
<%
}
%>
</form>
</body>
</html>