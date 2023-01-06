<%@page import="com.itwillbs.customer.db.CustomerDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>customer/userIdCheck.jsp</title>

</head>
<body>
<h2>아이디 중복 체크</h2>

<%	
	request.setCharacterEncoding("UTF-8");
	String id = request.getParameter("id");

	CustomerDAO dao = new CustomerDAO();
// 	boolean result = dao.UserCheck(id);
%>
<fieldset> 
	<form action="./CustomerInsertForm.cu" method="get" name="idck">
		아이디 : <input type="text" name="id" value="<%=id %>" readonly="readonly">
	</form>
</fieldset>
<%
// 	if(result){
%>
		<span style="color:red">해당 아이디는 이미 사용중이니 다시 입력해 주세요.</span><br>
		<button onclick="wclose();">닫기</button>
		
<%-- 	<%} else { %> --%>
		<span style="color:blue">사용 가능한 아이디 입니다.</span><br>
		<button onclick="useId();">사용하기</button>
	
<%-- 	<%} %> --%>
	

<script type="text/javascript">
    function useId(){
    	window.opener.document.join.id.value = document.idck.id.value;
<%-- 		window.opener.document.join.phone.value = <%=phone %>; --%>
    	
    	window.opener.document.join.id.readOnly=true;
    	
    	window.close();
    }
    
    function wclose() {
    	opener.document.join.id.value = "";
		window.close();
	}
</script>
</body>
</html>