<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>member/loginForm.jsp</title>
<script type="text/javascript">

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
	<h1>로그인</h1>
	<form action="./MemberLoginPro.me" method="post"  name="login" onsubmit="return log()">
		아이디 : <input type="text" name="id" placeholder="아이디"><br>
		비밀번호: <input type="text" name="pass" placeholder="비밀번호"><br>
		<input type="checkbox" name="keeplog" value="유지" id="keep" > 로그인 유지 <br>
		[자물쇠 이미지] <a href="./MemberFinfId.me">아이디</a> · <a href="./MemberFindPw.me">비밀번호 찾기</a><br>
		<input type="submit" value="로그인">
	</form>
</body>
</html>