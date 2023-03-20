<%@page import="com.itwillbs.customer.db.CustomerDTO"%>
<%@page import="com.itwillbs.customer.db.CustomerDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>member/loginPro.jsp</title>
</head>
<body>
<%
// 폼에서 입력한 id,pass => 서버 request에 저장
// request에 저장된 id,pass 파라미터 => 변수에 저장
String cus_id = request.getParameter("cus_id");
String cus_pass = request.getParameter("cus_pass");

//MemberDAO 객체 생성
CustomerDAO dao = new CustomerDAO();
// 리턴할 형 MemberDTO userCheck(String id, String pass)
// 메서드 정의
// MemberDTO dto =디비작업주소.userCheck(String id, String pass) 메서드 호출
CustomerDTO dto=dao.userCheck(cus_id,cus_pass);

//dto null이 아니면 =>"아이디 비밀번호 일치"
//    null이면     => "아이디 비밀번호 틀림"

//5단계 : 결과를 출력, 배열저장(select)
if(dto!=null){
	//데이터 있으면 => true =>"아이디 비밀번호 일치"
	out.println("아이디 비밀번호 일치");
	// 페이지 상관없이 값이 유지 => 세션값 부여(저장)
	session.setAttribute("cus_id", cus_id);
	// main.jsp 이동
	response.sendRedirect("main.jsp");
}else{
	//데이터 없으면 => false => "아이디 비밀번호 틀림"
	out.println("아이디 비밀번호 틀림");
	// "입력하신 정보 틀림", 뒤로이동
%>
	<script type="text/javascript">
		alert("입력하신 정보 틀림");
		history.back();
	</script>
	<%
}
%>
</body>
</html>