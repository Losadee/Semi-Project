<%@page import="java.math.BigInteger"%>
<%@page import="java.net.URLEncoder"%>
<%@page import="java.security.SecureRandom"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>member/loginForm.jsp</title>
<link href="./css/menu.css" rel="stylesheet" type="text/css">
<script src="https://developers.kakao.com/sdk/js/kakao.js"></script>
<script type="text/javascript">
Kakao.init('46649a5dcd99d3819c79c2f83892ddb9');

function kakaoLogin() {
	Kakao.Auth.login({
		scope:'account_email',
        success: function (response) {
            Kakao.API.request({
                url: '/v2/user/me',
                success: (res) => {
                    kakaologin.id.value=res.id;
                    kakaologin.pass.value=res.kakao_account.email;
					kakaologin.submit()
                },
				
                fail: function (error) {
                    console.log(error);
                },
            })
        },
        fail: function (error) {
            console.log(error);
        },
    })
}

function log() {
	let login = document.login;
	// 아이디 (필수)
	if(login.id.value == ""){
		alert("ID를 입력해 주세요.");
		login.id.focus();
		return false;
	}
	
	// 비밀번호
	if(login.pass.value == ""){
		alert("비밀번호를 입력해 주세요.");
		login.pass.focus();
		return false;
	}
}
</script>
</head>
<body>

<jsp:include page="../inc/headerMenu.jsp"></jsp:include>
<h1>로그인</h1>
<form action="./CustomerLoginPro.cu" method="post" name="login" onsubmit="return log()">
		아이디 : <input type="text" name="id" placeholder="아이디"><br>
		비밀번호: <input type="text" name="pass" placeholder="비밀번호"><br>
		<input type="checkbox" name="keeplog" value="유지" id="keep" > 로그인 유지
		<a href="./CustomerFinfId.cu">아이디</a> · <a href="./CustomerFindPw.cu">비밀번호 찾기</a><br>
		<input type="submit" value="로그인">
</form><br>

<form action="./CustomerLoginPro.cu" name="kakaologin" method="post">
     <input type="hidden" name="id">
     <input type="hidden" name="pass">
     <a href="javascript:kakaoLogin();"><img src="https://developers.kakao.com/tool/resource/static/img/button/login/full/ko/kakao_login_medium_narrow.png"></a>
</form>

</body>
</html>