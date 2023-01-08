<%@page import="com.itwillbs.customer.db.CustomerDTO"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>member/info.jsp</title>
<link href="./css/menu.css" rel="stylesheet" type="text/css">
</head>
<body>
<jsp:include page="../inc/headerMenu.jsp"></jsp:include>
<jsp:include page="../inc/mypageMenu.jsp"></jsp:include>
<h1>나의 정보 조회</h1>
<%
CustomerDTO dto = (CustomerDTO)request.getAttribute("dto");
%>
	아이디 : <%=dto.getCus_id() %><br>
	비밀번호 : <%=dto.getCus_pass() %><br>
	이름 : <%=dto.getCus_name() %><br>
	휴대폰 : <%=dto.getCus_phone() %><br>
	이메일 : <%=dto.getCus_email() %><br>

<a href="./CustomerMain.cu">main.jsp이동</a>

</body>
</html>