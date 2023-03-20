<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Find IDPW</title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="https://cdn.tutorialjinni.com/twitter-bootstrap/4.4.1/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
    <script src="https://cdn.tutorialjinni.com/twitter-bootstrap/4.4.1/js/bootstrap.min.js"></script>
    <script src="https://cdn.tutorialjinni.com/jquery/3.4.1/jquery.min.js"></script>
    <script src="https://cdn.tutorialjinni.com/jquery-validate/1.19.1/jquery.validate.js"></script>
    <link href="https://fonts.googleapis.com/css2?family=Gowun+Dodum&display=swap" rel="stylesheet">
    <link href="./css/login.css" rel="stylesheet" type="text/css">
</head>
<body>
<%
String cus_id = (String)request.getAttribute("cus_id");
%>

<div class="container">
    <div class="row">
        <div class="col-md-5 mx-auto">
             <div id="first">
                <div class="myform form ">
                 <!-- 창닫기 -> 메인으로 이동 -->
                 <div class="close">
                     <a href="./MainPage.cu">X</a>
                 </div>
                    <div class="logo mb-3">
                        <div class="col-md-12 text-center">
                            <h2>아이디 찾기</h2>
                        </div>
                    </div>
                    <form action="./CustomerLoginForm.cu" method="post">
                        <%
						if(cus_id != null) {
						%>
						<h6>회원님의 아이디는 <%=cus_id %> 입니다.</h6><br>
						<div class="col-md-12 mb-3">
                            <button type="submit" class="btn btn-block mybtn btn-primary tx-tfm">로그인 하기</button>
                        </div>
						<%	
						} else {
						%>
						<h6>등록된 정보가 없습니다.</h6><br>
						<div class="col-md-12 mb-3">
                            <button type="submit" class="btn btn-block mybtn btn-primary tx-tfm" onclick="history.back()">다시 찾기</button>
                        </div>
						<%
						}
						%>
                	</form>
                </div>
            </div>
        </div>
    </div>
</div>   
</body>
</html>