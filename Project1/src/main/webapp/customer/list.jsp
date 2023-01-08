<%@page import="com.itwillbs.customer.db.CustomerDTO"%>
<%@page import="java.util.List"%>
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
<title>jsp3/list.jsp</title>
</head>
<body>
<h1>회원목록</h1>
<%
// 세션값 가져오기
List<CustomerDTO> customerList=(List<CustomerDTO>)request.getAttribute("customerList");

// 디비작업 기능 => MemberDAO
// 사용 => MemberDAO 기억장소 할당(객체생성)
// dao주소를 통해서 메서드 호출
// 여러명을 저장하는 List배열변수=dao.getMemberList();

// System.out.println("전달 받은 배열 주소 : " + memberList);
// 5단계 while 결과를 출력, 배열저장(select)
%>
<table border="1">
<tr><td>아이디</td><td>비밀번호</td>
<td>이름</td><td>가입날짜</td></tr>
<%
for(int i = 0; i<customerList.size(); i++) {
//	MemberDTO dto = (MemberDTO)memberList.get(i);
//  참조형의 형변환 없이 가져옴
	CustomerDTO dto = customerList.get(i);
%>
	
	<tr><td><%=dto.getCus_id()%></td><td><%=dto.getCus_pass()%></td>
		<td><%=dto.getCus_name()%></td><td><%=dto.getCus_phone()%></td>
		<td><%=dto.getCus_email()%></td></tr>
		<%
}
%>
</table>
<a href="./CustomerMain.cu">main.jsp 이동</a>
</body>
</html>