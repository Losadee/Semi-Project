<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>

<body>
<%
int star = Integer.parseInt( request.getParameter("star"));
%>
<input type="text" value=<%=star %>>
</body>
</html>