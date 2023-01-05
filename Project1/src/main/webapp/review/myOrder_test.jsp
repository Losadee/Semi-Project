<%@page import="com.itwillbs.review.db.OrdersDTO"%>
<%@page import="java.net.URLEncoder"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>myOrder_test.jsp</title>
</head>
<body>
<%
String id = (String)session.getAttribute("id");

OrdersDTO dto = new OrdersDTO();
dto.setMenu("아메리카노");
%>
<input type="text" name="menu" value="<%=dto.getMenu() %>" readonly>
<input type="button" value="리뷰쓰기" onclick="location.href='./ReviewWriteForm.rv'">

</body>
</html>