<%@page import="com.itwillbs.review.db.OrdersDAO"%>
<%@page import="com.itwillbs.review.db.ReviewDAO"%>
<%@page import="com.itwillbs.review.db.MenuDTO"%>
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
request.setCharacterEncoding("UTF-8");
String id = (String)session.getAttribute("id");
System.out.println("id = " + id);

OrdersDAO Odao = new OrdersDAO();
String menu = Odao.findMenu(id);
System.out.println("menu = " + menu);

%>

<input type="text" name="menu" value="<%=menu %>" readonly>
<input type="button" value="리뷰쓰기" onclick="location.href='./ReviewWriteForm.rv?menu=<%=menu%>'">

</body>
</html>